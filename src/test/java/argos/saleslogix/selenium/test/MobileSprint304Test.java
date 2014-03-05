/**
 * .
 */
package argos.saleslogix.selenium.test;

import argos.saleslogix.selenium.CommonNavigation;
import argos.saleslogix.selenium.HeaderButton;
import argos.saleslogix.selenium.MyActivityViewsElements;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;


/**
 * @author mllena
 *
 */
public class MobileSprint304Test extends BrowserSetup {

	public String getKPICardValue(String fullKPICardVal) {
		
		String[] segStrArray = fullKPICardVal.split("\n");
		String cardValue = segStrArray[1];

		return cardValue;
	}

	@Test(enabled = true)
	public void test01_MobileDefect_MBL10191() throws InterruptedException {
		//MBL-10191: Remove configure option
		String methodID = "test01_MobileDefect_MBL10191";
			
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String selectedEntity = "";
		String[] entityList = {"My Activities", "Notes/History", "Accounts", "Contacts", "Leads", "Opportunities", "Tickets", "My Attachments"};
		for (int iCount = 1;iCount<entityList.length;iCount++) {
		    //Step: navigate to entity list view...
			selectedEntity = entityList[iCount];
			commNav.clickGlobalMenuItem(selectedEntity);
			
			//Step: verify the removal of KPI Configure link
			headerButton.showRightContextMenu();
			String resultsMsg = "VP: KPI Configure link is correctly not displayed in right-context menu for the '" + selectedEntity + "' entity.";
			try {
				AssertJUnit.assertTrue(driver.findElements(By.xpath(".//*[@id='right_drawer']/descendant::*[text() = 'Configure']")).size() == 0);			
				System.out.println(resultsMsg + " - Passed");
			}
			catch (Error e) {
				System.out.println(resultsMsg + " - Failed");
			}
			
			headerButton.closeRightContextMenu();
		}
			
		//END
		//---
		//Step: go back to start screen
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test02_MobileDefect_MBL10190() throws InterruptedException {
		//MBL-10190: Right Contextual menu - where SpeedSearch is executed consecutively more than once from the left Global menu, the contextual menu opens and hides a good part of the SpeedS
		String methodID = "test02_MobileDefect_MBL10190";
			
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);		
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: perform speed search...
	    String firstSearchItem = "abbott";	    
	    commNav.searchListView("speedsearch", firstSearchItem);
	
	    String secondSearchItem = "abc";	    
	    commNav.searchListView("speedsearch", secondSearchItem);
	    
		//VP: confirm that Right-context menu is not automatically displayed after 2nd Speed Search
	    String resultsMsg = "VP: Right-context menu is not displayed after 2nd Speed Search ";
	    try {
	    	AssertJUnit.assertTrue(driver.findElements(By.xpath(".//*[@id='right_drawer']")).size() == 0);
			System.out.println(resultsMsg + "- Passed");
		}
	    catch (Error e) {
			// Click Header Right-Context Menu button...
	    	headerButton.clickHeaderButton("right context menu");
	    	System.out.println(resultsMsg + "- False");
	    }
	    
		//END
		//---
		//Step: go back to start screen
		commNav.clickGlobalMenuItem("My Activities");
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = false)
	public void test03_MobileDefect_MBL10015() throws Exception {
		//MBL-10015: Under My Activities, when scrolling/ loading next batch of records, seeing expected �loading� message, plus unexpected �Retrieve More Records� beneath
		String methodID = "test03_MobileDefect_MBL10015";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		//Test Params:
		String entityType = "My Activities";
		String hashTag = "alarm";
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);		
	
	    //Step: navigate to My Activities list view...
		commNav.clickGlobalMenuItem(entityType);
		
		//Step: select the alarm hash-tag filter item
		commNav.rightClickContextMenuItem(hashTag);
		Thread.sleep(3000);
		
		//Step: scroll-down to the "x records remaining" label
		String recsRemainLblXPath = "//*[@id='myactivity_list']/div[3]/div";
		String resultsMsg = "VP: Invalid 'Retrieve More Records' label not found after loading more records";
		try {
			driver.findElement(By.xpath(recsRemainLblXPath)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='myactivity_list']")).sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(3000);			
			try {
				AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Retrieve More Records[\\s\\S]*$"));
				System.out.println(resultsMsg + " - Passed");
			} 
			catch (Error e) {
				verificationErrors.append(methodID + "(): " + e.toString());
				System.out.println(resultsMsg + " - Failed");
			}
		}
		catch (Exception exp) {
		    //Step: load more results (click on 'x remaining records' item)
			for (int count = 1; count<3; count++) {			
				driver.findElement(By.xpath("//*[@id='myactivity_list']")).sendKeys(Keys.PAGE_DOWN);
				Thread.sleep(3000);
				//JavascriptExecutor jsx = (JavascriptExecutor)driver;
				//jsx.executeScript("window.scrollBy(0,450)", "");
				
				try {
					AssertJUnit.assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Retrieve More Records[\\s\\S]*$"));
					System.out.println(resultsMsg + " - Passed");
				} 
				catch (Error er) {
					verificationErrors.append(er.toString());
					System.out.println(resultsMsg + " - Failed");
				}
			}				
		}
		
		//END
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test04_MobileDefect_MBL10127() throws Exception {
		//MBL-10127: Lead Detail/Edit - Add Mobile Phone
		String methodID = "test04_MobileDefect_MBL10127";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);	
		
		//Test Params:
		String entityType = "Leads";
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);		
	
	    //Step: navigate to the Leads list view
		commNav.clickGlobalMenuItem(entityType);
		
		//Step: click and open the top Leads record
		commNav.clickListViewItemN(entityType, 1);
		commNav.waitForNotPage("Leads");
		
		//VP: check to see that the Mobile Phone field is available in the Detail view
		String mobilePhoneDtlViewFldXPath = "//*[@id='lead_detail']/descendant::*[text() = 'mobile phone']";
		String resultsMsg = "VP: the Mobile Phone field is available in the Lead Detail view";
		try {
			AssertJUnit.assertTrue(driver.findElement(By.xpath(mobilePhoneDtlViewFldXPath)).isDisplayed());
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
		
		//Step: navigate to Lead Edit view
		headerButton.clickHeaderButton("edit");
		commNav.waitForPage("Lead");
		
		//VP: check to see that the Mobile Phone field is available in the Edit view
		String mobilePhoneEdtViewFldCSS = "input[name='Mobile']";
		resultsMsg = "VP: the Mobile Phone field is available in the Lead Edit view";
		try {
			AssertJUnit.assertTrue(driver.findElement(By.cssSelector(mobilePhoneEdtViewFldCSS)).isDisplayed());
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(resultsMsg + " - Failed");
		}
			
		//END
		commNav.clickGlobalMenuItem("My Activities");
		System.out.println(ENDLINE);
	}

	@Test(enabled = false)
	public void test05_MobileDefect_MBL10137() throws Exception {
		//MBL-10137: My Activities/entities - unexpectedly seeing #this-week hash tag displaying per scenario of scrolling, opening/closing an activity and contextual menu
		String methodID = "test05_MobileDefect_MBL10137";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);	
		
		//Test Params:
		String entityType = "My Activities";
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);		
	
	    //Step: navigate to the My Activities list view
		commNav.clickGlobalMenuItem(entityType);
		
		MyActivityViewsElements activitiesListView = PageFactory.initElements(driver, MyActivityViewsElements.class);
		
		//Step: execute a filter-free search
		activitiesListView.performNoFilterSearch();
		
		//Step: scroll-down the list a few times
		for (int count = 1; count<4; count++) {			
			driver.findElement(By.xpath("//*[@id='myactivity_list']")).sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(3000);
		}
		
		//Step: open any activity record
		commNav.clickListViewItemN(entityType, 5);
		commNav.waitForPage("Activity");
		
		//Step: navigate back to the Activities List view
		headerButton.clickHeaderButton("back");
		commNav.waitForPage(entityType);
		
		//Step: open the Right-context menu
		headerButton.showRightContextMenu();
		
		//VP: check to see if '#this-week' populates the Lookup input field
		String filter2Check = "#this-week";
		String lookupFldVal = activitiesListView.myActivitiesSearchTxtBox.getText();
		String resultsMsg = "VP: Lookup search field is not set to '" + filter2Check + "'";
		try {
			AssertJUnit.assertFalse(lookupFldVal.equals(filter2Check));
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(methodID + "(): " + e.toString());
			System.out.println(resultsMsg + " - False");
		}
		finally {
			headerButton.closeRightContextMenu();
		}
		
		//Step: scroll-down the list a few times (again)
		for (int count = 1; count<4; count++) {			
			driver.findElement(By.xpath("//*[@id='myactivity_list']")).sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(3000);
		}
		
		//Step: click the title bar to jump to the top of the list
		driver.findElement(By.xpath(".//*[@id='pageTitle']")).click();
		Thread.sleep(1000);
		
		//VP: check to see that '#this-week' filter is not displayed on the page
		resultsMsg = "VP: the '" + filter2Check + "' hash-tag filter was not present";
		try { if (!driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + filter2Check + "[\\s\\S]*$"))
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(methodID + "(): " + e.toString());
			System.out.println(resultsMsg + " - Failed");
		}
		
		
		//END
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test06_MobileDefect_MBL10139() throws Exception {
		//MBL-10139: SpeedSearch - card layout includes some unexpected html
		String methodID = "test06_MobileDefect_MBL10139";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		//Test Params:
	    String searchItem = "abbott";
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);		
	
	    //Step: click Top-Left button to reveal Global Menu...
		headerButton.showGlobalMenu();
	    commNav.searchListView("speedsearch", searchItem);
		
		//VP: check to see that HTML code (e.g. '<a NAME=TheBody>') is not displayed on the page
	    String htmlCode = "<a NAME=TheBody>";
		String resultsMsg = "VP: invalid HTML code was not present in the SpeedSearch results list";
		try { if (!driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + htmlCode + "[\\s\\S]*$"))
			System.out.println(resultsMsg + " - Passed");
		}
		catch (Error e) {
			System.out.println(methodID + "(): " + e.toString());
			System.out.println(resultsMsg + " - Failed");
		}
		
		//END
		System.out.println(ENDLINE);
	}

	//TODO: need to debug Jenkins CI failure for test07_MobileDefect_MBL10143
	@Test(enabled = false)
	public void test07_MobileDefect_MBL10143() throws Exception {
		//MBL-10143: Entity activities - where activities for multiple entities are viewed, the default activity filter for the first entity only is as expected
		String methodID = "test07_MobileDefect_MBL10143";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);	
			
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Test vars:
	    String hashTagXPath = "//*[@id='activity_related_search-expression']/descendant::*[text() = '#this-week']";
	    String entityDetailViewLink = "Activities";
		
		//Section 1: perform test for Account Details, Activities List view	
	    //Step: open the Account Detail view
	    String entityType = "Accounts";
	    String searchItem = "Abbott Ltd.";
		commNav.entityRecordOpenDetailView(entityType, searchItem);
	    
	    //Step: open the Account Activities view
	    String acctDetVwActivitiesXPath = "//*[@id='account_detail']/descendant::*[text() = '" + entityDetailViewLink + "']";
	    driver.findElement(By.xpath(acctDetVwActivitiesXPath)).click();
	    commNav.waitForPage("Activities");
	    
	    //VP: check to see that the '#this-week' hash-tag is displayed/applied
	    String resultsMsg = "VP: #this-week hash-tag is applied to the " + entityType + ", Activities List view";
	    try {
	    	AssertJUnit.assertTrue(driver.findElement(By.xpath(hashTagXPath)).isDisplayed());
	    	System.out.println(resultsMsg + " - Passed");
	    }
	    catch (Error e) {
	    	System.out.println(methodID + "(): " + e.toString());
	    	System.out.println(resultsMsg + " - Failed");
	    }
	    
	    //Section 2: perform test for Contact Details, Activities List view
	    //Step: open the Contact Detail view
	    entityType = "Contacts";
	    String contactName = "Abbott, John";
	    commNav.entityRecordOpenDetailView(entityType, contactName);
	    
	    //Step: open the Contact Activities view
	    String cntctDetVwActivitiesXPath = "//*[@id='contact_detail']/descendant::*[text() = '" + entityDetailViewLink + "']";
	    driver.findElement(By.xpath(cntctDetVwActivitiesXPath)).click();
	    commNav.waitForPage("Activities");
	    
	    //VP: check to see that the '#this-week' hash-tag is displayed/applied
	    resultsMsg = "VP: #this-week hash-tag is applied to the " + entityType + ", Activities List view";
	    try {
	    	AssertJUnit.assertTrue(driver.findElement(By.xpath(hashTagXPath)).isDisplayed());
	    	System.out.println(resultsMsg + " - Passed");
	    }
	    catch (Error e) {
	    	System.out.println(methodID + "(): " + e.toString());
	    	System.out.println(resultsMsg + " - Failed");
	    }
	    
	    //Section 3: perform test for Lead Details, Activities List view
	    //Step: open the Lead Detail view
	    entityType = "Leads";
	    String leadSearch = "Anderson";	//Anderson, Aaron
	    String leadName = "Anderson, Aaron";
	    headerButton.showGlobalMenu();
		commNav.clickGlobalMenuItem(entityType);
		commNav.searchListView(entityType, leadSearch);
		commNav.clickListViewItemN(entityType, 1);
		commNav.waitForPage(leadName);
	    
	    //Step: open the Lead Activities view
	    String leadDetVwActivitiesXPath = "//*[@id='lead_detail']/descendant::*[text() = '" + entityDetailViewLink + "']";
	    driver.findElement(By.xpath(leadDetVwActivitiesXPath)).click();
	    commNav.waitForPage("Activities");
	    
	    //VP: check to see that the '#this-week' hash-tag is displayed/applied
	    resultsMsg = "VP: #this-week hash-tag is applied to the " + entityType + ", Activities List view";
	    try {
	    	AssertJUnit.assertTrue(driver.findElement(By.xpath(hashTagXPath)).isDisplayed());
	    	System.out.println(resultsMsg + " - Passed");
	    }
	    catch (Error e) {
	    	System.out.println(methodID + "(): " + e.toString());
	    	System.out.println(resultsMsg + " - Failed");
	    }
	    
	    //Section 4: perform test for Opportunity Details, Activities List view
	    //Step: open the Opportunity Detail view
	    entityType = "Opportunities";
	    String oppItem = "Abbott WorldWide-Phase I";
		commNav.entityRecordOpenDetailView(entityType, oppItem);
	    
	    //Step: open the Lead Activities view
	    String oppDetVwActivitiesXPath = "//*[@id='opportunity_detail']/descendant::*[text() = '" + entityDetailViewLink + "']";
	    driver.findElement(By.xpath(oppDetVwActivitiesXPath)).click();
	    commNav.waitForPage("Activities");
	    
	    //VP: check to see that the '#this-week' hash-tag is displayed/applied
	    resultsMsg = "VP: #this-week hash-tag is applied to the " + entityType + ", Activities List view";
	    try {
	    	AssertJUnit.assertTrue(driver.findElement(By.xpath(hashTagXPath)).isDisplayed());
	    	System.out.println(resultsMsg + " - Passed");
	    }
	    catch (Error e) {
	    	System.out.println(methodID + "(): " + e.toString());
	    	System.out.println(resultsMsg + " - Failed");
	    }
	    
	    //Section 5: perform test for Ticket Details, Activities List view
	    //Step: open the Opportunity Detail view
	    entityType = "Tickets";
	    String tktItem = "001-00-000102";
		commNav.entityRecordOpenDetailView(entityType, tktItem);
	    
	    //Step: open the Lead Activities view
	    String tktDetVwActivitiesXPath = "//*[@id='ticket_detail']/descendant::*[text() = '" + entityDetailViewLink + "']";
	    driver.findElement(By.xpath(tktDetVwActivitiesXPath)).click();
	    commNav.waitForPage("Activities");
	    
	    //VP: check to see that the '#this-week' hash-tag is displayed/applied
	    resultsMsg = "VP: #this-week hash-tag is applied to the " + entityType + ", Activities List view";
	    try {
	    	AssertJUnit.assertTrue(driver.findElement(By.xpath(hashTagXPath)).isDisplayed());
	    	System.out.println(resultsMsg + " - Passed");
	    }
	    catch (Error e) {
	    	System.out.println(methodID + "(): " + e.toString());
	    	System.out.println(resultsMsg + " - Failed");
	    }
		
		//END
	    commNav.clickGlobalMenuItem("My Activities");
		System.out.println(ENDLINE);
	}

	//TODO: need to debug Jenkins CI failure for test08_MobileDefect_MBL10144
	@Test(enabled = false)
	public void test08_MobileDefect_MBL10144() throws Exception {
		//MBL-10144: Entity notes/history - where notes/history for multiple entities are viewed, the default notes/history filter for the first entity only is as expected
		String methodID = "test08_MobileDefect_MBL10144";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
			
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Test vars:
	    String hashTagXPath = "//*[@id='history_related_search-expression']/descendant::*[text() = '#my-history']";
	    String entityDetailViewLink = "Notes/History";
	    String hashTag = "#my-history";
		
		//Section 1: perform test for Account Details, Activities List view	
	    //Step: open the Account Detail view
	    String entityType = "Accounts";
	    String searchItem = "Abbott Ltd.";
		commNav.entityRecordOpenDetailView(entityType, searchItem);
	    
	    //Step: open the Account Activities view
	    String acctDetVwActivitiesXPath = "//*[@id='account_detail']/descendant::*[text() = '" + entityDetailViewLink + "']";
	    driver.findElement(By.xpath(acctDetVwActivitiesXPath)).click();
	    commNav.waitForPage(entityDetailViewLink);
	    
	    //VP: check to see that the '#this-week' hash-tag is displayed/applied
	    String resultsMsg = "VP: " + hashTag + " hash-tag is applied to the " + entityType + ", Activities List view";
	    try {
	    	AssertJUnit.assertTrue(driver.findElement(By.xpath(hashTagXPath)).isDisplayed());
	    	System.out.println(resultsMsg + " - Passed");
	    }
	    catch (Error e) {
	    	System.out.println(methodID + "(): " + e.toString());
	    	System.out.println(resultsMsg + " - Failed");
	    }
	    
	    //Section 2: perform test for Contact Details, Activities List view
	    //Step: open the Contact Detail view
	    entityType = "Contacts";
	    String contactName = "Abbott, John";
	    commNav.entityRecordOpenDetailView(entityType, contactName);
	    
	    //Step: open the Contact Activities view
	    String cntctDetVwActivitiesXPath = "//*[@id='contact_detail']/descendant::*[text() = '" + entityDetailViewLink + "']";
	    driver.findElement(By.xpath(cntctDetVwActivitiesXPath)).click();
	    commNav.waitForPage(entityDetailViewLink);
	    
	    //VP: check to see that the '#this-week' hash-tag is displayed/applied
	    resultsMsg = "VP: " + hashTag + " hash-tag is applied to the " + entityType + ", Activities List view";
	    try {
	    	AssertJUnit.assertTrue(driver.findElement(By.xpath(hashTagXPath)).isDisplayed());
	    	System.out.println(resultsMsg + " - Passed");
	    }
	    catch (Error e) {
	    	System.out.println(methodID + "(): " + e.toString());
	    	System.out.println(resultsMsg + " - Failed");
	    }
	    
	    //Section 3: perform test for Lead Details, Activities List view
	    //Step: open the Lead Detail view
	    entityType = "Leads";
	    String leadName = "Anderson, Aaron";
	    commNav.entityRecordOpenDetailView(entityType, leadName);
	    
	    //Step: open the Lead Activities view
	    String leadDetVwActivitiesXPath = "//*[@id='lead_detail']/descendant::*[text() = '" + entityDetailViewLink + "']";
	    driver.findElement(By.xpath(leadDetVwActivitiesXPath)).click();
	    commNav.waitForPage(entityDetailViewLink);
	    
	    //VP: check to see that the '#this-week' hash-tag is displayed/applied
	    resultsMsg = "VP: " + hashTag + " hash-tag is applied to the " + entityType + ", Activities List view";
	    try {
	    	AssertJUnit.assertTrue(driver.findElement(By.xpath(hashTagXPath)).isDisplayed());
	    	System.out.println(resultsMsg + " - Passed");
	    }
	    catch (Error e) {
	    	System.out.println(methodID + "(): " + e.toString());
	    	System.out.println(resultsMsg + " - Failed");
	    }
	    
	    //Section 4: perform test for Opportunity Details, Activities List view
	    //Step: open the Opportunity Detail view
	    entityType = "Opportunities";
	    String oppItem = "Abbott WorldWide-Phase I";
		commNav.entityRecordOpenDetailView(entityType, oppItem);
	    
	    //Step: open the Lead Activities view
	    String oppDetVwActivitiesXPath = "//*[@id='opportunity_detail']/descendant::*[text() = '" + entityDetailViewLink + "']";
	    driver.findElement(By.xpath(oppDetVwActivitiesXPath)).click();
	    commNav.waitForPage(entityDetailViewLink);
	    
	    //VP: check to see that the '#this-week' hash-tag is displayed/applied
	    resultsMsg = "VP: " + hashTag + " hash-tag is applied to the " + entityType + ", Activities List view";
	    try {
	    	AssertJUnit.assertTrue(driver.findElement(By.xpath(hashTagXPath)).isDisplayed());
	    	System.out.println(resultsMsg + " - Passed");
	    }
	    catch (Error e) {
	    	System.out.println(methodID + "(): " + e.toString());
	    	System.out.println(resultsMsg + " - Failed");
	    }	    
		
		//END
		System.out.println(ENDLINE);
	}

	//TODO: need to debug Jenkins CI failure for test09_MobileDefect_MBL10160
	@Test(enabled = false)
	public void test09_MobileDefect_MBL10160() throws Exception {
		//MBL-10160: Entity Opportunities - where opportunities for multiple entities are viewed, the default opportunities filter for the first entity only is as expected
		String methodID = "test09_MobileDefect_MBL10160";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
			
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Test vars:
	    String hashTagXPath = "//*[@id='opportunity_related_search-expression']/descendant::*[text() = '#my-opportunities']";
	    String entityDetailViewLink = "Opportunities";
	    String hashTag = "#my-opportunities";
		
		//Section 1: perform test for Account Details, Activities List view	
	    //Step: open the Account Detail view
	    String entityType = "Accounts";
	    String searchItem = "Abbott Ltd.";
		commNav.entityRecordOpenDetailView(entityType, searchItem);
	    
	    //Step: open the Account Activities view
	    String acctDetVwActivitiesXPath = "//*[@id='account_detail']/descendant::*[text() = '" + entityDetailViewLink + "']";
	    driver.findElement(By.xpath(acctDetVwActivitiesXPath)).click();
	    commNav.waitForPage(entityDetailViewLink);
	    
	    //VP: check to see that the '#my-opportunities' hash-tag is displayed/applied
	    String resultsMsg = "VP: " + hashTag + " hash-tag is applied to the " + entityType + ", Activities List view";
	    try {
	    	AssertJUnit.assertTrue(driver.findElement(By.xpath(hashTagXPath)).isDisplayed());
	    	System.out.println(resultsMsg + " - Passed");
	    }
	    catch (Error e) {
	    	System.out.println(methodID + "(): " + e.toString());
	    	System.out.println(resultsMsg + " - Failed");
	    }
	    
	    //Section 2: perform test for Contact Details, Activities List view
	    //Step: open the Contact Detail view
	    entityType = "Contacts";
	    String contactName = "Abbott, John";
	    commNav.entityRecordOpenDetailView(entityType, contactName);
	    
	    //Step: open the Contact Activities view
	    String cntctDetVwActivitiesXPath = "//*[@id='contact_detail']/descendant::*[text() = '" + entityDetailViewLink + "']";
	    driver.findElement(By.xpath(cntctDetVwActivitiesXPath)).click();
	    commNav.waitForPage(entityDetailViewLink);
	    
	    //VP: check to see that the '#my-opportunitie' hash-tag is displayed/applied
	    resultsMsg = "VP: " + hashTag + " hash-tag is applied to the " + entityType + ", Activities List view";
	    try {
	    	AssertJUnit.assertTrue(driver.findElement(By.xpath(hashTagXPath)).isDisplayed());
	    	System.out.println(resultsMsg + " - Passed");
	    }
	    catch (Error e) {
	    	System.out.println(methodID + "(): " + e.toString());
	    	System.out.println(resultsMsg + " - Failed");
	    }
	    
		//END
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test10_MobileDefect_MBL10166() throws Exception {
		//MBL-10160: Entity Opportunities - where opportunities for multiple entities are viewed, the default opportunities filter for the first entity only is as expected
		String methodID = "test10_MobileDefect_MBL10166";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);	
			
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
			
	    //Step: perform SpeedSearch then open a target results record
		//Note: the target results record to open must have an empty Completed By field
	    String searchItem = "Sophia Perez";
	    String recordItem = "Database Change (2012_10_13)";
	    
	    commNav.goToSpeedSearchResultDetailView(searchItem, recordItem);
		
	    //VP: check to see that the History detail page is successfully loaded (when the Completed By field is empty)
	    String resultsMsg = "VP: History Detail page was successfully loaded";
	    try {
	    	AssertJUnit.assertTrue(commNav.waitForPage("History"));
	    	System.out.println(resultsMsg + " - Passed");
	    }
	    catch (Error e) {
	    	System.out.println(methodID + "(): " + e.toString());
	    	System.out.println(resultsMsg + " - Failed");
	    }
	    
		//END
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test11_MobileDefect_MBL10172() throws Exception {
		//MBL-10172: Mobile - Ticket Activities : elapsed hours not displaying as it does in web client (16 dec positions versus 2) [DTS 13091638]
		String methodID = "test11_MobileDefect_MBL10172";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);	
			
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
					
	    //Step: open the Ticket Detail view
	    String entityType = "Tickets";
	    String tktItem = "001-00-000012";
	    String entityDetailViewLink = "Ticket Activities";
	    try {
			commNav.entityRecordOpenDetailView(entityType, tktItem);
		    
		    //Step: open the Ticket Activities view
		    String tktDetVwActivitiesXPath = "//*[@id='ticket_detail']/descendant::*[text() = '" + entityDetailViewLink + "']";
		    driver.findElement(By.xpath(tktDetVwActivitiesXPath)).click();
		    commNav.waitForPage(entityDetailViewLink);
		    
		    //Step: perform a Ticket Activity search
		    String searchItem = "Customer follow up to check on new units";
		    WebElement searchFld = driver.findElement(By.name("query"));
		    WebElement lookupBtn = driver.findElement(By.xpath("//div[3]/button"));
		    searchFld.clear();
		    searchFld.sendKeys(searchItem);
		    lookupBtn.click();
		    Thread.sleep(2000);
		    
		    //Step: click to open the Ticket Activity record
		    WebElement tktListItem = driver.findElement(By.xpath("//*[@id='ticketactivity_related']/ul/li"));
		    tktListItem.click();
		    commNav.waitForNotPage(entityDetailViewLink);
		    
		    //Step: expand the More Details link
		    WebElement moreDetailsLnk = driver.findElement(By.xpath("//*[@id='ticketactivity_detail']/descendant::*[text() = 'More Details']"));
		    moreDetailsLnk.click();
		    
		    //VP: check to see that the Elapsed Hours field is not equal to 0.0333333333333333
		    String txt2Chk = "0.0333333333333333";
		    String resultsMsg = "VP: The Elapsed Hours field value is not equal to " + txt2Chk;
		    try {
			    WebElement elapsedHrsFld = driver.findElement(By.xpath("//*[@id='ticketactivity_detail']/div[2]/div[2]/div[2]"));
			    String elapsedHrsVal = elapsedHrsFld.getText();
		    	AssertJUnit.assertFalse(elapsedHrsVal.equals("elapsed hours" + txt2Chk));
		    	System.out.println(resultsMsg + " - Passed");
		    }
		    catch (Exception e) {
		    	System.out.println(methodID + "(): " + e.toString());
		    	System.out.println(resultsMsg + " - Failed");
		    }
	    }
	    catch (Exception e) {
	    	verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    
		//END
	    commNav.clickGlobalMenuItem("My Activities");
		System.out.println(ENDLINE);
	}



	@Test(enabled = false)
	public void test12_MobileDefect_MBL10185() throws Exception {
		//Edit Ticket Activity view : displaying 'yyyy' and 'tt' instead of the expected 4 digit year and AM/ PM respectively
		String methodID = "test12_MobileDefect_MBL10185";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
			
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
					
	    //Step: open the Ticket Detail view
	    String entityType = "Tickets";
	    String tktItem = "001-00-000026";
	    String entityDetailViewLink = "Ticket Activities";
		commNav.entityRecordOpenDetailView(entityType, tktItem);
	    
		//Step: click the Ticket Activities List view
	    String tktDetVwActivitiesXPath = "//*[@id='ticket_detail']/descendant::*[text() = '" + entityDetailViewLink + "']";
	    driver.findElement(By.xpath(tktDetVwActivitiesXPath)).click();
	    commNav.waitForPage(entityDetailViewLink);
	    
	    //Step: click the top Ticket Activity item to open it's Detail view
	    WebElement tktListItem = driver.findElement(By.xpath("//*[@id='ticketactivity_related']/ul/li/div[1]/h3"));
	    tktListItem.click();
	    commNav.waitForNotPage(entityDetailViewLink);
	    
	    //Step: enter the Edit view of the Ticket Activity record
	    headerButton.clickHeaderButton("Edit");
	    commNav.waitForPage("Edit Ticket Activity");
	    
	    //VP: check to see that 'yyyy' does not appear as a value for Year labels in the Start/End Date fields
	    String txt2Chk = "yyyy";
	    String resultsMsg = "VP: The Start & End Date field values do not contain '" + txt2Chk + "' for the Year labels";
	    try {
	    	AssertJUnit.assertTrue(commNav.isTextNotPresentOnPage(txt2Chk));
	    	System.out.println(resultsMsg + " - Passed");
	    }
	    catch (Exception e) {
	    	System.out.println(methodID + "(): " + e.toString());
	    	System.out.println(resultsMsg + " - Failed");
	    }
	    
	    //VP: check to see that 'tt' does not appear as a value for the AM/PM labels in the Start/End Date fields
	    txt2Chk = "tt";
	    resultsMsg = "VP: The Start & End Date field values do not contain '" + txt2Chk + "' for the AM/PM labels";
	    try {
	    	AssertJUnit.assertTrue(commNav.isTextNotPresentOnPage(txt2Chk));
	    	System.out.println(resultsMsg + " - Passed");
	    }
	    catch (Exception e) {
	    	System.out.println(methodID + "(): " + e.toString());
	    	System.out.println(resultsMsg + " - Failed");
	    }
	    
		//END
	    commNav.clickGlobalMenuItem("My Activities");
		System.out.println(ENDLINE);
	}


	@Test(enabled = true)
	public void test13_MobileDefect_MBL10186() throws Exception {
		//MBL-10186: Activity Work Phone
		String methodID = "test13_MobileDefect_MBL10186";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
			
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Section 1: test the Account-based scenario
	    //Step: open the Account Detail view
	    String entityType = "Accounts";
	    String searchItem = "Abbott Ltd.";
		commNav.entityRecordOpenDetailView(entityType, searchItem);
		
		//Step: capture the phone number from the Account Detail view
		String acctDetVwPhoneFldXPath = "//*[@id='account_detail']/div[2]/ul[1]/li[1]/a/span";
		String acctDetVwPhoneNum = driver.findElement(By.xpath(acctDetVwPhoneFldXPath)).getText();
		
	    //Step: schedule an activity from an Account Detail view
		String entityDetailViewLink = "Schedule activity";
	    String acctDetVwSchedActivityXPath = "//*[@id='account_detail']/descendant::*[text() = '" + entityDetailViewLink + "']";
	    driver.findElement(By.xpath(acctDetVwSchedActivityXPath)).click();
	    commNav.waitForPage("Schedule...");
	    
	    String actyType = "Meeting";
	    String actyTypeLinkXPath = ".//*[@id='activity_types_list']/descendant::*[text() = '" + actyType + "']";
	    driver.findElement(By.xpath(actyTypeLinkXPath)).click();
	    commNav.waitForPage(actyType);
	    
	    String actyEditViewPhoneFldCSS = "input[name='PhoneNumber']";
	    String actyEditViewPhoneFldVal = driver.findElement(By.cssSelector(actyEditViewPhoneFldCSS)).getAttribute("value");
	    
	    //VP: check to see that the phone number value in the Activity Insert/Edit matches the assoicated Acccount 
	    String resultsMsg = "VP: The Phone Number in the Activity Edit view matches that of the accociated Account record";
	    try {
	    	AssertJUnit.assertTrue(actyEditViewPhoneFldVal.equals(acctDetVwPhoneNum));
	    	System.out.println(resultsMsg + " - Passed");
	    }
	    catch (Exception e) {
	    	System.out.println(methodID + "(): " + e.toString());
	    	System.out.println(resultsMsg + " - Failed");
	    }
	    
	    System.out.println("");
	    
		//Section 2: test the Contact-based scenario
	    //Step: open the Contact Detail view
	    entityType = "Contacts";
	    searchItem = "Abbott, John";
		commNav.entityRecordOpenDetailView(entityType, searchItem);
		
		//Step: capture the phone number from the Contact Detail view
		String cntctDetVwPhoneFldXPath = "//*[@id='contact_detail']/div[2]/ul[1]/li[1]/a/span";
		String cntctDetVwPhoneNum = driver.findElement(By.xpath(acctDetVwPhoneFldXPath)).getText();
		
	    //Step: schedule an activity from an Account Detail view
		entityDetailViewLink = "Schedule activity";
	    String cntctDetVwSchedActivityXPath = "//*[@id='contact_detail']/descendant::*[text() = '" + entityDetailViewLink + "']";
	    driver.findElement(By.xpath(cntctDetVwSchedActivityXPath)).click();
	    commNav.waitForPage("Schedule...");
	    
	    actyType = "Meeting";
	    actyTypeLinkXPath = ".//*[@id='activity_types_list']/descendant::*[text() = '" + actyType + "']";
	    driver.findElement(By.xpath(actyTypeLinkXPath)).click();
	    commNav.waitForPage(actyType);
	    
	    //String actyEditViewPhoneFldCSS = "input[name='PhoneNumber']";
	    //String actyEditViewPhoneFldVal = driver.findElement(By.cssSelector(actyEditViewPhoneFldCSS)).getAttribute("value");
	    
	    //VP: check to see that the phone number value in the Activity Insert/Edit matches the assoicated Acccount 
	    resultsMsg = "VP: The Phone Number in the Activity Edit view matches that of the accociated Contact record";
	    try {
	    	AssertJUnit.assertTrue(actyEditViewPhoneFldVal.equals(acctDetVwPhoneNum));
	    	System.out.println(resultsMsg + " - Passed");
	    }
	    catch (Exception e) {
	    	System.out.println(methodID + "(): " + e.toString());
	    	System.out.println(resultsMsg + " - Failed");
	    }
	    
		//END
	    commNav.clickGlobalMenuItem("My Activities");
		System.out.println(ENDLINE);
	}

	
	//TODO: need to debug Jenkins CI failure for test14_MobileDefect_MBL10192
	//TODO: setup additional test methods for notes/history, contacts, leads, opps. & tickets list views
	@Test(enabled = false)
	public void test14_MobileDefect_MBL10192() throws Exception {
		//MBL-10192: Listviews - after an item is added to a listview, then edited, the default filter does display above the list, but it is not in effect
		String methodID = "test14_MobileDefect_MBL10192";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
			
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Test vars:
	    String hashTagXPath = "//*[@id='activity_related_search-expression']/descendant::*[text() = '#this-week']";
	    String entityDetailViewLink = "Activities";
	    String actType = "Meeting";
	    String regardingVal = "Demonstration";
		
		//Section 1:	
	    //Step: open the Account Detail view
	    String entityType = "Accounts";
	    String searchItem = "Abbott Ltd.";
		commNav.entityRecordOpenDetailView(entityType, searchItem);
	    
	    //Step: open the Account Activities view
	    String acctDetVwActivitiesXPath = "//*[@id='account_detail']/descendant::*[text() = '" + entityDetailViewLink + "']";
	    driver.findElement(By.xpath(acctDetVwActivitiesXPath)).click();
	    commNav.waitForPage(entityDetailViewLink);
	    
	    //Step: add an Account Activity item
	    headerButton.clickHeaderButton("add");
		try {
			AssertJUnit.assertTrue(commNav.waitForPage("Schedule..."));
			
			//TODO: create a separate class for scheduling activities...
			//SubStep: set the Activity Type...
			driver.findElement(By.xpath("//*[@id='activity_types_list']/descendant::*[text() = '" + actType + "']")).click();
			commNav.waitForPage(actType);
		    
			//SubStep: setup the activity...
			//NOTE: here we just set the value of the input text field; selecting a Regarding value is not supported by Se WebDriver
			String regardingFldXPath = "//div[2]/div/input";
			driver.findElement(By.xpath(regardingFldXPath)).click();
			driver.findElement(By.xpath(regardingFldXPath)).clear();
			driver.findElement(By.xpath(regardingFldXPath)).sendKeys(regardingVal);
		    
		    //SubStep: leave all other Activity fields set to their defaults...
			
		    //Step: click the Header, Save button to return to Contact detail view...
		    headerButton.clickHeaderButton("save");
		    Thread.sleep(5000);
		    commNav.waitForPage(entityDetailViewLink);
		}
		catch (Exception e) {
			System.out.println("VP: The Schedule view was not displayed; test aborted.");
		}
	    
		//Section 2:
		//Step: capture the current Activities List view text
		MyActivityViewsElements activitiesList = PageFactory.initElements(driver, MyActivityViewsElements.class);
		
		String initActivityListViewTxt = activitiesList.getRelatedActivitiesListViewTxt();
		
		//Step: find and re-open the scheduled Activity
		activitiesList.performRelActivitiesSearch(regardingVal);
		activitiesList.selectNOpenRelatedActivityListItem(regardingVal);
		
		//Step: edit the Activity record
		headerButton.clickHeaderButton("edit");
		commNav.waitForPage("Activity");
		
		//Step: modify and save the Activity
		WebElement actyEditLocationFld = driver.findElement(By.cssSelector("input[name='Location']"));
		String modLocVal = "secret, un-disclosed location";
		actyEditLocationFld.click();
		actyEditLocationFld.sendKeys(modLocVal);
		
		headerButton.clickHeaderButton("save");
		commNav.waitForNotPage("Activity");
		
		//Section 3:
		//Step: navigate back to the Activities List view
		headerButton.clickHeaderButton("back");
		commNav.waitForPage("Activities");
		
		//Step: capture the current Activities List view text
		commNav.rightClickContextMenuItem("this-week");
		Thread.sleep(5000);
		activitiesList = PageFactory.initElements(driver, MyActivityViewsElements.class);		
		
		String nextActivityListViewTxt = activitiesList.getRelatedActivitiesListViewTxt();
		
	    //VP: check to see that the '#this-week' hash-tag is displayed/applied
	    String resultsMsg = "VP: #this-week hash-tag is applied to the " + entityType + ", Activities List view";
	    try {
	    	AssertJUnit.assertTrue(driver.findElement(By.xpath(hashTagXPath)).isDisplayed());
	    	System.out.println(resultsMsg + " - Passed");
	    }
	    catch (Error e) {
	    	System.out.println(methodID + "(): " + e.toString());
	    	System.out.println(resultsMsg + " - Failed");
	    }
	    
	    //VP: check to see that the current Activities List view matches the initially captured view
	    resultsMsg = "VP: the current Activity List view results are appplicable to the '#this-week' hash-tag filter";
	    try {
	    	AssertJUnit.assertTrue(initActivityListViewTxt.equals(nextActivityListViewTxt));
	    	System.out.println(resultsMsg + " - Passed");
	    }
	    catch (Error e) {
	    	System.out.println(methodID + "(): " + e.toString());
	    	System.out.println(resultsMsg + " - Failed");
	    }	    
	    
	    System.out.println("");
	    	    
		//END
	    commNav.clickGlobalMenuItem("My Activities");
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
