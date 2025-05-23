package baitap;

import java.util.ArrayList;
import java.util.List;

public class Thu {
	private int soThu;
	List<LichHoc> dsLichHoc = new ArrayList<>();

	public Thu(int soThu) {
		this.soThu = soThu;
	}

	public void themLichHoc(LichHoc lh) {
		dsLichHoc.add(lh);
	}

	public List<LichHoc> getDsLich() {
		return dsLichHoc;
	}

	public void hienThiLichHoc() {
		for (LichHoc lichHoc : dsLichHoc) {
			System.out.println(lichHoc);
		}
	}

	public int getSoThu() {
		return soThu;
	}

	public void setSoThu(int soThu) {
		this.soThu = soThu;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Lịch học Thứ " + soThu + ":\n");
		if (dsLichHoc.isEmpty()) {
			sb.append("  (Không có lịch học)\n");
		} else {
			for (LichHoc lh : dsLichHoc) {
				sb.append("  - ").append(lh.toString()).append("\n");
			}
		}
		return sb.toString();
	}
}
