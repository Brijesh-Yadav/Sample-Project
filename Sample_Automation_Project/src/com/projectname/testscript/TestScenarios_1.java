package com.projectname.testscript;

import org.testng.annotations.Test;
import com.projectname.utils.Logger;

public class TestScenarios_1 {
	
	@Test
	public void method() throws InterruptedException{
		Logger.info("This is test logger");
		Thread.sleep(1000);
		Logger.info("This is test logger");
		Thread.sleep(1000);
		Logger.info("This is test logger");
		Thread.sleep(1000);
		Logger.info("This is test logger");
		Thread.sleep(1000);
		Logger.info("This is test logger");
		
	}

}
