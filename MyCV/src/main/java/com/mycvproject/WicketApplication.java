package com.mycvproject;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;


public class WicketApplication extends WebApplication{

	@Override
	public Class<? extends Page> getHomePage() {
		// TODO Auto-generated method stub
		return HomePage.class;
	}
	
}
