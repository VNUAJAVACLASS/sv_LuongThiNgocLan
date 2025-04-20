package bai_toan_tin_chi;

public class Subject {
	private int maMh;
	private String tenMh;
	private int soTinChi;
	private int heSo1;
	private int heSo2;
	private int heSo3;
	private int heSo4;
	private int heSo5;
	
	public Subject(String tenMh, int soTinChi, int heSo1, int heSo2, int heSo3, int heSo4, int heSo5) {
		this.tenMh = tenMh;
		this.soTinChi = soTinChi;
		this.heSo1 = heSo1;
		this.heSo2 = heSo2;
		this.heSo3 = heSo3;
		this.heSo4 = heSo4;
		this.heSo5 = heSo5;
	}
	
	public Subject(int maMh,String tenMh, int soTinChi, int heSo1, int heSo2, int heSo3, int heSo4, int heSo5) {
		this.maMh = maMh;
		this.tenMh = tenMh;
		this.soTinChi = soTinChi;
		this.heSo1 = heSo1;
		this.heSo2 = heSo2;
		this.heSo3 = heSo3;
		this.heSo4 = heSo4;
		this.heSo5 = heSo5;
	}

	public int getMaMh() {
		return maMh;
	}

	public void setMaMh(int maMh) {
		this.maMh = maMh;
	}

	public String getTenMh() {
		return tenMh;
	}

	public void setTenMh(String tenMh) {
		this.tenMh = tenMh;
	}

	public int getSoTinChi() {
		return soTinChi;
	}

	public void setSoTinChi(int soTinChi) {
		this.soTinChi = soTinChi;
	}

	public int getHeSo1() {
		return heSo1;
	}

	public void setHeSo1(int heSo1) {
		this.heSo1 = heSo1;
	}

	public int getHeSo2() {
		return heSo2;
	}

	public void setHeSo2(int heSo2) {
		this.heSo2 = heSo2;
	}

	public int getHeSo3() {
		return heSo3;
	}

	public void setHeSo3(int heSo3) {
		this.heSo3 = heSo3;
	}

	public int getHeSo4() {
		return heSo4;
	}

	public void setHeSo4(int heSo4) {
		this.heSo4 = heSo4;
	}

	public int getHeSo5() {
		return heSo5;
	}

	public void setHeSo5(int heSo5) {
		this.heSo5 = heSo5;
	}
	
	

}
