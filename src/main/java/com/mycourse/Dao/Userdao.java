package com.mycourse.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycourse.Bean.UserBean;
@Repository
public class Userdao implements  IUserDao{

	List<UserBean>  users;
	
	
	public Userdao(){
		super();
		
		this.users=new ArrayList<>();
		this.users.add(new UserBean(1, "lISHA", "PATEL", "LISHA24", "lISHA@gmail.com", "123"));
		this.users.add(new UserBean(2, "lISHA", "PATEL", "LISHA24", "lISHA@gmail.com", "123"));
		this.users.add(new UserBean(3, "lISHA", "PATEL", "LISHA24", "lISHA@gmail.com", "123"));
		this.users.add(new UserBean(4, "lISHA", "PATEL", "LISHA24", "lISHA@gmail.com", "123"));
		this.users.add(new UserBean(5, "lISHA", "PATEL", "LISHA24", "lISHA@gmail.com", "123"));
		
			}
		
		
		
		
	
	
	
	
	@Override
	public List<UserBean> listUsers() {
		// TODO Auto-generated method stub
		return this.users;
	}

	@Override
	public UserBean findUser(int id) {

		
		return this.users.stream().
				filter(u -> u.getId()== id).
				findAny().orElse(null);
	}
	/*
	 * The following method is synchronized to prevent its execution concurrently 
	 * by multiple threads. This is to ensure that the id (max) is unique. In a
	 * real world scenario the id is created by other means like for example a 
	 * database identity field and not manually like in this example.
	 */   
	
	@Override
	public synchronized void CreateUser(UserBean user) {

		 int max=this.users.stream()
				.mapToInt(u -> u.getId())
				.max().orElse(0);
		
		 user.setId(++max);
	     this.users.add(user);
	}

	@Override
	public void ModifyUser(UserBean user) {
		/* 
    	 * The following statement requires the UserBean object to override the 
    	 * equals method.
    	 */
    
		int index=this.users.indexOf(user);
		
		  /* 
         * The index is greater or equals to zero if the user was found inside 
         * the Collection.
         */
      
		if(index >= 0) {
			this.users.set(index, user);
		}
	}

	@Override
	public void deleteUser(int id) {
       this.users.removeIf(u -> u.getId()==id)	;	
	}

	
	
	
}
