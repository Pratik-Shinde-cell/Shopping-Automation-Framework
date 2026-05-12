package com.shopping.pratik_practice.TestPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.shopping.pratik_practice.TestBase.TestBase;

public class SignIn extends TestBase
{
	public SignIn()
	{
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Name']")
	WebElement name;
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	WebElement email;
	
	@FindBy(xpath="//button[normalize-space()='Signup']")
	WebElement signup;
	
	@FindBy(xpath = "//input[@data-qa='login-email']")
	WebElement loginemail;
	
	@FindBy(xpath ="//input[@placeholder='Password']")
	WebElement loginpassword;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement loginbutton;
	
	public void newusername(String uname)
	{
		name.sendKeys(uname);
	}
	public void enteremail(String emailid)
	{
		email.sendKeys(emailid);
	}
	public void clicksignup()
	{
		signup.click();
	}
	public void enterloginemail(String email)
	{
		loginemail.sendKeys(email);
	}
	public void enterloginpassword(String password)
	{
		loginpassword.sendKeys(password);
	}
	public void clickloginbutton()
	{
		loginbutton.click();
	}
	
}
