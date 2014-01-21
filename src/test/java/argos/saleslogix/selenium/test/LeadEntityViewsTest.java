package argos.saleslogix.selenium.test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LeadEntityViewsTest extends BrowserSetup {
	
	//Test Set
	//========
	@Test(enabled = true)
	public void test01_SeTestTCLeadListView() throws Exception {
		//Reference: MBL-10050
		String methodID = "test01_SeTestTCLeadListView";
		
		// Test Params:
		String entityType = "Leads";
		String expEntityPgTitle = "Leads";
		String leadRecord = "Adams";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
	
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
			commNav.checkIfWebElementPresent("Leads List View, item record tab", LeadListView.topLeadsListItemTab);
			commNav.checkIfWebElementPresent("Leads List View, item record icon", LeadListView.topLeadsListItemIcon);
			commNav.checkIfWebElementPresent("Leads List View, item record name", LeadListView.topLeadsListItemName);
			commNav.checkIfWebElementPresent("Leads List View, item record company", LeadListView.topLeadsListItemLine2);
			commNav.checkIfWebElementPresent("Leads List View, item record work", LeadListView.topLeadsListItemLine3);
			commNav.checkIfWebElementPresent("Leads List View, item record web", LeadListView.topLeadsListItemLine4);
			commNav.checkIfWebElementPresent("Leads List View, item record email", LeadListView.topLeadsListItemLine5);
			
			//Step: check the Quick Action button and items
			try {
				//click Quick Action button to reveal Quick Action items
				commNav.checkIfWebElementPresent("Leads List View, Quick Action button", LeadListView.topLeadsListItemQuickActionsBtn);
				LeadListView.topLeadsListItemQuickActionsBtn.click();
				
				//click the Quick Action button, then check each of the Quick Action items
				commNav.checkIfWebElementPresent("Leads, Quick Action Add Attachment button", LeadListView.topLeadsListItemQuickActionsAddAttachmentBtn);
				commNav.checkIfWebElementPresent("Leads, Quick Action Add Activity button", LeadListView.topLeadsListItemQuickActionsAddActivityBtn);
				commNav.checkIfWebElementPresent("Leads, Quick Action Add Note button", LeadListView.topLeadsListItemQuickActionsAddNoteBtn);
				commNav.checkIfWebElementPresent("Leads, Quick Action Email button", LeadListView.topLeadsListItemQuickActionsEmailBtn);
				commNav.checkIfWebElementPresent("Leads, Quick Action Contacts button", LeadListView.topLeadsListItemQuickActionsCallMobileBtn);
				commNav.checkIfWebElementPresent("Leads, Quick Action Accounts button", LeadListView.topLeadsListItemQuickActionsCallWorkBtn);
				commNav.checkIfWebElementPresent("Leads, Quick Action Edit button", LeadListView.topLeadsListItemQuickActionsEditBtn);
				
				//click Quick Action button to hide the Quick Action items
				LeadListView.topLeadsListItemQuickActionsBtn.click();
			}
			catch (Exception e) {
				verificationErrors.append(e.toString());				
			}
			
			//Step: check the "X records remaining" item box at the bottom of the list view
			//commNav.checkIfWebElementPresent("Leads List View, 'x remaining records' item", LeadListView.recordsRemainingListItem);
		}
		else {
			System.out.println(methodID + ": required '" + expEntityPgTitle + "' not loaded; test aborted");
		}
		
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = true)
	public void test02_SeTestTCLeadListViewLoadMoreResults() throws Exception {
		String methodID = "test02_SeTestTCLeadListViewLoadMoreResults";
		
		//Test Params:
		String entityType = "Leads";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);

		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: click Top-Left button to reveal Global Menu...
		headerbutton.showGlobalMenu();
	
	    //Step: navigate to Leads list view...
		commNav.clickGlobalMenuItem(entityType);
	
	    //Step: load more results (click on 'x remaining records' item)
		for (int count = 0; count<=2; count++) {
			WebElement remainingRecordsItem = driver.findElement(By.xpath("//*[@id='lead_list']/div[4]"));
			commNav.highlightElement(remainingRecordsItem);
			remainingRecordsItem.click();
			Thread.sleep(3000);		
		}
		
		//Step: check if the 31th record item is present
		WebElement thirtyfirstRecordItem = driver.findElement(By.xpath("//*[@id='lead_list']/ul/li[31]"));
		commNav.checkIfWebElementPresent("31st Lead List View record available after load more records", thirtyfirstRecordItem);
		
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = true)
	public void test03_SeTestTCLeadListViewSearch() throws Exception {
		String methodID = "test03_SeTestTCLeadListViewSearch";
		
		// Test Params:
		String entityType = "Leads";
		String entityRecord = "Adams, Adelaide";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: search for an existing Lead record
		commNav.entityListViewSearch(entityType, entityRecord);		
		
		System.out.println(ENDLINE);
	}
	
	
	@Test(enabled = false)
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
		String entityRecord = "Adams, Adelaide";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

		commNav.entityListViewSearch(entityType, entityRecord);
			
		//Step: check for matching results...
		LeadViewsElements LeadListView = PageFactory.initElements(driver, LeadViewsElements.class);
		String topLeadListItemName = LeadListView.topLeadsListItemName.getText();
				
		//Step: click the clear Search input field button
		LeadListView.leadsSearchClearBtn.click();
				
		//Step: click the Lookup button to reload the full Leads list
		LeadListView.leadsSearchLookupBtn.click();
		Thread.sleep(3000);
				
		//Step: check if the previous search results were cleared
		String currTopLeadsListViewName = driver.findElement(By.xpath("//*[@id='Lead_list']/ul/li[1]/div/h3")).getText();
		try {
			AssertJUnit.assertEquals(topLeadListItemName, currTopLeadsListViewName);
		} catch (Error e) {
			verificationErrors.append(e.toString());
			System.out.println(methodID + ": clear previous Leads search results action failed");
			return;
		}
		
		System.out.println(methodID + ": clear previous Leads search results action was successful");
		System.out.println(ENDLINE);
	}

	
	@Test(enabled = true)
	public void test06_SeTestTCLeadListViewOpenRecord() throws Exception {
		String methodID = "test06_SeTestTCLeadListViewOpenRecord";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Leads";
		String entityRecord = "Adams, Adelaide";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		//Step: search for Lead entity, then open it's Detail view
		commNav.entityRecordOpenDetailView(entityType, entityRecord);
		
		//Step: go back to previous screen
		headerButton.goBack();
		Thread.sleep(3000);
		
		System.out.println(ENDLINE);
	}
	
	@Test(enabled = true)
	public void test07_SeTestTCLeadDetailView() throws Exception {
		String methodID = "test07_SeTestTCLeadDetailView";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		// Test Params:
		String entityType = "Leads";
		String entityRecord = "Adams, Adelaide";
		String viewName = "Lead Detail view";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
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
			commNav.isWebElementPresent(viewName + ",'name'", leadDetailView.leadsDetailViewNameFld);
			commNav.isWebElementPresent(viewName + ",'company'", leadDetailView.leadsDetailViewCompanyFld);
			commNav.isWebElementPresent(viewName + ",'web'", leadDetailView.leadsDetailViewWebFld);
			commNav.isWebElementPresent(viewName + ",'title'", leadDetailView.leadsDetailViewTitleFld);
			commNav.isWebElementPresent(viewName + ",'work phone'", leadDetailView.leadsDetailViewWorkPhoneFld);
			commNav.isWebElementPresent(viewName + ",'mobile phone'", leadDetailView.leadsDetailViewMobilePhoneFld);
			commNav.isWebElementPresent(viewName + ",'toll free'", leadDetailView.leadsDetailViewTollFreeFld);
			commNav.isWebElementPresent(viewName + ",'lead source'", leadDetailView.leadsDetailViewLeadSourceFld);

			//Step: check each item under the Lead Detail View, More Details section
			commNav.isWebElementPresent(viewName + ",'More Details' section header", leadDetailView.leadsDetailViewMoreDetailsHdr);
			//SubStep: conditionally expand the More Details section
			if (leadDetailView.leadsDetailViewMoreDetailsFields.getSize().height < 1) {
				leadDetailView.leadsDetailViewMoreDetailsHdr.click();
				Thread.sleep(1000);
			}
			commNav.isWebElementPresent(viewName + ",'interests'", leadDetailView.leadsDetailViewIndustryFld);
			commNav.isWebElementPresent(viewName + ",'industry'", leadDetailView.leadsDetailViewIndustryFld);
			commNav.isWebElementPresent(viewName + ",'sic code'", leadDetailView.leadsDetailViewSicCodeFld);
			commNav.isWebElementPresent(viewName + ",'bus desc'", leadDetailView.leadsDetailViewBusDescFld);
			commNav.isWebElementPresent(viewName + ",'comments'", leadDetailView.leadsDetailViewCommentsFld);
			commNav.isWebElementPresent(viewName + ",'owner'", leadDetailView.leadsDetailViewOwnerFld);

			//Step: check each item under the Lead Detail View, Related Items section
			commNav.isWebElementPresent(viewName + ",'Related Items' section header", leadDetailView.leadsDetailViewRelatedItemsHdr);
			commNav.verifyEntityViewElementClick(viewName + ",'Activities'", leadDetailView.leadsDetailViewActivitiesLnk, "Activities");
			commNav.verifyEntityViewElementClick(viewName + ",'Notes/History'", leadDetailView.leadsDetailViewNotesHistoryLnk, "Notes/History");
			commNav.verifyEntityViewElementClick(viewName + ",'Attachments'", leadDetailView.leadsDetailViewAttachmentsLnk, "Attachments");
			
			//Step: go back to previous screen
			headerButton.goBack();
			Thread.sleep(3000);
		}
		catch (Exception e) {
			verificationErrors.append(e.toString());
		}
		
		System.out.println(ENDLINE);
	}
	
	@Test(enabled = false)
	public void test08_SeTestTCAccountEditView() throws Exception {
		String methodID = "test08_SeTestTCAccountEditView";
		
		// Test Params:
		String entityType = "Account";
		String entityRecord = "Allied Corp.";
		String viewName = "Account Edit view";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: login & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
		
		try {
			//Step: search for Account entity, then open it's Edit view
			AssertJUnit.assertTrue(commNav.entityRecordEditView(entityType, entityRecord));
			
			LeadViewsElements leadEditView = PageFactory.initElements(driver, LeadViewsElements.class);
			
			/*
			//Step: check each input field and if applicable, its related list item selection view
			commNav.isWebElementPresent(viewName + ", 'Details' section header", accountEditView.accountEditViewDetailsHdr);
			commNav.isWebElementPresent(viewName + ", account field", accountEditView.accountEditViewAccountInputFld);
			commNav.isWebElementPresent(viewName + ", web field", accountEditView.accountEditViewWebInputFld);
			commNav.isWebElementPresent(viewName + ", phone field", accountEditView.accountEditViewPhoneInputFld);
			commNav.verifyEntityViewElementClick(viewName + ",'address field'", accountEditView.accountEditViewAddressFldBtn, "Address");
			commNav.isWebElementPresent(viewName + ", fax field", accountEditView.accountEditViewFaxInputFld);
			commNav.verifyEntityViewElementClick(viewName + ",'type field'", accountEditView.accountEditViewTypeFldBtn, "Account Type");
			commNav.verifyEntityViewElementClick(viewName + ",'subtype field'", accountEditView.accountEditViewSubTypeFldBtn, "Account Subtype");
			commNav.verifyEntityViewElementClick(viewName + ",'status field'", accountEditView.accountEditViewStatusFldBtn, "Account Status");
			commNav.verifyEntityViewElementClick(viewName + ",'industry field'", accountEditView.accountEditViewIndustryFldBtn, "Industry");
			commNav.isWebElementPresent(viewName + ", business description text area", accountEditView.accountEditViewBusDescFld);
			commNav.verifyEntityViewElementClick(viewName + ",'account manager field'", accountEditView.accountEditViewAcctMgrFldBtn, "Users");
			commNav.verifyEntityViewElementClick(viewName + ",'owner field'", accountEditView.accountEditViewOwnerFldBtn, "Owners");
			commNav.verifyEntityViewElementClick(viewName + ",'lead source field'", accountEditView.accountEditViewLeadSourceFldBtn, "Lead Sources");
			*/
			
			//end of test
			headerButton.clickHeaderButton("cancel");
		
			//Step: go back to previous screen
			headerButton.goBack();
			Thread.sleep(2000);
		} catch (Error e) {
			verificationErrors.append(e.toString());
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
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertEquals("Attachments", driver.findElement(By.xpath("//div[@id='Lead_detail']/div[2]/ul[2]/li[7]/a/span")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
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
	      verificationErrors.append(e.toString());
	    }
	    
	    // Step: search for a specific attachment item
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_36']/div/div[1]/input")).clear();
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_36']/div/div[1]/input")).sendKeys("Test123");
	    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_36']/div/div[3]/button")).click();
	    Thread.sleep(5000);
	    try {
		      assertTrue(isElementPresent(By.linkText("Test123")));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
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
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.cssSelector("button.button.inline")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.xpath("//div[@id='attachment_Add']/div[2]/div/button[2]")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
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

	
	@Test(enabled = true)
	public void test13_SeTestTCLeadListViewNotesBox() throws Exception {
		//Reference: MBL-10042
		String methodID = "test13_SeTestTCLeadListViewNotesBox";

		// Test Params:
		String entityType = "Leads";
		String expEntityPgTitle = "Leads";
		String entityRecord = "Adams, Adelaide";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
	
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
				verificationErrors.append(e.toString());
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
				verificationErrors.append(e.toString());
				System.out.println(resultsMsg + " - Failed");
			}
		}
		else {
			System.out.println(methodID + ": required '" + expEntityPgTitle + "' not loaded; test aborted");
		}
		
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
