<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	   <link rel="stylesheet" href="css/main.css">
	   <script type="text/javascript" src="js/jquery.min.js"></script>
		<style>
			
		</style>
	</head>
	<body>
		<input id="add" type="button" name="button" class="btn btn82 btn_add" value="添加">
		<div >
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table" id="CRZ0">
                <tbody><tr>
                   <th style="width: 100px;">商品名称</th>
                   <th style="width: 100px;">商品单价</th>
                   <th style="width: 100px;">商品数量</th>
                   <th style="width: 100px;">商品价格</th>
                    </tr>
                 <tr class="tr" style="background-color: rgb(255, 255, 255);">
                   <td><input type="text"  name="g_name" onblur="getprice(this)" class="input-text" line-height="30px" size="30"></td>
                   <td></td>
                   <td><input type="text" name="g_quantity" onblur="comprice(this)" class="input-text" line-height="30px" size="30"></td>
                   <td name="tprice"></td>
                 </tr>
              
              </tbody></table>
		</div>
		<div class="box_border" style="margin-top: 40px;">
			应付金额：<font id="total">0</font> &nbsp;&nbsp;&nbsp;
			实付金额:<input type="text" id="sfje" class="input-text" line-height="30px" size="30">
			&nbsp;&nbsp;&nbsp;
			找零：<font id="jy">0</font>&nbsp;&nbsp;&nbsp;
			<a href="#" id="jz" class="ext_btn">结账</a>
		</div>
	</body>
	<script>
		$(function(){
			$("#add").click(function(){
				$("table").append("<tr class='tr' style='background-color: rgb(255, 255, 255);'>"+
						"<td><input type='text' onblur='getprice(this)' name='g_name' class='input-text lh30' size='30'></td>"+
                   "<td></td>"+
                   "<td><input type='text' name='g_quantity' onblur='comprice(this)' class='input-text lh30' size='30'></td>"+
                   "<td name='tprice'></td>"+
                 "</tr>")
				
			})
			
			
			$("#sfje").blur(function(){
				var sfje = parseFloat($(this).val());
				var yfje = parseFloat($("#total").html());
				var jy = sfje-yfje;
				$("#jy").html(jy);
			})
			
			$("#jz").click(function(){
				var g_name="";
				var g_quantity="";
				$("[name=g_name]").each(function(index,item){
					g_name+=$(item).val()+"@";
				})
				$("[name=g_quantity]").each(function(index,item){
					g_quantity+=$(item).val()+"@";
				})
				
				$.ajax({
				    url: 'ShopManagerController',
				    type: 'post',
				    dataType: 'text',
				    data: {
				        method: "checkOut",
				        g_name: g_name,
				        g_quantity:g_quantity
				    },
				    success: function (data) {
				       alert("结算成功");
				       window.location.href="shouyi.jsp"
				    } 
				});
			})
			
		})
		function getprice(t){
			var g_name = t.value;
			$.ajax({
			    url: 'ShopManagerController',
			    type: 'post',
			    dataType: 'text',
			    data: {
			        method: "getPrice",
			        g_name: g_name
			    },
			    success: function (data) {
			        $(t).parent().next().html(data);
			    } 
			});
		}
		
		function comprice(t){
			var num = parseFloat(t.value);
			var price = parseFloat($(t).parent().prev().html());
			var tprice = num*price;
			$(t).parent().next().html(tprice);
			
			//计算总价
			var total=0;
			$("[name=tprice]").each(function(index,item){
				total+=parseFloat($(item).html());
			})
			$("#total").html(total);
			
			var sfje = parseFloat($("#sfje").val());
			var yfje = parseFloat($("#total").html());
			var jy = sfje-yfje;
			$("#jy").html(jy);
		}
	</script>
</html>
    