package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	TestUtil testutil;
	String sheetName = "Contacts";
	

	public ContactsPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage = new LoginPage();
		contactPage = new ContactsPage();
		testutil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		contactPage = homePage.clickOnContactsLink();
	}

	@Test(dataProvider ="getTestData")
	public void addNewContactTest(String tname,String fname,String lname,String suff,String comp)
	{
		homePage.clickOnNewContactLink();
		contactPage.addNewContact(tname, fname, lname, suff, comp);
	}
	
	@Test
	public void selectnewContactTest()
	{
		contactPage.selectContact("Sammy Winchester");
		contactPage.selectContact("Walter Reddmann");
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		Object[][] data =TestUtil.getTestData(sheetName);
		return data;
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
