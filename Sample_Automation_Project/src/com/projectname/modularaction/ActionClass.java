package com.projectname.modularaction;

import com.projectname.pageobject.LoginPage;

public class ActionClass {
	
	public static void loginIntoSalesforce(){
		LoginPage.Username().clear();
		LoginPage.Username().sendKeys("test@gmail.com");
		LoginPage.Password().click();
		LoginPage.Password().sendKeys("test");
//		LoginPage.Submit();
	}

}
