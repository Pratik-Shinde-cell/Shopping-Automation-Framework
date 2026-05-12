package com.shopping.pratik_practice.TestCases;

import org.testng.annotations.Test;

import com.shopping.pratik_practice.TestBase.TestBase;
import com.shopping.pratik_practice.TestPage.AccountInformation;
import com.shopping.pratik_practice.TestPage.HomePage;
import com.shopping.pratik_practice.TestPage.SignIn;
import com.shopping.pratik_practice.utilities.DataProviderClass;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;

public class VerifyRegisterUser extends TestBase {
	 
	  HomePage home;
SignIn signinpage;
AccountInformation acinfo;
	 @BeforeMethod
	  public void init() 
	  {
		 logger.info("Starting the Browser");
		  initialization();
		  logger.info("Browser started");
		  home=new HomePage();
		  signinpage= new SignIn();
		  acinfo=new AccountInformation();
	  }

	  @AfterMethod
	  public void afterMethod() 
	  {
		  logger.info("Closing the Browser");
		  driver.quit();
		  logger.info("Browser Closed");
	  }
 
  VerifyRegisterUser()
  {
	  super();
  }
  @Test(dataProvider = "CreateUser", dataProviderClass = DataProviderClass.class)
  void verifyRegistration(String title, String name, String email, String password, String day, String month, String year, String fname, String lname, String cname, String add1, String add2, String country, String state, String city, String zip, String mobno)
  {
	  logger.info("Test # Testcase Verify Register User started -----");
	  home.clicklogin();
	  logger.info("Step # Clicked on Sign in button");
	  signinpage.newusername(name);
	  logger.info("Step # Entered Username "+name+" in the New Username textbox");
	  signinpage.enteremail(email);
	  logger.info("Step # Entered Email "+email+" in the Email textbox");
	  signinpage.clicksignup();
	  logger.info("Step # Clicked on Sign Up button");
	  String actualformtitle="ENTER ACCOUNT INFORMATION";	  
	  assertEquals(acinfo.checktitleform(), actualformtitle);
	  logger.info("Step # ENTER ACCOUNT INFORMATION text is visible");
	  if(title.equalsIgnoreCase("mr"))
	  {
		  acinfo.clickmr();
		  logger.info("Step # Mr radio button is selected");
	  }
	  else
	  {
		  acinfo.clickmrs();
		  logger.info("Step # Mrs radio button is selected");
	  }
	  acinfo.entername(name);
	  logger.info("Step # Entered "+name+" in Name textbox");
	  assertEquals(acinfo.checkmail(), email);
	  logger.info("Step # Email is correctly fetched");
	  acinfo.enterpassword(password);
	  logger.info("Step # Entered "+password+" password in the password textbox");
	  acinfo.selectdaydropdown(day);
	  acinfo.selectmonthdropdown(month);
	  acinfo.selectyeardropdown(year);
	  logger.info("Step # Entered Date "+day+"/"+month+"/"+year);
	  acinfo.chkboxnewsletterclick();
	  logger.info("Step # Selected News Letter checkbox");
	  acinfo.enterfirstname(fname);
	  logger.info("Step # Entered "+fname+" in the first name textbox");
	  acinfo.enterlastname(lname);
	  logger.info("Step # Entered "+lname+" in the last name textbox");
	  acinfo.entercompanyname(cname);
	  logger.info("Step # Entered "+cname+" in the Company name textbox");
	  acinfo.enteraddress1(add1);
	  acinfo.enteraddress2(add2);
	  logger.info("Step # entered "+add1+" "+add2+" in the address textbox");
	  acinfo.selectcountrydropdown(country);
	  logger.info("Step # Selected "+country+" from the dropdown");
	  acinfo.enterstatename(state);
	  logger.info("Step # Entered "+state+" in the statename textbox");
	  acinfo.entercityname(city);
	  logger.info("Step # Entered "+city+" in the city textbox");
	  acinfo.enterzipcode(zip);
	  logger.info("Step # Entered "+zip+" in the Enter zipcode textbox");
	  acinfo.entermobileno(mobno);
	  logger.info("Step # Entered "+mobno+" in the Enter mobile no textbox");
	  acinfo.clickcreateaccount();
	  logger.info("Step # Clicked on Create Account Button");
	  assertEquals(acinfo.checkmsg(acinfo.getmessage()), true);
	  logger.info("Step # Account Created message is displayed correctly");
	  acinfo.clickoncontinue();
	  logger.info("Step # Clicked on Continue");
	  assertEquals(home.checkuname(name), true);
	  logger.info("Step # Username is displayed correctly on the Dashboard");
	  logger.info("Test # Testcase Create User completed successfully -----");
  }	    
  
 
}
