package argos.saleslogix.selenium.test;

//import static org.junit.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

public class CommonNavigation {
	private WebDriver driver;

	public CommonNavigation(WebDriver driver) {
		this.driver = driver;		
	}
	
	//Global Menu Items
	@CacheLookup
	@FindBy(xpath = ".//*[@id='left_drawer']")
	WebElement gmenu_panel;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='left_drawer']/descendant::*[text() = 'Add Account/Contact']")
	WebElement gmenu_addAccountContact;

	@CacheLookup
	@FindBy(xpath = ".//*[@id='left_drawer']/descendant::*[text() = 'SpeedSearch']")
	WebElement gmenu_speedSearch;
	
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

	
	//Right Context Menu Items
	@CacheLookup
	@FindBy(xpath = ".//*[@id='right_drawer']")
	WebElement rmenu_panel;

	@CacheLookup
	@FindBy(xpath = ".//*[@id='right_drawer']/div[4]/h2[1]")
	WebElement rmenu_HashTagsHdr;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='right_drawer']/div[4]/ul[1]")
	WebElement rmenu_HashTagsSubPnl;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='right_drawer']/div[4]/h2[2]")
	WebElement rmenu_KPIHdr;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='right_drawer']/div[4]/ul[2]")
	WebElement rmenu_KPISubPnl;
	
	
	public CommonNavigation clickGlobalMenuItem(String gMenuItem) throws InterruptedException {
		String methodID = "clickGlobalMenuItem";
		
		//click the Page Title (forces closure of any blocking panels)
		driver.findElement(By.id("pageTitle")).click();
		Thread.sleep(1000);
		
		//conditionally click the GlobalMenu button to reveal panel
		WebElement glblMenuPnl = driver.findElement(By.xpath(".//*[@id='left_drawer']"));
		if (!glblMenuPnl.isDisplayed()) {
			driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
			Thread.sleep(1000);
		}
						
		Boolean hasListview = true;
		try {
			switch (gMenuItem.toLowerCase()) {
			case "add account/contact": case "add account contact": case "add":
				highlightNClick(gmenu_addAccountContact);
				break;
			case "speedsearch": case "search":
				highlightNClick(gmenu_speedSearch);
				break;			
			case "my activities": case "activities":				
				highlightNClick(gmenu_myActivities);
				break;
			case "calendar":
				highlightNClick(gmenu_calendar);
				hasListview = false;
				break;
			case "notes/history": case "notes history": case "notes":
				highlightNClick(gmenu_notesHistory);
				break;
			case "accounts": case "account":
				highlightNClick(gmenu_accounts);
				break;
			case "contacts": case "contact":
				highlightNClick(gmenu_contacts);
				break;
			case "leads": case "lead":
				highlightNClick(gmenu_leads);
				break;
			case "opportunities": case "opportunity":
				highlightNClick(gmenu_opportunities);
				break;
			case "tickets": case "ticket":
				highlightNClick(gmenu_tickets);
				break;
			case "my attachments": case "attachments": case "attachment":
				highlightNClick(gmenu_myAttachments);
				break;
			case "configure menu": case "configure":
				highlightNClick(gmenu_configureMenu);
				break;
			case "settings":
				highlightNClick(gmenu_settings);
				hasListview = false;				
				break;
			case "help":
				highlightNClick(gmenu_help);
				break;
			case "log off": case "log out": case "logout": case "logoff":
				highlightNClick(gmenu_logOut);
				hasListview = false;
				break;
			}
			
			System.out.println(methodID + ": global menu link - '" + gMenuItem + "' was clicked.");
			Thread.sleep(1000);
			if (hasListview) {
				waitForListView(gMenuItem);
			} Thread.sleep(3000); {}
		}
		catch (Error e) {
			  System.out.println(e.toString());
		}
		return this;
	}
	
	public boolean rightClickContextMenuItem(String menuItem) throws InterruptedException {
		String methodID = "rightClickContextMenuItem";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		//conditionally click the RightContext Menu button to reveal panel
		if (!commNav.rmenu_panel.isDisplayed()) {
			driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
			System.out.println(methodID + ": the '" + menuItem + " Right-context Menu item was clicked.");
			Thread.sleep(1000);
			
			try {
				AssertJUnit.assertTrue(commNav.rmenu_panel.isDisplayed());
			}
			catch (Error e) {
				System.out.println(e.toString());
				return false;
			}					
		}
		
		//Step: perform context menu item selection
		WebElement contxtMnuItem = driver.findElement(By.xpath("//*[@id='right_drawer']/descendant::*[text() = '" + menuItem + "']"));
		highlightNClick(contxtMnuItem);
		Thread.sleep(2000);
		
		//conditionally close the Right-Context menu...
		if (driver.findElement(By.xpath(".//*[@id='right_drawer']")).isDisplayed()) {
			// Click Page Title to close...
			driver.findElement(By.id("pageTitle")).click();
			Thread.sleep(1000);
		}
		return true;
	}
	
	public boolean checkIfWebElementPresent(String sDesc, WebElement wElement) throws InterruptedException {
		String methodID = "checkIfWebElementPresent";
		
		try {
			AssertJUnit.assertTrue(wElement.isDisplayed());
			highlightElement(wElement);
			System.out.println(methodID + ": " + sDesc + " is displayed on the current page/screen.");
			return true;
		}
		catch (Error e) {
			System.out.println(e.toString());
			System.out.println(methodID + ": " + sDesc + " is NOT displayed on the current page/screen.");
			return false;
		}
	}
	
	public boolean clickWebElementToPage(String sDesc, WebElement wElement, String expPageTitle) throws InterruptedException {
		String methodID = "clickWebElementToPage";
		
		try {
			highlightElement(wElement);
			wElement.click();
			boolean pgOpened = waitForPage(expPageTitle);
			if (pgOpened) {
				System.out.println(methodID + ": clicking the " + sDesc + " page element successfully opened the '" + expPageTitle + "' page/screen.");
				return pgOpened;
			}
			else {
				return pgOpened;
			}
		}
		catch (Error e) {
			System.out.println(e.toString());
			return false;
		}
	}
	

	public void setupInputFieldValue(WebElement inputFld, String inputValue) {
		try {
			inputFld.click();
			inputFld.sendKeys(inputValue);
			inputFld.sendKeys(Keys.RETURN);
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	
	protected boolean verifyEntityViewElementClick(String elementDesc, WebElement wElement, String expPgTitle) throws InterruptedException {
		String methodID = "verifyEntityViewElementClick";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		try { commNav.clickWebElementToPage(elementDesc, wElement, expPgTitle);
			headerButton.goBack();
			return true;
		} catch (Error e) {
			System.out.println(e.toString());
			return false;
		}
		
	}
	
	
	public CommonNavigation waitForListView(String listName) throws InterruptedException {
	    
		String itemList = "";
		
		try {
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
		    	if (second >= 60) AssertJUnit.fail("timeout");
		    	try { if (isElementPresent(By.xpath(".//*[@id='" + itemList + "']/ul/li[1]")))
		    		System.out.println("VP: " + listName + " List View was successfully loaded.");
		    		break; 
		    	} 
		    	catch (Exception e) {
		    		System.out.println("Error: " + listName + " List View was NOT successfully loaded.");
		    	}
		    	Thread.sleep(1000);
		    }
		}
		catch (Error e) {
			  System.out.println(e.toString());
		}	    
		return this;
	}
	
	public void scrollDownPage() throws InterruptedException {
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(3000);
	}
	
	public CommonNavigation searchListView(String itemType, String searchItemName) throws InterruptedException {
		String methodID = "searchListView";
		
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		String searchWgtIDX = "";
		Boolean forSpdSrch = false;
		
		switch (itemType.toLowerCase()) {
		case "speedsearch": case "search": case "speed search":
			searchWgtIDX = "0";
			forSpdSrch = true;
			break;
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
		try {
		    if (forSpdSrch) {
		    	//invoke Global Menu
		    	headerbutton.showGlobalMenu();
		    			    	
		    	driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input")).clear();
		    	Thread.sleep(500);
		    	driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[2]/button")).click();
		    	Thread.sleep(1000);
		    	driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input")).sendKeys(searchItemName);
		    	Thread.sleep(500);
		    	driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[3]/button")).click();
		    }
		    else {
				//invoke the Right Context menu
				headerbutton.clickHeaderButton("right context menu");
				
		    	driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_SearchWidget_" + searchWgtIDX + "']/div/div[1]/input")).clear();
		    	Thread.sleep(500);
		    	driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_SearchWidget_" + searchWgtIDX + "']/div/div[2]/button")).click();
		    	Thread.sleep(1000);
		    	driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_SearchWidget_" + searchWgtIDX + "']/div/div[1]/input")).sendKeys(searchItemName);
		    	Thread.sleep(500);
		    	driver.findElement(By.xpath("//*[@id='Sage_Platform_Mobile_SearchWidget_" + searchWgtIDX + "']/div/div[3]/button")).click();	    	
		    }
		    System.out.println(methodID + ": performing search of '" + searchItemName + "' from " + itemType + " List View...");
		    waitForListView(itemType);
		}
		catch (Error e) {
			  System.out.println(e.toString());
		}
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
	
	public boolean waitForPage(String pageTitle) throws InterruptedException {
		String methodID = "waitForPage";
	    
		for (int second = 0;; second++) {
			Thread.sleep(100);
	    	if (second >= 6000) AssertJUnit.fail("timeout");
	    	try { 
	    		AssertJUnit.assertEquals(pageTitle, driver.findElement(By.xpath("//*[@id='pageTitle']")).getText());
	    		System.out.println(methodID + ": '" + pageTitle + "' page was successfully loaded");
	    		return true;
	    	} catch (Error e) {
	    		System.out.println(methodID + " " + e.toString());
	    		return false;
	    	}
	    }		
	}
	
	public CommonNavigation waitForNotPage(String pageTitle) throws InterruptedException {
		String methodID = "waitForNotPage";
	    
		for (int second = 0;; second++) {
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if (!pageTitle.equals(driver.findElement(By.xpath("//*[@id='pageTitle']")).getText()))
	    		System.out.println(methodID + ": '" + pageTitle + "' page was successfully navigated away from");
	    		break;
	    	} catch (Exception e) {
	    		System.out.println(methodID + ": '" + pageTitle + "' page failed to navigate away from prior to timeout");
	    	}
	    	Thread.sleep(1000);
	    }
		Thread.sleep(1000);
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
		Thread.sleep(3000);
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
	
	protected boolean isElementDisplayed(By by) {
		
	    try {
	    	AssertJUnit.assertTrue(driver.findElement(by).isDisplayed());
	    	return true;
	    } 
	    catch (NoSuchElementException e) {
	    	System.out.println(e.toString());
	    	return false;
	    }
	}
	
	public boolean isWebElementPresent(String sDesc, WebElement wElement) throws InterruptedException {
		String methodID = "isWebElementPresent";
		
		try { highlightElement(wElement);
			System.out.println(methodID + ": " + sDesc + " is displayed on the current page/screen.");
			return true;
		}
		catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public boolean isPageDisplayed(String pageTitle) {		
		String methodID = "isPageDisplayed";
		
    	if (pageTitle.equals(driver.findElement(By.id("pageTitle")).getText())) {
    		System.out.println(methodID + ": '" + pageTitle + "' page was successfully loaded");
    		return true; 
    	}
    	else {
    		System.out.println(methodID + ": '" + pageTitle + "' page was NOT successfully loaded");
    		return false;		
    	}
	}
	
	
	public boolean isTextNotPresentOnPage(String pageText) throws InterruptedException {
		String methodID = "isTextNotPresentOnPage";		
		
		Boolean checkResult = false;
		
		for (int second = 0;; second++) {
			Thread.sleep(100);
			if (second >= 600) 
				AssertJUnit.fail(methodID + ": page text '" + pageText + "' was not found before timeout expiration");
				try { if (!driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + pageText + "[\\s\\S]*$"))
					System.out.println(methodID + ": '" + pageText + "' was confirmed not to be present on the current page/screen");
					checkResult = true;
					break;
				}
				catch (Error e) {
					System.out.println(e.toString());
				}	
			}
		return checkResult;
	}
	
	
	public boolean isTextPresentOnPage(String pageText) throws InterruptedException {
		String methodID = "isTextPresentOnPage";
		
		Boolean checkResult = false;
		
		for (int second = 0;; second++) {
			Thread.sleep(100);
			if (second >= 600) 
				AssertJUnit.fail(methodID + ": page text '" + pageText + "' was not found before timeout expiration");
				try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + pageText + "[\\s\\S]*$"))
					System.out.println(methodID + ": '" + pageText + "' was confirmed to be present on the current page/screen");
					checkResult = true;
					break;
				}
				catch (Error e) {
					System.out.println(e.toString());
				}	
			}
		return checkResult;
	}


	public WebElement entityListViewSearch(String entityType, String entityName) throws Exception {
		String methodID = "entityListViewSearch";
		
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
			
	    //Step: click Top-Left button to reveal Global Menu...
		headerbutton.showGlobalMenu();
	
	    //Step: navigate to entity list view...
		clickGlobalMenuItem(entityType);
	
	    //Step: perform search for entity record items...
		if (entityType.toLowerCase().equals("contacts") || entityType.toLowerCase().equals("leads")) {
			String nameTokens[] = entityName.split(",");
			String lastName = nameTokens[0];
			searchListView(entityType, lastName);
		}
		else {
			searchListView(entityType, entityName);
		}
		
		//SubStep: singularize the entityType parameter
		String entListNameXPth = "";
		switch (entityType.toLowerCase()) {
		case "my activities": case "activities":
			entListNameXPth = ".//*[@id='myactivity_list']";
			break;
		case "notes/history": case "notes history": case "notes":
			entListNameXPth = ".//*[@id='history_list']";
			break;
		case "accounts": case "account":
			entListNameXPth = ".//*[@id='account_list']";
			break;
		case "contacts": case "contact":
			entListNameXPth = ".//*[@id='contact_list']";
			break;
		case "leads": case "lead":
			entListNameXPth = ".//*[@id='lead_list']";
			break;			
		case "opportunities": case "opportunity":
			entListNameXPth = ".//*[@id='opportunity_list']";
			break;			
		case "tickets": case "ticket":
			entListNameXPth = ".//*[@id='ticket_list']";
			break;			
		case "my attachments": case "attachments": case "attachment":
			entListNameXPth = ".//*[@id='myattachment_list']";
			break;	
		//TODO: continue to expand this switch case list for additional list views
		}		
				
		//Step: check if there is a 'no records' result
		try {
			//AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
			AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().contains("no records"));
			
			//Step: check for matching results...
			String targetEntRecXPath = entListNameXPth + "/descendant::*[text() = '" + entityName + "']"; 
			List<WebElement> targetEntRecords = driver.findElements(By.xpath(targetEntRecXPath));
			WebElement targetEntRecord = null;
			if (targetEntRecords.size() > 1) {
				//specify the actual record name so that the search label is not clicked
				if (entityType.toLowerCase().equals("my activities")) {
					targetEntRecord = driver.findElement(By.xpath(entListNameXPth + "/div[3]/ul[1]/li/div[3]/h3/span"));
				}
				else {
					targetEntRecord = driver.findElement(By.xpath(entListNameXPth + "/ul/li/div[3]/h3"));
				}
			}
			else {
				targetEntRecord = driver.findElement(By.xpath(targetEntRecXPath));
			}
			try {
				AssertJUnit.assertTrue(targetEntRecord.isDisplayed());
			} catch (Error e) {
				String errorStr = e.toString();
				System.out.println(errorStr);
				System.out.println(methodID + ": " + entityType + " record search for '" + entityName + "' was NOT successful");
				return null;
			}
			highlightElement(targetEntRecord);
			System.out.println(methodID + ": " + entityType + " record search for '" + entityName + "' was successful");
			return targetEntRecord;
		} catch (Error e) {
			System.out.println(e.toString());
			System.out.println(methodID + ": un-expected 'no records' search result for '" + entityName + "' " + entityType + "; test aborted.");
			return null;
		}
	}
	
	public boolean entityListViewNegativeSearch(String entityType, String entityName) throws Exception {
		String methodID = "entityListViewNegativeSearch";
		
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
			
	    //Step: click Top-Left button to reveal Global Menu...
		headerbutton.showGlobalMenu();
	
	    //Step: navigate to Accounts list view...
		clickGlobalMenuItem(entityType);
	
	    //Step: perform search for Account items...
		searchListView(entityType, entityName);		
		
		//Step: check if there is a 'no records' result
		try {
			//AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
			AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().contains("no records"));
			System.out.println(methodID + ": negative  " + entityType + " record List View search was successful; 'no records' results was displayed for non-existent " + entityType);
			return true;
		} catch (Error e) {
			System.out.println(e.toString());
			System.out.println(methodID + ": negative " + entityType + " record List View search failed; 'no records' results was NOT displayed for non-existent " + entityType);
			return false;
		}		
	}
	
	
	public boolean entityRecordOpenDetailView(String entityType, String entityName) throws Exception {
		String methodID = "entityRecordOpenDetailView";
		
		WebElement entityListItem = entityListViewSearch(entityType, entityName);
		if (!entityListItem.equals(null)) {
			entityListItem.click();
			Thread.sleep(3000);
			
			//Step: check if the detail view is loaded
			waitForPage(entityName);
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean entityRecordAdd(String entityType) throws Exception {
		String methodID = "entityRecordAdd";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

	    //Step: click Top-Left button to reveal Global Menu...
		headerButton.showGlobalMenu();
	
	    //Step: navigate to Accounts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		//Step: click the Header Add button...
		headerButton.clickHeaderButton("add");
		String addEditViewXPath = "//*[@id='" + entityType.toLowerCase() + "_edit']";
		try {
			WebElement entityAddEditView = driver.findElement(By.xpath(addEditViewXPath));
			highlightElement(entityAddEditView);
			System.out.println(methodID + ": the " + entityType + " Add Edit view was successfully opened.");
			return true;
		}
		catch (Error e) {
			System.out.println(methodID + ": " + e);
			return false;
		}
	}
	
	
	public boolean entityRecordEditView(String entityType, String entityName) throws Exception {
		String methodID = "entityRecordEditView";
		
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		WebElement entityListItem = entityListViewSearch(entityType, entityName);
		if (!entityListItem.equals(null)) {
			entityListItem.click();
			Thread.sleep(3000);
			
			//Step: check if the detail view is loaded
			waitForPage(entityName);
			
			//Step: open record Edit View
			headerbutton.editButton.click();
			
			String editViewXPath = "//*[@id='" + entityType.toLowerCase() + "_edit']";
			try {
				WebElement entityDetailView = driver.findElement(By.xpath(editViewXPath));
				highlightElement(entityDetailView);
				System.out.println(methodID + ": " + entityType + " Detail view was opened for the '" + entityName + "' record.");
				return true;
			}
			catch (Error e) {
				System.out.println(methodID + ": " + e);
				return false;
			}
		}
		else {
			System.out.println(methodID + ": search for " + entityType + " - " + "'" + entityName + "'; step aborted.");
			return false;
		}
	}
	
	public void highlightElement(WebElement wElement) throws InterruptedException {
		
		try {
			AssertJUnit.assertTrue(wElement.isDisplayed());
			Thread.sleep(250);
			for (int i = 0; i <= 2; i++) { 
				JavascriptExecutor js = (JavascriptExecutor) driver;
				try {
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);", wElement, "color: yellow; border: 2px solid yellow;"); 
					Thread.sleep(100);
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);", wElement, "color: red; border: 2px solid red;");
					Thread.sleep(100);
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);", wElement, "");
				}
				catch (Error e) {
					System.out.println(e.toString());
					break;
				}
			} 
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void highlightNClick(WebElement wElement) throws InterruptedException {
		
		highlightElement(wElement);
		wElement.click();
	}
}
