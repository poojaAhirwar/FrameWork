package com.keyword;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sound.midi.SysexMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class Keyword {

	public static WebDriver driver;

	public static void openBrower(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Sarfari")) {
			driver = new SafariDriver();
		} else {
			System.err.println("Invalid browser name:" + browserName);
		}
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void hoverOn(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public static String getText(String locatorType, String locatorValue) {
		return getWebElement(locatorType, locatorValue).getText();
	}

	public static List<String> getTexts(String locatorType, String locatorValue) {
		List<String> texts = new ArrayList<String>();
		List<WebElement> elements = new ArrayList<WebElement>();

		if (locatorType.equalsIgnoreCase("ID"))
			elements = driver.findElements(By.id(locatorValue));
		else if (locatorType.equalsIgnoreCase("CLASS"))
			elements = driver.findElements(By.className(locatorType));
		else if (locatorType.equalsIgnoreCase("NAME"))
			elements = driver.findElements(By.name(locatorType));

		else if (locatorType.equalsIgnoreCase("TAGNAME"))
			elements = driver.findElements(By.tagName(locatorType));

		else if (locatorType.equalsIgnoreCase("LINKTEXT"))
			elements = driver.findElements(By.linkText(locatorType));

		else if (locatorType.equalsIgnoreCase("PARTIALLINKTEXT"))
			elements = driver.findElements(By.partialLinkText(locatorType));

		else if (locatorType.equalsIgnoreCase("XPATH"))
			elements = driver.findElements(By.xpath(locatorType));

		else if (locatorType.equalsIgnoreCase("CSS"))
			elements = driver.findElements(By.cssSelector(locatorType));

		else
			return null;
		for (WebElement element : elements) {
			texts.add(element.getText());
		}
		return texts;
	}

	public static void enterKey(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);

	}

	public static void clickWebElement(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}

	public static WebElement getWebElement(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("ID"))
			return driver.findElement(By.id(locatorValue));
		else if (locatorType.equalsIgnoreCase("CLASS"))
			return driver.findElement(By.className(locatorValue));
		else if (locatorType.equalsIgnoreCase("NAME"))
			return driver.findElement(By.name(locatorValue));

		else if (locatorType.equalsIgnoreCase("TAGNAME"))
			return driver.findElement(By.tagName(locatorValue));

		else if (locatorType.equalsIgnoreCase("LINKTEXT"))
			return driver.findElement(By.linkText(locatorValue));

		else if (locatorType.equalsIgnoreCase("PARTIALLINKTEXT"))
			return driver.findElement(By.partialLinkText(locatorValue));

		else if (locatorType.equalsIgnoreCase("XPATH"))
			return driver.findElement(By.xpath(locatorValue));

		else if (locatorType.equalsIgnoreCase("CSS"))
			return driver.findElement(By.cssSelector(locatorValue));
		else
			return null;
	}

	public static void selectElementFromDropDownByIndex(String locatorType, String locatorValue, int index) {
		Select select = new Select(Keyword.getWebElement(locatorType, locatorValue));
		select.selectByIndex(index);
	}

	public static void selectElementFromDropDownByVisibleText(String locatorType, String locatorValue, String text) {
		Select select = new Select(Keyword.getWebElement(locatorType, locatorValue));
		select.selectByVisibleText(text);
	}

	public static void selectElementFromDropDownByValue(String locatorType, String locatorValue, String value) {
		Select select = new Select(Keyword.getWebElement(locatorType, locatorValue));
		select.selectByValue(value);
	}

	public static void impicite_wait(int sec) {
		Keyword.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}

	public static void getWebElements(String locatorType, String locatorValue, String option) {
		List<WebElement> allOptions = new ArrayList<WebElement>();
		if (locatorType.equalsIgnoreCase("ID"))
			allOptions = driver.findElements(By.id(locatorValue));
		else if (locatorType.equalsIgnoreCase("CLASS"))
			allOptions = driver.findElements(By.className(locatorType));
		else if (locatorType.equalsIgnoreCase("NAME"))
			allOptions = driver.findElements(By.name(locatorType));

		else if (locatorType.equalsIgnoreCase("TAGNAME"))
			allOptions = driver.findElements(By.tagName(locatorType));

		else if (locatorType.equalsIgnoreCase("LINKTEXT"))
			allOptions = driver.findElements(By.linkText(locatorType));

		else if (locatorType.equalsIgnoreCase("PARTIALLINKTEXT"))
			allOptions = driver.findElements(By.partialLinkText(locatorType));

		else if (locatorType.equalsIgnoreCase("XPATH"))
			allOptions = driver.findElements(By.xpath(locatorType));

		else if (locatorType.equalsIgnoreCase("CSS"))
			allOptions = driver.findElements(By.cssSelector(locatorType));

		for (WebElement option1 : allOptions) {
			if (option1.getText().contains(option)) {

				option1.click();
			}
		}
	}
}
