package com.InternetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig
{
    Properties pro;
    
	 public ReadConfig() 
	 {
		 try{
		 File file= new File(System.getProperty("user.dir")+"//Prop.properties");
		 FileInputStream fis=new FileInputStream(file);
		 pro=new Properties();		
		 pro.load(fis);		 
		 	 }
	   catch(Exception e)
	   {
		   e.getMessage();
	   }
	 }
	 public String getApplicationURL()
	 {
		 String url=pro.getProperty("baseURL");
		 return url;
	 }
	 
	 public String getUserName()
	 {
		 String uname=pro.getProperty("username");
		 return uname;
	 }
	 public String getPassword()
	 {
		 String pword=pro.getProperty("password");
		 return pword;
	 }
	 
	 public String getChromePath()
	 {
		String chrome= pro.getProperty("chromepath");
		return chrome;
	 }
	 public String getIePath()
	 {
		String ie= pro.getProperty("iepath");
		return ie;
	 }
	 public String getFirefoxPath()
	 {
		String firefox= pro.getProperty("firefoxpath");
		return firefox;
	 }
	 
	 }
	 
	