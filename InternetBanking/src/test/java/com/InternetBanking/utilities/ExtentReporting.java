package com.InternetBanking.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReporting implements ITestListener
{

	 public ExtentReports exreports;
	 public ExtentTest extest;
	  public ExtentHtmlReporter htmlrep;
	  
	public void onStart(ITestContext tcontext)
	{
		String timeStamp= new SimpleDateFormat("YYYY.MM.DD.HH.MM.SS").format(new Date());
		String repName="Test-Report-"+timeStamp+".html";
		
		htmlrep=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		htmlrep.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		exreports=new ExtentReports();
		exreports.attachReporter(htmlrep);
		
		htmlrep.config().setDocumentTitle("InternetBaking Test Results");
		htmlrep.config().setReportName("Functional Testing");
		//htmlrep.config().setTimeStampFormat("yyyy-mm-dd-hh-mm");
		
	}

	
	public void onTestSuccess(ITestResult tr)
	{
		extest=exreports.createTest(tr.getName());
		extest.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
   String screenShotPath=System.getProperty("user.dir")+"/ScreenShots/Passed/"+tr.getName()+".png";
		
		File f=new File(screenShotPath);
		if (f.exists())
		{
			try{
				extest.fail("Screenshot is below:"+extest.addScreenCaptureFromPath(screenShotPath));
			}
		
		catch(Exception e)
		{
			e.printStackTrace();
		
		}}
			
			
	}

	
	public void onTestFailure(ITestResult tr)
	{
		extest=exreports.createTest(tr.getName());
		extest.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String screenShotPath=System.getProperty("user.dir")+"/ScreenShots/Failed/"+tr.getName()+".png";
		
		File f=new File(screenShotPath);
		if (f.exists())
		{
			try{
				extest.fail("Screenshot is below:"+extest.addScreenCaptureFromPath(screenShotPath));
			}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		}
		
	}
	
	public void onFinish(ITestContext context) {
		exreports.flush();
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}
