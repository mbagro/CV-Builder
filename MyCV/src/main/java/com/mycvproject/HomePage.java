package com.mycvproject;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;
	protected static UserModel uModel = new UserModel();
	
	//Adding Form.
	Form<Void> cvForm = new Form<Void>("cvForm");
	
	public HomePage() {
	
		//Adding Links to Details Page.
		Link<String> basicDetailsLink = new Link<String>("basicLink") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(new BasicDetails(uModel));
			}
		};
		
		Link<String> educationDetailsLink = new Link<String>("educationLink") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(EducationDetails.class);
			}
		};

		
		Link<String> projectDetailsLink = new Link<String>("projectLink") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(ProjectDetails.class);
			}
		};
		
		Link<String> cvPageLink = new Link<String>("cvPageLink") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(CVUserDetails.class);
			}
		};
		
	add(basicDetailsLink);
	add(educationDetailsLink);
	add(projectDetailsLink);
	add(cvPageLink);
	}
	
}
