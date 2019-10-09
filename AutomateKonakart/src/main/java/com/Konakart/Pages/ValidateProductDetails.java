package com.Konakart.Pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Konakart.BrowserSetup.BrowserSetup;
import com.Konakart.Constants.Constants;
import com.Konakart.Helper.Assertion;
import com.Konakart.Properties.ReadProperties;
import com.Konakart.Utilities.ExcelUtils;

/**
 * validate product description ,specification and customer review.
 * 
 * @author indira.saravanan
 *
 */
public class ValidateProductDetails extends BrowserSetup {
	
	@DataProvider
	public Object[][] productDetails() {
		Object data[][] = ExcelUtils.ReadWriteExcel("pro1descriptionandspecification");
		return data;
	}

	@Test(dataProvider = "pro1descriptionandspecifications")
	public static void validateProduct1Detail(String Description, String Specification) throws Exception {
		String des = driver
				.findElement(By
						.xpath(ReadProperties.properties("loc_productdescription_txt", Constants.productdetails_path)))
				.getText();
		System.out.println(""+des);
		Assert.assertEquals(des, Description);
		driver.findElement(By.xpath(ReadProperties.properties("loc_specification_txt", Constants.productdetails_path)))
				.click();
		String spec = driver
				.findElement(By
						.xpath(ReadProperties.properties("loc_productdescription_txt", Constants.productdetails_path)))
				.getText();
		Assertion.assertEqual(spec, Specification);

	}

	@DataProvider
	public Object[][] product2Detail() {
		Object data[][] = ExcelUtils.ReadWriteExcel("pro2descriptionandspecification");
		return data;
	}

	@Test(dataProvider = "product2Detail")
	public static void validateProduct2Detail(String Description, String Specification) throws Exception {
		String des = driver
				.findElement(By
						.xpath(ReadProperties.properties("loc_productdescription_txt", Constants.productdetails_path)))
				.getText();
		Assertion.assertEqual(des, Description);
		driver.findElement(By.xpath(ReadProperties.properties("loc_specification_txt", Constants.productdetails_path)))
				.click();
		String spec = driver
				.findElement(By
						.xpath(ReadProperties.properties("loc_productdescription_txt", Constants.productdetails_path)))
				.getText();
		Assertion.assertEqual(spec, Specification);
	}
}