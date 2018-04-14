package com.yash.pageobjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.yash.base.LocalDriverManager;



public class InventoryMainPage extends PageGenerator {

	@FindBy(xpath = "//div[@id='categories-tile']//a[contains(@title, 'To classify the category of each item.')]")
	public static WebElement categoriesButton;

	public CategoriesPage clickCategoriesButton() {
		WebDriverWait wait = new WebDriverWait(LocalDriverManager.getDriver(), 5);
		wait.ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(categoriesButton));
		categoriesButton.click();
		return PageGenerator.getPageInstance(CategoriesPage.class);
	}

}
