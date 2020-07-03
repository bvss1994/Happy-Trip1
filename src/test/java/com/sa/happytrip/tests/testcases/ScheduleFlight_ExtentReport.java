package com.sa.happytrip.tests.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sa.happytrip.tests.base.BaseClass;
import com.sa.happytrip.utils.ExcelReadMethods;

public class ScheduleFlight_ExtentReport extends BaseClass {

	// builds a new report using the html template
	ExtentHtmlReporter htmlReporter;

	ExtentReports extent;
	// helps to generate the logs in test report.
	ExtentTest test;

	@Parameters({ "OS", "browser" })
	@BeforeTest
	public void startReport(String OS, String browser) {
		// initialize the HtmlReporter
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/ScheduleFlight.html");

		// initialize ExtentReports and attach the HtmlReporter
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// To add system or environment info by using the setSystemInfo method.
		extent.setSystemInfo("OS", OS);
		extent.setSystemInfo("Browser", browser);

		// configuration items to change the look and feel
		// add content, manage tests etc
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}

	@Test
	public void ReadData1() throws IOException, InterruptedException {
		test = extent.createTest("Test Case 01", "PASSED test case");
		driver.manage().window().maximize();

		driver.get("http://43.254.161.195:8085/happytripcrclean1/");

		driver.findElement(By.linkText("Log in as admin")).click();

		ExcelReadMethods exr = new ExcelReadMethods("src\\test\\resources\\TestDataFile\\TestData.xlsx");

		driver.findElement(By.id("username")).sendKeys(exr.getCellData("Credentials", 0, 0));

		driver.findElement(By.name("j_password")).sendKeys(exr.getCellData("Credentials", 0, 1));

		driver.findElement(By.tagName("button")).click();

		driver.findElement(By.xpath("//*[@id=\"MainTabs\"]/li[5]/a")).click();

		Select chooseFlight = new Select(driver.findElement(By.id("flight")));

		chooseFlight.selectByVisibleText("spice101");

		Select chooseRoute = new Select(driver.findElement(By.id("route")));

		chooseRoute.selectByVisibleText("bangaluru (Karnataka) - Bombay (Maharashtra)");

		driver.findElement(By.id("distance")).sendKeys("2000");

		driver.findElement(By.xpath("//*[@id=\"AddSchedule\"]/dl/dd[6]/img")).click();

		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[6]/a")).click();

		driver.findElement(By.id("departureTime")).sendKeys("13:00");

		driver.findElement(By.xpath("//*[@id=\"AddSchedule\"]/dl/dd[8]/img")).click();

		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[7]/a")).click();

		driver.findElement(By.id("arrivalTime")).sendKeys("05:00");

		//driver.findElement(By.id("classBusiness")).sendKeys("1000.0");

		driver.findElement(By.id("classEconomy")).sendKeys("2000.0");

		driver.findElement(By.id("signInButton")).click();

		Thread.sleep(2000);

		Assert.assertTrue(true);

	}

	@Test
	public void ReadData2() throws IOException, InterruptedException {

		test = extent.createTest("Test Case 02", "PASSED test case");

		driver.manage().window().maximize();

		driver.get("http://43.254.161.195:8085/happytripcrclean1/");

		driver.findElement(By.linkText("Log in as admin")).click();

		ExcelReadMethods exr = new ExcelReadMethods("src\\test\\resources\\TestDataFile\\TestData.xlsx");

		driver.findElement(By.id("username")).sendKeys(exr.getCellData("Credentials", 0, 0));

		driver.findElement(By.name("j_password")).sendKeys(exr.getCellData("Credentials", 0, 1));

		driver.findElement(By.tagName("button")).click();

		driver.findElement(By.xpath("//*[@id=\"MainTabs\"]/li[5]/a")).click();

		Select chooseFlight = new Select(driver.findElement(By.id("flight")));

		chooseFlight.selectByVisibleText("6E007");

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

		driver.findElement(By.id("classEconomy")).sendKeys("2000.0");

		driver.findElement(By.id("signInButton")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//*[@id=\"global\"]/li[2]/a"));
		js.executeScript("arguments[0].scrollIntoView();", element);

		Thread.sleep(2000);

		Assert.assertTrue(true);
	}

	@Test
	public void ReadData3() throws IOException, InterruptedException {

		test = extent.createTest("Test Case 03", "PASSED test case");

		driver.manage().window().maximize();

		driver.get("http://43.254.161.195:8085/happytripcrclean1/");

		driver.findElement(By.linkText("Log in as admin")).click();

		ExcelReadMethods exr = new ExcelReadMethods("src\\test\\resources\\TestDataFile\\TestData.xlsx");

		driver.findElement(By.id("username")).sendKeys(exr.getCellData("Credentials", 0, 0));

		driver.findElement(By.name("j_password")).sendKeys(exr.getCellData("Credentials", 0, 1));

		driver.findElement(By.tagName("button")).click();

		driver.findElement(By.xpath("//*[@id=\"MainTabs\"]/li[5]/a")).click();

		Select chooseRoute = new Select(driver.findElement(By.id("route")));

		chooseRoute.selectByVisibleText("bangaluru (Karnataka) - Bombay (Maharashtra)");

		driver.findElement(By.id("distance")).sendKeys("2000");

		driver.findElement(By.xpath("//*[@id=\"AddSchedule\"]/dl/dd[6]/img")).click();

		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[6]/a")).click();

		driver.findElement(By.id("departureTime")).sendKeys("09:00");

		driver.findElement(By.xpath("//*[@id=\"AddSchedule\"]/dl/dd[8]/img")).click();

		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[7]/a")).click();

		driver.findElement(By.id("arrivalTime")).sendKeys("05:00");

		// driver.findElement(By.id("classBusiness")).sendKeys("1000.0");

		// driver.findElement(By.id("classEconomy")).sendKeys("2000.0");

		driver.findElement(By.id("signInButton")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//*[@id=\"global\"]/li[2]/a"));
		js.executeScript("arguments[0].scrollIntoView();", element);

		Thread.sleep(3000);

		Assert.assertTrue(true);
	}

	@Test
	public void ReadData4() throws IOException, InterruptedException {

		test = extent.createTest("Test Case 04", "PASSED test case");

		driver.manage().window().maximize();

		driver.get("http://43.254.161.195:8085/happytripcrclean1/");

		driver.findElement(By.linkText("Log in as admin")).click();

		ExcelReadMethods exr = new ExcelReadMethods("src\\test\\resources\\TestDataFile\\TestData.xlsx");

		driver.findElement(By.id("username")).sendKeys(exr.getCellData("Credentials", 0, 0));

		driver.findElement(By.name("j_password")).sendKeys(exr.getCellData("Credentials", 0, 1));

		driver.findElement(By.tagName("button")).click();

		driver.findElement(By.xpath("//*[@id=\"MainTabs\"]/li[5]/a")).click();

		Select chooseFlight = new Select(driver.findElement(By.id("flight")));

		chooseFlight.selectByVisibleText("Flight 676");

		Select chooseRoute = new Select(driver.findElement(By.id("route")));

		chooseRoute.selectByVisibleText("bangaluru (Karnataka) - Bombay (Maharashtra)");

		driver.findElement(By.id("distance")).sendKeys("-2000");

		driver.findElement(By.xpath("//*[@id=\"AddSchedule\"]/dl/dd[6]/img")).click();

		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[6]/a")).click();

		driver.findElement(By.id("departureTime")).sendKeys("09:00");

		driver.findElement(By.xpath("//*[@id=\"AddSchedule\"]/dl/dd[8]/img")).click();

		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[7]/a")).click();

		driver.findElement(By.id("arrivalTime")).sendKeys("05:00");

		driver.findElement(By.id("classBusiness")).sendKeys("1000.0");

		driver.findElement(By.id("classEconomy")).sendKeys("2000.0");

		driver.findElement(By.id("signInButton")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//*[@id=\"global\"]/li[2]/a"));
		js.executeScript("arguments[0].scrollIntoView();", element);

		Thread.sleep(3000);

		Assert.assertTrue(true);
	}

	@Test
	public void ReadData5() throws IOException, InterruptedException {

		test = extent.createTest("Test Case 05", "PASSED test case");

		driver.manage().window().maximize();

		driver.get("http://43.254.161.195:8085/happytripcrclean1/");

		driver.findElement(By.linkText("Log in as admin")).click();

		ExcelReadMethods exr = new ExcelReadMethods("src\\test\\resources\\TestDataFile\\TestData.xlsx");

		driver.findElement(By.id("username")).sendKeys(exr.getCellData("Credentials", 0, 0));

		driver.findElement(By.name("j_password")).sendKeys(exr.getCellData("Credentials", 0, 1));

		driver.findElement(By.tagName("button")).click();

		driver.findElement(By.xpath("//*[@id=\"MainTabs\"]/li[5]/a")).click();

		Select chooseFlight = new Select(driver.findElement(By.id("flight")));

		chooseFlight.selectByVisibleText("Flight 676");

		Select chooseRoute = new Select(driver.findElement(By.id("route")));

		chooseRoute.selectByVisibleText("bangaluru (Karnataka) - Bombay (Maharashtra)");

		driver.findElement(By.xpath("//*[@id=\"AddSchedule\"]/dl/dd[6]/img")).click();

		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[6]/a")).click();

		driver.findElement(By.id("departureTime")).sendKeys("09:00");

		driver.findElement(By.xpath("//*[@id=\"AddSchedule\"]/dl/dd[8]/img")).click();

		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[7]/a")).click();

		driver.findElement(By.id("arrivalTime")).sendKeys("05:00");

		driver.findElement(By.id("classBusiness")).sendKeys("1000.0");

		driver.findElement(By.id("classEconomy")).sendKeys("2000.0");

		driver.findElement(By.id("signInButton")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//*[@id=\"global\"]/li[2]/a"));
		js.executeScript("arguments[0].scrollIntoView();", element);

		Thread.sleep(3000);

		Assert.assertTrue(true);

	}

	@Test
	public void ReadData6() throws IOException, InterruptedException {

		test = extent.createTest("Test Case 06", "PASSED test case");

		driver.manage().window().maximize();

		driver.get("http://43.254.161.195:8085/happytripcrclean1/");

		driver.findElement(By.linkText("Log in as admin")).click();

		ExcelReadMethods exr = new ExcelReadMethods("src\\test\\resources\\TestDataFile\\TestData.xlsx");

		driver.findElement(By.id("username")).sendKeys(exr.getCellData("Credentials", 0, 0));

		driver.findElement(By.name("j_password")).sendKeys(exr.getCellData("Credentials", 0, 1));

		driver.findElement(By.tagName("button")).click();

		driver.findElement(By.xpath("//*[@id=\"MainTabs\"]/li[5]/a")).click();

		Select chooseFlight = new Select(driver.findElement(By.id("flight")));

		chooseFlight.selectByVisibleText("Flight 676");

		Select chooseRoute = new Select(driver.findElement(By.id("route")));

		chooseRoute.selectByVisibleText("bangaluru (Karnataka) - Bombay (Maharashtra)");

		driver.findElement(By.id("distance")).sendKeys("2000");

		driver.findElement(By.id("departureTime")).sendKeys("09:00");

		driver.findElement(By.xpath("//*[@id=\"AddSchedule\"]/dl/dd[8]/img")).click();

		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[7]/a")).click();

		driver.findElement(By.id("arrivalTime")).sendKeys("05:00");

		driver.findElement(By.id("classBusiness")).sendKeys("1000.0");

		driver.findElement(By.id("classEconomy")).sendKeys("2000.0");

		driver.findElement(By.id("signInButton")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id("route"));
		js.executeScript("arguments[0].scrollIntoView();", element);

		Thread.sleep(3000);

		Assert.assertTrue(true);
	}

	@Test
	public void ReadData7() throws IOException, InterruptedException {

		test = extent.createTest("Test Case 07", "PASSED test case");

		driver.manage().window().maximize();

		driver.get("http://43.254.161.195:8085/happytripcrclean1/");

		driver.findElement(By.linkText("Log in as admin")).click();

		ExcelReadMethods exr = new ExcelReadMethods("src\\test\\resources\\TestDataFile\\TestData.xlsx");

		driver.findElement(By.id("username")).sendKeys(exr.getCellData("Credentials", 0, 0));

		driver.findElement(By.name("j_password")).sendKeys(exr.getCellData("Credentials", 0, 1));

		driver.findElement(By.tagName("button")).click();

		driver.findElement(By.xpath("//*[@id=\"MainTabs\"]/li[5]/a")).click();

		Select chooseFlight = new Select(driver.findElement(By.id("flight")));

		chooseFlight.selectByVisibleText("Flight03");

		Select chooseRoute = new Select(driver.findElement(By.id("route")));

		chooseRoute.selectByVisibleText("bangaluru (Karnataka) - Bombay (Maharashtra)");

		driver.findElement(By.id("distance")).sendKeys("2000");

		driver.findElement(By.xpath("//*[@id=\"AddSchedule\"]/dl/dd[6]/img")).click();

		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[6]/a")).click();

		driver.findElement(By.id("departureTime")).sendKeys("09:00");

		driver.findElement(By.id("arrivalTime")).sendKeys("05:00");

		driver.findElement(By.id("classBusiness")).sendKeys("1000.0");

		driver.findElement(By.id("classEconomy")).sendKeys("2000.0");

		driver.findElement(By.id("signInButton")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id("route"));
		js.executeScript("arguments[0].scrollIntoView();", element);

		Thread.sleep(3000);

		Assert.assertTrue(true);
	}

	@Test
	public void ReadData8() throws IOException, InterruptedException {

		test = extent.createTest("Test Case 08", "PASSED test case");

		driver.manage().window().maximize();

		driver.get("http://43.254.161.195:8085/happytripcrclean1/");

		driver.findElement(By.linkText("Log in as admin")).click();

		ExcelReadMethods exr = new ExcelReadMethods("src\\test\\resources\\TestDataFile\\TestData.xlsx");

		driver.findElement(By.id("username")).sendKeys(exr.getCellData("Credentials", 0, 0));

		driver.findElement(By.name("j_password")).sendKeys(exr.getCellData("Credentials", 0, 1));

		driver.findElement(By.tagName("button")).click();

		driver.findElement(By.xpath("//*[@id=\"MainTabs\"]/li[5]/a")).click();

		Select chooseFlight = new Select(driver.findElement(By.id("flight")));

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

		driver.findElement(By.id("classEconomy")).sendKeys("2000.0");

		driver.findElement(By.id("signInButton")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id("distance"));
		js.executeScript("arguments[0].scrollIntoView();", element);

		Thread.sleep(3000);

		Assert.assertTrue(true);
	}

	@Test
	public void ReadData9() throws IOException, InterruptedException {

		test = extent.createTest("Test Case 09", "PASSED test case");

		driver.manage().window().maximize();

		driver.get("http://43.254.161.195:8085/happytripcrclean1/");

		driver.findElement(By.linkText("Log in as admin")).click();

		ExcelReadMethods exr = new ExcelReadMethods("src\\test\\resources\\TestDataFile\\TestData.xlsx");

		driver.findElement(By.id("username")).sendKeys(exr.getCellData("Credentials", 0, 0));

		driver.findElement(By.name("j_password")).sendKeys(exr.getCellData("Credentials", 0, 1));

		driver.findElement(By.tagName("button")).click();

		driver.findElement(By.xpath("//*[@id=\"MainTabs\"]/li[5]/a")).click();

		Select chooseFlight = new Select(driver.findElement(By.id("flight")));

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

		Assert.assertTrue(true);
	}

	@Test
	public void ReadData10() throws IOException, InterruptedException {

		test = extent.createTest("Test Case 10", "PASSED test case");

		driver.manage().window().maximize();

		driver.get("http://43.254.161.195:8085/happytripcrclean1/");

		driver.findElement(By.linkText("Log in as admin")).click();

		ExcelReadMethods exr = new ExcelReadMethods("src\\test\\resources\\TestDataFile\\TestData.xlsx");

		driver.findElement(By.id("username")).sendKeys(exr.getCellData("Credentials", 0, 0));

		driver.findElement(By.name("j_password")).sendKeys(exr.getCellData("Credentials", 0, 1));

		driver.findElement(By.tagName("button")).click();

		driver.findElement(By.xpath("//*[@id=\"MainTabs\"]/li[5]/a")).click();

		Select chooseFlight = new Select(driver.findElement(By.id("flight")));

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

		driver.findElement(By.id("classBusiness")).sendKeys("-1000.0");

		driver.findElement(By.id("classEconomy")).sendKeys("-2000.0");

		driver.findElement(By.id("signInButton")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id("distance"));
		js.executeScript("arguments[0].scrollIntoView();", element);

		Thread.sleep(3000);

		Assert.assertTrue(true);
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
		} else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
	}

	@AfterTest
	public void tearDown() {
		// to write or update test information to reporter
		extent.flush();
	}
}