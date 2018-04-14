package com.yash.pageobjects;

import org.openqa.selenium.support.PageFactory;

import com.yash.base.LocalDriverManager;



public class PageGenerator {
	public static <T extends PageGenerator> T getPageInstance(Class<T> pageClass) {
		return PageFactory.initElements(LocalDriverManager.getDriver(), pageClass);
	}
}
