package com.mycvproject;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.mycvproject.EducationDetails.eduAreaStateEnum;

public class ProjectDetails extends WebPage {

	private static final long serialVersionUID = 1L;
	private UserPropModel uPropModel = new UserPropModel();

	//Education Area Enum.
	private enum prjAreaStateEnum {
		PRJ_AREA_1, PRJ_AREA_2, PRJ_AREA_3;
	};
	
	private prjAreaStateEnum prjAreaState = prjAreaStateEnum.PRJ_AREA_1;
	
	public ProjectDetails(PageParameters pgParam) {

		// Adding Project Title.
		final TextField<String> pTitleText = new TextField<String>("projectTitle");
		pTitleText.setRequired(true);

		// Adding Project Details.
		final TextArea<String> pDetailsArea = new TextArea<String>("projectDetails");
		pDetailsArea.setRequired(true);

		// These Components don't need Model (no value to save).
		
		//Project 1 Section.
		final Label pTitleLabel1 = new Label("pTitleLbl1", "Project 1 Title");
		pTitleLabel1.setVisible(false);
		
		final Label pDetailsLabel1 = new Label("pDetailsLbl1", "Project 1 Details");
		pDetailsLabel1.setVisible(false);
		
		final TextField<String> pTitleSection1 = new TextField<String>("pTitleSection1", Model.of(""));
		pTitleSection1.setEnabled(false);
		pTitleSection1.setVisible(false);
		pTitleSection1.setOutputMarkupId(true);
		
		final TextArea<String> pDetailsSection1 = new TextArea<String>("pDetailsSection1", Model.of(""));
		pDetailsSection1.setEnabled(false);
		pDetailsSection1.setVisible(false);
		pDetailsSection1.setOutputMarkupId(true);

		
		//Project 2 Section.
		final Label pTitleLabel2 = new Label("pTitleLbl2", "Project 2 Title");
		pTitleLabel2.setVisible(false);
		
		final Label pDetailsLabel2 = new Label("pDetailsLbl2", "Project 2 Details");
		pDetailsLabel2.setVisible(false);
		
		final TextField<String> pTitleSection2 = new TextField<String>("pTitleSection2", Model.of(""));
		pTitleSection2.setEnabled(false);
		pTitleSection2.setVisible(false);
		pTitleSection2.setOutputMarkupId(true);
		
		final TextArea<String> pDetailsSection2 = new TextArea<String>("pDetailsSection2", Model.of(""));
		pDetailsSection2.setEnabled(false);
		pDetailsSection2.setVisible(false);
		pDetailsSection2.setOutputMarkupId(true);
		
		//Project 3 Section.
		final Label pTitleLabel3 = new Label("pTitleLbl3", "Project 3 Title");
		pTitleLabel3.setVisible(false);
		
		final Label pDetailsLabel3 = new Label("pDetailsLbl3", "Project 3 Details");
		pDetailsLabel3.setVisible(false);
		
		final TextField<String> pTitleSection3 = new TextField<String>("pTitleSection3", Model.of(""));
		pTitleSection3.setEnabled(false);
		pTitleSection3.setVisible(false);
		pTitleSection3.setOutputMarkupId(true);
		
		final TextArea<String> pDetailsSection3 = new TextArea<>("pDetailsSection3", Model.of(""));
		pDetailsSection3.setEnabled(false);
		pDetailsSection3.setVisible(false);
		pDetailsSection3.setOutputMarkupId(true);

		
		//Adding AJAX on Project Title.
		pTitleText.add(new OnChangeAjaxBehavior() {
			
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				
				//Project Area 1.
				if(prjAreaState == prjAreaStateEnum.PRJ_AREA_1) {
				pTitleSection1.setModelObject(uPropModel.getProjectTitle());
				target.add(pTitleSection1);
				
				prjAreaState = prjAreaStateEnum.PRJ_AREA_2;
				}
				
				//Project Area 2.
				else if(prjAreaState == prjAreaStateEnum.PRJ_AREA_2) {
				pTitleSection2.setModelObject(uPropModel.getProjectTitle());
				target.add(pTitleSection2);
				
				prjAreaState = prjAreaStateEnum.PRJ_AREA_3;
				}
				
				//Project Area 3.
				else if(prjAreaState == prjAreaStateEnum.PRJ_AREA_3) {
				pTitleSection3.setModelObject(uPropModel.getProjectTitle());
				target.add(pTitleSection3);
				
				}
				
			}
		});
		
		//Adding AJAX on Project Details.
		pDetailsArea.add(new OnChangeAjaxBehavior() {
			
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				pDetailsSection1.setModelObject(uPropModel.getProjectDetails());
				target.add(pDetailsSection1);
			}
		});
		
		
		// Adding Add Project Button.
		Button addProjButton = new Button("addProjBtn") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				super.onSubmit();
				
				pTitleLabel1.setVisible(true);
				pTitleSection1.setVisible(true);
				
				pDetailsLabel1.setVisible(true);
				pDetailsSection1.setVisible(true);
				
				// On Adding Project 
				
				//Clearing the Input.
				pTitleText.setModelObject(" ");
				pDetailsArea.setModelObject(" ");
				
				// Adding Success Message.
				info("Project Added Successfully");
			}
		}.setDefaultFormProcessing(false);

		// Adding Add Project Button.
		Button updateProjButton = new Button("updateProjBtn") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				super.onSubmit();

				// Enabling TextField to update.
				pTitleSection1.setEnabled(true);				
				pDetailsSection1.setEnabled(true);
				
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

				if(uPropModel.getProjectTitle() != null) {
					pTitleText.setRequired(false);
					pDetailsArea.setRequired(false);
				}
				
				// Show the Updated Details.
				String pTitle = pTitleSection1.getModelObject();
				String pDetails = pDetailsSection1.getModelObject();

				try {
					info("Project Title : " + pTitle);
					info("Project Details : " + pDetails);
				} catch (NullPointerException e) {
					info("Occured Exception " + e.getLocalizedMessage());
				}
			}

		};

		// Adding Form Components.
		add(new FeedbackPanel("feedback"));
		add(pForm);
		pForm.add(pTitleText);
		pForm.add(pDetailsArea);
		
		pForm.add(pTitleLabel1);
		pForm.add(pDetailsLabel1);
		pForm.add(pTitleSection1);
		pForm.add(pDetailsSection1);
		
		pForm.add(pTitleLabel2);
		pForm.add(pDetailsLabel2);
		pForm.add(pTitleSection2);
		pForm.add(pDetailsSection2);
		
		pForm.add(pTitleLabel3);
		pForm.add(pDetailsLabel3);
		pForm.add(pTitleSection3);
		pForm.add(pDetailsSection3);
		
		pForm.add(addProjButton);
		pForm.add(updateProjButton);
		pForm.add(HomeButton);

	}

}
