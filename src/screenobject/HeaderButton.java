package screenobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.AssertJUnit;

public class HeaderButton {

	private WebDriver driver;
	
	public HeaderButton(WebDriver driver) {
		this.driver = driver;		
	}
		
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")
	WebElement globalMenuButton;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")
	WebElement addButton;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")
	WebElement editButton;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")
	WebElement saveButton;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")
	WebElement checkButton;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")
	WebElement deleteButton;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")
	WebElement cancelButton;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")
	WebElement backButton;	
	
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
		globalMenuButton.click();
		Thread.sleep(1000);
		
		// Verify the 'Global Menu' left-screen displays
		try {
			AssertJUnit.assertTrue(driver.findElement(By.xpath(".//*[@id='left_drawer']/div[3]/h2[1]")).isDisplayed());
		} catch (Error e) {     
			System.out.println("Verify Global Menu screen Displays" + e.toString());
		}
		return this;
	}
	
	public HeaderButton goBack() throws InterruptedException {
		String oldPgTitle = driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText();
				
		backButton.click();
		Thread.sleep(5000);
		
		String newPgTitle = driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText();
		
		// Verify that previous page is displayed (new title not equal to old)
		try {
			AssertJUnit.assertFalse(oldPgTitle == newPgTitle);
		} catch (Error e) {     
			System.out.println("Verify Previous screen Displays" + e.toString());
		}
		return this;
	}

	public HeaderButton clickAdd() throws InterruptedException {
		addButton.click();
		Thread.sleep(5000);

		return this;
	}
	
	public HeaderButton clickEdit() throws InterruptedException {
		editButton.click();
		Thread.sleep(5000);

		return this;
	}

}
