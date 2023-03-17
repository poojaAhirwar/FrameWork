package com.TS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.keyword.Keyword;

public class HomePage {

	@FindBy(css = "li.nS6XVS:nth-child(1)>div")
	public static WebElement newCarMenu;

	public static void hoverOnNewCarMenu() {
		Keyword.hoverOn(newCarMenu);
	}

	public static void clickOnNewCarMenu() {
		newCarMenu.click();
	}

	@FindBy(css = "li.nS6XVS:nth-child(2)>div")
	public static WebElement usedCarMenu;

	public static void hoverOnUsedCarMenu() {
		Keyword.hoverOn(usedCarMenu);
	}

	public void clickOnUsedCarMenu() {
		usedCarMenu.click();
	}

	@FindBy(css = "div[title=\"Location\"]")
	public static WebElement locationMenu;

	public static void clickOnLocationMenu() {
		locationMenu.click();
	}

	@FindBy(css = "div.o-fzptZU ")
	public static WebElement loginMenu;

	public static void clickOnLoginMenu() {
		loginMenu.click();
	}

	@FindBy(css = "placeholder=\"Search\"")
	public static WebElement searchBoxOnNavBar;

	public static void clickOnSearchBoxOnNavBar() {
		searchBoxOnNavBar.click();
	}
}
