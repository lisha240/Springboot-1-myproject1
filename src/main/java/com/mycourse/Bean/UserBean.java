package com.mycourse.Bean;

public class UserBean {
    int id;
	String firstName;
	String lastName;
	String userName;
	String emailId;
	String password;
	
	public UserBean(int id,	String firstName,String lastName,String userName,
	String emailId,String password)	{
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.userName=userName;
		this.emailId=emailId;
		this.password=password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	
	@Override
	public boolean equals(Object obj) {
		
		if(this==obj) 
			return true;
		
		if(obj==null) 
		return false;
		
		if(getClass() != obj.getClass()) 
			return false;
		
		UserBean other = (UserBean) obj;
		if(id != other.id) 
			return false;
		
		return true;
		}	
		
	

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ","
				+ " userName=" + userName	+ ", emailId=" + emailId + ", password=" + password + "]";
	}
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	