package com.frameWork;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.TS.utils.FileUtils;
import com.TS.utils.Locator;
import com.keyword.Keyword;

public class CarWale extends TestBase  {
	@Test
	public void verifyCompareCars() {
		 Keyword.launchUrl("https://www.carwale.com");
		Actions act = new Actions(Keyword.driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		Keyword.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		Keyword.clickWebElement("CSS", "button.o-fzpilm.o-bfyaNx.o-cQfblS");
		Keyword.clickWebElement("CSS", "div.o-elzeOy.o-bkmzIL.o-fzpihx");
		Keyword.clickWebElement("CSS", "div[data-make=\"Tata\"]");
		Keyword.clickWebElement("CSS", "li[data-model=\"Altroz\"]");
		Keyword.clickWebElement("XPATH", "//span[contains(text(),'Automatic')]");
		Keyword.clickWebElement("CSS", "p.o-bNxxEB.o-jjpuv");
		Assert.assertTrue(Keyword.getText("CSS", "h1#comparedetailsheading")
				.contains(Keyword.getText("CSS", "li[data-model=\"Altroz\"]")));
	}

	@Test
	public void verifyPopularBrandscomesUnderOtherBrands() {
		//Keyword.openBrower("Chrome");
		//Keyword.launchUrl("https://www.carwale.com");
		Actions act = new Actions(Keyword.driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		Keyword.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Keyword.driver.findElement(By.cssSelector("span[class=\"o-cCFBmR\"]"));
		Keyword.driver.findElement(By.cssSelector("div.o-fzpihx.o-bkmzIL"));
		List<String> otherBrands = Keyword.getTexts("XPATH", FileUtils.getLocator("Carwale.popular_brand_list"));
		List<String> popularBrands = Keyword.getTexts("XPATH",
				"(//h6[contains(text(),'OTHER BRANDS')]/following-sibling::ul)[1]/child::li");
		Assert.assertTrue(otherBrands.containsAll(popularBrands));
	}

	@Test
	public void verifyCountOfReview() {
		Keyword.launchUrl("https://www.carwale.com");
		Keyword.clickWebElement("CSS", "input[placeholder=\"Type to select car name\"]");
		Keyword.enterKey("CSS", "input[placeholder=\"Type to select car name\"]", "Tata Nexon");
		Keyword.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Keyword.clickWebElement("CSS", "div.o-duzCJV.o-bObQsr");
		Keyword.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String Reviews = Keyword.getText("CSS", "a[title=\"User Review of Tata Nexon\"]");
		System.out.println(Reviews);
		Pattern p = Pattern.compile("\\d");
		Matcher m = p.matcher(Reviews);
		int noOfReviews = 0;
		while (m.find())
			noOfReviews = Integer.parseInt(m.group());
		System.out.println(noOfReviews);
		Keyword.clickWebElement("XPATH", "//a[@title=\"Read All User Reviews\"]");
		Actions act = new Actions(Keyword.driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		int actualReviews = Keyword.driver
				.findElements(By.xpath("//li[@class=\"o-cCFBmR oxygen-card-wrapper__item H9UsWX o-bCRRBE o-deKpZW\"]"))
				.size();
		Assert.assertEquals(actualReviews, noOfReviews);

	}

	@Test
	public static void verifySearchCar() {
		String ExpectedCar = "Lexus LX";

		//Keyword.launchUrl("https://www.carwale.com");
		Keyword.clickWebElement("CSS", "input[placeholder=\"Type to select car name\"]");
		Keyword.enterKey("CSS", "input[placeholder=\"Type to select car name\"]", "Lexus LX");
		Keyword.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Keyword.clickWebElement("CSS", "div.o-duzCJV.o-bObQsr");
		Keyword.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String ActualCar = Keyword.getText("CSS", "h1[data-lang-id=\"car_overview_heading\"]");
		Assert.assertEquals(ActualCar, ExpectedCar);
	}

	@Test
	public void verifyLocation() {
		Keyword.launchUrl("https://www.carwale.com");
		Keyword.clickWebElement("CSS", "div[title=\"Location\"]");
		Assert.assertTrue(Keyword.getWebElement("CSS", "div.o-fzpimR.o-jjpuv").isEnabled());
		List<WebElement> cities = Keyword.driver.findElements(By.cssSelector("div.o-NBTwp.o-XylGE.o-cpnuEd>div"));
		for (WebElement city : cities) {
			Assert.assertTrue(city.isEnabled());
		}
	}
}
