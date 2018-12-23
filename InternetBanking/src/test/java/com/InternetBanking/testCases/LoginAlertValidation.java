package com.InternetBanking.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.InternetBanking.pageObjects.LoginPage;

public class LoginAlertValidation extends BaseClass

{
	@Test()
	public void AlertCheck() throws InterruptedException
	{
		LoginPage obj=new LoginPage(driver);
		obj.SetUserName(username);
		obj.setPassword(password);
		obj.clickSubmit();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			 captureScreen(driver,"AlertCheck");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			//Assert.assertTrue(false);
			driver.findElement(By.name("uid")).sendKeys("mngr165275");
			driver.findElement(By.name("password")).sendKeys("UdYqYbY");
			obj.clickSubmit();
			Thread.sleep(3000);
			obj.Logout();
			Thread.sleep(3000);
			System.out.println("Logout link is clicked");
		   driver.switchTo().alert().accept();
		  		}
		else 
		{
			Assert.assertTrue(false);
					
		}
	}
	
}
