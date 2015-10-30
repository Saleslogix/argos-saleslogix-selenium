package argos.saleslogix.selenium.test;

//import static org.junit.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

/**
 * CommonNavigation class defines WebElements and methods for any commonly accessed items (e.g. Global Menu).
 * This class also defines a collection of methods for commonly-used verifications.
 * 
 * @author	mike.llena@swiftpage.com
 * @version	1.0
 */
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
	@FindBy(xpath = "//*[@id='left_drawer']//input[@name='query']")
	WebElement gmenu_speedSearchLookupFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='left_drawer']//button[@class='subHeaderButton searchButton']")
	WebElement gmenu_speedSearchLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='left_drawer']//button[@class='clear-button']")
	WebElement gmenu_speedSearchLookupClearBtn;	
	
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
	@FindBy(xpath = ".//*[@id='right_drawer']/div[3]/h2[2]")
	WebElement rmenu_HashTagsHdr;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='right_drawer']//ul[@data-group='view']")
	WebElement rmenu_HashTagsSubPnl;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='right_drawer']/div[3]/h2[3]")
	WebElement rmenu_KPIHdr;

    @CacheLookup
    @FindBy(xpath = ".//*[@id='right_drawer']/div[3]/h2[1]")
    WebElement rmenu_GroupHdr;

    @CacheLookup
    @FindBy(xpath = ".//*[@id='right_drawer']//li[@data-action='groupConfigureClicked']//h3")
    WebElement rmenu_GroupConfigure;

    @CacheLookup
    @FindBy(xpath = ".//*[@id='right_drawer']//li[@data-name='Summary']//h3")
    WebElement rmenu_GroupSummary;

    @CacheLookup
    @FindBy(xpath = ".//*[@id='right_drawer']//li[@data-name='Detail']//h3")
    WebElement rmenu_GroupDetail;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='right_drawer']//ul[@data-group='kpi']")
	WebElement rmenu_KPISubPnl;
	
	//Methods
	//-------
	/**
	 * This method will open and select an item from the Global menu.
	 * 
	 * @version	1.0
	 * @param gMenuItem		global menu item to select
	 * @exception InterruptedException
	 */
	public CommonNavigation clickGlobalMenuItem(String gMenuItem) throws InterruptedException {
		String methodID = "clickGlobalMenuItem";
		
		//click the Page Title (forces closure of any blocking panels)
		driver.findElement(By.id("pageTitle")).click();
		Thread.sleep(1000);
		
		//conditionally click the GlobalMenu button to reveal panel
		WebElement glblMenuPnl = driver.findElement(By.xpath(".//*[@id='left_drawer']"));
		if (!glblMenuPnl.isDisplayed()) {
			driver.findElement(By.xpath("//*[@id='crm_Views_MainToolbar_0']/button[1]")).click();
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
		catch (Exception e) {
			System.out.println(methodID + ": " + e.toString());
		}
		return this;
	}
	
	
	/**
	 * This method will conditionally open the Right-context menu (in case it's currently closed) then  it will
	 * select a menu item from the current list view.
	 * 
	 * @version	1.0
	 * @param	menuItem	menu item from the Right-context menu to select
	 * @exception InterruptedException
	 */	
	public boolean rightClickContextMenuItem(String menuItem) throws InterruptedException {
		String methodID = "rightClickContextMenuItem";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		//conditionally click the RightContext Menu button to reveal panel
		if (!commNav.rmenu_panel.isDisplayed()) {
			driver.findElement(By.xpath(".//*[@id='crm_Views_MainToolbar_0']/button[2]")).click();
			Thread.sleep(1000);
			
			try {
				AssertJUnit.assertTrue(commNav.rmenu_panel.isDisplayed());
			}
			catch (Error e) {
				System.out.println(methodID + ": " + e.toString());
				return false;
			}					
		}
		
		//Step: perform context menu item selection
		try {
			WebElement contxtMnuItem = driver.findElement(By.xpath("//*[@id='right_drawer']/descendant::*[text() = '" + menuItem + "']"));
			highlightNClick(contxtMnuItem);
			Thread.sleep(2000);
			System.out.println(methodID + ": the '" + menuItem + "' Right-context Menu item was clicked.");
			return true;
		}
		catch (Exception e) {
			System.out.println(methodID + ": " + e.toString());
			return false;
		}
	}
	
	
	/**
	 * This method will return a boolean value indicating if a specific WebElement is displayed.
	 * 
	 * @version	1.0
	 * @param sDesc		description of the WebElement; for logging purposes
	 * @param wElement	WebElement object
	 */
	public boolean checkIfWebElementPresent(String sDesc, WebElement wElement) throws InterruptedException {
		String methodID = "checkIfWebElementPresent";
		
		Thread.sleep(1000);
		try {
			AssertJUnit.assertTrue(wElement.isDisplayed());
			highlightElement(wElement);
			System.out.println(methodID + ": " + sDesc + " is displayed on the current page/screen.");
			return true;
		}
		catch (Error e) {
			System.out.println(methodID + ": " + e.toString());
			System.out.println(methodID + ": " + sDesc + " is NOT displayed on the current page/screen.");
			return false;
		}
	}
	
	
	/**
	 * This method will click a WebElement to open an expected page.
	 * 
	 * @version	1.0
	 * @param sDesc			description of the WebElement; for logging purposes
	 * @param wElement		WebElement object
	 * @param expPageTitle	title of the expected page to open
	 * @exception InterruptedException
	 */
	public boolean clickWebElementToPage(String sDesc, WebElement wElement, String expPageTitle) throws InterruptedException {
		String methodID = "clickWebElementToPage";
		
		Thread.sleep(1000);
		try {
			highlightElement(wElement);
			wElement.click();
			Thread.sleep(3000);
			boolean pgOpened = waitForPage(expPageTitle);
			if (pgOpened) {
				System.out.println(methodID + ": clicking the " + sDesc + " page element successfully opened the '" + expPageTitle + "' page/screen.");
				return pgOpened;
			}
			else {
				return pgOpened;
			}
		}
		catch (Exception e) {
			System.out.println(methodID + ": " + e.toString());
			return false;
		}
	}
	

	/**
	 * This method will enter a value into an input field.
	 * 
	 * @version	1.0
	 * @param inputFld		WebElement object of the input field
	 * @param inputValue	field value to set
	 */
	public void setupInputFieldValue(WebElement inputFld, String inputValue) {
		
		String methodID = "setupInputFieldValue";
		
		try {
			inputFld.click();
			inputFld.sendKeys(inputValue);
			inputFld.sendKeys(Keys.RETURN);
		}
		catch (Exception e) {
			System.out.println(methodID + ": " + e.toString());
		}
	}

	
	/**
	 * This method will compare the attribute value of an on-screen WebElement.
	 * The comparison result will be tracked in the console log.
	 * 
	 * @version	1.0
	 * @param	elementDesc		description of the WebElement item
	 * @param	wElement		WebElement object
	 * @param	strAttribute	attribute type to check
	 * @param	expAttrVal		attribute value of the type to check against	
	 * @exception InterruptedException
	 */
	public void verifyWebElementAttributeVal(String elementDesc, WebElement wElement, String strAttribute, String expAttrVal) throws InterruptedException {
		String methodID = "verifyWebElementAttributeVal";
		
		String strResultsMsg = "VP: WebElement " + strAttribute + " check for " + elementDesc;
		
		try { 
			AssertJUnit.assertEquals(wElement.getAttribute(strAttribute), expAttrVal);
			highlightElement(wElement);
			System.out.println(strResultsMsg + " - Passed");
		} catch (Error e) {
			System.out.println(methodID + ": " + e.toString());
			System.out.println(strResultsMsg + " - FAILED");
		}		
	}
	
	
	/**
	 * This method will compare the text value of an on-screen WebElement.
	 * The comparison result will be tracked in the console log.
	 * 
	 * @version	1.0
	 * @param	elementDesc	description of the WebElement item
	 * @param	wElement	WebElement object
	 * @param	expText		text value of the WebElement to check against
	 * @see		highlightElement()
	 * @exception InterruptedException
	 */	
	public void verifyWebElementText(String elementDesc, WebElement wElement, String expText) throws InterruptedException {
		String methodID = "verifyWebElementText";
		
		String strResultsMsg = "VP: WebElement text check for " + elementDesc;
		
		try { 
			AssertJUnit.assertEquals(wElement.getText(), expText);
			highlightElement(wElement);
			System.out.println(strResultsMsg + " - Passed");
		} catch (Error e) {
			System.out.println(methodID + ": " + e.toString());
			System.out.println(strResultsMsg + " - FAILED");
		}		
	}
	
	
	/**
	 * This method will compare the attribute value of an on-screen WebElement.
	 * The comparison result will be tracked in the console log.
	 * 
	 * @version	1.0
	 * @param	elementDesc	description of the WebElement item
	 * @param	wElement	WebElement object
	 * @param	expValue	value of the WebElement to check against
	 * @see		highlightElement()
	 * @exception InterruptedException
	 */
	public void verifyWebElementValue(String elementDesc, WebElement wElement, String expValue) throws InterruptedException {
		String methodID = "verifyWebElementValue";
		
		String strResultsMsg = "VP: WebElement value check for " + elementDesc;
		
		try { 
			AssertJUnit.assertEquals(wElement.getAttribute("value"), expValue);
			highlightElement(wElement);
			System.out.println(strResultsMsg + " - Passed");
		} catch (Error e) {
			System.out.println(methodID + ": " + e.toString());
			System.out.println(strResultsMsg + " - FAILED");
		}
	}
	
	
	/**
	 * This method will click an on-screen WebElement and verify that the expected page is successfully 
	 * navigated to.
	 * 
	 * @version	1.0
	 * @param	elementDesc	description of the WebElement item to click
	 * @param	wElement	WebElement object to click
	 * @param	expPgTitle	title of the expected page
	 * @return	<code>True</code> if the title of the loaded page matches the expected page title
	 * 			<code>False</code> otherwise 
	 * @see		clickWebElement()
	 * @exception InterruptedException
	 */
	protected boolean verifyEntityViewElementClick(String elementDesc, WebElement wElement, String expPgTitle) throws InterruptedException {
		String methodID = "verifyEntityViewElementClick";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		try { 
			commNav.clickWebElementToPage(elementDesc, wElement, expPgTitle);
			try {
				headerButton.backButton.click();
			}
			catch (Exception e) {
				headerButton.cancelButton.click();
			}
			Thread.sleep(1000);
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
		
	}
	
	
	/**
	 * This method will wait for a specific Entity List view to load.  This method should is applicable
	 * when performing a search on a list view.
	 * 
	 * @version	1.0
	 * @param listName			description of the WebElement; for logging purposes
	 * @exception InterruptedException
	 */
	public CommonNavigation waitForListView(String listName) throws InterruptedException {
		
		String methodID = "waitForListView";
	    
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
		    	try { if (isElementPresent(By.xpath(".//*[@id='" + itemList + "']//ul/li[1]")))
		    		System.out.println("VP: " + listName + " List View was successfully loaded.");
		    		break; 
		    	} 
		    	catch (Exception e) {
		    		System.out.println("Error: " + listName + " List View was NOT successfully loaded.");
		    	}
		    	Thread.sleep(1000);
		    }
		}
		catch (Exception e) {
			  System.out.println(methodID + ": " + e.toString());
		}	    
		return this;
	}

	
	/**
	 * This method will perform page scroll-down action.
	 *
	 * @version	1.0
	 * @exception InterruptedException
	 */
	public void scrollDownPage() throws InterruptedException {
		
		/* below doesn't seem to work anymore
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(3000);
		*/
		
		//resorting to sendKeys action
		Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN);
        action.perform();
	}
	
	
	/**
	 * This method will perform SpeedSearch (from Global Menu) or entity record lookup (from the 
	 * Right-Context menu).
	 *
	 * @version	1.0
	 * @param	searchType  	specify 'SpeedSearch' or the entity record type
	 * @param	searchItemName	item or entity record to search for
	 * @exception InterruptedException
	 */
	public CommonNavigation searchListView(String searchType, String searchItemName) throws InterruptedException {
		String methodID = "searchListView";
		
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
		
		String searchWgtIDX = "";
		Boolean forSpdSrch = false;
		
		switch (searchType.toLowerCase()) {
		case "speedsearch": case "search": case "speed search":
		//	searchWgtIDX = "0";
			forSpdSrch = true;
			break;
		//case "my activities": case "activities": case "activity":
		//	searchWgtIDX = "26";
		//	break;
		//case "notes/history": case "notes history": case "notes": case "note": case "history":
		//	searchWgtIDX = "27";
		//	break;
		//case "accounts": case "account":
		//	searchWgtIDX = "3";
		//	break;
		//case "contacts": case "contact":
		//	searchWgtIDX = "6";
		//	break;
		//case "leads": case "lead":
		//	searchWgtIDX = "16";
		//	break;
		//case "opportunities": case "opportunity":
		//	searchWgtIDX = "11";
		//	break;
		//case "tickets": case "ticket":
		//	searchWgtIDX = "18";
		//	break;
		//case "my attachments": case "attachments": case "attachment":
		//	searchWgtIDX = "36";
		//	break;
		//TODO: continue to expand this switch case list for additional list views
		}
		
		//input the search item then perform the search
		try {
		    if (forSpdSrch) {
		    	//invoke Global Menu
		    	headerbutton.showGlobalMenu();
		    			    	
		    	gmenu_speedSearchLookupFld.clear();
		    	Thread.sleep(500);
                gmenu_speedSearchLookupFld.click();
                Thread.sleep(500);
		    	//gmenu_speedSearchLookupClearBtn.click();
                gmenu_speedSearchLookupFld.sendKeys(Keys.BACK_SPACE);
		    	Thread.sleep(500);
		    	gmenu_speedSearchLookupFld.sendKeys(searchItemName);
		    	Thread.sleep(500);
		    	gmenu_speedSearchLookupFld.sendKeys(Keys.RETURN);
		    }
		    else {
				//invoke the Right Context menu ... no longer needed, Lookup field is top of screen
				//headerbutton.clickHeaderButton("right context menu");
				
		    	//driver.findElement(By.xpath("//*[@id='argos_SearchWidget_" + searchWgtIDX + "']/div/div[1]/input")).clear();
                commView.lookupTxtBox.clear();
		    	Thread.sleep(500);
                commView.lookupTxtBox.click();
                Thread.sleep(500);
		    	//driver.findElement(By.xpath("//*[@id='argos_SearchWidget_" + searchWgtIDX + "']/div/div[2]/button")).click();
                commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
		    	Thread.sleep(500);
		    	//driver.findElement(By.xpath("//*[@id='argos_SearchWidget_" + searchWgtIDX + "']/div/div[1]/input")).sendKeys(searchItemName);
                commView.lookupTxtBox.sendKeys(searchItemName);
		    	Thread.sleep(500);
		    	//driver.findElement(By.xpath("//*[@id='argos_SearchWidget_" + searchWgtIDX + "']/div/div[3]/button")).click();
                commView.lookupTxtBox.sendKeys(Keys.RETURN);
		    }
		    System.out.println(methodID + ": performing search of '" + searchItemName + "' from " + searchType + " List View...");
		    waitForListView(searchType);
		}
		catch (Exception e) {
			  System.out.println(methodID + ": " + e.toString());
		}
		return this;
	}
	
	/**
	 * This method will perform entity record lookup (from the Right-Context 
	 * menu) for record selection from another entity Edit view.
	 * 
	 * @version	1.0
	 * @param	searchType  	specify 'SpeedSearch' or the entity record type
	 * @param	searchItemName	item or entity record to search for
	 * @exception InterruptedException
	 */
	public CommonNavigation searchNSelectListView(String searchType, String searchItemName) throws InterruptedException {
		String methodID = "searchListView";
		
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
		
		String searchWgtIDX = "";
		Boolean forSpdSrch = false;
		
		switch (searchType.toLowerCase()) {
		//case "accounts": case "account":
		//	searchWgtIDX = "4";
		//	break;
		//case "contacts": case "contact":
		//	searchWgtIDX = "7";
		//	break;
		//case "leads": case "lead":
		//	searchWgtIDX = "17";
		//	break;
		//case "opportunities": case "opportunity":
		//	searchWgtIDX = "12";
		//	break;
		//case "tickets": case "ticket":
		//	searchWgtIDX = "19";
		//	break;
		//TODO: continue to expand this switch case list for additional list views
		}

		//invoke the Right Context menu ... no longer needed, Lookup is at the top of the screen
		//headerbutton.clickHeaderButton("right context menu");
		
    	//driver.findElement(By.xpath("//*[@id='argos_SearchWidget_" + searchWgtIDX + "']/div/div[1]/input")).clear();
        commView.lookupTxtBox.clear();
        Thread.sleep(500);
        commView.lookupTxtBox.click();
        Thread.sleep(500);
    	//driver.findElement(By.xpath("//*[@id='argos_SearchWidget_" + searchWgtIDX + "']/div/div[2]/button")).click();
        commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(500);
    	//driver.findElement(By.xpath("//*[@id='argos_SearchWidget_" + searchWgtIDX + "']/div/div[1]/input")).sendKeys(searchItemName);
        commView.lookupTxtBox.sendKeys(searchItemName);
        Thread.sleep(500);
    	//driver.findElement(By.xpath("//*[@id='argos_SearchWidget_" + searchWgtIDX + "']/div/div[3]/button")).click();
        commView.lookupTxtBox.sendKeys(Keys.RETURN);

	    System.out.println(methodID + ": performing search of '" + searchItemName + "' from " + searchType + " List View...");
	    waitForListView(searchType);
	
		return this;
	}
	
	
	/**
	 * This method will find and then click a specific WebElement object.
	 * 
	 * @version	1.0
	 * @param listName		name of entity list view
	 * @param intemIndex	index of list item to click
	 * @exception InterruptedException
	 */
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
		case "speedsearch": case "speed search":
			itemList = "speedsearch_list";
			break;
		//TODO: continue to expand this switch case list for additional list views
		}
		
		//perform the list view item click
		String srchItemXPath = "";
		if (!listName.toLowerCase().contains("speed")) {
			srchItemXPath = "//*[@id='" + itemList + "']//ul/li[" + itemIndex + "]/div/h3";
		}
		else {
			srchItemXPath = ".//*[@id='" + itemList + "']//ul/li[" + itemIndex + "]/div[3]/h4";
		}
		
		try {
			driver.findElement(By.xpath(srchItemXPath)).click();
			System.out.println(methodID + ": clicking '" + itemIndex + "th item ' from the " + listName + " List View...");
		} catch (Exception e) {
			System.out.println("Error: Unable to click the '" + itemIndex + "th' item from the " + listName + " List View.");
			System.out.println(methodID + ": " + e.toString());
		}	    
		return this;
	}
	
	
	/**
	 * This method will wait up to 60s. for an expected page to load.
	 * 
	 * @version	1.0
	 * @param	pageTitle  exact page title of expected page
	 * @exception InterruptedException
	 */	
	public boolean waitForPage(String pageTitle) throws InterruptedException {
		String methodID = "waitForPage";
	    
		for (int second = 0;; second++) {
			Thread.sleep(1000);
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { 
	    		AssertJUnit.assertEquals(pageTitle, driver.findElement(By.id("pageTitle")).getText());
	    		System.out.println(methodID + ": '" + pageTitle + "' page was successfully loaded");
	    		return true;
	    	} 
	    	catch (Error e) {
	    		System.out.println(methodID + " " + e.toString());
	    		return false;
	    	}
	    }		
	}
	
	
	/**
	 * This method will wait up to 60s. for a page transition from a given start page.
	 * 
	 * @version	1.0
	 * @param	pageTitle  exact title of transition from page
	 * @exception InterruptedException
	 */	
	public boolean waitForNotPage(String pageTitle) throws InterruptedException {
		String methodID = "waitForNotPage";
	    
		for (int second = 0;; second++) {
			Thread.sleep(1000);
	    	if (second >= 60) AssertJUnit.fail("timeout");
	    	try { if (!pageTitle.equals(driver.findElement(By.xpath("//*[@id='pageTitle']")).getText()))
	    		System.out.println(methodID + ": '" + pageTitle + "' page was successfully navigated away from");
	    		return true;
	    	} catch (Exception e) {
	    		System.out.println(methodID + ": '" + pageTitle + "' page failed to navigate away from prior to timeout");
	    		return false;
	    	}
	    }
	}
	
	
	/**
	 * This method will find and then click a specific WebElement object.
	 * 
	 * @version	1.0
	 * @param locator		WebElement locator
	 * @exception InterruptedException
	 */
	public WebElement clickListViewGridItem(By locator) throws InterruptedException {
		int i = 0;
		WebElement element = null;
		while (i < 5) {
			try {
				element = driver.findElement(locator);
				highlightNClick(element);
				break;
			} catch (Exception e) {
				Thread.sleep(1000);
				element = driver.findElement(locator);
				highlightNClick(element);
			}
		}
		Thread.sleep(3000);
		return element;
	}
	
	
	/**
	 * This method will return a boolean value that determines whether a specific WebElement is present 
	 * (not necessarily displayed) on the page.
	 * 
	 * @version	1.0
	 * @param	By			by locator string for target WebElement
	 * @return	boolean		true - if WebElement with matching by locator is displayed; 
	 * 						false - otherwise
	 */
	protected boolean isElementPresent(By by) {
		
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	    	return false;
	    }
	}
	
	
	/**
	 * This method will return a boolean value that determines whether a specific WebElement is displayed 
	 * on the page.
	 * 
	 * @version	1.0
	 * @param	By			by locator string for target WebElement
	 * @return	boolean		true - if WebElement with matching by locator is displayed; 
	 * 						false - otherwise
	 */	
	protected boolean isElementDisplayed(By by) {
		
		String methodID = "isElementDisplayed";
		
	    try {
	    	AssertJUnit.assertTrue(driver.findElement(by).isDisplayed());
	    	return true;
	    } 
	    catch (NoSuchElementException e) {
	    	System.out.println(methodID + ": " + e.toString());
	    	return false;
	    }
	}
	
	
	/**
	 * This method will determine if webelement's value attribute is empty or not. For non-empty webelements
	 * the value is displayed in the log.
	 * 
	 * @version	1.0
	 * @param sDesc		description of the WebElement
	 * @param WebElement	WebElement object
	 * @return boolean	true - if WebElement's value is empty; 
	 * 					false - otherwise
	 */
	public boolean isFieldValueEmpty(String sDesc, WebElement wElement) {
		String methodID = "isFieldValueEmpty";
		
		try {
			String fieldVal = wElement.getAttribute("value");
			//TODO: may need to add additional code to strip-out the field label that might be returned in the getText() call
			if (fieldVal.equals(null)) {
				//try to get the value attribute
				String fieldVal1 = wElement.getText();
				if (fieldVal1.contentEquals("")) {
					System.out.println(methodID + ": " + sDesc + " field value present but empty.");
					return true;
				}
				else {
					System.out.println(methodID + ": " + sDesc + " field has a value of '" + fieldVal1 + "'");
					return false;
				}
			}
			else {
				System.out.println(methodID + ": " + sDesc + " field has a value of '" + fieldVal + "'");
				return false;
			}
		}
		catch (Exception e) {
			//try to get the value attribute
			String fieldVal2 = wElement.getText();
			if (fieldVal2.contentEquals("")) {
				System.out.println(methodID + ": " + sDesc + " field value present but empty.");
				return true;
			}
			else {
				System.out.println(methodID + ": " + sDesc + " field has a value of '" + fieldVal2 + "'");
				return false;
			}
			//System.out.println(methodID + ": value/text attribute for WebElement '" + sDesc + "' is not available.");
			//return false;
		}
	}
	
	
	/**
	 * This method will determine if a WebelEment is present or not.
	 * 
	 * @version	1.0
	 * @param	String		description of webelement (for logging purposes)
	 * @param	WebElement	WebElement object
	 * @return	boolean		true - if WebElement is present
	 * 						false - otherwise
	 * @throws	InterruptedException
	 */
	public boolean isWebElementPresent(String sDesc, WebElement wElement) throws InterruptedException {
		String methodID = "isWebElementPresent";
		
		try { 
			highlightElement(wElement);
			System.out.println(methodID + ": " + sDesc + " is displayed on the current page/screen.");
			return true;
		}
		catch (Exception e) {
			System.out.println(methodID + ": " + e.toString());
			System.out.println(methodID + ": Unable to locate '" + sDesc + "' on the current page/screen.");
			return false;
		}
	}
	
	
	/**
	 * This method will determine whether a page with a specific pagetitle is displayed.
	 * 
	 * @version	1.0
	 * @param	pageTitle	exact pagetitle text for expected page
	 * @return	boolean		true - if page with matching pagetitle is displayed; 
	 * 						false - otherwise
	 * @throws InterruptedException 
	 */	
	public boolean isPageDisplayed(String pageTitle) throws InterruptedException {		
		String methodID = "isPageDisplayed";
		
		Thread.sleep(1000);
    	if (pageTitle.equals(driver.findElement(By.id("pageTitle")).getText())) {
    		System.out.println(methodID + ": '" + pageTitle + "' page was successfully loaded");
    		return true; 
    	}
    	else {
    		System.out.println(methodID + ": '" + pageTitle + "' page was NOT successfully loaded");
    		return false;		
    	}
	}
	
	
	/**
	 * This method will return a boolean value that determines whether a specific text string is NOT present 
	 * on the page.  This method can be used for negative verification.
	 * 
	 * @version	1.0
	 * @param	By			by locator string for target WebElement
	 * @return	boolean		true - if WebElement with matching by locator is displayed; 
	 * 						false - otherwise
	 * @exception InterruptedException
	 */
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
					System.out.println(methodID + ": " + e.toString());
				}	
			}
		return checkResult;
	}
	
	
	/**
	 * This method will return a boolean value that determines whether a specific text string is present 
	 * on the page.
	 * 
	 * @version	1.0
	 * @param	pageText	text to check for
	 * @return	boolean		true - if WebElement with matching by locator is displayed; 
	 * 						false - otherwise
	 * @exception InterruptedException
	 */
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
					System.out.println(methodID + ": " + e.toString());
				}	
			}
		return checkResult;
	}
	

	/**
	 * This method will search for a given entity record.
	 * 
	 * @version	1.0
	 * @param	entityType	entity type to search for
	 * @param	entityName	entity record name to search for
	 * @exception Exception
	 */	
	public WebElement entityListViewSearch(String entityType, String entityName) throws Exception {
		String methodID = "entityListViewSearch";
		
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
			
	    //Step: click Top-Left button to reveal Global Menu...
		headerbutton.showGlobalMenu();
	
	    //Step: navigate to entity list view...
		clickGlobalMenuItem(entityType);
	
	    //Step: perform search for entity record items...
		if (entityType.toLowerCase().contains("contact") || entityType.toLowerCase().contains("lead")) {
			String nameTokens[] = entityName.split(",");
			String lastName = nameTokens[0];
			searchListView(entityType, lastName);
		}
		else {
			searchListView(entityType, entityName);
			Thread.sleep(3000);
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
					targetEntRecord = targetEntRecords.get(0);
				}
				else {
					targetEntRecord = targetEntRecords.get(1);
				}
			}
			else {
				if (entityType.toLowerCase().contains("notes")) {
					targetEntRecord = driver.findElement(By.xpath(entListNameXPth + "//ul/li[1]"));
				}
				else {
					targetEntRecord = driver.findElement(By.xpath(targetEntRecXPath));
				}
			}
			try {
				AssertJUnit.assertTrue(targetEntRecord.isDisplayed());
			} 
			catch (Error e) {
				String errorStr = e.toString();
				System.out.println(errorStr);
				System.out.println(methodID + ": " + entityType + " record search for '" + entityName + "' was NOT successful");
				return null;
			}
			highlightElement(targetEntRecord);
			System.out.println(methodID + ": " + entityType + " record search for '" + entityName + "' was successful");
			return targetEntRecord;
		} 
		catch (Error e) {
			System.out.println(methodID + ": " + e.toString());
			System.out.println(methodID + ": un-expected 'no records' search result for '" + entityName + "' " + entityType + "; test aborted.");
			return null;
		}
	}
	
	
	/**
	 * This method will return a WebElement object from an entity List view that matches a partial description.
	 * 
	 * @version	1.0
	 * @param	entityType	type of entity list view to search
	 * @param	entityName	item to search for
	 * @exception Exception
	 */	
	public WebElement entityListViewSearchContains(String entityType, String entityName) throws Exception {
		String methodID = "entityListViewSearchContains";
		
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
			Thread.sleep(3000);
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
			AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().contains("no records"));
			
			//Step: check for matching results...
			String targetEntRecXPath = entListNameXPth + "/descendant::*[text()[contains(., '" + entityName + "')]]";
			List<WebElement> targetEntRecords = driver.findElements(By.xpath(targetEntRecXPath));
			WebElement targetEntRecord = null;
			if (targetEntRecords.size() > 1) {
				//specify the actual record name so that the search label is not clicked
				if (entityType.toLowerCase().equals("my activities")) {
					targetEntRecord = targetEntRecords.get(0);
				}
				else {
					targetEntRecord = targetEntRecords.get(1);
				}
			}
			else {
				if (entityType.toLowerCase().contains("notes")) {
					targetEntRecord = driver.findElement(By.xpath(entListNameXPth + "//ul/li[1]"));
				}
				else {
					targetEntRecord = driver.findElement(By.xpath(targetEntRecXPath));
				}
			}
			try {
				AssertJUnit.assertTrue(targetEntRecord.isDisplayed());
			} 
			catch (Error e) {
				String errorStr = e.toString();
				System.out.println(errorStr);
				System.out.println(methodID + ": " + entityType + " record search for '" + entityName + "' was NOT successful");
				return null;
			}
			highlightElement(targetEntRecord);
			System.out.println(methodID + ": " + entityType + " record search for '" + entityName + "' was successful");
			return targetEntRecord;
		} catch (Error e) {
			System.out.println(methodID + ": " + e.toString());
			System.out.println(methodID + ": un-expected 'no records' search result for '" + entityName + "' " + entityType + "; test aborted.");
			return null;
		}
	}
	
	
	/**
	 * This method will return a WebElement object from an entity List view that matches an exact description.
	 * 
	 * @version	1.0
	 * @param	entityType	type of entity list view to search
	 * @param	entityName	item to search for
	 * @exception Exception
	 */	
	public WebElement entityListViewSelect(String entityType, String entityName) throws Exception {
		String methodID = "entityListViewSelect";
		
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
			
	
	    //Step: perform search for entity record items...
		if (entityType.toLowerCase().equals("contacts") || entityType.toLowerCase().equals("leads")) {
			String nameTokens[] = entityName.split(",");
			String lastName = nameTokens[0];
			searchNSelectListView(entityType, lastName);
		}
		else {
			searchNSelectListView(entityType, entityName);
		}
		
		//SubStep: singularize the entityType parameter
		String entListNameXPth = "";
		switch (entityType.toLowerCase()) {
		case "my activities":
			entListNameXPth = ".//*[@id='myactivity_related']";
			break;
		case "activities": case "activity": 
			entListNameXPth = ".//*[@id='activity_related']";
			break;			
		case "notes/history": case "notes history": case "notes":
			entListNameXPth = ".//*[@id='history_related']";
			break;
		case "accounts": case "account":
			entListNameXPth = ".//*[@id='account_related']";
			break;
		case "contacts": case "contact":
			entListNameXPth = ".//*[@id='contact_related']";
			break;
		case "leads": case "lead":
			entListNameXPth = ".//*[@id='lead_related']";
			break;			
		case "opportunities": case "opportunity":
			entListNameXPth = ".//*[@id='opportunity_related']";
			break;			
		case "tickets": case "ticket":
			entListNameXPth = ".//*[@id='ticket_related']";
			break;			
		case "my attachments": case "attachments": case "attachment":
			entListNameXPth = ".//*[@id='myattachment_related']";
			break;	
		//TODO: continue to expand this switch case list for additional list views
		}		
				
		//Step: check if there is a 'no records' result
		try {
			Thread.sleep(3000);
			AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().contains("no records"));
			
			//Step: check for matching results...
			String targetEntRecXPath = entListNameXPth + "/descendant::*[text() = '" + entityName + "']"; 
			List<WebElement> targetEntRecords = driver.findElements(By.xpath(targetEntRecXPath));
			WebElement targetEntRecord = null;
			if (targetEntRecords.size() > 1) {
				//specify the actual record name so that the search label is not clicked
				if (entityType.toLowerCase().equals("my activities")) {
					targetEntRecord = targetEntRecords.get(0);
				}
				else {
					targetEntRecord = targetEntRecords.get(1);
				}
			}
			else {
				if (entityType.toLowerCase().contains("notes")) {
					targetEntRecord = driver.findElement(By.xpath(entListNameXPth + "//ul/li[1]"));
				}
				else {
					targetEntRecord = driver.findElement(By.xpath(targetEntRecXPath));
				}
			}
			try {
				AssertJUnit.assertTrue(targetEntRecord.isDisplayed());
			} 
			catch (Error e) {
				String errorStr = e.toString();
				System.out.println(errorStr);
				System.out.println(methodID + ": " + entityType + " record search 'n select for '" + entityName + "' was NOT successful");
				return null;
			}
			highlightElement(targetEntRecord);
			System.out.println(methodID + ": " + entityType + " record search for '" + entityName + "' was successful");
			return targetEntRecord;
		} catch (Error e) {
			System.out.println(methodID + ": " + e.toString());
			System.out.println(methodID + ": un-expected 'no records' search result for '" + entityName + "' " + entityType + "; test aborted.");
			return null;
		}
	}
	
	
	/**
	 * This method will perform a SpeedSearch for a given search item string.
	 * This method is a wrapper method for searchListView().
	 * 
	 * @version	1.0
	 * @param	searchItem	item to search for
	 * @exception InterruptedException
	 */	
	public void doSpeedSearch(String searchItem) throws InterruptedException {
		String methodID = "doSpeedSearch";
		
		String searchType = "SpeedSearch";
		searchListView(searchType, searchItem);
		
	}
	
	
	/**
	 * This method will return a boolean value that indicates whether or not a specific item is displayed
	 * in an entity List view.
	 * 
	 * @version	1.0
	 * @param	entityType	type of entity list view to search
	 * @param	entityName	item to search for
	 * @exception Exception
	 */	
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
		Thread.sleep(3000);
		try {
			//AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
			AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().contains("no records"));
			System.out.println(methodID + ": negative  " + entityType + " record List View search was successful; 'no records' results was displayed for non-existent " + entityType);
			return true;
		} catch (Error e) {
			System.out.println(methodID + ": " + e.toString());
			System.out.println(methodID + ": negative " + entityType + " record List View search failed; 'no records' results was NOT displayed for non-existent " + entityType);
			return false;
		}		
	}
	
	/**
	 * This method will search for then open the entity Detail view of a given record.
	 * This method first calls the entityListViewSearch() method to find the target WebElement.
	 * 
	 * @version	1.0
	 * @param	entityType	entity type to search for
	 * @param	entityItem	item to search for
	 * @exception Exception
	 */	
	public boolean entityRecordOpenDetailView(String entityType, String entityName) throws Exception {
		String methodID = "entityRecordOpenDetailView";
		
		try {
			WebElement entityListItem = entityListViewSearch(entityType, entityName);
			highlightNClick(entityListItem);
			//entityListItem.click();
			Thread.sleep(3000);
			
			//Step: check if the detail view is loaded
			if (!entityType.toLowerCase().contains("notes")) {
				waitForPage(entityName);
                return true;
			}
			else if (entityType.toLowerCase().contains("notes") && entityType.toLowerCase().contains("history")) {
				waitForNotPage("Notes/History");
				return true;	
			}
			else {
				return false;				
			}
		}
		catch (Exception e) {
			System.out.println(methodID + ": " + e.toString());
			System.out.println(methodID + ": Unable to open the " + entityType + " - " + entityName + " detail view");
			return false;
		}
	}
	
	
	/**
	 * This method will click the Header Add button from a given entity List view.
	 * 
	 * @version	1.0
	 * @param	entityType	type of entity list view to search
	 * @exception Exception
	 */	
	public boolean entityRecordAdd(String entityType) throws Exception {
		String methodID = "entityRecordAdd";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

	    //Step: click Top-Left button to reveal Global Menu...
		headerButton.showGlobalMenu();
	
	    //Step: navigate to entity list view...
		commNav.clickGlobalMenuItem(entityType);
		
		//Step: click the Header Add button...
		headerButton.clickHeaderButton("add");
		
		String entTypeXPath = "";
		switch (entityType.toLowerCase()) {
		case "notes/history":
			entTypeXPath = "history";
			break;
		case "opportunities":
			entTypeXPath = "opportunity";
			break;
		default:
			entTypeXPath = entityType.replace("s", "");
			break;
		}
		
		String editViewXPath = "//*[@id='" + entTypeXPath.toLowerCase() + "_edit']";
		try {
			WebElement entityAddEditView = driver.findElement(By.xpath(editViewXPath));
			highlightElement(entityAddEditView);
			System.out.println(methodID + ": the " + entityType + " Add Edit view was successfully opened.");
			return true;
		}
		catch (Exception e) {
			System.out.println(methodID + ": " + e);
			return false;
		}
	}
	
	
	/**
	 * This method will locate and then click an item from an entity list view to open the item's edit view.
	 * 
	 * @version	1.0
	 * @param	entityType	type of entity list view to search
	 * @exception Exception
	 */
	public boolean entityRecordEditView(String entityType, String entityName) throws Exception {
		String methodID = "entityRecordEditView";
		
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		WebElement entityListItem = entityListViewSearch(entityType, entityName);
		if (!entityListItem.equals(null)) {
			entityListItem.click();
			Thread.sleep(3000);
			
			//Step: check if the detail view is loaded
			if (!entityType.contains("ote")) {
				waitForPage(entityName);
			}
			else {
				waitForNotPage("Notes/History");
			}
			
			//Step: open record Edit View
			headerbutton.editButton.click();
			
			String entTypeXPath = "";
			switch (entityType.toLowerCase()) {
			case "notes/history":
				entTypeXPath = "history";
				break;
			case "opportunities":
				entTypeXPath = "opportunity";
				break;
			default:
				entTypeXPath = entityType.replace("s", "");
				break;
			}
			
			String editViewXPath = "//*[@id='" + entTypeXPath.toLowerCase() + "_edit']";
			try {
				WebElement entityDetailView = driver.findElement(By.xpath(editViewXPath));
				highlightElement(entityDetailView);
				System.out.println(methodID + ": " + entityType + " Edit view was opened for the '" + entityName + "' record.");
				return true;
			}
			catch (Exception e) {
				System.out.println(methodID + ": " + e);
				return false;
			}
		}
		else {
			System.out.println(methodID + ": search for " + entityType + " - " + "'" + entityName + "'; step aborted.");
			return false;
		}
	}
	
	
	/**
	 * This method will perform a SpeedSearch for a given term, then select to open a specific results item's
	 * detail view.
	 * 
	 * @version	1.0
	 * @param	searchItem		item to search for
	 * @param	recordToOpen	speedsearch results item to open
	 * @exception Exception
	 */
	public void goToSpeedSearchResultDetailView(String searchItem, String recordToOpen)  throws InterruptedException {
		String methodID = "goToSpeedSearchResultDetailView";
		
		//perform SpeedSearch on the target item
		doSpeedSearch(searchItem);
		
		String targetSpdSearchResultXPath = "//*[@id='speedsearch_list']/descendant::*[text() = '" + recordToOpen + "'][1]";
		
		//open the top matching search result from the List view 
		clickListViewGridItem(By.xpath(targetSpdSearchResultXPath));
		waitForNotPage("SpeedSearch");
			
	}
	
	
	/**
	 * This method will invoke javascript commands to highlight a given WebElement on the page.
	 * The assumption is that the given WebElement is displayed on the page.  This method is 
	 * useful for debugging by providing a visual confirmation of target WebElement objects.
	 * 
	 * @version	1.0
	 * @param	wElement	a WebElement object on the page
	 * @return	void 
	 */	
	public void highlightElement(WebElement wElement) throws InterruptedException {
		
		String methodID = "highlightElement";
		
		Thread.sleep(1000);
		//try {
			//AssertJUnit.assertTrue(wElement.isDisplayed());
			//Thread.sleep(250);
			for (int i = 0; i <= 2; i++) { 
				JavascriptExecutor js = (JavascriptExecutor) driver;
				try {
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);", wElement, "color: yellow; border: 2px solid yellow;"); 
					Thread.sleep(100);
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);", wElement, "color: red; border: 2px solid red;");
					Thread.sleep(100);
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);", wElement, "");
				}
				catch (Exception e) {
					System.out.println(methodID + ": " + e.toString());
					break;
				}
			} 
		//}
		//catch (Error e){
		//	System.out.println(methodID + ": " + e.toString());
		//}
	}
	
	
	/**
	 * This method will first highlight a target WebElement then click the same object.
	 *
	 * @version	1.0
	 * @param	wElement	a WebElement object on the page
	 * @return	void
	 */	
	public void highlightNClick(WebElement wElement) throws InterruptedException {
		
		highlightElement(wElement);
		wElement.click();
	}
}
