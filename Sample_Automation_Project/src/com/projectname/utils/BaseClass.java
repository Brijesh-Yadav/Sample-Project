package com.projectname.utils;

import java.io.File;
import java.net.URL;
import java.util.logging.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	
	protected static WebDriver driver = null ;
	protected static ThreadLocal<RemoteWebDriver> threadDriver = null;
	
	public static void launch_browser(){
		if("remote".equalsIgnoreCase(Constants.driverName)){
			initialize_remoteDriver();
		}else {
			initialize_webDriver();
		}
		Logger.info(Constants.browserName+" browser is launched!!");
	}
	
	public static void initialize_webDriver(){
		boolean flag = true;
		if("firefox".equalsIgnoreCase(Constants.browserName)){
			driver = fireFox();
		}else if("chrome".equalsIgnoreCase(Constants.browserName)){
			driver = chrome();
		}else if("ie".equalsIgnoreCase(Constants.browserName)){
			driver = ie();
		}else {
			flag=false;
			Logger.warn("Browser instance not found");
		}
		if(flag!=false){
			Logger.info("WebDriver is initialized!!");
		}
	}
	
	public static void initialize_remoteDriver(){
		
		try{
			boolean flag = true;
			threadDriver = new ThreadLocal<RemoteWebDriver>();
			DesiredCapabilities dc = new DesiredCapabilities();
			//set firefox browsers
			if("firefox".equalsIgnoreCase(Constants.browserName)){
				dc = return_DesiredCapabilities_firefox();
			//set chrome browser	
			}else if("chrome".equalsIgnoreCase(Constants.browserName)){
				System.setProperty("webdriver.chrome.driver", Constants.chrome_driver);
				dc = return_DesiredCapabilities_chrome();
			//set Internet Explorer browser	
			}else if("ie".equalsIgnoreCase(Constants.browserName)){
				System.setProperty("webdriver.ie.driver", Constants.ie_driver);
				dc = return_DesiredCapabilities_ie();
			}else {
				Logger.warn("Browser instance not found");
			}
			
			threadDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc));
			
			if(getDriver()!=null){
				getDriver().manage().window().maximize();
				getDriver().get(Constants.url);
			}else {
				flag = false;
			}
			
			if(flag!=false){
				Logger.info("Remote WebDriver is initialized!!");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static WebDriver getDriver() {
		if("remote".equalsIgnoreCase(Constants.driverName)){
			return threadDriver.get();	
		}else {
			return driver;
		}
	}	 
	
	public static WebDriver fireFox(){
		if("custom".equalsIgnoreCase(Constants.firefox)){
			File firefox_file = new File(Constants.firefox_custom_path);
			FirefoxBinary binary = new FirefoxBinary(firefox_file);
			FirefoxProfile ffox_profile = new FirefoxProfile();
			driver = new FirefoxDriver(binary,ffox_profile);
		}else {
			DesiredCapabilities caps = return_DesiredCapabilities_firefox();
			driver = new FirefoxDriver(caps);
		}
		driver.manage().window().maximize();
		driver.get(Constants.url);
		return driver;
	}
	
	public static WebDriver chrome(){
		System.setProperty("webdriver.chrome.driver",Constants.chrome_driver);
		DesiredCapabilities caps = return_DesiredCapabilities_chrome();
		driver = new ChromeDriver(caps);
		driver.manage().window().maximize();
		driver.get(Constants.url);
		return driver;
	}
	
	public static WebDriver ie(){
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY,Constants.ie_driver);
		DesiredCapabilities capab = return_DesiredCapabilities_ie();
		driver = new InternetExplorerDriver(capab);
		driver.manage().deleteAllCookies();
		driver.get(Constants.url);
		return driver;
	}

	public static DesiredCapabilities return_DesiredCapabilities_firefox(){
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setJavascriptEnabled(true);
		FirefoxProfile fp = new FirefoxProfile();
		cap.setCapability(FirefoxDriver.PROFILE, fp);
		cap.setBrowserName(cap.getBrowserName());
		return cap;
	}
	
	public static DesiredCapabilities return_DesiredCapabilities_ie(){
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setJavascriptEnabled(true);
		cap.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true); 
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		cap.setCapability("ignoreZoomSetting", true);
		cap.setCapability("nativeEvents",false);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return cap;
	}
	
	public static DesiredCapabilities return_DesiredCapabilities_chrome(){
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setJavascriptEnabled(true);
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        return caps;
	}

	public static void closeBrowser(){
		getDriver().close();
		Logger.info(Constants.browserName+" browser window has been closed!!");
	}
	
	public static void quitBrowser(){
		getDriver().quit();
		Logger.info(Constants.browserName+" browser has been quit!!");
	}
	
}
