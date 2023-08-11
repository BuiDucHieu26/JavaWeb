<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang xác thực</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>
<style>
.form-verify {
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>
</head>
<body>
	<%
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	String maKH = session.getAttribute("maKhachHangXacThuc") + "";
	%>
	<jsp:include page="../header.jsp"></jsp:include>

	<form class="mt-5" action="<%=url%>/khach-hang" method="post"
		class="form-verify"
		style="display: flex; justify-content: center; align-items: center;">
		<div>
			<input type="hidden" name="hanhDong" value="xac-thuc"> <input
				type="hidden" name="maKhachHang" value="<%=maKH%>">
			<h3>Vui lòng nhập mã xác thực đã nhận qua email !</h3>
			<input type="text" class="form-control" id="maXacThuc"
				name="maXacThuc" required="required" style="width: 600px"> <br>
			<input class="btn btn-primary form-control mt-3" type="submit"
				value="Xác thực" name="submit" id="submit" style="width: 600px" />
		</div>
	</form>
</body>
</html>