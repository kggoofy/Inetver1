package com.InternetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	 WebDriver ldriver;
	
	 public LoginPage(WebDriver rdriver)
	 {
		ldriver = rdriver;
		 PageFactory.initElements(rdriver, this);
	 }

	 @FindBy(name="uid")
	 WebElement Username;

	 @FindBy(name="password")
	 WebElement Password;

	 @FindBy(name="btnLogin")
	 WebElement Login;

	 @FindBy(xpath="//a[text()='Log out']")
		 WebElement Logout;
			 
	 public void SetUserName(String uname)
	 {
		 Username.sendKeys(uname);
	 }
	 public void setPassword(String pwd)
	 {
		 Password.sendKeys(pwd);
	 }
	 public void clickSubmit()
	 {
		 Login.click();
	 }
public void Logout()
{
	Logout.click();
}

}
