package com.InternetBanking.testCases;

//import org.apache.logging.log4j.Logger;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.util.TimeUtils;

import com.InternetBanking.utilities.ReadConfig;



public class BaseClass 
{
	
	public ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUserName();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	//public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass()
 public void setup(String br) throws Exception 

	{
		 if(br.equals("chrome"))
		 {
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver=new ChromeDriver();
		System.out.println("chrome is enabled");
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
				}
		 else if(br.equals("firefox"))
		 {
			 System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
				driver=new FirefoxDriver();
				System.out.println("Firefox is enabled");
				driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
				driver.manage().deleteAllCookies();
				Thread.sleep(3000);
		 }
		 else if(br.equals("ie"))
		 {
			 System.setProperty("webdriver.ie.driver",readconfig.getIePath());
				driver=new InternetExplorerDriver();
				System.out.println("IE is enabled");
				driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
				driver.manage().deleteAllCookies();
				Thread.sleep(3000);
		 }
		 
		driver.get(baseURL);
         // logger=LogManager.getLogger(BaseClass.class);
	//PropertyConfigurator.configure("log4j.properties");
	}
	
/*	@AfterClass
	public void tearDown()
	{
		driver.quit();
		System.out.println("driver is closed");
	
	}*/
	
	public void captureScreen(WebDriver driver,String tname) 
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		try{
		File source= ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/ScreenShots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");}
		catch(Exception e){System.out.println("no file");}
	}

	public boolean isAlertPresent()
	{
		try{
		driver.switchTo().alert();
				return true;
				}
		catch(Exception e)
		{
			return false;}
		}
	}
