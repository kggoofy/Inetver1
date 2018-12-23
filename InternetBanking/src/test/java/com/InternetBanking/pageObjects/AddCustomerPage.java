package com.InternetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage 
{
 WebDriver ldriver;
 
 public AddCustomerPage(WebDriver rdriver)
   {
	 ldriver=rdriver;
	 PageFactory.initElements(rdriver,this);
   }
 
 @FindBy(how=How.LINK_TEXT,using="New Customer")
 WebElement NewCustomer;

 @FindBy(how=How.NAME,using="name")
 WebElement CustName;

 @FindBy(how=How.NAME,using="rad1")
 WebElement mradio;

 @FindBy(how=How.NAME,using="dob")
 WebElement DOB;

 @FindBy(how=How.NAME,using="addr")
 WebElement Address;

 @FindBy(how=How.NAME,using="city")
 WebElement City;
 
 @FindBy(how=How.NAME,using="state")
 WebElement State;
 
 @FindBy(how=How.NAME,using="pinno")
 WebElement PinNo;
 
 @FindBy(how=How.NAME,using="telephoneno")
 WebElement PhNo;
 
 @FindBy(how=How.NAME,using="emailid")
 WebElement EmailId;
 
 @FindBy(how=How.NAME,using="password")
 WebElement Password;

 @FindBy(how=How.NAME,using="sub")
 WebElement Submit;
 
 public void clickLink()
 {
	 NewCustomer.click();
 }

 public void CName(String cname)
 {
	 CustName.sendKeys(cname);
 }
 public void radio()
 {
	 mradio.click();
 }

 public void dob(String mm,String dd,String yy)
 {
	 DOB.sendKeys(mm);
	 DOB.sendKeys(dd);
	 DOB.sendKeys(yy);
	 }
 public void Address(String add)
 {
	 Address.sendKeys(add);
 }
 public void CityName(String cityname)
 {
	 City.sendKeys(cityname);
 }
 
 public void State(String st)
 {
	 State.sendKeys(st);
 
 }
 public void pin(String cpin)
 {
	 PinNo.sendKeys(cpin);
 }
 public void phno(String phno)
 {
	 PhNo.sendKeys(phno);
 }
 public void emailid(String email)
 {
	 EmailId.sendKeys(email);
 }
 public void pw(String pw)
 {
	 Password.sendKeys(pw);
 }
 public void submit()
 {
	 Submit.click();
 }


}
