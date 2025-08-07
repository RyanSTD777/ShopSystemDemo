package model;

import java.io.Serializable;

public class Users implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String username;
	private String password;
	private String phone;
	private String role;
	private String memberLevel;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String name, String username, String password, String phone, String role,String memberLevel) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.role = role;
		this.memberLevel = memberLevel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}

}
