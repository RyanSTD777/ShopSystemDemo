package service.impl;

import dao.impl.EmployeeDaoImpl;
import model.Users;
import service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

	public static void main(String[] args) {
		//System.out.println(new EmployeeServiceImpl().login("ryan", "666"));

	}
	
	private static EmployeeDaoImpl mdi=new EmployeeDaoImpl();
	@Override
	public boolean existsByUsername(Users users) {
		// TODO Auto-generated method stub
		boolean isUserNameBeenUse=false;
		Users u = mdi.select(users.getUsername());
		if(u==null)
		{
			isUserNameBeenUse=true;
		}
		return isUserNameBeenUse;
	}
	@Override
	public Users login(String username, String password) {
		// TODO Auto-generated method stub
		return mdi.select(username, password);
	}

}
