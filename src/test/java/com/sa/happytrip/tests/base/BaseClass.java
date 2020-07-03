package com.sa.happytrip.tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	protected static WebDriver driver;
	
	@BeforeMethod
	public void setup() {
				//Set browser property
				//System.setProperty("webdriver.chrome.driver", "E:\\WFH\\DevOps\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
				
				//Define Webdriver
				driver = new ChromeDriver();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	

	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
