package com.Konakart.Testscript;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Konakart.BrowserSetup.BrowserSetup;

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
		
		String ele=driver.findElement(By.xpath("//picture[@id=\"slide-1\"]")).toString();
		System.out.println(""+ele);		
	}
}
