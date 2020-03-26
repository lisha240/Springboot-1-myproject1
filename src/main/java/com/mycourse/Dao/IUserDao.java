package com.mycourse.Dao;

import java.util.List;

import com.mycourse.Bean.UserBean;

public interface IUserDao {
	
	List<UserBean> listUsers();
	
	UserBean findUser(int id);
	
	void CreateUser(UserBean user);
	
	void ModifyUser(UserBean user);
	
	void deleteUser(int id);

}