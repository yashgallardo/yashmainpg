package com.yash.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.yash.utils.ConfigReader;

public class BaseTest {

	public WebDriver driver;
	static ConfigReader prop = new ConfigReader();
	
	@Parameters({"browser"})
	@BeforeClass
	public void classLevelSetUp(String browser) {
		System.out.println("Executing Before class");
		LocalDriverManager.setDriver(browser);
		driver = LocalDriverManager.getDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void classLevelTearDown() {
		LocalDriverManager.getDriver().quit();
		
	}
}
