package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utilities.TimeWait;
import com.qa.opencart.utilities.WebElementUtility;


public class LoginAccountPage {
	
	private WebDriver driver;
	private By userElement= By.name("email");
	private By passwordElement= By.name("password");
	private By loginButton= By.xpath("//input[@type='submit']");
	protected By logoutLink=By.linkText("Logout");
	WebElementUtility elementUtility;
	
public LoginAccountPage(WebDriver driver) {
		this.driver=driver;
		elementUtility = new WebElementUtility(driver);
	}
public String getLoginPageTitle() 
{
	return elementUtility.getPageTitle();
}
public AccountPage loginToAccount(String emailAddress, String password) {
		elementUtility.doSendKeysValueWithWait(userElement, emailAddress ,TimeWait.WAIT10SECONDS );
		elementUtility.doSendKeysValue(passwordElement, password);
		elementUtility.doClick(loginButton);
		return new AccountPage(driver);
	}
public void logout() {
	elementUtility.doClick(logoutLink);
	
}

}
