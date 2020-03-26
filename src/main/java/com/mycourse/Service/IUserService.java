package com.mycourse.Service;

import java.util.List;

import com.mycourse.Bean.UserBean;

public interface IUserService {
	
	List<UserBean> ListUsers();
	
	UserBean findUser(int id);

	void CreateUser(UserBean user);
	
	void ModiftUser(UserBean user);
	
	void DeleteUser(int id);
	

}
