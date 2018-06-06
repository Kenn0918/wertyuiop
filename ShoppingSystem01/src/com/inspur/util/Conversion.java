package com.inspur.util;
import java.lang.reflect.Field;  
import java.sql.Date;  
import java.sql.Timestamp;  
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Arrays;  
  
import javax.servlet.http.HttpServletRequest;  
  
  
/** 
 * ��request�����л�ȡ����ֵ������ֵ������ 
 *  
 * @author kenn 
 * 
 */  
public class Conversion {  
  
    public static <T> void convert(T t, HttpServletRequest request) {  
  
        // ��ȡ�����  
        Class<?> c = t.getClass();  
        try {  
            // ��ȡ��������  
            Field[] fs = c.getDeclaredFields();  
            for (Field f : fs) {  
                // ����Ϊ�ɷ���  
                f.setAccessible(true);  
                // ���������  
                String name = f.getName();  
                // ������Ե�������  
                Class<?> type = f.getType();  
                // �ж��Ƿ�Ϊ�������͵�����  
                if (type.isArray()) {  
  
                    System.out.println("s����ת��");  
                    // �������л�ȡ��������  
                    String[] str = request.getParameterValues(name);  
                    if (str != null) {  
                        // �ж����Ե�����  
                        if (type == String[].class) {  
                            // ��������ֵ  
                            f.set(t, str);  
                        } else if (type == int[].class || type == Integer[].class) {// ����  
                            // ����һ����������  
                            Integer[] args = new Integer[str.length];  
                            // ��Stringת��ΪInteger  
                            for (int i = 0; i < str.length; i++) {  
                                args[i] = Integer.valueOf(str[i]);  
                            }  
  
                            f.set(t, args);  
                        } else if (type == Float[].class || type == float[].class) {  
                            // ����һ��float����  
                            Float[] args = new Float[str.length];  
                            // ��Stringת��ΪFloat  
                            for (int i = 0; i < str.length; i++) {  
                                args[i] = Float.valueOf(str[i]);  
                            }  
  
                            f.set(t, args);  
                        } else if (type == Double[].class || type == double[].class) {  
                            // ����һ��Double����  
                            Double[] args = new Double[str.length];  
                            // ��Stringת��ΪDouble  
                            for (int i = 0; i < str.length; i++) {  
                                args[i] = Double.valueOf(str[i]);  
                            }  
  
                            f.set(t, args);  
                        }else if(type==Date[].class){//ת��Ϊjava.sql.Date ����  
                            Date[] date=new Date[str.length];  
                            for(int i=0;i<str.length;i++){  
                                try {  
                                    date[i]= new Date(new SimpleDateFormat("yyyy-MM-dd").parse(str[i]).getTime());  
                                } catch (ParseException e) {  
                                    // TODO Auto-generated catch block  
                                    e.printStackTrace();  
                                }  
                                f.set(t, date);  
                            }  
                        } else if(type==java.util.Date[].class){  
                            java.util.Date[] date=new Date[str.length];  
                            for(int i=0;i<str.length;i++){  
                                try {  
                                    date[i]= new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").parse(str[i]);  
                                } catch (ParseException e) {  
                                    // TODO Auto-generated catch block  
                                    e.printStackTrace();  
                                }  
                                f.set(t, date);  
                            }  
                        }  
                    }  
  
                } else {  
                    String str = request.getParameter(name);  
                    if (str != null && !str.equals("")) {  
                        // String����  
                        if (type == String.class) {  
                            f.set(t, str);  
                        } else if (type == int.class || type == Integer.class) {// ����  
                            f.set(t, Integer.valueOf(str));  
                        } else if (type == Float.class || type == float.class) {// float����  
                            f.setFloat(t, Float.valueOf(str));  
                        } else if (type == Double.class || type == double.class) {// double����  
                            f.setDouble(t, Double.valueOf(str));  
                        }else if(type==Date.class){//ת��Ϊjava.sql.Date ����  
                            Date date;  
                            try {  
                                date = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(str).getTime());  
                                f.set(t, date);  
                            } catch (ParseException e) {  
                                // TODO Auto-generated catch block  
                                e.printStackTrace();  
                            }  
                              
                        }else if(type==Timestamp.class){//java.sql.Timestap����ת��  
                            Timestamp time;  
                            try {  
                                time=new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime());  
                                f.set(t, time);  
                            } catch (ParseException e) {  
                                // TODO Auto-generated catch block  
                                e.printStackTrace();  
                            }  
                        }else if(type==java.util.Date.class){//java.util.Date����ת��  
                            java.util.Date date;  
                            try {  
                                date= new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").parse(str);  
                                f.set(t, date);  
                            } catch (ParseException e) {  
                                // TODO Auto-generated catch block  
                                e.printStackTrace();  
                            }  
                        }  
                    }  
                }  
  
            }  
  
        } catch (IllegalAccessException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
  
} 