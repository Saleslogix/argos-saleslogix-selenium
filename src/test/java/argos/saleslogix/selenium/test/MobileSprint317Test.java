package argos.saleslogix.selenium.test;

import argos.saleslogix.selenium.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


/**
 * Test class that defines test methods for the SLX Mobile Defect (v3.1 sprint 7) fixes
 *
 * @author kathleen.lockyer-bratton@swiftpage.com
 * @version 1.0
 */
public class MobileSprint317Test extends BaseTest {

    public String TEST_CONTACT_RECORD = "Abbott, John";
    public String TEST_ACCOUNT1_RECORD = "Abbott Ltd.";
    public String TEST_ACCOUNT2_RECORD = "Bank of the Sun";
    public String TEST_ACCOUNT3_RECORD = "Above Marine";

    public String TEST_CONTACT1_RECORD = "Balbo, Lou";
    public String TEST_CONTACT2_RECORD = "Sherman, John";

    public String TEST_CONTACT1_LOOKUP = "Balbo";
    public String TEST_CONTACT2_LOOKUP = "Sherman";

    public String TEST_LEAD_RECORD = "Beck, John";

    //Login & Logout
    //==============
    @Test
    public void test00_MobileClient_Login() throws InterruptedException {
        String methodID = "test00_MobileClient_Login";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        doVerificationLogin();

        System.out.println(ENDLINE);
    }

    @Test
    public void test99_Mobile_LogOut() throws InterruptedException {
        String methodID = "test99_Mobile_LogOut";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        doVerificationLogout();

        System.out.println(ENDLINE);
    }


    @Test
    // Add My Activities as a menu item
    public void test01_AddMyActivities() throws Exception {
        String methodID = "test01_AddMyActivities";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MiscEntityItemViewsElements miscView = PageFactory.initElements(driver, MiscEntityItemViewsElements.class);


        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        try {


            //Step: logout & log back in (to clear cookies)
            LogOutThenLogBackIn(userName, userPwd);

            //Step: enable 'My Activities' under Configure view ... needed with 'My Activities' no longer displaying by default in 3.4
            commNav.clickGlobalMenuItem("Configure Menu");
            commNav.waitForPage("Configure");
            miscView.configureMyActivities.click();
            headerButton.clickHeaderButton("Save");
            commNav.waitForPage("My Schedule");

            System.out.println("VP: added My Activities back as a menu item - PASSED");

        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: added My Activities back as a menu item - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }

    @Test
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
        } catch (Exception e) {
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


    @Test
    // MBL-10404 ... load home page based on user's preference as defined on Configure View
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


        //Step: for Calendar, drag button up to the top of the list, above 'My Activities', or whatever is the current default page
        Actions action = new Actions(driver);
        action.dragAndDrop(miscView.configureCalendarBtn, miscView.configureTopPosition).build().perform();
        headerButton.clickHeaderButton("Save");

        //Step: logout & log back in ... then verify that default page after login is now 'Calendar'
        LogOutThenLogBackIn(userName, userPwd);
        commNav.waitForPage("Calendar");
        AssertJUnit.assertTrue("VP: default page after login now set to 'Calendar' - FAILED", driver.findElement(By.xpath(".//*[@id='calendar_view']")).isDisplayed());
        System.out.println("VP: default page after login now set to 'Calendar' - PASSED");

        //Step: reset the default page back to 'My Activities', or whatever it was previously
        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        headerButton = PageFactory.initElements(driver, HeaderButton.class);
        miscView = PageFactory.initElements(driver, MiscEntityItemViewsElements.class);
        commNav.clickGlobalMenuItem("Configure Menu");
        commNav.waitForPage("Configure");

        //Step: for Calendar, drag button down to second position
        action.dragAndDrop(miscView.configureCalendarBtn, miscView.configureSecondPosition).build().perform();
        headerButton.clickHeaderButton("Save");

        //Step: logout & log back in ... then verify that default page after login is again 'My Activities' ... LATER update with NEW default page for Mobile 3.4
        //LogOutThenLogBackIn(userName, userPwd);
        //commNav.waitForPage("My Activities");
        //AssertJUnit.assertTrue("VP: default page after login set back to 'My Activities' - FAILED", driver.findElement(By.xpath(".//*[@id='myactivity_list']")).isDisplayed());
        //System.out.println("VP: default page after login set back to 'My Activities' - PASSED");

        System.out.println(ENDLINE);
    }


    @Test
    // MBL-10452 ... While editing an Activity in the Mobile Client, changing the Account doesn't validate the Contact ... Contact field should be cleared out as in web client and LAN
    //               Two Scenarios :
    //               1. adding and editing the activity within the same login session ... changing the account (this was working previously)
    //               2. editing the activity in  a different login session than that in which it was created ... changing the account
    public void test03_MBL10452() throws Exception {
        String methodID = "test03_MBL10452";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);


        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        try {


            //Step: logout & log back in (to clear cookies)
            LogOutThenLogBackIn(userName, userPwd);


            //Step: go to "My Activities" view, if not already there ... wait for page My Activities
            if (!commNav.isPageDisplayed("My Activities")) {
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
            //accountsListView.relatedAccountsSearchTxtBox.sendKeys(TEST_ACCOUNT1_RECORD);
            commView.lookupTxtBox.sendKeys(TEST_ACCOUNT1_RECORD);
            //accountsListView.relatedAccountsSearchLookupBtn.click();
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
            Thread.sleep(3000);
            accountsListView.relatedAccountsListViewTopItem.click();
            System.out.println("Initial account chosen was : " + TEST_ACCOUNT1_RECORD);
            commNav.waitForPage("Meeting");

            //Step: set the initial Contact for the activity
            activityEditView.activityEditViewContactBtn.click();
            commNav.waitForPage("Contacts");
            ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
            commView = PageFactory.initElements(driver, CommonViewsElements.class);
            commView.lookupTxtBox.click();
            Thread.sleep(500);
            commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
            Thread.sleep(500);
            //contactsListView.relatedContactsSearchTxtBox.sendKeys(TEST_CONTACT1_LOOKUP);
            commView.lookupTxtBox.sendKeys(TEST_CONTACT1_LOOKUP);
            //contactsListView.relatedContactsSearchLookupBtn.click();
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
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
            commView = PageFactory.initElements(driver, CommonViewsElements.class);
            //accountsListView.relatedAccountsSearchTxtBox.clear();
            commView.lookupTxtBox.click();
            Thread.sleep(500);
            commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
            Thread.sleep(500);
            //accountsListView.relatedAccountsSearchTxtBox.sendKeys(TEST_ACCOUNT2_RECORD);
            commView.lookupTxtBox.sendKeys(TEST_ACCOUNT2_RECORD);
            //accountsListView.relatedAccountsSearchLookupBtn.click();
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
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
            commView = PageFactory.initElements(driver, CommonViewsElements.class);

            //contactsListView.relatedContactsSearchTxtBox.clear();
            commView.lookupTxtBox.click();
            Thread.sleep(500);
            commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
            Thread.sleep(500);
            //contactsListView.relatedContactsSearchTxtBox.sendKeys(TEST_CONTACT2_LOOKUP);
            commView.lookupTxtBox.sendKeys(TEST_CONTACT2_LOOKUP);
            //contactsListView.relatedContactsSearchLookupBtn.click();
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
            Thread.sleep(3000);
            contactsListView.relatedContactsListViewTopItem.click();
            System.out.println("Second contact chosen was : " + TEST_CONTACT2_RECORD);
            commNav.waitForPage("Meeting");

            //Step: save activity
            headerButton.clickHeaderButton("Save");

            //Step: within a different login session choose a new (third) value for the Account ... verify that the Contact value has been cleared
            LogOutThenLogBackIn(userName, userPwd);

            //Step: go to "My Activities" view, if not already there ... wait for page My Activities
            commNav = PageFactory.initElements(driver, CommonNavigation.class);
            if (!commNav.isPageDisplayed("My Activities")) {
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
            commView = PageFactory.initElements(driver, CommonViewsElements.class);

            //accountsListView.relatedAccountsSearchTxtBox.clear();
            commView.lookupTxtBox.click();
            Thread.sleep(500);
            commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
            Thread.sleep(500);
            //accountsListView.relatedAccountsSearchTxtBox.sendKeys(TEST_ACCOUNT3_RECORD);
            commView.lookupTxtBox.sendKeys(TEST_ACCOUNT3_RECORD);
            //accountsListView.relatedAccountsSearchLookupBtn.click();
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
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


        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: changing activity account should clear the contact field " + " - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test
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
                AssertJUnit.assertEquals("VP: edit view, opened by quick action, is not displaying address line 1 for " + TEST_ACCOUNT1_RECORD + " as ... " + addressLine1ExpectedData + " - FAILED", addressLine1ExpectedData, addressLine1Data);
                System.out.println("VP: edit view, opened by quick action, is displaying address line 1 for " + TEST_ACCOUNT1_RECORD + " as ... " + addressLine1ExpectedData + " - PASSED");

            } catch (Exception e) {
                verificationErrors.append(methodID + "(): " + e.toString());
                AssertJUnit.fail("test failed");
            }

        } else {
            System.out.println(methodID + ": required '" + entityType + "' view not loaded; test aborted");
            AssertJUnit.fail("test failed");
        }
        System.out.println(ENDLINE);


    }


    @Test
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
        noteshistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);

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
        Thread.sleep(1000);
        notesHistoryEditView.notesHistoryEditViewRegardingInputFld.sendKeys(strRegardingVal);
        notesHistoryEditView.notesHistoryEditViewNotesInputFld.sendKeys(newNotesData);
        headerbutton.clickHeaderButton("save");

        //Step: Verify that one sees a validation summary title at the top of the screen
        if (commNav.isWebElementPresent(viewName + ",'Validation Summary title'", notesHistoryEditView.notesHistoryEditViewValSummTitle)) {
            String valSummaryTitleExpected = "Validation Summary";
            String valSummaryTitleActual = notesHistoryEditView.notesHistoryEditViewValSummTitle.getText();
            AssertJUnit.assertEquals("VP: Validation Summary title does not have the expected value of " + valSummaryTitleExpected + " - FAILED", valSummaryTitleExpected, valSummaryTitleActual);
            System.out.println("VP: Validation Summary title does have the expected value of ... " + valSummaryTitleExpected + " - PASSED");
        } else {
            System.out.println("VP: expected Validation Summary title not present - FAILED");
            AssertJUnit.fail("test failed");
        }

        //Step: Verify that one sees a validation summary message that "The field 'account' must have a value."
        if (commNav.isWebElementPresent(viewName + ",'Validation Summary message'", notesHistoryEditView.notesHistoryEditViewValSummMessage)) {
            String valSummaryMessageExpected = "The field 'account' must have a value";
            String valSummaryMessageActual = notesHistoryEditView.notesHistoryEditViewValSummMessage.getText();
            AssertJUnit.assertEquals("VP: Validation Summary message does not have the expected value of " + valSummaryMessageExpected + " - FAILED", valSummaryMessageExpected, valSummaryMessageActual);
            System.out.println("VP: Validation Summary message does have the expected value of ... " + valSummaryMessageExpected + " - PASSED");
        } else {
            System.out.println("VP: expected Validation Summary message not present - FAILED");
            AssertJUnit.fail("test failed");
        }

        //Step: Verify that one sees a validation summary field of 'account'
        if (commNav.isWebElementPresent(viewName + ",'Validation Summary field'", notesHistoryEditView.notesHistoryEditViewValSummField)) {
            String valSummaryFieldExpected = "account";
            String valSummaryFieldActual = notesHistoryEditView.notesHistoryEditViewValSummField.getText();
            AssertJUnit.assertEquals("VP: Validation Summary field does not have the expected value of " + valSummaryFieldExpected + " - FAILED", valSummaryFieldExpected, valSummaryFieldActual);
            System.out.println("VP: Validation Summary field does have the expected value of ... " + valSummaryFieldExpected + " - PASSED");
        } else {
            System.out.println("VP: expected Validation Summary field not present - FAILED");
            AssertJUnit.fail("test failed");
        }


        //Step : verify that one may now enter an account, and save the note successfully
        notesHistoryEditView.notesHistoryEditViewAccountFldBtn.click();
        commNav.highlightNClick(commNav.entityListViewSelect("Accounts", entityRecord));

        headerbutton.clickHeaderButton("save");
        commNav.waitForPage("Notes/History");

        String strResultsMsg = "VP: recently added test Note '" + newNotesData + "' was saved";
        System.out.println(strResultsMsg + " - PASSED");


        System.out.println(ENDLINE);
    }


    @Test
    // MBL-10486 ... Activity Leader should use calendar security for list of users available (as in web client)
    //               This is designed to work for user name of 'loup', the user used for all automation

    public void test06_MBL10486() throws Exception {
        String methodID = "test06_MBL10486";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);


        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        try {


            //Step: logout & log back in (to clear cookies)
            LogOutThenLogBackIn(userName, userPwd);


            //Step: go to "My Activities" view, if not already there ... wait for page My Activities
            if (!commNav.isPageDisplayed("My Activities")) {
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

            //Step: open the Leader lookup, and check that the correct users are displaying for loup
            activityEditView.activityEditViewLeaderFldBtn.click();
            commNav.waitForPage("Users");

            String leaderUser1 = activityEditView.activityLeaderViewUser1.getText();
            AssertJUnit.assertEquals("VP: 1st user on the activity leader users' list is not Dan Barret - FAILED", "Barret, Dan", leaderUser1);
            System.out.println("VP: 1st user on the activity leader users' list is Dan Barret - PASSED");

            String leaderUser2 = activityEditView.activityLeaderViewUser2.getText();
            AssertJUnit.assertEquals("VP: 2nd user on the activity leader users' list is not Ken Dryden - FAILED", "Dryden, Ken", leaderUser2);
            System.out.println("VP: 2nd user on the activity leader users' list is Ken Dryden - PASSED");

            String leaderUser3 = activityEditView.activityLeaderViewUser3.getText();
            AssertJUnit.assertEquals("VP: 3rd user on the activity leader users' list is not Georgine Ekels - FAILED", "Ekels, Georgine", leaderUser3);
            System.out.println("VP: 3rd user on the activity leader users' list is Georgine Ekels - PASSED");

            String leaderUser4 = activityEditView.activityLeaderViewUser4.getText();
            AssertJUnit.assertEquals("VP: 4th user on the activity leader users' list is not Manuel Fuentes - FAILED", "Fuentes, Manuel", leaderUser4);
            System.out.println("VP: 4th user on the activity leader users' list is Manuel Fuentes - PASSED");

            String leaderUser5 = activityEditView.activityLeaderViewUser5.getText();
            AssertJUnit.assertEquals("VP: 5th user on the activity leader users' list is not Jean Grant - FAILED", "Grant, Jean", leaderUser5);
            System.out.println("VP: 5th user on the activity leader users' list is Jean Grant - PASSED");

            String leaderUser6 = activityEditView.activityLeaderViewUser6.getText();
            AssertJUnit.assertEquals("VP: 6th user on the activity leader users' list is not Lee Hogan - FAILED", "Hogan, Lee", leaderUser6);
            System.out.println("VP: 6th user on the activity leader users' list is Lee Hogan - PASSED");

            String leaderUser7 = activityEditView.activityLeaderViewUser7.getText();
            AssertJUnit.assertEquals("VP: 7th user on the activity leader users' list is not Cathy Hughes - FAILED", "Hughes, Cathy", leaderUser7);
            System.out.println("VP: 7th user on the activity leader users' list is Cathy Hughes - PASSED");

            String leaderUser8 = activityEditView.activityLeaderViewUser8.getText();
            AssertJUnit.assertEquals("VP: 8th user on the activity leader users' list is not Barb Hutchinson - FAILED", "Hutchinson, Barb", leaderUser8);
            System.out.println("VP: 8th user on the activity leader users' list is Barb Hutchinson - PASSED");

            String leaderUser9 = activityEditView.activityLeaderViewUser9.getText();
            AssertJUnit.assertEquals("VP: 9th user on the activity leader users' list is not Jay Johnson - FAILED", "Johnson, Jay", leaderUser9);
            System.out.println("VP: 9th user on the activity leader users' list is Jay Johnson - PASSED");

            String leaderUser10 = activityEditView.activityLeaderViewUser10.getText();
            AssertJUnit.assertEquals("VP: 10th user on the activity leader users' list is not Ed Martinez - FAILED", "Martinez, Ed", leaderUser10);
            System.out.println("VP:10th user on the activity leader users' list is Ed Martinez - PASSED");

            String leaderUser11 = activityEditView.activityLeaderViewUser11.getText();
            AssertJUnit.assertEquals("VP: 11th user on the activity leader users' list is not Lou McBeal - FAILED", "McBeal, Lou", leaderUser11);
            System.out.println("VP: 11th user on the activity leader users' list is Lou McBeal - PASSED");

            String leaderUser12 = activityEditView.activityLeaderViewUser12.getText();
            AssertJUnit.assertEquals("VP: 12th user on the activity leader users' list is not Lou Pizzutti - FAILED", "Pizzutti, Lou", leaderUser12);
            System.out.println("VP: 12th user on the activity leader users' list is Lou Pizzutti - PASSED");

            String leaderUser13 = activityEditView.activityLeaderViewUser13.getText();
            AssertJUnit.assertEquals("VP: 13th user on the activity leader users' list is not Tom Scanlon - FAILED", "Scanlon, Tom", leaderUser13);
            System.out.println("VP: 13th user on the activity leader users' list is Tom Scanlon - PASSED");

            String leaderUser14 = activityEditView.activityLeaderViewUser14.getText();
            AssertJUnit.assertEquals("VP: 14th user on the activity leader users' list is not Lois Tomlin - FAILED", "Tomlin, Lois", leaderUser14);
            System.out.println("VP: 14th user on the activity leader users' list is Lois Tomlin - PASSED");

            String leaderUser15 = activityEditView.activityLeaderViewUser15.getText();
            AssertJUnit.assertEquals("VP: 15th user on the activity leader users' list is not Linda Walsh - FAILED", "Walsh, Linda", leaderUser15);
            System.out.println("VP: 15th user on the activity leader users' list is Linda Walsh - PASSED");

            System.out.println("VP: Activity Leader should use calendar security for list of users available " + " - PASSED");


        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Activity Leader should use calendar security for list of users available " + " - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test
    // MBL-10454 ... error trying to save an edited address for contacts (and accounts)
    public void test07_MBL10454() throws Exception {
        String methodID = "test07_MBL10454";

        //Test Parameters:
        String entityType = "Contact";
        String contactRecord = TEST_CONTACT_RECORD;
        String viewName = "Contact Edit view";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: login & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        try {
            //Step: search for Contact entity, then open it's Edit view
            AssertJUnit.assertTrue(commNav.entityRecordEditView(entityType, contactRecord));

            //Step: open the contact's Address view and store current values for the Address
            ContactViewsElements contactEditView = PageFactory.initElements(driver, ContactViewsElements.class);
            CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);

            contactEditView.contactsEditViewAddressInputFldBtn.click();
            commNav.waitForPage("Address");
            String contactAddress1 = commView.addressLine1.getAttribute("value");
            String contactAddress2 = commView.addressLine2.getAttribute("value");
            String contactAddress3 = commView.addressLine3.getAttribute("value");
            String contactCity = commView.addressCityInputFld.getAttribute("value");
            String contactState = commView.addressStateInputFld.getAttribute("value");
            String contactPostal = commView.addressPostalInputFld.getAttribute("value");
            String contactCountry = commView.addressCountryInputFld.getAttribute("value");

            System.out.println("Original address for contact " + TEST_CONTACT_RECORD + " is as follows :");
            System.out.println("Address1 :  " + contactAddress1);
            System.out.println("Address2 :  " + contactAddress2);
            System.out.println("Address3 :  " + contactAddress3);
            System.out.println("City     :  " + contactCity);
            System.out.println("State    :  " + contactState);
            System.out.println("Postal   :  " + contactPostal);
            System.out.println("Country  :  " + contactCountry);


            //Step: clear and change the value of Postal for the contact's address, accept change and save contact
            commView.addressPostalInputFld.clear();
            commView.addressPostalInputFld.sendKeys("60688");
            String contactNewPostal = commView.addressPostalInputFld.getAttribute("value");
            System.out.println("Postal code for contact " + TEST_CONTACT_RECORD + " has been changed from " + contactPostal + " to : " + contactNewPostal);
            headerButton.clickHeaderButton("check");
            commNav.waitForPage("Contact");
            headerButton.clickHeaderButton("save");
            commNav.waitForPage(TEST_CONTACT_RECORD);
            System.out.println("VP: after editing a contact's address, contact saved as expected - PASSED");


            //Step: edit the contact again, and verify that the address fields have been retained as expected
            contactEditView = PageFactory.initElements(driver, ContactViewsElements.class);
            commView = PageFactory.initElements(driver, CommonViewsElements.class);

            headerButton.clickHeaderButton("edit");
            commNav.waitForPage("Contact");
            contactEditView.contactsEditViewAddressInputFldBtn.click();
            commNav.waitForPage("Address");

            String contactAddress1Recheck = commView.addressLine1.getAttribute("value");
            String contactAddress2Recheck = commView.addressLine2.getAttribute("value");
            String contactAddress3Recheck = commView.addressLine3.getAttribute("value");
            String contactCityRecheck = commView.addressCityInputFld.getAttribute("value");
            String contactStateRecheck = commView.addressStateInputFld.getAttribute("value");
            String contactPostalRecheck = commView.addressPostalInputFld.getAttribute("value");
            String contactCountryRecheck = commView.addressCountryInputFld.getAttribute("value");

            AssertJUnit.assertEquals("VP: Address1 has not been retained after saving contact ... it is now    : " + contactAddress1Recheck, contactAddress1, contactAddress1Recheck);
            System.out.println("VP: Address1 has been retained after saving contact as : " + contactAddress1Recheck);

            AssertJUnit.assertEquals("VP: Address2 has not been retained after saving contact ... it is now    : " + contactAddress2Recheck, contactAddress2, contactAddress2Recheck);
            System.out.println("VP: Address2 has been retained after saving contact as : " + contactAddress2Recheck);

            AssertJUnit.assertEquals("VP: Address3 has not been retained after saving contact ... it is now    : " + contactAddress3Recheck, contactAddress3, contactAddress3Recheck);
            System.out.println("VP: Address3 has been retained after saving contact as : " + contactAddress3Recheck);

            AssertJUnit.assertEquals("VP: City has not been retained after saving contact ... it is now        : " + contactCityRecheck, contactCity, contactCityRecheck);
            System.out.println("VP: City has been retained after saving contact as : " + contactCityRecheck);

            AssertJUnit.assertEquals("VP: State has not been retained after saving contact ... it is now       : " + contactStateRecheck, contactState, contactStateRecheck);
            System.out.println("VP: State has been retained after saving contact as : " + contactStateRecheck);

            AssertJUnit.assertEquals("VP: Postal code has not been retained after saving contact ... it is now : " + contactPostalRecheck, contactNewPostal, contactPostalRecheck);
            System.out.println("VP: Postal code has been retained after saving contact as : " + contactPostalRecheck);

            AssertJUnit.assertEquals("VP: Country has not been retained after saving contact ... it is now     : " + contactCountryRecheck, contactCountry, contactCountryRecheck);
            System.out.println("VP: Country has been retained after saving contact as : " + contactCountryRecheck);

            System.out.println("VP: no error trying to save edited address for contacts, and address data retained - PASSED");

        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: no error trying to save edited address for contacts - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test
    // MBL-10455 ... after editing lead address, most of address is disappearing
    public void test08_MBL10455() throws Exception {
        String methodID = "test08_MBL10455";

        //Test Parameters:
        String entityType = "Lead";
        String leadRecord = TEST_LEAD_RECORD;
        String viewName = "Lead Edit view";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: login & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        try {
            //Step: search for Lead entity, then open it's Edit view
            AssertJUnit.assertTrue(commNav.entityRecordEditView(entityType, leadRecord));

            //Step: open the lead's Address view and store current values for the Address
            LeadViewsElements leadEditView = PageFactory.initElements(driver, LeadViewsElements.class);
            CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);

            leadEditView.leadsEditViewAddressFldBtn.click();
            commNav.waitForPage("Address");
            String leadAddress1 = commView.addressLine1.getAttribute("value");
            String leadAddress2 = commView.addressLine2.getAttribute("value");
            String leadAddress3 = commView.addressLine3.getAttribute("value");
            String leadCity = commView.addressCityInputFld.getAttribute("value");
            String leadState = commView.addressStateInputFld.getAttribute("value");
            String leadPostal = commView.addressPostalInputFld.getAttribute("value");
            String leadCountry = commView.addressCountryInputFld.getAttribute("value");

            System.out.println("Original address for lead " + TEST_LEAD_RECORD + " is as follows :");
            System.out.println("Address1 :  " + leadAddress1);
            System.out.println("Address2 :  " + leadAddress2);
            System.out.println("Address3 :  " + leadAddress3);
            System.out.println("City     :  " + leadCity);
            System.out.println("State    :  " + leadState);
            System.out.println("Postal   :  " + leadPostal);
            System.out.println("Country  :  " + leadCountry);


            //Step: clear and change the value of Postal for the lead's address
            commView.addressPostalInputFld.clear();
            commView.addressPostalInputFld.sendKeys("60188-9422");
            String leadNewPostal = commView.addressPostalInputFld.getAttribute("value");
            System.out.println("Postal code for lead " + TEST_LEAD_RECORD + " has been changed from " + leadPostal + " to : " + leadNewPostal);

            //Step: set Address description to 'mailing', accept changes and save lead
            commView.addressDescriptionInputFld.clear();
            commView.addressDescriptionInputFld.sendKeys("Mailing");
            headerButton.clickHeaderButton("check");
            commNav.waitForPage("Lead");
            headerButton.clickHeaderButton("save");
            commNav.waitForPage(TEST_LEAD_RECORD);
            System.out.println("VP: after editing a lead's address, lead saved as expected - PASSED");


            //Step: edit the lead again, and verify that the address fields have been retained as expected
            leadEditView = PageFactory.initElements(driver, LeadViewsElements.class);
            commView = PageFactory.initElements(driver, CommonViewsElements.class);

            headerButton.clickHeaderButton("edit");
            commNav.waitForPage("Lead");
            leadEditView.leadsEditViewAddressFldBtn.click();
            commNav.waitForPage("Address");

            String leadAddress1Recheck = commView.addressLine1.getAttribute("value");
            String leadAddress2Recheck = commView.addressLine2.getAttribute("value");
            String leadAddress3Recheck = commView.addressLine3.getAttribute("value");
            String leadCityRecheck = commView.addressCityInputFld.getAttribute("value");
            String leadStateRecheck = commView.addressStateInputFld.getAttribute("value");
            String leadPostalRecheck = commView.addressPostalInputFld.getAttribute("value");
            String leadCountryRecheck = commView.addressCountryInputFld.getAttribute("value");

            AssertJUnit.assertEquals("VP: Address1 has not been retained after saving lead ... it is now    : " + leadAddress1Recheck, leadAddress1, leadAddress1Recheck);
            System.out.println("VP: Address1 has been retained after saving lead as : " + leadAddress1Recheck);

            AssertJUnit.assertEquals("VP: Address2 has not been retained after saving lead ... it is now    : " + leadAddress2Recheck, leadAddress2, leadAddress2Recheck);
            System.out.println("VP: Address2 has been retained after saving lead as : " + leadAddress2Recheck);

            AssertJUnit.assertEquals("VP: Address3 has not been retained after saving lead ... it is now    : " + leadAddress3Recheck, leadAddress3, leadAddress3Recheck);
            System.out.println("VP: Address3 has been retained after saving lead as : " + leadAddress3Recheck);

            AssertJUnit.assertEquals("VP: City has not been retained after saving lead ... it is now        : " + leadCityRecheck, leadCity, leadCityRecheck);
            System.out.println("VP: City has been retained after saving lead as : " + leadCityRecheck);

            AssertJUnit.assertEquals("VP: State has not been retained after saving lead ... it is now       : " + leadStateRecheck, leadState, leadStateRecheck);
            System.out.println("VP: State has been retained after saving lead as : " + leadStateRecheck);

            AssertJUnit.assertEquals("VP: Postal code has not been retained after saving lead ... it is now : " + leadPostalRecheck, leadNewPostal, leadPostalRecheck);
            System.out.println("VP: Postal code has been retained after saving lead as : " + leadPostalRecheck);

            AssertJUnit.assertEquals("VP: Country has not been retained after saving lead ... it is now     : " + leadCountryRecheck, leadCountry, leadCountryRecheck);
            System.out.println("VP: Country has been retained after saving lead as : " + leadCountryRecheck);

            System.out.println("VP: no error trying to save edited address for leads, and address data retained - PASSED");

        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: no error trying to save edited address for leads - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


}
