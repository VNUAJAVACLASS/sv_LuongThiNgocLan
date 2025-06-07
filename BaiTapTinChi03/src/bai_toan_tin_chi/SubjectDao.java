 package bai_toan_tin_chi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubjectDao {
	private Connection connection;

	public SubjectDao() {
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

	public boolean addSubject(Subject subject) {
		String query = "INSERT INTO qlsv.subject ( MaMH,TenMh, SoTinChi, HeSo1, HeSo2, HeSo3, HeSo4, HeSo5) VALUES(?,?,?,?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, subject.getMaMh());
			stmt.setString(2, subject.getTenMh());
			stmt.setInt(3, subject.getSoTinChi());
			stmt.setFloat(4, subject.getHeSo1());
			stmt.setFloat(5, subject.getHeSo2());
			stmt.setFloat(6, subject.getHeSo3());
			stmt.setFloat(7, subject.getHeSo4());
			stmt.setFloat(8, subject.getHeSo5());

			int rowInserted = stmt.executeUpdate();
			return rowInserted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateSubject(Subject subject) {
		String query = "UPDATE qlsv.subject SET TenMh =?,SoTinChi=?,HeSo1=?,HeSo2=?, HeSo3=?,HeSo4=?,HeSo5=?  WHERE MaMH=?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, subject.getTenMh());
			stmt.setInt(2, subject.getSoTinChi());
			stmt.setFloat(3, subject.getHeSo1());
			stmt.setFloat(4, subject.getHeSo2());
			stmt.setFloat(5, subject.getHeSo3());
			stmt.setFloat(6, subject.getHeSo4());
			stmt.setFloat(7, subject.getHeSo5());
			stmt.setString(8, subject.getMaMh());

			int rowsUpdate = stmt.executeUpdate();
			return rowsUpdate > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteSubject(int subjectId) {
		String query = "DELETE FROM qlsv.subject WHERE MaMH =?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, subjectId);
			int rowDeleted = stmt.executeUpdate();
			return rowDeleted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
