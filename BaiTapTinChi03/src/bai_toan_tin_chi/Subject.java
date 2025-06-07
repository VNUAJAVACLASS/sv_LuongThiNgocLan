package bai_toan_tin_chi;

public class Subject {
	private String maMh;
	private String tenMh;
	private int soTinChi;
	private float heSo1;
	private float heSo2;
	private float heSo3;
	private float heSo4;
	private float heSo5;
	
	public Subject(String tenMh, int soTinChi, float heSo1, float heSo2, float heSo3, float heSo4, float heSo5) {
		this.tenMh = tenMh;
		this.soTinChi = soTinChi;
		this.heSo1 = heSo1;
		this.heSo2 = heSo2;
		this.heSo3 = heSo3;
		this.heSo4 = heSo4;
		this.heSo5 = heSo5;
	}
	
	public Subject(String maMh,String tenMh, int soTinChi, float heSo1, float heSo2, float heSo3, float heSo4, float heSo5) {
		this.maMh = maMh;
		this.tenMh = tenMh;
		this.soTinChi = soTinChi;
		this.heSo1 = heSo1;
		this.heSo2 = heSo2;
		this.heSo3 = heSo3;
		this.heSo4 = heSo4;
		this.heSo5 = heSo5;
	}

	public String getMaMh() {
		return maMh;
	}

	public void setMaMh(String maMh) {
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

	public float getHeSo1() {
		return heSo1;
	}

	public void setHeSo1(float heSo1) {
		this.heSo1 = heSo1;
	}

	public float getHeSo2() {
		return heSo2;
	}

	public void setHeSo2(float heSo2) {
		this.heSo2 = heSo2;
	}

	public float getHeSo3() {
		return heSo3;
	}

	public void setHeSo3(float heSo3) {
		this.heSo3 = heSo3;
	}

	public float getHeSo4() {
		return heSo4;
	}

	public void setHeSo4(float heSo4) {
		this.heSo4 = heSo4;
	}

	public float getHeSo5() {
		return heSo5;
	}

	public void setHeSo5(float heSo5) {
		this.heSo5 = heSo5;
	}

}
