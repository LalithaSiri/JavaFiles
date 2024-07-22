package com.qa.opencart.utilities;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Authenticator;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SubjectTerm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class EqBrikOTP {
	
	String host = "imap.gmail.com";
	String username = "lsnsponsor@gmail.com";
	String password = "xavr iyox cied mxqj";
	Session session;
	Store store;
	Folder inbox;
	String OTP;
	
//	public static void main(String arg[]) throws MessagingException, InterruptedException {
	//@Test
	//public void readandCreate() throws MessagingException, InterruptedException {
	/*
	 * WebDriver driver; By signUpNowLink= By.xpath("//a[@id='createAccount']"); By
	 * emailID= By.id("email"); By sendOTP=
	 * By.id("emailVerificationControl_but_send_code"); By emailVarificationCode=
	 * By.id("emailVerificationCode"); By buttonVerifyCode=
	 * By.id("emailVerificationControl_but_verify_code");// WebElementUtility
	 * elementUtility;
	 */
	
	
	// driver= new ChromeDriver();
		/*
		 * driver.get("https://qa-sponsor.equitybrix.net/"); EqBrikOTPTest email = new
		 * EqBrikOTPTest(); email.deleteEmail(); Thread.sleep(5000); elementUtility= new
		 * WebElementUtility(driver); elementUtility.findWebElement(signUpNowLink).
		 * click(); elementUtility.doSendKeysValueWithWait(emailID,
		 * "lsnsponsor+100@gmail.com",5000);
		 * elementUtility.findWebElementWithWait(sendOTP,TimeWait.WAIT10SECONDS).click()
		 * ; Thread.sleep(8000);
		 */
	//	String newOTP=email.getOTP();
				
//				elementUtility.doSendKeysValueWithWait(emailVarificationCode, newOTP, TimeWait.WAIT5SECONDS);
	//			elementUtility.findWebElementWithWait(buttonVerifyCode, TimeWait.WAIT30SECONDS).click();
	//}
	
//	}
	public String getOTP() {
		try {
			//deleteEmail();
			store= ConnectEmail();
					//Session session = Session.getInstance(props, null);
					// store = session.getStore("imaps");
					store.connect(host, username, password);
					Folder inbox = store.getFolder("inbox");
					inbox.open(Folder.READ_ONLY);
					if(inbox.getUnreadMessageCount()>0) {
					Message[] messages = inbox.getMessages();
					if (messages.length > 0) {
						Message latestMessage = messages[messages.length-1];
						String messageContent="";
						Object content = latestMessage.getContent();
						messageContent = (String) content;
						String regex="Your code is: .*([0-9]{6}).*";
						Pattern pattern = Pattern.compile(regex);
						Matcher matcher = pattern.matcher(messageContent);
						if (matcher.find()) {
							OTP = matcher.group(1);
							// String[] onlyotp= otp.split("Your code is: .*([0-9]{6}).*");
							// String[] onlyotp1= onlyotp[1].split("</span>");
							System.out.println("OTP found: " + OTP);
						} else {
							System.out.println("No OTP found in the email.");
						}
					} else {
						System.out.println("No messages in inbox.");
					}
					// Close connection
					inbox.close(false);
					store.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		return OTP;
	}
	
	

	public Store ConnectEmail() throws MessagingException {
	//Store  store1;
		 Properties props = new Properties(); props.setProperty("mail.store.protocol",
				  "imaps"); props.setProperty("mail.imap.ssl.enable", "true");
				  props.setProperty("mail.imap.host", host);
				  props.setProperty("mail.imap.port", "993");

	         session = Session.getDefaultInstance(props, new Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(username, password);
	            }
	         Session session = Session.getInstance(props, null);
	         
	        });
	         Store store1 = session.getStore("imaps");
			return store1;
	}
	
	public void deleteEmail() throws MessagingException {
		 String subjectToDelete = "EquityBrix Demo account email verification code";
		  store= ConnectEmail();
	            // Connect to the IMAP server
	         try {   
	            store.connect(host, username, password);

	            // Open the inbox folder
	             inbox = store.getFolder("INBOX");
	            inbox.open(Folder.READ_WRITE);

	            // Fetch messages from the inbox
	           // Message[] messages = inbox.getMessages();
	            Message[] messages = inbox.search(new SubjectTerm(subjectToDelete));

	            // Delete the first message as an example
	            if (messages.length > 0) {
	                Message messageToDelete = messages[0];
	                System.out.println("Deleting message: " + messageToDelete.getSubject());
	                
	                // Mark the message for deletion
	                messageToDelete.setFlag(Flags.Flag.DELETED, true);

	                // Close the folder and expunge the deleted message
	                inbox.close(true); // true to expunge deleted messages
	            } else {
	                System.out.println("No messages found in the inbox.");
	            }

	            // Close the store
	            store.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {
	            try {
	                // Ensure folder is closed and messages are expunged
	                if (inbox != null && inbox.isOpen()) {
	                    inbox.close(true); // true to expunge deleted messages
	                }
	                if (store != null) {
	                    store.close();
	                }
	            } catch (MessagingException e) {
	                e.printStackTrace();
	            }
	        }}}
	

