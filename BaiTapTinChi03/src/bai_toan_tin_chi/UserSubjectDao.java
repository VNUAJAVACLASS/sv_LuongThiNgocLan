package bai_toan_tin_chi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserSubjectDao {
private Connection connection;
	
	public UserSubjectDao() {
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
	
	public boolean addUserSubject(UserSubject userSubject) {
		String query = "INSERT INTO qlsv.usersubject ( MaMhNguoiDung,MaNguoiDung,MaMH,Diem1,Diem2,Diem3,Diem4,Diem5) VALUES(?,?,?,?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, userSubject.getMaMhNguoiDung());
			stmt.setString(2, userSubject.getMaNguoiDung());
			stmt.setString(3, userSubject.getMaMh());
			stmt.setFloat(4, userSubject.getDiem1());
			stmt.setFloat(5, userSubject.getDiem2());
			stmt.setFloat(6, userSubject.getDiem3());
			stmt.setFloat(7, userSubject.getDiem4());
			stmt.setFloat(8, userSubject.getDiem5());

			int rowInserted = stmt.executeUpdate();
			return rowInserted > 0;
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateUserSubject(UserSubject userSubject) {
		String query = "UPDATE qlsv.usersubject SET MaNguoiDung =?,MaMH=?,Diem1=?,Diem2=?,Diem3=?,Diem4=?,Diem5=? WHERE MaMhNguoiDung=?";
		try (PreparedStatement stmt=connection.prepareStatement(query)){
			stmt.setString(1, userSubject.getMaNguoiDung());
			stmt.setString(2, userSubject.getMaMh());
			stmt.setFloat(3, userSubject.getDiem1());
			stmt.setFloat(4, userSubject.getDiem2());
			stmt.setFloat(5, userSubject.getDiem3());
			stmt.setFloat(6, userSubject.getDiem4());
			stmt.setFloat(7, userSubject.getDiem5());
			stmt.setString(8, userSubject.getMaMhNguoiDung());
			
			int rowsUpdate = stmt.executeUpdate();
			return rowsUpdate >0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteUserSubject(int userSubjectId) {
		String query = "DELETE FROM qlsv.usersubject WHERE MaMhNguoiDung =?";
		try (PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setInt(1, userSubjectId);
			int rowDeleted = stmt.executeUpdate();
			return rowDeleted >0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
