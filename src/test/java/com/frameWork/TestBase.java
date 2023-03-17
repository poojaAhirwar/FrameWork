package com.frameWork;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.TS.utils.FileUtils;
import com.keyword.Keyword;

public class TestBase {
	@BeforeMethod
	public void launchBrowser() {
		String env = System.getProperty("env");
		Keyword.openBrower("Chrome");
		Keyword.launchUrl(FileUtils.getAppUrl(env));
	}

	@AfterMethod
	public void tearDownMethod() throws Exception {
		Keyword.driver.close();
	}
}
