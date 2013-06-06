package argos.saleslogix.selenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SLXMobileLogin {
	
	private WebDriver driver;
	
	public SLXMobileLogin(WebDriver driver) {
		this.driver = driver;		
	}
		
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
}
