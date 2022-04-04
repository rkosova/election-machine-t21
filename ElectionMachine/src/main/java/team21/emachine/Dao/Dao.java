package team21.emachine.Dao;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
	private Connection conn;
	public Dao() {
		try {
			Class.forName("com.mysgl.jdbc.Driver").newInstance();
			conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/election_db", "root", "password");
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// TODO Auto-generated constructor stub
	}
	public void close() {
		try {
		conn.close();
		} catch (SQLException e) {
		 e.printStackTrace();
		}
		}
	public void addUser(String username, String pw, String salt){
		String sql = "insert into user (username, hashedpassword, salt) values (?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, username);
			stmt.setString(2, pw);
			stmt.setString(3, salt);
			
			stmt.executeUpdate();	 
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	public String getUserSalt(String username) {
		String result = "";
		String sql = "select salt from user where username = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				result = rs.getString("salt");
			}} catch (SQLException e){
				e.printStackTrace();
			}
			return result;}
	public String getUserPasswordHash(String username) {
		String result = "";
		String sql = "select hashedpassword from user where username = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				result = rs.getString("hashedpassword");
			}} catch (SQLException e){
				e.printStackTrace();
			}
			return result;}
}