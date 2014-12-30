<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/jquery-1.10.2.js"></script>
<script type="text/javascript">
	$.fn.serializeObject = function()
	{
	    var o = {};
	    var a = this.serializeArray();
	    $.each(a, function() {
	        if (o[this.name] !== undefined) {
	            if (!o[this.name].push) {
	                o[this.name] = [o[this.name]];
	            }
	            o[this.name].push(this.value || '');
	        } else {
	            o[this.name] = this.value || '';
	        }
	    });
	    return o;
	};

	$(document).ready(function() {
		
		
		$("#btnSubmit").click(function() {
			var user = {};
			user.userId=$("#userId").val();
			user.userName=$("#userName").val();
			user.mobile=$("#mobile").val();
			user.address=$("#address").val();

			var company ={};
			company.companyId=$("#companyId").val();
			company.companyName=$("#companyName").val();
			company.address=$("#companyAddress").val();

			user.company = company;
			
			var userJsonStr = JSON.stringify(user);

			alert(userJsonStr);
			
			$.ajax({ 
				 	url:"<%=request.getContextPath()%>/user/saveUser.do",
			        type:'POST',
			        dataType:"json",
			        data:userJsonStr,
			        contentType:'application/json',
			        success:function(data) {
			        	alert(data.success);
			        },  
			        error:function() {
			            alert('Err...');
			        }
			});
			return false;
		 });
		
		
		
	});
</script>
<style>
body * {
	font-size: 12px;
}
</style>
</head>
<body>
<form id="formID" method="post" action="saveUser.do">
用户ID:<input type="text" id="userId" name="userId" value=""/><br />
用户名：<input type="text" id="userName" name="userName" value=""/> <br />
用户手机：<input type="text" id="mobile" name="mobile" value=""/> <br />
用户地址：<input type="text" id="address" name="address" value=""/> <br />
公司ID:<input type="text" id="companyId" name="company.companyId" value=""/> <br />
公司名：<input type="text" id="companyName" name="company.companyName" value=""/> <br />
公司地址：<input type="text" id="companyAddress" name="company.address" value=""/> <br />
<input id="btnSubmit" type="submit" value="提交"/>
</form>
</body>
</html>
