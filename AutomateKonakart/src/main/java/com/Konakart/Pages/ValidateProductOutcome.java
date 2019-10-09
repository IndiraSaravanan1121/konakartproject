package com.Konakart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Konakart.BrowserSetup.BrowserSetup;
import com.Konakart.Constants.Constants;
import com.Konakart.Helper.ClickOperation;
import com.Konakart.Properties.ReadProperties;

public class ValidateProductOutcome extends BrowserSetup {

	public static void validatePositiveCase(WebElement element, String value) throws Exception {
		element.sendKeys(value);
		ClickOperation.click("xpath", ReadProperties.properties("loc_search_btn", Constants.pathProperties_file));
		String title = driver
				.findElement(By.className(ReadProperties.properties("loc_itemtitle_txt", Constants.pathProperties_file)))
				.getText();
		Assert.assertEquals(title, value);
		log.logReport(title);
	}

	public static void validateNegativeCase(WebElement element, String value) throws Exception {
		element.sendKeys(value);
		ClickOperation.click("xpath", ReadProperties.properties("loc_search_btn", Constants.pathProperties_file));
		String itemmessage = driver
				.findElement(By.className(ReadProperties.properties("loc_itemmessage_txt", Constants.pathProperties_file)))
				.getText();
		log.logReport(itemmessage);
	}
}
