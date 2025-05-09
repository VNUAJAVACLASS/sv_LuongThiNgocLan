package baitap;

import java.util.ArrayList;
import java.util.List;

public class Thu {
	int soThu;
	List<LichHoc> dsLich = new ArrayList<>();

	public Thu(int soThu) {
		this.soThu = soThu;
	}

	public void them(LichHoc lh) {
		dsLich.add(lh);
	}

	public List<LichHoc> getDsLich() {
		return dsLich;
	}
}
