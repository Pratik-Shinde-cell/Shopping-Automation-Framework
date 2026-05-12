package com.shopping.pratik_practice.TestPage;

import org.testng.annotations.Test;

import com.shopping.pratik_practice.TestBase.TestBase;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class HomePage extends TestBase
{

	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Signup / Login']")
	WebElement login;
	
	@FindBy(xpath = "//a[contains(text(), ' Logged in as ')]/b")
	WebElement loggedinname;
	
	@FindBy(xpath = "//a[normalize-space()='Delete Account']")
	WebElement deleteaccount;
	
	@FindBy(xpath ="//b[normalize-space()='Account Deleted!']")
	WebElement delacmsg;
	
	@FindBy(xpath ="//a[normalize-space()='Continue']")
	WebElement delcontinuebutton;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement logout;
	
	public void deleteacc()
	{
		deleteaccount.click();
	}
	public void clicklogin()
	{
		login.click();
	}
	
	public String checkpage()
	{
		return driver.getTitle();
	}
	
	public boolean checkuname(String uname)
	{
		System.out.println(loggedinname.getText());
		return uname.equalsIgnoreCase(loggedinname.getText());
	}
	
	public boolean checkdeletemsg()
	{
		String actmsg ="Account Deleted!";
		if(delacmsg.isDisplayed() && actmsg.equalsIgnoreCase(delacmsg.getText()))
			return true;
		else
			return false;
	}
	public void delcontinue()
	{
		delcontinuebutton.click();
	}
	public void logout()
	{
		logout.click();
	}
}
