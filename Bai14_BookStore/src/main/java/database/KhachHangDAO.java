// co sua
package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.KhachHang;

public class KhachHangDAO implements DAOInterface<KhachHang> {

	public ArrayList<KhachHang> data = new ArrayList<>();

	public KhachHangDAO() {
		ConnectDB.getInstance().connect();
	}

	@Override
	public ArrayList<KhachHang> selectAll() {
		ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = ConnectDB.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM khachhang";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String maKhacHang = rs.getString("makhachhang");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String hoVaTen = rs.getString("hovaten");
				String gioiTinh = rs.getString("gioitinh");
				String diaChi = rs.getString("diachi");
				String diaChiNhanHang = rs.getString("diachinhan");
				String diaChiMuaHang = rs.getString("diachimua");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				boolean dangKyNhanBangTin = rs.getBoolean("dangkynhantinnhan");
				String maXacThuc = rs.getString("maxacthuc");
				Date thoiGianHieuLuc = rs.getDate("thoigianhieuluc");
				boolean trangThaiXacThuc = rs.getBoolean("trangthaixacthuc");
				String duongDan = rs.getString("duongdananh");
				KhachHang kh = new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang,
						diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin, maXacThuc, thoiGianHieuLuc,
						trangThaiXacThuc,duongDan);
				ketQua.add(kh);
			}

			// Bước 5: close connect
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public boolean kiemTraTenDangNhap(String tenDN) {
		boolean result = false;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = ConnectDB.getConnection();
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM khachhang where tendangnhap = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, tenDN);
			// Bước 3: thực thi câu lệnh SQL
			ResultSet rs = st.executeQuery();
			// Bước 4:
			while (rs.next()) {
				result = true;
			}
			// Bước 5: close connect
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public KhachHang selectById(KhachHang t) {
		KhachHang ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = ConnectDB.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM khachhang WHERE makhachhang=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaKH());

			// Bước 3: thực thi câu lệnh SQL
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String maKhacHang = rs.getString("makhachhang");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String hoVaTen = rs.getString("hovaten");
				String gioiTinh = rs.getString("gioitinh");
				String diaChi = rs.getString("diachi");
				String diaChiNhanHang = rs.getString("diachinhan");
				String diaChiMuaHang = rs.getString("diachimua");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				boolean dangKyNhanBangTin = rs.getBoolean("dangkynhantinnhan");
				String maXacThuc = rs.getString("maxacthuc");
				Date thoiGianHieuLuc = rs.getDate("thoigianhieuluc");
				boolean trangThaiXacThuc = rs.getBoolean("trangthaixacthuc");
				String duongDan = rs.getString("duongdananh");
				ketQua= new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang,
						diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin, maXacThuc, thoiGianHieuLuc,
						trangThaiXacThuc,duongDan);
			}
			// Bước 5:
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public KhachHang selectByUserName(String username) {
		KhachHang ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = ConnectDB.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM khachhang WHERE tendangnhap=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, username);

			// Bước 3: thực thi câu lệnh SQL
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String maKhacHang = rs.getString("makhachhang");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String hoVaTen = rs.getString("hovaten");
				String gioiTinh = rs.getString("gioitinh");
				String diaChi = rs.getString("diachi");
				String diaChiNhanHang = rs.getString("diachinhan");
				String diaChiMuaHang = rs.getString("diachimua");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				boolean dangKyNhanBangTin = rs.getBoolean("dangkynhantinnhan");
				String maXacThuc = rs.getString("maxacthuc");
				Date thoiGianHieuLuc = rs.getDate("thoigianhieuluc");
				boolean trangThaiXacThuc = rs.getBoolean("trangthaixacthuc");
				String duongDan = rs.getString("duongdananh");
				ketQua = new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang,
						diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin, maXacThuc, thoiGianHieuLuc,
						trangThaiXacThuc,duongDan);
			}

			// Bước 5:
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public boolean selectCustomer(String username, String pwd) {
		boolean ketQua = false;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = ConnectDB.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM khachhang WHERE tendangnhap=? and matkhau = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, pwd);

			// Bước 3: thực thi câu lệnh SQL
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				ketQua = true;
			}

			// Bước 5:
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insert(KhachHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = ConnectDB.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO khachhang (makhachhang, tendangnhap, matkhau, hovaten, gioitinh, diachi, diachinhan, diachimua, ngaysinh, sodienthoai, email, dangkynhantinnhan) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaKH());
			st.setString(2, t.getNameLogin());
			st.setString(3, t.getMatKhau());
			st.setString(4, t.getHoTen());
			st.setString(5, t.getGioiTinh());
			st.setString(6, t.getDiaChi());
			st.setString(7, t.getDiaChiNhan());
			st.setString(8, t.getDiaChiMua());
			st.setDate(9, t.getNgaySinh());
			st.setString(10, t.getSDT());
			st.setString(11, t.geteMail());
			st.setBoolean(12, t.isDkNhanTinNhan());

			// Bước 3: thực thi câu lệnh SQL
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<KhachHang> arr) {
		int dem = 0;
		for (KhachHang KhachHang : arr) {
			dem += this.insert(KhachHang);
		}
		return dem;
	}

	@Override
	public int delete(KhachHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = ConnectDB.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from khachhang " + " WHERE makhachhang=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaKH());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<KhachHang> arr) {
		int dem = 0;
		for (KhachHang KhachHang : arr) {
			dem += this.delete(KhachHang);
		}
		return dem;
	}

	@Override
	public int update(KhachHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = ConnectDB.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE khachhang " + " SET " + " tendangnhap=?" + ", matkhau=?" + ", hoten=?" + ", gioitinh=?"
					+ ", diachi=?" + ", diachinhanhang=?" + ", diachimuahang=?" + ", ngaysinh=?" + ", sodienthoai=?"
					+ ", email=?" + ", dangkinhanbangtin=?" + " WHERE makhachhang=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getNameLogin());
			st.setString(2, t.getMatKhau());
			st.setString(3, t.getHoTen());
			st.setString(4, t.getGioiTinh());
			st.setString(5, t.getDiaChi());
			st.setString(6, t.getDiaChiNhan());
			st.setString(7, t.getDiaChiMua());
			st.setDate(8, t.getNgaySinh());
			st.setString(9, t.getSDT());
			st.setString(10, t.geteMail());
			st.setBoolean(11, t.isDkNhanTinNhan());
			st.setString(12, t.getMaKH());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public boolean changePass(KhachHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = ConnectDB.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE khachhang " + " SET " + "matkhau=?" + " WHERE tendangnhap=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMatKhau());
			st.setString(2, t.getNameLogin());
			// Bước 3: thực thi câu lệnh SQL
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua > 0;
	}

	public int updateInfo(KhachHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = ConnectDB.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE khachhang " + " SET " + "hovaten=?" + ", gioitinh=?" + ", diachi=?" + ", diachinhan=?"
					+ ", diachimua=?" + ", ngaysinh=?" + ", sodienthoai=?" + ", email=?" + ", dangkynhantinnhan=?"
					+ " WHERE makhachhang=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getHoTen());
			st.setString(2, t.getGioiTinh());
			st.setString(3, t.getDiaChi());
			st.setString(4, t.getDiaChiNhan());
			st.setString(5, t.getDiaChiMua());
			st.setDate(6, t.getNgaySinh());
			st.setString(7, t.getSDT());
			st.setString(8, t.geteMail());
			st.setBoolean(9, t.isDkNhanTinNhan());
			st.setString(10, t.getMaKH());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public int updateVerifyCustomer(KhachHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = ConnectDB.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE khachhang " + " SET " + "maxacthuc=?" + ", thoigianhieuluc=?" + ", trangthaixacthuc=?"
					+ " WHERE makhachhang=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaXacThuc());
			st.setDate(2, t.getThoiGianHieuLuc());
			st.setBoolean(3, t.isTrangThaiXacThuc());
			st.setString(4, t.getMaKH());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	public int updateImage(KhachHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = ConnectDB.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE khachhang " + " SET " + "duongdananh=?" 
					+ " WHERE makhachhang=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getDuongDan());
			st.setString(2, t.getMaKH());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
}