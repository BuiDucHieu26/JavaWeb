package model;

import java.sql.Date;

public class KhachHang {
	private String maKH;
	private String nameLogin;
	private String matKhau;
	private String hoTen;
	private String gioiTinh;
	private String diaChi;
	private String diaChiNhan;
	private String diaChiMua;
	private Date ngaySinh;
	private String SDT;
	private String eMail;
	private boolean dkNhanTinNhan;
	private String maXacThuc;
	private Date thoiGianHieuLuc;
	private boolean trangThaiXacThuc;
	private String duongDan;
	public KhachHang() {

	}

	public KhachHang(String maKH, String nameLogin, String matKhau, String hoTen, String gioiTinh, String diaChi,
			String diaChiNhan, String diaChiMua, Date ngaySinh, String sDT, String eMail, boolean dkNhanTinNhan) {
		super();
		this.maKH = maKH;
		this.nameLogin = nameLogin;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.diaChiNhan = diaChiNhan;
		this.diaChiMua = diaChiMua;
		this.ngaySinh = ngaySinh;
		SDT = sDT;
		this.eMail = eMail;
		this.dkNhanTinNhan = dkNhanTinNhan;
	}
	
	public KhachHang(String maKH, String nameLogin, String matKhau, String hoTen, String gioiTinh, String diaChi,
			String diaChiNhan, String diaChiMua, Date ngaySinh, String sDT, String eMail, boolean dkNhanTinNhan,
			String maXacThuc, Date thoiGianHieuLuc, boolean trangThaiXacThuc) {
		super();
		this.maKH = maKH;
		this.nameLogin = nameLogin;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.diaChiNhan = diaChiNhan;
		this.diaChiMua = diaChiMua;
		this.ngaySinh = ngaySinh;
		SDT = sDT;
		this.eMail = eMail;
		this.dkNhanTinNhan = dkNhanTinNhan;
		this.maXacThuc = maXacThuc;
		this.thoiGianHieuLuc = thoiGianHieuLuc;
		this.trangThaiXacThuc = trangThaiXacThuc;
	}
	
	public KhachHang(String maKH, String nameLogin, String matKhau, String hoTen, String gioiTinh, String diaChi,
			String diaChiNhan, String diaChiMua, Date ngaySinh, String sDT, String eMail, boolean dkNhanTinNhan,
			String maXacThuc, Date thoiGianHieuLuc, boolean trangThaiXacThuc, String duongDan) {
		super();
		this.maKH = maKH;
		this.nameLogin = nameLogin;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.diaChiNhan = diaChiNhan;
		this.diaChiMua = diaChiMua;
		this.ngaySinh = ngaySinh;
		SDT = sDT;
		this.eMail = eMail;
		this.dkNhanTinNhan = dkNhanTinNhan;
		this.maXacThuc = maXacThuc;
		this.thoiGianHieuLuc = thoiGianHieuLuc;
		this.trangThaiXacThuc = trangThaiXacThuc;
		this.duongDan = duongDan;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getNameLogin() {
		return nameLogin;
	}

	public void setNameLogin(String nameLogin) {
		this.nameLogin = nameLogin;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDiaChiNhan() {
		return diaChiNhan;
	}

	public void setDiaChiNhan(String diaChiNhan) {
		this.diaChiNhan = diaChiNhan;
	}

	public String getDiaChiMua() {
		return diaChiMua;
	}

	public void setDiaChiMua(String diaChiMua) {
		this.diaChiMua = diaChiMua;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public boolean isDkNhanTinNhan() {
		return dkNhanTinNhan;
	}

	public void setDkNhanTinNhan(boolean dkNhanTinNhan) {
		this.dkNhanTinNhan = dkNhanTinNhan;
	}
	
	public String getMaXacThuc() {
		return maXacThuc;
	}

	public void setMaXacThuc(String maXacThuc) {
		this.maXacThuc = maXacThuc;
	}

	public Date getThoiGianHieuLuc() {
		return thoiGianHieuLuc;
	}

	public void setThoiGianHieuLuc(Date thoiGianHieuLuc) {
		this.thoiGianHieuLuc = thoiGianHieuLuc;
	}

	public boolean isTrangThaiXacThuc() {
		return trangThaiXacThuc;
	}

	public void setTrangThaiXacThuc(boolean trangThaiXacThuc) {
		this.trangThaiXacThuc = trangThaiXacThuc;
	}
	
	public String getDuongDan() {
		return duongDan;
	}

	public void setDuongDan(String duongDan) {
		this.duongDan = duongDan;
	}

	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", nameLogin=" + nameLogin + ", matKhau=" + matKhau + ", hoTen=" + hoTen
				+ ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", diaChiNhan=" + diaChiNhan + ", diaChiMua="
				+ diaChiMua + ", ngaySinh=" + ngaySinh + ", SDT=" + SDT + ", eMail=" + eMail + ", dkNhanTinNhan="
				+ dkNhanTinNhan + "]";
	}
	
}
