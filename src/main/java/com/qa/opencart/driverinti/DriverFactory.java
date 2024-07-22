package com.qa.opencart.driverinti;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.exception.OpenCartExceptions;
public class DriverFactory {
	 WebDriver driver;
	Properties prop;
	String browserName;
	public static ThreadLocal<WebDriver> tlDriver= new ThreadLocal<WebDriver>();
	public WebDriver initDriver(Properties prop) {
		String browserrName = prop.getProperty("browser");
		switch (browserrName.trim().toLowerCase())
		{
		case "chrome":
		tlDriver.set(new ChromeDriver());
		//driver= new ChromeDriver();
		break;
		
		case "firefox":
		tlDriver.set(new FirefoxDriver());
		//driver=new FirefoxDriver();
		break;
		case "edge" :
		//driver=new EdgeDriver();
		tlDriver.set(new EdgeDriver());	
		break;
		default : 
			throw new OpenCartExceptions("Browser not found");
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}
	
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	public Properties initProp() throws IOException {
		prop= new Properties();
		try {
		FileInputStream propFileName= new FileInputStream(AppConstants.PROPERTIESPATH);
		prop.load(propFileName);
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
		catch (IOException e) {
		System.out.println(e);
	}
		return prop;}
	
	public static String getScreenshot(String methodName) {
		File srcFile=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		System.out.println("User directory"+System.getProperty("user.dir"));
		String PathScreenShort =System.getProperty("user.dir")+"\\screenshots\\"+methodName+"_"+System.currentTimeMillis()+".png"
		;
		File destination= new File(PathScreenShort);
		try {
			FileHandler.copy(srcFile, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return PathScreenShort;
		
	}
}
