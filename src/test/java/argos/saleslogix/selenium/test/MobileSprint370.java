package argos.saleslogix.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;


/**
 * @author Kathy Lockyer-Bratton
 *         Class: MobileSprint360
 *         Desc.: Test class for some defects or features in Mobile 3.7.0
 */
public class MobileSprint370 extends BaseTest {
    public String TEST_LEAD_RECORD = "Beck, John";


    //Test Methods Set
    //================


    @Test(enabled = true)
    // Add email value for the lead if email is blank

    public void test01_AddEmailAddressIfNeeded() throws Exception {
        String methodID = "test01_AddEmailAddressIfNeeded";

        // Test Params:
        String entityType = "Lead";
        String entityRecord = TEST_LEAD_RECORD;

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: search for Lead entity, then open it's Edit view
        AssertJUnit.assertTrue(commNav.entityRecordEditView(entityType, entityRecord));

        LeadViewsElements leadEditView = PageFactory.initElements(driver, LeadViewsElements.class);

        //Step: add some data for the lead's email if it is blank, and save
        String leadNewEmail = "jbeck@gmail.com";
        if (leadEditView.leadsEditViewEmailInputFld.getAttribute("value").isEmpty()) {
            leadEditView.leadsEditViewEmailInputFld.click();
            leadEditView.leadsEditViewEmailInputFld.clear();
            leadEditView.leadsEditViewEmailInputFld.sendKeys(leadNewEmail);
            headerButton.clickHeaderButton("Save");
            commNav.waitForPage(entityRecord);
            System.out.println("VP: email value for lead '" + entityRecord + "' has been set to ... " + leadNewEmail);
        } else {
            System.out.println("VP: email value for lead '" + entityRecord + "' is already set to ... " + leadEditView.leadsEditViewEmailInputFld.getAttribute("value"));
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // INFORCRM-14569 ... Mobile - lead detail view : for 'Send email' quick action, history is not saved for the lead

    public void test02_INFORCRM14569() throws Exception {
        String methodID = "test02_INFORCRM14569";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        // Test Params:
        String entityType = "Lead";
        String entityRecord = TEST_LEAD_RECORD;

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: search for Lead entity, then open it's Detail view
        commNav.entityRecordOpenDetailView(entityType, entityRecord);

        LeadViewsElements leadDetailView = PageFactory.initElements(driver, LeadViewsElements.class);
        NotesHistoryViewsElements notesHistoryInsertView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);

        //Step: on the Lead Detail View, press the 'Send email' Quick Action
        commNav.highlightNClick(leadDetailView.leadsDetailViewSendEmailLnk);
        commNav.waitForPage("Note");

        //Step: on the 'E-mail' insert history record, add some data to Notes
        String notesData = "Email sent for John Beck-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
        notesHistoryInsertView.notesHistoryEditViewNotesInputFld.click();
        notesHistoryInsertView.notesHistoryEditViewNotesInputFld.sendKeys(notesData);

        //Step: save the 'E-mail' history record and refresh the lead detail view
        headerButton.saveButton.click();
        commNav.waitForPage(TEST_LEAD_RECORD);
        headerButton.refreshButton.click();

        //Step: verify that this 'E-mail' history record displays under the Lead Detail View, Related Items section
        commNav.highlightNClick(leadDetailView.leadsDetailViewRelatedItemsTab);
        leadDetailView.leadsDetailViewNotesHistoryLnk.click();
        commNav.waitForPage("Notes/History");

        List<WebElement> notesHistoryItemLnk = driver.findElements(By.xpath("//*[@id='history_related']//div[@class='note-text-item']//div[contains(text(), '" + notesData + "')]"));

        if (notesHistoryItemLnk.size() != 0) {
            System.out.println("VP: history record with Notes value of '" + notesData + "' created for lead '" + TEST_LEAD_RECORD + "' after pressing 'Send email' QA on lead detail view - PASSED");
        } else {
            System.out.println("VP: history record with Notes value of '" + notesData + "' created for lead '" + TEST_LEAD_RECORD + "' after pressing 'Send email' on lead detail view -  FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println("VP: history record created for lead after pressing 'Send email' QA on lead detail view - PASSED");
        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // INFORCRM-14570 ... Mobile - lead listview : when pressing email link, lead information not appearing in potential history record

    public void test03_INFORCRM14570() throws Exception {
        String methodID = "test03_INFORCRM14570";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
        LeadViewsElements leadListView = PageFactory.initElements(driver, LeadViewsElements.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        NotesHistoryViewsElements notesHistoryInsertView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: search for an existing Lead record
        commNav.clickGlobalMenuItem("Leads");

        commNav.waitForPage("All Leads");
        commNav.waitForListView();
        commView.clearToast();
        commView.lookupTxtBox.click();
        Thread.sleep(50);
        commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(50);
        commView.lookupTxtBox.sendKeys(TEST_LEAD_RECORD);
        Thread.sleep(50);
        commView.lookupTxtBox.sendKeys(Keys.RETURN);

        //Step: press the email link for the lead under listview
        commNav.highlightNClick(leadListView.topLeadsListItemEmailLink);
        commNav.waitForPage("Note");

        //Step: on the 'E-mail' insert history record, add some data to Notes
        String notesData = "Email sent for John Beck-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
        notesHistoryInsertView.notesHistoryEditViewNotesInputFld.sendKeys(notesData);

        //Step: save the 'E-mail' history record, open the lead detail from listview, and refresh the lead detail view
        headerButton.saveButton.click();
        commNav.waitForPage("Leads");

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .withTimeout(30, TimeUnit.SECONDS);
        wait.until((d) -> leadListView.topLeadsListItem.isDisplayed());
        leadListView.topLeadsListItem.click();
        commNav.waitForPage(TEST_LEAD_RECORD);
        headerButton.refreshButton.click();

        //Step: verify that this 'E-mail' history record displays under the Lead Detail View, Related Items section
        commNav.highlightNClick(leadListView.leadsDetailViewRelatedItemsTab);
        leadListView.leadsDetailViewNotesHistoryLnk.click();
        commNav.waitForPage("Notes/History");

        List<WebElement> notesHistoryItemLnk = driver.findElements(By.xpath("//*[@id='history_related']//div[@class='note-text-item']//div[contains(text(), '" + notesData + "')]"));

        if (notesHistoryItemLnk.size() != 0) {
            System.out.println("VP: history record with Notes value of '" + notesData + "' created for lead '" + TEST_LEAD_RECORD + "' after pressing email link for lead on list view - PASSED");
        } else {
            System.out.println("VP: history record with Notes value of '" + notesData + "' created for lead '" + TEST_LEAD_RECORD + "' after pressing email link for lead on list view -  FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println("VP: history record created for lead after pressing email link on listview - PASSED");
        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // INFORCRM-14570 ... Mobile - lead listview : when pressing email quick action, lead information not appearing in potential history record

    public void test04_INFORCRM14570() throws Exception {
        String methodID = "test04_INFORCRM14570";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
        LeadViewsElements leadListView = PageFactory.initElements(driver, LeadViewsElements.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        NotesHistoryViewsElements notesHistoryInsertView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: search for an existing Lead record
        commNav.clickGlobalMenuItem("Leads");
        commNav.waitForPage("All Leads");
        commView.clearToast();
        commView.lookupTxtBox.click();
        Thread.sleep(50);
        commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(50);
        commView.lookupTxtBox.sendKeys(TEST_LEAD_RECORD);
        Thread.sleep(50);
        commView.lookupTxtBox.sendKeys(Keys.RETURN);

        //Step: open quick actions for lead, and press the 'Email' quick action for the lead under listview
        leadListView.topLeadsListItemIcon.click();
        commNav.highlightNClick(leadListView.topLeadsListItemQuickActionsEmailBtn);
        commNav.waitForPage("Note");

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .withTimeout(5, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.visibilityOf(notesHistoryInsertView.notesHistoryEditViewNotesInputFld));

        //Step: on the 'E-mail' insert history record, add some data to Notes
        String notesData = "Email sent for John Beck-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
        notesHistoryInsertView.notesHistoryEditViewNotesInputFld.sendKeys(notesData);

        //Step: save the 'E-mail' history record, open the lead detail from listview, and refresh the lead detail view
        headerButton.saveButton.click();
        commNav.waitForPage("Leads");
        commNav.waitForListView();
        leadListView.topLeadsListItem.click();
        commNav.waitForPage(TEST_LEAD_RECORD);
        headerButton.refreshButton.click();

        //Step: verify that this 'E-mail' history record displays under the Lead Detail View, Related Items section
        commNav.highlightNClick(leadListView.leadsDetailViewRelatedItemsTab);
        leadListView.leadsDetailViewNotesHistoryLnk.click();
        commNav.waitForPage("Notes/History");

        List<WebElement> notesHistoryItemLnk = driver.findElements(By.xpath("//*[@id='history_related']//div[@class='note-text-item']//div[contains(text(), '" + notesData + "')]"));

        if (notesHistoryItemLnk.size() != 0) {
            System.out.println("VP: history record with Notes value of '" + notesData + "' created for lead '" + TEST_LEAD_RECORD + "' after pressing Email quick action for lead on list view - PASSED");
        } else {
            System.out.println("VP: history record with Notes value of '" + notesData + "' created for lead '" + TEST_LEAD_RECORD + "' after pressing Email quick action for lead on list view -  FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println("VP: history record created for lead after pressing Email quick action on listview - PASSED");
        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // INFORCRM-14570 ... Mobile - lead group view : when pressing email link, lead information not appearing in potential history record

    public void test05_INFORCRM14570() throws Exception {
        String methodID = "test05_INFORCRM14570";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        LeadViewsElements leadListView = PageFactory.initElements(driver, LeadViewsElements.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        NotesHistoryViewsElements notesHistoryInsertView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: navigate to Leads group
        commNav.clickGlobalMenuItem("Leads");
        commNav.waitForPage("All Leads");

        //Step: open right menu, and choose to display 'Detail' layout
        commNav.setGroupDetailMode();
        commNav.waitForPage("All Leads");
        commNav.waitForListView();

        //Step: press the email link for the lead under group view
        commNav.highlightNClick(leadListView.johnBeckGroupViewEmailLink);
        commNav.waitForPage("Note");

        //Step: on the 'E-mail' insert history record, add some data to Notes
        String notesData = "Email sent for John Beck-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
        notesHistoryInsertView.notesHistoryEditViewNotesInputFld.sendKeys(notesData);

        //Step: save the 'E-mail' history record, open the lead detail from group view, and refresh the lead detail view
        headerButton.saveButton.click();
        commNav.waitForPage("All Leads");

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .withTimeout(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(leadListView.johnBeckGroupViewCard));
        commNav.highlightNClick(leadListView.johnBeckGroupViewCard);
        commNav.waitForPage(TEST_LEAD_RECORD);
        headerButton.refreshButton.click();

        //Step: verify that this 'E-mail' history record displays under the Lead Detail View, Related Items section
        commNav.highlightNClick(leadListView.leadsDetailViewRelatedItemsTab);
        leadListView.leadsDetailViewNotesHistoryLnk.click();
        commNav.waitForPage("Notes/History");

        List<WebElement> notesHistoryItemLnk = driver.findElements(By.xpath("//*[@id='history_related']//div[@class='note-text-item']//div[contains(text(), '" + notesData + "')]"));

        if (notesHistoryItemLnk.size() != 0) {
            System.out.println("VP: history record with Notes value of '" + notesData + "' created for lead '" + TEST_LEAD_RECORD + "' after pressing email link for lead on group view - PASSED");
        } else {
            System.out.println("VP: history record with Notes value of '" + notesData + "' created for lead '" + TEST_LEAD_RECORD + "' after pressing email link for lead on group view -  FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println("VP: history record created for lead after pressing email link on group view - PASSED");
        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // INFORCRM-14570 ... Mobile - lead group view : when pressing email quick action, lead information not appearing in potential history record

    public void test06_INFORCRM14570() throws Exception {
        String methodID = "test06_INFORCRM14570";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        LeadViewsElements leadListView = PageFactory.initElements(driver, LeadViewsElements.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        NotesHistoryViewsElements notesHistoryInsertView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: navigate to Leads group
        commNav.clickGlobalMenuItem("Leads");
        commNav.waitForPage("All Leads");

        //Step: open quick actions for lead, and press the 'Email' quick action for the lead under group view
        leadListView.johnBeckGroupViewQuickActionBtn.click();
        commNav.highlightNClick(leadListView.leadGroupViewQuickActionEmailBtn);
        commNav.waitForPage("Note");

        //Step: on the 'E-mail' insert history record, add some data to Notes
        String notesData = "Email sent for John Beck-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
        notesHistoryInsertView.notesHistoryEditViewNotesInputFld.sendKeys(notesData);

        //Step: save the 'E-mail' history record, open the lead detail from group view, and refresh the lead detail view
        headerButton.saveButton.click();
        commNav.waitForPage("All Leads");
        commNav.highlightNClick(leadListView.johnBeckGroupViewCard);
        commNav.waitForPage(TEST_LEAD_RECORD);
        headerButton.refreshButton.click();

        //Step: verify that this 'E-mail' history record displays under the Lead Detail View, Related Items section
        commNav.highlightNClick(leadListView.leadsDetailViewRelatedItemsTab);
        leadListView.leadsDetailViewNotesHistoryLnk.click();
        commNav.waitForPage("Notes/History");

        List<WebElement> notesHistoryItemLnk = driver.findElements(By.xpath("//*[@id='history_related']//div[@class='note-text-item']//div[contains(text(), '" + notesData + "')]"));

        if (notesHistoryItemLnk.size() != 0) {
            System.out.println("VP: history record with Notes value of '" + notesData + "' created for lead '" + TEST_LEAD_RECORD + "' after pressing email quick action for lead on group view - PASSED");
        } else {
            System.out.println("VP: history record with Notes value of '" + notesData + "' created for lead '" + TEST_LEAD_RECORD + "' after pressing email quick action for lead on group view -  FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println("VP: history record created for lead after pressing email quick action on group view - PASSED");
        System.out.println(ENDLINE);
    }


    @Test(enabled = false)
    //INFORCRM-NoJira ... Leads group view : 'Call Work' quick action incorrectly initiating an email
    public void test07_INFORCRMNoJira() throws Exception {
        String methodID = "test07_INFORCRMNoJira";
        Wait<WebDriver> wait;

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        LeadViewsElements leadListView = PageFactory.initElements(driver, LeadViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: go to Leads group view
        commNav.clickGlobalMenuItem("Leads");
        commNav.waitForPage("All Leads");
        commNav.waitForListView();

        //Step: open quick actions for lead, and press the 'Call Work' quick action for the lead under group view

        leadListView.johnBeckGroupViewQuickActionBtn.click();
        wait = new FluentWait<>(driver)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(100, TimeUnit.MILLISECONDS);
        wait.until((driver) -> leadListView.leadGroupViewQuickActionCallWorkBtn.isEnabled());

        commNav.highlightNClick(leadListView.leadGroupViewQuickActionCallWorkBtn);

        // TODO: Ensure tel

        System.out.println(methodID + "- PASSED");
        System.out.println(ENDLINE);
    }


    @Test(enabled = false)
    //INFORCRM-NoJira ... Leads group view : 'Call Mobile' quick action incorrectly initiating an email
    public void test08_INFORCRMNoJira() throws Exception {
        String methodID = "test08_INFORCRMNoJira";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        LeadViewsElements leadListView = PageFactory.initElements(driver, LeadViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: go to Leads group view
        commNav.clickGlobalMenuItem("Leads");
        commNav.waitForPage("All Leads");
        commNav.waitForListView();

        //Step: open quick actions for lead, and press the 'Call Mobile' quick action for the lead under group view
        leadListView.johnBeckGroupViewQuickActionBtn.click();
        commNav.highlightNClick(leadListView.leadGroupViewQuickActionCallMobileBtn);

        // TODO: Ensure tel

        System.out.println(methodID + "- PASSED");
        System.out.println(ENDLINE);
    }


    @Test(enabled = false)
    //INFORCRM-NoJira ... Leads list view : work phone link incorrectly initiating an email
    public void test09_INFORCRMNoJira() throws Exception {
        String methodID = "test09_INFORCRMNoJira";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        LeadViewsElements leadListView = PageFactory.initElements(driver, LeadViewsElements.class);

        // Test Params:
        String entityType = "Leads";
        String entityRecord = TEST_LEAD_RECORD;

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: search for an existing Lead record, to display in list view
        commNav.entityListViewSearch(entityType, entityRecord);

        //Step: click the lead's work phone link in list view
        commNav.highlightNClick(leadListView.topLeadsListItemCallWorkLink);

        // TODO: Ensure tel

        System.out.println(methodID + "- PASSED");
        System.out.println(ENDLINE);
    }


    @Test(enabled = false)
    //INFORCRM-NoJira ... Leads list view : mobile phone link incorrectly initiating an email
    public void test10_INFORCRMNoJira() throws Exception {
        String methodID = "test10_INFORCRMNoJira";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        LeadViewsElements leadListView = PageFactory.initElements(driver, LeadViewsElements.class);

        // Test Params:
        String entityType = "Leads";
        String entityRecord = TEST_LEAD_RECORD;

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: search for an existing Lead record, to display in list view
        commNav.entityListViewSearch(entityType, entityRecord);

        //Step: click the lead's mobile phone link in list view
        commNav.highlightNClick(leadListView.topLeadsListItemCallMobileLink);

        // TODO: Ensure tel

        System.out.println(methodID + "- PASSED");
        System.out.println(ENDLINE);
    }


    @Test(enabled = false)
    //INFORCRM-NoJira ... Leads list view : 'Call Work' quick action incorrectly initiating an email
    public void test11_INFORCRMNoJira() throws Exception {
        String methodID = "test11_INFORCRMNoJira";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        LeadViewsElements leadListView = PageFactory.initElements(driver, LeadViewsElements.class);

        // Test Params:
        String entityType = "Leads";
        String entityRecord = TEST_LEAD_RECORD;

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: search for an existing Lead record, to display in list view
        commNav.entityListViewSearch(entityType, entityRecord);

        //Step: click the lead's 'Call Work' quick action in list view
        leadListView.topLeadsListItemIcon.click();
        commNav.highlightNClick(leadListView.topLeadsListItemQuickActionsCallWorkBtn);

        // TODO: Ensure tel

        System.out.println(methodID + "- PASSED");
        System.out.println(ENDLINE);
    }


    @Test(enabled = false)
    //INFORCRM-NoJira ... Leads list view : 'Call Mobile' quick action incorrectly initiating an email
    public void test12_INFORCRMNoJira() throws Exception {
        String methodID = "test12_INFORCRMNoJira";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        LeadViewsElements leadListView = PageFactory.initElements(driver, LeadViewsElements.class);

        // Test Params:
        String entityType = "Leads";
        String entityRecord = TEST_LEAD_RECORD;

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: search for an existing Lead record, to display in list view
        commNav.entityListViewSearch(entityType, entityRecord);

        //Step: click the lead's 'Call Mobile' quick action in list view
        leadListView.topLeadsListItemIcon.click();
        commNav.highlightNClick(leadListView.topLeadsListItemQuickActionsCallMobileBtn);

        // TODO: Ensure tel

        System.out.println(methodID + "- PASSED");
        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // INFORCRM-14930 ... Activities - edit view : 'reminder' field is enabled even though the 'alarm' field is turned off
    public void test13_INFORCRM14930() throws Exception {
        String methodID = "test13_INFORCRM14930";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);

        String viewName = "Calendar control";


        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: go to Calendar view ... wait for page Calendar
        commNav.clickGlobalMenuItem("Calendar");
        commNav.waitForPage("Calendar");

        //Step: click the Add header button to open Activity schedule view ... uses current day as default
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

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(5, SECONDS)
                .pollingEvery(50, MILLISECONDS);
        wait.until((d) -> activityEditView.activityEditViewRegardingFld.isEnabled());
        activityEditView.activityEditViewRegardingFld.click();
        Thread.sleep(100);
        activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);

        //Step: verify that 'alarm' is turned off by default on the insert view ... if not, turn it off
        List insertAlarmToggle = driver.findElements(By.xpath("//div[@data-field='Alarm']//div[contains(@class,'toggleStateOn')]"));

        if (insertAlarmToggle.size() != 0) {
            activityEditView.activityEditViewAlarmTgl.click();
            System.out.println("VP: Activity insert screen - 'alarm' toggle has been turned off");
        } else {
            System.out.println("VP: Activity insert screen - 'alarm' toggle is off by default");
        }

        //Step: verify that 'reminder' is disabled on the insert view, where 'alarm' is turned off
        if (activityEditView.activityEditViewAlarmFld.isEnabled()) {
            System.out.println("VP: Activity insert screen - 'reminder' field should be disabled when alarm toggle is off - FAILED");
            AssertJUnit.fail("test failed");
        } else {
            System.out.println("VP: Activity insert screen - 'reminder' field should be disabled when alarm toggle is off - PASSED");
        }

        //Step: Save activity
        headerButton.clickHeaderButton("Save");
        commNav.waitForPage("Calendar");
        wait = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(100, MILLISECONDS);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'activity-content ') and not(contains(@class, 'list-loading'))]")));

        //Step: verify that the activity created displays for the currently selected day of the month
        WebElement activityItemLnk = driver.findElement(By.xpath("//*[@id='calendar_view']//*[text() = '" + newActivityRegarding + "']"));
        if (commNav.isWebElementPresent(viewName + ", ActivityAdded ", activityItemLnk)) {
            System.out.println("VP: activity created for the currently selected day of the month, with no alarm set - PASSED");
        } else {
            System.out.println("VP: activity created for the currently selected day of the month, with no alarm set - FAILED");
            AssertJUnit.fail("test failed");
        }

        //Step: open and edit this activity, where 'alarm' is off
        activityItemLnk.click();
        commNav.waitForPage(newActivityRegarding);
        headerButton.clickHeaderButton("Edit");
        commNav.waitForPage("Activity");

        //Step: verify that 'alarm' is turned off on the edit view
        WebElement editAlarmToggle = driver.findElement(By.xpath("//input[@name='Alarm']"));

        if (editAlarmToggle.isSelected()) {
            System.out.println("VP: Activity edit screen - 'alarm' toggle should be turned off - FAILED");
            AssertJUnit.fail("test failed");
        } else {
            System.out.println("VP: Activity edit screen - 'alarm' toggle should be turned off - PASSED");
        }

        //Step: verify that 'reminder' is disabled on the edit view, where 'alarm' is turned off
        if (activityEditView.activityEditViewAlarmFld.isEnabled()) {
            System.out.println("VP: Activity edit screen - 'reminder' field should be disabled when alarm toggle is off - FAILED");
            AssertJUnit.fail("test failed");
        } else {
            System.out.println("VP: Activity edit screen - 'reminder' field should be disabled when alarm toggle is off - PASSED");
        }

        System.out.println(methodID + "- PASSED");
        System.out.println(ENDLINE);
    }
}
