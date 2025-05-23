package baitap;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LayTKB {
	public void layVaLuuBangTKB() {
		try (Playwright playwright = Playwright.create()) {
			// Khởi tạo trình duyệt ở chế độ headless
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(100)); // Thêm slowMo để thấy rõ hơn
			BrowserContext context = browser.newContext();
			Page page = context.newPage();

			// 1. Điều hướng tới trang đăng nhập
			page.navigate("https://daotao.vnua.edu.vn/");
			page.waitForSelector("input[name='username']");

			// 2. Điền thông tin đăng nhập
			page.fill("input[name='username']", "687686");
			page.fill("input[name='password']", "NgocLan2208");
			page.click("button:has-text(\"Đăng nhập\")");

			// 3. Đợi trang tải sau khi đăng nhập
			page.waitForSelector("#WEB_TKB_HK", new Page.WaitForSelectorOptions().setTimeout(60000)); // Tăng lên 60 giây

			// 4. Vào trang thời khóa biểu học kỳ
			page.waitForSelector("#WEB_TKB_HK");
			page.click("#WEB_TKB_HK");

			// 5. Chọn học kỳ cần lấy (Học kỳ 2 - Năm học 2024 - 2025)
			page.waitForSelector("div[role='combobox']");
			page.click("div[role='combobox']");
			page.waitForSelector("div[role='option']:has-text('Học kỳ 2 - Năm học 2024 - 2025')");
			page.click("div[role='option']:has-text('Học kỳ 2 - Năm học 2024 - 2025')");

			// 6. Đợi bảng thời khóa biểu tải
			page.waitForSelector("table.table");
			page.waitForTimeout(2000); // Đợi thêm để bảng render đầy đủ

			// 7. Lấy nội dung HTML của bảng
			String bangHtml = page.evaluate("document.querySelector('table.table')?.outerHTML").toString();

			if (bangHtml != null && !bangHtml.isEmpty()) {
				// 8. Gói bảng HTML vào trong một trang đầy đủ
				String htmlWrapper = """
						    <!DOCTYPE html>
						    <html>
						    <head>
						        <meta charset="UTF-8">
						        <title>Thời khóa biểu</title>
						    </head>
						    <body>
						""" + bangHtml + """
						    </body>
						    </html>
						""";

				// 9. Lưu vào file
				Files.writeString(Paths.get("src/main/resources/timetable.html"), htmlWrapper);
				System.out.println("✅ Đã lưu thời khóa biểu vào src/main/resources/timetable.html");
			} else {
				System.out.println("❌ Không tìm thấy bảng thời khóa biểu.");
			}

			browser.close();
		} catch (Exception e) {
			System.err.println("❌ Lỗi khi lấy thời khóa biểu: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		LayTKB layTKB = new LayTKB();
		layTKB.layVaLuuBangTKB();
	}
}
