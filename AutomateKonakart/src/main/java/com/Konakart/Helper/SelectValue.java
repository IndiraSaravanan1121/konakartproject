package com.Konakart.Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectValue {
	static Select select;

	public static void selectValueByIndex(WebDriver driver, String element, String locatorType,
			int index) {
		try {
			switch (locatorType) {
			case "className":
				select = new Select(driver.findElement(By.className(element)));
				select.selectByIndex(index);
				break;
			case "cssSelector":
				select = new Select(driver.findElement(By.cssSelector(element)));
				select.selectByIndex(index);
				break;
			case "id":
				select = new Select(driver.findElement(By.id(element)));
				select.selectByIndex(index);
				break;
			case "linkText":
				select = new Select(driver.findElement(By.linkText(element)));
				select.selectByIndex(index);
				break;
			case "name":
				select = new Select(driver.findElement(By.name(element)));
				select.selectByIndex(index);
				break;
			case "partialLinkText":
				select = new Select(driver.findElement(By.partialLinkText(element)));
				select.selectByIndex(index);
				break;
			case "tagName":
				select = new Select(driver.findElement(By.tagName(element)));
				select.selectByIndex(index);
				break;
			case "xpath":
				select = new Select(driver.findElement(By.xpath(element)));
				select.selectByIndex(index);
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void selectValueByValues(WebDriver driver, String element, String locatorType,
			String value) {
		try {
			switch (locatorType) {
			case "className":
				select = new Select(driver.findElement(By.className(element)));
				select.selectByValue(value);
				break;
			case "cssSelector":
				select = new Select(driver.findElement(By.cssSelector(element)));
				select.selectByValue(value);
				break;
			case "id":
				select = new Select(driver.findElement(By.id(element)));
				select.selectByValue(value);
				break;
			case "linkText":
				select = new Select(driver.findElement(By.linkText(element)));
				select.selectByValue(value);
				break;
			case "name":
				select = new Select(driver.findElement(By.name(element)));
				select.selectByValue(value);
				break;
			case "partialLinkText":
				select = new Select(driver.findElement(By.partialLinkText(element)));
				select.selectByValue(value);
				break;
			case "tagName":
				select = new Select(driver.findElement(By.tagName(element)));
				select.selectByValue(value);
				break;
			case "xpath":
				select = new Select(driver.findElement(By.xpath(element)));
				select.selectByValue(value);
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void selectValueByVisibleText(WebDriver driver, String element, String locatorType,
			String visibleText) {
		try {
			switch (locatorType) {
			case "className":
				select = new Select(driver.findElement(By.className(element)));
				select.selectByVisibleText(visibleText);
				break;
			case "cssSelector":
				select = new Select(driver.findElement(By.cssSelector(element)));
				select.selectByVisibleText(visibleText);
				break;
			case "id":
				select = new Select(driver.findElement(By.id(element)));
				select.selectByVisibleText(visibleText);
				break;
			case "linkText":
				select = new Select(driver.findElement(By.linkText(element)));
				select.selectByVisibleText(visibleText);
				break;
			case "name":
				select = new Select(driver.findElement(By.name(element)));
				select.selectByVisibleText(visibleText);
				break;
			case "partialLinkText":
				select = new Select(driver.findElement(By.partialLinkText(element)));
				select.selectByVisibleText(visibleText);
				break;
			case "tagName":
				select = new Select(driver.findElement(By.tagName(element)));
				select.selectByVisibleText(visibleText);
				break;
			case "xpath":
				select = new Select(driver.findElement(By.xpath(element)));
				select.selectByVisibleText(visibleText);
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}