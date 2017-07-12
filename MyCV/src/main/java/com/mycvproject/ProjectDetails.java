package com.mycvproject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class ProjectDetails extends WebPage {

	private static final long serialVersionUID = 1L;
	private UserPropModel uPropModel = new UserPropModel();

	public ProjectDetails(PageParameters pgParam) {

		// Adding Project Title.
		final TextField<String> pTitleText = new TextField<String>("projectTitle");
		pTitleText.setRequired(true);

		// Adding Project Details.
		final TextArea<String> pDetailsArea = new TextArea<String>("projectDetails");
		pDetailsArea.setRequired(true);

		// These Components don't need Model (no value to save).
		final TextField<String> pTitleSection = new TextField<String>("pTitleSection", Model.of(""));
		pTitleSection.setEnabled(false);

		final TextArea<String> pDetailsSection = new TextArea<>("pDetailsSection", Model.of(""));
		pDetailsSection.setEnabled(false);

		// Adding Add Project Button.
		Button addProjButton = new Button("addProjBtn") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				super.onSubmit();

				// Setting Project Details to Section.
				pTitleSection.setModelObject(uPropModel.getProjectTitle());
				pDetailsSection.setModelObject(uPropModel.getProjectDetails());

				// On Adding Project 
				
				//Clearing the Input.
				pTitleText.setModelObject(" ");
				pDetailsArea.setModelObject(" ");
				
				//Disable the TextFields.
				pTitleText.setEnabled(false);
				pDetailsArea.setEnabled(false);

				// Adding Success Message.
				info("Project Added Successfully");
			}
		}.setDefaultFormProcessing(true);

		// Adding Add Project Button.
		Button updateProjButton = new Button("updateProjBtn") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				super.onSubmit();

				// Enabling TextField to update.
				pTitleSection.setEnabled(true);
				pDetailsSection.setEnabled(true);

			}
		}.setDefaultFormProcessing(false);

		
		// Adding Home Button.
		Button HomeButton = new Button("HomeBtn") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				super.onSubmit();
				setResponsePage(HomePage.class);
				
			}
		}.setDefaultFormProcessing(false);
		
		// Adding Project Form.
		Form<UserPropModel> pForm = new Form<UserPropModel>("pForm",
				new CompoundPropertyModel<UserPropModel>(uPropModel)) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				super.onSubmit();

				// Show the Updated Details.
				String pTitle = pTitleSection.getModelObject();
				String pDetails = pDetailsSection.getModelObject();

				try {
					info("Project Title : " + pTitle);
					info("Project Details : " + pDetails);
				} catch (NullPointerException e) {
					System.out.println("Occured Exception " + e.getLocalizedMessage());
				}
			}

		};

		// Adding Form Components.
		add(new FeedbackPanel("feedback"));
		add(pForm);
		pForm.add(pTitleText);
		pForm.add(pDetailsArea);
		pForm.add(pTitleSection);
		pForm.add(pDetailsSection);
		pForm.add(addProjButton);
		pForm.add(updateProjButton);
		pForm.add(HomeButton);

	}

}
