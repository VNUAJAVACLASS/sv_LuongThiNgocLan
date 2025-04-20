package bai_toan_tin_chi;

public class User {
	private int maNguoiDung;
	private String hoTen;
	private String diaChi;
	private String matKhau;
	private String loai;
	
	public User(String hoTen, String diaChi, String matKhau, String loai) {
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.matKhau = matKhau;
		this.loai = loai;
	}
	
	public User(int maNguoiDung,String hoTen, String diaChi, String matKhau, String loai) {
		this.maNguoiDung = maNguoiDung;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.matKhau = matKhau;
		this.loai = loai;
	}

	public int getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(int maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}
	
	

}
