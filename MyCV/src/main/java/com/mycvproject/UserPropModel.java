package com.mycvproject;

//User Compound Property Model for Education and Project Page.
public class UserPropModel{

	//Private Fields of Model.
	private String educationChoice;
	private String educationSelected1;   
	private String educationSelected2; 
	private String educationSelected3; 
	
	private String projectTitle;
	private String projectDetails;
	
	//Setters and Getters for Education.
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
	
	//Setters and Getters for Project.
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
