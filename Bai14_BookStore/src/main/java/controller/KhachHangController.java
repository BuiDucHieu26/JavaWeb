package controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import database.KhachHangDAO;
import model.KhachHang;
import util.Email;
import util.MaHoa;
import util.MaSoNgauNhien;

/**
 * Servlet implementation class KhachHangController
 */
@WebServlet("/khach-hang")
public class KhachHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KhachHangController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String hanhDong = request.getParameter("hanhDong");
		if (hanhDong.equals("dang-nhap")) {
			dangNhap(request, response);
		} else if (hanhDong.equals("dang-xuat")) {
			dangXuat(request, response);
		} else if (hanhDong.equals("dang-ky")) {
			dangKy(request, response);
		} else if (hanhDong.equals("doi-mat-khau")) {
			doiMatKhau(request, response);
		} else if (hanhDong.equals("doi-thong-tin")) {
			doiThongTin(request, response);
		} else if (hanhDong.equals("xac-thuc")) {
			xacThuc(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void dangNhap(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("tenDangNhap");
		String passWord = request.getParameter("matKhau");
		request.setAttribute("tenDangNhap", userName);
		KhachHangDAO khachHangDAO = new KhachHangDAO();
		KhachHang khachHang = new KhachHang();
		String url = "";
		passWord = MaHoa.toSHA1(passWord);
		if(khachHangDAO.selectByUserName(userName)==null) {
			request.setAttribute("baoLoi", "Tài khoản không tồn tại");
		}
		if (khachHangDAO.selectCustomer(userName, passWord)&&khachHangDAO.selectByUserName(userName).isTrangThaiXacThuc()) {
			khachHang = khachHangDAO.selectByUserName(userName);
			System.out.println(khachHang);
			HttpSession session = request.getSession();
			session.setAttribute("khachHang", khachHang);
			url = "/index.jsp";
		}else if(!khachHangDAO.selectByUserName(userName).isTrangThaiXacThuc()) {
			request.setAttribute("baoLoi", "Tài khoản chưa được xác thực");
			url = "/khachhang/dangnhap.jsp";
		}
		else {
			request.setAttribute("baoLoi", "Tên đăng nhập hoặc mật khẩu không đúng");
			url = "/khachhang/dangnhap.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	private void dangXuat(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

	private void dangKy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		String matKhauNhapLai = request.getParameter("matKhauNhapLai");
		String hoVaTen = request.getParameter("hoVaTen");
		String gioiTinh = request.getParameter("gioiTinh");
		String ngaySinh = request.getParameter("ngaySinh");
		String diaChiKhachHang = request.getParameter("diaChiKhachHang");
		String diaChiMuaHang = request.getParameter("diaChiMuaHang");
		String diaChiNhanHang = request.getParameter("diaChiNhanHang");
		String dienThoai = request.getParameter("dienThoai");
		String email = request.getParameter("email");
		String dongYNhanMail = request.getParameter("dongYNhanMail");
		request.setAttribute("tenDangNhap", tenDangNhap);
		request.setAttribute("hoVaTen", hoVaTen);
		request.setAttribute("gioiTinh", gioiTinh);
		request.setAttribute("ngaySinh", ngaySinh);
		request.setAttribute("diaChiKhachHang", diaChiKhachHang);
		request.setAttribute("diaChiMuaHang", diaChiMuaHang);
		request.setAttribute("diaChiNhanHang", diaChiNhanHang);
		request.setAttribute("dienThoai", dienThoai);
		request.setAttribute("dongYNhanMail", dongYNhanMail);

		String url = "";
		KhachHangDAO dao = new KhachHangDAO();
		ArrayList<KhachHang> dsKhachHang = dao.selectAll();
		int count = dsKhachHang.size();
		String baoLoi = "";
		KhachHangDAO khachHangDAO = new KhachHangDAO();

		if (khachHangDAO.kiemTraTenDangNhap(tenDangNhap)) {
			baoLoi += "Tên đăng nhập đã tồn tại, vui lòng chọn tên đăng nhập khác.<br/>";
		}

		if (!matKhau.equals(matKhauNhapLai)) {
			baoLoi += "Mẫu khẩu không khớp.<br/>";
		}

		request.setAttribute("baoLoi", baoLoi);

		if (baoLoi.length() > 0) {
			url = "/khachhang/dangky.jsp";
		} else {
			count++;
			String maKhachHang = "VN" + "00" + count;
			matKhau = MaHoa.toSHA1(matKhau);
			KhachHang kh = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChiKhachHang,
					diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh), dienThoai, email, dongYNhanMail != null);
			if (khachHangDAO.insert(kh) > 0) {
				HttpSession session = request.getSession();
				session.setAttribute("maKhachHangXacThuc",kh.getMaKH());
				String soNgauNhien = MaSoNgauNhien.getSoNgauNhien();
				Date todayDate = new Date(new java.util.Date().getTime());
				Calendar c = Calendar.getInstance();
				c.setTime(todayDate);
				c.add(Calendar.DATE, 1);
				Date thoiGianHieuLuc = new Date(c.getTimeInMillis());
				boolean trangThaiXacThuc = false;
				kh.setMaXacThuc(soNgauNhien);
				kh.setThoiGianHieuLuc(thoiGianHieuLuc);
				kh.setTrangThaiXacThuc(trangThaiXacThuc);
				if (khachHangDAO.updateVerifyCustomer(kh) > 0) {
					Email.sendEmail(kh.geteMail(), "Xác thực tài khoản tại BookStore", getNoiDung(kh));
				}
			}
			url = "/khachhang/thanhcong.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	private void xacThuc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maKhachHang = request.getParameter("maKhachHang");
		String maXacThuc = request.getParameter("maXacThuc");
		System.out.println(maKhachHang);
		String url = "";
		String baoLoi = "";
		KhachHangDAO dao = new KhachHangDAO();
		KhachHang khachHang = new KhachHang();
		khachHang.setMaKH(maKhachHang);
		KhachHang kh = dao.selectById(khachHang);
		System.out.println(kh);
		Date todayDate = new Date(new java.util.Date().getTime());
		if (kh != null) {
			if (kh.getThoiGianHieuLuc().getTime() < todayDate.getTime()) {
				dao.delete(kh);
				System.out.println("Hết hiệu lực");
				baoLoi = "Ma xác thực đã hết hiệu lực vui lòng đăng ký lại";
			} else if (kh.getMaKH().equals(maKhachHang) && kh.getMaXacThuc().equals(maXacThuc)) {
				kh.setTrangThaiXacThuc(true);
				dao.updateVerifyCustomer(kh);
				baoLoi = "Xác thực thành công";
				request.getSession().invalidate();
			} else {
				baoLoi = "Xác thực thất bại";
			}
		} else {
			baoLoi = "Tài khoản khách hàng không tồn tại";
		}
		url = "/khachhang/thongbao.jsp";
		request.setAttribute("baoLoi", baoLoi);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	private void doiMatKhau(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String matKhauHienTai = request.getParameter("matKhauHienTai");
		String matKhauMoi = request.getParameter("matKhauMoi");
		String matKhauMoiNhapLai = request.getParameter("matKhauMoiNhapLai");
		String url = "/khachhang/doimatkhau.jsp";
		String baoLoi = "";
		String matKhauDatabase = MaHoa.toSHA1(matKhauHienTai);
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		System.out.println(matKhauDatabase);
		HttpSession session = request.getSession();
		KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
		System.out.println(khachHang.getMatKhau());
		System.out.println(khachHang.getNameLogin());
		if (!matKhauDatabase.equals(khachHang.getMatKhau())) {
			baoLoi = "Mật khẩu hiện tại không chính xác!";
		} else if (matKhauMoi.equals(matKhauMoiNhapLai) == false) {
			baoLoi = "Mật khẩu nhập lại không chính xác!";
		} else {
			KhachHangDAO dao = new KhachHangDAO();
			String matKhauMoiSHA1 = MaHoa.toSHA1(matKhauMoi);
			khachHang.setMatKhau(matKhauMoiSHA1);
			if (dao.changePass(khachHang)) {

				baoLoi = "Mật khẩu đã thay đổi thành công!";
			} else {
				baoLoi = "Mật khẩu thay đổi không thành công!";
			}
		}
		request.setAttribute("baoLoi", baoLoi);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);

	}

	private void doiThongTin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String hoVaTen = request.getParameter("hoVaTen");
		String gioiTinh = request.getParameter("gioiTinh");
		String ngaySinh = request.getParameter("ngaySinh");
		String diaChiKhachHang = request.getParameter("diaChiKhachHang");
		String diaChiMuaHang = request.getParameter("diaChiMuaHang");
		String diaChiNhanHang = request.getParameter("diaChiNhanHang");
		String dienThoai = request.getParameter("dienThoai");
		String email = request.getParameter("email");
		String dongYNhanMail = request.getParameter("dongYNhanMail");
		String url = "";

		String baoLoi = "";
		KhachHangDAO khachHangDAO = new KhachHangDAO();

		request.setAttribute("baoLoi", baoLoi);

		if (baoLoi.length() > 0) {
			url = "/khachhang/dangky.jsp";
		} else {
			Object obj = request.getSession().getAttribute("khachHang");
			KhachHang khachHang = null;
			if (obj != null)
				khachHang = (KhachHang) obj;
			if (khachHang != null) {
				System.out.println(khachHang.toString());
				KhachHang kh = new KhachHang(khachHang.getMaKH(), "", "", hoVaTen, gioiTinh, diaChiKhachHang,
						diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh), dienThoai, email, dongYNhanMail != null);
				khachHangDAO.updateInfo(kh);
				KhachHang kh2 = khachHangDAO.selectById(khachHang);
				url = "/khachhang/thanhcong.jsp";
				request.getSession().setAttribute("khachHang", kh2);
			}
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
	public static String getNoiDung(KhachHang kh) {
		String link = "http://localhost:8080/Bai14_BookStore/khach-hang?hanhDong=xac-thuc&maKhachHang=" + kh.getMaKH()
				+ "&maXacThuc=" + kh.getMaXacThuc();
		String noiDung = "<p>TITV.vn xin ch&agrave;o bạn <strong>" + kh.getHoTen() + "</strong>,</p>\r\n"
				+ "<p>Vui l&ograve;ng x&aacute;c thực t&agrave;i khoản của bạn bằng c&aacute;ch nhập m&atilde; <strong>"
				+ kh.getMaXacThuc() + "</strong>, hoặc click trực tiếp v&agrave;o đường link sau đ&acirc;y:</p>\r\n"
				+ "<p><a href=\"" + link + "\">" + link + "</a></p>\r\n"
				+ "<p>Đ&acirc;y l&agrave; email tự động, vui l&ograve;ng kh&ocirc;ng phản hồi email n&agrave;y.</p>\r\n"
				+ "<p>Tr&acirc;n trọng cảm ơn.</p>";
		return noiDung;
	}
	
}
