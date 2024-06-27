package com.qa.opencart.driverinti;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.exception.OpenCartExceptions;
public class DriverFactory {
	 WebDriver driver;
	Properties prop;
	String browserName;
	public WebDriver initDriver(Properties prop) {
		String browserrName = prop.getProperty("browser");
		switch (browserrName.trim().toLowerCase())
		{
		case "chrome":
		driver= new ChromeDriver();
		break;
		
		case "firefox":
		driver=new FirefoxDriver();
		break;
		case "edge" :
		driver=new EdgeDriver();
		break;
		default : 
			throw new OpenCartExceptions("Browser not found");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;
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
}
