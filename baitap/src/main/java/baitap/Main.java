package baitap;

import java.io.File;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
	public static void main(String[] args) throws Exception {
		CTrinhChinh qltkb = new CTrinhChinh();
		Document doc = Jsoup.parse(new File("tkb_LuongThiNgocLan.html"), "UTF-8");

		Elements rows = doc.select("tbody tr");
		String ma = "", ten = "", lop = "";
		for (Element row : rows) {
			Elements tds = row.select("td");
			if (tds.size() >= 14) {
				if (!tds.get(0).text().isBlank())
					ma = tds.get(0).text();
				if (!tds.get(1).text().isBlank())
					ten = tds.get(1).text();
				if (!tds.get(6).text().isBlank())
					lop = tds.get(6).text();

				int thu = Integer.parseInt(tds.get(8).text());
				int tietBD = Integer.parseInt(tds.get(9).text());
				int soTiet = Integer.parseInt(tds.get(10).text());
				String phong = tds.get(11).text();
				String gv = tds.get(12).text();
				String tgchuoi = tds.get(13).text();

				LichHoc lh = new LichHoc(ma, ten, lop, thu, tietBD, soTiet, phong, gv);

				for (char c : tgchuoi.toCharArray()) {
					if (Character.isDigit(c)) {
						int tuan = Character.getNumericValue(c);
						qltkb.them(tuan, thu, lh);
					}
				}
			}
		}

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n=== MENU ===");
			System.out.println("1. Xem TKB hôm nay");
			System.out.println("2. Xem TKB theo tuần");
			System.out.println("3. Xem TKB theo tuần + thứ");
			System.out.println("4. Xem TKB theo ngày cụ thể");
			System.out.println("0. Thoát");
			System.out.print(">> Chọn: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				qltkb.xemHomNay();
				break;
			case 2:
				System.out.print("Nhập tuần: ");
				int t = Integer.parseInt(sc.nextLine());
				qltkb.xemTheoTuan(t);
				break;
			case 3:
				System.out.print("Tuần: ");
				t = Integer.parseInt(sc.nextLine());
				System.out.print("Thứ: ");
				int thu = Integer.parseInt(sc.nextLine());
				qltkb.xemTheoTuanThu(t, thu);
				break;
			case 4:
				System.out.print("Nhập ngày (dd/mm/yyyy): ");
				String[] parts = sc.nextLine().split("/");
				qltkb.xemTheoNgay(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
				break;
			case 0:
				System.exit(0);
			}
		}
	}
}