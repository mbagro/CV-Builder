package com.mycvproject;

//User Property Model POJO Class for User Basic Details.

public class UserModel {

	//Property Fields.
	private String userName;
	private String userDOB;
	private String userGender;
	private String userAddress;
	private String userCoverLetter;
	
	//Setters and Getters for UserName.
	public void setName(String name) {
		userName = name;
	}
	
	public String getName() {
		return this.userName;
	}
	
	//Setters and Getters for UserDOB.
	public void setDOB(String dob) {
		userDOB = dob;
	}
	
	public String getDOB() {
		return this.userDOB;
	}
	
	
	//Setters and Getters for UserGender.
	public void setGender(String gender) {
		userGender = gender;
	}
	
	public String getGender() {
		return this.userGender;
	}
	
	//Setters and Getters for UserAddress.
	public void setAddress(String address) {
		userAddress = address;
	}
	
	public String getAddress() {
		return this.userAddress;
	}
	
	//Setters and Getters for UserCoverLetter.
	public void setCoverLetter(String coverletter) {
		userCoverLetter = coverletter;
	}
	
	public String getCoverLetter() {
		return userCoverLetter;
	}
	
}
