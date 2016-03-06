package com.projectname.utils;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	
	protected static WebDriver driver = null ;
	protected static ThreadLocal<RemoteWebDriver> threadDriver = null;
	
	public static void initialize_webDriver(){
		
		if("firefox".equalsIgnoreCase(Constants.browserName)){
			driver = fireFox();
			
		}else if("chrome".equalsIgnoreCase(Constants.browserName)){
			driver = chrome();
			
		}else if("ie".equalsIgnoreCase(Constants.browserName)){
			driver = ie();
			
		}else {
			System.out.println("Browser instance not found");
		}
	}
	
	public static void initialize_remoteDriver()  throws MalformedURLException {
		threadDriver = new ThreadLocal<RemoteWebDriver>();
		DesiredCapabilities dc = new DesiredCapabilities();
		
		
		if("firefox".equalsIgnoreCase(Constants.browserName)){
			
			FirefoxProfile fp = new FirefoxProfile();
			dc.setCapability(FirefoxDriver.PROFILE, fp);
			dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
				
		}else if("chrome".equalsIgnoreCase(Constants.browserName)){
			
			dc.setJavascriptEnabled(true);
			System.setProperty("webdriver.chrome.driver", "/Users/xxxxx/chromedriver");
			dc = DesiredCapabilities.chrome();
			
		}else if("ie".equalsIgnoreCase(Constants.browserName)){

			dc.setJavascriptEnabled(true);
			System.setProperty("webdriver.ie.driver", "/Users/xxxxx/chromedriver");
			dc = DesiredCapabilities.internetExplorer();
			
		}else {
			System.out.println("Browser instance not found");
		}
		
		threadDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc));
	}
	
	public static WebDriver getDriver() {
		
		if("remote".equalsIgnoreCase(Constants.driverName)){
			return threadDriver.get();	
		}else {
			return driver;
		}
		
	}	 
	
	public static WebDriver fireFox(){
		return driver;
	}
	
	public static WebDriver chrome(){
		return driver;
	}
	
	public static WebDriver ie(){
		return driver;
	}
	
	public static void closeBrowser(){
		driver.close();
	}
	
	public static void quitBrowser(){
		driver.quit();
	}
}
