package com.inspur.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inspur.model.SalesMan;
import com.inspur.util.Conversion;
import com.inspur.util.DButils;

/**
 * Servlet implementation class ShopManagerController
 */
@WebServlet("/SalesManController")
public class SalesManController extends BaseController {
	private static final long serialVersionUID = 1L;
    //�����ۻ�Ա
	public void addSalesMan(HttpServletRequest request, HttpServletResponse response) throws Exception{
		SalesMan salesMan = new SalesMan();
		Conversion.convert(salesMan, request);
		String sql="insert into salesman values(null,?,?,'1')";
		//ִ����������
		DButils.executeSQL(sql,salesMan.getS_name(),salesMan.getS_password());
		sql="select * from salesman";
		List salesMans = DButils.queryResult(sql, null, SalesMan.class);
		request.getSession().setAttribute("salesMans", salesMans);
		response.sendRedirect("shymanager.jsp");
	}
	//ɾ���ۻ�Ա
	public void deleteSalesMan(HttpServletRequest request, HttpServletResponse response) throws Exception{
		SalesMan salesMan = new SalesMan();
		Conversion.convert(salesMan, request);
		String sql="delete from salesman where s_id='"+salesMan.getS_id()+"'";
		//ִ��ɾ������
		DButils.executeSQL(sql);
		sql="select * from salesman";
		List salesMans = DButils.queryResult(sql, null, SalesMan.class);
		request.getSession().setAttribute("salesMans", salesMans);
		response.sendRedirect("shymanager.jsp");
	}
	
	//�޸��ۻ�Ա
	public void updateSalesMan(HttpServletRequest request, HttpServletResponse response) throws Exception{
		SalesMan salesMan = new SalesMan();
		Conversion.convert(salesMan, request);
		String sql="update salesman set s_name=?,s_password=? where s_id=?";
		//ִ��ɾ������
		DButils.executeSQL(sql,salesMan.getS_name(),salesMan.getS_password(),salesMan.getS_id());
		sql="select * from salesman";
		List salesMans = DButils.queryResult(sql, null, SalesMan.class);
		request.getSession().setAttribute("salesMans", salesMans);
		response.sendRedirect("shymanager.jsp");
	}
	
	//��ѯ�ۻ�Ա
	public void querySalesMan(HttpServletRequest request, HttpServletResponse response) throws Exception{
		SalesMan salesMan = new SalesMan();
		Conversion.convert(salesMan, request);
		String sql="select * from salesman where 1=1 ";
		if(salesMan.getS_id()!=0){
			sql+=" and s_id='"+salesMan.getS_id()+"'";
		}
		if(salesMan.getS_name()!=null && !salesMan.getS_name().equals("")){
			sql+=" and s_name like '%"+salesMan.getS_name()+"%'";
		}
		List salesMans = DButils.queryResult(sql, null, SalesMan.class);
		request.getSession().setAttribute("salesMans", salesMans);
		response.sendRedirect("shymanager.jsp");
	}
	
	//��¼
	public void login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		SalesMan salesMan = new SalesMan();
		Conversion.convert(salesMan, request);
		String sql="select * from salesman where s_name='"+salesMan.getS_name()+"' and s_password='"+salesMan.getS_password()+"'";
		List salesMans = DButils.queryResult(sql, null, SalesMan.class);
		if(salesMans.size()==0){
			response.sendRedirect("login.jsp");
		}else{
			response.sendRedirect("index.jsp");
		}
	}
}
