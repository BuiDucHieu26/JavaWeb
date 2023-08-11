<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
<% String thongBao = request.getAttribute("baoLoi")+""; %>
<h1><%=thongBao %>! Vui lòng đợi giây lát để hệ thống quay lại trang đăng nhập.</h1>
	<script>
         setTimeout(function(){
            window.location.href = 'index.jsp';
         }, 5000);
      </script>
</body>
</html>