package com.qa.opencart.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import com.qa.opencart.utilities.*;

public class RegisterUserPage {
	WebDriver driver;
	WebElementUtility elementUtility;

	
	public RegisterUserPage(WebDriver driver) {
		this.driver = driver;
		elementUtility = new WebElementUtility(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	By firstName_locator = By.name("firstname");
	By lastName_locator = By.name("lastname");
	By email_locator = By.name("email");
	By phone_locator = By.name("telephone");
	By password_locator = By.name("password");
	By pConfirm_locator = By.name("confirm");
	By agree_locator = By.name("agree");
	By submit_locator = By.xpath("//input[@type='submit']");
	By logoutElemant = By.linkText("Logout");
	By confirmationText = By.xpath("//h1[text()='Your Account Has Been Created!']");
	By warning = By.xpath("//div[@class='alert alert-danger alert-dismissible']");

	public String regersterNewUserWithRandom(String name, String email, String phone ) {

		elementUtility.findWebElementWithWait(firstName_locator, 30).sendKeys(name);
		elementUtility.findWebElement(lastName_locator).sendKeys(name);
		elementUtility.findWebElement(email_locator).sendKeys(email);
		elementUtility.findWebElement(phone_locator).sendKeys(phone);
		elementUtility.findWebElement(password_locator).sendKeys(name);
		elementUtility.findWebElement(pConfirm_locator).sendKeys(name);
		elementUtility.findWebElement(agree_locator).click();
		elementUtility.findWebElement(submit_locator).click();

		return elementUtility.findWebElementWithWait(confirmationText, 20).getText();

	}

	public String regersterNewUserWithDuplicate(String name, String email, String phone) {

		elementUtility.findWebElementWithWait(firstName_locator, 30).sendKeys(name);
		elementUtility.findWebElement(lastName_locator).sendKeys(name);
		elementUtility.findWebElement(email_locator).sendKeys(email);
		;
		elementUtility.findWebElement(phone_locator).sendKeys(phone);
		elementUtility.findWebElement(password_locator).sendKeys(name);
		elementUtility.findWebElement(pConfirm_locator).sendKeys(name);
		elementUtility.findWebElement(agree_locator).click();
		elementUtility.findWebElement(submit_locator).click();
		return elementUtility.findWebElementWithWait(warning, 20).getText();

	}

	public void logout() {

		elementUtility.findWebElementWithWait(logoutElemant, 20).click();
	}

}
