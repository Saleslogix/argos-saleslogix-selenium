package argos.saleslogix.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;


/**
 * @author Kathy Lockyer-Bratton
 *         Class: MobileSprint360
 *         Desc.: Test class for some defects or features in Mobile 3.7.0
 */
public class MobileSprint370 extends BaseTest {

    public String TEST_ACCOUNT_RECORD = "Abbott Ltd.";
    public String TEST_CONTACT_RECORD = "Abbott, John";
    public String TEST_LEAD_RECORD = "Beck, John";
    public String TEST_COMPANY_RECORD = "Rdi Group Inc";


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

        try {
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

        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println(methodID + ": unable to check or add email for ... '" + entityRecord + "' " + entityType);
            AssertJUnit.fail("test failed");
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

        try {
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
        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: history record created for lead after pressing 'Send email' QA on lead detail view - FAILED");
            AssertJUnit.fail("test failed");
        }

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

        try {

            //Step: search for an existing Lead record
            commNav.clickGlobalMenuItem("Leads");

            commNav.waitForPage("All Leads");
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
        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: history record created for lead after pressing email link on listview - FAILED");
            AssertJUnit.fail("test failed");
        }

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

        try {

            //Step: search for an existing Lead record
            commNav.clickGlobalMenuItem("Leads");

            commNav.waitForPage("All Leads");
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

            //Step: on the 'E-mail' insert history record, add some data to Notes
            String notesData = "Email sent for John Beck-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            notesHistoryInsertView.notesHistoryEditViewNotesInputFld.sendKeys(notesData);

            //Step: save the 'E-mail' history record, open the lead detail from listview, and refresh the lead detail view
            headerButton.saveButton.click();
            commNav.waitForPage("Leads");
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
        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: history record created for lead after pressing Email quick action on listview - FAILED");
            AssertJUnit.fail("test failed");
        }

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


        //Step: press the email link for the lead under group view
        commNav.highlightNClick(leadListView.johnBeckGroupViewEmailLink);
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

        try {

            //Step: navigate to Leads group
            commNav.clickGlobalMenuItem("Leads");
            commNav.waitForPage("All Leads");

            //Step: open quick actions for lead, and press the 'Email' quick action for the lead under group view
            leadListView.johnBeckGroupViewQuickActionBtn.click();
            commNav.highlightNClick(leadListView.leadGroupViewQuickActionEmailBtn);
            commNav.waitForPage("E-mail");

            //Step: on the 'E-mail' insert history record, add some data to Notes
            String notesData = "Email sent for John Beck-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            notesHistoryInsertView.notesHistoryEditViewNotesInputFld.sendKeys(notesData);

            //Step: on the 'E-mail' insert history record, verify expected lead and company are displaying
            System.out.println("VP: adding history record for lead '" + TEST_LEAD_RECORD + "', with Notes value of ... " + notesData);
            AssertJUnit.assertEquals("VP: expected lead '" + TEST_LEAD_RECORD + "' displaying on insert history record - FAILED", TEST_LEAD_RECORD, notesHistoryInsertView.notesHistoryEditViewLeadInputFld.getAttribute("value"));
            System.out.println("VP: expected lead '" + TEST_LEAD_RECORD + "' displaying on insert history record - PASSED");
            AssertJUnit.assertEquals("VP: expected company '" + TEST_COMPANY_RECORD + "' displaying on insert history record - FAILED", TEST_COMPANY_RECORD, notesHistoryInsertView.notesHistoryEditViewCompanyInputFld.getAttribute("value"));
            System.out.println("VP: expected company '" + TEST_COMPANY_RECORD + "' displaying on insert history record - PASSED");

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
        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: history record created for lead after pressing email quick action on group view - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    //INFORCRM-NoJira ... Leads group view : 'Call Work' quick action incorrectly initiating an email
    public void test07_INFORCRMNoJira() throws Exception {
        String methodID = "test07_INFORCRMNoJira";


        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        LeadViewsElements leadListView = PageFactory.initElements(driver, LeadViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        try {

            //Step: go to Leads group view
            commNav.clickGlobalMenuItem("Leads");
            commNav.waitForPage("All Leads");

            //Step: open quick actions for lead, and press the 'Call Work' quick action for the lead under group view
            leadListView.johnBeckGroupViewQuickActionBtn.click();
            commNav.highlightNClick(leadListView.leadGroupViewQuickActionCallWorkBtn);

            Thread.sleep(3000);
            String urlTelType = driver.getCurrentUrl().substring(0, 3);
            String urlTelephone = driver.getCurrentUrl().substring(4);

            //Step: verify that clicking the lead 'Call Work' quick action in leads group view results in a call being initiated
            AssertJUnit.assertEquals("VP: Lead group view - clicking the lead 'Call Work' quick action results in a call being initiated - FAILED", "tel", urlTelType);
            System.out.println("VP: Value of lead's Work Phone in browser address bar (would be called) is ... " + urlTelephone);
            System.out.println("VP: Lead group view - clicking the lead 'Call Work' quick action results in a call being initiated  - PASSED");


            closeBrowser();
            launchBrowser();
            doVerificationLogin();

            System.out.println(methodID + "- PASSED");

        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Lead group view : 'Call Work' quick action incorrectly initiating an email - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    //INFORCRM-NoJira ... Leads group view : 'Call Mobile' quick action incorrectly initiating an email
    public void test08_INFORCRMNoJira() throws Exception {
        String methodID = "test08_INFORCRMNoJira";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        LeadViewsElements leadListView = PageFactory.initElements(driver, LeadViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        try {

            //Step: go to Leads group view
            commNav.clickGlobalMenuItem("Leads");
            commNav.waitForPage("All Leads");

            //Step: open quick actions for lead, and press the 'Call Mobile' quick action for the lead under group view
            leadListView.johnBeckGroupViewQuickActionBtn.click();
            commNav.highlightNClick(leadListView.leadGroupViewQuickActionCallMobileBtn);

            Thread.sleep(3000);
            String urlTelType = driver.getCurrentUrl().substring(0, 3);
            String urlTelephone = driver.getCurrentUrl().substring(4);

            //Step: verify that clicking the lead 'Call Mobile' quick action in leads group view results in a call being initiated
            AssertJUnit.assertEquals("VP: Lead group view - clicking the lead 'Call Mobile' quick action results in a call being initiated - FAILED", "tel", urlTelType);
            System.out.println("VP: Value of lead's Mobile Phone in browser address bar (would be called) is ... " + urlTelephone);
            System.out.println("VP: Lead group view - clicking the lead 'Call Mobile' quick action results in a call being initiated  - PASSED");


            closeBrowser();
            launchBrowser();
            doVerificationLogin();

            System.out.println(methodID + "- PASSED");

        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Leads group view : 'Call Mobile' quick action incorrectly initiating an email - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
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

        try {

            //Step: search for an existing Lead record, to display in list view
            commNav.entityListViewSearch(entityType, entityRecord);

            //Step: click the lead's work phone link in list view
            commNav.highlightNClick(leadListView.topLeadsListItemCallWorkLink);

            Thread.sleep(3000);
            String urlTelType = driver.getCurrentUrl().substring(0, 3);
            String urlTelephone = driver.getCurrentUrl().substring(4);

            //Step: verify that clicking the lead work phone link in leads list view results in a call being initiated
            AssertJUnit.assertEquals("VP: Lead list view - clicking the lead work phone link results in a call being initiated - FAILED", "tel", urlTelType);
            System.out.println("VP: Value of lead's Work Phone in browser address bar (would be called) is ... " + urlTelephone);
            System.out.println("VP: Lead list view - clicking the lead work phone link results in a call being initiated  - PASSED");


            closeBrowser();
            launchBrowser();
            doVerificationLogin();

            System.out.println(methodID + "- PASSED");

        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Lead list view : work phone link incorrectly initiating an email - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
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

        try {

            //Step: search for an existing Lead record, to display in list view
            commNav.entityListViewSearch(entityType, entityRecord);

            //Step: click the lead's mobile phone link in list view
            commNav.highlightNClick(leadListView.topLeadsListItemCallMobileLink);

            Thread.sleep(3000);
            String urlTelType = driver.getCurrentUrl().substring(0, 3);
            String urlTelephone = driver.getCurrentUrl().substring(4);

            //Step: verify that clicking the lead mobile phone link in leads list view results in a call being initiated
            AssertJUnit.assertEquals("VP: Lead list view - clicking the lead mobile phone link results in a call being initiated - FAILED", "tel", urlTelType);
            System.out.println("VP: Value of lead's Mobile Phone in browser address bar (would be called) is ... " + urlTelephone);
            System.out.println("VP: Lead list view - clicking the lead mobile phone link results in a call being initiated  - PASSED");


            closeBrowser();
            launchBrowser();
            doVerificationLogin();

            System.out.println(methodID + "- PASSED");

        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Lead list view : mobile phone link incorrectly initiating an email - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
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

        try {

            //Step: search for an existing Lead record, to display in list view
            commNav.entityListViewSearch(entityType, entityRecord);

            //Step: click the lead's 'Call Work' quick action in list view
            leadListView.topLeadsListItemIcon.click();
            commNav.highlightNClick(leadListView.topLeadsListItemQuickActionsCallWorkBtn);

            Thread.sleep(3000);
            String urlTelType = driver.getCurrentUrl().substring(0, 3);
            String urlTelephone = driver.getCurrentUrl().substring(4);

            //Step: verify that clicking the lead 'Call Work' quick action in leads list view results in a call being initiated
            AssertJUnit.assertEquals("VP: Lead list view - clicking the lead 'Call Work' quick action results in a call being initiated - FAILED", "tel", urlTelType);
            System.out.println("VP: Value of lead's Work Phone in browser address bar (would be called) is ... " + urlTelephone);
            System.out.println("VP: Lead list view - clicking the lead 'Call Work' quick action results in a call being initiated  - PASSED");


            closeBrowser();
            launchBrowser();
            doVerificationLogin();

            System.out.println(methodID + "- PASSED");

        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Lead list view : 'Call Work' quick action incorrectly initiating an email - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
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

        try {

            //Step: search for an existing Lead record, to display in list view
            commNav.entityListViewSearch(entityType, entityRecord);

            //Step: click the lead's 'Call Mobile' quick action in list view
            leadListView.topLeadsListItemIcon.click();
            commNav.highlightNClick(leadListView.topLeadsListItemQuickActionsCallMobileBtn);

            Thread.sleep(3000);
            String urlTelType = driver.getCurrentUrl().substring(0, 3);
            String urlTelephone = driver.getCurrentUrl().substring(4);

            //Step: verify that clicking the lead 'Call Mobile' quick action in leads list view results in a call being initiated
            AssertJUnit.assertEquals("VP: Lead list view - clicking the lead 'Call Mobile' quick action results in a call being initiated - FAILED", "tel", urlTelType);
            System.out.println("VP: Value of lead's Mobile Phone in browser address bar (would be called) is ... " + urlTelephone);
            System.out.println("VP: Lead list view - clicking the lead 'Call Mobile' quick action results in a call being initiated  - PASSED");


            closeBrowser();
            launchBrowser();
            doVerificationLogin();

            System.out.println(methodID + "- PASSED");

        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Lead list view : 'Call Mobile' quick action incorrectly initiating an email - FAILED");
            AssertJUnit.fail("test failed");
        }

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

        try {


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
            Thread.sleep(1000);

            //Step: add an Activity record with a random value for 'regarding'
            String newActivityRegarding = "SeAutoTestActivity-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("Activity regarding field will be - " + newActivityRegarding);

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

            //Step: verify that the activity created displays for the currently selected day of the month
            WebElement activityItemLnk = driver.findElement(By.xpath("//*[@id='calendar_view']//h3[text() = '" + newActivityRegarding + "']"));
            if (commNav.isWebElementPresent(viewName + ", ActivityAdded ", activityItemLnk)) {
                System.out.println("VP: activity created for the currently selected day of the month, with no alarm set - PASSED");
            } else {
                System.out.println("VP: activity created for the currently selected day of the month, with no alarm set - FAILED");
                AssertJUnit.fail("test failed");
            }

            //Step: open and edit this activity, where 'alarm' is off
            activityItemLnk.click();
            commNav.waitForPage(newActivityRegarding);
            Thread.sleep(1000);
            headerButton.clickHeaderButton("Edit");
            commNav.waitForPage("Meeting");
            Thread.sleep(1000);

            //Step: verify that 'alarm' is turned off on the edit view
            List editAlarmToggle = driver.findElements(By.xpath("//div[@data-field='Alarm']//div[contains(@class,'toggleStateOn')]"));

            if (editAlarmToggle.size() != 0) {
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
        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println(methodID + "- FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    //Login & Logout
    //==============
    @Test(enabled = true)
    public void test00_MobileClient_Login() throws InterruptedException {
        String methodID = "test00_MobileClient_Login";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        Assert.assertTrue(doVerificationLogin());

        System.out.println(ENDLINE);
    }

    @Test(enabled = true)
    public void test99_Mobile_LogOut() throws InterruptedException {
        String methodID = "test99_Mobile_LogOut";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        doVerificationLogout();

        System.out.println(ENDLINE);
    }
}
