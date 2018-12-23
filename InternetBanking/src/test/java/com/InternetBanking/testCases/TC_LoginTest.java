package com.InternetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InternetBanking.pageObjects.LoginPage;


public class TC_LoginTest extends BaseClass

{
	@Test
public void loginTest()

	{
		
		LoginPage lp=new LoginPage(driver);
		lp.SetUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
	
		if(driver.getTitle().equals("Guruss99 Bank Manager HomePage"))
			{
			
			Assert.assertTrue(true);
			}
			else
			{
				captureScreen(driver,"loginTest");
				Assert.assertTrue(false);
			}
		}
}
	


