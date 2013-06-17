package argos.saleslogix.selenium.test;

import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

	
	public CommonNavigation clickGlobalMenuItem(String gMenuItem) throws InterruptedException {
		String methodID = "clickGlobalMenuItem";
		
		Boolean hasListview = true;
		switch (gMenuItem.toLowerCase()) {
		case "add account/contact": case "add account contact": case "add":
			gmenu_addAccountContact.click();
			break;
		case "my activities": case "activities":
			gmenu_myActivities.click();
			break;
		case "calendar":
			gmenu_calendar.click();
			hasListview = false;
			break;
		case "notes/history": case "notes history": case "notes":
			gmenu_notesHistory.click();
			break;
		case "accounts": case "account":
			gmenu_accounts.click();
			break;
		case "contacts": case "contact":
			gmenu_contacts.click();
			break;
		case "leads": case "lead":
			gmenu_leads.click();
			break;
		case "opportunities": case "opportunity":
			gmenu_opportunities.click();
			break;
		case "tickets": case "ticket":
			gmenu_tickets.click();
			break;
		case "my attachments": case "attachments": case "attachment":
			gmenu_myAttachments.click();
			break;
		case "configure menu": case "configure":
			gmenu_configureMenu.click();
			break;
		case "settings":
			gmenu_settings.click();
			hasListview = false;
			break;
		case "help":
			gmenu_help.click();
			break;
		case "log off": case "log out": case "logout": case "logoff":
			gmenu_logOut.click();
			hasListview = false;
			break;
		}
		
		System.out.println(methodID + ": global menu link - '" + gMenuItem + "' was clicked.");
		Thread.sleep(1000);
		if (hasListview) {
			waitForListView(gMenuItem);
		} Thread.sleep(3000); {}
		
		return this;
	}
	
	public CommonNavigation waitForListView(String listName) throws InterruptedException {
	    
		String itemList = "";
		
		switch (listName.toLowerCase()) {
		case "my activities": case "activities":
			itemList = "myactivity_list";
			break;
		case "notes/history": case "notes history": case "notes":
			itemList = "history_list";
			break;
		case "accounts": case "account":
			itemList = "account_list";
			break;
		case "contacts": case "contact":
			itemList = "contact_list";
			break;
		case "leads": case "lead":
			itemList = "lead_list";
			break;			
		case "opportunities": case "opportunity":
			itemList = "opportunity_list";
			break;			
		case "tickets": case "ticket":
			itemList = "ticket_list";
			break;			
		case "my attachments": case "attachments": case "attachment":
			itemList = "attachment_list";
			break;	
		//TODO: continue to expand this switch case list for additional list views
		}
		for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.xpath(".//*[@id='" + itemList + "']/ul/li[1]")))
	    		System.out.println("VP: " + listName + " List View was successfully loaded.");
	    		break; 
	    	} 
	    	catch (Exception e) {
	    		System.out.println("Error: " + listName + " List View was NOT successfully loaded.");
	    	}
	    	Thread.sleep(1000);
	    }
	    
		return this;
	}
	
	public CommonNavigation searchListView(String itemType, String searchItemName) throws InterruptedException {
		String methodID = "searchListView";
		
		String searchWgtIDX = "";
		
		switch (itemType.toLowerCase()) {
		case "my activities": case "activities":
			searchWgtIDX = "26";
			break;
		case "notes/history": case "notes history": case "notes":
			searchWgtIDX = "27";
			break;
		case "accounts": case "account":
			searchWgtIDX = "3";
			break;
		case "contacts": case "contact":
			searchWgtIDX = "6";
			break;
		case "leads": case "lead":
			searchWgtIDX = "16";
			break;			
		case "opportunities": case "opportunity":
			searchWgtIDX = "11";
			break;			
		case "tickets": case "ticket":
			searchWgtIDX = "18";
			break;			
		case "my attachments": case "attachments": case "attachment":
			searchWgtIDX = "35";
			break;	
		//TODO: continue to expand this switch case list for additional list views
		}
		
		//input the search item then perform the search
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_" + searchWgtIDX + " > div.table-layout > div > input[name=\"query\"]")).clear();
	    Thread.sleep(500);
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_" + searchWgtIDX + " > div.table-layout > div > input[name=\"query\"]")).sendKeys(searchItemName);
	    Thread.sleep(500);
	    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_" + searchWgtIDX + " > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();	    
	    System.out.println(methodID + ": performing search of '" + searchItemName + "' from " + itemType + " List View...");
	    waitForListView(itemType);
	    
		return this;
	}
	
	public CommonNavigation clickListViewItemN(String listName, Integer itemIndex) throws InterruptedException {
		String methodID = "clickListViewItemN";
		
		String itemList = "";
		
		switch (listName.toLowerCase()) {
		case "my activities": case "activities":
			itemList = "myactivity_list";
			break;
		case "notes/history": case "notes history": case "notes":
			itemList = "history_list";
			break;
		case "accounts": case "account":
			itemList = "account_list";
			break;
		case "contacts": case "contact":
			itemList = "contact_list";
			break;
		case "leads": case "lead":
			itemList = "lead_list";
			break;			
		case "opportunities": case "opportunity":
			itemList = "opportunity_list";
			break;			
		case "tickets": case "ticket":
			itemList = "ticket_list";
			break;			
		case "my attachments": case "attachments": case "attachment":
			itemList = "attachment_list";
			break;	
		//TODO: continue to expand this switch case list for additional list views
		}
		
		//perform the list view item click
		try {
			driver.findElement(By.xpath(".//*[@id='" + itemList + "']/ul/li[" + itemIndex + "]/div/h3")).click();
			System.out.println(methodID + ": clicking '" + itemIndex + "th item ' from the " + listName + " List View...");
		} catch (Exception e) {
			System.out.println("Error: Unable to click the '" + itemIndex + "th' item from the " + listName + " List View.");
			System.out.println(e.toString());
		}
	    
		return this;
	}
	
	public CommonNavigation waitForPageTitle(String pageTitle) throws InterruptedException {
	    
		for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (pageTitle.equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
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
		Thread.sleep(5000);
		return element;
	}
	
	protected boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	    	return false;
	    }
	}
	
}
