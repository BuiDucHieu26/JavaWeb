package database;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.catalina.realm.DataSourceRealm;

import model.TacGia;

public class TacGiaDAO implements DAOInterface<TacGia> {
	private ArrayList<TacGia> data = new ArrayList<>();

	@Override
	public ArrayList<TacGia> selectAll() {
		Connection connection = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("select * from TacGia");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				TacGia author = new TacGia(rs.getString("matacgia"),rs.getString("hovaten"),Date.valueOf(rs.getString("ngaysinh")),rs.getString("tieusu"));
				data.add(author);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(stmt);
		}
		return this.data;
	}

	@Override
	public TacGia selectById(TacGia t) {
		TacGia tacGia = null;
		Connection connection = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("Select * from TacGia where matacgia = ? ");
			stmt.setString(1,t.getMaTG());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String maTacGia = rs.getString("matacgia");
				String hoTen = rs.getString("hovaten");
				Date ngaySinh = rs.getDate("ngaysinh");
				String tieuSu = rs.getString("tieusu");
				tacGia = new TacGia(maTacGia, hoTen, ngaySinh, tieuSu);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(stmt);
		}
		return tacGia;
	}

	@Override
	public int insert(TacGia t) {
		if (this.selectById(t) == null) {
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			try {
				stmt = con.prepareStatement("insert into TacGia(matacgia, hovaten, ngaysinh, tieusu)values(?,?,?,?)");
				stmt.setString(1,t.getMaTG());
				stmt.setString(2,t.getTenTG());
				stmt.setDate(3,t.getNgaySinh());
				stmt.setString(4, t.getTieuSu());				
				return  stmt.executeUpdate();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			finally {
				close(stmt);
			}
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<TacGia> arr) {
		int dem = 0;
		for (TacGia tacGia : arr) {
			dem += this.insert(tacGia);
		}
		return dem;
	}

	@Override
	public int delete(TacGia t) {
		if (this.selectById(t) != null) {
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			try {
				stmt = con.prepareStatement("delete from TacGia where matacgia = ?");
				stmt.setString(1,t.getMaTG());				
				return  stmt.executeUpdate();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			finally {
				close(stmt);
			}
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<TacGia> arr) {
		int dem = 0;
		for (TacGia tacGia : arr) {
			dem += this.delete(tacGia);
		}
		return dem;
	}

	@Override
	public int update(TacGia t) {
		if (this.selectById(t) != null) {
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			try {
				stmt = con.prepareStatement("update TacGia set hovaten = ?, ngaysinh = ?, tieusu = ? where matacgia = ?");
				stmt.setString(1,t.getTenTG());
				stmt.setDate(2,t.getNgaySinh());
				stmt.setString(3, t.getTieuSu());				
				stmt.setString(4,t.getMaTG());
				return  stmt.executeUpdate();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			finally {
				close(stmt);
			}
		}
		return 0;
	}
	private void close(PreparedStatement st) {
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		ConnectDB.getInstance().connect();
		TacGiaDAO dao = new TacGiaDAO();
		ArrayList<TacGia> ls = dao.selectAll();
		for (TacGia tacGia : ls) {
			System.out.println(tacGia.toString());
		}
	}
}