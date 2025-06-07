package bai_toan_tin_chi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserSubjectView {
	private Connection connection;

	public UserSubjectView() {
		try {
			String driverName = "com.mysql.cj.jdbc.Driver";
			String URL = "jdbc:mysql://localhost:3306/qlsv";
			String user = "Lan";
			String pass = "12345";
			connection = DriverManager.getConnection(URL, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void showUserSubject() {
		String query =
			    "SELECT u.HoTen, s.TenMh, us.Diem1, us.Diem2, us.Diem3, us.Diem4, us.Diem5 " +
			    "FROM qlsv.user u " +
			    "INNER JOIN qlsv.usersubject us ON u.MaNguoiDung = us.MaNguoiDung " +
			    "INNER JOIN qlsv.subject s ON s.MaMh = us.MaMh";


		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				String hoTen = rs.getString("HoTen");
				String tenMh = rs.getString("TenMh");
				float diem1 = rs.getFloat("Diem1");
				float diem2 = rs.getFloat("Diem2");
				float diem3 = rs.getFloat("Diem3");
				float diem4 = rs.getFloat("Diem4");
				float diem5 = rs.getFloat("Diem5");
				System.out.println("Họ tên: " + hoTen + "Môn: " + tenMh + "| Diểm: " + diem1 + "," + diem2 + "," + diem3
						+ "," + diem4 + "," + diem5);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
