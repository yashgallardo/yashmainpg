package com.yash.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.yash.base.LocalDriverManager;
import com.yash.utils.ConfigReader;



public class SignInPage extends PageGenerator {

	@FindBy(id = "username")
	public static WebElement usernameInputTextBox;

	@FindBy(id = "password")
	public static WebElement passwordInputTextBox;

	@FindBy(id = "submit")
	public static WebElement signInSubmitButton;
	
	@FindBy(id = "//a[contains(text(),' Sign out')]")
	public static WebElement Signoutbutton;
	
	public void baseURL() throws IOException {
				
		ConfigReader prop = new ConfigReader();
		String baseURL = prop.TestProperties("baseurl");
		LocalDriverManager.getDriver().get(baseURL);
	}

	public void enterUserName(String userName) {
		usernameInputTextBox.clear();
		usernameInputTextBox.sendKeys(userName);
	}

	public void enterPassword(String Password) {
		passwordInputTextBox.clear();
		passwordInputTextBox.sendKeys(Password);
	}

	public void clickSignIn() {
		signInSubmitButton.click();
	}
	
	
	}

