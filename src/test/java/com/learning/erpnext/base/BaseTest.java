package com.learning.erpnext.base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties configProps = new Properties();
	public static Properties locatorProps = new Properties();
	public static FileReader file;
	
	
	@BeforeSuite
	public void setup() throws IOException {
		if(driver == null) {
			FileReader configFile = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configFiles\\config.properties");
			FileReader locatorsFile = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configFiles\\locators.properties");
			configProps.load(configFile);
			locatorProps.load(locatorsFile);
		}
		if(configProps.getProperty("browser").equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(configProps.getProperty("erpNextURL"));
		
		loginToErpnext();
	}
	
 }
	//@BeforeTest
	public void loginToErpnext() {
		driver.findElement(By.xpath("//a[@class='btn btn-primary btn-sm']")).click();
		driver.findElement(By.xpath("//input[@id='login_email']")).sendKeys("Administrator");
		driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("password");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		//Thread.sleep(5000);
		
	}
	
	@AfterTest
	public void tearDown() {
		//driver.close();
		System.out.println("teardown successfull");
	}
}
