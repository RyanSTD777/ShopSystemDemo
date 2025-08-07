package dao;

import model.Users;

public interface MemberDao {
	//create
	void add(Users member); //註冊

		
	//read
	Users select(String username,String password); //登入
	Users select(String username); //檢查帳號是否重複
	Users findByName(String name);
	
	
	//update
	
	
	//delete
}
