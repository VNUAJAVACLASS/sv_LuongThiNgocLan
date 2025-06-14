package bai_toan_tin_chi;

public class UserSubject {
	private String maMhNguoiDung;
	private String maNguoiDung;
	private String maMh;
	private float diem1;
	private float diem2;
	private float diem3;
	private float diem4;
	private float diem5;
	
	public UserSubject(String maNguoiDung, String maMh, float diem1, float diem2, float diem3, float diem4, float diem5) {
		this.maNguoiDung = maNguoiDung;
		this.maMh = maMh;
		this.diem1 = diem1;
		this.diem2 = diem2;
		this.diem3 = diem3;
		this.diem4 = diem4;
		this.diem5 = diem5;
	}
	
	public UserSubject(String maMhNguoiDung,String maNguoiDung,String maMh, float diem1, float diem2, float diem3, float diem4, float diem5) {
		this.maMhNguoiDung = maMhNguoiDung;
		this.maNguoiDung = maNguoiDung;
		this.maMh = maMh;
		this.diem1 = diem1;
		this.diem2 = diem2;
		this.diem3 = diem3;
		this.diem4 = diem4;
		this.diem5 = diem5;
	}

	public String getMaMhNguoiDung() {
		return maMhNguoiDung;
	}

	public void setMaMhNguoiDung(String maMhNguoiDung) {
		this.maMhNguoiDung = maMhNguoiDung;
	}

	public String getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(String maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public String getMaMh() {
		return maMh;
	}

	public void setMaMh(String maMh) {
		this.maMh = maMh;
	}

	public float getDiem1() {
		return diem1;
	}

	public void setDiem1(float diem1) {
		this.diem1 = diem1;
	}

	public float getDiem2() {
		return diem2;
	}

	public void setDiem2(float diem2) {
		this.diem2 = diem2;
	}

	public float getDiem3() {
		return diem3;
	}

	public void setDiem3(float diem3) {
		this.diem3 = diem3;
	}

	public float getDiem4() {
		return diem4;
	}

	public void setDiem4(float diem4) {
		this.diem4 = diem4;
	}

	public float getDiem5() {
		return diem5;
	}

	public void setDiem5(float diem5) {
		this.diem5 = diem5;
	}

}
