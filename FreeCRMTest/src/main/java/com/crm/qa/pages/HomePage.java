package com.crm.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath = "//td[contains(text(),'User: Chaithra Shankar')]")
	WebElement userNameLabel;
	
	@FindBy(xpath ="//a[text()='Companies']")
	WebElement companiesLink;
	
	@FindBy(xpath ="//a[text()='New Company']")
	WebElement NewCompany;

	@FindBy(xpath = "//a[text()='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[text()='New Contact']")
	WebElement newContactLink;
	

	@FindBy(xpath = "//a[text()='Deals']")
	WebElement dealsLink;

	@FindBy(xpath = "//a[text()='Tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath ="//select[@name ='slctMonth']")
	WebElement month;
	
	@FindBy(xpath ="//select[@name ='slctYear']")
	WebElement year;
	
	@FindBy(xpath ="//td[@class='calendarcell']")
	WebElement day;
	
	@FindBy(xpath ="//a[text()='»»']")
	WebElement next;
	
	@FindBy(xpath ="//a[text()='««']")
	WebElement previous;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}
	
	public void selectdatefromcalendar(String Day, String Month, String Year) {
Select syear = new Select(year);
	syear.selectByVisibleText(Year);
	Select mon =new Select(month);
		mon.selectByVisibleText(Month);
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[4]/td[6]
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[5]/td[6]
		String befXpath ="//*[@id=\"crmcalendar\"]/table/tbody/tr[2]/td/table/tbody/tr[";
		String afterXpath ="]/td[";
		String days ="";
		boolean flag = false;
		for(int rowsum = 2;rowsum <=6;rowsum++)
		{
			for(int cols =1;cols<=7;cols++)
			{
				try
				{
				days = driver.findElement(By.xpath(befXpath+rowsum+afterXpath+cols+"]")).getText();
				}
				catch(Exception e)
				{
					e.getMessage();
					flag =false;
				}
				if(days.contains(Day))
				{
					driver.findElement(By.xpath(befXpath+rowsum+afterXpath+cols+"]")).click();	
					flag= true;
					break;
					
			}
		}
			if(flag)
				break;
	}
	}
}
	
	
	
	
	
	

