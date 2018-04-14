package com.yash.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestPage extends PageGenerator{
	@FindBy(id = "username")
	public static WebElement yashwanth;
	
	public void enteryeshwanth(String userName) {
		yashwanth.clear();
		yashwanth.sendKeys(userName);
	}

}
