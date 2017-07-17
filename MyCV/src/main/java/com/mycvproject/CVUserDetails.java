package com.mycvproject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class CVUserDetails extends WebPage{

	private static final long serialVersionUID = 1L;
	protected transient UserModel uModel = new UserModel();
	
	public CVUserDetails(PageParameters pgParam) {
		
		Form<String> cvForm = new Form<String>("cvForm");
		
		//*************************************
		//Adding Details for User Details Page.
		//*************************************
		TextArea<String> cvUserName = new TextArea<String>("cvUserName",Model.of(""));
		cvUserName.setModelObject(uModel.getName());
				
		TextArea<String> cvUserDOB = new TextArea<String>("cvUserDOB",Model.of(""));
		cvUserDOB.setModelObject(uModel.getDOB());
		
		TextArea<String> cvUserGender = new TextArea<String>("cvUserGender",Model.of(""));
		cvUserGender.setModelObject(uModel.getGender());
		 
		TextArea<String> cvUserCurrAddress = new TextArea<String>("cvUserCurrAddress",Model.of(""));
		cvUserCurrAddress.setModelObject(uModel.getAddress());
		 
		TextArea<String> cvUserCoverLetter = new TextArea<String>("cvUserCoverLetter",Model.of(""));
		cvUserCoverLetter.setModelObject(uModel.getCoverLetter());
		//***************************
		//User Details Section Ended
		//***************************
		
		//Adding Components to Form.
		add(cvForm);
		cvForm.add(cvUserName);
		cvForm.add(cvUserDOB);
		cvForm.add(cvUserGender);
		cvForm.add(cvUserCurrAddress);
		cvForm.add(cvUserCoverLetter);
	}
	

}
