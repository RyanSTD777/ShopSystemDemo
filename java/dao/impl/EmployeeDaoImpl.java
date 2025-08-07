package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.EmployeeDao;
import model.Users;
import util.DbConnection;

public class EmployeeDaoImpl implements EmployeeDao{

	public static void main(String[] args) {
		//Employee employee = new Employee("Ryan","ryan","666","0900111333");
		//new EmployeeDaoImpl().add(employee);
		System.out.println(new EmployeeDaoImpl().select("ryan","666"));
	}
	
	Connection conn = DbConnection.getDb();

	@Override
	public Users select(String username, String password) {
		Users user =null;
		String sql ="select * from employee where username=? and password=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				user = new Users();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setMemberLevel("管理員");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Users select(String username) {
		Users user =null;
		String sql ="select * from employee where username=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				user = new Users();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setRole("admin");
				user.setMemberLevel("管理員");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
