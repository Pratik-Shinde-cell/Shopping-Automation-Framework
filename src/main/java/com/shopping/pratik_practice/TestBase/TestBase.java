package com.shopping.pratik_practice.TestBase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestBase 
{
	public static Properties prop;
	public static WebDriver driver;
	public static Logger logger;
	
	public TestBase()
	{
		try
		{
			logger= LogManager.getLogger(this.getClass());
			prop= new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\com.shopping.pratik_practice\\src\\main\\java\\com\\shopping\\pratik_practice\\configuration\\Propertise");
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void initialization()
	{
		String browser=prop.getProperty("browser");
		if(browser.equals("Edge"))
		{
			driver= new EdgeDriver();
		}
		else
		{
			driver= new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
	}
	
}
