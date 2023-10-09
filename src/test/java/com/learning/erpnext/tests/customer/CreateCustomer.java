package com.learning.erpnext.tests.customer;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.learning.erpnext.base.BaseTest;

public class CreateCustomer extends BaseTest {
	

	
	@Test
	public void validInputs() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath(locatorProps.getProperty("Home"))).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath(locatorProps.getProperty("Customer"))).click();
	
		driver.findElement(By.xpath(locatorProps.getProperty("AddCustomer"))).click();
		driver.findElement(By.xpath(locatorProps.getProperty("Customer_name_field"))).sendKeys("Andrian Zack");
		driver.findElement(By.xpath(locatorProps.getProperty("Customer_group_field"))).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(locatorProps.getProperty("Territory_field"))).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(locatorProps.getProperty("Save_button"))).click();
	
	}
	
}
