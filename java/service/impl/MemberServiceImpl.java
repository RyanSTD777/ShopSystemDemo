package service.impl;

import dao.impl.EmployeeDaoImpl;
import dao.impl.MemberDaoImpl;
import model.Users;
import service.MemberService;

public class MemberServiceImpl implements MemberService{

	public static void main(String[] args) {
		//Member m=new Member("jay","jay","777","0911777222",1);
		//System.out.println(new MemberServiceImpl().addMember(m));
		//System.out.println(new MemberServiceImpl().login("jay", "777"));

	}

	private static MemberDaoImpl mdi=new MemberDaoImpl();
	private static EmployeeDaoImpl edi = new EmployeeDaoImpl();
	@Override
	public boolean existsByUsername(Users users) {
		boolean isUserNameBeenUse=false;
		Users u = mdi.select(users.getUsername());
		if(u==null)
		{
			isUserNameBeenUse=true;
		}
		return isUserNameBeenUse;
	}
	@Override
	public boolean addMember(Users users) {
		// TODO Auto-generated method stub
		boolean isUserNameBeenUse=false;
		Users u = mdi.select(users.getUsername());
		Users u2 = edi.select(users.getUsername());
		if(u==null && u2==null )
		{
			mdi.add(users);
			isUserNameBeenUse=true;
		}
		return isUserNameBeenUse;
	}
	@Override
	public Users login(String username, String password) {
		// TODO Auto-generated method stub
		return mdi.select(username, password);
	}
	@Override
	public Users findByName(String name) {
		// TODO Auto-generated method stub
		return mdi.findByName(name);
	}

}
