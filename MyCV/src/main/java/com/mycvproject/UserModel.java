package com.mycvproject;

//User Property Model POJO Class for User Basic Details.

public class UserModel {

	//Property Fields.
	private transient String userName;
	private String userDOB;
	private String userGender;
	private String userAddress;
	private String userCoverLetter;
	
	//Setters and Getters for UserName.
	public void setName(String userName) {
		this.userName = userName;
	}
	
	public String getName() {
		return userName;
	}
	
	//Setters and Getters for UserDOB.
	public void setDOB(String userDOB) {
		this.userDOB = userDOB;
	}
	
	public String getDOB() {
		return userDOB;
	}
	
	
	//Setters and Getters for UserGender.
	public void setGender(String userGender) {
		this.userGender = userGender;
	}
	
	public String getGender() {
		return userGender;
	}
	
	//Setters and Getters for UserAddress.
	public void setAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	public String getAddress() {
		return userAddress;
	}
	
	//Setters and Getters for UserCoverLetter.
	public void setCoverLetter(String userCoverLetter) {
		this.userCoverLetter = userCoverLetter;
	}
	
	public String getCoverLetter() {
		return userCoverLetter;
	}
	
}
