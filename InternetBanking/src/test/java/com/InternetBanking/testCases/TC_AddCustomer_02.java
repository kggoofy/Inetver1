package com.InternetBanking.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.InternetBanking.pageObjects.AddCustomerPage;
import com.InternetBanking.pageObjects.LoginPage;




public class TC_AddCustomer_02 extends BaseClass

{

	@Test
	public void AddCust() throws InterruptedException
	{
		LoginPage log=new LoginPage(driver);
		log.SetUserName(username);
		log.setPassword(password);
		log.clickSubmit();
		Thread.sleep(2000);
		AddCustomerPage addc=new AddCustomerPage(driver);
		Thread.sleep(1000);
		addc.clickLink();
		addc.CName("Selni");
		addc.radio();
		addc.dob("01","01","1990");
		addc.Address("INDIA");
		addc.CityName("Mumbai");
	    addc.State("UP");
	    addc.pin("5001091");
	    addc.phno("987892789");
	    
	    String email=randomestring()+"@gmail.com";
	    	    addc.emailid(email);
	    	    
	    addc.pw("lillysf");
	    addc.submit();
	    System.out.println("form is submitted");
	    Thread.sleep(2000);
	    boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
	    if(res==true)
	    {Assert.assertTrue(true);
	    
	    }
	    else{ 
	    	captureScreen(driver,"AddCust");
	    	Assert.assertTrue(false);
	    }
	}	
	
	public String randomestring()
	{
		String genemail=RandomStringUtils.randomAlphabetic(8);
		return(genemail);
			}
	public static String randomNum()
	{
		String number=RandomStringUtils.randomNumeric(4);
		return(number);
	}
}
