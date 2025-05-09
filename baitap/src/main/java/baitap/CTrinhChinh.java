
package baitap;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class CTrinhChinh {
	Map<Integer, Tuan> dsTuan = new HashMap<>();

	// Ngày bắt đầu học kỳ
	private static final int NAM_BD = 2025;
	private static final int THANG_BD = 1; // Tháng 1
	private static final int NGAY_BD = 13; // Ngày 13

	public void them(int tuan, int thu, LichHoc lh) {
		dsTuan.putIfAbsent(tuan, new Tuan(tuan));
		dsTuan.get(tuan).them(thu, lh);
	}

	public void xemHomNay() {
		Calendar cal = Calendar.getInstance();
		int thu = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (thu == 0)
			thu = 8; // CN -> 8
		int tuan = cal.get(Calendar.WEEK_OF_YEAR);
		xemTheoTuanThu(tuan, thu);
	}

	public void xemTheoNgay(int ngay, int thang, int nam) {
		Calendar cal = new GregorianCalendar(nam, thang - 1, ngay);
		int thu = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (thu == 0)
			thu = 8;
		int tuan = cal.get(Calendar.WEEK_OF_YEAR);
		xemTheoTuanThu(tuan, thu);
	}

	public void xemTheoTuan(int tuan) {
		if (!dsTuan.containsKey(tuan)) {
			System.out.println("Không có dữ liệu tuần " + tuan);
			return;
		}
		System.out.println("TKB tuần " + tuan);
		Tuan t = dsTuan.get(tuan);

		for (int thu = 2; thu <= 8; thu++) {
			Thu th = t.getThu(thu);
			String ngay = quyDoiNgay(tuan, thu); // Quy đổi tuần và thứ thành ngày

			// Nếu có lịch học, in ra
			if (th != null && !th.getDsLich().isEmpty()) {
				System.out.println("Ngày " + ngay + " (Thứ " + thu + "):");
				for (LichHoc lh : th.getDsLich()) {
					System.out.println("  " + lh);
				}
			} else {
				// Nếu không có lịch học, thông báo cho người dùng
				System.out.println("Ngày " + ngay + " (Thứ " + thu + "): Không có lịch học");
			}
		}
	}

	public void xemTheoTuanThu(int tuan, int thu) {
		if (!dsTuan.containsKey(tuan)) {
			System.out.println("Không có tuần " + tuan);
			return;
		}
		Thu th = dsTuan.get(tuan).getThu(thu);
		if (th == null) {
			System.out.println(" Không có lịch học vào Thứ " + thu);
			return;
		}
		for (LichHoc lh : th.getDsLich()) {
			System.out.println(lh);
		}
	}

	public String quyDoiNgay(int tuan, int thu) {
		// Tạo một đối tượng Calendar với ngày bắt đầu học kỳ
		Calendar calendar = new GregorianCalendar(NAM_BD, THANG_BD - 1, NGAY_BD); // Tháng bắt đầu từ 0

		// Tính ngày đầu tuần của tuần học kỳ (cập nhật lại dựa trên ngày bắt đầu học
		// kỳ)
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // Đặt ngày là Thứ 2 của tuần học kỳ
		calendar.add(Calendar.WEEK_OF_YEAR, tuan - 1); // Thêm số tuần

		// Tính ngày trong tuần
		calendar.add(Calendar.DAY_OF_WEEK, thu - 1); // Cộng số ngày để đến Thứ 'thu'

		// Trả về kết quả dưới dạng chuỗi (ngày/tháng/năm)
		return calendar.get(Calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/"
				+ calendar.get(Calendar.YEAR);
	}
}