package com.qa.opencart.test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.utilities.DataUtility;

public class RegistrationPageTest extends BaseTest  
	{
	DataUtility dataUtility;
	
	//  @Ignore
	  
//	  @Test( description = "checking login page title...")
		/*
		 * public void loginPageTitleTest() { String title = driver.getTitle();
		 * System.out.println("page title : " + title); Assert.assertEquals(title,
		 * "Register Account","====title is not matched===="); }
		 * 
		 * 
		 * 
		 * 
		 * @DataProvider public Object[][] regesterDataProvider(){ dataUtility= new
		 * DataUtility(driver);
		 * 
		 * return new Object[][] { {"randomFirst",dataUtility.randomEmailGenerator()
		 * ,"3456789010"}
		 * 
		 * }; }
		 */
	  
		
		/*
		 * @Test (dataProvider = "regesterDataProvider") public void
		 * regersterNewAccountTest(String name, String email, String phone ) {
		 * regesterUser = new RegersterUser(driver); //String String String String
		 * confirmMessage=regesterUser.regersterNewUserWithRandom(name, email, phone);
		 * System.out.println("ConfirmMessage"+confirmMessage);
		 * Assert.assertEquals(confirmMessage, "Your Account Has Been Created!");
		 * regesterUser.logout();
		 * 
		 * }
		 */
		 
	 
  	/*  @Test (dataProvider = "regesterDataProvider")
	  public void duplicateAccountTest(String name, String email, String phone) {
  		regesterUser = new RegersterUserPage(driver);  
  	  String warning=regesterUser.regersterNewUserWithDuplicate(name, "random@random.com", phone);
	  System.out.println("Warning message"+warning); Assert.assertEquals(warning ,"Warning: E-Mail Address is already registered!");  }
		 
}*/
	}
