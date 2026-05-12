package com.shopping.pratik_practice.utilities;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import java.lang.reflect.Method;

public class DataProviderClass {
  @DataProvider(name="CreateUser")
  public Object[][] getData(Method method) throws Exception
  {
	 String testcasename = method.getName(); 
	 switch(testcasename)
	 {
	 case "verifyRegistration":
		 return ExcelUtility.getexceldata("Create Account");
	case "verifylogins":
		 return ExcelUtility.getexceldata("Login");
	case "deleteaccount":
		return ExcelUtility.getexceldata("Delete");
	default:
		return null;	
	 }
  }
}
