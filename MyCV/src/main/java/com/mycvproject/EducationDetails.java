package com.mycvproject;

import java.util.Arrays;
import java.util.List;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class EducationDetails extends WebPage {

	private static final long serialVersionUID = 1L;

	// Adding Education List Field.
	private List<String> eduListChoice = Arrays.asList(new String[] { "Undergraduate/Matriculation",
			"Undergraduate/Higher Secondary", "Graduate/B.tech", "Graduate/B.E", "Graduate/BSC", "Graduate/BBA",
			"Graduate/BCA", "Graduate/BCOM", "Post Graduate/M.Tech", "Post Graduate/MCA", "Post Graduate/MCOM",
			"Post Graduate/MSC", "Post Graduate/MBA", });

	// User Property Model Field.
	private UserPropModel uPropModel = new UserPropModel();

	// Education Area Enum.
	private enum eduAreaStateEnum {
		EDU_AREA_0, EDU_AREA_1, EDU_AREA_2, EDU_AREA_3;
	};

	private eduAreaStateEnum eduAreaState = eduAreaStateEnum.EDU_AREA_0;

	public EducationDetails(PageParameters pgParam) {

		// Adding FeedBack Panel.
		add(new FeedbackPanel("feedback"));

		// Adding Education DropDownList.
		final DropDownChoice<String> eduDropDown = new DropDownChoice<String>("eduList",
				new PropertyModel<String>(uPropModel, "educationChoice"), eduListChoice);
		eduDropDown.setRequired(true);
		eduDropDown.setEnabled(true);

		// Adding Education Label1
		final Label eduLabel1 = new Label("eduLabel1", "Education1");
		eduLabel1.setVisible(false);

		// Adding Education Selected Area1.
		final TextArea<String> eduArea1 = new TextArea<String>("eduArea1",
				new PropertyModel<String>(uPropModel, "educationSelected1"));
		eduArea1.setEnabled(false);
		eduArea1.setVisible(false);
		eduArea1.setOutputMarkupId(true);
		eduArea1.setRequired(true);

		eduArea1.add(new OnChangeAjaxBehavior() {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				// TODO Auto-generated method stub
				try {
					eduListChoice.add(eduArea1.getModelObject());
					target.add(eduDropDown);
				} catch (Exception e) {
					info("Exception " + e.getLocalizedMessage());
				}

			}
		});

		// Adding Education Label2
		final Label eduLabel2 = new Label("eduLabel2", "Education2");
		eduLabel2.setVisible(false);

		// Adding Education Selected Area2.
		final TextArea<String> eduArea2 = new TextArea<String>("eduArea2",
				new PropertyModel<String>(uPropModel, "educationSelected2"));
		eduArea2.setEnabled(false);
		eduArea2.setVisible(false);
		eduArea2.setOutputMarkupId(true);
		eduArea2.setRequired(true);

		// Adding Education Label3
		final Label eduLabel3 = new Label("eduLabel3", "Education3");
		eduLabel3.setVisible(false);

		// Adding Education Selected Area3.
		final TextArea<String> eduArea3 = new TextArea<String>("eduArea3",
				new PropertyModel<String>(uPropModel, "educationSelected3"));
		eduArea3.setEnabled(false);
		eduArea3.setVisible(false);
		eduArea3.setOutputMarkupId(true);
		eduArea3.setRequired(true);

		// Adding AddEducation Button.
		Button eduAddButton = new Button("eduAdd") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				super.onSubmit();

				// Adding Education Areas.
				if (eduAreaState == eduAreaStateEnum.EDU_AREA_0) {
					eduLabel1.setVisible(true);
					eduArea1.setVisible(true);
					eduArea1.setModelObject(uPropModel.getEducationChoice());
					eduAreaState = eduAreaStateEnum.EDU_AREA_1;

					// Enable the DropDown List
					eduDropDown.setEnabled(true);
				} else if (eduAreaState == eduAreaStateEnum.EDU_AREA_1) {
					eduLabel2.setVisible(true);
					eduArea2.setVisible(true);
					eduArea2.setModelObject(uPropModel.getEducationChoice());

					eduAreaState = eduAreaStateEnum.EDU_AREA_2;
				} else if (eduAreaState == eduAreaStateEnum.EDU_AREA_2) {
					eduLabel3.setVisible(true);
					eduArea3.setVisible(true);
					eduArea3.setModelObject(uPropModel.getEducationChoice());

					eduAreaState = eduAreaStateEnum.EDU_AREA_3;
				} else
					info("Limit reached on Adding Education Areas!");
			}
		}.setDefaultFormProcessing(false);

		// Adding AJAX on DropDown list.
		eduDropDown.add(new OnChangeAjaxBehavior() {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onUpdate(AjaxRequestTarget target) {

				// Education Areas.
				if (eduAreaState == eduAreaStateEnum.EDU_AREA_0) {
					eduArea1.setModelObject(uPropModel.getEducationChoice());
					target.add(eduArea1);

					// Enable the DropDown List
					eduDropDown.setEnabled(true);
				} else if (eduAreaState == eduAreaStateEnum.EDU_AREA_1) {
					eduArea2.setModelObject(uPropModel.getEducationChoice());
					target.add(eduArea2);

				} else if (eduAreaState == eduAreaStateEnum.EDU_AREA_2) {
					eduArea3.setModelObject(uPropModel.getEducationChoice());
					target.add(eduArea3);
				}

			}

		});

		// Adding Update Button.
		Button eduUpdateButton = new Button("eduUpdate") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				super.onSubmit();

				// Education Areas.
				if (eduAreaState == eduAreaStateEnum.EDU_AREA_1)
					eduArea1.setEnabled(true);

				else if (eduAreaState == eduAreaStateEnum.EDU_AREA_2)
					eduArea2.setEnabled(true);

				else if (eduAreaState == eduAreaStateEnum.EDU_AREA_3)
					eduArea3.setEnabled(true);

			}
		}.setDefaultFormProcessing(false);

		// Adding Education Form.
		Form<Void> eduForm = new Form<Void>("eduForm") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				super.onSubmit();

				try {

					if (eduAreaState == eduAreaStateEnum.EDU_AREA_1)
						info("Education 1 : " + eduArea1.getModelObject());

					else if (eduAreaState == eduAreaStateEnum.EDU_AREA_2) {
						info("Education 1 : " + eduArea1.getModelObject());
						info("Education 2 : " + eduArea2.getModelObject());
					}

					else if (eduAreaState == eduAreaStateEnum.EDU_AREA_3) {
						info("Education 1 : " + eduArea1.getModelObject());
						info("Education 2 : " + eduArea2.getModelObject());
						info("Education 3 : " + eduArea3.getModelObject());
					}

				} catch (NullPointerException ex) {
					info("Exception on Input : " + ex.getLocalizedMessage());
				}

			}

		};
 
		// Adding Next Button.
		Button nextButton = new Button("NextBtn") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				super.onSubmit();
				setResponsePage(ProjectDetails.class);

			}
		}.setDefaultFormProcessing(false);

		// Adding Form Components.
		add(eduForm);
		eduForm.add(eduAddButton);
		eduForm.add(eduDropDown);
		eduForm.add(eduLabel1);
		eduForm.add(eduArea1);
		eduForm.add(eduLabel2);
		eduForm.add(eduArea2);
		eduForm.add(eduLabel3);
		eduForm.add(eduArea3);
		eduForm.add(eduUpdateButton);
		eduForm.add(nextButton);
	}

}
