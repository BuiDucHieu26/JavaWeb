

go 
create table TacGia
(	matacgia nvarchar(10) primary key not null,
	hovaten nvarchar(255),
	ngaysinh date,
	tieusu nvarchar(255)
)
go
create table TheLoai
(
	matheloai nvarchar(10) primary key not null,
	tentheloai nvarchar(255)
)
go
create table SanPham
(	masanpham nvarchar(10) not null,
	tensanpham nvarchar(255),
	matacgia nvarchar(10) foreign key references TacGia(matacgia),
	namXB int,
	gianhap float,
	giagoc float,
	giaban float,
	soluongton int,
	matheloai nvarchar(10) foreign key references TheLoai(matheloai),
	ngonngu nvarchar(20),
	mota nvarchar(255),
	primary key(masanpham)
)
go
create table KhachHang
(	makhachhang nvarchar(10) primary key not null,
	tendangnhap nvarchar(50),
	matkhau nvarchar(512),
	hovaten nvarchar(50),
	gioitinh nvarchar(5),
	diachi nvarchar(512),
	diachinhan nvarchar(512),
	diachimua nvarchar(512),
	ngaysinh date,
	sodienthoai nvarchar(20),
	email nvarchar(255),
	dangkynhantinnhan tinyint
)
go
create table DonHang
(	madonhang nvarchar(10) primary key not null,
	makhachhang nvarchar(10) foreign key references KhachHang(makhachhang),
	diachimuahang nvarchar(255),
	diachinhanhang nvarchar(255) not null,
	trangthai nvarchar(255) not null,
	hinhthucthanhtoan nvarchar(255) not null,
	trangthaithanhtoan nvarchar(255),
	sotiendathanhtoan float,
	sotienconthieu float,
	ngaydathang date,
	ngaygiaohang date
)
go
CREATE TABLE ChiTietDonHang (
    machitietdonhang nVARCHAR(10),
    madonhang nVARCHAR(10),
    masanpham nVARCHAR(10),
    soluong INT,
    giagoc FLOAT,
    giamgia FLOAT,
    giaban FLOAT,
    thueVAT FLOAT,
    tongtien FLOAT,
    PRIMARY KEY (machitietdonhang),
    FOREIGN KEY (madonhang) REFERENCES DonHang(madonhang),
    FOREIGN KEY (masanpham) REFERENCES SanPham(masanpham)
);
