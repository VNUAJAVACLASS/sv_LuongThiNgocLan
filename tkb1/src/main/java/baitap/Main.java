package baitap;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
	public static void main(String[] args) throws Exception {
		CTrinhChinh qltkb = new CTrinhChinh();
		Scanner sc = new Scanner(System.in);

		// Đọc file HTML
		File file = new File("tkb_LuongThiNgocLan.html");
		if (!file.exists()) {
			System.out.println("Lỗi: File tkb_LuongThiNgocLan.html không tồn tại.");
			return;
		}
		Document doc = Jsoup.parse(file, "UTF-8");
		Elements rows = doc.select("tr");
		//System.out.println("Số dòng đọc được: " + rows.size());

		int count = 0; // Đếm số lịch học được thêm
		String lastMaMH = "";
		String lastTenMH = "";
		String lastLop = "";

		for (Element row : rows) {
			Elements cells = row.select("td");
			// Bỏ qua dòng tiêu đề hoặc không đủ cột tối thiểu
			if (cells.size() < 6 || row.text().contains("Mã MH") || row.text().contains("Tên môn học")) {
				//System.out.println("Bỏ qua dòng: " + row.text());
				continue;
			}

			try {
				// Xử lý dòng chính (≥14 cột) hoặc dòng phụ (≥6 cột)
				String maMH, tenMH, lop, thuStr, tietBDStr, soTietStr, phong, gv, thoiGianHoc;
				int offset = 0;
				if (cells.size() >= 14 && !cells.get(0).text().trim().isEmpty()) {
					// Dòng chính
					maMH = cells.get(0).text().trim();
					tenMH = cells.get(1).text().trim();
					lop = cells.get(6).text().trim();
					thuStr = cells.get(8).text().trim();
					tietBDStr = cells.get(9).text().trim();
					soTietStr = cells.get(10).text().trim();
					phong = cells.get(11).text().trim();
					gv = cells.get(12).text().trim();
					thoiGianHoc = cells.get(13).text().trim();
					// Lưu thông tin cho dòng phụ
					lastMaMH = maMH;
					lastTenMH = tenMH;
					lastLop = lop;
				} else {
					// Dòng phụ: Sử dụng maMH, tenMH, lop từ dòng trước
					maMH = lastMaMH;
					tenMH = lastTenMH;
					lop = lastLop;
					offset = cells.size() >= 14 ? 8 : 0; // Dòng phụ bắt đầu từ cột 8 hoặc 0
					thuStr = cells.get(offset).text().trim();
					tietBDStr = cells.get(offset + 1).text().trim();
					soTietStr = cells.get(offset + 2).text().trim();
					phong = cells.get(offset + 3).text().trim();
					gv = cells.get(offset + 4).text().trim();
					thoiGianHoc = cells.get(offset + 5).text().trim();
				}

				// Kiểm tra dữ liệu trống
				if (maMH.isEmpty() || tenMH.isEmpty() || lop.isEmpty() || thuStr.isEmpty() || tietBDStr.isEmpty()
						|| soTietStr.isEmpty() || phong.isEmpty() || gv.isEmpty() || thoiGianHoc.isEmpty()) {
					//System.out.println("Lỗi: Dữ liệu trống trong dòng: " + row.text());
					continue;
				}

				// Chuyển đổi dữ liệu số
				int thu = Integer.parseInt(thuStr);
				int tietBD = Integer.parseInt(tietBDStr);
				int soTiet = Integer.parseInt(soTietStr);

				// Kiểm tra giá trị hợp lệ
				if (thu < 2 || thu > 7) {
					System.out.println("Lỗi: Thứ không hợp lệ (" + thu + ") trong dòng: " + row.text());
					continue;
				}
				if (tietBD < 1 || soTiet < 1) {
					System.out.println("Lỗi: Tiết bắt đầu hoặc số tiết không hợp lệ trong dòng: " + row.text());
					continue;
				}
			
				System.out.println("Đọc dòng: " + maMH + ", " + tenMH + ", thứ " + thu + ", thời gian: " + thoiGianHoc);
				LichHoc lichHoc = new LichHoc(maMH, tenMH, lop, thu, tietBD, soTiet, phong, gv, thoiGianHoc);
				qltkb.themLichHoc(lichHoc);
				count++;
			} catch (NumberFormatException e) {
				System.out.println("Lỗi: Dữ liệu số không hợp lệ trong dòng: " + row.text());
			} catch (Exception e) {
				System.out.println("Lỗi khác trong dòng: " + row.text() + " - " + e.getMessage());
			}
		}
		System.out.println("Đã thêm " + count + " lịch học."); 

		// Menu
		while (true) {
			System.out.println("\n=== MENU ===");
			System.out.println("1. Xem TKB hôm nay");
			System.out.println("2. Xem TKB theo tuần");
			System.out.println("3. Xem TKB theo tuần + thứ");
			System.out.println("4. Xem TKB theo ngày cụ thể");
			System.out.println("5. Hiển thị toàn bộ TKB");
			System.out.println("0. Thoát");
			System.out.print(">> Chọn: ");
			try {
				int chon = Integer.parseInt(sc.nextLine());
				switch (chon) {
				case 1: {
					LocalDate homNay = LocalDate.now();
					System.out.println("Ngày hôm nay: " + homNay + ", tuần: " + qltkb.getCurrentWeek(homNay));
					List<LichHoc> homNayList = qltkb.timLichHocTheoNgay(homNay);
					System.out.println("Lịch học hôm nay (" + homNay + "):");
					if (homNayList.isEmpty()) {
						System.out.println("Không có lịch học.");
					} else {
						homNayList.forEach(System.out::println);
					}
					break;
				}
				case 2: {
					System.out.print("Nhập tuần: ");
					int t = Integer.parseInt(sc.nextLine());
					if (t < 1) {
						System.out.println("Tuần phải từ 1 trở lên.");
						break;
					}
					Tuan tuan = qltkb.timLichHocTheoTuan(t);
					if (tuan == null) {
						System.out.println("Không có lịch học cho tuần này.");
					} else {
						System.out.println(tuan);
					}
					break;
				}
				case 3: {
					System.out.print("Nhập tuần: ");
					int t = Integer.parseInt(sc.nextLine());
					System.out.print("Nhập thứ (2-7): ");
					int thu = Integer.parseInt(sc.nextLine());
					if (t < 1 || thu < 2 || thu > 7) {
						System.out.println("Tuần hoặc thứ không hợp lệ.");
						break;
					}
					Tuan tuan = qltkb.timLichHocTheoTuan(t);
					if (tuan == null || tuan.getThu(thu) == null) {
						System.out.println("Không có lịch học.");
					} else {
						List<LichHoc> ds = tuan.getThu(thu).getDsLich();
						ds.forEach(System.out::println);
					}
					break;
				}
				case 4: {
					System.out.print("Nhập ngày (dd/mm/yyyy): ");
					String[] parts = sc.nextLine().split("/");
					if (parts.length != 3) {
						System.out.println("Định dạng ngày không hợp lệ.");
						break;
					}
					try {
						int ngay = Integer.parseInt(parts[0]);
						int thang = Integer.parseInt(parts[1]);
						int nam = Integer.parseInt(parts[2]);
						LocalDate date = LocalDate.of(nam, thang, ngay);
						System.out.println("Ngày nhập: " + date + ", tuần: " + qltkb.getCurrentWeek(date));
						List<LichHoc> list = qltkb.timLichHocTheoNgay(date);
						if (list.isEmpty()) {
							System.out.println("Không có lịch học.");
						} else {
							list.forEach(System.out::println);
						}
					} catch (Exception e) {
						System.out.println("Lỗi: Ngày không hợp lệ.");
					}
					break;
				}
				case 5: {
					qltkb.hienThiThoiKhoaBieu();
					break;
				}
				case 0: {
					System.out.println("Thoát!");
					return;
				}
				default:
					System.out.println("Lựa chọn không hợp lệ!");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Lỗi: Vui lòng nhập số hợp lệ.");
			}
		}
	}
}
