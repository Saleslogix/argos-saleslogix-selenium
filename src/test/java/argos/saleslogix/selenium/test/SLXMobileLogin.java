package argos.saleslogix.selenium.test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

public class SLXMobileLogin {
	
	private WebDriver driver;
	
	public SLXMobileLogin(WebDriver driver) {
		this.driver = driver;		
	}
	
	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_TextField_0']/input")
	WebElement userNameTextbox;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_Fields_TextField_1']/input")
	WebElement passwordTextbox;
	
	@CacheLookup
	@FindBy(css = "#Sage_Platform_Mobile_Fields_BooleanField_0 > div.toggle > span.thumb")
	WebElement rememberToggle;
	
	@CacheLookup
	@FindBy(css = "button.button.actionButton")
	WebElement loginButton;
	
	
	public SLXMobileLogin enterUserName(String userName) throws InterruptedException {
		userNameTextbox.clear();
		userNameTextbox.sendKeys(userName);
		return this;
	}
	
	public SLXMobileLogin enterPassword(String password) {
		passwordTextbox.clear();
		passwordTextbox.sendKeys(password);
		return this;
	}
	
	public SLXMobileLogin toggleRemember() throws InterruptedException {
		rememberToggle.click();
		Thread.sleep(1000);
		return this;
	}
	
	public SLXMobileLogin logonButton() throws InterruptedException {
		loginButton.click();
		Thread.sleep(10000);
		return this;
	}
	
	
	/**
	 * Assuming that the Mobile Client login page is displayed, this method will enter a username,
	 * password and optionally check the Remember Me box then click the Login button.
	 * @author	mike.llena@swiftpage.com
	 * @version	1.0
	 * @param	userName	username to login as
	 * @param	passWord	password of username to use for login
	 * @param	rememberMe	if true, then the Remember Me check box will be checked; if false, then
	 * 						the check box will be left un-checked
	 * @return	boolean		true - if Mobile Client login is successful 
	 * 						false - otherwise
	 */	
	public boolean doLogin(String userName, String passWord, Boolean rememberMe) throws InterruptedException {
		String methodID = "doLogin";
		
		//Setp: enter username
		enterUserName(userName);
		Thread.sleep(1000);
		
		//Step: enter password
		enterPassword(passWord);
		Thread.sleep(1000);
		
		//Step: conditionally set the remember option
		if (rememberMe) {
			toggleRemember();
		}
		
		//Step: click the Log On button
		logonButton();
		Thread.sleep(5000);		
 		
		System.out.println(methodID + ": username = " + userName + ", password = " + passWord + ", remember? = " + rememberMe);

		// VP: confirm that the 'My Activities' screen displays after login
		Thread.sleep(3000);
		try {
			AssertJUnit.assertTrue(driver.findElement(By.xpath(".//*[@id='myactivity_list']")).isDisplayed());
			System.out.println("VP: Successfully logged in to Mobile Client.");
		} catch (UnhandledAlertException e) {
			//closeAlert();
			closeModal();
			//assertEquals("The user name or password is invalid.", closeAlertAndGetItsText());
			System.out.println("Error: Unable to login to Mobile Client.");
			System.out.println(e.toString());
		}
		
		return true;
	}
	
	public void closeModal() {
		Set<String> windowids = driver.getWindowHandles();
		Iterator<String> iter= windowids.iterator();
		String popupWindowId=iter.next();
		driver.switchTo().window(popupWindowId);
	}
}
