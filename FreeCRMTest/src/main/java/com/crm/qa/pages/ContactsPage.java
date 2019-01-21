package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath = "//select[@name ='title']")
	WebElement titleName;
	
	@FindBy(xpath ="//input[@id='first_name']")
	WebElement firstName;
	
	@FindBy(xpath ="//input[@id='surname']")
	WebElement lastName;
	
	@FindBy(xpath = "//select[@name ='suffix']")
	WebElement suffix;
	
	@FindBy(xpath ="//input[@name ='client_lookup']")
	WebElement Company;
	
	@FindBy(xpath ="//input[@type='submit' and @value ='Save']")
	WebElement Save;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void addNewContact(String title,String fname,String lname,String suff,String company)
	{
		Select s = new Select(titleName);
		s.selectByVisibleText(title);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		Select suf = new Select(suffix);
		suf.selectByVisibleText(suff);
		Company.sendKeys(company);
		Save.click();
	}
	
	public void selectContact(String name)
	{
		driver.findElement(By.xpath("//a[text() = '"+ name +"']/parent::td[@class ='datalistrow']/preceding-sibling::td[@class ='datalistrow']/input[@name ='contact_id']")).click();
	}

}
