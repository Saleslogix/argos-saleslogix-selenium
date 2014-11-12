package argos.saleslogix.selenium.test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;


/**
 * Test class that defines test methods for the Lead entity views on the Mobile Client.
 * *
 * @author mike.llena@swiftpage.com
 * @version	1.0
 */
public class LeadEntityViewsTest extends BaseTest {
	
	public String TEST_LEAD_RECORD = "Beck, John";
	
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
	
	//Test Set
	//========
	@Test(enabled = true)
	public void test01_SeTestTCLeadListView() throws Exception {
		//Reference: MBL-10050
		String methodID = "test01_SeTestTCLeadListView";
		
		// Test Params:
		String entityType = "Leads";
		String expEntityPgTitle = "Leads";
		String leadRecord = TEST_LEAD_RECORD;
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
	    //Step: navigate to specific Leads list view...
		commNav.entityListViewSearchContains(entityType, leadRecord);
		
		//Step: test Leads, List View page elements
		if (commNav.isPageDisplayed(expEntityPgTitle)) {
			
			LeadViewsElements LeadListView = PageFactory.initElements(driver, LeadViewsElements.class);
						
			//Step: check the Leads list view format
			commNav.checkIfWebElementPresent("Leads List View", LeadListView.leadsListView);
			
			//Step: check an Lead list view item record
			commNav.checkIfWebElementPresent("Leads List View, item record", LeadListView.topLeadsListItem);
			commNav.checkIfWebElementPresent("Leads List View, item record icon", LeadListView.topLeadsListItemIcon);
			commNav.checkIfWebElementPresent("Leads List View, item record name", LeadListView.topLeadsListItemName);
			commNav.checkIfWebElementPresent("Leads List View, item record company", LeadListView.topLeadsListItemLine2);
			commNav.checkIfWebElementPresent("Leads List View, item record work", LeadListView.topLeadsListItemLine3);
			commNav.checkIfWebElementPresent("Leads List View, item record web", LeadListView.topLeadsListItemLine4);
			commNav.checkIfWebElementPresent("Leads List View, item record email", LeadListView.topLeadsListItemLine5);
			
			//Step: check the Quick Action button and items
			try {
				//click list item icon to reveal Quick Action items
				LeadListView.topLeadsListItemIcon.click();
				
				//click the Quick Action button, then check each of the Quick Action items
				commNav.checkIfWebElementPresent("Leads, Quick Action Add Attachment button", LeadListView.topLeadsListItemQuickActionsAddAttachmentBtn);
				commNav.checkIfWebElementPresent("Leads, Quick Action Add Activity button", LeadListView.topLeadsListItemQuickActionsAddActivityBtn);
				commNav.checkIfWebElementPresent("Leads, Quick Action Add Note button", LeadListView.topLeadsListItemQuickActionsAddNoteBtn);
				commNav.checkIfWebElementPresent("Leads, Quick Action Email button", LeadListView.topLeadsListItemQuickActionsEmailBtn);
				commNav.checkIfWebElementPresent("Leads, Quick Action Call Mobile button", LeadListView.topLeadsListItemQuickActionsCallMobileBtn);
				commNav.checkIfWebElementPresent("Leads, Quick Action Call Work button", LeadListView.topLeadsListItemQuickActionsCallWorkBtn);
				commNav.checkIfWebElementPresent("Leads, Quick Action Edit button", LeadListView.topLeadsListItemQuickActionsEditBtn);
				
				//click list item icon to hide the Quick Action items
				LeadListView.topLeadsListItemIcon.click();
			}
			catch (Exception e) {
				verificationErrors.append(methodID + "(): " + e.toString());				
			}			
		}
		else {
			System.out.println(methodID + ": required '" + expEntityPgTitle + "' not loaded; test aborted");
		}
		
		commNav.clickGlobalMenuItem("My Activities");
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test02_SeTestTCLeadListViewLoadMoreResults() throws Exception {
		String methodID = "test02_SeTestTCLeadListViewLoadMoreResults";
		
		//Test Params:
		String entityType = "Leads";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
        LeadViewsElements leadsListView = PageFactory.initElements(driver, LeadViewsElements.class);

		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: logout & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
		
	    //Step: click Top-Left button to reveal Global Menu...
		headerbutton.showGlobalMenu();
	
	    //Step: navigate to Leads list view... wait for page to open
		commNav.clickGlobalMenuItem(entityType);
        commNav.waitForPage("Leads");
		
		//Step: reveal Right Context Menu panel, clear search button and search on all records
        leadsListView.leadsSearchClearBtn.click();
        leadsListView.leadsSearchLookupBtn.click();
        Thread.sleep(3000);

        //capture the initial Leads List view info
        String initLeadsListInfo = leadsListView.getLeadsListViewTxt();

        //Step: load more results (click on 'x remaining records' item)
        for (int count = 1; count<3; count++) {
            JavascriptExecutor jsx = (JavascriptExecutor)driver;
            jsx.executeScript("window.scrollBy(0,450)", "");
        }

        //capture the expanded Leads List view
        String expandedLeadsListInfo = leadsListView.getLeadsListViewTxt();

        //VP: confirm that the Leads List view is indeed expanded with more record data
        String resultMsg = "VP: scrolling down the Leads List view loaded more records";
        try {
            AssertJUnit.assertFalse(initLeadsListInfo.matches(expandedLeadsListInfo));
            System.out.println(resultMsg + " - PASSED");
        }
        catch (Error e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println(resultMsg + " - FAILED");
        }
		
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = true)
	public void test03_SeTestTCLeadListViewSearch() throws Exception {
		String methodID = "test03_SeTestTCLeadListViewSearch";
		
		// Test Params:
		String entityType = "Leads";
		String entityRecord = TEST_LEAD_RECORD;
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for an existing Lead record
		commNav.entityListViewSearch(entityType, entityRecord);		
		
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test04_SeTestTCLeadListViewNegativeSearch() throws Exception {
		String methodID = "test04_SeTestTCLeadListViewNegativeSearch";

		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Test Params:
		String entityType = "leads";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		//Step: search for non-existent Lead record to confirm it's non-existence
		commNav.entityListViewNegativeSearch(entityType, "Non-Existent Lead");		
		
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = true)
	public void test05_SeTestTCLeadListViewClearSearch() throws Exception {
		String methodID = "test05_SeTestTCLeadListViewClearSearch";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Leads";
		String entityRecord = TEST_LEAD_RECORD;
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        LeadViewsElements LeadListView = PageFactory.initElements(driver, LeadViewsElements.class);

		commNav.entityListViewSearch(entityType, entityRecord);
			
		//Step: check for matching results...
        String initLeadsListInfo = LeadListView.getLeadsListViewTxt();
				
		//Step: click the clear Search input field button
		headerButton.showRightContextMenu();
		LeadListView.leadsSearchClearBtn.click();
				
		//Step: click the Lookup button to reload the full Leads list
		LeadListView.leadsSearchLookupBtn.click();
		Thread.sleep(7000);
				
		//Step: check if the previous search results were cleared
        String expandedLeadsListInfo = LeadListView.getLeadsListViewTxt();
		try {
            AssertJUnit.assertFalse(initLeadsListInfo.matches(expandedLeadsListInfo));
            System.out.println(methodID + ": clear previous Leads search results action PASSED");
		} catch (Error e) {
			verificationErrors.append(methodID + "(): " + e.toString());
			System.out.println(methodID + ": clear previous Leads search results action FAILED");
		}

		System.out.println(ENDLINE);
	}

	
	@Test(enabled = true)
	public void test06_SeTestTCLeadListViewOpenRecord() throws Exception {
		String methodID = "test06_SeTestTCLeadListViewOpenRecord";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Leads";
		String entityRecord = TEST_LEAD_RECORD;
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        //Step: login & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        try {
            //Step: search for Lead entity, then open it's Detail view
            commNav.entityRecordOpenDetailView(entityType, entityRecord);

            //Step: go back to previous screen
            headerButton.goBack();
            Thread.sleep(3000);
        }
        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
        }
		
		System.out.println(ENDLINE);
	}
	
	@Test(enabled = true)
	public void test07_SeTestTCLeadDetailView() throws Exception {
		String methodID = "test07_SeTestTCLeadDetailView";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Lead";
		String entityRecord = TEST_LEAD_RECORD;
		String viewName = "Lead Detail view";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        //Step: login & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);
		
		try {
			//Step: search for Lead entity, then open it's Detail view
			commNav.entityRecordOpenDetailView(entityType, entityRecord);
			
			LeadViewsElements leadDetailView = PageFactory.initElements(driver, LeadViewsElements.class);
			
			//Step: check each item under the Lead Detail View, Quick Actions section
			commNav.isWebElementPresent(viewName + ",'Quick Actions' section header", leadDetailView.leadsDetailViewQuickActionsHdr);
			commNav.isWebElementPresent(viewName + ",'Call main number'", leadDetailView.leadsDetailViewCallMainNumberLnk);
			commNav.isWebElementPresent(viewName + ",'Send email'", leadDetailView.leadsDetailViewSendEmailLnk);
			commNav.verifyEntityViewElementClick(viewName + ",'Schedule activity'", leadDetailView.leadsDetailViewScheduleActivityLnk, "Schedule...");
			commNav.isWebElementPresent(viewName + ",'Add note'", leadDetailView.leadsDetailViewAddNoteLnk);
			//TODO: figure out why there is a failure for this step; reverting to 
			commNav.verifyEntityViewElementClick(viewName + ",'Add note'", leadDetailView.leadsDetailViewAddNoteLnk, "Note");
			commNav.isWebElementPresent(viewName + ",'View address'", leadDetailView.leadsDetailViewViewAddressLnk);
			
			//Step: check each item under the Lead Detail View, Details section
			commNav.isWebElementPresent(viewName + ",'Details' section header", leadDetailView.leadsDetailViewDetailsHdr);
			commNav.isFieldValueEmpty(viewName + ",'name'", leadDetailView.leadsDetailViewNameFld);
			commNav.isFieldValueEmpty(viewName + ",'company'", leadDetailView.leadsDetailViewCompanyFld);
			commNav.isFieldValueEmpty(viewName + ",'web'", leadDetailView.leadsDetailViewWebFld);
			commNav.isFieldValueEmpty(viewName + ",'title'", leadDetailView.leadsDetailViewTitleFld);
			commNav.isFieldValueEmpty(viewName + ",'work phone'", leadDetailView.leadsDetailViewWorkPhoneFld);
			commNav.isFieldValueEmpty(viewName + ",'mobile phone'", leadDetailView.leadsDetailViewMobilePhoneFld);
			commNav.isFieldValueEmpty(viewName + ",'toll free'", leadDetailView.leadsDetailViewTollFreeFld);
			commNav.isFieldValueEmpty(viewName + ",'lead source'", leadDetailView.leadsDetailViewLeadSourceFld);

			//Step: check each item under the Lead Detail View, More Details section
			commNav.isWebElementPresent(viewName + ",'More Details' section header", leadDetailView.leadsDetailViewMoreDetailsHdr);
			//SubStep: conditionally expand the More Details section
			if (leadDetailView.leadsDetailViewMoreDetailsFields.getSize().height < 1) {
				leadDetailView.leadsDetailViewMoreDetailsHdr.click();
				Thread.sleep(1000);
			}
			commNav.isFieldValueEmpty(viewName + ",'interests'", leadDetailView.leadsDetailViewInterestsFld);
			commNav.isFieldValueEmpty(viewName + ",'industry'", leadDetailView.leadsDetailViewIndustryFld);
			commNav.isFieldValueEmpty(viewName + ",'sic code'", leadDetailView.leadsDetailViewSicCodeFld);
			commNav.isFieldValueEmpty(viewName + ",'bus desc'", leadDetailView.leadsDetailViewBusDescFld);
			commNav.isFieldValueEmpty(viewName + ",'comments'", leadDetailView.leadsDetailViewCommentsFld);
			commNav.isFieldValueEmpty(viewName + ",'owner'", leadDetailView.leadsDetailViewOwnerFld);

			//Step: check each item under the Lead Detail View, Related Items section
			commNav.isWebElementPresent(viewName + ",'Related Items' section header", leadDetailView.leadsDetailViewRelatedItemsHdr);
			commNav.verifyEntityViewElementClick(viewName + ",'Activities'", leadDetailView.leadsDetailViewActivitiesLnk, "Activities");
			commNav.verifyEntityViewElementClick(viewName + ",'Notes/History'", leadDetailView.leadsDetailViewNotesHistoryLnk, "Notes/History");
			commNav.verifyEntityViewElementClick(viewName + ",'Attachments'", leadDetailView.leadsDetailViewAttachmentsLnk, "Lead Attachments");
			
			//Step: go back to previous screen
			headerButton.goBack();
			Thread.sleep(3000);
		}
		catch (Exception e) {
			verificationErrors.append(methodID + "(): " + e.toString());
		}
		
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test08_SeTestTCLeadEditView() throws Exception {
		String methodID = "test08_SeTestTCLeadEditView";
		
		// Test Params:
		String entityType = "Lead";
		String entityRecord = TEST_LEAD_RECORD;
		String viewName = "Lead Edit view";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: login & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
		
		try {
			//Step: search for Lead entity, then open it's Edit view
			AssertJUnit.assertTrue(commNav.entityRecordEditView(entityType, entityRecord));
			
			LeadViewsElements leadEditView = PageFactory.initElements(driver, LeadViewsElements.class);
		
			//Step: check each input field and if applicable, its related list item selection view
			commNav.isWebElementPresent(viewName + ", 'Details' section header", leadEditView.leadsEditViewDetailsHdr);
			commNav.verifyEntityViewElementClick(viewName + ", name field", leadEditView.leadsEditViewNameFldBtn, "Edit Name");			
			commNav.isFieldValueEmpty(viewName + ", company field", leadEditView.leadsEditViewCompanyInputFld);			
			commNav.isFieldValueEmpty(viewName + ", web field", leadEditView.leadsEditViewWebInputFld);			
			commNav.isFieldValueEmpty(viewName + ", work phone field", leadEditView.leadsEditViewWorkPhoneInputFld);			
			commNav.isWebElementPresent(viewName + ", mobile phone field", leadEditView.leadsEditViewWorkPhoneInputFld);
			commNav.isWebElementPresent(viewName + ", toll free field", leadEditView.leadsEditViewTollFreeInputFld);
			commNav.isWebElementPresent(viewName + ", email field", leadEditView.leadsEditViewEmailInputFld);
			commNav.verifyEntityViewElementClick(viewName + ", title field", leadEditView.leadsEditViewTitleFldBtn, "Title");			
			commNav.verifyEntityViewElementClick(viewName + ", address field", leadEditView.leadsEditViewAddressFldBtn, "Address");
			commNav.verifyEntityViewElementClick(viewName + ", lead source field", leadEditView.leadsEditViewLeadSourceFldBtn, "Lead Sources");
			commNav.isWebElementPresent(viewName + ", interests field", leadEditView.leadsEditViewInterestsInputFld);
			commNav.verifyEntityViewElementClick(viewName + ", industry field", leadEditView.leadsEditViewIndustryFldBtn, "Industry");			
			commNav.isWebElementPresent(viewName + ", sic code field", leadEditView.leadsEditViewSicCodeInputFld);
			commNav.isWebElementPresent(viewName + ", business description text area", leadEditView.leadsEditViewBusDescInputFld);			
			commNav.verifyEntityViewElementClick(viewName + ", owner field", leadEditView.leadsEditViewOwnerFldBtn, "Owners");
			
			//end of test
			headerButton.clickHeaderButton("cancel");
		
			//Step: go back to previous screen
			headerButton.goBack();
			Thread.sleep(2000);
		} catch (Exception e) {
			verificationErrors.append(methodID + "(): " + e.toString());
			System.out.println(methodID + ": unable to open locate the '" + entityRecord + "' " + entityType);		
		}
		
		System.out.println(ENDLINE);
	}
	
	@Test(enabled = false)
	public void test98_SeTestTCAttachLeadScreens() throws Exception {
	    // SETest-Attachments_Lead_Screens
	    // Version: 2.2
	    // Desc: Confirms that the Attachments feature is functional from Lead screens...
	    // Condition(s): Test user is logged in.    
	    // Required Entities: Lead - Abbott Ltd.
	    // ==================================================================
		String methodID = "test01_SeTestTCAttachLeadScreens";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "Leads";
		String entityRecordName = "Abbott Ltd.";

		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    // Step: click Top-Left button to reveal Global Menu...
		headerbutton.showGlobalMenu();
	
	    // Step: navigate to Leads list view...
		commNav.clickGlobalMenuItem(entityType);
	
	    // Step: perform search for Lead items...
		commNav.searchListView(entityType, entityRecordName);
	
	    // Step: navigate to top Lead record...
	    commNav.clickListViewItemN(entityType, 1);
	    commNav.waitForPage(entityRecordName);
	
		//TODO: Left-off routine refactoring here (6/13/13)
	    // VP: confirm that Attachments is available under the Related Items section...
	    try {
	      assertTrue(isElementPresent(By.xpath("(//img[@alt='icon'])[11]")));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    try {
	      assertEquals("Attachments", driver.findElement(By.xpath("//div[@id='Lead_detail']/div[2]/ul[2]/li[7]/a/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    // Step: click the Attachments link...
	    driver.findElement(By.xpath("//div[@id='Lead_detail']/div[2]/ul[2]/li[7]/a/span")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Lead Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // Step: click to open an Attachment item...
	    try {
	      assertTrue(isElementPresent(By.xpath(".//*[@id='Lead_attachment_related']/ul/li[1]")));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    
	    // Step: search for a specific attachment item
	    driver.findElement(By.xpath(".//*[@selected='true']//input[@name='query']")).clear();
	    driver.findElement(By.xpath(".//*[@selected='true']//input[@name='query']")).sendKeys("Test123");
	    driver.findElement(By.xpath(".//*[@selected='true']//button[@class='subHeaderButton searchButton']")).click();
	    Thread.sleep(5000);
	    try {
		      assertTrue(isElementPresent(By.linkText("Test123")));
		    } catch (Error e) {
		      verificationErrors.append(methodID + "(): " + e.toString());
		    }
	    driver.findElement(By.linkText("Test123")).click();
	    
	    // Step: click the top Add buton...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Add Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    // VP: confirm the elements of the Add Attachments screen...
	    try {
	      assertTrue(isElementPresent(By.cssSelector("input[type=\"file\"]")));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.cssSelector("button.button.inline")));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='attachment_Add']/div[2]/div/button[2]")));
	    } catch (Error e) {
	      verificationErrors.append(methodID + "(): " + e.toString());
	    }
	    // Step: navigate back to Lead screen...
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Lead Attachments".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Abbott Ltd.".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("Leads".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	
	    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) Assert.fail("timeout");
	    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    // -- END
	    System.out.println(ENDLINE);
	}
	

	@Test(enabled = false)
	public void test10_SeTestTCLeadListViewHashTags() throws Exception {
		String methodID = "test10_SeTestTCLeadListViewHashTags";
		
		// Test Params:
		String entityType = "Leads";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: login & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);
		
	    //Step: navigate to Contacts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		LeadViewsElements leadsListView = PageFactory.initElements(driver, LeadViewsElements.class);
		
		//Step: reveal Right Context Menu panel
		headerButton.showRightContextMenu();
		
	    //Step: test the Hash Tags header
		//expand the Hash Tags sub-panel if it's currently collapsed
		if (!leadsListView.leadsHashTagsPnl.isDisplayed()) {
			leadsListView.leadsHashTagsHdr.click();
			
			//confirm the the panel was indeed expanded
			try {
				AssertJUnit.assertTrue(leadsListView.leadsHashTagsPnl.isDisplayed());
			}
			catch (Error e) {
				verificationErrors.append(methodID + "(): " + e.toString());
				System.out.println(methodID + ": Hash Tags panel failed to expand on panel header click; test aborted.");
				return;
			}
		}
		//collapase the Hash Tags sub-panel
		leadsListView.leadsHashTagsHdr.click();
		try {
			AssertJUnit.assertFalse(leadsListView.leadsHashTagsPnl.isDisplayed());
			System.out.println("VP: Hash Tags sub-panel collapse check - Passed");
			
			//re-expand the Hash Tags sub-panel
			leadsListView.leadsHashTagsHdr.click();
			try {
				AssertJUnit.assertTrue(leadsListView.leadsHashTagsPnl.isDisplayed());
				System.out.println("VP: Hash Tags sub-panel expand check - Passed");
			}
			catch (Error e) {
				verificationErrors.append(methodID + "(): " + e.toString());
				System.out.println("VP: Hash Tags sub-panel expand check - FAILED");
			}
		}
		catch (Error e) {
			verificationErrors.append(methodID + "(): " + e.toString());
			System.out.println("VP: Hash Tags sub-panel collapse check - FAILED");
		}
		
		//Step: test each of the pre-set Hash Tag items
		commNav.rightClickContextMenuItem("my-leads");
		commNav.rightClickContextMenuItem("can-email");
		commNav.rightClickContextMenuItem("can-phone");
		commNav.rightClickContextMenuItem("can-fax");
		commNav.rightClickContextMenuItem("can-mail");
		commNav.rightClickContextMenuItem("can-solicit");
		
		//Step: go back to previous screen
		headerButton.goBack();
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test11_SeTestTCLeadListViewKPI() throws Exception {
		String methodID = "test11_SeTestTCLeadListViewKPI";
		
		// Test Params:
		String entityType = "Leads";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: login & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);
		
	    //Step: navigate to Contacts list view...
		commNav.clickGlobalMenuItem(entityType);
		
		LeadViewsElements leadsListView = PageFactory.initElements(driver, LeadViewsElements.class);
		
		//Step: reveal Right Context Menu panel
		headerButton.showRightContextMenu();
		
	    //Step: test the KPI header
		//expand the KPI sub-panel if it's currently collapsed
		if (!leadsListView.leadsKPIPnl.isDisplayed()) {
			leadsListView.leadsKPIHdr.click();
			
			//confirm the the panel was indeed expanded
			try {
				AssertJUnit.assertTrue(leadsListView.leadsHashTagsPnl.isDisplayed());
			}
			catch (Error e) {
				verificationErrors.append(methodID + "(): " + e.toString());
				System.out.println(methodID + ": Hash Tags panel failed to expand on panel header click; test aborted.");
				return;
			}
		}
		//collapse Hash Tags sub-panel check
		leadsListView.leadsKPIHdr.click();
		try {
			AssertJUnit.assertFalse(leadsListView.leadsKPIPnl.isDisplayed());
			System.out.println("VP: KPI sub-panel collapse check - Passed");
			
			//re-expand the Hash Tags sub-panel
			leadsListView.leadsKPIHdr.click();
			try {
				AssertJUnit.assertTrue(leadsListView.leadsKPIPnl.isDisplayed());
				System.out.println("VP: KPI sub-panel expand check - Passed");
			}
			catch (Error e) {
				verificationErrors.append(methodID + "(): " + e.toString());
				System.out.println("VP: KPI sub-panel e check - FAILED");
			}
		}
		catch (Error e) {
			verificationErrors.append(methodID + "(): " + e.toString());
			System.out.println("VP: KPI sub-panel collapse check - FAILED");
		}
		
		//Step: test each of the pre-set KPI items		
		commNav.scrollDownPage();
		commNav.rightClickContextMenuItem("Total Leads");
		
		//Step: go back to previous screen
		headerButton.closeRightContextMenu();
		headerButton.goBack();
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test12_SeTestTCLeadListViewAddLead() throws Exception {
		String methodID = "test12_SeTestTCLeadListViewAddLead";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: login & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
				
		LeadViewsElements leadsListView = PageFactory.initElements(driver, LeadViewsElements.class);
		
		//Step: add a random test Lead record
		String newLeadLastName = "Turing-" + new SimpleDateFormat("yyMMddHHmm").format(new GregorianCalendar().getTime());
		leadsListView.doAddRandTestLead(newLeadLastName, "Alan", "Turing and Co.");
		
		//Step: find the newly-added test Lead record
		String strResultsMsg = "VP: recently added test Lead '" + newLeadLastName + "' was found.";
        String fullName = newLeadLastName + ", Alan";
        WebElement entityListItem = commNav.entityListViewSearch("Lead", fullName);

        if (entityListItem.isDisplayed())  {
            System.out.println(strResultsMsg + " - PASSED");
        }
        else {
            System.out.println(strResultsMsg + " - FAILED");
        }
		
		//Step: go back to My Activities view
		commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = false)
	public void test13_SeTestTCLeadListViewNotesBox() throws Exception {
		//Reference: MBL-10042
		String methodID = "test13_SeTestTCLeadListViewNotesBox";

		// Test Params:
		String entityType = "Leads";
		String expEntityPgTitle = "Leads";
		String entityRecord = TEST_LEAD_RECORD;
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: login & log back in (to clear cookies)  TODO added logout/in
        LogOutThenLogBackIn(userName, userPwd);
	
	    //Step: navigate to Leads list view...
		commNav.entityListViewSearch(entityType, entityRecord);
		
		//Step: test Leads, List View page elements
		// SubStep: check the Page Title
		if (commNav.isPageDisplayed(entityType)) {
			
			LeadViewsElements leadListView = PageFactory.initElements(driver, LeadViewsElements.class);			
			
			//Step: check the Leads list view format
			commNav.checkIfWebElementPresent("Leads List View", leadListView.leadsListView);
			
			//Step: check an Account list view item record
			commNav.checkIfWebElementPresent("Leads List View, Notes Box", leadListView.leadsListViewNotesBox1stItem);			
			commNav.checkIfWebElementPresent("Leads List View, Notes Box item, Initials box", leadListView.leadsListViewNotesBox1stItemInitialsBox);			
			commNav.checkIfWebElementPresent("Leads List View, Notes Box item, Regarding header", leadListView.leadsListViewNotesBox1stItemRegarding);			
			commNav.checkIfWebElementPresent("Leads List View, Notes Box item, Last Activity note", leadListView.leadsListViewNotesBox1stItemLastActivity);			
			commNav.checkIfWebElementPresent("Leads List View, Notes Box item, note item", leadListView.leadsListViewNotesBox1stItemNotes);			
			commNav.checkIfWebElementPresent("Leads List View, Notes Box item, see list link", leadListView.leadsListViewNotesBoxSeeListLink);
			
			//Step: check the Notes Box list item click navigation
			String expPgTitle = "Meeting";
			String resultsMsg = "VP: Clicking Notes Box item navigated to the expected page";
			try {
				//click the 1st Notes Box item
				leadListView.leadsListViewNotesBox1stItem.click();
				Thread.sleep(5000);
				commNav.isPageDisplayed(expPgTitle);
				AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id='history_detail']")).isDisplayed());
				headerButton.goBack();
				Thread.sleep(2000);
				System.out.println(resultsMsg + " - Passed");
				
			}
			catch (Exception e) {
				verificationErrors.append(methodID + "(): " + e.toString());
				System.out.println(resultsMsg + " - Failed");
			}
			
			leadListView = PageFactory.initElements(driver, LeadViewsElements.class);
			
			//Step: check the Notes Box 'see list' link click navigation
			expPgTitle = "Notes";
			resultsMsg = "VP: Clicking Notes Box 'see list' link navigated to the expected page";
			try {
				//click the Notes Box 'see list' link
				leadListView.leadsListViewNotesBoxSeeListLink.click();
				Thread.sleep(5000);
				commNav.isPageDisplayed(expPgTitle);
				AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id='history_related']")).isDisplayed());
				headerButton.goBack();
				Thread.sleep(2000);
				System.out.println(resultsMsg + " - Passed");
				
			}
			catch (Exception e) {
				verificationErrors.append(methodID + "(): " + e.toString());
				System.out.println(resultsMsg + " - Failed");
			}
		}
		else {
			System.out.println(methodID + ": required '" + expEntityPgTitle + "' not loaded; test aborted");
		}
		
		System.out.println(ENDLINE);
	}

	@Test(enabled = true)
	public void test09_SeTestTCLeadAddEditView() throws Exception {
		String methodID = "test09_SeTestTCLeadAddEditView";
		
		// Test Params:
		String entityType = "Lead";
		String viewName = "Lead Add Edit view";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: login & log back in (to clear cookies)  TODO added logout/in
        LogOutThenLogBackIn(userName, userPwd);
		
		try {
			//Step: enter the Contact Add Edit view...
			commNav.entityRecordAdd(entityType);
			
			LeadViewsElements leadEditView = PageFactory.initElements(driver, LeadViewsElements.class);
			
			//Step: check each input field and if applicable, its related list item selection view
			commNav.isWebElementPresent(viewName + ", 'Details' section header", leadEditView.leadsEditViewDetailsHdr);
			commNav.verifyEntityViewElementClick(viewName + ", name field", leadEditView.leadsEditViewNameFldBtn, "Edit Name");			
			commNav.isWebElementPresent(viewName + ", company field", leadEditView.leadsEditViewCompanyInputFld);			
			commNav.isWebElementPresent(viewName + ", web field", leadEditView.leadsEditViewWebInputFld);			
			commNav.isWebElementPresent(viewName + ", work phone field", leadEditView.leadsEditViewWorkPhoneInputFld);			
			commNav.isWebElementPresent(viewName + ", mobile phone field", leadEditView.leadsEditViewWorkPhoneInputFld);
			commNav.isWebElementPresent(viewName + ", toll free field", leadEditView.leadsEditViewTollFreeInputFld);
			commNav.isWebElementPresent(viewName + ", email field", leadEditView.leadsEditViewEmailInputFld);
			commNav.verifyEntityViewElementClick(viewName + ", title field", leadEditView.leadsEditViewTitleFldBtn, "Title");			
			commNav.verifyEntityViewElementClick(viewName + ", address field", leadEditView.leadsEditViewAddressFldBtn, "Address");
			commNav.verifyEntityViewElementClick(viewName + ", lead source field", leadEditView.leadsEditViewLeadSourceFldBtn, "Lead Sources");
			commNav.isWebElementPresent(viewName + ", interests field", leadEditView.leadsEditViewInterestsInputFld);
			commNav.verifyEntityViewElementClick(viewName + ", industry field", leadEditView.leadsEditViewIndustryFldBtn, "Industry");			
			commNav.isWebElementPresent(viewName + ", sic code field", leadEditView.leadsEditViewSicCodeInputFld);
			commNav.isWebElementPresent(viewName + ", business description text area", leadEditView.leadsEditViewBusDescInputFld);			
			commNav.verifyEntityViewElementClick(viewName + ", owner field", leadEditView.leadsEditViewOwnerFldBtn, "Owners");
			
			//end of test
			headerButton.clickHeaderButton("cancel");
		
			//Step: go back to previous screen
			headerButton.goBack();
			Thread.sleep(2000);
					
		}
		catch (Exception e) {
			verificationErrors.append(methodID + "(): " + e.toString());
			System.out.println(methodID + ": unable to open the Contact Add Edit view.");
		}
		
		System.out.println(ENDLINE);
	}
}
