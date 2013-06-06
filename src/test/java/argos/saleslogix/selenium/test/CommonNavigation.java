package argos.saleslogix.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CommonNavigation {
	private WebDriver driver;

	public CommonNavigation(WebDriver driver) {
		this.driver = driver;		
	}
	
	//Global Menu Items
	@CacheLookup
	@FindBy(xpath = ".//*[@id='left_drawer']/descendant::*[text() = 'Add Account/Contact']")
	WebElement gmenu_addAccountContact;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='left_drawer']/descendant::*[text() = 'My Activities']")
	WebElement gmenu_myActivities;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='left_drawer']/descendant::*[text() = 'Calendar']")
	WebElement gmenu_calendar;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='left_drawer']/descendant::*[text() = 'Notes/History']")
	WebElement gmenu_notesHistory;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='left_drawer']/descendant::*[text() = 'Accounts']")
	WebElement gmenu_accounts;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='left_drawer']/descendant::*[text() = 'Contacts']")
	WebElement gmenu_contacts;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='left_drawer']/descendant::*[text() = 'Leads']")
	WebElement gmenu_leads;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='left_drawer']/descendant::*[text() = 'Opportunities']")
	WebElement gmenu_opportunities;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='left_drawer']/descendant::*[text() = 'Tickets']")
	WebElement gmenu_tickets;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='left_drawer']/descendant::*[text() = 'My Attachments']")
	WebElement gmenu_myAttachments;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='left_drawer']/descendant::*[text() = 'Configure Menu']")
	WebElement gmenu_configureMenu;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='left_drawer']/descendant::*[text() = 'Settings']")
	WebElement gmenu_settings;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='left_drawer']/descendant::*[text() = 'Help']")
	WebElement gmenu_help;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='left_drawer']/descendant::*[text() = 'Log Out']")
	WebElement gmenu_logOff;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='left_drawer']/descendant::*[text() = 'Log Out']")
	WebElement gmenu_logOut;
	
	// Menus
	
	@CacheLookup
	@FindBy(id = "mnuNew_text")
	WebElement menu_New;
		
	// Save button 
	@CacheLookup
	//@FindBy(xpath = ".//*[@id='MainContent']/descendant::*[contains(@id,'_btnSave')]")
	@FindBy(xpath = ".//*[@id='MainContent']/descendant::*[@title='Save']")
	WebElement save;
	

	public CommonNavigation addAcctContact() throws InterruptedException {
		gmenu_addAccountContact.click();
		Thread.sleep(3000);
		return this;
	}
	
	public CommonNavigation myActivities() throws InterruptedException {
		gmenu_myActivities.click();
		Thread.sleep(3000);
		return this;
	}
	
	public CommonNavigation calendar() throws InterruptedException {
		gmenu_calendar.click();
		Thread.sleep(3000);
		return this;
	}
	
	public CommonNavigation notesHistory() throws InterruptedException {
		gmenu_notesHistory.click();
		Thread.sleep(3000);
		return this;
	}
	
	public CommonNavigation accounts() throws InterruptedException {
		gmenu_accounts.click();
		Thread.sleep(3000);
		return this;
	}
	
	public CommonNavigation contacts() throws InterruptedException {
		gmenu_contacts.click();
		Thread.sleep(3000);
		return this;
	}
	
	public CommonNavigation leads() throws InterruptedException {
		gmenu_leads.click();
		Thread.sleep(3000);
		return this;
	}
	
	public CommonNavigation opportunities() throws InterruptedException {
		gmenu_opportunities.click();
		Thread.sleep(3000);
		return this;
	}
	
	public CommonNavigation tickets() throws InterruptedException {
		gmenu_tickets.click();
		Thread.sleep(3000);
		return this;
	}
	
	public CommonNavigation myAttachments() throws InterruptedException {
		gmenu_myAttachments.click();
		Thread.sleep(3000);
		return this;
	}
	
	public CommonNavigation configureMenu() throws InterruptedException {
		gmenu_configureMenu.click();
		Thread.sleep(3000);
		return this;
	}
	
	public CommonNavigation settings() throws InterruptedException {
		gmenu_settings.click();
		Thread.sleep(3000);
		return this;
	}
	
	public CommonNavigation help() throws InterruptedException {
		gmenu_help.click();
		Thread.sleep(3000);
		return this;
	}
	
	public CommonNavigation logOut() throws InterruptedException {
		gmenu_logOut.click();
		Thread.sleep(3000);
		return this;
	}
	
	
	public WebElement clickListViewGridItem(By locator) throws InterruptedException {
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
		//Thread.sleep(10000);
		Thread.sleep(5000);
		return element;
		}
}
