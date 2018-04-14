package com.yash.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.yash.base.LocalDriverManager;



public class DataRecordsPage extends PageGenerator {

	@FindBy(id = "tableName")
	public static WebElement showRecodsDropDown;

	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement findRecodsButton;

	@FindBy(xpath = "//i[@class='glyphicon glyphicon-trash text-danger']/..")
	public static WebElement deleteIconCategories;

	@FindBy(xpath = "//i[contains(text(), ' Sign Out')]/..")
	public static WebElement signOut;

	public void selectCategoriesFromDropDown() {
		Select recordsDropDown = new Select(showRecodsDropDown);
		recordsDropDown.selectByValue("categories");
		findRecodsButton.click();
	}

	public void deleteTwoCategory() {
		deleteIconCategories.click();
		Alert alert = (Alert) LocalDriverManager.getDriver().switchTo().alert();
		alert.accept();
		deleteIconCategories.click();
		alert = (Alert) LocalDriverManager.getDriver().switchTo().alert();
		alert.accept();
	}
}
