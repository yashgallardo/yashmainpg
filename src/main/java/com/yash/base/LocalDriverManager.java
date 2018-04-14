package com.yash.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LocalDriverManager {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static synchronized WebDriver getDriver() {
		return driver.get();
	}

	public static synchronized void setDriver(String browserName) {
		if (driver != null)
			driver.set(createBrowserDriver(browserName));
	}

	

	private static WebDriver createBrowserDriver(String browserName) {
		WebDriver driver = null;
		String driverPath = "../browserdrivers/";

		if (browserName.equalsIgnoreCase("chrome")) {
			String path = driverPath + "chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", path);
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			String path = driverPath + "geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", path);
			driver = new FirefoxDriver();
		} 
		
		else {
			System.out.println("Select the browser driver");
		}

		return driver;
	}
}
