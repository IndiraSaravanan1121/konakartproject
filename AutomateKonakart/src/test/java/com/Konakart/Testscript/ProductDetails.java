package com.Konakart.Testscript;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Konakart.BrowserSetup.BrowserSetup;
import com.Konakart.Constants.Constants;
import com.Konakart.Pages.ValidateProductDetails;
import com.Konakart.Properties.ReadProperties;

/**
 * Validate product description content. Validate product specification content.
 * Validate product review by sort it with all combinations.
 * 
 * @author indira.saravanan
 *
 */

public class ProductDetails extends BrowserSetup {
	static String description ;
	static String specification ;

	@Test
	public void validateproduct() throws Exception {

		if (driver
				.findElement(By.xpath(
						ReadProperties.properties("loc_heroimagecoffeemaker_img", Constants.pathProperties_file)))
				.isDisplayed()) {
			ValidateProductDetails.validateProductDetails(description, specification);
		}
		else {
			ValidateProductDetails.validateProductDetail(description, specification);

		}

	}
}
