package service;

import model.Users;

public interface EmployeeService {
	//create
	boolean existsByUsername(Users users);//判斷帳號
			
			
	//read
	Users login(String username,String password);//登入
			
	//update
			
	//delete	
}
