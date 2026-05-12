package com.shopping.pratik_practice.TestPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.shopping.pratik_practice.TestBase.TestBase;

public class AccountInformation extends TestBase{

	public AccountInformation()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//b[normalize-space()='Enter Account Information']")
	WebElement formtitle;
	
	@FindBy(xpath="//input[@id='id_gender1']")
	WebElement mrradio;
	
	@FindBy(xpath="//input[@id='id_gender2']")
	WebElement mrsradio;

	@FindBy(xpath="//input[@id='name']")
	WebElement name;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement passoword;
	
	@FindBy(xpath="//select[@id='days']")
	WebElement daydropdown;
	
	@FindBy(xpath="//select[@id='months']")
	WebElement monthdropdown;
	
	@FindBy(xpath="//select[@id='years']")
	WebElement yeardropdown;
	
	@FindBy(xpath="//input[@id='newsletter']")
	WebElement checkboxnewsletter;
	
	@FindBy(xpath="//input[@id='optin']")
	WebElement checkboxreceiveoffer;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@id='company']")
	WebElement companyname;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement address1;
	
	@FindBy(xpath="//input[@id='address2']")
	WebElement address2;
	
	@FindBy(xpath="//select[@id='country']")
	WebElement countrydropdown;
	
	@FindBy(xpath="//input[@id='state']")
	WebElement state;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='zipcode']")
	WebElement zipcode;
	
	@FindBy(xpath="//input[@id='mobile_number']")
	WebElement mobileno;
	
	@FindBy(xpath="//button[normalize-space()='Create Account']")
	WebElement createaccount;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement continuebutton;
	
	public String checktitleform()
	{
		return formtitle.getText();
	}
	
	public void clickmr()
	{
		mrradio.click();
	}
	public void clickmrs()
	{
		mrsradio.click();
	}
	public void entername(String uname)
	{
		name.clear();
		name.sendKeys(uname);
	}
	public void enteremail(String mail)
	{
		email.sendKeys(mail);
	}
	public String checkmail()
	{
		return email.getAttribute("value");
	}
	public void enterpassword(String pass)
	{
		passoword.sendKeys(pass);
	}
	public void selectdaydropdown(String day)
	{
			Select selectday=new Select(daydropdown);
			selectday.selectByVisibleText(day);
	}
	public void selectmonthdropdown(String month)
	{
		Select selectmonth=new Select(monthdropdown);
		selectmonth.selectByVisibleText(month);
	}
	public void selectyeardropdown(String year)
	{
		Select selectyear=new Select(yeardropdown);
		selectyear.selectByVisibleText(year);
	}
	public void chkboxnewsletterclick()
	{
		checkboxnewsletter.click();
	}
	public void chkboxreceiveofferclick()
	{
		checkboxreceiveoffer.click();
	}
	public void enterfirstname(String fname)
	{
		firstname.sendKeys(fname);
	}
	public void enterlastname(String lname)
	{
		lastname.sendKeys(lname);
	}
	public void entercompanyname(String cname)
	{
		companyname.sendKeys(cname);
	}
	public void enteraddress1(String add1)
	{
		address1.sendKeys(add1);
	}
	public void enteraddress2(String add2)
	{
		address2.sendKeys(add2);
	}
	public void selectcountrydropdown(String country)
	{
		Select countryname= new Select(countrydropdown);
		countryname.selectByVisibleText(country);
	}
	public void enterstatename(String statename)
	{
		state.sendKeys(statename);
	}
	public void entercityname(String cityname)
	{
		city.sendKeys(cityname);
	}
	public void enterzipcode(String zip)
	{
		zipcode.sendKeys(zip);
	}
	public void entermobileno(String mobno)
	{
		mobileno.sendKeys(mobno);
	}
	public void clickcreateaccount()
	{
		createaccount.click();
	} 
	public String verifyaccountcreation()
	{
		return driver.getCurrentUrl();
	}
	public boolean checkmsg(String[] msg)
	{
	    String actualmsg1 ="Congratulations! Your new account has been successfully created!";
		String actualmsg2 ="You can now take advantage of member privileges to enhance your online shopping experience with us.";
		if((msg[0].equalsIgnoreCase(actualmsg1))&&(msg[1].equalsIgnoreCase(actualmsg2)))
			return true;
		else
			return false;
	}
	public void clickoncontinue()
	{
		continuebutton.click();
	}
	public String[] getmessage()
	{
		String actualmsg1 ="Congratulations! Your new account has been successfully created!";
		String actualmsg2 ="You can now take advantage of member privileges to enhance your online shopping experience with us.";
		return new String[] {actualmsg1, actualmsg2};
	}
	
}