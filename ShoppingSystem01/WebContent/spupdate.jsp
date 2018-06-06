<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<div id="forms" margin-top="10px">
		        <div class="box">
		          <div class="box_border">
		            <div class="box_top"><b padding-left="5px">表单</b></div>
		            <div class="box_center">
		              <form action="ShopManagerController" class="jqtransform">
		                <input type="hidden" name="method" value="updateShop">
		                <table class="form_table" padding-top="15px" padding-bottom="15px" width="100%" border="0" cellpadding="0" cellspacing="0">
		                 <tbody>
		                 <tr>
		                  <td align="right">商品编号：</td>
		                  <td class=""> 
		                    <input type="text" name="g_id" class="input-text " line-height="30px" readonly="readonly" size="40" value="${param.g_id }">
		                  </td>
		                  
		                </tr>
		                 <tr>
		                  <td align="right">商品名称：</td>
		                  <td class=""> 
		                    <input type="text" name="g_name" class="input-text" line-height="30px" size="40" value="${param.g_name }">
		                  </td>
		                  
		                </tr>
		                
		                 <tr>
		                  <td align="right">商品价格：</td>
		                  <td class="">
		                    <input type="text" name="g_price" class="input-text" line-height="30px" size="40" value="${param.g_price }">
		                  </td>
		                 </tr>
		                <tr>
		                  <td align="right">商品数量：</td>
		                  <td class="">
		                    <input type="text" name="g_quantity" class="input-text" line-height="30px" size="40" value="${param.g_quantity }">
		                  </td>
		                 </tr>
		                 <tr>
		                  <td align="right">商品备注：</td>
		                  <td class="">
		                    <textarea name="g_remark" cols="30" rows="10" class="textarea" >${param.g_remark }</textarea>
		                  </td>
		                 </tr>
		                 <tr>
		                   <td align="right">&nbsp;</td>
		                   <td class="">
		                     <input type="submit" name="button" class="btn btn82 " value="保存"> 
		                    <input type="reset" name="button" class="btn btn82 " value="重置"> 
		                   </td>
		                 </tr>
		               </tbody></table>
		               </form>
		            </div>
		          </div>
		        </div>
		     </div>
		</div>
	</body>
</html>
    