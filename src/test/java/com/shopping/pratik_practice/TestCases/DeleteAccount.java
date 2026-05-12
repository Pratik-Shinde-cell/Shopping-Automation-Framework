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

public class DeleteAccount extends TestBase {
	HomePage homepage;
	SignIn signin;
	
  @Test(dataProvider = "CreateUser", dataProviderClass = DataProviderClass.class)
  public void deleteaccount(String email, String pass) {
	  logger.info("Test # Delete Account Test Started -----");
	  homepage.clicklogin();
	  logger.info("Step # Clicked on Login");
	  signin.enterloginemail(email);
	  logger.info("Step # Entered "+email+" email in the Email textbox");
	  signin.enterloginpassword(pass);
	  logger.info("Step # Entered"+pass+" password in the password tab");
	  signin.clickloginbutton();
	  logger.info("Step # Clicked on Login button");
	  homepage.deleteacc();
	  logger.info("Step # Clicked on Delete button");
	  assertEquals(homepage.checkdeletemsg(), true);
	  logger.info("Step # Deletion completed");
	  homepage.delcontinue();
	  logger.info("Test # Delete Account Test completed -----");
  }
  @BeforeMethod
  public void init() {
	  logger.info(" Browser Initialization Start");
	  initialization();
	  logger.info("Browser Loaded Successfully");
	  homepage=new HomePage();
	  signin=new SignIn();
  }

  @AfterMethod
  public void teardown() {
	  logger.info("Closing Browser");
	  driver.quit();
	  logger.info("Browser Closed");
  }
}
