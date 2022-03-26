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

public class ContactsPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactsPage;
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		testutil = new TestUtil();
		contactsPage = new ContactsPage();
		loginpage=new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		contactsPage = homepage.clickOnContactsLink();
		
	}
	
	@Test
	public void verifyCotactsPageLabel()
	{
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts label is missing");
	}
	
	/*
	 * @Test public void selectContactTest() {
	 * contactsPage.selectContacts("Aman Test"); }
	 */
	
	@Test
	public void validateCreateNewContact() throws InterruptedException
	{
		homepage.clickOnNewContactLink();
		contactsPage.createNewContact("Mr.", "mansiha", "deol", "amazon");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
