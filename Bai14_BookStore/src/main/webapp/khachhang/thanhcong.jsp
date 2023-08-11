<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
	<%
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	%>
	<h1>Chúc mừng bạn đã đăng ký tài khoản thành công! Hệ thống sẽ gửi thông tin xác thưc qua Email vui lòng xác thực tài khoản.</h1>
	<script>
		setTimeout(function() {
			window.location.href ="khachhang/xacthuc.jsp";
		}, 5000);
	</script>
</body>
</html>