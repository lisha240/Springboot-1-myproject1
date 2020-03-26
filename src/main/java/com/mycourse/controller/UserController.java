package com.mycourse.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycourse.Bean.UserBean;
import com.mycourse.Service.IUserService;
import com.mycourse.Service.UserService;

@Controller
public class UserController {

	@Autowired
	IUserService UserService;
	
	@GetMapping({"/","index"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/list_users")
	public ModelAndView listUsers() {
		List<UserBean> users= UserService.ListUsers();
		for(UserBean user:users) {
			System.out.println(user);
		}
		
		
		return new ModelAndView("list_users", "users", users);
		
	}
	@GetMapping("/input_user")
	public String inputUser() {
		return "input_user";
		
	}
	
	@PostMapping("/create_user")
	public String createUser(HttpServletRequest request) throws ParseException {
		
		String firstName=request.getParameter("firstName");
		
		String lastName=request.getParameter("lastName");
		String userName=request.getParameter("userName");
		String emailId=request.getParameter("emailId");
		String password=request.getParameter("password");
		
		UserBean user=this.createUserBean("0", firstName,lastName, userName, emailId,password);
		this.UserService.CreateUser(user);
		
		return "redirect:/list_users";
		
				
		
	}

	private UserBean createUserBean(String id, String firstName, String lastName, String userName, String emailId,
			String password) throws ParseException{

		UserBean user= new UserBean(Integer.parseInt(id.trim()),
				firstName.trim(), lastName.trim(), userName.trim(),emailId.trim(), password.trim());
				
		
		
		
		return user;
	}


	@GetMapping("/show_user")
	public ModelAndView showUser(@RequestParam("id") int id) {
		UserBean user=this.UserService.findUser(id);
		return new ModelAndView ("show_user", "user", user);
		
	}
	
	@PostMapping("/modify_user")
public String modifyUser(HttpServletRequest request) throws ParseException {
		
		String id=request.getParameter("id");
		String firstName=request.getParameter("firstName");
		
		String lastName=request.getParameter("lastName");
		String userName=request.getParameter("userName");
		String emailId=request.getParameter("emailId");
		String password=request.getParameter("password");
		
		UserBean user=this.createUserBean(id, firstName,lastName, userName, emailId,password);
		this.UserService.ModiftUser(user);
		
		return "redirect:/list_users";
	
				
		
	}
	
	@GetMapping("/delete_user")
	public String deleteUser(@RequestParam ("id")  int id) {
		this.UserService.DeleteUser(id);
		return "redirect:/list_users";	
	}
}
