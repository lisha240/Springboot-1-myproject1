package com.mycourse.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycourse.Bean.UserBean;
import com.mycourse.Dao.IUserDao;

@Service
public class UserService implements IUserService{

	@Autowired
	IUserDao Userdao;
	
	
	
	@Override
	public List<UserBean> ListUsers() {
     List<UserBean> users=Userdao.listUsers();
		
		return users;
	}

	@Override
	public UserBean findUser(int id) {
		return this.Userdao.findUser(id);
	}

	@Override
	public void CreateUser(UserBean user) {
      this.Userdao.CreateUser(user);		
	}

	@Override
	public void ModiftUser(UserBean user) {
		// TODO Auto-generated method stub
		this.Userdao.ModifyUser(user);
	}

	@Override
	public void DeleteUser(int id) {
		// TODO Auto-generated method stub
		this.Userdao.deleteUser(id);
	}

	
	
	
	
}
