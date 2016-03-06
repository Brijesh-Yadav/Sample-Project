package com.projectname.testscript;

import org.testng.annotations.Test;
import com.projectname.modularaction.ActionClass;
import com.projectname.utils.BaseClass;

public class TestScenarios_2 {
	
	@Test
	public void method(){
		
		BaseClass.launch_browser();
		ActionClass.loginIntoSalesforce();
		BaseClass.closeBrowser();
		
	}

}
