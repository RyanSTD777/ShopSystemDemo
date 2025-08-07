package service;

import model.Users;

public interface MemberService {
		//create
		boolean addMember(Users users);//判斷帳號+新增
		boolean existsByUsername(Users users);
		
		//read
		Users login(String username,String password);//登入
		Users findByName(String name);
		
		//update
		
		//delete
}
