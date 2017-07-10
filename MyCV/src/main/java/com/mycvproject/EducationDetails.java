package com.mycvproject;


import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;


public class EducationDetails extends WebPage {

	private static final long serialVersionUID = 1L;

	public EducationDetails() {
		
		//Creating Labels for User Details.
		Label eduLbl = new Label("edu","Welcome to Education Page");
		add(eduLbl); 
	}
	
	
}
