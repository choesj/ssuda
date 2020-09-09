package login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Database {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String user="java", pwd = "1234";
	public Database() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public HashMap<Integer, HwtooPae> bringPae() throws SQLException {
		HashMap<Integer, HwtooPae> list = new HashMap<Integer, HwtooPae>();
		HwtooPae hwtp;
		String sql = "select * from ssuda";
		con = DriverManager.getConnection(url,user,pwd);
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			hwtp = new HwtooPae();
			hwtp.setNum(rs.getInt("num"));
			hwtp.setGty(rs.getString("gty"));
			list.put(rs.getInt("numkey"), hwtp);
		}
		return list;
	}
	
	public HashMap<String, Integer> bringUser() throws SQLException {
		HashMap<String, Integer> list = new HashMap<String, Integer>();
		User user;
		String sql = "select * from nameid";
		con = DriverManager.getConnection(url,this.user,pwd);
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			user = new User();
			user.setId(rs.getString("id"));
			user.setMoney(rs.getInt("money"));
			list.put(user.getId(),user.getMoney());
		}
		return list;
	}
	
	public int bringUserMoney(String name) throws SQLException {
		String sql = "select money from nameid where id = '"+name+"'";
		con = DriverManager.getConnection(url,this.user,pwd);
		ps = con.prepareStatement(sql); 
		rs = ps.executeQuery();
		int x=0;
		while(rs.next()) {
			x=rs.getInt("money");
		}
		return x;
	}
	
	public void insertUser(String id) throws SQLException {
		String sql = "insert into nameid values(?,?)";
		con = DriverManager.getConnection(url,this.user,pwd);
		ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setInt(2, 1000000);
		ps.executeUpdate();
	}
	
	public void updateUser(String id, int money) throws SQLException {
		String sql = "update nameid set money = "+money+" where id = '"+id+"'";
		con = DriverManager.getConnection(url,this.user,pwd);
		ps = con.prepareStatement(sql);
		ps.executeUpdate();
	}
	
	public void deleteUser(String id) throws SQLException {
		String sql = "delete nameid where id = ?";
		con = DriverManager.getConnection(url,user,pwd);
		ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.executeUpdate();
	}
	
}
