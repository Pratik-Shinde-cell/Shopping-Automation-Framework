package com.shopping.pratik_practice.TestCases;

import org.testng.annotations.Test;

import com.shopping.pratik_practice.TestBase.TestBase;
import com.shopping.pratik_practice.TestPage.HomePage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;

public class Verifyhometitlename extends TestBase{
	
	HomePage home;
	
  @Test
  public void verifytitle() 
  {
	 logger.info("Test # Testcase Verify Title Name started -----");
	 String actual="Automation Exercises";
	 assertEquals(actual,home.checkpage());
	 logger.info("Step # Title Name is correct");
	 System.out.println(home.checkpage());	
	 logger.info("Test # Testcase Verify Title Name completed successfully -----");
  }
  @BeforeMethod
  public void init() 
  {
	  logger.info("Starting Browser");
	  initialization();
	  logger.info("Browser Started");
		home=new HomePage();
  }

  @AfterMethod
  public void teardown() 	
  {
	  logger.info("Closing the Browser");
	  driver.quit();
	  logger.info("Browser Closed");
  }

}
