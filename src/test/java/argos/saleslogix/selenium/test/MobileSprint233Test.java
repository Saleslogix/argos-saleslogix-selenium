/**
 * .
 */
package argos.saleslogix.selenium.test;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;


/**
 * @author mllena
 *
 */
public class MobileSprint233Test extends BaseTest {

	public String getKPICardValue(String fullKPICardVal) {
		
		String[] segStrArray = fullKPICardVal.split("\n");
		String cardValue = segStrArray[0];

		return cardValue;
	}

	//MBL10006 - After opening widget and pressing back arrow, not taken to expected listview per scenario
    //disable test for now ... causes problems for later tests
	@Test(enabled = false)
	public void test01_MBL10006() throws Exception {
		String methodID = "test01_MBL10006";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
				
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Section 1:
		String entityType = "accounts";
		
	    //Step: navigate to Accounts list view...
		commNav.clickGlobalMenuItem(entityType);	
		
		AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
		
		//Step: select Total Revenue KPI
		String KPI1 = "Total Revenue";
		commNav.rightClickContextMenuItem(KPI1);
		// del this line later
		headerButton.closeRightContextMenu();
		/*
		String resultMsg = "VP: Accounts - " + KPI1 + " KPI was selected";
		try {
			AssertJUnit.assertEquals(KPI1, driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MetricWidget_0']/button/div[1]")).getText());
			System.out.println(resultMsg + " - Passed");
		}
		catch (Error e){
			System.out.println(methodID + "(): " + e.toString());
			System.out.println(resultMsg + " - Failed");
		}
		*/
		
		//Step: select Total Accounts KPI
		String KPI2 = "Total Accounts";
		commNav.rightClickContextMenuItem(KPI2);
		headerButton.closeRightContextMenu();
		/*
		resultMsg = "VP: Accounts - " + KPI2 + " KPI was selected";
		try {
			AssertJUnit.assertEquals(KPI2, driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MetricWidget_2']/button/div[1]")).getText());
			System.out.println(resultMsg + " - Passed");
		}
		catch (Error e){
			System.out.println(methodID + "(): " + e.toString());
			System.out.println(resultMsg + " - Failed");
		}
		*/
		
		//Section 2:
		entityType = "contacts";
		
	    //Step: navigate to Contacts list view...
		commNav.clickGlobalMenuItem(entityType);
		ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
	
		//Step: select Total Contacts KPI
		String KPI3 = "Total Contacts";
		commNav.rightClickContextMenuItem(KPI3);
		headerButton.closeRightContextMenu();
		/*
		resultMsg = "VP: Contacts - " + KPI3 + " KPI was selected";
		try {
			AssertJUnit.assertEquals(KPI1, driver.findElement(By.xpath("//*[@id='Mobile_SalesLogix_Views_MetricWidget_3']/button/div[1]")).getText());
			System.out.println(resultMsg + " - Passed");
		}
		catch (Error e){
			System.out.println(methodID + "(): " + e.toString());
			System.out.println(resultMsg + " - Failed");
		}
		*/
		
		//Step: confirm that Contacts List view is still displayed
		String resultMsg = "VP: Contacts List view was displayed";
		try {
			AssertJUnit.assertTrue(driver.findElement(By.id("contact_list")).isDisplayed());
			System.out.println(resultMsg + " - Passed");
		}
		catch (Error e){
			System.out.println(methodID + "(): " + e.toString());
			System.out.println(resultMsg + " - Failed");
		}
		
		//Step: go back to My Activities view
		commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);
	}

    //MBL10115 - Index filtering Selection in Contextual menu
    @Test(enabled = true)
    public void test02_MBL10115() throws Exception {
        String methodID = "test02_MBL10115";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);

        // Test Params:
        String searchItem = "Abbott";
        String indexFilter = "";
        String resultsMsg = "";
        String[] indexFilters = {"Account", "Activity", "Contact", "History", "Lead", "Opportunity", "Ticket"};

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: perform SpeedSearch
        commNav.searchListView("SpeedSearch", searchItem);

        //Step: clear all SpeedSearch indexes
        for (int iCount = 0;iCount<indexFilters.length;iCount++) {
            indexFilter = indexFilters[iCount];
            commNav.rightClickContextMenuItem(indexFilter);
        }

        //Step: select index filter and perform SpeedSearch
        for (int iCount = 0;iCount<indexFilters.length;iCount++) {
            indexFilter = indexFilters[iCount];
            resultsMsg = "VP: Index filter - " + indexFilter + " succesfully filtered the SpeedSearch results";
            commNav.rightClickContextMenuItem(indexFilter);
            //driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_1']/div/div[3]/button")).click();
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
            if (commNav.isTextPresentOnPage(indexFilter)) {
                System.out.println(resultsMsg + " - Passed");
                commNav.rightClickContextMenuItem(indexFilter);
            }
            else {
                System.out.println(resultsMsg + " - FAILED");
            }
        }

        //Step: go back to previous screen
        commNav.clickGlobalMenuItem("My Activities");
        Thread.sleep(3000);

        System.out.println(ENDLINE);
    }

	//MBL10222 - Update Login Screen to include Logo
	@Test(enabled = true)
	public void test03_MBL10222() throws InterruptedException {
		String methodID = "test03_MBL10222";
		
		SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);	
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Click the Top-Left, Global Menu button...
		headerbutton.showGlobalMenu();
	
		// Click the Log Off button
		commNav.clickGlobalMenuItem("log out");
		Thread.sleep(2000);
		closeAlert();
		Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(2000);
					
		//VP: Login Page Name
		Thread.sleep(1000);	
		try {
			AssertJUnit.assertTrue(commNav.isPageDisplayed(fullProdName));
			System.out.println("VP: Login Page Name check - Passed");
		} 
		catch (Error e) {
			System.out.println("Error: Login Page Name check - FAILED");
			verificationErrors.append(methodID + "(): " + e.toString());
		}
		
		//VP: product logo
		try {
			AssertJUnit.assertTrue(commNav.isElementDisplayed(By.xpath(".//*[@id='login']/p/img")));
			System.out.println("VP: 'saleslog!x' logo check  - Passed");
		}
		catch (Error e) {
			System.out.println("Error: product logo check - FAILED");
			verificationErrors.append(methodID + "(): " + e.toString());
		}		
		
		// Step: Enter username and password then click the logon button		
		slxmobilelogin.doLogin(userName, userPwd, true);
			
		System.out.println(ENDLINE);
	}

	//MBL10112 - KPI widgets need to work for listviews under an entity - Notes History (no filtering by hash tags)
	@Test(enabled = true)
	public void test04_MBL10112_NotesHistory_NoFiltering() throws InterruptedException {
		String methodID = "test04_MBL10112_NotesHistory_NoFiltering";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Notes/History";
		int KPIIndex = 10;
		
		//Step: login & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
		
	    //Step: navigate to Notes/History list view...
		commNav.clickGlobalMenuItem(entityType);		
		NotesHistoryViewsElements notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
		
		//VP: confirm that current hash-tag/filter appears above the list view in the Lookup ... from 3.1 #my-history does not display by default
        commNav.rightClickContextMenuItem("my-history");
		String resultsMsg = "VP: current hash-tag/filter is displayed above the Notes/History list view";
        //String currHashTag = notesHistoryListView.notesHistorysSearchTxtBox.getAttribute("value");
        String currHashTag = commView.lookupTxtBox.getAttribute("value");

        AssertJUnit.assertEquals(resultsMsg + " - FAILED","#my-history",currHashTag);
        System.out.println("Current " + entityType + " hash-tags/filter: '" + currHashTag + "'");
        System.out.println(resultsMsg + " - PASSED");
		
		//Section 1: clear the default hash-tag/filter
		//----------
		//Step: un-select the KPI item
		headerButton.showRightContextMenu();
		commNav.rightClickContextMenuItem("Total History");
		Thread.sleep(2000);
		commNav.rightClickContextMenuItem("Total Duration");
		Thread.sleep(2000);
		headerButton.closeRightContextMenu();
		Thread.sleep(5000);
		
		//Step: remove any current hash-tags/filters then perform a Lookup
        // In Mobile 3.2 the clear and lookup buttons have been removed ... for lookup text box, just backspace and enter instead
		//headerButton.showRightContextMenu();
		//notesHistoryListView.notesHistorysSearchTxtBox.click();
        commView.lookupTxtBox.click();
		Thread.sleep(500);
		//notesHistoryListView.notesHistorysSearchClearBtn.click();
        commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		//notesHistoryListView.notesHistorysSearchLookupBtn.click();
        commView.lookupTxtBox.sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		
		//VP: check that for an unfiltered search nothing displays in the lookup above the list view
		notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
        resultsMsg = "VP: lookup displays nothing for cleared hash-tags/filters";
        //currHashTag = notesHistoryListView.notesHistorysSearchTxtBox.getAttribute("value");
        currHashTag = commView.lookupTxtBox.getAttribute("value");
        AssertJUnit.assertEquals(resultsMsg + " - FAILED","",currHashTag);
        System.out.println(resultsMsg + " - PASSED");
		
		//Section 2: Notes/ History KPI metrics
		//----------
		headerButton.showRightContextMenu();
		
		//VP: verify the KPI section header
		resultsMsg = "VP: KPI header label is displayed in right-context menu";
		WebElement KPIHeaderXPath = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'KPI']"));
		String headerLbl = KPIHeaderXPath.getText();
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", KPIHeaderXPath));			
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}

		
		//VP: verify the KPI metric items
		resultsMsg = "VP: KPI metric items are available in right-context menu";
		WebElement totalHistoryKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total History']"));
		WebElement totalDurationKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total Duration']"));
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("Total History KPI header label", totalHistoryKPI));
			AssertJUnit.assertTrue(commNav.isWebElementPresent("Total Duration KPI header label", totalDurationKPI));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		headerButton.closeRightContextMenu();
		
		//Section 3: Test Tickets KPI metric selections
		//----------
		String selectedKpiMetric = "";
		String[] kpiMetrics = {"Total History", "Total Duration"};
		for (int iKPICount = 0;iKPICount<kpiMetrics.length;iKPICount++) {
			selectedKpiMetric = kpiMetrics[iKPICount];		
		
			//Step: select the KPI metric (should be un-selected by default)
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			headerButton.closeRightContextMenu();
			Thread.sleep(5000);
			resultsMsg = "VP: '" + selectedKpiMetric + "' KPI metric button is displayed above the list view";
			notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
			String kpiCardXpath = "//div[" + (KPIIndex + iKPICount) + "]/div[3]/div/div/div/button";

            try {
				WebElement kpiCard = driver.findElement(By.xpath(kpiCardXpath));
				AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", kpiCard));
				System.out.println(resultsMsg + " - Passed");
				
				resultsMsg = "VP: '" + selectedKpiMetric + "' KPI card title check";
				try {
					String kpiCardTitle = kpiCard.getText();
					String regExp = "^[\\s\\S]*" + selectedKpiMetric + "[\\s\\S]*$";
					AssertJUnit.assertTrue(kpiCardTitle.matches(regExp));
					System.out.println(resultsMsg + " - Passed");
				}
				catch (Error e) {
					System.out.println(resultsMsg + " - Failed");
				}
				
				resultsMsg = "VP: '" + selectedKpiMetric + "' KPI Chart page check";
				commNav.highlightNClick(kpiCard);
				try {
					commNav.waitForPage(selectedKpiMetric);
					WebElement kpiChart = driver.findElement(By.id("chart_generic_bar"));
					System.out.println(resultsMsg + " - Passed");
				}
				catch (NoSuchElementException e) {
					System.out.println(resultsMsg + " - Failed");
				}
				headerButton.clickHeaderButton("back");
			}
			catch (NoSuchElementException e) {
				System.out.println(methodID + "(): " + e.toString());
				System.out.println(resultsMsg + " - Failed");
			}
			
			//Step: un-select the KPI item
			headerButton.showRightContextMenu();
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			headerButton.closeRightContextMenu();
			Thread.sleep(5000);
		}
		
		//END
		//---
		//Step: go back to start screen
		headerButton.closeRightContextMenu();
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}
	
	
	//MBL10112 - KPI widgets need to work for list views under an entity - Notes History (filtering by hash tags)
	@Test(enabled = true)
	public void test05_MBL10112_NotesHistory_Filtering() throws InterruptedException {
		String methodID = "test05_MBL10112_NotesHistory_Filtering";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Notes/History";
		
		//Step: login & log back in
		LogOutThenLogBackIn(userName, userPwd);
		
	    //Step: navigate to Notes/History list view...
		commNav.clickGlobalMenuItem(entityType);
	
		//Section: Notes/ History List view KPI metric & filters
		//--------		
		//Step: KPI filter selection loop
		String selectedKpiMetric = "";
		String[] kpiMetrics = {"Total History", "Total Duration"};
		for (int iKPICount = 0;iKPICount<kpiMetrics.length;iKPICount++) {
			selectedKpiMetric = kpiMetrics[iKPICount];
			
			NotesHistoryViewsElements notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
			
			//Step: un-select the KPI item
			//headerButton.showRightContextMenu();
			//commNav.rightClickContextMenuItem("Total History");
			//Thread.sleep(2000);
			//commNav.rightClickContextMenuItem("Total Duration");
			//Thread.sleep(2000);
			//headerButton.closeRightContextMenu();
			//Thread.sleep(5000);
			
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			
			//KPI filter + hashtag filter selection loop
			String hSelectedFilter = "";
			String[] hTagFilters = {"my-history", "note", "phonecall", "meeting", "personal", "email"};
			for (int iCount = 0;iCount<hTagFilters.length;iCount++) {
				hSelectedFilter = hTagFilters[iCount];
				
				//select the hash-tag filter item
				commNav.rightClickContextMenuItem(hSelectedFilter);
				Thread.sleep(5000);		
				String resultsMsg = "VP: " + selectedKpiMetric + " KPI metric card is displayed above the list view";
				try {
					WebElement selectedKPICard = notesHistoryListView.notesHistorysListView1stKPICard; 
					AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", selectedKPICard));
					System.out.println(resultsMsg + " - Passed");
					
					resultsMsg = "VP: " + selectedKpiMetric + " KPI card title check";
					notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);
					try {
						String selectedKPICardTitle = selectedKPICard.getText();
						String regExp = "^[\\s\\S]*" + selectedKpiMetric + "[\\s\\S]*$";
						AssertJUnit.assertTrue(selectedKPICardTitle.matches(regExp));
						System.out.println(resultsMsg + " - Passed");
						
						String selectedKPICardVal = getKPICardValue(selectedKPICardTitle);
						System.out.println("'" + selectedKpiMetric + "' & #" + hSelectedFilter + " card value: " + selectedKPICardVal);
					}
					catch (Error e) {
						System.out.println(resultsMsg + " - Failed");
					}
					
					resultsMsg = "VP: selected '#" + hSelectedFilter + "' hash tag filter label check";
                    try {
                        //String selectedHTagFilterLbl = notesHistoryListView.notesHistorysSearchTxtBox.getAttribute("value");
                        String selectedHTagFilterLbl = commView.lookupTxtBox.getAttribute("value");
                        String regExp = "^[\\s\\S]*" + hSelectedFilter + "[\\s\\S]*$";
                        AssertJUnit.assertTrue(selectedHTagFilterLbl.matches(regExp));
                        System.out.println(resultsMsg + " - PASSED");

                        System.out.println("select hash tag filter applied: '#" + hSelectedFilter + "'");
                    }
                    catch (Error e) {
                        System.out.println(resultsMsg + " - FAILED");
                    }
				}
				catch (NoSuchElementException e) {
					System.out.println(methodID + "(): " + e.toString());
					System.out.println(resultsMsg + " - Failed");
				}
			}
			
			//Step: remove any current hash-tags/filters then perform an empty Lookup
			headerButton.showRightContextMenu();
			commNav.rightClickContextMenuItem(selectedKpiMetric);

            //Thread.sleep(2000);
            //commNav.rightClickContextMenuItem("Total History");
            //Thread.sleep(2000);
            //commNav.rightClickContextMenuItem("Total Duration");
            //Thread.sleep(2000);

            // In Mobile 3.2 the clear and lookup buttons have been removed ... for lookup text box, just backspace and enter instead
			//notesHistoryListView.notesHistorysSearchTxtBox.click();
            commView.lookupTxtBox.click();
			Thread.sleep(500);
			//notesHistoryListView.notesHistorysSearchClearBtn.click();
            commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(1000);
			//notesHistoryListView.notesHistorysSearchLookupBtn.click();
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
			Thread.sleep(3000);
			
			System.out.println("");
		}
		
		//END
		//---
		//Step: go back to start screen
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	
	//MBL10112 - KPI widgets need to work for list views under an entity - Accounts (no filtered lookups)
	@Test(enabled = true)
	public void test06_MBL10112_Accounts_NoFiltering() throws InterruptedException {
		String methodID = "test06_MBL10112_Accounts_NoFiltering";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Accounts";
		int KPIIndex = 9;	//derived from the x in '//div[x]/...' (1st KPI metric card xpath def.)
		
		//Step: login & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
		
	    //Step: navigate to Accounts list view...
		commNav.clickGlobalMenuItem(entityType);		
		AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
		
		//Section 1: perform a Lookup with nothing in the lookup value
		//accountsListView.accountsSearchClearBtn.click();
        commView.lookupTxtBox.click();
        commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		//accountsListView.accountsSearchLookupBtn.click();
        commView.lookupTxtBox.sendKeys(Keys.RETURN);
		Thread.sleep(1000);

		
		//Section 2: Account KPI metrics
		//----------
		headerButton.showRightContextMenu();
		
		//VP: verify the KPI section header
		String resultsMsg = "VP: KPI header label is displayed in right-context menu";
		WebElement KPIHeaderXPath = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'KPI']"));
		String headerLbl = KPIHeaderXPath.getText();
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", KPIHeaderXPath));			
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		
		//VP: verify the Account KPI metric items
		resultsMsg = "VP: KPI metric items are available in right-context menu";
		WebElement totalRevenuKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total Revenue']"));
		WebElement avgTimeAsCustKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Avg Time as Customer']"));
		WebElement totalAccountsKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total Accounts']"));
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("Total Revenue KPI header label", totalRevenuKPI));
			AssertJUnit.assertTrue(commNav.isWebElementPresent("Avg Time as Customer KPI header label", avgTimeAsCustKPI));
			AssertJUnit.assertTrue(commNav.isWebElementPresent("Total Accounts KPI header label", totalAccountsKPI));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		headerButton.closeRightContextMenu();
		
		//Section 3: Test Account KPI metric selections
		//----------
		String selectedKpiMetric = "";
		String[] kpiMetrics = {"Total Revenue", "Avg Time as Customer", "Total Accounts"};
		for (int iKPICount = 0;iKPICount<kpiMetrics.length;iKPICount++) {
			selectedKpiMetric = kpiMetrics[iKPICount];		
		
			//Step: select the KPI metric (should be un-selected by default)
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			headerButton.closeRightContextMenu();
			Thread.sleep(5000);
			resultsMsg = "VP: '" + selectedKpiMetric + "' KPI metric button is displayed above the list view";
			accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
			String kpiCardXpath = "//div[" + (KPIIndex + iKPICount) + "]/div[3]/div/div/div/button";

			try {
				WebElement kpiCard = driver.findElement(By.xpath(kpiCardXpath));
				AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", kpiCard));
				System.out.println(resultsMsg + " - Passed");
				
				resultsMsg = "VP: '" + selectedKpiMetric + "' KPI card title check";
				try {
					String kpiCardTitle = kpiCard.getText();
					String regExp = "^[\\s\\S]*" + selectedKpiMetric + "[\\s\\S]*$";
					AssertJUnit.assertTrue(kpiCardTitle.matches(regExp));
					System.out.println(resultsMsg + " - Passed");
				}
				catch (Error e) {
					System.out.println(resultsMsg + " - Failed");
				}
				
				resultsMsg = "VP: '" + selectedKpiMetric + "' KPI Chart page check";
				commNav.highlightNClick(kpiCard);
				try {
					commNav.waitForPage(selectedKpiMetric);
					WebElement kpiChart = driver.findElement(By.id("chart_generic_bar"));
					System.out.println(resultsMsg + " - Passed");
				}
				catch (NoSuchElementException e) {
					System.out.println(resultsMsg + " - Failed");
				}
				headerButton.clickHeaderButton("back");
			}
			catch (NoSuchElementException e) {
				System.out.println(methodID + "(): " + e.toString());
				System.out.println(resultsMsg + " - Failed");
			}
			
			//Step: un-select the KPI item
			headerButton.showRightContextMenu();
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			headerButton.closeRightContextMenu();
			Thread.sleep(5000);
		}
		
		//END
		//---
		//Step: go back to start screen
		headerButton.closeRightContextMenu();
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}
	
	
	//MBL10112 - KPI widgets need to work for list views under an entity - Accounts (filtering by hash tags) ... hashtags removed in 3.1
	@Test(enabled = false)
	public void test07_MBL10112_Accounts_Filtering() throws InterruptedException {
		String methodID = "test07_MBL10112_Accounts_Filtering";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Accounts";
		
		//Step: login & log back in
		LogOutThenLogBackIn(userName, userPwd);
		
	    //Step: navigate to Accounts list view...
		commNav.clickGlobalMenuItem(entityType);
	
		//Section: Accounts List view KPI metric & filters 
		//--------		
		//Step: KPI filter selection loop
		String selectedKpiMetric = "";
		String[] kpiMetrics = {"Total Revenue", "Avg Time as Customer", "Total Accounts"};
		for (int iKPICount = 0;iKPICount<kpiMetrics.length;iKPICount++) {
			selectedKpiMetric = kpiMetrics[iKPICount];
			
			AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
			
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			
			//KPI filter + hashtag filter selection loop
			String hSelectedFilter = "";
			String[] hTagFilters = {"my-accounts", "active", "inactive", "suspect", "lead", "prospect", "customer", "partner", "vendor", "influencer", "competitor"};
			for (int iCount = 0;iCount<hTagFilters.length;iCount++) {
				hSelectedFilter = hTagFilters[iCount];
				
				//select the hash-tag filter item
				commNav.rightClickContextMenuItem(hSelectedFilter);
				Thread.sleep(5000);		
				String resultsMsg = "VP: " + selectedKpiMetric + " KPI metric card is displayed above the list view";
				try {
					WebElement selectedKPICard = accountsListView.accountsListView1stKPICard; 
					AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", selectedKPICard));
					System.out.println(resultsMsg + " - Passed");
					
					resultsMsg = "VP: " + selectedKpiMetric + " KPI card title check";
					accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
					try {
						String selectedKPICardTitle = selectedKPICard.getText();
						String regExp = "^[\\s\\S]*" + selectedKpiMetric + "[\\s\\S]*$";
						AssertJUnit.assertTrue(selectedKPICardTitle.matches(regExp));
						System.out.println(resultsMsg + " - Passed");
						
						String selectedKPICardVal = getKPICardValue(selectedKPICardTitle);
						System.out.println("'" + selectedKpiMetric + "' & #" + hSelectedFilter + " card value: " + selectedKPICardVal);
					}
					catch (Error e) {
						System.out.println(resultsMsg + " - Failed");
					}
					
					resultsMsg = "VP: selected '#" + hSelectedFilter + "' hash tag filter label check";
                    try {
                        //String selectedHTagFilterLbl = accountsListView.accountsSearchTxtBox.getAttribute("value");
                        String selectedHTagFilterLbl = commView.lookupTxtBox.getAttribute("value");
                        String regExp = "^[\\s\\S]*" + hSelectedFilter + "[\\s\\S]*$";
                        AssertJUnit.assertTrue(selectedHTagFilterLbl.matches(regExp));
                        System.out.println(resultsMsg + " - PASSED");

                        System.out.println("select hash tag filter applied: '#" + hSelectedFilter + "'");
                    }
                    catch (Error e) {
                        System.out.println(resultsMsg + " - Failed");
                    }
				}
				catch (NoSuchElementException e) {
					System.out.println(methodID + "(): " + e.toString());
					System.out.println(resultsMsg + " - Failed");
				}
			}
			
			//Step: remove any current hash-tags/filters then perform an empty Lookup
			headerButton.showRightContextMenu();
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			//accountsListView.accountsSearchTxtBox.click();
            commView.lookupTxtBox.click();
			Thread.sleep(500);
			//accountsListView.accountsSearchClearBtn.click();
            commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(1000);
			//accountsListView.accountsSearchLookupBtn.click();
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
			Thread.sleep(3000);
			
			System.out.println("");
		}
		
		//END
		//---
		//Step: go back to start screen
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	
	//MBL10112 - KPI widgets need to work for list views under an entity - Contacts (no filtered lookups)
	@Test(enabled = true)
	public void test08_MBL10112_Contacts_NoFiltering() throws InterruptedException {
		String methodID = "test08_MBL10112_Contacts_NoFiltering";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Contacts";
		int KPIIndex = 8;	//derived from the x in '//div[x]/...' (1st KPI metric card xpath def.)
		
		//Step: login & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
		
	    //Step: navigate to Contacts list view...
		commNav.clickGlobalMenuItem(entityType);		
		ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
		
		//Step: un-select the KPI item
		headerButton.showRightContextMenu();
		commNav.rightClickContextMenuItem("Total Contacts");
		Thread.sleep(1000);
		headerButton.closeRightContextMenu();
		Thread.sleep(5000);

		
		//Section 1: perform a Lookup with nothing in the lookup value
		//contactsListView.contactsSearchClearBtn.click();
        commView.lookupTxtBox.click();
        commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		//contactsListView.contactsSearchLookupBtn.click();
        commView.lookupTxtBox.sendKeys(Keys.RETURN);
		Thread.sleep(1000);

		
		//Section 2: Contact KPI metrics
		//----------
		headerButton.showRightContextMenu();
		
		//VP: verify the KPI section header
		String resultsMsg = "VP: KPI header label is displayed in right-context menu";
		WebElement KPIHeaderXPath = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'KPI']"));
		String headerLbl = KPIHeaderXPath.getText();
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", KPIHeaderXPath));			
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		
		//VP: verify the Contact KPI metric items
		resultsMsg = "VP: KPI metric items are available in right-context menu";
		WebElement totalContactsKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total Contacts']"));
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("Total Contacts KPI header label", totalContactsKPI));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		headerButton.closeRightContextMenu();
		
		//Section 3: Test Contact KPI metric selections
		//----------
		String selectedKpiMetric = "";
		String[] kpiMetrics = {"Total Contacts"};
		for (int iKPICount = 0;iKPICount<kpiMetrics.length;iKPICount++) {
			selectedKpiMetric = kpiMetrics[iKPICount];		
		
			//Step: select the KPI metric (should be un-selected by default)
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			headerButton.closeRightContextMenu();
			Thread.sleep(5000);
			resultsMsg = "VP: '" + selectedKpiMetric + "' KPI metric button is displayed above the list view";
			contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
			String kpiCardXpath = "//div[" + (KPIIndex + iKPICount) + "]/div[3]/div/div/div/button";

			try {
				WebElement kpiCard = driver.findElement(By.xpath(kpiCardXpath));
				AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", kpiCard));
				System.out.println(resultsMsg + " - Passed");
				
				resultsMsg = "VP: '" + selectedKpiMetric + "' KPI card title check";
				try {
					String kpiCardTitle = kpiCard.getText();
					String regExp = "^[\\s\\S]*" + selectedKpiMetric + "[\\s\\S]*$";
					AssertJUnit.assertTrue(kpiCardTitle.matches(regExp));
					System.out.println(resultsMsg + " - Passed");
				}
				catch (Error e) {
					System.out.println(resultsMsg + " - Failed");
				}
				
				resultsMsg = "VP: '" + selectedKpiMetric + "' KPI Chart page check";
				commNav.highlightNClick(kpiCard);
				try {
					commNav.waitForPage(selectedKpiMetric);
					WebElement kpiChart = driver.findElement(By.id("chart_generic_bar"));
					System.out.println(resultsMsg + " - Passed");
				}
				catch (NoSuchElementException e) {
					System.out.println(resultsMsg + " - Failed");
				}
				headerButton.clickHeaderButton("back");
			}
			catch (NoSuchElementException e) {
				System.out.println(methodID + "(): " + e.toString());
				System.out.println(resultsMsg + " - Failed");
			}
			
			//Step: un-select the KPI item
			headerButton.showRightContextMenu();
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			headerButton.closeRightContextMenu();
			Thread.sleep(5000);
		}
		
		//END
		//---
		//Step: go back to start screen
		headerButton.closeRightContextMenu();
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}
	

	//MBL10112 - KPI widgets need to work for list views under an entity - Contacts (filtering by hash tags) ... hashtags removed in 3.1
	@Test(enabled = false)
	public void test09_MBL10112_Contacts_Filtering() throws InterruptedException {
		String methodID = "test09_MBL10112_Contacts_Filtering";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Contacts";
		
		//Step: login & log back in
		LogOutThenLogBackIn(userName, userPwd);
		
	    //Step: navigate to Contacts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		//Step: un-select the KPI item
		//headerButton.showRightContextMenu();
		//commNav.rightClickContextMenuItem("Total Contacts");
		//Thread.sleep(1000);
		//headerButton.closeRightContextMenu();
		//Thread.sleep(5000);
			
		//Section: Contacts List view KPI metric & filters 
		//--------		
		//Step: KPI filter selection loop
		String selectedKpiMetric = "";
		String[] kpiMetrics = {"Total Contacts"};
		for (int iKPICount = 0;iKPICount<kpiMetrics.length;iKPICount++) {
			selectedKpiMetric = kpiMetrics[iKPICount];
			
			ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
			
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			
			//KPI filter + hashtag filter selection loop
			String hSelectedFilter = "";
			String[] hTagFilters = {"my-contacts", "primary", "not-primary", "can-email", "can-phone", "can-fax", "can-mail", "can-solicit"};
			for (int iCount = 0;iCount<hTagFilters.length;iCount++) {
				hSelectedFilter = hTagFilters[iCount];
				
				//select the hash-tag filter item
				commNav.rightClickContextMenuItem(hSelectedFilter);
				Thread.sleep(5000);		
				String resultsMsg = "VP: " + selectedKpiMetric + " KPI metric card is displayed above the list view";
				try {
					WebElement selectedKPICard = contactsListView.contactsListView1stKPICard; 
					AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", selectedKPICard));
					System.out.println(resultsMsg + " - Passed");
					
					resultsMsg = "VP: " + selectedKpiMetric + " KPI card title check";
					contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
					try {
						String selectedKPICardTitle = selectedKPICard.getText();
						String regExp = "^[\\s\\S]*" + selectedKpiMetric + "[\\s\\S]*$";
						AssertJUnit.assertTrue(selectedKPICardTitle.matches(regExp));
						System.out.println(resultsMsg + " - Passed");
						
						String selectedKPICardVal = getKPICardValue(selectedKPICardTitle);
						System.out.println("'" + selectedKpiMetric + "' & #" + hSelectedFilter + " card value: " + selectedKPICardVal);
					}
					catch (Error e) {
						System.out.println(resultsMsg + " - Failed");
					}
					
					resultsMsg = "VP: selected '#" + hSelectedFilter + "' hash tag filter label check";
                    try {
                        //String selectedHTagFilterLbl = contactsListView.contactsSearchTxtBox.getAttribute("value");
                        String selectedHTagFilterLbl = commView.lookupTxtBox.getAttribute("value");
                        String regExp = "^[\\s\\S]*" + hSelectedFilter + "[\\s\\S]*$";
                        AssertJUnit.assertTrue(selectedHTagFilterLbl.matches(regExp));
                        System.out.println(resultsMsg + " - PASSED");

                        System.out.println("select hash tag filter applied: '#" + hSelectedFilter + "'");
                    }
                    catch (Error e) {
                        System.out.println(resultsMsg + " - Failed");
                    }
				}
				catch (NoSuchElementException e) {
					System.out.println(methodID + "(): " + e.toString());
					System.out.println(resultsMsg + " - Failed");
				}
			}
			
			//Step: remove any current hash-tags/filters then perform an empty Lookup
			headerButton.showRightContextMenu();
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			//contactsListView.contactsSearchTxtBox.click();
            commView.lookupTxtBox.click();
			Thread.sleep(500);
			//contactsListView.contactsSearchClearBtn.click();
            commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(1000);
			//contactsListView.contactsSearchLookupBtn.click();
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
			Thread.sleep(3000);
			
			System.out.println("");
		}
		
		//END
		//---
		//Step: go back to start screen
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	//MBL10112 - KPI widgets need to work for list views under an entity - Leads (no filtered lookups)
	@Test(enabled = true)
	public void test10_MBL10112_Leads_NoFiltering() throws InterruptedException {
		String methodID = "test10_MBL10112_Leads_NoFiltering";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Leads";
		int KPIIndex = 7;	//derived from the x in '//div[x]/...' (1st KPI metric card xpath def.)
		
		//Step: login & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
		
	    //Step: navigate to Leads list view...
		commNav.clickGlobalMenuItem(entityType);		
		LeadViewsElements leadsListView = PageFactory.initElements(driver, LeadViewsElements.class);

		
		//Section 1: perform a Lookup with nothing in the lookup value
		//leadsListView.leadsSearchClearBtn.click();
        commView.lookupTxtBox.click();
        commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		//leadsListView.leadsSearchLookupBtn.click();
        commView.lookupTxtBox.sendKeys(Keys.RETURN);
		Thread.sleep(1000);

		
		//Section 2: Lead KPI metrics
		//----------
		headerButton.showRightContextMenu();
		
		//VP: verify the KPI section header
		String resultsMsg = "VP: KPI header label is displayed in right-context menu";
		WebElement KPIHeaderXPath = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'KPI']"));
		String headerLbl = KPIHeaderXPath.getText();
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", KPIHeaderXPath));			
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}

		
		//VP: verify the Lead KPI metric items
		resultsMsg = "VP: KPI metric items are available in right-context menu";
		WebElement totalLeadsKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total Leads']"));
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("Total Leads KPI header label", totalLeadsKPI));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		headerButton.closeRightContextMenu();
		
		//Section 3: Test Lead KPI metric selections
		//----------
		String selectedKpiMetric = "";
		String[] kpiMetrics = {"Total Leads"};
		for (int iKPICount = 0;iKPICount<kpiMetrics.length;iKPICount++) {
			selectedKpiMetric = kpiMetrics[iKPICount];		
		
			//Step: select the KPI metric (should be un-selected by default)
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			headerButton.closeRightContextMenu();
			Thread.sleep(5000);
			resultsMsg = "VP: '" + selectedKpiMetric + "' KPI metric button is displayed above the list view";
			leadsListView = PageFactory.initElements(driver, LeadViewsElements.class);
			String kpiCardXpath = "//div[" + (KPIIndex + iKPICount) + "]/div[3]/div/div/div/button";

			try {
				WebElement kpiCard = driver.findElement(By.xpath(kpiCardXpath));
				AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", kpiCard));
				System.out.println(resultsMsg + " - Passed");
				
				resultsMsg = "VP: '" + selectedKpiMetric + "' KPI card title check";
				try {
					String kpiCardTitle = kpiCard.getText();
					String regExp = "^[\\s\\S]*" + selectedKpiMetric + "[\\s\\S]*$";
					AssertJUnit.assertTrue(kpiCardTitle.matches(regExp));
					System.out.println(resultsMsg + " - Passed");
				}
				catch (Error e) {
					System.out.println(resultsMsg + " - Failed");
				}
				
				resultsMsg = "VP: '" + selectedKpiMetric + "' KPI Chart page check";
				commNav.highlightNClick(kpiCard);
				try {
					commNav.waitForPage(selectedKpiMetric);
					WebElement kpiChart = driver.findElement(By.id("chart_generic_bar"));
					System.out.println(resultsMsg + " - Passed");
				}
				catch (NoSuchElementException e) {
					System.out.println(resultsMsg + " - Failed");
				}
				headerButton.clickHeaderButton("back");
			}
			catch (NoSuchElementException e) {
				System.out.println(methodID + "(): " + e.toString());
				System.out.println(resultsMsg + " - Failed");
			}
			
			//Step: un-select the KPI item
			headerButton.showRightContextMenu();
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			headerButton.closeRightContextMenu();
			Thread.sleep(5000);
		}
		
		//END
		//---
		//Step: go back to start screen
		headerButton.closeRightContextMenu();
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	//MBL10112 - KPI widgets need to work for list views under an entity - Leads (filtering by hash tags) ... hashtags removed in 3.1
	@Test(enabled = false)
	public void test11_MBL10112_Leads_Filtering() throws InterruptedException {
		String methodID = "test11_MBL10112_Leads_Filtering";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Leads";
		
		//Step: login & log back in
		LogOutThenLogBackIn(userName, userPwd);
		
	    //Step: navigate to Leads list view...
		commNav.clickGlobalMenuItem(entityType);
			
		//Section: Leads List view KPI metric & filters 
		//--------		
		//Step: KPI filter selection loop
		String selectedKpiMetric = "";
		String[] kpiMetrics = {"Total Leads"};
		for (int iKPICount = 0;iKPICount<kpiMetrics.length;iKPICount++) {
			selectedKpiMetric = kpiMetrics[iKPICount];
			
			LeadViewsElements leadsListView = PageFactory.initElements(driver, LeadViewsElements.class);
			
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			
			//KPI filter + hashtag filter selection loop
			String hSelectedFilter = "";
			String[] hTagFilters = {"my-leads", "can-email", "can-phone", "can-fax", "can-mail", "can-solicit"};
			for (int iCount = 0;iCount<hTagFilters.length;iCount++) {
				hSelectedFilter = hTagFilters[iCount];
				
				//select the hash-tag filter item
				commNav.rightClickContextMenuItem(hSelectedFilter);
				Thread.sleep(5000);		
				String resultsMsg = "VP: " + selectedKpiMetric + " KPI metric card is displayed above the list view";
				try {
					WebElement selectedKPICard = leadsListView.leadsListView1stKPICard; 
					AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", selectedKPICard));
					System.out.println(resultsMsg + " - Passed");
					
					resultsMsg = "VP: " + selectedKpiMetric + " KPI card title check";
					leadsListView = PageFactory.initElements(driver, LeadViewsElements.class);
					try {
						String selectedKPICardTitle = selectedKPICard.getText();
						String regExp = "^[\\s\\S]*" + selectedKpiMetric + "[\\s\\S]*$";
						AssertJUnit.assertTrue(selectedKPICardTitle.matches(regExp));
						System.out.println(resultsMsg + " - Passed");
						
						String selectedKPICardVal = getKPICardValue(selectedKPICardTitle);
						System.out.println("'" + selectedKpiMetric + "' & #" + hSelectedFilter + " card value: " + selectedKPICardVal);
					}
					catch (Error e) {
						System.out.println(resultsMsg + " - Failed");
					}
					
					resultsMsg = "VP: selected '#" + hSelectedFilter + "' hash tag filter label check";
                    try {
                        //String selectedHTagFilterLbl = leadsListView.leadsSearchTxtBox.getAttribute("value");
                        String selectedHTagFilterLbl = commView.lookupTxtBox.getAttribute("value");
                        String regExp = "^[\\s\\S]*" + hSelectedFilter + "[\\s\\S]*$";
                        AssertJUnit.assertTrue(selectedHTagFilterLbl.matches(regExp));
                        System.out.println(resultsMsg + " - PASSED");

                        System.out.println("select hash tag filter applied: '#" + hSelectedFilter + "'");
                    }
                    catch (Error e) {
                        System.out.println(resultsMsg + " - Failed");
                    }
				}
				catch (NoSuchElementException e) {
					System.out.println(methodID + "(): " + e.toString());
					System.out.println(resultsMsg + " - Failed");
				}
			}
			
			//Step: remove any current hash-tags/filters then perform an empty Lookup
			headerButton.showRightContextMenu();
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			//leadsListView.leadsSearchTxtBox.click();
            commView.lookupTxtBox.click();
			Thread.sleep(500);
			//leadsListView.leadsSearchClearBtn.click();
            commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(1000);
			//leadsListView.leadsSearchLookupBtn.click();
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
			Thread.sleep(3000);
			
			System.out.println("");
		}
		
		//END
		//---
		//Step: go back to start screen
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}


    //MBL10112 - KPI widgets need to work for listviews under an entity - Opportunities (no filtered lookups)
    @Test(enabled = true)
    public void test12_MBL10112_Opportunities_NoFiltering() throws InterruptedException {
        String methodID = "test12_MBL10112_Opportunities_NoFiltering";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        // Test Params:
        String entityType = "Opportunities";
        int KPIIndex = 6;

        //Step: login & log back in
        LogOutThenLogBackIn(userName, userPwd);

        //Step: navigate to Opportunities list view...
        commNav.clickGlobalMenuItem(entityType);

        OpportunityViewsElements opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);

        //Section 1: perform a Lookup with nothing in the lookup value
        //opportunitiesListView.opportunitySearchClearBtn.click();
        commView.lookupTxtBox.click();
        commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(1000);
        //opportunitiesListView.opportunitySearchLookupBtn.click();
        commView.lookupTxtBox.sendKeys(Keys.RETURN);
        Thread.sleep(1000);


        //Section 2: Opportunity KPI metrics
        //----------
        headerButton.showRightContextMenu();

        //Step: verify the KPI section header
        String resultsMsg = "VP: KPI header label is displayed in right-context menu";
        WebElement KPIHeaderXPath = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'KPI']"));
        String headerLbl = KPIHeaderXPath.getText();
        try {
            AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", KPIHeaderXPath));
            System.out.println(resultsMsg + " - Passed");
        }
        catch (Error e) {
            System.out.println(resultsMsg + " - Failed");
        }


        //Step: verify the Opportunity KPI metric items
        resultsMsg = "VP: KPI metric items are available in right-context menu";
        WebElement totalOppsKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total Opportunities']"));
        WebElement salesPotentialKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total Sales Potential']"));
        WebElement mthlySalesPotentialKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Average Monthly Sales Potential']"));
        try {
            AssertJUnit.assertTrue(commNav.isWebElementPresent("Total Opportunities KPI header label", totalOppsKPI));
            AssertJUnit.assertTrue(commNav.isWebElementPresent("Sales Potential KPI header label", salesPotentialKPI));
            AssertJUnit.assertTrue(commNav.isWebElementPresent("Average Monthly Sales Potential KPI header label", mthlySalesPotentialKPI));
            System.out.println(resultsMsg + " - Passed");
        }
        catch (Error e) {
            System.out.println(resultsMsg + " - Failed");
        }
        headerButton.closeRightContextMenu();

        //Section 3: Total Opportunities KPI metric selection
        //----------
        String selectedKpiMetric = "";
        String[] kpiMetrics = {"Total Opportunities", "Total Sales Potential"};
        for (int iKPICount = 0;iKPICount<kpiMetrics.length;iKPICount++) {
            selectedKpiMetric = kpiMetrics[iKPICount];

            //Step: select the KPI metric (should be un-selected by default)
            commNav.rightClickContextMenuItem(selectedKpiMetric);
            headerButton.closeRightContextMenu();
            Thread.sleep(5000);
            resultsMsg = "VP: '" + selectedKpiMetric + "' KPI metric button is displayed above the list view";
            opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
            String kpiCardXpath = "//div[" + (KPIIndex + iKPICount) + "]/div[3]/div/div/div/button";


            try {
                WebElement kpiCard = driver.findElement(By.xpath(kpiCardXpath));
                AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", kpiCard));
                System.out.println(resultsMsg + " - Passed");

                resultsMsg = "VP: '" + selectedKpiMetric + "' KPI card title check";
                try {
                    String kpiCardTitle = kpiCard.getText();
                    String regExp = "^[\\s\\S]*" + selectedKpiMetric + "[\\s\\S]*$";
                    AssertJUnit.assertTrue(kpiCardTitle.matches(regExp));
                    System.out.println(resultsMsg + " - Passed");
                }
                catch (Error e) {
                    System.out.println(resultsMsg + " - Failed");
                }

                resultsMsg = "VP: '" + selectedKpiMetric + "' KPI Chart page check";
                commNav.highlightNClick(kpiCard);
                try {
                    commNav.waitForPage(selectedKpiMetric);
                    WebElement kpiChart = driver.findElement(By.id("chart_generic_bar"));
                    System.out.println(resultsMsg + " - Passed");
                }
                catch (NoSuchElementException e) {
                    System.out.println(resultsMsg + " - Failed");
                }
                headerButton.clickHeaderButton("back");
            }
            catch (NoSuchElementException e) {
                System.out.println(methodID + "(): " + e.toString());
                System.out.println(resultsMsg + " - Failed");
            }

            //Step: un-select the KPI item
            headerButton.showRightContextMenu();
            commNav.rightClickContextMenuItem(selectedKpiMetric);
            headerButton.closeRightContextMenu();
            Thread.sleep(5000);
        }

        //END
        //---
        //Step: go back to start screen
        headerButton.closeRightContextMenu();
        commNav.clickGlobalMenuItem("My Activities");
        Thread.sleep(3000);

        System.out.println(ENDLINE);
    }
	

	//MBL10112 - KPI widgets need to work for listviews under an entity - Opportunities (filtering by hash tags) ... hashtags removed in 3.1
	@Test(enabled = false)
	public void test13_MBL10112_Opportunities_Filtering() throws InterruptedException {
		String methodID = "test13_MBL10112_Opportunities_Filtering";
			
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Opportunities";
		int KPIIndex = 6;
		
		//Step: login & log back in
		LogOutThenLogBackIn(userName, userPwd);
		
	    //Step: navigate to Opportunities list view...
		commNav.clickGlobalMenuItem(entityType);
	
		//Section: Opportunities List view KPI metric & filters 
		//--------		
		//Step: KPI filter selection loop
		String selectedKpiMetric = "";
		String[] kpiMetrics = {"Total Opportunities", "Sales Potential"};
		for (int iKPICount = 0;iKPICount<kpiMetrics.length;iKPICount++) {
			selectedKpiMetric = kpiMetrics[iKPICount];
			
			OpportunityViewsElements opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
			
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			
			//KPI filter + hashtag filter selection loop
			String hSelectedFilter = "";
			String[] hTagFilters = {"my-opportunities", "open", "won", "lost", "inactive"};
			for (int iCount = 0;iCount<hTagFilters.length;iCount++) {
				hSelectedFilter = hTagFilters[iCount];
				
				//select the hash-tag filter item
				commNav.rightClickContextMenuItem(hSelectedFilter);
				Thread.sleep(5000);		
				String resultsMsg = "VP: " + selectedKpiMetric + " KPI metric card is displayed above the list view";
				String kpiCardXpath = "//div[" + (KPIIndex + iKPICount) + "]/div[3]/div/div/div/button";

				try {
					//WebElement selectedKPICard = driver.findElement(By.xpath(kpiCardXpath));
					WebElement selectedKPICard = opportunitiesListView.opportunityListView1stKPICard; 
					AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", selectedKPICard));
					System.out.println(resultsMsg + " - Passed");
					
					resultsMsg = "VP: " + selectedKpiMetric + " KPI card title check";
					opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
					try {
						String selectedKPICardTitle = selectedKPICard.getText();
						String regExp = "^[\\s\\S]*" + selectedKpiMetric + "[\\s\\S]*$";
						AssertJUnit.assertTrue(selectedKPICardTitle.matches(regExp));
						System.out.println(resultsMsg + " - Passed");
						
						String selectedKPICardVal = getKPICardValue(selectedKPICardTitle);
						System.out.println("'" + selectedKpiMetric + "' & #" + hSelectedFilter + " card value: " + selectedKPICardVal);
					}
					catch (Error e) {
						System.out.println(resultsMsg + " - Failed");
					}
					
					resultsMsg = "VP: selected '#" + hSelectedFilter + "' hash tag filter label check";
                    try {
                        //String selectedHTagFilterLbl = opportunitiesListView.opportunitySearchTxtBox.getAttribute("value");
                        String selectedHTagFilterLbl = commView.lookupTxtBox.getAttribute("value");
                        String regExp = "^[\\s\\S]*" + hSelectedFilter + "[\\s\\S]*$";
                        AssertJUnit.assertTrue(selectedHTagFilterLbl.matches(regExp));
                        System.out.println(resultsMsg + " - PASSED");

                        System.out.println("select hash tag filter applied: '#" + hSelectedFilter + "'");
                    }
                    catch (Error e) {
                        System.out.println(resultsMsg + " - Failed");
                    }
				}
				catch (NoSuchElementException e) {
					System.out.println(methodID + "(): " + e.toString());
					System.out.println(resultsMsg + " - Failed");
				}
			}
			
			//Step: remove any current hash-tags/filters then perform an empty Lookup
			headerButton.showRightContextMenu();
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			//opportunitiesListView.opportunitySearchTxtBox.click();
            commView.lookupTxtBox.click();
			Thread.sleep(500);
			//opportunitiesListView.opportunitySearchClearBtn.click();
            commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(1000);
			//opportunitiesListView.opportunitySearchLookupBtn.click();
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
			Thread.sleep(3000);
			
			System.out.println("");
		}
		
		//END
		//---
		//Step: go back to start screen
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}
	

	//MBL10112 - KPI widgets need to work for listviews under an entity - Tickets (no filtered lookups)
	@Test(enabled = true)
	public void test14_MBL10112_Tickets_NoFiltering() throws InterruptedException {
		String methodID = "test14_MBL10112_Tickets_NoFiltering";
			
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Tickets";
		int KPIIndex = 5;
		
		//Step: login & log back in
		LogOutThenLogBackIn(userName, userPwd);
		
	    //Step: navigate to Tickets list view...
		commNav.clickGlobalMenuItem(entityType);		
		TicketViewsElements ticketsListView = PageFactory.initElements(driver, TicketViewsElements.class);
		
		//Section 1: perform a Lookup with nothing in the lookup value
		//ticketsListView.ticketsSearchClearBtn.click();
        commView.lookupTxtBox.click();
        commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		//ticketsListView.ticketsSearchLookupBtn.click();
        commView.lookupTxtBox.sendKeys(Keys.RETURN);
		Thread.sleep(1000);

		
		//Section 2: Ticket KPI metrics
		//----------
		headerButton.showRightContextMenu();
		
		//VP: verify the KPI section header
		String resultsMsg = "VP: KPI header label is displayed in right-context menu";
		WebElement KPIHeaderXPath = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'KPI']"));
		String headerLbl = KPIHeaderXPath.getText();
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", KPIHeaderXPath));			
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}

		
		//VP: verify the Ticket KPI metric items
		resultsMsg = "VP: KPI metric items are available in right-context menu";
		WebElement totalTicktsKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Total Tickets']"));
		WebElement openAgeAvgKPI = driver.findElement(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Open Age Average']"));
		try {
			AssertJUnit.assertTrue(commNav.isWebElementPresent("Total Tickets KPI header label", totalTicktsKPI));
			AssertJUnit.assertTrue(commNav.isWebElementPresent("Open Age Average KPI header label", openAgeAvgKPI));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		headerButton.closeRightContextMenu();
		
		//Section 3: Test Tickets KPI metric selections
		//----------
		String selectedKpiMetric = "";
		String[] kpiMetrics = {"Total Tickets", "Open Age Average"};
		for (int iKPICount = 0;iKPICount<kpiMetrics.length;iKPICount++) {
			selectedKpiMetric = kpiMetrics[iKPICount];		
		
			//Step: select the KPI metric (should be un-selected by default)
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			headerButton.closeRightContextMenu();
			Thread.sleep(5000);
			resultsMsg = "VP: '" + selectedKpiMetric + "' KPI metric button is displayed above the list view";
			ticketsListView = PageFactory.initElements(driver, TicketViewsElements.class);
			String kpiCardXpath = "//div[" + (KPIIndex + iKPICount) + "]/div[3]/div/div/div/button";

			try {
				WebElement kpiCard = driver.findElement(By.xpath(kpiCardXpath));
				AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", kpiCard));
				System.out.println(resultsMsg + " - Passed");
				
				resultsMsg = "VP: '" + selectedKpiMetric + "' KPI card title check";
				try {
					String kpiCardTitle = kpiCard.getText();
					String regExp = "^[\\s\\S]*" + selectedKpiMetric + "[\\s\\S]*$";
					AssertJUnit.assertTrue(kpiCardTitle.matches(regExp));
					System.out.println(resultsMsg + " - Passed");
				}
				catch (Error e) {
					System.out.println(resultsMsg + " - Failed");
				}
				
				resultsMsg = "VP: '" + selectedKpiMetric + "' KPI Chart page check";
				commNav.highlightNClick(kpiCard);
				try {
					commNav.waitForPage(selectedKpiMetric);
					WebElement kpiChart = driver.findElement(By.id("chart_generic_bar"));
					System.out.println(resultsMsg + " - Passed");
				}
				catch (NoSuchElementException e) {
					System.out.println(resultsMsg + " - Failed");
				}
				headerButton.clickHeaderButton("back");
			}
			catch (NoSuchElementException e) {
				System.out.println(methodID + "(): " + e.toString());
				System.out.println(resultsMsg + " - Failed");
			}
			
			//Step: un-select the KPI item
			headerButton.showRightContextMenu();
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			headerButton.closeRightContextMenu();
			Thread.sleep(5000);
		}
		
		//END
		//---
		//Step: go back to start screen
		headerButton.closeRightContextMenu();
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}
	

	//MBL10112 - KPI widgets need to work for listviews under an entity - Tickets (filtering by hash tags) ... hashtags removed in 3.1
	@Test(enabled = false)
	public void test15_MBL10112_Tickets_Filtering() throws InterruptedException {
		String methodID = "test15_MBL10112_Tickets_Filtering";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Tickets";
		
		//Step: login & log back in
		LogOutThenLogBackIn(userName, userPwd);
		
	    //Step: navigate to Tickets list view...
		commNav.clickGlobalMenuItem(entityType);
	
		//Section: Tickets List view KPI metric & filters 
		//--------		
		//Step: KPI filter selection loop
		String selectedKpiMetric = "";
		String[] kpiMetrics = {"Total Tickets", "Open Age Average"};
		for (int iKPICount = 0;iKPICount<kpiMetrics.length;iKPICount++) {
			selectedKpiMetric = kpiMetrics[iKPICount];
			
			TicketViewsElements ticketsListView = PageFactory.initElements(driver, TicketViewsElements.class);
			
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			
			//KPI filter + hashtag filter selection loop
			String hSelectedFilter = "";
			String[] hTagFilters = {"assigned-to-me", "completed-by-me"};
			for (int iCount = 0;iCount<hTagFilters.length;iCount++) {
				hSelectedFilter = hTagFilters[iCount];
				
				//select the hash-tag filter item
				commNav.rightClickContextMenuItem(hSelectedFilter);
				Thread.sleep(5000);		
				String resultsMsg = "VP: " + selectedKpiMetric + " KPI metric card is displayed above the list view";
				try {
					WebElement selectedKPICard = ticketsListView.ticketsListView1stKPICard; 
					AssertJUnit.assertTrue(commNav.isWebElementPresent("KPI header label", selectedKPICard));
					System.out.println(resultsMsg + " - Passed");
					
					resultsMsg = "VP: " + selectedKpiMetric + " KPI card title check";
					ticketsListView = PageFactory.initElements(driver, TicketViewsElements.class);
					try {
						String selectedKPICardTitle = selectedKPICard.getText();
						String regExp = "^[\\s\\S]*" + selectedKpiMetric + "[\\s\\S]*$";
						AssertJUnit.assertTrue(selectedKPICardTitle.matches(regExp));
						System.out.println(resultsMsg + " - Passed");
						
						String selectedKPICardVal = getKPICardValue(selectedKPICardTitle);
						System.out.println("'" + selectedKpiMetric + "' & #" + hSelectedFilter + " card value: " + selectedKPICardVal);
					}
					catch (Error e) {
						System.out.println(resultsMsg + " - Failed");
					}
					
					resultsMsg = "VP: selected '#" + hSelectedFilter + "' hash tag filter label check";
                    try {
                        //String selectedHTagFilterLbl = ticketsListView.ticketsSearchTxtBox.getAttribute("value");
                        String selectedHTagFilterLbl = commView.lookupTxtBox.getAttribute("value");
                        String regExp = "^[\\s\\S]*" + hSelectedFilter + "[\\s\\S]*$";
                        AssertJUnit.assertTrue(selectedHTagFilterLbl.matches(regExp));
                        System.out.println(resultsMsg + " - PASSED");

                        System.out.println("select hash tag filter applied: '#" + hSelectedFilter + "'");
                    }
                    catch (Error e) {
                        System.out.println(resultsMsg + " - Failed");
                    }
				}
				catch (NoSuchElementException e) {
					System.out.println(methodID + "(): " + e.toString());
					System.out.println(resultsMsg + " - Failed");
				}
			}
			
			//Step: remove any current hash-tags/filters then perform an empty Lookup
			headerButton.showRightContextMenu();
			commNav.rightClickContextMenuItem(selectedKpiMetric);
			//ticketsListView.ticketsSearchTxtBox.click();
            commView.lookupTxtBox.click();
			Thread.sleep(500);
			//ticketsListView.ticketsSearchClearBtn.click();
            commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(1000);
			//ticketsListView.ticketsSearchLookupBtn.click();
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
			Thread.sleep(3000);
			
			System.out.println("");
		}
		
		//END
		//---
		//Step: go back to start screen
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	//Login & Logout
	//==============
	@Test(enabled = true)
	public void test00_MobileClient_Login() throws InterruptedException {
		String methodID = "test00_MobileClient_Login";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		doVerificationLogin();
		
		System.out.println(ENDLINE);	
	}

	@Test(enabled = true)
	public void test99_Mobile_LogOut()  throws InterruptedException {				
		String methodID = "test99_Mobile_LogOut";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		doVerificationLogout();
		
		System.out.println(ENDLINE);
	}
}
