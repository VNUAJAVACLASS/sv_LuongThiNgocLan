package baitap;

import java.util.HashMap;
import java.util.Map;

public class Tuan {
	int soTuan;
	Map<Integer, Thu> dsThu = new HashMap<>();

	public Tuan(int soTuan) {
		this.soTuan = soTuan;
	}

	public void them(int thu, LichHoc lh) {
		dsThu.putIfAbsent(thu, new Thu(thu));
		dsThu.get(thu).them(lh);
	}

	public Thu getThu(int thu) {
		return dsThu.get(thu);
	}

	public Map<Integer, Thu> getDsThu() {
		return dsThu;
	}
}
