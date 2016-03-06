package com.projectname.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.projectname.utils.BaseClass;

public class LoginPage extends BaseClass{
	
	private static WebElement element = null;
	
	public static WebElement Username(){
		element = getDriver().findElement(By.id("username"));
		return element;
	}
	
	public static WebElement Password(){
		element = getDriver().findElement(By.id("password"));
		return element;
	}
	
	public static WebElement Submit(){
		element = getDriver().findElement(By.id("Login"));
		return element;
	}
	
}
