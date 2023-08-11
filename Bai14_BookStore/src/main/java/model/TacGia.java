package model;

import java.sql.Date;

public class TacGia {
	private String maTG;
	private String tenTG;
	private Date ngaySinh;
	private String tieuSu;
	public TacGia(String maTG, String tenTG, Date ngaySinh, String tieuSu) {
		this.maTG = maTG;
		this.tenTG = tenTG;
		this.ngaySinh = ngaySinh;
		this.tieuSu = tieuSu;
	}
	
	public TacGia() {
		
	}

	public String getMaTG() {
		return maTG;
	}

	public void setMaTG(String maTG) {
		this.maTG = maTG;
	}

	public String getTenTG() {
		return tenTG;
	}

	public void setTenTG(String tenTG) {
		this.tenTG = tenTG;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getTieuSu() {
		return tieuSu;
	}

	public void setTieuSu(String tieuSu) {
		this.tieuSu = tieuSu;
	}

	@Override
	public String toString() {
		return "TacGia [maTG=" + maTG + ", tenTG=" + tenTG + ", ngaySinh=" + ngaySinh + ", tieuSu=" + tieuSu + "]";
	}
	
	
}
