package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.MemberDao;
import model.Users;
import util.DbConnection;

public class MemberDaoImpl implements MemberDao{

	public static void main(String[] args) {
		//Member member = new Member("lin","lin","666","0922111333","member",1);
		//new MemberDaoImpl().add(member);
		System.out.println(new MemberDaoImpl().select("lin"));
	}
	Connection conn = DbConnection.getDb();
	
	@Override
	public void add(Users users) {
		String sql ="insert into member(name,username,password,phone,member_level) value(?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, users.getName());
			ps.setString(2, users.getUsername());
			ps.setString(3, users.getPassword());
			ps.setString(4, users.getPhone());
	        ps.setString(5, users.getMemberLevel());
	        
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Users select(String username, String password) {
		Users users=null;
		String sql="select * from member where username=? and password=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				users=new Users();
				users.setId(rs.getInt("id"));
				users.setName(rs.getString("name"));
				users.setUsername(rs.getString("username"));
				users.setPassword(rs.getString("password"));
				users.setPhone(rs.getString("phone"));
				users.setRole("member");
				users.setMemberLevel(rs.getString("member_level"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public Users select(String username) {
		Users users=null;
		String sql="select * from member where username=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				users=new Users();
				users.setId(rs.getInt("id"));
				users.setName(rs.getString("name"));
				users.setUsername(rs.getString("username"));
				users.setPassword(rs.getString("password"));
				users.setPhone(rs.getString("phone"));
				users.setMemberLevel(rs.getString("member_level"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return users;
	}

	@Override
	public Users findByName(String name) {
		 String sql = "select name, member_level, phone from member where name = ?";
	        try (
	            PreparedStatement ps = conn.prepareStatement(sql);
	        ) {
	            ps.setString(1, name);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                Users u = new Users();
	                u.setName(rs.getString("name"));
	                u.setMemberLevel(rs.getString("member_level"));
	                u.setPhone(rs.getString("phone"));
	                return u;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null; // 找不到視為非會員
	}
	

}
