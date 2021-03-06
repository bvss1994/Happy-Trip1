package com.sa.happytrip.tests.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.sa.happytrip.tests.base.BaseClass;
import com.sa.happytrip.utils.ExcelReadMethods;

//Check if fight is scheduled or not, by entering all fields except economy class field
//Please provide a valid cost for the Economy seats
public class TestCase_09 extends BaseClass {
	
	@Test
	public void ReadData9() throws IOException, InterruptedException {
		
		driver.manage().window().maximize();
		
		driver.get("http://43.254.161.195:8085/happytripcrclean1/");
		
		driver.findElement(By.linkText("Log in as admin")).click();
		
		ExcelReadMethods exr = new ExcelReadMethods("src\\test\\resources\\TestDataFile\\TestData.xlsx");
		
		driver.findElement(By.id("username")).sendKeys(exr.getCellData("Credentials", 0, 0));
		
		driver.findElement(By.name("j_password")).sendKeys(exr.getCellData("Credentials", 0, 1));
		
		driver.findElement(By.tagName("button")).click();
		
		driver.findElement(By.xpath("//*[@id=\"MainTabs\"]/li[5]/a")).click();
		
		Select chooseFlight =new Select(driver.findElement(By.id("flight")));
		
		chooseFlight.selectByVisibleText("Flight 676");
		
		Select chooseRoute = new Select(driver.findElement(By.id("route")));
		
		chooseRoute.selectByVisibleText("bangaluru (Karnataka) - Bombay (Maharashtra)");
		
		driver.findElement(By.id("distance")).sendKeys("2000");
		
		driver.findElement(By.xpath("//*[@id=\"AddSchedule\"]/dl/dd[6]/img")).click();
		
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[6]/a")).click();
		
		driver.findElement(By.id("departureTime")).sendKeys("09:00");
		
		driver.findElement(By.xpath("//*[@id=\"AddSchedule\"]/dl/dd[8]/img")).click();
		
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[7]/a")).click();
		
		driver.findElement(By.id("arrivalTime")).sendKeys("05:00");
		
		driver.findElement(By.id("classBusiness")).sendKeys("1000.0");
		
		driver.findElement(By.id("signInButton")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id("distance"));
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		Thread.sleep(3000);

}

}