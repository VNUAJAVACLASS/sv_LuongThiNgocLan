package bai_toan_tin_chi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
	private Connection connection;
	
	public UserDao() {
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
	
	public boolean addUser(User user) {
		String query = "INSERT INTO qlsv.user (maNguoiDung, HoTen, DiaChi, MatKhau, Loai) VALUES(?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, user.getMaNguoiDung());
			stmt.setString(2, user.getHoTen());
			stmt.setString(3, user.getDiaChi());
			stmt.setString(4, user.getMatKhau());
			stmt.setString(5, user.getLoai());

			int rowInserted = stmt.executeUpdate();
			return rowInserted > 0;
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateUser(User user) {
		String query = "UPDATE qlsv.user SET HoTen =?,DiaChi=?,MatKhau=?,Loai=? WHERE MaNguoiDung=?";
		try (PreparedStatement stmt=connection.prepareStatement(query)){
			stmt.setString(1, user.getHoTen());
			stmt.setString(2, user.getDiaChi());
			stmt.setString(3, user.getMatKhau());
			stmt.setString(4, user.getLoai());
			stmt.setInt(5, user.getMaNguoiDung());
			
			int rowsUpdate = stmt.executeUpdate();
			return rowsUpdate >0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteUser(int userId) {
		String query = "DELETE FROM qlsv.user WHERE MaNguoiDung =?";
		try (PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setInt(1, userId);
			int rowDeleted = stmt.executeUpdate();
			return rowDeleted >0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
