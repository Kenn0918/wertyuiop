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
			<!--查询表单--> 
			<div id="forms" margin-top="10px">
		        <div class="box">
		          <div class="box_border">
		            <div class="box_top"><b padding-left="15px">表单</b></div>
		            <div class="box_center">
		              <form action="ShopManagerController" class="jqtransform">
		               <input type="hidden" name="method" value="queryShop" class="input-text" line-height="30px" size="40">
		               <table class="form_table" padding-top="15px"  padding-bottom="15px" width="100%" border="0" cellpadding="0" cellspacing="0">
		                 <tbody>
		                 <tr>
		                 <td align="right">排序：</td>
		                  <td class="">
		                    <span float="left">
		                      <div class="select_border"> 
		                        <div class="select_containers "> 
		                        <select name="order" class="select"> 
		                        	<option value="g_quantity">数量升序</option> 
		                        	<option value="g_price">价格升序</option> 
		                        </select> 
		                        </div> 
		                      </div> 
		                    </span>
		                  </td>
		                  <td align="right">商品名称：</td>
		                  <td class=""> 
		                    <input type="text" name="g_name" class="input-text" line-height="30px" size="30">
		                  </td>
		                  <td align="right">商品编号：</td><td><input type="text" name="g_id" class="input-text" line-height="30px" size="30"></td>
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
			 <input id="add" type="button" name="button" class="ext_btn" value="新增">
			 <!--查询列表--> 
			 <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table CRZ" id="CRZ0">
                <tbody><tr>
                   <th style="width: 70px;">商品编号</th>
                   <th style="width: 100px;">商品名称</th>
                   <th style="width: 100px;">商品价格</th>
                   <th style="width: 100px;">商品数量</th>
                   <th style="width: 100px;">商品备注</th>
                   <th style="width: 100px;">操作</th>
                    </tr>
                <c:forEach items="${goods }" var="good">
                	<tr class="tr" style="background-color: rgb(255, 255, 255);">
	                   <td>${good.g_id}</td>
	                   <td>${good.g_name}</td>
	                   <td>${good.g_price}</td>
	                   <td>${good.g_quantity}</td>
	                   <td>${good.g_remark}</td>
	                   <td align="center">
	                   <a href="ShopManagerController?method=deleteShop&g_id=${good.g_id}" class="ext_btn">删除</a>
	                   <a href="spupdate.jsp?g_id=${good.g_id}&g_name=${good.g_name}
	                   &g_price=${good.g_price}&g_quantity=${good.g_quantity}&g_remark=${good.g_remark}" class="ext_btn">修改</a>
	                   </td>
	                 </tr>
                </c:forEach>
                
                 
              
              </tbody></table>
		</div>
	</body>
	<script>
		$(function(){
			$("#add").click(function(){
				window.location.href="spadd.jsp";
			})
		})
	</script>
</html>
