package com.mycvproject;


import java.util.ArrayList;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.ListChoice;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class EducationDetails extends WebPage {

	private static final long serialVersionUID = 1L;

	//Adding Fields.
	private ArrayList<String> eduListChoice = new ArrayList<String>();
	private String eduSelected = "select";
	
	public EducationDetails(PageParameters pgParam) {
		
		//Adding FeedBack Panel.
		add(new FeedbackPanel("feedback"));
		
		//Adding Education Choices.
		eduListChoice.add("undergraduate");
		eduListChoice.add("Graduate");
		eduListChoice.add("Post Graduate");
						
		//Adding Education List.
		ListChoice<String> educationList = new ListChoice<>("eduList",new PropertyModel<String>(this, "eduSelected"),eduListChoice);
		
		//Adding Education Selected Area.
		final TextArea<String> eduArea = new TextArea<String>("eduArea",Model.of(""));
		
		
		//Adding AddEducation Button.
		Button eduAddButton = new Button("eduAdd") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				super.onSubmit();
				eduArea.setModelObject(eduSelected);
			}
		};
		eduAddButton.setDefaultFormProcessing(false);
		
		//Adding Update Button.
		Button eduUpdateButton = new Button("eduUpdate") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				super.onSubmit();
			}
		};
		eduUpdateButton.setDefaultFormProcessing(false);
		
		
		//Adding Education Form.
		Form<Void> eduForm = new Form<Void>("eduForm") {
			
			@Override
			protected void onSubmit() {
				super.onSubmit();
				
				eduArea.setModelObject(eduSelected);
				info(eduSelected);
				eduArea.setEnabled(false);
			}
			
		};
		
		
		//Adding Form Components.
		add(eduForm);
		eduForm.add(eduAddButton);
		eduForm.add(educationList);
		eduForm.add(eduArea);
		eduForm.add(eduUpdateButton);
	}
	
}
