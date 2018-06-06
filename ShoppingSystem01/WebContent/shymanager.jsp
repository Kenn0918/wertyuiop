<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	   <link rel="stylesheet" href="css/main.css">
	   <script type="text/javascript" src="js/jquery.min.js"></script>
	</head>
	<body>
		<div >
			 <div id="forms" class="mt10" style="margin-bottom: 20px;">
		        <div class="box">
		          <div class="box_border">
		            <div class="box_top"><b padding-left="5px">表单</b></div>
		            <div class="box_center">
		              <form action="SalesManController" class="jqtransform">
		               <input type="hidden" name="method" value="querySalesMan" class="input-text" line-height="30px" size="40">
		               <table class="form_table pb15" padding-top="15px" padding-bottom="15px" width="100%" border="0" cellpadding="0" cellspacing="0">
		                 <tbody>
		                 <tr>
		                  <td align="right">售货员编号：</td>
		                  <td class=""> 
		                    <input type="text" name="s_id" class="input-text" line-height="30px" size="30">
		                  </td>
		                  <td align="right">售货员姓名：</td>
		                  <td><input type="text" name="s_name" class="input-text" line-height="30px" size="30"></td>
		                  <td class="">
		                     <input type="submit" name="button" class="ext_btn" value="查询"> 
		                  </td>
		                 </tr>
		               
		               </tbody></table>
		               </form>
		            </div>
		          </div>
		        </div>
		     </div>
			 <a href="shyadd.jsp" class="ext_btn">新增售货员</a>
			 <a href="ShopManagerController?method=queryNowShop" class="ext_btn">当日卖出商品列表</a>	
			 <!--查询列表--> 
			 <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table CRZ" id="CRZ0">
                <tbody><tr>
                   <th style="width: 70px;">编号</th>
                   <th style="width: 100px;">姓名</th>
                   <th style="width: 100px;">密码</th>
                   <th style="width: 100px;">操作</th>
                    </tr>
                <c:forEach items="${salesMans}" var="sm">
                	<tr class="tr" style="background-color: rgb(255, 255, 255);">
	                   <td>${sm.s_id}</td>
	                   <td>${sm.s_name}</td>
	                   <td>${sm.s_password}</td>
	                   <td align="center">
	                   <a href="SalesManController?method=deleteSalesMan&s_id=${sm.s_id}" class="ext_btn">删除</a>
	                   <a href="shyupdate.jsp?s_id=${sm.s_id}&s_name=${sm.s_name}&s_password=${sm.s_password}" class="ext_btn">修改</a>
	                   </td>
	                 </tr>
                </c:forEach>
              </tbody></table>
		</div>
	</body>
	<script>
		$(function(){
			$("#add").click(function(){
				window.location.href="shyadd.jsp";
			})
		})
	</script>
</html>
    