package argos.saleslogix.selenium.test;

import argos.saleslogix.selenium.pages.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;


/**
 * Test class that defines test methods for the SLX Mobile Defect (v3.0.4 sprint 8) fixes.
 *
 * @author kathleen.lockyer-bratton@swiftpage.com
 * @version 1.0
 */
public class GroupsTest extends BaseTest {

    public String TEST_CONTACT_RECORD = "Abbott, John";
    public String TEST_TICKET_RECORD_NULL_CONTACT = "001-00-000002";

    @Test(enabled = true)
    // MBL-10514 ... Right Menu - Groups section disappearing per scenario
    public void test01_MBL10514() throws Exception {
        String methodID = "test01_MBL10514";

        // Test Params:
        String entityType = "accounts";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: login & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: navigate to Accounts list view...
        commNav.clickGlobalMenuItem(entityType);

        AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);

        //Step: perform a lookup for everything in Accounts ... switches to non-group mode
        // In Mobile 3.2 the lookup and clear buttons have been removed ... use Return and Backspace instead
        //accountsListView.accountsSearchLookupBtn.click();
        commView.lookupTxtBox.click();
        Thread.sleep(500);
        commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(500);
        commView.lookupTxtBox.sendKeys(Keys.RETURN);

        //Step: reveal Right Context Menu panel
        commNav.openGroupConfigure();
        headerButton.clickHeaderButton("cancel");
        commNav.waitForPage("Accounts");

        //Step: open right menu and verify that Groups header is still displayed
        headerButton.showRightContextMenu();

        //Step: verify that the Groups header is displayed
        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        AssertJUnit.assertTrue("VP: right menu Groups header is not displaying after opening and closing Configure - FAILED", commNav.isSettingsOpen());
        System.out.println("VP: right menu Groups header is still displaying after opening and closing Configure - PASSED");


        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // MBL-10519 ... Last group used mostly not being retained between login sessions

    public void test02_MBL10519() throws Exception {
        String methodID = "test02_MBL10519";

        // Test Params:
        String entityType = "accounts";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);


        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: navigate to Accounts list view...
        commNav.clickGlobalMenuItem(entityType);

        AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);

        //Step: click on Configure button to open 'Groups Lookup' and select 'My Accounts' for loup
        commNav.openGroupConfigure();
        accountsListView.groupsConfigureMyAccounts.click();
        headerButton.clickHeaderButton("check");
        commNav.waitForPage("All Accounts");

        //Step: open right menu and select 'My Accounts' group to display
        //headerButton.showRightContextMenu();
        commNav.openGroupSettings();
        accountsListView.rmenu_groupMyAccounts.click();
        commNav.waitForPage("My Accounts");

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
        //Step: navigate to Accounts list view...
        commNav.clickGlobalMenuItem(entityType);



        //Step: verify that group 'My Accounts' is displayed
        commNav.waitForPage("My Accounts");

        //Step: open right menu and select 'All Accounts' group to display again
        commNav.openGroupSettings();
        accountsListView.rmenu_groupAllAccounts.click();
        commNav.waitForPage("All Accounts");

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);
        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        headerButton = PageFactory.initElements(driver, HeaderButton.class);
        accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);

        //Step: navigate to Accounts list view...
        commNav.clickGlobalMenuItem(entityType);

        //Step: verify that group 'All Accounts' is displayed
        commNav.waitForPage("All Accounts");

        //Step: open right menu, choose Configure and uncheck 'My Accounts', so back to single default group of 'All Accounts'
        commNav.openGroupConfigure();
        accountsListView.groupsConfigureMyAccounts.click();
        headerButton.clickHeaderButton("check");
        commNav.waitForPage("All Accounts");

        System.out.println(ENDLINE);
    }


    @Test(enabled = false)
    // MBL-10524 ... For 'Authorized Contacts' group, Authorized displays a value of 'T', instead of Yes as in the web client

    public void test03_MBL10524() throws Exception {
        String methodID = "test03_MBL10524";

        // Test Params:
        String entityType = "contacts";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);


        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: navigate to Contacts list view...
        commNav.clickGlobalMenuItem(entityType);

        ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);

        //Step: click on Configure button to open 'Groups Lookup' and select 'Authorized Contacts' for loup
        commNav.openGroupConfigure();
        contactsListView.groupsConfigureAuthContacts.click();
        headerButton.clickHeaderButton("check");
        commNav.waitForPage("All Contacts");

        //Step: open right menu and select 'Authorized Contacts' group to display
        //headerButton.showRightContextMenu();
        commNav.openGroupSettings();
        contactsListView.rmenu_groupAuthContacts.click();
        commNav.waitForPage("Authorized Contacts");

        //headerButton = PageFactory.initElements(driver, HeaderButton.class);
        //headerButton.showRightContextMenu();
        commNav.setGroupDetailMode();
        commNav.waitForPage("Authorized Contacts");

        //Step: verify that for the Authorized value, a value of 'T' or 'F' does not display ... expecting Yes or No
        String authorizedValue = contactsListView.authContactsGroupTopAuthValue.getText();
        System.out.println("VP: 'Authorized' has a value of ... " + authorizedValue);

        if (authorizedValue == "T") {
            System.out.println("VP: Authorized has a value of 'T' - FAILED");
            AssertJUnit.fail("test failed");
        }

        if (authorizedValue == "F") {
            System.out.println("VP: Authorized has a value of 'F' - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println("VP: Authorized does not have a value of 'T' or 'F' - PASSED");


        //Step: open right menu, choose Configure and uncheck 'Authorized Contacts', so back to single default group of 'All Contacts'
        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
        commNav.openGroupConfigure();
        contactsListView.groupsConfigureAuthContacts.click();
        headerButton.clickHeaderButton("check");
        commNav.waitForPage("All Contacts");
        commNav.setGroupSummaryMode();
        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // MBL-10526 ... In 'Follow-Up' ticket group see 'Invalid date' for Completed Date, instead of just blank

    public void test04_MBL10526() throws Exception {
        String methodID = "test04_MBL10526";

        // Test Params:
        String entityType = "tickets";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);
        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        //Step: navigate to Tickets list view...
        commNav.clickGlobalMenuItem(entityType);

        TicketViewsElements ticketsListView = PageFactory.initElements(driver, TicketViewsElements.class);

        //Step: reveal Right Context Menu panel
        commNav.openGroupConfigure();
        ticketsListView.groupsConfigureFollowUp.click();
        headerButton.clickHeaderButton("check");
        commNav.waitForPage("All Open");

        //Step: open right menu and select 'Follow-Up' group to display
        commNav.openGroupSettings();
        ticketsListView.rmenu_groupFollowUp.click();
        commNav.waitForPage("Follow-Up");

        //Step: reveal Right Context Menu panel again, and choose 'Detail' layout ... right menu is still open?
        commNav.setGroupDetailMode();
        commNav.waitForPage("Follow-Up");
        ticketsListView = PageFactory.initElements(driver, TicketViewsElements.class);

        //Step: verify that the Completed Date value for the top ticket does not display 'Invalid date' ... should just be blank
        String completedDate = ticketsListView.followUpTicketsGroupTopComplDate.getText();
        System.out.println("VP: 'Top Completed Date' has a value of ... " + completedDate);
        AssertJUnit.assertEquals("VP: top Completed Date is not displaying as blank  - FAILED", "", completedDate);
        System.out.println("VP: top Completed Date is displaying as blank, not 'Invalid date' - PASSED");

        //Step: open right menu, choose Configure and uncheck 'Follow-Up', so back to single default group of 'All Open'
        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        ticketsListView = PageFactory.initElements(driver, TicketViewsElements.class);
        commNav.openGroupConfigure();
        ticketsListView.groupsConfigureFollowUp.click();
        headerButton.clickHeaderButton("check");
        commNav.waitForPage("All Open");
        commNav.setGroupSummaryMode();

        System.out.println(ENDLINE);
    }
}
