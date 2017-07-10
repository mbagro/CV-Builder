package com.mycvproject;


import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;


public class ProjectDetails extends WebPage {

	private static final long serialVersionUID = 1L;

	public ProjectDetails() {
		
		//Creating Labels for User Details.
		Label proLbl = new Label("pro","Welcome to Project Page");
		add(proLbl); 
	}
	
	
}
