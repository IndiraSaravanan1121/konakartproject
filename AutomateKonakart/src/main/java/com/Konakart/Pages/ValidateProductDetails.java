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

public class ValidateProductDetails extends BrowserSetup {

	@DataProvider
	public Object[][] productDetails() {
		Object data[][] = ExcelUtils.ReadWriteExcel("Sheet2");
		return data;
	}

	@Test(dataProvider = "productDetails")
	public static void validateProductDetails(String Description, String Specification) throws Exception {
		driver.findElement(By.xpath(ReadProperties.properties("loc_heroimg_img", Constants.pathProperties_file)))
				.click();
		String des = driver
				.findElement(By
						.xpath(ReadProperties.properties("loc_productdescription_txt", Constants.pathProperties_file)))
				.getText();
		Assert.assertEquals(des, Description);
		driver.findElement(By.xpath(ReadProperties.properties("loc_specification_txt", Constants.pathProperties_file)))
				.click();
		String spec = driver
				.findElement(By
						.xpath(ReadProperties.properties("loc_productdescription_txt", Constants.pathProperties_file)))
				.getText();
		Assertion.assertEqual(spec, Specification);

	}

	@DataProvider
	public Object[][] productDetail() {
		Object data[][] = ExcelUtils.ReadWriteExcel("Sheet3");
		return data;
	}

	@Test(dataProvider = "productDetail")
	public static void validateProductDetail(String Description, String Specification) throws Exception {
		driver.findElement(By.xpath(ReadProperties.properties("loc_heroimg_img", Constants.pathProperties_file)))
				.click();
		String des = driver
				.findElement(By
						.xpath(ReadProperties.properties("loc_productdescription_txt", Constants.pathProperties_file)))
				.getText();
		Assertion.assertEqual(des, Description);
		driver.findElement(By.xpath(ReadProperties.properties("loc_specification_txt", Constants.pathProperties_file)))
				.click();
		String spec = driver
				.findElement(By
						.xpath(ReadProperties.properties("loc_productdescription_txt", Constants.pathProperties_file)))
				.getText();
		Assertion.assertEqual(spec, Specification);
	}
}