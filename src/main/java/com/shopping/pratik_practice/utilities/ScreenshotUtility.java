package com.shopping.pratik_practice.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.shopping.pratik_practice.TestBase.TestBase;

public class ScreenshotUtility extends TestBase {
	
	public String CaptureScreen(String tname) throws IOException
	{
	String timestamp=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss").format(new Date());
	
	TakesScreenshot ts= (TakesScreenshot)driver;
	
	File src=ts.getScreenshotAs(OutputType.FILE);
	
	String target=System.getProperty("user.dir")+"\\Screenshots\\"+tname+"_"+timestamp+".png";
	
	File f= new File(target);
	
	FileUtils.copyFile(src, f);
	
	return target;
}	
}