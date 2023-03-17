package com.frameWork;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.TS.pages.HomePage;
import com.keyword.Keyword;

public class Amazon extends TestBase {

	@Test(dataProvider = "UserData", dataProviderClass = Data_Provider.class)
	public static void verifyLogIn(String names) {
		Keyword.clickWebElement("CSS", "a[data-nav-ref=\"nav_ya_signin\"]");
		Keyword.enterKey("CSS", "input[type=\"email\"]", names);
		Keyword.clickWebElement("CSS", "span#continue");
		Keyword.getText("CSS", "h4[class=\"a-alert-heading\"]");
		if (Keyword.getWebElement("CSS", "h4[class=\"a-alert-heading\"]").isDisplayed()) {
			System.out.println(Keyword.getText("CSS", "h4[class=\"a-alert-heading\"]"));
		} else {
			Keyword.clickWebElement("CSS", "span#auth-signin-button");
			Keyword.enterKey("CSS", "input[name=\"password\"]", "Naktu@2828");
			Keyword.clickWebElement("CSS", "input[id=\"signInSubmit\"]");
			Assert.assertEquals(Keyword.getText("CSS", "span[id=\"nav-link-accountList-nav-line-1\"]"),
					"Hello, ahirwarpooja@gmail.com");
		}

	}

	@Ignore
	@Test
	public void verifyProductsInCart() {
		Amazon.verifyLogIn("ahirwarpooja@gmail.com");
		String count = Keyword.getText("CSS", "span#nav-cart-count");
		System.out.println(Keyword.getText("CSS", "span#nav-cart-count"));
		Keyword.clickWebElement("CSS", "input[type=\"text\"]");
		Keyword.enterKey("CSS", "input[type=\"text\"]", "smart watch");
		Keyword.clickWebElement("CSS", "input#nav-search-submit-button");
		Keyword.impicite_wait(3);
		Keyword.clickWebElement("XPATH",
				"a[href=\"/Fire-Boltt-Phoenix-Bluetooth-Calling-Monitoring/dp/B0B3RRWSF6/ref=sr_1_4?keywords=smart+watch&qid=1675786441&sprefix=s%2Caps%2C259&sr=8-4\"] span[class=\"a-price-whole\"]");
		String cost = Keyword.getText("XPATH",
				"a[href=\"/Fire-Boltt-Phoenix-Bluetooth-Calling-Monitoring/dp/B0B3RRWSF6/ref=sr_1_4?keywords=smart+watch&qid=1675786441&sprefix=s%2Caps%2C259&sr=8-4\"] span[class=\"a-price-whole\"]");
		System.out.println(cost);
		String parent = Keyword.driver.getWindowHandle();
		Set<String> s = Keyword.driver.getWindowHandles();
		Iterator<String> Itr = s.iterator();
		while (Itr.hasNext()) {
			String childWindow = (String) Itr.next();
			if (!parent.equals(childWindow)) {
				Keyword.driver.switchTo().window(childWindow);
				Keyword.selectElementFromDropDownByIndex("CSS", "select[name=\"quantity\"]", 0);
				Keyword.clickWebElement("CSS", "input[name=\"submit.add-to-cart\"]");
				String newCount = Keyword.getText("CSS", "span#nav-cart-count");
				System.out.println(newCount.compareToIgnoreCase(count));

				Assert.assertTrue(false);
			}
		}

	}

	@Test
	public void verifyCreatAccount() {
		Keyword.clickWebElement("CSS", "a[data-nav-ref=\"nav_ya_signin\"]");
		Keyword.clickWebElement("CSS", "a#createAccountSubmit");

		Keyword.enterKey("CSS", "input[type=\"text\"]", "Maya");
		Keyword.clickWebElement("CSS", "span[data-action=\"a-dropdown-button\"]");
		Keyword.getWebElements("CSS", "li[role=\"option\"]", "India +91");
		Keyword.enterKey("CSS", "input[placeholder=\"Mobile number\"]", "8375023485");
		Keyword.enterKey("CSS", "input[type=\"password\"]", "Maya@12234");
		Keyword.clickWebElement("CSS", "span[id=\"auth-continue\"] span input");
		Keyword.impicite_wait(10);
		Assert.assertTrue(Keyword.getWebElement("CSS", "a[id=\"auth-resend-code-link\"]").isEnabled());
		Assert.assertTrue(Keyword.getWebElement("CSS", "input[name=\"code\"]").isEnabled());
		String expected = "Verify mobile number";
		Assert.assertEquals(Keyword.getText("CSS", "div[class=\"a-box-inner\"] h1"), expected);
	}

	@Test
	public void verifyAllNavigationMenu() {
		Keyword.clickWebElement("CSS", "a[href=\"javascript: void(0)\"]");
//Keyword.getTexts("CSS", "div[class=\"hmenu-item hmenu-title \"]");
		System.out.println(Keyword.getTexts("CSS", "ul[class=\"hmenu hmenu-visible\"] li"));

	}

}
