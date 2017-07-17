package com.mycvproject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;


public class CVUserDetails extends WebPage{

	private static final long serialVersionUID = 1L;

	//Public Default Constructor Invoked by Init() If opened Direct from HomePage.
	public CVUserDetails() {
		this(BasicDetails.uModel);
	}
	
	//Public Custom Constructor Invoked on Form Response Page.
	public CVUserDetails(final UserModel uModel) {
		
		// Adding FeedBack Panel.
		add(new FeedbackPanel("feedback"));
		
		//Adding Form.
		Form<UserModel> cvForm = new Form<UserModel>("cvForm",
				new CompoundPropertyModel<UserModel>(uModel))  {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				super.onSubmit();
				
			}
		};
		
		//*****************************
		// User Details Section Starts.
		//*****************************
		TextArea<String> cvUserName = new TextArea<String>("cvUserName",Model.of(""));
		cvUserName.setModelObject(uModel.getName());
		cvUserName.setEnabled(false);
		
		
		TextArea<String> cvUserDOB = new TextArea<String>("cvUserDOB",Model.of(""));
		cvUserDOB.setModelObject(uModel.getDOB());
		cvUserDOB.setEnabled(false);
		
		
		TextArea<String> cvUserGender = new TextArea<String>("cvUserGender",Model.of(""));
		cvUserGender.setModelObject(uModel.getGender());
		cvUserGender.setEnabled(false); 
		
		TextArea<String> cvUserCurrAddress = new TextArea<String>("cvUserCurrAddress",Model.of(""));
		cvUserCurrAddress.setModelObject(uModel.getAddress());
		cvUserCurrAddress.setEnabled(false); 
		
		TextArea<String> cvUserCoverLetter = new TextArea<String>("cvUserCoverLetter",Model.of(""));
		cvUserCoverLetter.setModelObject(uModel.getCoverLetter());
		cvUserCoverLetter.setEnabled(false);
		
		//***************************
		//User Details Section Ended
		//***************************
		
		//**********************************
		// Education Details Section Starts.
		//**********************************
		
		//Education 1 Area.
		Label cvEduLabel1 = new Label("cvEduLabel1","Education 1 :");
		
		TextArea<String> cvEduArea1 = new TextArea<String>("cvEduArea1",Model.of(""));
		cvEduArea1.setEnabled(false);
		
		//Education 2 Area.
		Label cvEduLabel2 = new Label("cvEduLabel2","Education 2 :");
		cvEduLabel2.setVisible(false);
		
		TextArea<String> cvEduArea2 = new TextArea<String>("cvEduArea2",Model.of(""));
		cvEduArea2.setEnabled(false);
		cvEduArea2.setVisible(false);
		
		//Education 3 Area.
		Label cvEduLabel3 = new Label("cvEduLabel3","Education 3 :");
		cvEduLabel3.setVisible(false);
		
		TextArea<String> cvEduArea3 = new TextArea<String>("cvEduArea3",Model.of(""));
		cvEduArea3.setEnabled(false);
		cvEduArea3.setModelObject(uModel.getEducation3());
		cvEduArea3.setVisible(false);
		
		//Setting Updated Values.
		if(EducationDetails.eduAreaState == EducationDetails.EDU_AREA_1) {
			cvEduArea1.setModelObject(uModel.getEducation1());
		}
		else if(EducationDetails.eduAreaState == EducationDetails.EDU_AREA_2) {
			
			//Setting Visibility.
			cvEduLabel2.setVisible(true);
			cvEduArea2.setVisible(true);
			
			//Setting Model Value to Education Areas 1 & 2.
			cvEduArea1.setModelObject(uModel.getEducation1());
			cvEduArea2.setModelObject(uModel.getEducation2());
		}
		else if(EducationDetails.eduAreaState == EducationDetails.EDU_AREA_3) {
			
			//Setting Visibility.
			cvEduLabel2.setVisible(true);
			cvEduArea2.setVisible(true);
			
			cvEduLabel3.setVisible(true);
			cvEduArea3.setVisible(true);
			
			//Setting Model Value to Education Areas 1,2 & 3.
			cvEduArea1.setModelObject(uModel.getEducation1());
			cvEduArea2.setModelObject(uModel.getEducation2());
			cvEduArea3.setModelObject(uModel.getEducation3());
		}
		
		//********************************
		//Education Details Section Ended
		//********************************
		
		//**********************************
		// Project Details Section Starts.
		//**********************************
		
		//Project 1 Area.
		Label cvPTitleLbl1 = new Label("cvPTitleLbl1","Project 1 Title:");
		
		TextField<String> cvPTitleSection1 = new TextField<String>("cvPTitleSection1",Model.of(""));
		cvPTitleSection1.setEnabled(false);
		
		
		Label cvPDetailsLbl1 = new Label("cvPDetailsLbl1","Project 1 Details");
		
		TextArea<String> cvPDetailsSection1 = new TextArea<String>("cvPDetailsSection1",Model.of(""));
		cvPDetailsSection1.setEnabled(false);
		
		
		//Project 2 Area.
		Label cvPTitleLbl2 = new Label("cvPTitleLbl2","Project 2 Title:");
		cvPTitleLbl2.setVisible(false);
		
		TextField<String> cvPTitleSection2 = new TextField<String>("cvPTitleSection2",Model.of(""));
		cvPTitleSection2.setEnabled(false);
		cvPTitleSection2.setVisible(false);

		Label cvPDetailsLbl2 = new Label("cvPDetailsLbl2","Project 2 Details");
		cvPDetailsLbl2.setEnabled(false);
		cvPDetailsLbl2.setVisible(false);
		
		TextArea<String> cvPDetailsSection2 = new TextArea<String>("cvPDetailsSection2",Model.of(""));
		cvPDetailsSection2.setEnabled(false);
		cvPDetailsSection2.setVisible(false);
		
		//Project 3 Area.
		Label cvPTitleLbl3 = new Label("cvPTitleLbl3","Project 3 Title:");
		cvPTitleLbl3.setEnabled(false);
		cvPTitleLbl3.setVisible(false);
		
		TextField<String> cvPTitleSection3 = new TextField<String>("cvPTitleSection3",Model.of(""));
		cvPTitleSection3.setEnabled(false);
		cvPTitleSection3.setVisible(false);
		
		Label cvPDetailsLbl3 = new Label("cvPDetailsLbl3","Project 3 Details");
		cvPDetailsLbl3.setEnabled(false);
		cvPDetailsLbl3.setVisible(false);
		
		TextArea<String> cvPDetailsSection3 = new TextArea<String>("cvPDetailsSection3",Model.of(""));
		cvPDetailsSection3.setEnabled(false);
		cvPDetailsSection3.setVisible(false);
				
		// Show the Updated Details For Project.
		try {

			if (ProjectDetails.prjAreaState == ProjectDetails.PRJ_AREA_1) {
				
				//Setting Project 1 Details.
				cvPTitleSection1.setModelObject(ProjectDetails.pTitleSection1.getModelObject());
				cvPDetailsSection1.setModelObject(ProjectDetails.pDetailsSection1.getModelObject());
			}

			else if ((ProjectDetails.prjAreaState == ProjectDetails.PRJ_AREA_2)) {
				cvPTitleLbl2.setVisible(true);
				cvPDetailsLbl2.setVisible(true);
				cvPTitleSection2.setVisible(true);
				cvPDetailsSection2.setVisible(true);
				
				//Setting Project 1 & 2 Details.
				cvPTitleSection1.setModelObject(ProjectDetails.pTitleSection1.getModelObject());
				cvPDetailsSection1.setModelObject(ProjectDetails.pDetailsSection1.getModelObject());
				
				cvPTitleSection2.setModelObject(ProjectDetails.pTitleSection2.getModelObject());
				cvPDetailsSection2.setModelObject(ProjectDetails.pDetailsSection2.getModelObject());
			}

			else if ((ProjectDetails.prjAreaState == ProjectDetails.PRJ_AREA_3)) {
				cvPTitleLbl2.setVisible(true);
				cvPDetailsLbl2.setVisible(true);
				cvPTitleSection2.setVisible(true);
				cvPDetailsSection2.setVisible(true);
				cvPTitleLbl3.setVisible(true);
				cvPDetailsLbl3.setVisible(true);
				cvPTitleSection3.setVisible(true);
				cvPDetailsSection3.setVisible(true);
				
				//Setting Project 1 ,2 & 3 Details.
				cvPTitleSection1.setModelObject(ProjectDetails.pTitleSection1.getModelObject());
				cvPDetailsSection1.setModelObject(ProjectDetails.pDetailsSection1.getModelObject());
				
				cvPTitleSection2.setModelObject(ProjectDetails.pTitleSection2.getModelObject());
				cvPDetailsSection2.setModelObject(ProjectDetails.pDetailsSection2.getModelObject());
				
				cvPTitleSection3.setModelObject(ProjectDetails.pTitleSection3.getModelObject());
				cvPDetailsSection3.setModelObject(ProjectDetails.pDetailsSection3.getModelObject());
			}

		} catch (NullPointerException e) {
			info("Occured Exception " + e.getLocalizedMessage());
		}
		
		
		//********************************
		//Project Details Section Ended
		//********************************
		
		
		//Adding Components to Form.
		add(cvForm);
		
		//User Details.
		cvForm.add(cvUserName);
		cvForm.add(cvUserDOB);
		cvForm.add(cvUserGender);
		cvForm.add(cvUserCurrAddress);
		cvForm.add(cvUserCoverLetter);
		
		//Education Detials
		cvForm.add(cvEduLabel1);
		cvForm.add(cvEduLabel2);
		cvForm.add(cvEduLabel3);
		cvForm.add(cvEduArea1);
		cvForm.add(cvEduArea2);
		cvForm.add(cvEduArea3);
		
		//Project Details.
		cvForm.add(cvPTitleLbl1);
		cvForm.add(cvPTitleSection1);
		cvForm.add(cvPDetailsLbl1);
		cvForm.add(cvPDetailsSection1);
		
		cvForm.add(cvPTitleLbl2);
		cvForm.add(cvPTitleSection2);
		cvForm.add(cvPDetailsLbl2);
		cvForm.add(cvPDetailsSection2);
		
		cvForm.add(cvPTitleLbl3);
		cvForm.add(cvPTitleSection3);
		cvForm.add(cvPDetailsLbl3);
		cvForm.add(cvPDetailsSection3);
		
	}
	

}
