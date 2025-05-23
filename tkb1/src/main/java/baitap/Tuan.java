package baitap;

import java.util.HashMap;
import java.util.Map;

public class Tuan {
	private int soTuan;
	Map<Integer, Thu> dsThu = new HashMap<>();

	public Tuan(int soTuan) {
		this.soTuan = soTuan;
	}

	public void themLichHoc(int thu, LichHoc lh) {
		dsThu.putIfAbsent(thu, new Thu(thu));
		dsThu.get(thu).themLichHoc(lh);
	}

	public Thu getThu(int thu) {
		return dsThu.get(thu);
	}

	public Map<Integer, Thu> getDsThu() {
		return dsThu;
	}

	public int getSoTuan() {
		return soTuan;
	}

	public void setSoTuan(int soTuan) {
		this.soTuan = soTuan;
	}

	public void hienThiThoiKhoaBieu() {
		for (Map.Entry<Integer, Thu> entry : dsThu.entrySet()) {
			System.out.println("Thứ " + entry.getKey() + ":");
			entry.getValue().hienThiLichHoc();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Tuần " + soTuan + ":\n");
		if (dsThu.isEmpty()) {
			sb.append("  (Không có lịch học)\n");
		} else {
			for (Map.Entry<Integer, Thu> entry : dsThu.entrySet()) {
				sb.append("Thứ ").append(entry.getKey()).append(":\n");
				sb.append(entry.getValue().toString());
			}
		}
		return sb.toString();
	}
}
