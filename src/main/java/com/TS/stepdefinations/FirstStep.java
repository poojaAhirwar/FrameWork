package com.TS.stepdefinations;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.TS.utils.FileUtils;
import com.keyword.Keyword;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstStep {
	@Given("Open browser")
	public void openBrowser() {
		Keyword.openBrower("Chrome");

	}

	@When("Launch Url")
	public void launchUrl() {
		Keyword.launchUrl("https://www.carwale.com");
	}

	@Then("Application Should Lunch")
	public void VertifyTitleofHomepage() {
		String actualTitle = Keyword.driver.getTitle();
		String expectedTitle = "New Cars, Used Cars, Buy a Car, Sell Your Car - CarWale";
		Assert.assertEquals(actualTitle, expectedTitle);
		Keyword.driver.close();

	}

	@Then("get the list of popular brands")
	public static void get_the_list_of_popular_brands() {
		Actions act = new Actions(Keyword.driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		Keyword.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Keyword.driver.findElement(By.cssSelector("span[class=\"o-cCFBmR\"]"));
		Keyword.driver.findElement(By.cssSelector("div.o-fzpihx.o-bkmzIL"));
		List<String> otherBrands = Keyword.getTexts("XPATH", FileUtils.getLocator("Carwale.popular_brand_list"));
	}

	@Then("get the list of All brands")
	public static void get_the_list_of_all_brands() {
		Actions act = new Actions(Keyword.driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		Keyword.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Keyword.driver.findElement(By.cssSelector("span[class=\"o-cCFBmR\"]"));
		Keyword.driver.findElement(By.cssSelector("div.o-fzpihx.o-bkmzIL"));
		List<String> popularBrands = Keyword.getTexts("XPATH",
				"(//h6[contains(text(),'OTHER BRANDS')]/following-sibling::ul)[1]/child::li");
	}

	@Then("check if the popular brands comes under all brands")
	public static void check_if_the_popular_brands_comes_under_all_brands() {
		Actions act = new Actions(Keyword.driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		Keyword.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Keyword.driver.findElement(By.cssSelector("span[class=\"o-cCFBmR\"]"));
		Keyword.driver.findElement(By.cssSelector("div.o-fzpihx.o-bkmzIL"));
		List<String> otherBrands = Keyword.getTexts("XPATH", FileUtils.getLocator("Carwale.popular_brand_list"));
		List<String> popularBrands = Keyword.getTexts("XPATH",
				"(//h6[contains(text(),'OTHER BRANDS')]/following-sibling::ul)[1]/child::li");
		Assert.assertTrue(otherBrands.containsAll(popularBrands), "Popular brands comes under all brands");
		Keyword.driver.close();
	}

}
