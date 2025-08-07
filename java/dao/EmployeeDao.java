package dao;

import model.Users;

public interface EmployeeDao {
	//create
	
	
	//read
	Users select(String username,String password); //登入
	Users select(String username); //檢查帳號是否重複
	
	
	//update
	
	
	//delete
	
	
}
