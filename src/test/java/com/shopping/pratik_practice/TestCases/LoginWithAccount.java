package com.shopping.pratik_practice.TestCases;

import org.testng.annotations.Test;

import com.shopping.pratik_practice.TestBase.TestBase;
import com.shopping.pratik_practice.TestPage.HomePage;
import com.shopping.pratik_practice.TestPage.SignIn;
import com.shopping.pratik_practice.utilities.DataProviderClass;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class LoginWithAccount extends TestBase {
	HomePage home;
	SignIn signin;
	
  @Test(dataProvider = "CreateUser", dataProviderClass = DataProviderClass.class)
  public void verifylogins(String email, String pass, String name)
  {
	 logger.info("Test # Verify Login Testcase started -----");
	 home.clicklogin();
	 logger.info("Step # Clicked on Login");
	 signin.enterloginemail(email);
	 logger.info("Step # Entered "+email+" email in the Email textbox");
	 signin.enterloginpassword(pass);
	 logger.info("Step # Entered "+pass+" passoword in the password textbox");
	 signin.clickloginbutton();
	 logger.info("Step # Clicked on Login Button");
	 assertEquals(home.checkuname(name), true);
	 logger.info("Step # Username is displayed correctly on the Dashboard");
	 home.logout();
	 logger.info("Step # Clicked on Log-out");
	 logger.info("Test # Verify Login Testcase Completed Successfully -----");
  }
  @BeforeMethod
  public void init()
  {
	  logger.info("Browser starting");
	  initialization();
	  logger.info("Browser Started");
	  home=new HomePage();
	  signin= new SignIn();
  }
  @AfterMethod
  public void teardown()
  {
	  logger.info("Closing the browser");
	  driver.quit();  
	  logger.info("Browser Closed");
  }
  }
