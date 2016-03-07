package utils;

import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

final public class Logger {
	
	public static String currPrjDirpath = System.getProperty("user.dir"); //To get current directory path
	public static String logfilepath = "";
	
	final public static void createLogFile() {
		try {
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
			// get current date time with Date()
			Date date = new Date();
			String datevalue = dateFormat.format(date);
			// System.out.println(datevalue);

			DateFormat datetime = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
			// get current date time with Calendar()
			Calendar cal = Calendar.getInstance();
			String date_time = datetime.format(cal.getTime());
			// System.out.println(date_time);
			String logfolder = currPrjDirpath + File.separator
					+ "log" + File.separator + datevalue + File.separator;
			
			File logfld = new File(logfolder);
			if (!logfld.exists()) {
				logfld.mkdirs();
//				System.out.println("Log folder path is created!!");
			} else {
//				System.out.println("Log folder path is already created!!");
			}
			String logfilpth = logfolder + date_time + ".txt";
			File logfile = new File(logfilpth);
			
			// if file doesnt exists, then create it
			if (!logfile.exists()) {
				logfile.createNewFile();
			}
			//create log file path autoit log genration
			createlog_filepath_forautoit(logfilpth);
			// set logfolder path
			logfilepath = logfilpth;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	final public static void info(String mssg) {
		if(logfilepath.length()==0){
			createLogFile();
		}
		System.out.println("info : " + mssg);
		log("info : " + mssg);
	}

	final public static void warn(String mssg) {
		if(logfilepath.length()==0){
			createLogFile();
		}
		System.out.println("warn : " + mssg);
		log("warn : " + mssg);
	}

	final public static void error(String mssg) {
		if(logfilepath.length()==0){
			createLogFile();
		}
		System.out.println("error : " + mssg);
		log("error : " + mssg);
	}
	
	final public static void error(String mssg, Throwable e) {
		if(logfilepath.length()==0){
			createLogFile();
		}
		System.out.println("error : " + mssg + " " + e);
		log("error : " + mssg + " " + e);
	}
	
	final public static void error(Throwable e) {
		if(logfilepath.length()==0){
			createLogFile();
		}
		System.out.println("error : "+ e);
		log("error : "+ e);
	}

	final public static void fatal(String mssg, Throwable e) {
		if(logfilepath.length()==0){
			createLogFile();
		}
		System.out.println("fatal : " + mssg + " " + e);
		log("fatal : " + mssg + " " + e);
	}

	// Creates log 
	public static void log(String loddata) {
		try {
			String filpath = logfilepath;
//			System.out.println(" file path :: "+filpath);
			TimeZone tz = TimeZone.getTimeZone("IST"); // or PST, MID, etc ...
			Date now = new Date();
			DateFormat df = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss  ");
			df.setTimeZone(tz);
			String currentTime = df.format(now);
			FileWriter aWriter = new FileWriter(filpath, true);
			aWriter.write(currentTime + " " + loddata + "\n");
			aWriter.flush();
			aWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Log | Exception " + e.getStackTrace());
		}
	}
	
	public static void createlog_filepath_forautoit(String logfilepath) {
		try {
			String path = currPrjDirpath + File.separator
					+ "resources" + File.separator + "autoit" + File.separator
					+ "compiled_file" + File.separator;

			File folder_chk = new File(path);
			
			if(!folder_chk.exists()){
				System.out.println(path+" folder does not exist");
			}
			
			// create logfile path for generic function
			File file3 = new File(path);
			if (file3.exists()) {
				String filepath = path  + "logfilepath.txt";
				File creatfle = new File(filepath);
				// first deleting the file if exist
				if (creatfle.exists()) {
					creatfle.delete();
				}
				// if does not exit then create it
				if (!creatfle.exists()) {
					creatfle.createNewFile();
					FileWriter aWriter = new FileWriter(filepath, true);
					aWriter.write(logfilepath);
					aWriter.flush();
					aWriter.close();
				}
			}
			//create file for others
			File file = new File(path);
			String[] names = file.list();
			boolean flag = false;
			for (String name : names) {
				if (new File(path + name).isDirectory()) {
					String filepath = path + name + File.separator
							+ "logfilepath.txt";
					File creatfle = new File(filepath);
					// first deleting the file if exist
					if (creatfle.exists()) {
						creatfle.delete();
					}
					// if does not exit then create it
					if (!creatfle.exists()) {
						creatfle.createNewFile();
						FileWriter aWriter = new FileWriter(filepath, true);
						aWriter.write(logfilepath);
						aWriter.flush();
						aWriter.close();
						flag = true;
					}
				}
			}

			if (flag != true) {
//				System.out.println("Log filepath for autoit is already created, so not creatd new file");
			} else {
//				System.out.println("New log filepath for autoit is created!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
