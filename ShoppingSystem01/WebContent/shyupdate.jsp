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
			<div id="forms" class="mt10">
		        <div class="box">
		          <div class="box_border">
		            <div class="box_top"><b padding-left="15px">表单</b></div>
		            <div class="box_center">
		              <form action="SalesManController" class="jqtransform">
		               <input type="hidden" name="method" value="updateSalesMan" class="input-text" line-height="30px" size="40">
		               <table class="form_table" padding-bottom="15px" padding-top="15px" width="100%" border="0" cellpadding="0" cellspacing="0">
		                 <tbody>
		                  <tr>
		                  <td align="right">编号：</td>
		                  <td class=""> 
		                    <input type="text" name="s_id" readonly="readonly" value="${param.s_id }" class="input-text" line-height="30px" size="40">
		                  </td>
		                </tr>
		                 <tr>
		                  <td align="right">姓名：</td>
		                  <td class=""> 
		                    <input type="text" name="s_name" value="${param.s_name }" class="input-text" line-height="30px" size="40">
		                  </td>
		                </tr>
		                
		                 <tr>
		                  <td align="right">密码：</td>
		                  <td class="">
		                    <input type="text" id="s_password" name="s_password"  value="${param.s_password }" id="s_password" class="input-text" line-height="30px" size="40">
		                  </td>
		                 </tr>
		                <tr>
		                  <td align="right">重复密码：</td>
		                  <td class="">
		                    <input type="text" id="s_repassword" value="${param.s_password }"  class="input-text" line-height="30px" size="40">
		                  </td>
		                 </tr>
		                 <tr>
		                   <td class="td_right">&nbsp;</td>
		                   <td class="">
		                     <input type="button" id="save" name="button" class="btn btn82 " value="保存"> 
		                     <input type="reset" name="button" class="btn btn82 " value="重置"> 
		                   </td>
		                 </tr>
		               </tbody>
		               </table>
		               </form>
		            </div>
		          </div>
		        </div>
		     </div>
		</div>
	</body>
	<script type="text/javascript">
		$(function(){
			$("#save").click(function(){
				var s_password = $("#s_password").val();
				var s_repassword = $("#s_repassword").val();
				if(s_password!=s_repassword){
					alert("2次密码输入不一致！");
					return;
				}
				
				$("form").submit();
			})
		})
	</script>
</html>
