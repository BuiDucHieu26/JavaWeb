package model;

public class TheLoai {
	private String maTL;
	private String tenTL;
	
	public TheLoai(String ma, String ten) {
		this.maTL = ma;
		this.tenTL = ten;
	}
	
	public TheLoai() {
		
	}

	public String getMaTL() {
		return maTL;
	}

	public void setMaTL(String maTL) {
		this.maTL = maTL;
	}

	public String getTenTL() {
		return tenTL;
	}

	public void setTenTL(String tenTL) {
		this.tenTL = tenTL;
	}
	
	
	
}
