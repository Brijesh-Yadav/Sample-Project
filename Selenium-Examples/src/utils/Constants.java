package utils;

public class Constants {
	
	public static String browserName = "chrome"; // chrome or firefox or ie

	public static String firefox = "defualt"; // default or custom
	
	public static String driverName = "remote"; //local or remote
	
	public static String url = "https://login.salesforce.com/";
	
	public static String PrjDirectory = System.getProperty("user.dir"); //To get current directory path
	
	public static String user_Home_directory = System.getProperty("user.home"); //To get home path
	
	public static String chrome_driver = PrjDirectory+"/resources/browser-driver/chrome/chromedriver.exe"; // chrome driver parth
	
	public static String ie_driver = PrjDirectory+"/resources/browser-driver/IE/IEDriverServer_x64_2.44.0.exe"; //  ie driver path
	
	public static String firefox_custom_path = user_Home_directory; // home directory path
	
}
