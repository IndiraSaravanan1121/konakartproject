package com.Konakart.Testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Konakart.BrowserSetup.BrowserSetup;
import com.Konakart.Constants.Constants;
import com.Konakart.Helper.ClickOperation;
import com.Konakart.Helper.SelectValue;
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
		Object data[][] = ExcelUtils.ReadWriteExcel("positive search item");
		return data;
	}

	@Test(dataProvider = "possibleValues", priority = 1)
	public void positiveProductOutcome(String categories,String value) throws Exception {
		ClickOperation.click("id", ReadProperties.properties("loc_dropdownlist_btn", Constants.productoutcome_path));
		SelectValue.selectValueByVisibleText(driver, ReadProperties.properties("loc_dropdownlist_btn", Constants.productoutcome_path), "id", categories);
		WebElement element = driver
				.findElement(By.xpath(ReadProperties.properties("loc_searchbox_txt", Constants.productoutcome_path)));
		ValidateProductOutcome.validatePositiveCase(element, value);
	}
	
	
	@DataProvider
	public Object[][] negativeValues() throws Exception {
		Object data[][] = ExcelUtils.ReadWriteExcel("negative search item");
		return data;
	}

	@Test(dataProvider = "negativeValues", priority = 2)
	public void negativeProductOutcome(String categories,String value) throws Exception {
		ClickOperation.click("id", ReadProperties.properties("loc_dropdownlist_btn", Constants.productoutcome_path));
		SelectValue.selectValueByVisibleText(driver, ReadProperties.properties("loc_dropdownlist_btn", Constants.productoutcome_path), "id", categories);
		WebElement element = driver
				.findElement(By.xpath(ReadProperties.properties("loc_searchbox_txt", Constants.productoutcome_path)));
		ValidateProductOutcome.validateNegativeCase(element, value);
	}

}
