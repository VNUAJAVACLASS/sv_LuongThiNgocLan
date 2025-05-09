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

	public LichHoc(String maMH, String tenMH, String lop, int thu, int tietBD, int soTiet, String phong, String gv) {
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.lop = lop;
		this.thu = thu;
		this.tietBD = tietBD;
		this.soTiet = soTiet;
		this.phong = phong;
		this.gv = gv;
	}

	@Override
	public String toString() {
		return maMH + " Tên: " + tenMH + " lớp " + lop + " vào " + thu + " tại " + phong + " (Tiết " + tietBD + " - "
				+ (tietBD + soTiet - 1) + ")" + " của " + gv ;
	}
}