package argos.saleslogix.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.AssertJUnit;

public class HeaderButton {

	private WebDriver driver;
	
	public HeaderButton(WebDriver driver) {
		this.driver = driver;		
	}
		
	//@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")
	WebElement globalMenuButton;
	
	//@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")
	WebElement rightCntxtMnuButton;
	
	//@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")
	WebElement addButton;
	
	//@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")
	WebElement editButton;
	
	//@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")
	WebElement saveButton;
	
	//@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")
	WebElement checkButton;
	
	//@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")
	WebElement deleteButton;
	
	//@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")
	WebElement cancelButton;
	
	//@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")
	WebElement backButton1;
	
	//@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")
	WebElement backButton2;
	
	public WebElement getSafeElement(By locator) throws InterruptedException {
		int i = 0;
		WebElement element = null;
		while (i < 5) {
			try {
				element = driver.findElement(locator);
				element.click();
				break;
			} catch (Exception e) {
				Thread.sleep(1000);
				element = driver.findElement(locator);
				element.click();
			}
		}
		return element;
		}
	
	public HeaderButton showGlobalMenu() throws InterruptedException {
		// Click Header Global Menu button...
		clickHeaderButton("global");
		
		// Verify the 'Global Menu' left-screen displays...
		try {
			AssertJUnit.assertTrue(driver.findElement(By.xpath(".//*[@id='left_drawer']/div[3]/h2[1]")).isDisplayed());
			System.out.println("VP: Global Menu was accessed successfully on header button click.");
		} catch (Error e) {     
			System.out.println("Error: Global Menu failed to display on header button click.");
			System.out.println(e.toString());
		}
		Thread.sleep(1000);
		return this;
	}
	
	public boolean showRightContextMenu() throws InterruptedException {
		String methodID = "showRightContextMenu";
		
		// Click Header Right-Context Menu button...
		clickHeaderButton("right context menu");
		
		// Verify the 'Right-Context Menu' left-screen displays...
		try {
			AssertJUnit.assertTrue(driver.findElement(By.xpath(".//*[@id='right_drawer']/div")).isDisplayed());
			System.out.println(methodID + ": Right-Context Menu was accessed successfully on header button click.");
			return true;
		} catch (Error e) {     
			System.out.println(methodID + ": Right-Context Menu failed to display on header button click.");
			System.out.println(e.toString());
			return false;
		}
	}
	
	public HeaderButton goBack() throws InterruptedException {
		String methodID = "goBack";
		
		WebElement pgTitleBar = driver.findElement(By.xpath(".//*[@id='pageTitle']"));
		String oldPgTitle = driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText();		

		//determine which button to actually click (back button placement varies)
		pgTitleBar.click();
		pgTitleBar.sendKeys(Keys.BACK_SPACE);
		/*
		try {
			backButton2.click();
		}
		finally {
			backButton1.click();
		}
		*/
		Thread.sleep(1000);
		
		String newPgTitle = driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText();
		
		// Verify that previous page is displayed (new title not equal to old)
		try {
			AssertJUnit.assertFalse(oldPgTitle == newPgTitle);
		} catch (Error e) {     
			System.out.println(e.toString());
		}
		return this;
	}
	
	public HeaderButton clickHeaderButton(String buttonName) throws InterruptedException {
		String methodID = "clickHeaderButton";
		
		switch (buttonName.toLowerCase()) {
		case "global menu": case "global":
			globalMenuButton.click();
			break;
		case "right context menu": case "right menu": case "right":
			rightCntxtMnuButton.click();
			break;
		case "back": case "go back":
			if (backButton2.isDisplayed()) { 
				backButton2.click();
			}
			else {
				backButton1.click();
			}
			break;
		case "cancel":
			cancelButton.click();
			break;
		case "add": case "add new":
			addButton.click();
			break;
		case "edit":
			editButton.click();
			break;
		case "check": case "accept":
			checkButton.click();
			break;
		case "delete":
			deleteButton.click();
			break;
		case "save":
			saveButton.click();
			break;
		}
		
		System.out.println(methodID + ": header button - '" + buttonName + "' was clicked.");
		Thread.sleep(1500);
		return this;
	}
}
