package com.mycvproject;

import java.io.Serializable;

//User Property Model POJO Class for User Basic Details.

public class UserModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// Property Fields for User Details.
	private String userName;
	private String userDOB;
	private String userGender;
	private String userAddress;
	private String userCoverLetter;

	// Property Fields of Education and Project Details.
	private String educationChoice;
	private String educationSelected1;
	private String educationSelected2;
	private String educationSelected3;
	private String projectTitle;
	private String projectDetails;

	// Setters and Getters for UserName.
	public void setName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return userName;
	}

	// Setters and Getters for UserDOB.
	public void setDOB(String userDOB) {
		this.userDOB = userDOB;
	}

	public String getDOB() {
		return userDOB;
	}

	// Setters and Getters for UserGender.
	public void setGender(String userGender) {
		this.userGender = userGender;
	}

	public String getGender() {
		return userGender;
	}

	// Setters and Getters for UserAddress.
	public void setAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getAddress() {
		return userAddress;
	}

	// Setters and Getters for UserCoverLetter.
	public void setCoverLetter(String userCoverLetter) {
		this.userCoverLetter = userCoverLetter;
	}

	public String getCoverLetter() {
		return userCoverLetter;
	}

	// Setters and Getters for Education.
	public void setEducationChoice(String educationChoice) {
		this.educationChoice = educationChoice;
	}

	public String getEducationChoice() {
		return educationChoice;
	}

	public void setEducation1(String educationSelected1) {
		this.educationSelected1 = educationSelected1;
	}

	public String getEducation1() {
		return educationSelected1;
	}

	public void setEducation2(String educationSelected2) {
		this.educationSelected2 = educationSelected2;
	}

	public String getEducation2() {
		return educationSelected2;
	}

	public void setEducation3(String educationSelected3) {
		this.educationSelected3 = educationSelected3;
	}

	public String getEducation3() {
		return educationSelected3;
	}

	// Setters and Getters for Project.
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectDetails(String projectDetails) {
		this.projectDetails = projectDetails;
	}

	public String getProjectDetails() {
		return projectDetails;
	}

}
