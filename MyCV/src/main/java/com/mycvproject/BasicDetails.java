package com.mycvproject;

import java.util.ArrayList;
import java.util.Date;
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
import org.apache.wicket.validation.validator.PatternValidator;

public class BasicDetails extends WebPage {

	private static final long serialVersionUID = 1L;
	private ArrayList<String> genderChoices = new ArrayList<String>();
	private final String charPattern = "[^0-9]*?"; // Discard numbers 0-9

	
	// Public Default Constructor Invoked by Init() If opened DIrect from HomePage.
	public BasicDetails() {
		this(HomePage.uModel);
	}

	// Public Custom Constructor Invoked on Form Response Page.
	public BasicDetails(final UserModel uModel) {

		// Adding Gender Choices.
		genderChoices.add("Male");
		genderChoices.add("Female");

		// Adding FeedBack panel.
		add(new FeedbackPanel("feedback"));

		// Adding UserName Component.
		final TextField<String> uName = new TextField<String>("uName", new PropertyModel<String>(uModel, "userName"));
		uName.setRequired(true);
		uName.add(new PatternValidator(charPattern));
		uName.setOutputMarkupId(true);
		
		// Adding DOB Component with DatePicker.
		DateTextField uDOB = DateTextField.forDatePattern("uDOB", new PropertyModel<Date>(uModel, "userDOB"),
				"dd/MM/yyyy");
		DatePicker dPicker = new DatePicker();
		dPicker.setAutoHide(true);
		uDOB.add(dPicker);
		uDOB.setRequired(true);
		uDOB.setOutputMarkupId(true);

		// Adding Gender Radio Button.
		RadioChoice<String> genderRadio = new RadioChoice<String>("uGender",
				new PropertyModel<String>(uModel, "userGender"), genderChoices);
		genderRadio.setOutputMarkupId(true);
		
		// Adding Address Component.
		TextArea<String> uAddress = new TextArea<String>("uAddress", new PropertyModel<String>(uModel, "userAddress"));
		uAddress.setRequired(true);
		uAddress.add(new PatternValidator(charPattern));
		uAddress.setConvertEmptyInputStringToNull(false);
		uAddress.setOutputMarkupId(true);
		
		// Adding Cover Letter Component.
		TextArea<String> uLetter = new TextArea<String>("uLetter",
				new PropertyModel<String>(uModel, "userCoverLetter"));
		uLetter.setRequired(true);
		uLetter.add(new PatternValidator(charPattern));
		uLetter.setConvertEmptyInputStringToNull(false);
		uLetter.setOutputMarkupId(true);
		
		// Adding Next Button.
		Button nextButton = new Button("NextBtn") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				super.onSubmit();

				// Passing uModel Object for Saving Details.
				setResponsePage(new EducationDetails(uModel));
			}
		}.setDefaultFormProcessing(true);

		//Adding Save Details Button.
		Button saveButton = new Button("SaveBtn") {
			
			private static final long serialVersionUID = 1L;
			
			@Override
			public void onSubmit() {

				// Adding Error Messages.
				// if(uName.getModelObject().isEmpty())
				// uName.error("UserName is required");

				setResponsePage(HomePage.class);

			}
		}.setDefaultFormProcessing(true);
		
		
		// Adding Form
		Form<Void> mForm = new Form<Void>("userForm");

		// Adding Components to Form
		add(mForm);
		mForm.add(uName);
		mForm.add(uDOB);
		mForm.add(genderRadio);
		mForm.add(uAddress);
		mForm.add(uLetter);
		mForm.add(nextButton);
		mForm.add(saveButton);
	}

}
