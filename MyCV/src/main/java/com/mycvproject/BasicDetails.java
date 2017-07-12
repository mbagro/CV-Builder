package com.mycvproject;

import java.util.ArrayList;
import java.util.Date;

import org.apache.wicket.datetime.StyleDateConverter;
import org.apache.wicket.datetime.markup.html.form.DateTextField;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.validation.validator.DateValidator;
import org.apache.wicket.validation.validator.PatternValidator;

public class BasicDetails extends WebPage {

	private static final long serialVersionUID = 1L;
	private UserModel uModel = new UserModel();
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
		
		// Adding DOB Component with DatePicker.
		/*DateTextField uDOB = new DateTextField("uDOB",new PropertyModel<Date>(uModel, "userDOB"),new StyleDateConverter("S-", true));
		DatePicker dPicker = new DatePicker();
		dPicker.setShowOnFieldClick(true);
		uDOB.add(dPicker);
		uDOB.setRequired(true);*/
		
		//Adding DOB witout DatePicker.
		TextField<Date> uDOB = new TextField<Date>("uDOB", new PropertyModel<Date>(uModel, "userDOB"));
		uDOB.setRequired(true);
		uDOB.add(DateValidator.range("01/01/1800", "31/31/2050"));
		
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
	
		// Adding Home Button.
		Button HomeButton = new Button("HomeBtn") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				super.onSubmit();
				setResponsePage(HomePage.class);
				
			}
		}.setDefaultFormProcessing(false);
		
		
		// Adding Components to Form
		add(mForm);
		mForm.add(uName);
		mForm.add(uDOB);
		mForm.add(genderRadio);
		mForm.add(uAddress);
		mForm.add(uLetter);
		mForm.add(HomeButton);

	}

}
