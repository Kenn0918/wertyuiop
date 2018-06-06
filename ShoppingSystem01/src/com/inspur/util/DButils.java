package com.inspur.util;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;  
  
public class DButils<T> {  
    private static String url = "";  
    private static String user = "";  
    private static String password = "";  
  
    static {  
        InputStream inputStream = DButils.class.getResourceAsStream("/jdbc.properties");  
        Properties properties = new Properties();  
        try {  
            properties.load(inputStream);  
            url = properties.getProperty("url");  
            user = properties.getProperty("user");  
            password = properties.getProperty("password");  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                inputStream.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
  
    public static Connection getConnection() {  
        Connection connection = null;  
        try {  
            Class.forName("com.mysql.jdbc.Driver");  
            connection = DriverManager.getConnection(url, user, password);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return connection;  
    }  
  
    /** 
     * 执行sql 
     */  
    public static boolean executeSQL(String sql, Object... params) {  
        boolean flag = false;  
        Connection connection = null;  
        PreparedStatement statement = null;  
        try {  
            connection = getConnection();  
            statement = connection.prepareStatement(sql);  
            for (int i = 0, n = params.length; i < n; i++) {  
                statement.setObject(i + 1, params[i]);  
            }  
            statement.execute();  
            flag = true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (statement != null) {  
                try {  
                    statement.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (connection != null) {  
                try {  
                    connection.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        return flag;  
    }  
  
    /** 
     * 查询结果 
     * @return 返回结果集 
     */  
    public static <T> List<?> queryResult(String sql, String[] params, Class<T> c) {  
        List<Map<String, Object>> results = null;  
        Connection connection = null;  
        ResultSet resultSet = null;  
        PreparedStatement statement = null;  
        try {  
            connection = getConnection();  
            statement = connection.prepareStatement(sql);  
            for (int i = 0, n = (params != null ? params.length : 0); i < n; i++) {  
                statement.setString(i+1, params[i]);  
            }  
            resultSet = statement.executeQuery();  
            if (resultSet != null) {  
                results = new ArrayList<>();  
                String[] name = null;  
                ResultSetMetaData rsm = null;  
                while (resultSet.next()) {  
                    if (rsm == null) {  
                        rsm = resultSet.getMetaData();  
                        int count = rsm.getColumnCount();  
                        name = new String[count];  
                        for (int i = 0; i < count; i++) {  
                            name[i] = rsm.getColumnName(i + 1);                                   
                        }  
                    }  
                    Map<String, Object> map = new HashMap<>();  
                    // 开始填充值  
                    for (String keys : name) {                       
                        map.put(keys, resultSet.getString(keys));  
                    }  
                    results.add(map);  
                }  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (statement != null) {  
                try {  
                    statement.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (resultSet != null) {  
                try {  
                    resultSet.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (connection != null) {  
                try {  
                    connection.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        ResultMapper<T> handler = new DButils().new DefaultMapper();
        // 开始处理结合  
        List<T> lists = new ArrayList<>();  
        if (results != null) {  
            for (Map<String, Object> e : results) {  
                T t = (T) handler.convert(e, c);  
                lists.add(t);  
            }  
            return lists;  
        } else {  
            return null;  
        }  
    }  
  
    /** 
     * 类型转化接口  
     * @param <T> 
     */  
    public interface ResultMapper<T> {  
        @SuppressWarnings("hiding")  
        <T> T convert(Map<String, Object> resource, Class<T> c);  
    }  
  
    /** 
     * 默认的类型实现 
     * 
     */  
    public class DefaultMapper implements ResultMapper<T> {  
  
        @SuppressWarnings("hiding")  
        public <T> T getInstance(Class<T> c) throws InstantiationException, IllegalAccessException {  
            return c.newInstance();  
        }  
  
        /** 
         * 转化的核心方法 
         */  
        @SuppressWarnings("hiding")  
        @Override  
        public <T> T convert(Map<String, Object> resource, Class<T> c) {  
            T t = null;  
            try {  
                t = getInstance(c);  
                // 获取所有的成员变量  
                Field[] declaredFields = t.getClass().getDeclaredFields();  
                // 循环遍历设置值  
                for (Field f : declaredFields) {  
                    setValue(f, t, resource.get(f.getName()));  
                }  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
            return t;  
        }  
  
        /** 
         * 设置类型的值 
         *  
         * @param fieldType 
         * @param value 
         */  
        @SuppressWarnings({ "hiding", "rawtypes" })  
        private <T> void setValue(Field field, T t, Object value) {  
            try {  
            	if(value==null || value.equals("")){
            		return;
            	}
                Class fieldType = field.getType();  
                field.setAccessible(true);  
                if (fieldType.equals(int.class)) {// 如果是整形  
                    field.setInt(t, Integer.parseInt(value.toString()));  
                } else if (fieldType.equals(float.class)) {  
                    field.setFloat(t, Float.parseFloat(value.toString()));  
                } else if (fieldType.equals(boolean.class)) {  
                    field.setBoolean(t, Boolean.parseBoolean(value.toString()));  
                } else if (fieldType.equals(double.class)) {  
                    field.setDouble(t, Double.parseDouble(value.toString()));  
                } else if (fieldType.equals(byte.class)) {  
                    field.setByte(t, Byte.parseByte(value.toString()));  
                } else if (fieldType.equals(short.class)) {  
                    field.setShort(t, Short.parseShort(value.toString()));  
                } else if (fieldType.equals(long.class)) {  
                    field.setLong(t, Long.parseLong(value.toString()));  
                } else if (fieldType.equals(char.class)) {  
                    field.setChar(t, value.toString().charAt(0));  
                }else if(fieldType.equals(Date.class)){
                	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                	String date = sdf.format(value);
                	field.set(t, date);
                }else {  
                    field.set(t, value);  
                }  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
  
    }  
       
  
} 