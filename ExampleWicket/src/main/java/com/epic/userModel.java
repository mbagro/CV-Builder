package com.epic;

//User Property Model POJO.

public class userModel {

	//Properties Fields.
	private String userName;
	private String userEmail;
	private String userPhone;
	
	//Setters and Getters for UserName.
	public void setName(String name) {
		userName = name;
	}
	
	public String getName() {
		return this.userName;
	}
	
	//Setters and Getters for UserEmail.
	public void setEmail(String email) {
		userEmail = email;
	}
	
	public String getEmail() {
		return this.userEmail;
	}
	
	
	//Setters and Getters for UserPhone.
	public void setPhone(String phone) {
		userPhone = phone;
	}
	
	public String getPhone() {
		return this.userPhone;
	}
	
}
