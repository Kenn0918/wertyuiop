<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
	   <link rel="stylesheet" href="css/main.css">
	   <link rel="stylesheet" href="css/css.css">
	   <script type="text/javascript" src="js/jquery.min.js"></script>

	</head>
	<body>
			<div class="head">
			</div>
			
			<div>
				<div id="forms" margin-top="10px">
		        <div >
		          <div border="1px solid ">
		            <div height="45px" line-height="37px" ><b padding-left="5px">登录</b></div>
		            <div align="center">
		              <form action="SalesManController" class="jqtransform" >
		               <input type="hidden" name="method" value="login" line-height="30px" size="40">
		               <table class="form_table"  width="100%" border="0" cellpadding="0" cellspacing="0">
		                 <tbody><tr>
		                  <td align="right">姓名：</td>
		                  <td > 
		                    <input type="text" name="s_name" class="input-text" line-height="30px" size="40">
		                  </td>
		                  
		                </tr>
		                
		                 <tr>
		                  <td align="right">密码：</td>
		                  <td>
		                    <input type="text" name="s_password" id="s_password" class="input-text" line-height="30px" size="40">
		                  </td>
		                 </tr>
		                
		                 <tr>
		                   <td align="right">&nbsp;</td>
		                   <td>
		                     <input type="submit" id="save" name="button" class="ext_btn " value="登录"> 
		                   	 <input type="reset" name="button" class="ext_btn "  value="重置">
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
