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
			
			 <!--查询列表--> 
			 <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table CRZ" id="CRZ0">
                <tbody><tr>
                   <th style="width: 70px;">编号</th>
                   <th style="width: 100px;">商品名称</th>
                   <th style="width: 100px;">商品单价</th>
                   <th style="width: 100px;">销售数量</th>
                    </tr>
                <c:forEach items="${goods}" var="shop">
                	<tr class="tr" style="background-color: rgb(255, 255, 255);">
	                   <td>${shop.g_id}</td>
	                   <td>${shop.g_name}</td>
	                   <td>${shop.g_price}</td>
	                   <td>${shop.sale_qunitity}</td>
	                 
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
    