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
 * Test class that defines test methods for the SLX Mobile Defect (v3.0.4 sprint 8) fixes.
 * 
 * @author kathleen.lockyer-bratton@swiftpage.com
 * @version	1.0
 */
public class GroupsTest extends BaseTest {

    public String TEST_CONTACT_RECORD = "Abbott, John";
    public String TEST_TICKET_RECORD_NULL_CONTACT = "001-00-000002";

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
        headerButton.showRightContextMenu();

        //Step: verify that the Groups header is displayed
        AssertJUnit.assertTrue("VP: right menu Groups header is not displaying after a 'lookup' - FAILED", commNav.rmenu_GroupHdr.isDisplayed());
        System.out.println("VP: right menu Groups header is displaying after a 'lookup' - PASSED");

        //Step: click on Configure button to open 'Groups Lookup', then simply cancel
        commNav.rmenu_GroupConfigure.click();
        commNav.waitForPage("Groups Lookup");
        headerButton.cancelButton.click();
        commNav.waitForPage("Accounts");

        //Step: open right menu and verify that Groups header is still displayed
        headerButton.showRightContextMenu();

        //Step: verify that the Groups header is displayed
        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        AssertJUnit.assertTrue("VP: right menu Groups header is not displaying after opening and closing Configure - FAILED", commNav.rmenu_GroupHdr.isDisplayed());
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

        //Step: reveal Right Context Menu panel
        headerButton.showRightContextMenu();

        //Step: click on Configure button to open 'Groups Lookup' and select 'My Accounts' for loup
        commNav.rmenu_GroupConfigure.click();
        commNav.waitForPage("Groups Lookup");
        accountsListView.groupsConfigureMyAccounts.click();
        headerButton.checkButton.click();
        commNav.waitForPage("All Accounts");

        //Step: open right menu and select 'My Accounts' group to display
        //headerButton.showRightContextMenu();
        accountsListView.rmenu_groupMyAccounts.click();
        commNav.waitForPage("My Accounts");

        //Step: verify that group 'My Accounts' is displayed
        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        AssertJUnit.assertEquals("VP: user is not seeing the chosen group (My Accounts) just selected  - FAILED","My Accounts", driver.findElement(By.id("pageTitle")).getText());
        System.out.println("VP: user is seeing the chosen group (My Accounts) just selected  - PASSED");

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: navigate to Accounts list view...
        commNav.clickGlobalMenuItem(entityType);

        accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);

        //Step: verify that group 'My Accounts' is displayed
        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        AssertJUnit.assertEquals("VP: user is not seeing the last group (My Accounts) used in previous login session  - FAILED","My Accounts", driver.findElement(By.id("pageTitle")).getText());
        System.out.println("VP: user is seeing the last group (My Accounts) used in previous login session  - PASSED");

        //Step: open right menu and select 'All Accounts' group to display again
        headerButton.showRightContextMenu();
        accountsListView.rmenu_groupAllAccounts.click();
        commNav.waitForPage("All Accounts");

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: navigate to Accounts list view...
        commNav.clickGlobalMenuItem(entityType);

        accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);

        //Step: verify that group 'All Accounts' is displayed
        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        AssertJUnit.assertEquals("VP: user is not seeing the last group (All Accounts) used in previous login session  - FAILED","All Accounts", driver.findElement(By.id("pageTitle")).getText());
        System.out.println("VP: user is seeing the last group (All Accounts) used in previous login session  - PASSED");

        //Step: open right menu, choose Configure and uncheck 'My Accounts', so back to single default group of 'All Accounts'
        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        headerButton.showRightContextMenu();
        commNav.rmenu_GroupConfigure.click();
        commNav.waitForPage("Groups Lookup");
        accountsListView.groupsConfigureMyAccounts.click();
        headerButton.checkButton.click();
        commNav.waitForPage("All Accounts");
        headerButton.clickHeaderButton("right context menu");

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

        //Step: reveal Right Context Menu panel
        headerButton.showRightContextMenu();

        //Step: click on Configure button to open 'Groups Lookup' and select 'Authorized Contacts' for loup
        commNav.rmenu_GroupConfigure.click();
        commNav.waitForPage("Groups Lookup");
        contactsListView.groupsConfigureAuthContacts.click();
        headerButton.checkButton.click();
        commNav.waitForPage("All Contacts");

        //Step: open right menu and select 'Authorized Contacts' group to display
        //headerButton.showRightContextMenu();
        contactsListView.rmenu_groupAuthContacts.click();
        commNav.waitForPage("Authorized Contacts");

        //Step: reveal Right Context Menu panel again, and choose 'Detail' layout
        Thread.sleep(3000);
        //headerButton = PageFactory.initElements(driver, HeaderButton.class);
        //headerButton.showRightContextMenu();
        headerButton.rightCntxtMnuButton.click();
        commNav.rmenu_GroupDetail.click();
        commNav.waitForPage("Authorized Contacts");

        //Step: verify that for the Authorized value, a value of 'T' or 'F' does not display ... expecting Yes or No
        commNav = PageFactory.initElements(driver, CommonNavigation.class);
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
        //headerButton.showRightContextMenu();
        headerButton.rightCntxtMnuButton.click();
        commNav.rmenu_GroupConfigure.click();
        commNav.waitForPage("Groups Lookup");
        contactsListView.groupsConfigureAuthContacts.click();
        headerButton.checkButton.click();
        commNav.waitForPage("All Contacts");
        commNav.rmenu_GroupSummary.click();
        //headerButton.closeRightContextMenu();
        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // MBL-10526 ... In 'Follow-Up' ticket group see 'Invalid date' for Completed Date, instead of just blank

    public void test04_MBL10526() throws Exception {
        String methodID = "test04_MBL10526";

        // Test Params:
        String entityType = "tickets";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);


        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: navigate to Tickets list view...
        commNav.clickGlobalMenuItem(entityType);

        TicketViewsElements ticketsListView = PageFactory.initElements(driver, TicketViewsElements.class);

        //Step: reveal Right Context Menu panel
        headerButton.showRightContextMenu();

        //Step: click on Configure button to open 'Groups Lookup' and select 'Follow-Up' for loup
        commNav.rmenu_GroupConfigure.click();
        commNav.waitForPage("Groups Lookup");
        ticketsListView.groupsConfigureFollowUp.click();
        headerButton.checkButton.click();
        commNav.waitForPage("All Open");

        //Step: open right menu and select 'Follow-Up' group to display
        //headerButton.showRightContextMenu();
        ticketsListView.rmenu_groupFollowUp.click();
        commNav.waitForPage("Follow-Up");

        //Step: reveal Right Context Menu panel again, and choose 'Detail' layout ... right menu is still open?
        //headerButton.showRightContextMenu();
        commNav.rmenu_GroupDetail.click();
        commNav.waitForPage("Follow-Up");

        //Step: verify that the Completed Date value for the top ticket does not display 'Invalid date' ... should just be blank
        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        String completedDate = ticketsListView.followUpTicketsGroupTopComplDate.getText();
        System.out.println("VP: 'Top Completed Date' has a value of ... " + completedDate);
        AssertJUnit.assertEquals("VP: top Completed Date is not displaying as blank  - FAILED", "", completedDate);
        System.out.println("VP: top Completed Date is displaying as blank, not 'Invalid date' - PASSED");


        //Step: open right menu, choose Configure and uncheck 'Follow-Up', so back to single default group of 'All Open'
        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        ticketsListView = PageFactory.initElements(driver, TicketViewsElements.class);
        headerButton.showRightContextMenu();
        commNav.rmenu_GroupConfigure.click();
        commNav.waitForPage("Groups Lookup");
        ticketsListView.groupsConfigureFollowUp.click();
        headerButton.checkButton.click();
        commNav.waitForPage("All Open");
        commNav.rmenu_GroupSummary.click();
        //headerButton.closeRightContextMenu();

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
