<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" href="css/css.css">
<script type="text/javascript" src="js/jquery.min.js"></script>

</head>
<body>
	<div>
		<div class="head"></div>
		<div>

			<tr>
				<td><a href="ShopManagerController?method=queryShop">商品维护</a></td>
				<td><a href="shouyi.jsp">前台收银</a></td>
				<td><a href="SalesManController?method=querySalesMan">商品管理</a></td>
			</tr>

		</div>
		<div class="">
			<iframe  name="frame" src="shouyi.jsp" width="100%" height="500px"> </iframe>

		</div>
	</div>
</body>
</html>
