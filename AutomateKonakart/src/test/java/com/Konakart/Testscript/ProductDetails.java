package com.Konakart.Testscript;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Konakart.BrowserSetup.BrowserSetup;
import com.Konakart.Constants.Constants;
import com.Konakart.Helper.Assertion;
import com.Konakart.Helper.ClickOperation;
import com.Konakart.Properties.ReadProperties;
import com.Konakart.Utilities.ExcelUtils;

/**
 * Validate product description content. Validate product specification content.
 * Validate product review by sort it with all combinations.
 * 
 * @author indira.saravanan
 *
 */

public class ProductDetails extends BrowserSetup {

	private String description;
	private String specification;

	
	public void clickHeroImage() throws Exception {
		driver.findElement(By.xpath(ReadProperties.properties("loc_heroimage_img", Constants.productdetails_path)))
				.click();

		String productName = driver
				.findElement(
						By.xpath(ReadProperties.properties("loc_producttitle_text", Constants.productdetails_path)))
				.getText();
		System.out.println("" + productName);

		if (productName.equalsIgnoreCase(productName)) {
			validateProduct1Detail(description, specification);
		} else {
			validateProduct2Detail(description, specification);
		}
	}


	public Object[][] productDetails() {
		Object data[][] = ExcelUtils.ReadWriteExcel("pro1descriptionandspecification");
		return data;
	}

	@Test(dataProvider = "productDetails")
	public static void validateProduct1Detail(String Description, String Specification) throws Exception {
		String des = driver
				.findElement(
						By.id(ReadProperties.properties("loc_productdescription_txt", Constants.productdetails_path)))
				.getText();
		System.out.println("" + des);
		Assert.assertEquals(des, Description);
		driver.findElement(By.xpath(ReadProperties.properties("loc_specification_txt", Constants.productdetails_path)))
				.click();
		String spec = driver
				.findElement(By
						.xpath(ReadProperties.properties("loc_productdescription_txt", Constants.productdetails_path)))
				.getText();
		Assertion.assertEqual(spec, Specification);
	}

	
	public Object[][] product2Detail() {
		Object data[][] = ExcelUtils.ReadWriteExcel("pro2descriptionandspecification");
		return data;
	}


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
