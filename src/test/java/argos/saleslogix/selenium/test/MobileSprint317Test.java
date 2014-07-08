package argos.saleslogix.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * Test class that defines test methods for the SLX Mobile Defect (v3.1 sprint 7) fixes
 * 
 * @author kathleen.lockyer-bratton@swiftpage.com
 * @version	1.0
 */
public class MobileSprint317Test extends BaseTest {

    public String TEST_ACCOUNT1_RECORD = "Abbott Ltd.";
    public String TEST_ACCOUNT2_RECORD = "Bank of the Sun";
    public String TEST_ACCOUNT3_RECORD = "Above Marine";

    public String TEST_CONTACT1_RECORD = "Balbo, Lou";
    public String TEST_CONTACT2_RECORD = "Sherman, John";

    public String TEST_CONTACT1_LOOKUP = "Balbo";
    public String TEST_CONTACT2_LOOKUP = "Sherman";

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


    @Test(enabled = true)
    // MBL-10429 ... For a new contact/ account, the address entered for the contact is copied into the account address if the account address is not set
    public void test01_MBL10429() throws Exception {
        String methodID = "test01_MBL10429";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        AddAccountContactEditViewElements addAcctCntctView = PageFactory.initElements(driver, AddAccountContactEditViewElements.class);

        //Step: open view to add account/ contact
        commNav.clickGlobalMenuItem("Add Account/Contact");
        commNav.waitForPage("Add Account / Contact");


        //Step: set the contact address field
        addAcctCntctView.addAcctCntctAddressInputBtn.click();
        commNav.waitForPage("Address");

        try {
            commView.addressDescriptionInputFld.sendKeys("Mailing");
            commView.addressLine1.sendKeys("8800 Shea Blvd");
            commView.addressLine2.sendKeys("Corporate Campus");
            commView.addressLine3.sendKeys("Suite 200");
            commView.addressCityInputFld.sendKeys("Scottsdale");
            commView.addressStateInputFld.sendKeys("AZ");
            commView.addressPostalInputFld.sendKeys("85258");
            commView.addressCountryInputFld.sendKeys("USA");
            commView.addressAttentionInputFld.sendKeys("Mr. Rogers");
            headerButton.clickHeaderButton("check");
            commNav.waitForPage("Add Account / Contact");
        }
        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: adding address for new contact " + " - FAILED");
            AssertJUnit.fail("test failed");
        }


        //Step: Verify that the address under Account Info has been set to the same as the Contact address
        String contactAddress = addAcctCntctView.addAcctCntctAddressInputFld.getText();
        String accountAddress = addAcctCntctView.addAcctCntctAcctAddressInputFld.getText();
        String addressAssigned = "8800 Shea Blvd Corporate Campus Suite 200 Scottsdale, AZ 85258 USA";

        System.out.println("VP: Contact Address for new account/ contact has been set to : " + contactAddress);
        System.out.println("VP: Account Address for new account/ contact has been set to : " + accountAddress);

        AssertJUnit.assertEquals("VP: Account Address was not initially set, so Contact Address was copied into Account Address - FAILED", addressAssigned, accountAddress);
        System.out.println("VP: Account Address was not initially set, so Contact Address was copied into Account Address - PASSED");


        System.out.println(ENDLINE);
    }



    @Test(enabled = true)
    // MBL-10404 ... load home page based on user's preference as defined on Configure View (at present the default home page is 'My Activities')
    public void test02_MBL10404() throws Exception {
        String methodID = "test02_MBL10404";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MiscEntityItemViewsElements miscView = PageFactory.initElements(driver, MiscEntityItemViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);


        //Step: open Configure view
        commNav.clickGlobalMenuItem("Configure Menu");
        commNav.waitForPage("Configure");


        //Step: for Calendar, press button once to move it up to the top of the list, above 'My Activities'
        miscView.configureCalendarMoveUpBtn.click();
        headerButton.clickHeaderButton("Save");

        //Step: logout & log back in ... then verify that default page after login is now 'Calendar'
        LogOutThenLogBackIn(userName, userPwd);
        commNav.waitForPage("Calendar");
        AssertJUnit.assertTrue("VP: default page after login now set to 'Calendar' - FAILED", driver.findElement(By.xpath(".//*[@id='calendar_daylist']")).isDisplayed());
        System.out.println("VP: default page after login now set to 'Calendar' - PASSED");

        //Step: reset the default page back to 'My Activities'
        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        headerButton = PageFactory.initElements(driver, HeaderButton.class);
        miscView = PageFactory.initElements(driver, MiscEntityItemViewsElements.class);
        commNav.clickGlobalMenuItem("Configure Menu");
        commNav.waitForPage("Configure");

        //Step: for Calendar, press button once to move it down below 'My Activities'
        miscView.configureCalendarMoveDownBtn.click();
        headerButton.clickHeaderButton("Save");

        //Step: logout & log back in ... then verify that default page after login is again 'My Activities'
        LogOutThenLogBackIn(userName, userPwd);
        commNav.waitForPage("My Activities");
        AssertJUnit.assertTrue("VP: default page after login set back to 'My Activities' - FAILED", driver.findElement(By.xpath(".//*[@id='myactivity_list']")).isDisplayed());
        System.out.println("VP: default page after login set back to 'My Activities' - PASSED");

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // MBL-10452 ... While editing an Activity in the Mobile Client, changing the Account doesn't validate the Contact ... Contact field should be cleared out as in web client and LAN
    //               Two Scenarios :
    //               1. adding and editing the activity within the same login session ... changing the account (this was working previously)
    //               2. editing the activity in  a different login session than that in which it was created ... changing the account
    public void test03_MBL10452() throws Exception {
        String methodID = "test03_MBL10452";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);


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


            //Step: set the initial Account for the activity
            activityEditView.activityEditViewAccountBtn.click();
            commNav.waitForPage("Accounts");
            AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
            accountsListView.relatedAccountsSearchTxtBox.sendKeys(TEST_ACCOUNT1_RECORD);
            accountsListView.relatedAccountsSearchLookupBtn.click();
            Thread.sleep(3000);
            accountsListView.relatedAccountsListViewTopItem.click();
            System.out.println("Initial account chosen was : " + TEST_ACCOUNT1_RECORD);
            commNav.waitForPage("Meeting");

            //Step: set the initial Contact for the activity
            activityEditView.activityEditViewContactBtn.click();
            commNav.waitForPage("Contacts");
            ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
            contactsListView.relatedContactsSearchTxtBox.sendKeys(TEST_CONTACT1_LOOKUP);
            contactsListView.relatedContactsSearchLookupBtn.click();
            Thread.sleep(3000);
            contactsListView.relatedContactsListViewTopItem.click();
            System.out.println("Initial contact chosen was : " + TEST_CONTACT1_RECORD);
            commNav.waitForPage("Meeting");

            //Step: save activity
            headerButton.clickHeaderButton("Save");

            //Step: wait for page My Activities
            commNav.waitForPage("My Activities");

            //Step: search for activity created ... and re-open
            activityEditView.performMyActivitiesSearch(newActivityRegarding);
            WebElement activityItemLnk = driver.findElement(By.xpath("//*[@id='myactivity_list']//ul/li[1]/descendant::*[text() = '" + newActivityRegarding + "']"));
            commNav.highlightNClick(activityItemLnk);
            commNav.waitForPage("Activity");


            //Step: open the activity created in edit mode
            headerButton.clickHeaderButton("Edit");

            //Step: wait for page Activity
            commNav.waitForPage("Activity");

            //Step: print values for account and contact in 'edit' mode, and verify that both still have the expected values
            System.out.println("*** START OF SCENARIO 1 ... CHANGING ACTIVITY ACCOUNT WITHIN SAME LOGIN SESSION AS CREATED ***");
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            System.out.println("On edit view initial Account chosen displays as : " + activityEditView.activityEditViewAccountFld.getAttribute("value"));
            System.out.println("On edit view initial Contact chosen displays as : " + activityEditView.activityEditViewContactFld.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Account field not set to initial expected value - FAILED", TEST_ACCOUNT1_RECORD, activityEditView.activityEditViewAccountFld.getAttribute("value"));
            System.out.println("VP: Account field is set to initial expected value - PASSED");
            AssertJUnit.assertEquals("VP: Contact field not set to initial expected value - FAILED", TEST_CONTACT1_RECORD, activityEditView.activityEditViewContactFld.getAttribute("value"));
            System.out.println("VP: Contact field is set to initial expected value - PASSED");

            //Step: within the same login session choose a new (second) value for the Account ... verify that the Contact value has been cleared
            activityEditView.activityEditViewAccountBtn.click();
            commNav.waitForPage("Accounts");
            accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
            accountsListView.relatedAccountsSearchTxtBox.clear();
            accountsListView.relatedAccountsSearchTxtBox.sendKeys(TEST_ACCOUNT2_RECORD);
            accountsListView.relatedAccountsSearchLookupBtn.click();
            Thread.sleep(3000);
            accountsListView.relatedAccountsListViewTopItem.click();
            System.out.println("WITHIN SAME LOGIN SESSION ... Second account chosen was : " + TEST_ACCOUNT2_RECORD);
            commNav.waitForPage("Meeting");

            //Step: print new (second) values for account and contact in 'edit' mode, and verify that both values are as expected ... Contact field should be cleared
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            System.out.println("On edit view second Account chosen displays as : " + activityEditView.activityEditViewAccountFld.getAttribute("value"));
            System.out.println("On edit view Contact now displays as : " + activityEditView.activityEditViewContactFld.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Account field not set to second expected value - FAILED", TEST_ACCOUNT2_RECORD, activityEditView.activityEditViewAccountFld.getAttribute("value"));
            System.out.println("VP: Account field is set to second expected value - PASSED");
            AssertJUnit.assertEquals("VP: Contact field not set to expected value of blank - FAILED", "", activityEditView.activityEditViewContactFld.getAttribute("value"));
            System.out.println("VP: Contact field is set to expected value of blank - PASSED");
            System.out.println("*** END OF SCENARIO 1 ... CHANGING ACTIVITY ACCOUNT WITHIN SAME LOGIN SESSION AS CREATED ***");


            //Step: Assign a value to the Contact field, ready for scenario 2
            System.out.println("*** START OF SCENARIO 2 ... CHANGING ACTIVITY ACCOUNT WITHIN NEXT LOGIN SESSION AFTER CREATED ***");
            activityEditView.activityEditViewContactBtn.click();
            commNav.waitForPage("Contacts");
            contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
            contactsListView.relatedContactsSearchTxtBox.clear();
            contactsListView.relatedContactsSearchTxtBox.sendKeys(TEST_CONTACT2_LOOKUP);
            contactsListView.relatedContactsSearchLookupBtn.click();
            Thread.sleep(3000);
            contactsListView.relatedContactsListViewTopItem.click();
            System.out.println("Second contact chosen was : " + TEST_CONTACT2_RECORD);
            commNav.waitForPage("Meeting");

            //Step: save activity
            headerButton.clickHeaderButton("Save");

            //Step: within a different login session choose a new (third) value for the Account ... verify that the Contact value has been cleared
            LogOutThenLogBackIn(userName, userPwd);

            //Step: go to "My Activities" view, if not already there ... wait for page My Activities
            if (!commNav.isPageDisplayed("My Activities"))   {
                commNav.clickGlobalMenuItem("My Activities");
                commNav.waitForPage("My Activities");
            }

            //Step: search for activity created ... and re-open
            activityEditView.performMyActivitiesSearch(newActivityRegarding);
            activityItemLnk = driver.findElement(By.xpath("//*[@id='myactivity_list']//ul/li[1]/descendant::*[text() = '" + newActivityRegarding + "']"));
            commNav.highlightNClick(activityItemLnk);
            commNav.waitForPage("Activity");


            //Step: open the activity created in edit mode
            headerButton.clickHeaderButton("Edit");

            //Step: wait for page Activity
            commNav.waitForPage("Activity");

            //Step: print values for account and contact in 'edit' mode, and verify that both still have the expected values
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            System.out.println("On edit view second Account chosen displays as : " + activityEditView.activityEditViewAccountFld.getAttribute("value"));
            System.out.println("On edit view second Contact chosen displays as : " + activityEditView.activityEditViewContactFld.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Account field not set to second expected value - FAILED", TEST_ACCOUNT2_RECORD, activityEditView.activityEditViewAccountFld.getAttribute("value"));
            System.out.println("VP: Account field is set to second expected value - PASSED");
            AssertJUnit.assertEquals("VP: Contact field not set to second expected value - FAILED", TEST_CONTACT2_RECORD, activityEditView.activityEditViewContactFld.getAttribute("value"));
            System.out.println("VP: Contact field is set to second expected value - PASSED");

            //Step: within a different login session than the one in which activity was created, choose a new (third) value for the Account ... verify that the Contact value has been cleared
            activityEditView.activityEditViewAccountBtn.click();
            commNav.waitForPage("Accounts");
            accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
            accountsListView.relatedAccountsSearchTxtBox.clear();
            accountsListView.relatedAccountsSearchTxtBox.sendKeys(TEST_ACCOUNT3_RECORD);
            accountsListView.relatedAccountsSearchLookupBtn.click();
            Thread.sleep(3000);
            accountsListView.relatedAccountsListViewTopItem.click();
            System.out.println("WITHIN DIFFERENT LOGIN SESSION ... Third account chosen was : " + TEST_ACCOUNT3_RECORD);
            commNav.waitForPage("Meeting");

            //Step: print new (third) values for account and contact in 'edit' mode, and verify that both values are as expected ... Contact field should be cleared
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            System.out.println("On edit view third Account chosen displays as : " + activityEditView.activityEditViewAccountFld.getAttribute("value"));
            System.out.println("On edit view Contact now displays as : " + activityEditView.activityEditViewContactFld.getAttribute("value"));
            AssertJUnit.assertEquals("VP: Account field not set to third expected value - FAILED", TEST_ACCOUNT3_RECORD, activityEditView.activityEditViewAccountFld.getAttribute("value"));
            System.out.println("VP: Account field is set to third expected value - PASSED");
            AssertJUnit.assertEquals("VP: Contact field not set to expected value of blank - FAILED", "", activityEditView.activityEditViewContactFld.getAttribute("value"));
            System.out.println("VP: Contact field is set to expected value of blank - PASSED");
            System.out.println("*** END OF SCENARIO 2 ... CHANGING ACTIVITY ACCOUNT WITHIN NEXT LOGIN SESSION AFTER CREATED ***");



        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: changing activity account should clear the contact field " + " - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // MBL-10472 ... Using Account listview Edit quick action to edit account should display address on edit view or Address view
    public void test04_MBL10472() throws Exception {
        String methodID = "test04_MBL10472";

        // Test Params:
        String entityType = "Accounts";
        String entityRecord = TEST_ACCOUNT1_RECORD;

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: search for an existing Account record
        commNav.entityListViewSearch(entityType, entityRecord);

        if (commNav.isPageDisplayed(entityType)) {

            AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);
            commNav.checkIfWebElementPresent("Accounts List View, item record Icon", accountListView.topAccountsListItemIcon);

            //Step: open the Account quick actions
            try {
                //click list item icon to reveal Quick Action items
                accountListView.topAccountsListItemIcon.click();

                //check the Edit Quick Action item
                commNav.checkIfWebElementPresent("Account, Quick Action Edit button", accountListView.topAccountsListItemQuickActionsEditBtn);

                //click the Edit Quick Action item
                accountListView.topAccountsListItemQuickActionsEditBtn.click();
                commNav.waitForPage("Account");
                AccountViewsElements accountEditView = PageFactory.initElements(driver, AccountViewsElements.class);

                //click the edit address button to open the Address screen
                accountEditView.accountEditViewAddressFldBtn.click();
                commNav.waitForPage("Address");

                String addressLine1Data = commView.addressLine1.getAttribute("value");
                System.out.println("address Line1 is ... " + addressLine1Data);
                String addressLine1ExpectedData = "4206 W. Grand Avenue";
                AssertJUnit.assertEquals("VP: edit view is not displaying address line 1 for " + TEST_ACCOUNT1_RECORD + " as ... " + addressLine1ExpectedData + " - FAILED" ,addressLine1ExpectedData, addressLine1Data);
                System.out.println("VP: edit view is displaying address line 1 for " + TEST_ACCOUNT1_RECORD + " as ... " + addressLine1ExpectedData + " - PASSED");

            }
            catch (Exception e) {
                verificationErrors.append(methodID + "(): " + e.toString());
                AssertJUnit.fail("test failed");
            }

        }
        else {
            System.out.println(methodID + ": required '" + entityType + "' view not loaded; test aborted");
            AssertJUnit.fail("test failed");
        }
        System.out.println(ENDLINE);



    }


    @Test(enabled = true)
    //MBL-10483 ...   Adding a Note with no account specified should not give a server error
    public void test05_MBL10483() throws Exception {
        String methodID = "test05_MBL10483";

        //Test Params:
        String entityType = "notes/history";
        String viewName = "Note Insert view";
        String entityRecord = TEST_ACCOUNT1_RECORD;

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
        NotesHistoryViewsElements noteshistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: login & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: click Top-Left button to reveal Global Menu...
        headerbutton.showGlobalMenu();

        //Step: navigate to Notes/History list view...
        commNav.clickGlobalMenuItem(entityType);
        commNav.waitForPage("Notes/History");

        //Step: add a new note, with no account specified
        headerbutton.clickHeaderButton("add");
        commNav.waitForPage("Note");

        //Step: add a random test Note/History record
        NotesHistoryViewsElements notesHistoryEditView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);

        String strRegardingVal = "AutoTestNote-" + new SimpleDateFormat("yyMMddHHmm").format(new GregorianCalendar().getTime());
        String newNotesData = "Technical notes";

        //Step: setup Regarding and Notes fields, then try to save new note
        notesHistoryEditView.notesHistoryEditViewRegardingInputFld.sendKeys(strRegardingVal);
        notesHistoryEditView.notesHistoryEditViewNotesInputFld.sendKeys(newNotesData);
        headerbutton.clickHeaderButton("save");

        //Step: Verify that one sees a validation summary title at the top of the screen
        if (commNav.isWebElementPresent(viewName + ",'Validation Summary title'", notesHistoryEditView.notesHistoryEditViewValSummTitle)) {
            String valSummaryTitleExpected = "Validation Summary";
            String valSummaryTitleActual = notesHistoryEditView.notesHistoryEditViewValSummTitle.getText();
            AssertJUnit.assertEquals("VP: Validation Summary title does not have the expected value of " + valSummaryTitleExpected + " - FAILED", valSummaryTitleExpected, valSummaryTitleActual);
            System.out.println("VP: Validation Summary title does have the expected value of ... " + valSummaryTitleExpected + " - PASSED");
        }
        else {
            System.out.println("VP: expected Validation Summary title not present - FAILED");
            AssertJUnit.fail("test failed");
        }

        //Step: Verify that one sees a validation summary message that "The field 'account' must have a value."
        if (commNav.isWebElementPresent(viewName + ",'Validation Summary message'", notesHistoryEditView.notesHistoryEditViewValSummMessage)) {
            String valSummaryMessageExpected = "The field 'account' must have a value.";
            String valSummaryMessageActual = notesHistoryEditView.notesHistoryEditViewValSummMessage.getText();
            AssertJUnit.assertEquals("VP: Validation Summary message does not have the expected value of " + valSummaryMessageExpected + " - FAILED", valSummaryMessageExpected, valSummaryMessageActual);
            System.out.println("VP: Validation Summary message does have the expected value of ... " + valSummaryMessageExpected + " - PASSED");
        }
        else {
            System.out.println("VP: expected Validation Summary message not present - FAILED");
            AssertJUnit.fail("test failed");
        }

        //Step: Verify that one sees a validation summary field of 'account'
        if (commNav.isWebElementPresent(viewName + ",'Validation Summary field'", notesHistoryEditView.notesHistoryEditViewValSummField)) {
            String valSummaryFieldExpected = "account";
            String valSummaryFieldActual = notesHistoryEditView.notesHistoryEditViewValSummField.getText();
            AssertJUnit.assertEquals("VP: Validation Summary field does not have the expected value of " + valSummaryFieldExpected + " - FAILED", valSummaryFieldExpected, valSummaryFieldActual);
            System.out.println("VP: Validation Summary field does have the expected value of ... " + valSummaryFieldExpected + " - PASSED");
        }
        else {
            System.out.println("VP: expected Validation Summary field not present - FAILED");
            AssertJUnit.fail("test failed");
        }


        //Step : verify that one may now enter an account, and save the note successfully
        notesHistoryEditView.notesHistoryEditViewAccountFldBtn.click();
        commNav.highlightNClick(commNav.entityListViewSelect("Accounts", entityRecord));

        headerbutton.clickHeaderButton("save");
        commNav.waitForPage("Notes/History");
        noteshistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);

        String strResultsMsg = "VP: recently added test Note '" + newNotesData + "' was found";
        noteshistoryListView.notesHistorysSearchTxtBox.sendKeys(strRegardingVal);
        noteshistoryListView.notesHistorysSearchLookupBtn.click();

        WebElement entityListItem = noteshistoryListView.topNotesHistoryListItem;
        if (entityListItem.isDisplayed())  {
            System.out.println(strResultsMsg + " - PASSED");
        }
        else {
            System.out.println(strResultsMsg + " - FAILED");
        }

        System.out.println(ENDLINE);
    }


}
