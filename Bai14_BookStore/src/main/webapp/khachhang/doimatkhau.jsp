<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isThreadSafe="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookstore</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
	integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT"
	crossorigin="anonymous"></script>
</head>
<body>
	<%
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	Object obj = session.getAttribute("khachHang");
	KhachHang khachHang = null;
	if (obj != null)
		khachHang = (KhachHang) obj;
	if (khachHang == null) {
	%>
	<h1>Bạn chưa đăng nhập vào hệ thống. Vui lòng quay lại trang chủ!</h1>
	<%
	} else {
	String baoLoi = request.getAttribute("baoLoi") + "";
	if (baoLoi.equals("null")) {
		baoLoi = "";
	}
	%>
	<div class="container">
		<h1>ĐỔI MẬT KHẨU</h1>
		<span style="color: red"> <%=baoLoi%>
		</span>
		<form action="<%=url %>/khach-hang" method="POST">
			<input type="hidden" name="hanhDong" value="doi-mat-khau">
			<div class="mb-3">
				<label for="matKhauHienTai" class="form-label">Mật khẩu hiện
					tại</label> <input type="password" class="form-control" id="matKhauHienTai"
					name="matKhauHienTai">
			</div>
			<div class="mb-3">
				<label for="matKhauMoi" class="form-label">Mật khẩu mới</label> <input
					type="password" class="form-control" id="matKhauMoi"
					name="matKhauMoi">
			</div>
			<div class="mb-3">
				<label for="matKhauMoiNhapLai" class="form-label">Xác nhận
					mật khẩu mới</label> <input type="password" class="form-control"
					id="matKhauMoiNhapLai" name="matKhauMoiNhapLai">
			</div>
			<a href="index.jsp" class="btn btn-primary"
				style="text-decoration: none;">Hủy bỏ</a>
			<button type="submit" class="btn btn-primary">Đồng ý</button>
		</form>
	</div>
	<%
	}
	%>
	<script>
		// Hàm chuyển hướng sau 5 giây
		function redirectToIndex() {
			window.location.href =
	<%=url%>
		+ "/index.jsp"
		}
		if (baoLoi === "Mật khẩu đã thay đổi thành công!") {
			setTimeout(redirectToIndex, 5000);
		}
	</script>
</body>
</html>