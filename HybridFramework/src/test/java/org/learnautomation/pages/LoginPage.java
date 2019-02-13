package org.learnautomation.pages;

import org.learnautomation.utility.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	@FindBy(xpath="//span[text()='Log In']") WebElement Logintoapp;
	@FindBy(name="email") WebElement uname;
	@FindBy(xpath="//input[@name='password']") WebElement pwd;
	//@FindBy(xpath="//input[@name='Login']") WebElement login;
	
    @FindBy(how = How.XPATH, using = "//div[text()='Login']" ) WebElement login;
    
    public void login1(String lusername, String lpassword)
    {
    	//Logintoapp.click();
    	//uname.sendKeys(lusername);
    	//pwd.sendKeys(lpassword);
    	//login.click();
    	Helper.waitforWebElement1(driver, Logintoapp, 20).click();
    	Helper.waitforWebElement1(driver, uname, 20).sendKeys(lusername);
    	Helper.waitforWebElement1(driver, pwd, 20).sendKeys(lpassword);
    	Helper.waitforWebElement1(driver, login, 10).click();
    	    	    }
	
}
