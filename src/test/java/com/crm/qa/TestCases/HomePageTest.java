package com.crm.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();
		testutil = new TestUtil();
		contactsPage = new ContactsPage();
		loginpage = new LoginPage();
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void verifyHomePageTitleTest() {
		String homepagetitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO", "Home page title not matched");
	}

	@Test
	public void verifyusernameTest() {
		testutil.switchToFrame();
		Assert.assertTrue(homePage.userNameLabel());

	}

	@Test
	public void clickOnContactsLinkTest() {
		testutil.switchToFrame();

		contactsPage = homePage.clickOnContactsLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
