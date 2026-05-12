package com.shopping.pratik_practice.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class ExtentReportManager implements ITestListener {
  
	public ExtentSparkReporter esparkreporter;
	public ExtentReports extent;
	public ExtentTest etest;
	
	public String reportname;
	
	public void onStart(ITestContext context)
	{
		String timestamp=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss").format(new Date());
		
		reportname="Test-Report"+timestamp+".html";
		
		esparkreporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/"+reportname);
		esparkreporter.config().setDocumentTitle("Functional Testing");
		esparkreporter.config().setReportName("Pratik's Report");
		esparkreporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(esparkreporter);
		extent.setSystemInfo("Tester Name", "Pratik");
	}
	
	public void onTestStart(ITestResult result)
	{
		etest=extent.createTest(result.getName());
	}
	public void onTestSuccess(ITestResult result)
	{
		etest.log(Status.PASS, "Testcase Pass:-"+result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		etest.log(Status.FAIL, "Testcase Failed:-"+result.getName());
		try
		{
			String imgpath=new ScreenshotUtility().CaptureScreen(result.getName());
			etest.addScreenCaptureFromPath(imgpath);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
}
