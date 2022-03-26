package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Demo User')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(@title,'New Contact')]")
	
		WebElement newcontactslink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}

	public ContactsPage clickOnContactsLink()
	{
		
		contactsLink.click();
		return new ContactsPage();
	}
	
	public boolean userNameLabel()
	{
		
		return userNameLabel.isDisplayed();
		
	}
	
	public DealsPage clickOnDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink()
	{
		tasksLink.click();
		return new TasksPage();
	}

	public void clickOnNewContactLink() throws InterruptedException
	{
		Actions action = new Actions(driver);
		Thread.sleep(5000);
		action.moveToElement(contactsLink).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@title,'New Contact')]")));
		newcontactslink.click();
	}
	
}
