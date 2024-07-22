package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utilities.WebElementUtility;

public class AccountPage
{
	WebDriver driver;
	WebElementUtility elementUtility;
	protected By headerElements= By.cssSelector("#content h2");
	protected By logoutMessage= By.cssSelector("#content h1");
	protected By logOutLink = By.linkText("Logout");
	protected By logoutTitle= By.cssSelector("#content h1");
	
public AccountPage(WebDriver driver) {
	this.driver=driver;
	elementUtility = new WebElementUtility(driver);
}	
	
public String getPageTitle() {
	
	return elementUtility.getPageTitle();
}	

public List<String> getHeaderElements() {
	List<String> listElements= new ArrayList<String>();
	List<WebElement> webEleList= elementUtility.getListElements(headerElements);
for(WebElement e: webEleList ) {
	
	String listName= e.getText();
	listElements.add(listName);
}
return listElements;

}

public void logoutAccountsPage() {
	elementUtility.doClick(logOutLink);
	
}


}