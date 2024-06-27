package com.qa.opencart.test;


import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.utilities.EqBrikOTP;
import com.qa.opencart.utilities.TimeWait;
import com.qa.opencart.utilities.WebElementUtility;

public class ReadOTPTest extends BaseTest{
	WebDriver driver;
	@Test
		public void readandCreate() throws  InterruptedException, MessagingException {
		
		  By signUpNowLink= By.xpath("//a[@id='createAccount']"); 
		  By emailID= By.id("email"); 
		  By sendOTPButton=By.id("emailVerificationControl_but_send_code"); 
		  By emailVarificationCode=By.id("emailVerificationCode"); 
		  By buttonVerifyCode=By.id("emailVerificationControl_but_verify_code");// 
		  By buttonChangeEmail=By.id("emailVerificationControl_but_change_claims");
		  WebElementUtility elementUtility;
		  driver= new ChromeDriver();
		  driver.get("https://qa-sponsor.equitybrix.net/"); 
			  EqBrikOTP email = new EqBrikOTP();  
			  Thread.sleep(5000); 
			  email.deleteEmail();
			  elementUtility= new WebElementUtility(driver); elementUtility.findWebElement(signUpNowLink).
			  click(); elementUtility.doSendKeysValueWithWait(emailID,
			  "lsnsponsor+100@gmail.com",5000);
			  elementUtility.findWebElementWithWait(sendOTPButton,TimeWait.WAIT10SECONDS).click(); 
			  Thread.sleep(10000);
			 //wait(10000);
			  //email.deleteEmail();
			String newOTP=email.getOTP();
				elementUtility.doSendKeysValueWithWait(emailVarificationCode, newOTP, TimeWait.WAIT5SECONDS);
				elementUtility.findWebElementWithWait(buttonVerifyCode, TimeWait.WAIT30SECONDS).click();
				elementUtility.findWebElement(buttonChangeEmail).isDisplayed();
		}
		
}
