package com.inspur.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inspur.model.Goods;
import com.inspur.util.Conversion;
import com.inspur.util.DButils;

/**
 * Servlet implementation class ShopManagerController
 */
@WebServlet("/ShopManagerController")
public class ShopManagerController extends BaseController {
	private static final long serialVersionUID = 1L;
    //��Ʒ����
	public void addShop(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Goods good = new Goods();
		Conversion.convert(good, request);
		String sql="insert into goods values(null,?,?,?,?)";
		//ִ��������Ʒ����
		DButils.executeSQL(sql, good.getG_name(),good.getG_price(),good.getG_quantity(),good.getG_remark());
		sql="select * from goods";
		List goods = DButils.queryResult(sql, null, Goods.class);
		request.getSession().setAttribute("goods", goods);
		response.sendRedirect("spmanager.jsp");
	}
	//��Ʒɾ��
	public void deleteShop(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Goods good = new Goods();
		Conversion.convert(good, request);
		String sql="delete from goods  where g_id=?";
		//ִ���޸���Ʒ����
		DButils.executeSQL(sql, good.getG_id());
		
		sql="select * from goods";
		List goods = DButils.queryResult(sql, null, Goods.class);
		request.getSession().setAttribute("goods", goods);
		response.sendRedirect("spmanager.jsp");
	}
	//��Ʒ�޸�
	public void updateShop(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Goods good = new Goods();
		Conversion.convert(good, request);
		String sql="update goods set g_name=?,g_price=?,g_quantity=?,g_remark=? where g_id=?";
		//ִ���޸���Ʒ����
		DButils.executeSQL(sql, good.getG_name(),good.getG_price(),good.getG_quantity(),good.getG_remark(),good.getG_id());
	
		sql="select * from goods";
		List goods = DButils.queryResult(sql, null, Goods.class);
		request.getSession().setAttribute("goods", goods);
		response.sendRedirect("spmanager.jsp");
	}
	//��Ʒ��ѯ
	public void queryShop(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Goods good = new Goods();
		Conversion.convert(good, request);
		String order  = request.getParameter("order");
		String sql="select * from goods where 1=1";
		if(good.getG_name()!=null){
			sql+=" and g_name like '%"+good.getG_name()+"%'";
		}
		if(good.getG_id()!=0){
			sql+=" and g_id='"+good.getG_id()+"'";
		}
		sql+=" order by "+order;
		//ִ�в�ѯ��Ʒ����
		List goods = DButils.queryResult(sql, null, Goods.class);
		request.getSession().setAttribute("goods", goods);
		response.sendRedirect("spmanager.jsp");
	}
	
	//��ѯ��Ʒ����
	public void getPrice(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Goods good = new Goods();
		Conversion.convert(good, request);
		String sql="select * from goods where g_name='"+good.getG_name()+"'";
		//ִ�в�ѯ��Ʒ����
		List goods = DButils.queryResult(sql, null, Goods.class);
		if(goods.size()!=0){
			Goods gd = (Goods)goods.get(0);
			response.getWriter().write(gd.getG_price()+"");
		}else{
			response.getWriter().write("0");
		}
	}

	//����
	public void checkOut(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String g_name = request.getParameter("g_name");
		String g_quantity = request.getParameter("g_quantity");
		String[] name = g_name.split("@");
		String[] quantity = g_quantity.split("@");
		for(int i=0;i<name.length;i++){
			String sql="insert into sold_detail_list values(null,?,?,now())";
			DButils.executeSQL(sql, name[i],quantity[i]);
			sql="update goods set g_quantity=g_quantity-"+quantity[i]+" where g_name='"+name[i]+"'";
			DButils.executeSQL(sql);
		}
		response.getWriter().write("true");
	}
	
	//��ѯ������Ʒ�б�
	public void queryNowShop(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String sql="select t2.*,t1.sale_qunitity,t1.sale_date from sold_detail_list t1,goods t2 where t1.g_name=t2.g_name";
		//ִ�в�ѯ��Ʒ����
		List goods = DButils.queryResult(sql, null, Goods.class);
		request.getSession().setAttribute("goods", goods);
		response.sendRedirect("shoplist.jsp");
	}
}
