package com.qa.opencart.utilities;

import org.openqa.selenium.WebDriver;

public class DataUtility {
	
	WebDriver driver;

	public DataUtility(WebDriver driver) {
		this.driver=driver;
	}
	public String randomEmailGenerator() {
		 String random = "random"+System.currentTimeMillis()+"@gmail.com";
		return random;
	  }
}
