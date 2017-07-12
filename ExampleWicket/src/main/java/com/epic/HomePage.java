package com.epic;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.parse.metapattern.MetaPattern;
import org.apache.wicket.validation.validator.EmailAddressValidator;
import org.apache.wicket.validation.validator.PatternValidator;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.awt.Container;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	private final String uNamePattern = "[^0-9]*?"; // Discard numbers 0-9
	private final String uPhonePattern = "[0-9]*?";
	private final String uPassPattern = "(([a-z]*?)([A-Z]*?)([@#$%]*?).{6,20})";

	//User Property Model Object POJO.
	userModel uModel = new userModel();
	
	public HomePage(final PageParameters parameters) {
		super(parameters);

		FeedbackPanel fbPnl = new FeedbackPanel("feedback");
		add(fbPnl);

		// Adding Inputs Components.
		final TextField<String> username = new TextField<String>("userName",new PropertyModel<String>(uModel, "userName"));
		username.setRequired(true);
		username.add(new PatternValidator(uNamePattern));

		final TextField<String> useremail = new TextField<String>("userEmail",new PropertyModel<String>(uModel,"userEmail"));
		useremail.setRequired(true);
		useremail.add(EmailAddressValidator.getInstance());

		final TextField<String> userphone = new TextField<String>("userPhone",new PropertyModel<String>(uModel,"userPhone"));
		userphone.setRequired(true);
		userphone.add(new PatternValidator(uPhonePattern));

		/*final PasswordTextField userpass = new PasswordTextField("userPass", Model.of(""));
		userpass.setRequired(false);
		userpass.add(new PatternValidator(uPassPattern));*/

		final CheckBox mCheck = new CheckBox("mCheck", Model.of(Boolean.FALSE));
		final CheckBox fCheck = new CheckBox("fCheck", Model.of(Boolean.FALSE));

		// Adding Form
		Form<Void> mForm = new Form<Void>("userForm") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {

				// Retrieving the Values back from Form.
				final String uName = uModel.getName();
				final String uEmail = uModel.getEmail();
				final Integer uPhone = Integer.parseInt(uModel.getPhone());

				PageParameters pgParam = new PageParameters();
				// Adding User Details to Parameters.

				
				//Check for Null Values.
				assert(uName != null);
				assert(uEmail != null);
				assert(uPhone != null);
				
				pgParam.add("userName", uName);
				pgParam.add("userEmail", uEmail);
				pgParam.add("userPhone", uPhone);

				// Sending Gender Param.
				if (mCheck.getModelObject().booleanValue()) {
					pgParam.add("userGender", "Male");

					fCheck.setModelObject(Boolean.FALSE);
					fCheck.setEnabled(false);

				} else if (fCheck.getModelObject().booleanValue()) {
					pgParam.add("userGender", "Female");

					mCheck.setModelObject(Boolean.FALSE);
					mCheck.setEnabled(false);
				} else
					pgParam.add("userGender", "nil");

				// Set Page on Form Submit.
				setResponsePage(SuccessPage.class, pgParam);
			}

		};

		// Attaching components to the Form.
		add(mForm);
		mForm.add(username);
		mForm.add(useremail);
		mForm.add(userphone);
		//mForm.add(userpass);
		mForm.add(mCheck);
		mForm.add(fCheck);
	}
}
