package com.epic;


import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;


public class SuccessPage extends WebPage {

	private static final long serialVersionUID = 1L;

	public SuccessPage(PageParameters parameters) {
		super(parameters);
		
		//Creating Labels for User Details.
		Label uNameLbl = new Label("uNameLbl",parameters.get("userName"));
		Label uEmailLbl = new Label("uEmailLbl",parameters.get("userEmail"));
		Label uPhoneLbl = new Label("uPhoneLbl",parameters.get("userPhone"));
		Label uGender = new Label("uGender",parameters.get("userGender"));
		
		
		add(uNameLbl);
		add(uEmailLbl);
		add(uPhoneLbl);
		add(uGender);
	}
	
	
}
