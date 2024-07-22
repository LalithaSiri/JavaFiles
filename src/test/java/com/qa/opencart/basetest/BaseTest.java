package com.qa.opencart.basetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.driverinti.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginAccountPage;
import com.qa.opencart.pages.RegisterUserPage;
import com.qa.opencart.utilities.WebElementUtility;


public class BaseTest {
	
	WebDriver driver;
	DriverFactory factory;
	protected Properties prop;
	protected LoginAccountPage loginPage;
	protected AccountPage accountPage;
	protected RegisterUserPage registerPage;
	protected WebElementUtility elementUtility;

@BeforeTest

	public void setUp() throws Exception{
		factory= new DriverFactory();
		
		prop=factory.initProp();
	//	factory.initDriver(prop);
		
		driver= factory.initDriver(prop);
		loginPage=new LoginAccountPage(driver);
		 elementUtility= new WebElementUtility(driver);
		 accountPage= new AccountPage(driver);

	}

@AfterTest
public void tearDown(){
	driver.quit();

}}
