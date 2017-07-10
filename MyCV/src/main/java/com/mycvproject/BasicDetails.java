package com.mycvproject;

import java.util.ArrayList;
import java.util.Date;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.validation.validator.PatternValidator;

public class BasicDetails extends WebPage {

	private static final long serialVersionUID = 1L;
	private userModel uModel = new userModel();
	private ArrayList<String> genderChoices = new ArrayList<String>();
	private final String charPattern = "[^0-9]*?"; // Discard numbers 0-9

	public BasicDetails(final PageParameters pgParam) {

		// Adding Gender Choices.
		genderChoices.add("Male");
		genderChoices.add("Female");

		// Adding FeedBack panel.
		FeedbackPanel fbPnl = new FeedbackPanel("feedback");
		add(fbPnl);
		
	
		// Adding Form
		Form<Void> mForm = new Form<Void>("userForm") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
					
				try {
					info("Username : " + uModel.getName());
					info("DOB : " + uModel.getDOB());
					info("Gender : " + uModel.getGender());
					info("Address : " + uModel.getAddress());
					info("Cover Letter : " + uModel.getCoverLetter());
				} catch (NullPointerException ex) {
					System.out.println("Exception occured IN : " + ex.getLocalizedMessage());
				}
			}

		};
		
		// Adding UserName Component.
		TextField<String> uName = new TextField<String>("uName", new PropertyModel<String>(uModel, "userName"));
		uName.setRequired(true);
		uName.add(new PatternValidator(charPattern));
		uName.setConvertEmptyInputStringToNull(false);
		
		// Adding DOB Component.
		TextField<Date> uDOB = new TextField<Date>("uDOB", new PropertyModel<Date>(uModel, "userDOB"));
		uDOB.setRequired(true);
		
		// Adding Gender Radio Button.
		RadioChoice<String> genderRadio = new RadioChoice<String>("uGender",
				new PropertyModel<String>(uModel, "userGender"), genderChoices);

		// Adding Address Component.
		TextArea<String> uAddress = new TextArea<String>("uAddress",
				new PropertyModel<String>(uModel, "userAddress"));
		uAddress.setRequired(true);
		uAddress.add(new PatternValidator(charPattern));
		uAddress.setConvertEmptyInputStringToNull(false);
		
		// Adding Cover Letter Component.
		TextArea<String> uLetter = new TextArea<String>("uLetter",
				new PropertyModel<String>(uModel, "userCoverLetter"));
		uLetter.setRequired(true);
		uLetter.add(new PatternValidator(charPattern));
		uLetter.setConvertEmptyInputStringToNull(false);
	
		
		// Adding Components to Form
		add(mForm);
		mForm.add(uName);
		mForm.add(uDOB);
		mForm.add(genderRadio);
		mForm.add(uAddress);
		mForm.add(uLetter);

	}

}
