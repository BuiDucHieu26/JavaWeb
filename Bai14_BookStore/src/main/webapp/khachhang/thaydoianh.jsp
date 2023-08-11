<%@page import="java.sql.Date"%>
<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Thay đổi ảnh</title>
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
.red {
	color: red;
}
</style>
</head>
<body>
	<%
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	%>
	<%
	Object obj = session.getAttribute("khachHang");
	KhachHang khachHang = null;
	if (obj != null)
		khachHang = (KhachHang) obj;
	if (khachHang == null) {
	%>
	<h1>Bạn chưa đăng nhập vào hệ thống. Vui lòng quay lại trang chủ!</h1>
	<%
	} else {
	%>

	<div class="container">
		<div id="btn-back" style="margin-top: 20px; margin-left: 10px">
			<a href="index.jsp" class="btn btn-primary"
				style="text-decoration: none">Quay lại</a>
		</div>
		<%
		String baoLoi = request.getAttribute("baoLoi") + "";
		baoLoi = (baoLoi.equals("null")) ? "" : baoLoi;

		String duongDan = khachHang.getDuongDan();

		
		%>
		<div class="container">
			<div class="text-center">
				<h1>THÔNG TIN TÀI KHOẢN</h1>
			</div>

			<div class="red" id="baoLoi">
				<%=baoLoi%>
			</div>
			<form class="form" action="<%=url%>/doi-anh" method="post" enctype="multipart/form-data">	
				<input type="hidden" name="hanhDong" value="doi-anh-dai-dien">
				<div class="row">
					<div class="col-sm-6">
						<h3>Thông tin khách hàng</h3>
						<img alt="avatar" src="<%=url%>/avatar/<%=duongDan%>">
						<div class="mb-3">
							<label for="duongDanAnh" class="form-label">Đường dẫn ảnh</label> <input
								type="file" class="form-control" id="duongDanAnh" name="duongDanAnh">
						</div>
						<input class="btn btn-primary form-control" type="submit"
							value="Lưu thông tin" name="submit" id="submit" />
					</div>
				</div>
			</form>
		</div>
	</div>
	<%
	}
	%>
</body>

</html>