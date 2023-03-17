package com.TS.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {

	/**
	 * use this method to get the locators from OR.properties files. Pass the key of
	 * locator that you want
	 * 
	 * @param locator
	 * @return value of locator
	 */
	public static String getLocator(String locator) {
		String baseDir = System.getProperty("user.dir");
		String locatorValue = "";
		try {
			FileInputStream fis = new FileInputStream(baseDir + "/src/main/resorces/OR.properties");
			Properties prop = new Properties();
			prop.load(fis);
			locatorValue = prop.getProperty(locator);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return locatorValue;
	}

	
	/**
	 * this method is used to get the url or to select the enviorment.
	 * @param env
	 * @return
	 */
	public static String getAppUrl(String env) {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream("F:\\Testing\\FrameWork\\src\\main\\resources\\app.properties");
			prop = new Properties();
			prop.load(fis);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty("app." + env + ".url");
	}

}
