package com.Konakart.Testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Konakart.BrowserSetup.BrowserSetup;
import com.Konakart.Constants.Constants;
import com.Konakart.Helper.ClickOperation;
import com.Konakart.Pages.ValidateProductOutcome;
import com.Konakart.Properties.ReadProperties;
import com.Konakart.Utilities.ExcelUtils;

/**
 * Validate product outcome with positive and negative value.
 * 
 * @author indira.saravanan
 *
 */
public class ProductOutcome extends BrowserSetup {

	// It read value from excel sheet.
	@DataProvider
	public Object[][] possibleValues() throws Exception {
		Object data[][] = ExcelUtils.ReadWriteExcel("Sheet1");
		return data;
	}

	@Test(dataProvider = "possibleValues", priority = 1)
	public void positiveProductOutcome(String text,String value) throws Exception {
		ClickOperation.click("XPath", ReadProperties.properties("loc_dropdownlist_btn", Constants.pathProperties_file));
		Select select = new Select(driver.findElement(
				By.xpath(ReadProperties.properties("loc_dropdownlist_btn", Constants.pathProperties_file))));
		select.selectByVisibleText(text);
		WebElement element = driver
				.findElement(By.xpath(ReadProperties.properties("loc_searchbox_txt", Constants.pathProperties_file)));
		ValidateProductOutcome.validatePositiveCase(element, value);
	}
	
	
	@DataProvider
	public Object[][] negativeValues() throws Exception {
		Object data[][] = ExcelUtils.ReadWriteExcel("Sheet4");
		return data;
	}

	@Test(dataProvider = "negativeValues", priority = 2)
	public void negativeProductOutcome(String text,String value) throws Exception {
		ClickOperation.click("XPath", ReadProperties.properties("loc_dropdownlist_btn", Constants.pathProperties_file));
		Select select = new Select(driver.findElement(
				By.xpath(ReadProperties.properties("loc_dropdownlist_btn", Constants.pathProperties_file))));
		select.selectByVisibleText(text);
		WebElement element = driver
				.findElement(By.xpath(ReadProperties.properties("loc_searchbox_txt", Constants.pathProperties_file)));
		ValidateProductOutcome.validateNegativeCase(element, value);
	}

}
