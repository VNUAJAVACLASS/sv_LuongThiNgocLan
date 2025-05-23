package baitap;

public class LichHoc {
	private String maMH;
	private String tenMH;
	private String lop;
	private int thu;
	private int tietBD;
	private int soTiet;
	private String phong;
	private String gv;
	private String thoiGianHoc;

	public LichHoc(String maMH, String tenMH, String lop, int thu, int tietBD, int soTiet, String phong, String gv,
			String thoiGianHoc) {
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.lop = lop;
		this.thu = thu;
		this.tietBD = tietBD;
		this.soTiet = soTiet;
		this.phong = phong;
		this.gv = gv;
		this.thoiGianHoc = thoiGianHoc;
	}

	public String getMaMH() {
		return maMH;
	}

	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

	public String getTenMH() {
		return tenMH;
	}

	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public int getThu() {
		return thu;
	}

	public void setThu(int thu) {
		this.thu = thu;
	}

	public int getTietBD() {
		return tietBD;
	}

	public void setTietBD(int tietBD) {
		this.tietBD = tietBD;
	}

	public int getSoTiet() {
		return soTiet;
	}

	public void setSoTiet(int soTiet) {
		this.soTiet = soTiet;
	}

	public String getPhong() {
		return phong;
	}

	public void setPhong(String phong) {
		this.phong = phong;
	}

	public String getGv() {
		return gv;
	}

	public void setGv(String gv) {
		this.gv = gv;
	}

	public String getThoiGianHoc() {
		return thoiGianHoc;
	}

	public void setThoiGianHoc(String thoiGianHoc) {
		this.thoiGianHoc = thoiGianHoc;
	}

	@Override
	public String toString() {
		return maMH + " Tên: " + tenMH + " lớp " + lop + " vào thứ " + thu + " tại " + phong + " (Tiết " + tietBD + " - "
				+ (tietBD + soTiet - 1) + ")" + " của " + gv;
	}
}