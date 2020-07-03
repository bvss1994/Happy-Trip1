package com.sa.happytrip.tests.pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.sa.happytrip.tests.base.BaseClass;

public class login_PageModel extends BaseClass {
	
	@Test
	public void login() {
		driver.get("http://43.254.161.195:8085/happytripcrclean1/");
		driver.manage().window().maximize();
		driver.get("http://43.254.161.195:8085/happytripcrclean1/");
		driver.manage().window().maximize();
		//create page class for home page/login page too
		driver.findElement(By.linkText("Log in as admin")).click();
		adminPageLogin admin = new adminPageLogin(driver);

		admin.sendUsername("admin@mindtree.com");

		admin.sendPassword("admin");

		admin.SignIN();
		
		admin.assertResult();
	}	
}
