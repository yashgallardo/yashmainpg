 package com.yash.testscripts;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.yash.base.BaseTest;
import com.yash.pageobjects.CategoriesPage;
import com.yash.pageobjects.DataRecordsPage;
import com.yash.pageobjects.InventoryMainPage;
import com.yash.pageobjects.MembershipManagementHomepage;
import com.yash.pageobjects.PageGenerator;
import com.yash.pageobjects.SignInPage;
import com.yash.pageobjects.Signoutpage;
import com.yash.utils.ConfigReader;

import io.qameta.allure.Attachment;

public class CetegoryEndToEndTest extends BaseTest {
	static ConfigReader prop = new ConfigReader();
	private static final Logger LOGGER=Logger.getLogger(CetegoryEndToEndTest.class);


/*	@Attachment(value = "Page screenshot", type = "image/png")
	public byte[] saveScreenshot(byte[] screenShot) {
	    return screenShot;
	}*/
	
	@Test(priority = 1)
	
	public void signIn() throws InterruptedException, IOException {
		SignInPage signInPage = PageGenerator.getPageInstance(SignInPage.class);
		signInPage.baseURL();
		System.out.println("Base URL loaded");
		LOGGER.info("Base URL loaded");
		signInPage.enterUserName(prop.TestProperties("username"));
		System.out.println("Entered UserName");
		signInPage.enterPassword(prop.TestProperties("password"));
		System.out.println("Entered Password");
		signInPage.clickSignIn();
		
	}

	@Test(dependsOnMethods = { "signIn" }, priority = 2)
	public void addCategoryAndGoToAdminArea() throws InterruptedException, IOException {
		Thread.sleep(5000);
		InventoryMainPage inventoryMainPage = PageGenerator.getPageInstance(InventoryMainPage.class);
		CategoriesPage categoriesPage = inventoryMainPage.clickCategoriesButton();
		categoriesPage.clickOnAddNewCategoryButton();
		System.out.println("Categories Section Loaded");
		categoriesPage.addTwoCategory(prop.TestProperties("categoryName1"),
				prop.TestProperties("categoryName2"));
		System.out.println("Two Category Added Successfully");
		categoriesPage.goToAdminArea();
		System.out.println("Admin Area Loaded");

	}

	@Test(dependsOnMethods = { "addCategoryAndGoToAdminArea" }, priority = 3)
	public void memberShipManagementTest() {
		MembershipManagementHomepage inventoryMainPage = PageGenerator
				.getPageInstance(MembershipManagementHomepage.class);
		inventoryMainPage.goToNewestUpdates();
		System.out.println("Newest Updates Loaded");
	}

	@Test(dependsOnMethods = { "memberShipManagementTest" }, priority = 4)
	public void deleteDataRecords() {
		DataRecordsPage dataRecordsPage = PageGenerator.getPageInstance(DataRecordsPage.class);
		dataRecordsPage.selectCategoriesFromDropDown();
		System.out.println("DropDown for Categories Selected");
		dataRecordsPage.deleteTwoCategory();
		System.out.println("Deleted Two Category");
	}
	
	@Test(priority = 5)
	public void Signingout(){
		Signoutpage signoutPage = PageGenerator.getPageInstance(Signoutpage.class);
		signoutPage.clickSignOut();
	}
}
