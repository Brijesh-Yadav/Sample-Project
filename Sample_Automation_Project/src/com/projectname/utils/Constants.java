package com.projectname.utils;

public class Constants {
	
	public static String browserName = "firefox";

	public static String firefox = "defualt"; // default/custom
	
	public static String driverName = "remote";
	
	public static String url = "remote";
	
	public static String PrjDirectory = System.getProperty("user.dir"); //To get current directory path
	
	public static String user_Home_directory = System.getProperty("user.home"); //To get home path
	
	public static String chrome_driver = PrjDirectory+"/resources/browser-driver/chrome/chromedriver.exe";
	
	public static String ie_driver = PrjDirectory+"/resources/browser-driver/IE/IEDriverServer_x64_2.44.0.exe";
	
	public static String firefox_custom_path = user_Home_directory;
	
}
