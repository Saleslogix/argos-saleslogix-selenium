package argos.saleslogix.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * Test class that defines test methods for the SLX Mobile Defect (v3.3.0) fixes.
 * 
 * @author kathleen.lockyer-bratton@infor.com
 * @version	1.0
 */
public class MobileSprint330B extends BaseTest {

    public String TEST_OPPORTUNITY_RECORD = "Vegas Vision-Phase1";
    public String TEST_OPPORTUNITY_RECORD2 = "Advising Group-Phase1";
    public String TEST_CONTACT_RECORD = "Abbott, John";
    public String TEST_ACCOUNT_RECORD = "Abbott Ltd.";

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
    // MBL-10613 ... My Activities : phone - on adding a second activity, phone displays value for the first activity's account, while account is blank

    public void test01_MBL10613() throws Exception {
        String methodID = "test01_MBL10613";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);



        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        try {


            //Step: logout & log back in (to clear cookies)
            LogOutThenLogBackIn(userName, userPwd);


            //Step: go to "My Activities" view, if not already there ... wait for page My Activities
            if (!commNav.isPageDisplayed("My Activities"))   {
                commNav.clickGlobalMenuItem("My Activities");
                commNav.waitForPage("My Activities");
            }


            //Step: click the Add header button to open Activity schedule view
            headerButton.clickHeaderButton("Add");

            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");

            //Step: select Meeting for activity type
            activityEditView.activityScheduleMeetingBtn.click();

            //Step: wait for page Meeting to open
            commNav.waitForPage("Meeting");

            //Step: add an Activity record with a random value for 'regarding'
            String newActivityRegarding = "SeAutoTestActivity-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("Activity regarding field will be - " + newActivityRegarding);

            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);


            //Step: set the account to one that has a phone number
            activityEditView.activityEditViewAccountBtn.click();
            commNav.waitForPage("Accounts");

            commView.lookupTxtBox.sendKeys(TEST_ACCOUNT_RECORD);
            Thread.sleep(500);
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
            Thread.sleep(1000);
            accountListView.relatedAccountsListViewTopItem.click();
            Thread.sleep(500);
            commNav.waitForPage("Meeting");

            //Step: retrieve the value for phone for the account record chosen
            String firstActivityPhoneNo = activityEditView.activityEditViewPhoneFld.getAttribute("value");
            System.out.println("VP: phone number for first activity ... from account chosen, is ... " + firstActivityPhoneNo);


            //Step: save activity
            headerButton.clickHeaderButton("Save");

            //Step: wait for page My Activities
            commNav.waitForPage("My Activities");
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);

            //Step: create a second activity with no account
            headerButton.clickHeaderButton("Add");

            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");

            //Step: select Meeting for activity type
            activityEditView.activityScheduleMeetingBtn.click();

            //Step: wait for page Meeting to open
            commNav.waitForPage("Meeting");

            //Step: with no account chosen for activity, verify that phone number is not set to the first activity's phone number - should be blank
            String secondActivityPhoneNo = activityEditView.activityEditViewPhoneFld.getAttribute("value");
            System.out.println("VP: phone number for second activity ... with no account chosen, is ... " + secondActivityPhoneNo);

            AssertJUnit.assertEquals("VP: second activity phone number is not displaying as blank - FAILED", "", secondActivityPhoneNo);
            System.out.println("VP: second activity phone number is displaying as blank - PASSED");

        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: second activity phone number is displaying as blank " + " - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // MBL-10930 ... Cancelled edits still unexpectedly displaying

    public void test02_MBL10930() throws Exception {

        String methodID = "test02_MBL10930";

        // Test Params:
        String entityType = "Accounts";
        String entityRecord = TEST_ACCOUNT_RECORD;

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        try {

            //Step: click Top-Left button to reveal Global Menu...
            headerbutton.showGlobalMenu();

            //Step: navigate to Accounts list view, and serach for an account
            commNav.entityListViewSearch(entityType, entityRecord);

            //Step: display quick actions for the account
            AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);
            accountListView.topAccountsListItemIcon.click();

            //Step: press the 'edit' quick action button
            accountListView.topAccountsListItemQuickActionsEditBtn.click();
            commNav.waitForPage("Account");

            //Step: save the initial value of the phone
            String initialPhoneValue = accountListView.accountEditViewPhoneInputFld.getAttribute("value");
            System.out.println("VP: initial value of phone is ... " + initialPhoneValue);

            //Step: type in an 'x' at the end of the phone value, and save the edited phone value
            accountListView.accountEditViewPhoneInputFld.sendKeys("x");
            String editedPhoneValue = accountListView.accountEditViewPhoneInputFld.getAttribute("value");
            System.out.println("VP: edited value of phone is ... " + editedPhoneValue);

            //Step: cancel out of the edit view, without saving any changes
            headerbutton.clickHeaderButton("Cancel");
            commNav.waitForPage("Accounts");

            //Step: again, display quick actions for the account, and press the 'edit' button
            accountListView = PageFactory.initElements(driver, AccountViewsElements.class);
            accountListView.topAccountsListItemIcon.click();
            accountListView.topAccountsListItemQuickActionsEditBtn.click();
            commNav.waitForPage("Account");

            //Step: retrieve the current value of phone ... should be equal to the initial value of the phone, before the edit
            String currentPhoneValue = accountListView.accountEditViewPhoneInputFld.getAttribute("value");
            System.out.println("VP: value of phone after cancelled edit is ... " + currentPhoneValue);

            //Step: verify that current phone value is equal to the initial value of the phone
            AssertJUnit.assertEquals("VP: after cancelled edit current value of phone equals initial value of phone - FAILED", initialPhoneValue, currentPhoneValue);
            System.out.println("VP: after cancelled edit current value of phone equals initial value of phone - PASSED");

        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: cancelled edits still unexpectedly displaying " + " - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    public void test03_MBL10928() throws Exception {
        //MBL-10928 ... Opportunity 'Quick Edit' quick action and 'Edit' screen
        //MBL-10935 ... Opportunity Quick Edit - disable 'close prob' editing for closed opportunities
        //MBL-10931 ... non-group : Opportunity Quick Edit - multiple changes to one opportunity, and changes to multiple opportunities on 'Edit' screen should save as expected
        String methodID = "test03_MBL10928";

        // Test Params:
        String entityType = "Opportunities";
        String expEntityPgTitle = "Opportunities";
        String oppRecord = TEST_OPPORTUNITY_RECORD;

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
        HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
        OpportunityViewsElements opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
        CalendarViewsElements calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        try {

            //Step: login & log back in (to clear cookies)
            LogOutThenLogBackIn(userName, userPwd);

            //Step: navigate to Opportunity list view ... search for specified opportunity
            commNav.entityListViewSearch(entityType, oppRecord);


            //Step: save listview card layout information
            String opportunityCardLayout = opportunitiesListView.topOpportunityCardLayout.getText();
            System.out.println("VP: opportunityCardLayout is ... " + opportunityCardLayout);

            //Step: click button to display the Quick Actions
            opportunitiesListView.topOpportunityListItemIcon.click();

            //Step: verify existence of the Quick Edit quick action, then click it to open the 'Edit' screen
            commNav.checkIfWebElementPresent("Opportunity, Quick Action Quick Edit button", opportunitiesListView.topOpportunityListItemQuickActionsQuickEditBtn);
            opportunitiesListView.topOpportunityListItemQuickActionsQuickEditBtn.click();
            commNav.waitForPage("Edit");

            //Step: save quick edit card layout information
            String quickEditCardLayout = opportunitiesListView.opportunityQuickEditCardLayout.getText();
            System.out.println("VP: quickEditCardLayout is ... " + quickEditCardLayout);

            //Step: compare card layouts from Opportunity listview and Quick Edit 'Edit' view
            AssertJUnit.assertEquals("VP: Opportunity card layout matches Quick Edit card layout - FAILED", opportunityCardLayout, quickEditCardLayout);
            System.out.println("VP: Opportunity card layout matches Quick Edit card layout - PASSED");

            //Step: verify that all 4 expected fields are present on the 'Edit' screen
            commNav.checkIfWebElementPresent("Opportunity, Quick Edit 'stage'", opportunitiesListView.opportunityQuickEditStageText);
            commNav.checkIfWebElementPresent("Opportunity, Quick Edit 'close prob'", opportunitiesListView.opportunityQuickEditCloseProbText);
            commNav.checkIfWebElementPresent("Opportunity, Quick Edit 'sales potential'", opportunitiesListView.opportunityQuickEditSalesPotentialText);
            commNav.checkIfWebElementPresent("Opportunity, Quick Edit 'est close'", opportunitiesListView.opportunityQuickEditEstCloseText);

            //Step: edit the 'close prob' field, and set to '10' ... should be editable as opportunity is 'open'
            opportunitiesListView.opportunityQuickEditCloseProbBtn.click();
            commNav.waitForPage("Opportunity Probability");
            opportunitiesListView.opportunityProbability10.click();
            commNav.waitForPage("Edit");
            opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
            String initEditCloseProb = opportunitiesListView.opportunityQuickEditCloseProbText.getAttribute("value");
            System.out.println("VP: 1st edit of opportunity " + TEST_OPPORTUNITY_RECORD + " ... 'close prob' set to : " + initEditCloseProb);

            //Step: edit the 'sales potential', and set to '5500.00' ... should be editable
            opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
            opportunitiesListView.opportunityQuickEditSalesPotentialText.clear();
            opportunitiesListView.opportunityQuickEditSalesPotentialText.sendKeys("5500.00");
            String initEditSalesPotential = opportunitiesListView.opportunityQuickEditSalesPotentialText.getAttribute("value");
            System.out.println("VP: 1st edit of opportunity " + TEST_OPPORTUNITY_RECORD + " ... 'sales potential' set to : " + initEditSalesPotential);

            //Step: edit the 'est close' ... should be editable
            opportunitiesListView.opportunityQuickEditEstCloseBtn.click();
            commNav.waitForPage("Calendar");
            calendarView.calendarIncrementYearBtn.click();
            headerbutton.clickHeaderButton("check");
            commNav.waitForPage("Edit");
            opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
            String initEditEstClose = opportunitiesListView.opportunityQuickEditEstCloseText.getAttribute("value");
            System.out.println("VP: 1st edit of opportunity " + TEST_OPPORTUNITY_RECORD + " ... 'est close' set to : " + initEditEstClose);

            //Step: save the opportunity edits
            headerbutton.clickHeaderButton("save");
            commNav.waitForPage("Opportunities");

            //Step: again, display quick actions for the opportunity, press 'Quick Edit' and wait for 'Edit' screen to open
            opportunitiesListView.topOpportunityListItemIcon.click();
            opportunitiesListView.topOpportunityListItemQuickActionsQuickEditBtn.click();
            commNav.waitForPage("Edit");

            //Step: verify the expected values for 'close prob', 'sales potential' and 'est close'
            opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
            AssertJUnit.assertEquals("VP: On re-opening Opportunity " + TEST_OPPORTUNITY_RECORD + " after 1st edit via Quick Edit, 'close prob' does not have expected value of : " + initEditCloseProb + " - FAILED", initEditCloseProb, opportunitiesListView.opportunityQuickEditCloseProbText.getAttribute("value"));
            System.out.println("VP: On re-opening Opportunity " + TEST_OPPORTUNITY_RECORD + " after 1st edit via Quick Edit, 'close prob' does have expected value of : " + initEditCloseProb + " - PASSED");
            AssertJUnit.assertEquals("VP: On re-opening Opportunity " + TEST_OPPORTUNITY_RECORD + " after 1st edit via Quick Edit, 'sales potential' does not have expected value of : " + initEditSalesPotential + " - FAILED", initEditSalesPotential, opportunitiesListView.opportunityQuickEditSalesPotentialText.getAttribute("value"));
            System.out.println("VP: On re-opening Opportunity " + TEST_OPPORTUNITY_RECORD + " after 1st edit via Quick Edit, 'sales potential' does have expected value of : " + initEditSalesPotential + " - PASSED");
            AssertJUnit.assertEquals("VP: On re-opening Opportunity " + TEST_OPPORTUNITY_RECORD + " after 1st edit via Quick Edit, 'est close' does not have expected value of : " + initEditEstClose + " - FAILED", initEditEstClose, opportunitiesListView.opportunityQuickEditEstCloseText.getAttribute("value"));
            System.out.println("VP: On re-opening Opportunity " + TEST_OPPORTUNITY_RECORD + " after 1st edit via Quick Edit, 'est close' does have expected value of : " + initEditEstClose + " - PASSED");


            //Step: edit the 'sales potential' for the same opportunity a second time, and set to '6702.00' ... should be editable
            opportunitiesListView.opportunityQuickEditSalesPotentialText.clear();
            opportunitiesListView.opportunityQuickEditSalesPotentialText.sendKeys("6702.00");
            String secondEditSalesPotential = opportunitiesListView.opportunityQuickEditSalesPotentialText.getAttribute("value");
            System.out.println("VP: 2nd edit of opportunity " + TEST_OPPORTUNITY_RECORD + " ... 'sales potential' set to : " + secondEditSalesPotential);

            //Step: save the opportunity edits
            headerbutton.clickHeaderButton("save");
            commNav.waitForPage("Opportunities");

            //Step: again, display quick actions for the opportunity, press 'Quick Edit' and wait for 'Edit' screen to open
            opportunitiesListView.topOpportunityListItemIcon.click();
            opportunitiesListView.topOpportunityListItemQuickActionsQuickEditBtn.click();
            commNav.waitForPage("Edit");

            //Step: verify the expected values for 'sales potential' after the second edit
            opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
            AssertJUnit.assertEquals("VP: On re-opening Opportunity " + TEST_OPPORTUNITY_RECORD + " after 2nd edit via Quick Edit, 'sales potential' does not have expected value of : " + secondEditSalesPotential + " - FAILED", secondEditSalesPotential, opportunitiesListView.opportunityQuickEditSalesPotentialText.getAttribute("value"));
            System.out.println("VP: On re-opening Opportunity " + TEST_OPPORTUNITY_RECORD + " after 2nd edit via Quick Edit, 'sales potential' does have expected value of : " + secondEditSalesPotential + " - PASSED");


            //Step: cancel out of the 'Edit' screen, and search for a different opportunity to edit (closed-won opportunity)
            headerbutton.clickHeaderButton("cancel");
            commNav.waitForPage("Opportunities");
            commView.lookupTxtBox.click();
            Thread.sleep(500);
            commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
            Thread.sleep(500);
            commView.lookupTxtBox.sendKeys(TEST_OPPORTUNITY_RECORD2);
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
            Thread.sleep(500);

            //Step: display quick actions for this second opportunity, press 'Quick Edit' and wait for 'Edit' screen to open
            opportunitiesListView.topOpportunityListItemIcon.click();
            opportunitiesListView.topOpportunityListItemQuickActionsQuickEditBtn.click();
            commNav.waitForPage("Edit");

            //Step: verify that the 'close prob' field may not be edited  [MBL-10935]
            opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
            opportunitiesListView.opportunityQuickEditCloseProbBtn.click();
            Thread.sleep(500);
            AssertJUnit.assertEquals("VP: 'close prob' disabled for a Closed opportunity " + TEST_OPPORTUNITY_RECORD2 + " - FAILED", "Edit", driver.findElement(By.id("pageTitle")).getText());
            System.out.println("VP: 'close prob' disabled for a Closed opportunity " + TEST_OPPORTUNITY_RECORD2 + " - PASSED");


            //Step: edit the 'sales potential' for this second opportunity, and set to '654321.00' ... should be editable
            opportunitiesListView.opportunityQuickEditSalesPotentialText.clear();
            opportunitiesListView.opportunityQuickEditSalesPotentialText.sendKeys("654321.00");
            String thirdEditSalesPotential = opportunitiesListView.opportunityQuickEditSalesPotentialText.getAttribute("value");
            System.out.println("VP: 3rd edit of a different opportunity " + TEST_OPPORTUNITY_RECORD2 + " ... 'sales potential' set to : " + thirdEditSalesPotential);


            //Step: save the opportunity edit
            headerbutton.clickHeaderButton("save");
            commNav.waitForPage("Opportunities");

            //Step: again, display quick actions for the opportunity, press 'Quick Edit' and wait for 'Edit' screen to open
            opportunitiesListView.topOpportunityListItemIcon.click();
            opportunitiesListView.topOpportunityListItemQuickActionsQuickEditBtn.click();
            commNav.waitForPage("Edit");

            //Step: verify the expected values for 'sales potential' after the third edit for a different opportunity
            opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
            AssertJUnit.assertEquals("VP: On re-opening different Opportunity " + TEST_OPPORTUNITY_RECORD2 + " after 3rd edit via Quick Edit, 'sales potential' does not have expected value of : " + thirdEditSalesPotential + " - FAILED", thirdEditSalesPotential, opportunitiesListView.opportunityQuickEditSalesPotentialText.getAttribute("value"));
            System.out.println("VP: On re-opening different Opportunity " + TEST_OPPORTUNITY_RECORD2 + " after 3rd edit via Quick Edit, 'sales potential' does have expected value of : " + thirdEditSalesPotential + " - PASSED");


        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Opportunity Quick Edit functioning as expected " + " - FAILED");
            AssertJUnit.fail("test failed");
        }


        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    public void test04_MBL10931() throws Exception {
        //MBL-10931 ... groups : verify that summary and detail listview layouts are reflected on the Quick Edit screen
        //                     : verify that group layout for a different group is reflected on the Quick Edit screen
        String methodID = "test04_MBL10931";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
        OpportunityViewsElements opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);


        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        try {

            //Step: login & log back in (to clear cookies)
            LogOutThenLogBackIn(userName, userPwd);

            //Step: navigate to Opportunity list view
            commNav.clickGlobalMenuItem("Opportunities");
            commNav.waitForPage("All Opportunities");

            //Step: reveal Right Context Menu panel, and choose 'Summary' layout
            headerbutton.showRightContextMenu();
            commNav.rmenu_GroupSummary.click();
            System.out.println("VP: Summary layout chosen for 'All Opportunities' group");
            commNav.waitForPage("All Opportunities");
            Thread.sleep(3000);


            //Step: save group listview card layout information
            String opportunityGroupLayout = opportunitiesListView.topOpportunityCardLayout.getText();
            System.out.println("VP: Summary opportunityGroupLayout is ... " + opportunityGroupLayout);

            //Step: click button to display the Quick Actions
            opportunitiesListView.topOpportunityListItemIcon.click();

            //Step: verify existence of the Quick Edit quick action, then click it to open the 'Edit' screen
            commNav.checkIfWebElementPresent("Opportunity, Quick Action Quick Edit button", opportunitiesListView.topOpportunityListItemQuickActionsQuickEditBtn);
            opportunitiesListView.topOpportunityListItemQuickActionsQuickEditBtn.click();
            commNav.waitForPage("Edit");

            //Step: save quick edit card layout information
            String quickEditCardLayout = opportunitiesListView.opportunityQuickEditCardLayout.getText();
            System.out.println("VP: quickEditCardLayout is ... " + quickEditCardLayout);

            //Step: compare card layouts from Opportunity group Summary listview and Quick Edit 'Edit' view
            AssertJUnit.assertEquals("VP: Summary Opportunity group layout matches Quick Edit card layout - FAILED", opportunityGroupLayout, quickEditCardLayout);
            System.out.println("VP: Summary Opportunity group layout matches Quick Edit card layout - PASSED");


            //Step: cancel out of the 'Edit' screen
            headerbutton.clickHeaderButton("cancel");
            commNav.waitForPage("All Opportunities");

            //Step: reveal Right Context Menu panel, and choose 'Detail' layout
            headerbutton.showRightContextMenu();
            commNav.rmenu_GroupDetail.click();
            System.out.println("VP: Detail layout chosen for 'All Opportunities' group");
            commNav.waitForPage("All Opportunities");
            Thread.sleep(3000);


            //Step: save group listview card layout information
            opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
            opportunityGroupLayout = opportunitiesListView.topOpportunityCardLayout.getText();
            System.out.println("VP: Detail opportunityGroupLayout is ... " + opportunityGroupLayout);

            //Step: click button to display the Quick Actions
            opportunitiesListView.topOpportunityListItemIcon.click();

            //Step: click the Quick Edit quick action to open the 'Edit' screen
            opportunitiesListView.topOpportunityListItemQuickActionsQuickEditBtn.click();
            commNav.waitForPage("Edit");

            //Step: save quick edit card layout information
            quickEditCardLayout = opportunitiesListView.opportunityQuickEditCardLayout.getText();
            System.out.println("VP: quickEditCardLayout is ... " + quickEditCardLayout);

            //Step: compare card layouts from Opportunity group Detail listview and Quick Edit 'Edit' view
            AssertJUnit.assertEquals("VP: Detail Opportunity group layout matches Quick Edit card layout - FAILED", opportunityGroupLayout, quickEditCardLayout);
            System.out.println("VP: Detail Opportunity group layout matches Quick Edit card layout - PASSED");


            //Step: cancel out of the 'Edit' screen
            headerbutton.clickHeaderButton("cancel");
            commNav.waitForPage("All Opportunities");

            //Step: reveal Right Context Menu panel
            headerbutton.showRightContextMenu();

            //Step: click on Configure button to open 'Groups Lookup' and select 'Closed - Won' for loup
            commNav.rmenu_GroupConfigure.click();
            commNav.waitForPage("Groups Lookup");
            opportunitiesListView.groupsConfigureClosedWon.click();
            headerbutton.checkButton.click();
            commNav.waitForPage("All Opportunities");


            //Step: open right menu and select 'Closed - Won' group to display
            headerbutton.showRightContextMenu();
            opportunitiesListView.rmenu_groupClosedWon.click();
            commNav.waitForPage("Closed - Won");

            //Step: verify that group 'Closed - Won' is displayed
            commNav = PageFactory.initElements(driver, CommonNavigation.class);
            AssertJUnit.assertEquals("VP: user is not seeing the chosen group (Closed - Won) just selected  - FAILED","Closed - Won", driver.findElement(By.id("pageTitle")).getText());
            System.out.println("VP: user is seeing the chosen group (Closed - Won) just selected  - PASSED");

            //Step: save group listview card layout information ... for 'Closed - Won' group
            headerbutton.closeRightContextMenu();
            opportunitiesListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
            opportunityGroupLayout = opportunitiesListView.topOpportunityCardLayout.getText();
            System.out.println("VP: 'Closed - Won' opportunityGroupLayout is ... " + opportunityGroupLayout);

            //Step: click button to display the Quick Actions
            opportunitiesListView.topOpportunityListItemIcon.click();

            //Step: click the Quick Edit quick action to open the 'Edit' screen
            opportunitiesListView.topOpportunityListItemQuickActionsQuickEditBtn.click();
            commNav.waitForPage("Edit");

            //Step: save quick edit card layout information
            quickEditCardLayout = opportunitiesListView.opportunityQuickEditCardLayout.getText();
            System.out.println("VP: quickEditCardLayout is ... " + quickEditCardLayout);

            //Step: compare card layouts from 'Closed - Won' Opportunity group Detail listview and Quick Edit 'Edit' view
            AssertJUnit.assertEquals("VP: 'Closed - Won' Opportunity group layout matches Quick Edit card layout - FAILED", opportunityGroupLayout, quickEditCardLayout);
            System.out.println("VP: 'Closed - Won' Opportunity group layout matches Quick Edit card layout - PASSED");

        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Opportunity Quick Edit layout as expected for detail/ summary/ different groups " + " - FAILED");
            AssertJUnit.fail("test failed");
        }


        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    public void test05_MBL10925() throws Exception {
        //MBL-10925 ... personalize quick actions
        String methodID = "test05_MBL10925";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
        AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);


        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        try {

            //Step: logout & log back in (to clear cookies)
            LogOutThenLogBackIn(userName, userPwd);

            //Step: navigate to Account list view
            commNav.clickGlobalMenuItem("Accounts");
            commNav.waitForPage("All Accounts");

            //Step: click button to display the Quick Actions
            accountListView.topAccountsListItemIcon.click();

            //Step: verify OOTB quick actions ... order and display
            String quickActionText0 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=0]/label")).getText();
            String quickActionText1 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=1]/label")).getText();
            String quickActionText2 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=2]/label")).getText();
            String quickActionText3 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=3]/label")).getText();
            String quickActionText4 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=4]/label")).getText();
            String quickActionText5 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=5]/label")).getText();
            String quickActionText6 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=6]/label")).getText();

            AssertJUnit.assertEquals("VP: 1st Account quick action is 'Configure' - FAILED", "Configure", quickActionText0);
            System.out.println("VP: 1st Account quick action is 'Configure' - PASSED");
            AssertJUnit.assertEquals("VP: 2nd Account quick action is 'Edit' - FAILED", "Edit", quickActionText1);
            System.out.println("VP: 2nd Account quick action is 'Edit' - PASSED");
            AssertJUnit.assertEquals("VP: 3rd Account quick action is 'Call Main' - FAILED", "Call Main", quickActionText2);
            System.out.println("VP: 3rd Account quick action is 'Call Main' - PASSED");
            AssertJUnit.assertEquals("VP: 4th Account quick action is 'Contacts' - FAILED", "Contacts", quickActionText3);
            System.out.println("VP: 4th Account quick action is 'Contacts' - PASSED");
            AssertJUnit.assertEquals("VP: 5th Account quick action is 'Add Note' - FAILED", "Add Note", quickActionText4);
            System.out.println("VP: 5th Account quick action is 'Add Note' - PASSED");
            AssertJUnit.assertEquals("VP: 6th Account quick action is 'Add Activity' - FAILED", "Add Activity", quickActionText5);
            System.out.println("VP: 6th Account quick action is 'Add Activity' - PASSED");
            AssertJUnit.assertEquals("VP: 7th Account quick action is 'Add Attachment' - FAILED", "Add Attachment", quickActionText6);
            System.out.println("VP: 7th Account quick action is 'Add Attachment' - PASSED");

            //Step: press Configure quick action to open 'Configure Quick Actions' screen
            //      click on 'Call Main' to hide this quick action, and move up 'Add Attachment' quick action one position, above 'Add Activity'
            accountListView.topAccountsListItemQuickActionsConfiguretBtn.click();
            commNav.waitForPage("Configure Quick Actions");
            accountListView.accountConfigureQACallMain.click();
            accountListView.accountConfigureQAAddAttachUp.click();
            headerbutton.clickHeaderButton("save");
            commNav.waitForPage("All Accounts");

            //Step: click button to display the amended Quick Actions
            accountListView = PageFactory.initElements(driver, AccountViewsElements.class);
            accountListView.topAccountsListItemIcon.click();

            //Step: verify that the quick action order and visibility has changed appropriately in group view
            quickActionText0 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=0]/label")).getText();
            quickActionText1 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=1]/label")).getText();
            quickActionText2 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=2]/label")).getText();
            quickActionText3 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=3]/label")).getText();
            quickActionText4 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=4]/label")).getText();
            quickActionText5 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=5]/label")).getText();

            AssertJUnit.assertEquals("VP: after personalization 1st Account quick action in group view is 'Configure' - FAILED", "Configure", quickActionText0);
            System.out.println("VP: after personalization 1st Account quick action in group view is 'Configure' - PASSED");
            AssertJUnit.assertEquals("VP: after personalization 2nd Account quick action in group view is 'Edit' - FAILED", "Edit", quickActionText1);
            System.out.println("VP: after personalization 2nd Account quick action in group view is 'Edit' - PASSED");
            AssertJUnit.assertEquals("VP: after personalization 3rd Account quick action in group view is 'Contacts' - FAILED", "Contacts", quickActionText2);
            System.out.println("VP: after personalization 3rd Account quick action in group view is 'Contacts' - PASSED");
            AssertJUnit.assertEquals("VP: after personalization 4th Account quick action in group view is 'Add Note' - FAILED", "Add Note", quickActionText3);
            System.out.println("VP: after personalization 4th Account quick action in group view is 'Add Note' - PASSED");
            AssertJUnit.assertEquals("VP: after personalization 5th Account quick action in group view is 'Add Attachment' - FAILED", "Add Attachment", quickActionText4);
            System.out.println("VP: after personalization 5th Account quick action in group view is 'Add Attachment' - PASSED");
            AssertJUnit.assertEquals("VP: after personalization 6th Account quick action in group view is 'Add Activity' - FAILED", "Add Activity", quickActionText5);
            System.out.println("VP: after personalization 6th Account quick action in group view is 'Add Activity' - PASSED");


            //Step: Clear search button and search on all records ... to display the 'card layout' view
            commView.lookupTxtBox.click();
            Thread.sleep(500);
            commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
            Thread.sleep(3000);
            commNav.waitForPage("Accounts");

            //Step: click button to display the amended Quick Actions
            accountListView = PageFactory.initElements(driver, AccountViewsElements.class);
            accountListView.topAccountsListItemIcon.click();

            //Step: verify that the quick action order and visibility in card layout reflects the personalization appropriately
            quickActionText0 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=0]/label")).getText();
            quickActionText1 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=1]/label")).getText();
            quickActionText2 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=2]/label")).getText();
            quickActionText3 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=3]/label")).getText();
            quickActionText4 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=4]/label")).getText();
            quickActionText5 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=5]/label")).getText();

            AssertJUnit.assertEquals("VP: after personalization 1st Account quick action in card layout view is 'Configure' - FAILED", "Configure", quickActionText0);
            System.out.println("VP: after personalization 1st Account quick action in card layout view is 'Configure' - PASSED");
            AssertJUnit.assertEquals("VP: after personalization 2nd Account quick action in card layout view is 'Edit' - FAILED", "Edit", quickActionText1);
            System.out.println("VP: after personalization 2nd Account quick action in card layout view is 'Edit' - PASSED");
            AssertJUnit.assertEquals("VP: after personalization 3rd Account quick action in card layout view is 'Contacts' - FAILED", "Contacts", quickActionText2);
            System.out.println("VP: after personalization 3rd Account quick action in card layout view is 'Contacts' - PASSED");
            AssertJUnit.assertEquals("VP: after personalization 4th Account quick action in card layout view is 'Add Note' - FAILED", "Add Note", quickActionText3);
            System.out.println("VP: after personalization 4th Account quick action in card layout view is 'Add Note' - PASSED");
            AssertJUnit.assertEquals("VP: after personalization 5th Account quick action in card layout view is 'Add Attachment' - FAILED", "Add Attachment", quickActionText4);
            System.out.println("VP: after personalization 5th Account quick action in card layout view is 'Add Attachment' - PASSED");
            AssertJUnit.assertEquals("VP: after personalization 6th Account quick action in card layout view is 'Add Activity' - FAILED", "Add Activity", quickActionText5);
            System.out.println("VP: after personalization 6th Account quick action in card layout view is 'Add Activity' - PASSED");

            //Step: logout & log back in (to clear cookies) ... then recheck that Account quick actions personalization is still in effect
            LogOutThenLogBackIn(userName, userPwd);

            commNav = PageFactory.initElements(driver, CommonNavigation.class);

            //Step: navigate to Account list view
            commNav.clickGlobalMenuItem("Accounts");
            commNav.waitForPage("All Accounts");

            //Step: click button to display the amended Quick Actions
            accountListView = PageFactory.initElements(driver, AccountViewsElements.class);
            accountListView.topAccountsListItemIcon.click();

            //Step: verify that the quick action order and visibility is still reflecting the personalization appropriately after logoff/ on
            quickActionText0 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=0]/label")).getText();
            quickActionText1 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=1]/label")).getText();
            quickActionText2 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=2]/label")).getText();
            quickActionText3 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=3]/label")).getText();
            quickActionText4 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=4]/label")).getText();
            quickActionText5 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=5]/label")).getText();

            AssertJUnit.assertEquals("VP: after personalization and logoff/on 1st Account quick action in group view is 'Configure' - FAILED", "Configure", quickActionText0);
            System.out.println("VP: after personalization and logoff/on 1st Account quick action in group view is 'Configure' - PASSED");
            AssertJUnit.assertEquals("VP: after personalization and logoff/on 2nd Account quick action in group view is 'Edit' - FAILED", "Edit", quickActionText1);
            System.out.println("VP: after personalization and logoff/on 2nd Account quick action in group view is 'Edit' - PASSED");
            AssertJUnit.assertEquals("VP: after personalization and logoff/on 3rd Account quick action in group view is 'Contacts' - FAILED", "Contacts", quickActionText2);
            System.out.println("VP: after personalization and logoff/on 3rd Account quick action in group view is 'Contacts' - PASSED");
            AssertJUnit.assertEquals("VP: after personalization and logoff/on 4th Account quick action in group view is 'Add Note' - FAILED", "Add Note", quickActionText3);
            System.out.println("VP: after personalization and logoff/on 4th Account quick action in group view is 'Add Note' - PASSED");
            AssertJUnit.assertEquals("VP: after personalization and logoff/on 5th Account quick action in group view is 'Add Attachment' - FAILED", "Add Attachment", quickActionText4);
            System.out.println("VP: after personalization and logoff/on 5th Account quick action in group view is 'Add Attachment' - PASSED");
            AssertJUnit.assertEquals("VP: after personalization and logoff/on 6th Account quick action in group view is 'Add Activity' - FAILED", "Add Activity", quickActionText5);
            System.out.println("VP: after personalization and logoff/on 6th Account quick action in group view is 'Add Activity' - PASSED");

            //Step: press Configure quick action to open 'Configure Quick Actions' screen ... restore to OOTB position and display
            //      click on 'Call Main' to re-display this quick action, and move down 'Add Attachment' quick action one position, below 'Add Activity'
            accountListView.topAccountsListItemQuickActionsConfiguretBtn.click();
            commNav.waitForPage("Configure Quick Actions");
            accountListView.accountConfigureQACallMain.click();
            accountListView.accountConfigureQAAddAttachDown.click();
            headerbutton.clickHeaderButton("save");
            commNav.waitForPage("All Accounts");

            //Step: click button to display the amended Quick Actions
            accountListView = PageFactory.initElements(driver, AccountViewsElements.class);
            accountListView.topAccountsListItemIcon.click();

            //Step: verify OOTB quick actions order and display have been restored
            quickActionText0 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=0]/label")).getText();
            quickActionText1 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=1]/label")).getText();
            quickActionText2 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=2]/label")).getText();
            quickActionText3 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=3]/label")).getText();
            quickActionText4 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=4]/label")).getText();
            quickActionText5 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=5]/label")).getText();
            quickActionText6 = driver.findElement(By.xpath("//*[@id='account_list']//ul/li[2]//button[@data-id=6]/label")).getText();

            AssertJUnit.assertEquals("VP: after resetting to OOTB order and display 1st Account quick action is 'Configure' - FAILED", "Configure", quickActionText0);
            System.out.println("VP: after resetting to OOTB order and display 1st Account quick action is 'Configure' - PASSED");
            AssertJUnit.assertEquals("VP: after resetting to OOTB order and display 2nd Account quick action is 'Edit' - FAILED", "Edit", quickActionText1);
            System.out.println("VP: after resetting to OOTB order and display 2nd Account quick action is 'Edit' - PASSED");
            AssertJUnit.assertEquals("VP: after resetting to OOTB order and display 3rd Account quick action is 'Call Main' - FAILED", "Call Main", quickActionText2);
            System.out.println("VP: after resetting to OOTB order and display 3rd Account quick action is 'Call Main' - PASSED");
            AssertJUnit.assertEquals("VP: after resetting to OOTB order and display 4th Account quick action is 'Contacts' - FAILED", "Contacts", quickActionText3);
            System.out.println("VP: after resetting to OOTB order and display 4th Account quick action is 'Contacts' - PASSED");
            AssertJUnit.assertEquals("VP: after resetting to OOTB order and display 5th Account quick action is 'Add Note' - FAILED", "Add Note", quickActionText4);
            System.out.println("VP: after resetting to OOTB order and display 5th Account quick action is 'Add Note' - PASSED");
            AssertJUnit.assertEquals("VP: after resetting to OOTB order and display 6th Account quick action is 'Add Activity' - FAILED", "Add Activity", quickActionText5);
            System.out.println("VP: after resetting to OOTB order and display 6th Account quick action is 'Add Activity' - PASSED");
            AssertJUnit.assertEquals("VP: after resetting to OOTB order and display 7th Account quick action is 'Add Attachment' - FAILED", "Add Attachment", quickActionText6);
            System.out.println("VP: after resetting to OOTB order and display 7th Account quick action is 'Add Attachment' - PASSED");

        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: personalization of quick actions " + " - FAILED");
            AssertJUnit.fail("test failed");
        }


        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // INFORCRM-2071 (MBL-10894) ... Calendar Month view : where activity is created not today, with start time earlier than current time,
    //               on saving, the calendar cell count is incremented by 1 as expected, but the associated activity doesn't display
    //               Requires that Month view ... next month ... first day on second row has no activities
    public void test06_INFORCRM2071() throws Exception {
        String methodID = "test06_INFORCRM2071";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        CalendarViewsElements calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);


        try {


            //Step: logout & log back in (to clear cookies)
            LogOutThenLogBackIn(userName, userPwd);


            //Step: go to Calendar view ... wait for page Calendar, and press 'Month' button
            commNav.clickGlobalMenuItem("Calendar");
            commNav.waitForPage("Calendar");
            calendarView.calendarDayListToMonthBtn.click();


            //Step: go to the next month, and click on the Sunday at the start of the 2nd row of days for the month
            calendarView.calendarNextMonthBtn.click();
            calendarView.calendarMonthFirstDaySecondRow.click();


            //Step: click the Add header button to open Activity schedule view
            headerButton.clickHeaderButton("Add");


            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");


            //Step: select Meeting for activity type
            activityEditView.activityScheduleMeetingBtn.click();


            //Step: wait for page Meeting to open
            commNav.waitForPage("Meeting");


            //Step: add an Activity record with a random value for 'regarding'
            String newActivityRegarding = "SeAutoTestActivity-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("Activity regarding field will be - " + newActivityRegarding);


            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);


            //Step: retrieve the default value for start time, then open the start time Calendar to set time to be earlier than the current time
            String newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("VP: Value for Start Time is : " + newActivityStartDate);
            activityEditView.activityEditViewStartTimeFldBtn.click();
            commNav.waitForPage("Calendar");
            calendarView.calendarDecrementHourBtn.click();
            headerButton.clickHeaderButton("accept");
            commNav.waitForPage("Meeting");


            //Step: retrieve the new value for start time, then find the 'time' portion only
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            String strDateTime = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("VP: 'Value for updated Start Time is ... " + strDateTime);
            String activityTime = strDateTime.substring(strDateTime.indexOf(' ')+1);
            System.out.println("VP: Activity time has a value of ... " + activityTime);


            //Step: convert activity string date representation to calendar date format
            SimpleDateFormat ft = new SimpleDateFormat("hh:mm a");
            Calendar activityDateTime1 = Calendar.getInstance();
            activityDateTime1.setTime(ft.parse(activityTime));


            //Step: convert current date/ time to date format of "hh:mm a", then convert time portion back to calendar date format
            Calendar todayDate = Calendar.getInstance();
            String todayString = ft.format(todayDate.getTime()).toString();
            System.out.println("VP: Today's time in hh:mm a format is - " + todayString);
            Calendar todayDateTime2 = Calendar.getInstance();
            todayDateTime2.setTime(ft.parse(todayString));

            //Step: check that the time of the activity is less than the current time 'today'
            if (activityDateTime1.before(todayDateTime2)){
                System.out.println("VP: Activity time is less than the current time for today ... continue test");
            }
            else {
                System.out.println("VP: Activity time is not less than the current time for today ... stop test " + " - FAILED");
                AssertJUnit.fail("test failed");
            }


            //Step: save activity
            headerButton.clickHeaderButton("Save");


            //Step: wait for page Calendar ... should still be positioned on Month view
            commNav.waitForPage("Calendar");
            calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);


            //Step: focus should still be on the Sunday at the start of the 2nd row of days for the month; verify that activity just created appears for this day
            AssertJUnit.assertEquals("VP: Activity created, not today, and earlier time than today, is displaying under the expected day in Calendar Month view " + " - FAILED", newActivityRegarding, calendarView.calendarMonthFirstActivityDescription.getText());
            System.out.println("VP: Activity created, not today, and earlier time than today, is displaying under the expected day in Calendar Month view " + " - PASSED");


        }


        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Activity created, not today, and earlier time than today, is displaying under the expected day in Calendar Month view " + " - FAILED");
            AssertJUnit.fail("test failed");
        }


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
