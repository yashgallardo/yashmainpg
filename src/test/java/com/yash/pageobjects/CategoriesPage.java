package com.yash.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoriesPage extends PageGenerator {

	@FindBy(xpath = "//a[@title='Admin Area']")
	public WebElement adminAreaButton;

	@FindBy(xpath = "//button[@id='addNew']")
	public WebElement addNewCategoryButton;

	@FindBy(xpath = "//input[@id='category']")
	public WebElement categorySearchTextBox;

	@FindBy(xpath = "//button[@id='insert']")
	public WebElement saveNewCategoryButton;

	@FindBy(xpath = "//button/[@id='update']")
	public WebElement saveChangesButton;

	@FindBy(id = "deselect")
	public WebElement backButton;
	
	
	
	
	public void clickOnAddNewCategoryButton() {
		addNewCategoryButton.click();
	}

	public void addTwoCategory(String category1, String category2) {
		categorySearchTextBox.clear();
		categorySearchTextBox.sendKeys(category1);
		saveNewCategoryButton.click();
		backButton.click();
		clickOnAddNewCategoryButton();
		categorySearchTextBox.clear();
		categorySearchTextBox.sendKeys(category2);
		saveNewCategoryButton.click();
	}

	public void goToAdminArea() {
		adminAreaButton.click();
	}
	
	
}
