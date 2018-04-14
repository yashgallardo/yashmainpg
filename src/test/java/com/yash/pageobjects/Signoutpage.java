package com.yash.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Signoutpage extends PageGenerator{
	
		@FindBy(xpath = "//a[contains(text(),' Sign out')]")
		public static WebElement Signoutbutton;
		
		public void clickSignOut(){
			Signoutbutton.click();
	}

}
