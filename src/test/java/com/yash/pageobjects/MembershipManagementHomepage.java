package com.yash.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MembershipManagementHomepage extends PageGenerator {
	@FindBy(xpath = "//div/h3[contains(text(), 'Newest Updates')]/a")
	public static WebElement newestUpdateButton;

	public void goToNewestUpdates() {
		newestUpdateButton.click();
	}

}
