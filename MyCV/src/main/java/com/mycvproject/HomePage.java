package com.mycvproject;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	//Adding Form.
	Form<Void> cvForm = new Form<Void>("cvForm");
	
	public HomePage() {
	
		//Adding Links to Details Page.
		Link<String> basicDetailsLink = new Link<String>("basicLink") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(BasicDetails.class);
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
		
	add(basicDetailsLink);
	add(educationDetailsLink);
	add(projectDetailsLink);
	}
	
}
