package com.qa.opencart.utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementUtility {

	
	WebDriver driver;

public WebElementUtility(WebDriver driver) {
	this.driver=driver;
}


//######################## Basic Find Web Elements ###############################

public WebElement findWebElement(By locator) {
	return driver.findElement(locator);
	
}
public void doSendKeysValue(By locator, String value) {
	
	findWebElement(locator).sendKeys(value);
}
public void doClick(By locator) {
findWebElement(locator).click();	
}

public String getPageTitle() {
	return driver.getTitle();
	
}
public List<WebElement> getListElements(By locator) {
	
List<WebElement> elementList;
return elementList=driver.findElements(locator);
}



//######################## Find Web Elements with WAIT ###############################


public WebElement findWebElementWithWait(By locator, int waitTime) {
	
	WebDriverWait pause= new WebDriverWait(driver, Duration.ofSeconds(waitTime));
	return pause.until(ExpectedConditions.presenceOfElementLocated(locator));
}
public void doSendKeysValueWithWait(By locator, String value, int waitTime) {
	WebDriverWait pause= new WebDriverWait(driver, Duration.ofSeconds(waitTime));
	pause.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(value);
}
public void doClickWithWait(By locator, int waitTime) {
	findWebElementWithWait(locator, waitTime).click();	
}



}