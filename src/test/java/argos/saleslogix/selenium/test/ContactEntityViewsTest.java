package argos.saleslogix.selenium.test;

import argos.saleslogix.selenium.CommonNavigation;
import argos.saleslogix.selenium.ContactViewsElements;
import argos.saleslogix.selenium.HeaderButton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


public class ContactEntityViewsTest extends BaseTest {

    public String TEST_CONTACT_RECORD = "Barbosa, Angelo";

    //Test Methods Set
    //================
    @Test(enabled = true)
    public void test01_SeTestTCContactListView() throws Exception {
        String methodID = "test01_SeTestTCContactListView";

        // Test Params:
        String entityType = "Contacts";
        String entityRecord = TEST_CONTACT_RECORD;

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: click Top-Left button to reveal Global Menu...
        headerbutton.showGlobalMenu();

        //Step: navigate to Contacts list view...
        commNav.entityListViewSearchContains(entityType, entityRecord);

        //Step: test Contacts, List View page elements
        // SubStep: check the Page Title
        try {
            AssertJUnit.assertTrue(commNav.isPageDisplayed(entityType));

            ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);

            //Step: check the Contacts list view format
            commNav.checkIfWebElementPresent("Contacts List View", contactsListView.contactsListView);

            //Step: check elements of a Contacts list view item record
            commNav.checkIfWebElementPresent("Contacts List View, item record", contactsListView.topContactsListItem);
            commNav.checkIfWebElementPresent("Contacts List View, item record icon", contactsListView.topContactsListItemIcon);
            commNav.checkIfWebElementPresent("Contacts List View, item record name", contactsListView.topContactsListItemName);
            commNav.checkIfWebElementPresent("Contacts List View, item record title & Account name", contactsListView.topContactsListItemLine2);
            commNav.checkIfWebElementPresent("Contacts List View, item record Work Phone", contactsListView.topContactsListItemLine3);
            commNav.checkIfWebElementPresent("Contacts List View, item record Mobile Phone", contactsListView.topContactsListItemLine4);
            commNav.checkIfWebElementPresent("Contacts List View, item record Email", contactsListView.topContactsListItemLine5);
            commNav.checkIfWebElementPresent("Contacts List View, item record touch widget", contactsListView.topContactsListItemTouch);

            //Step: check the Quick Action button and items
            try {
                //click Quick Action button to reveal Quick Action items
                commNav.checkIfWebElementPresent("Contacts List View, Quick Action button", contactsListView.topContactsListItemQuickActionsBtn);
                contactsListView.topContactsListItemQuickActionsBtn.click();

                //click the Quick Action button, then check each of the Quick Action items
                commNav.checkIfWebElementPresent("Contact, Quick Action button", contactsListView.topContactsListItemQuickActionsAddAttachmentBtn);
                commNav.checkIfWebElementPresent("Contact, Quick Action button", contactsListView.topContactsListItemQuickActionsAddActivityBtn);
                commNav.checkIfWebElementPresent("Contact, Quick Action button", contactsListView.topContactsListItemQuickActionsAddNoteBtn);
                commNav.checkIfWebElementPresent("Contact, Quick Action button", contactsListView.topContactsListItemQuickActionsEmailBtn);
                commNav.checkIfWebElementPresent("Contact, Quick Action button", contactsListView.topContactsListItemQuickActionsAccountBtn);
                commNav.checkIfWebElementPresent("Contact, Quick Action button", contactsListView.topContactsListItemQuickActionsCallMobileBtn);
                commNav.checkIfWebElementPresent("Contact, Quick Action button", contactsListView.topContactsListItemQuickActionsCallWorkBtn);
                commNav.checkIfWebElementPresent("Contact, Quick Action button", contactsListView.topContactsListItemQuickActionsEditBtn);

                //click Quick Action button to hide the Quick Action items
                contactsListView.topContactsListItemQuickActionsBtn.click();
            } catch (Exception e) {
                verificationErrors.append(methodID + "(): " + e.toString());
            }

            //Step: check the "X records remaining" item box at the bottom of the list view
            //commNav.checkIfWebElementPresent("Contacts List View, 'x remaining records' item", contactsListView.recordsRemainingListItem);
        } catch (Error e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println(methodID + ": required '" + entityType + "' not loaded; test aborted");
        }
        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    public void test02_SeTestTCContactListViewLoadMoreResults() throws Exception {
        String methodID = "test02_SeTestTCContactListViewLoadMoreResults";

        //Test Params:
        String entityType = "contacts";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: login & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: click Top-Left button to reveal Global Menu...
        headerbutton.showGlobalMenu();

        //Step: navigate to Contacts list view...
        commNav.clickGlobalMenuItemContacts();

        //capture the initial Contacts List view info
        ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
        String initListInfo = contactsListView.getContactsListViewTxt();

        //Step: load more results (click on 'x remaining records' item)
        for (int count = 1; count < 3; count++) {
            JavascriptExecutor jsx = (JavascriptExecutor) driver;
            jsx.executeScript("window.scrollBy(0,450)", "");
        }

        //capture the expanded Contacts List view
        String expandedListInfo = contactsListView.getContactsListViewTxt();

        //VP: confirm that the Contacts List view is indeed expanded with more record data
        String resultMsg = "VP: scrolling down the Contacts List view loaded more records";
        try {
            AssertJUnit.assertFalse(initListInfo.matches(expandedListInfo));
            System.out.println(resultMsg + " - Passed");
        } catch (Error e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println(resultMsg + " - Failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    public void test03_SeTestTCContactListViewSearch() throws Exception {
        String methodID = "test03_SeTestTCContactListViewSearch";

        // Test Params:
        String entityType = "Contacts";
        String entityRecord = TEST_CONTACT_RECORD;

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: search for an existing Contact record
        commNav.entityListViewSearch(entityType, entityRecord);

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    public void test04_SeTestTCContactListViewNegativeSearch() throws Exception {
        String methodID = "test04_SeTestTCContactListViewNegativeSearch";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: search for non-existent Contact record to confirm it's non-existence
        commNav.entityListViewNegativeSearch("Contacts", "Non-Existent Contact");

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    public void test05_SeTestTCContactListViewClearSearch() throws Exception {
        String methodID = "test05_SeTestTCContactListViewClearSearch";

        // Test Params:
        String entityType = "Contacts";
        String entityRecord = TEST_CONTACT_RECORD;

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        commNav.entityListViewSearch(entityType, entityRecord);

        //Step: check for matching results...
        ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
        String topContactListItemName = contactsListView.topContactsListItemName.getText();

        //Step: click the clear Search input field button
        headerButton.showRightContextMenu();
        contactsListView.contactsSearchClearBtn.click();

        //Step: click the Lookup button to reload the full Contacts list
        contactsListView.contactsSearchLookupBtn.click();
        Thread.sleep(3000);

        //Step: check if the previous search results were cleared
        String currTopContactsListViewName = driver.findElement(By.xpath("//*[@id='contact_list']/ul/li[1]/div/h3")).getText();
        try {
            AssertJUnit.assertEquals(topContactListItemName, currTopContactsListViewName);
        } catch (Error e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println(methodID + ": clear previous Contacts search results action failed");
            return;
        }

        System.out.println(methodID + ": clear previous Contacts search results action was successful");
        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    public void test06_SeTestTCContactListViewOpenRecord() throws Exception {
        String methodID = "test06_SeTestTCContactListViewOpenRecord";

        // Test Params:
        String entityType = "Contacts";
        String entityRecord = TEST_CONTACT_RECORD;

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: search for Contact entity, then open it's Detail view
        commNav.entityRecordOpenDetailView(entityType, entityRecord);

        //Step: go back to previous screen
        headerButton.goBack();
        Thread.sleep(3000);

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    public void test07_SeTestTCContactDetailView() throws Exception {
        String methodID = "test07_SeTestTCContactDetailView";

        //Test Parameters:
        String entityType = "Contacts";
        String contactRecord = TEST_CONTACT_RECORD;
        String viewName = "Contact Detail view";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        try {
            //Step: search for Contact entity, then open it's Detail view
            commNav.entityRecordOpenDetailView(entityType, contactRecord);

            ContactViewsElements contactDetailView = PageFactory.initElements(driver, ContactViewsElements.class);

            //Step: check each item under the Contact Detail View, Quick Actions section
            commNav.isWebElementPresent(viewName + ", 'Quick Actions' section header", contactDetailView.contactsDetailViewQuickActionsHdr);
            commNav.isWebElementPresent(viewName + ", 'Call main number'", contactDetailView.contactsDetailViewCallMainNumberLnk);
            commNav.isWebElementPresent(viewName + ", 'Call mobile'", contactDetailView.contactsDetailViewCallMobileLnk);
            commNav.isWebElementPresent(viewName + ", 'Send email'", contactDetailView.contactsDetailViewSendEmailLnk);
            commNav.verifyEntityViewElementClick(viewName + ", 'Schedule activity'", contactDetailView.contactsDetailViewScheduleActivityLnk, "Schedule...");
            commNav.isWebElementPresent(viewName + ", 'Add note'", contactDetailView.contactsDetailViewAddNoteLnk);
            commNav.isWebElementPresent(viewName + ", 'View address'", contactDetailView.contactsDetailViewViewAddressLnk);

            //Step: check each item under the Contact Detail View, Details section
            commNav.isWebElementPresent(viewName + ", 'Details' section header", contactDetailView.contactsDetailViewDetailsHdr);
            commNav.isFieldValueEmpty(viewName + ", 'contact'", contactDetailView.contactsDetailViewContactFld);
            commNav.isFieldValueEmpty(viewName + ", 'account'", contactDetailView.contactsDetailViewAccountFld);
            commNav.isFieldValueEmpty(viewName + ", 'web'", contactDetailView.contactsDetailViewWebFld);
            commNav.isFieldValueEmpty(viewName + ", 'title'", contactDetailView.contactsDetailViewTitleFld);

            //Step: check each item under the Contact Detail View, More Details section
            commNav.isWebElementPresent(viewName + ", 'More Details' section header", contactDetailView.contactsDetailViewMoreDetailsHdr);
            //SubStep: conditionally expand the More Details section
            if (contactDetailView.contactsDetailViewMoreDetailsFields.getSize().height < 1) {
                contactDetailView.contactsDetailViewMoreDetailsHdr.click();
                Thread.sleep(1000);
            }
            commNav.isFieldValueEmpty(viewName + ", 'home phone'", contactDetailView.contactsDetailViewHomePhoneFld);
            commNav.isFieldValueEmpty(viewName + ", 'fax'", contactDetailView.contactsDetailViewFaxFld);
            commNav.isFieldValueEmpty(viewName + ", 'acct mgr'", contactDetailView.contactsDetailViewAcctMgrFld);
            commNav.isFieldValueEmpty(viewName + ", 'owner'", contactDetailView.contactsDetailViewOwnerFld);
            commNav.isFieldValueEmpty(viewName + ", 'cuisine'", contactDetailView.contactsDetailViewCuisineFld);

            //Step: check each item under the Contact Detail View, Related Items section
            commNav.isWebElementPresent(viewName + ", 'Related Items' section header", contactDetailView.contactsDetailViewRelatedItemsHdr);
            commNav.verifyEntityViewElementClick(viewName + ", 'Activities'", contactDetailView.contactsDetailViewActivitiesLnk, "Activities");
            commNav.verifyEntityViewElementClick(viewName + ", 'Opportunities'", contactDetailView.contactsDetailViewOpportunitiesLnk, "Opportunities");
            commNav.verifyEntityViewElementClick(viewName + ", 'Tickets'", contactDetailView.contactsDetailViewTicketsLnk, "Tickets");
            commNav.verifyEntityViewElementClick(viewName + ", 'Notes/History'", contactDetailView.contactsDetailViewNotesHistoryLnk, "Notes/History");
            commNav.verifyEntityViewElementClick(viewName + ", 'Addresses'", contactDetailView.contactsDetailViewAddressesLnk, "Addresses");
            commNav.verifyEntityViewElementClick(viewName + ", 'Attachments'", contactDetailView.contactsDetailViewAttachmentsLnk, "Contact Attachments");
        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println(methodID + ": the Contact Detail view for the '" + contactRecord + "' Contact record; test aborted.");
        }

        //Step: go back to previous screen
        headerButton.goBack();
        commNav.waitForPage("Contacts");

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    public void test08_SeTestTCContactEditView() throws Exception {
        String methodID = "test08_SeTestTCContactEditView";

        //Test Parameters:
        String entityType = "Contact";
        String contactRecord = TEST_CONTACT_RECORD;
        String viewName = "Contact Edit view";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        try {
            //Step: search for Contact entity, then open it's Detail view
            AssertJUnit.assertTrue(commNav.entityRecordEditView(entityType, contactRecord));

            //Step: check each input field and if applicable, its related list item selection view
            ContactViewsElements contactEditView = PageFactory.initElements(driver, ContactViewsElements.class);

            //Step: check each input field and if applicable, its related list item selection view
            commNav.isWebElementPresent(viewName + ", 'Details' section header", contactEditView.contactsEditViewDetailsHdr);
            commNav.isFieldValueEmpty(viewName + ", name field", contactEditView.contactsEditViewNameInputFld);
            commNav.isFieldValueEmpty(viewName + ", account field", contactEditView.contactsEditViewAccountInputFld);
            commNav.isFieldValueEmpty(viewName + ", web field", contactEditView.contactsEditViewWebInputFld);
            commNav.isFieldValueEmpty(viewName + ", phone field", contactEditView.contactsEditViewPhoneInputFld);
            commNav.isFieldValueEmpty(viewName + ", email field", contactEditView.contactsEditViewEmailInputFld);
            commNav.isFieldValueEmpty(viewName + ", title field", contactEditView.contactsEditViewTitleInputFld);
            commNav.verifyEntityViewElementClick(viewName + ",'address field'", contactEditView.contactsEditViewAddressInputFldBtn, "Address");
            commNav.isFieldValueEmpty(viewName + ", home phone field", contactEditView.contactsEditViewHomePhoneInputFld);
            commNav.isFieldValueEmpty(viewName + ", mobile field", contactEditView.contactsEditViewMobileInputFld);
            commNav.isFieldValueEmpty(viewName + ", fax field", contactEditView.contactsEditViewFaxInputFld);
            commNav.verifyEntityViewElementClick(viewName + ",'account manager field'", contactEditView.contactsEditViewAcctMgrInputFld, "Users");
            contactEditView = PageFactory.initElements(driver, ContactViewsElements.class);
            commNav.verifyEntityViewElementClick(viewName + ",'owner field'", contactEditView.contactsEditViewOwnerInputFldBtn, "Owners");
            commNav.verifyEntityViewElementClick(viewName + ",'cuisine field'", contactEditView.contactsEditViewCuisineInputFldBtn, "Cuisine");

            //end of test
            headerButton.clickCancel();

            //Step: go back to previous screen
            headerButton.goBack();
            Thread.sleep(2000);
        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    public void test09_SeTestTCContactAddEditView() throws Exception {
        String methodID = "test09_SeTestTCContactAddEditView";

        // Test Params:
        String entityType = "Contact";
        String viewName = "Contact Add Edit view";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        try {
            //Step: enter the Contact Add Edit view...
            commNav.entityRecordAdd(entityType);

            ContactViewsElements contactEditView = PageFactory.initElements(driver, ContactViewsElements.class);

            //Step: check each input field and if applicable, its related list item selection view
            commNav.isWebElementPresent(viewName + ", 'Details' section header", contactEditView.contactsEditViewDetailsHdr);
            commNav.isWebElementPresent(viewName + ", name field", contactEditView.contactsEditViewNameInputFld);
            commNav.isWebElementPresent(viewName + ", account field", contactEditView.contactsEditViewAccountInputFld);
            commNav.isWebElementPresent(viewName + ", web field", contactEditView.contactsEditViewWebInputFld);
            commNav.isWebElementPresent(viewName + ", phone field", contactEditView.contactsEditViewPhoneInputFld);
            commNav.isWebElementPresent(viewName + ", email field", contactEditView.contactsEditViewEmailInputFld);
            commNav.isWebElementPresent(viewName + ", title field", contactEditView.contactsEditViewTitleInputFld);
            commNav.verifyEntityViewElementClick(viewName + ",'address field'", contactEditView.contactsEditViewAddressInputFldBtn, "Address");
            commNav.isWebElementPresent(viewName + ", home phone field", contactEditView.contactsEditViewHomePhoneInputFld);
            commNav.isWebElementPresent(viewName + ", mobile field", contactEditView.contactsEditViewMobileInputFld);
            commNav.isWebElementPresent(viewName + ", fax field", contactEditView.contactsEditViewFaxInputFld);
            commNav.verifyEntityViewElementClick(viewName + ",'account manager field'", contactEditView.contactsEditViewAcctMgrInputFld, "Users");
            commNav.verifyEntityViewElementClick(viewName + ",'owner field'", contactEditView.contactsEditViewOwnerInputFldBtn, "Owners");
            commNav.verifyEntityViewElementClick(viewName + ",'cuisine field'", contactEditView.contactsEditViewCuisineInputFldBtn, "Cuisine");

            //end of test
            headerButton.clickCancel();

            //Step: go back to previous screen
            headerButton.goBack();
            Thread.sleep(2000);

            //Step: go back to previous screens
            headerButton.clickCancel();
            headerButton.goBack();
            Thread.sleep(2000);
        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println(methodID + ": unable to open the Contact Add Edit view.");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    public void test10_SeTestTCContactListViewHashTags() throws Exception {
        String methodID = "test10_SeTestTCContactListViewHashTags";

        // Test Params:
        String entityType = "Contacts";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: navigate to Contacts list view...
        commNav.clickGlobalMenuItemContacts();

        ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);

        //Step: reveal Right Context Menu panel
        headerButton.showRightContextMenu();

        //Step: test the Hash Tags header
        //expand the Hash Tags sub-panel if it's currently collapsed
        if (!contactsListView.contactsHashTagsPnl.isDisplayed()) {
            contactsListView.contactsHashTagsHdr.click();

            //confirm the the panel was indeed expanded
            try {
                AssertJUnit.assertTrue(contactsListView.contactsHashTagsPnl.isDisplayed());
            } catch (Error e) {
                verificationErrors.append(methodID + "(): " + e.toString());
                System.out.println(methodID + ": Hash Tags panel failed to expand on panel header click; test aborted.");
                return;
            }
        }
        //collapase the Hash Tags sub-panel
        contactsListView.contactsHashTagsHdr.click();
        try {
            AssertJUnit.assertFalse(contactsListView.contactsHashTagsPnl.isDisplayed());
            System.out.println("VP: Hash Tags sub-panel collapse check - Passed");

            //re-expand the Hash Tags sub-panel
            contactsListView.contactsHashTagsHdr.click();
            try {
                AssertJUnit.assertTrue(contactsListView.contactsHashTagsPnl.isDisplayed());
                System.out.println("VP: Hash Tags sub-panel expand check - Passed");
            } catch (Error e) {
                verificationErrors.append(methodID + "(): " + e.toString());
                System.out.println("VP: Hash Tags sub-panel expand check - FAILED");
            }
        } catch (Error e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Hash Tags sub-panel collapse check - FAILED");
        }

        //Step: test each of the pre-set Hash Tag items
        commNav.rightClickContextMenuItem("my-contacts");
        commNav.rightClickContextMenuItem("primary");
        commNav.rightClickContextMenuItem("not-primary");
        commNav.rightClickContextMenuItem("can-email");
        commNav.rightClickContextMenuItem("can-phone");
        commNav.rightClickContextMenuItem("can-fax");
        commNav.rightClickContextMenuItem("can-phone");
        commNav.rightClickContextMenuItem("can-mail");

        //Step: go back to previous screen
        headerButton.goBack();
        Thread.sleep(3000);

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    public void test11_SeTestTCContactListViewKPI() throws Exception {
        String methodID = "test11_SeTestTCContactListViewKPI";

        // Test Params:
        String entityType = "Contacts";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: navigate to Contacts list view...
        commNav.clickGlobalMenuItemContacts();

        ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);

        //Step: reveal Right Context Menu panel
        headerButton.showRightContextMenu();

        //Step: test the KPI header
        //expand the KPI sub-panel if it's currently collapsed
        if (!contactsListView.contactsKPIPnl.isDisplayed()) {
            contactsListView.contactsKPIHdr.click();

            //confirm the the panel was indeed expanded
            try {
                AssertJUnit.assertTrue(contactsListView.contactsHashTagsPnl.isDisplayed());
            } catch (Error e) {
                verificationErrors.append(methodID + "(): " + e.toString());
                System.out.println(methodID + ": Hash Tags panel failed to expand on panel header click; test aborted.");
                return;
            }
        }
        //collapse Hash Tags sub-panel check
        contactsListView.contactsKPIHdr.click();
        try {
            AssertJUnit.assertFalse(contactsListView.contactsKPIPnl.isDisplayed());
            System.out.println("VP: KPI sub-panel collapse check - Passed");

            //re-expand the Hash Tags sub-panel
            contactsListView.contactsKPIHdr.click();
            try {
                AssertJUnit.assertTrue(contactsListView.contactsKPIPnl.isDisplayed());
                System.out.println("VP: KPI sub-panel expand check - Passed");
            } catch (Error e) {
                verificationErrors.append(methodID + "(): " + e.toString());
                System.out.println("VP: KPI sub-panel e check - FAILED");
            }
        } catch (Error e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: KPI sub-panel collapse check - FAILED");
        }

        //Step: test each of the pre-set KPI items
        commNav.scrollDownPage();
        commNav.rightClickContextMenuItem("Total Contacts");

        //Step: go back to previous screen
        headerButton.closeRightContextMenu();
        headerButton.goBack();
        Thread.sleep(3000);

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    public void test12_SeTestTCContactListViewAddContact() throws Exception {
        String methodID = "test12_SeTestTCContactListViewAddContact";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: login & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);

        //Step: add a random test Contact record
        String newConLastName = "Andersen-" + new SimpleDateFormat("yyMMddHHmm").format(new GregorianCalendar().getTime());
        contactsListView.doAddRandTestContact(newConLastName, "Thomas", "AECOM");

        //Step: find the newly-added test Contact record
        String strResultsMsg = "VP: recently added test Contact '" + newConLastName + "' was found.";
        if (contactsListView.doSearchContact(newConLastName)) {
            System.out.println(strResultsMsg + " - Passed");
        } else {
            System.out.println(strResultsMsg + " - FAILED");
        }

        //Step: go back to My Activities view
        commNav.clickGlobalMenuItemMyActivities();

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    public void test13_SeTestTCContactListViewNotesBox() throws Exception {
        //Reference: MBL-10042
        String methodID = "test13_SeTestTCContactListViewNotesBox";

        // Test Params:
        String entityType = "Contacts";
        String expEntityPgTitle = "Contacts";
        String entityRecord = "Barbosa, Angelo";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: navigate to Contacts list view...
        commNav.entityListViewSearch(entityType, entityRecord);

        //Step: test Contacts, List View page elements
        // SubStep: check the Page Title
        if (commNav.isPageDisplayed(entityType)) {

            ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);

            //Step: check the Contacts list view format
            commNav.checkIfWebElementPresent("Contacts List View", contactsListView.contactsListView);

            //Step: check an Contact list view item record
            commNav.checkIfWebElementPresent("Contacts List View, Notes Box", contactsListView.contactsListViewNotesBox1stItem);
            commNav.checkIfWebElementPresent("Contacts List View, Notes Box item, Initials box", contactsListView.contactsListViewNotesBox1stItemInitialsBox);
            commNav.checkIfWebElementPresent("Contacts List View, Notes Box item, Regarding header", contactsListView.contactsListViewNotesBox1stItemRegarding);
            commNav.checkIfWebElementPresent("Contacts List View, Notes Box item, Last Activity note", contactsListView.contactsListViewNotesBox1stItemLastActivity);
            commNav.checkIfWebElementPresent("Contacts List View, Notes Box item, note item", contactsListView.contactsListViewNotesBox1stItemNotes);
            commNav.checkIfWebElementPresent("Contacts List View, Notes Box item, see list link", contactsListView.contactsListViewNotesBoxSeeListLink);

            //Step: check the Notes Box list item click navigation
            String expPgTitle = "Meeting";
            String resultsMsg = "VP: Clicking Notes Box item navigated to the expected page";
            try {
                //click the 1st Notes Box item
                contactsListView.contactsListViewNotesBox1stItem.click();
                Thread.sleep(5000);
                commNav.isPageDisplayed(expPgTitle);
                AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id='history_detail']")).isDisplayed());
                headerButton.goBack();
                Thread.sleep(2000);
                System.out.println(resultsMsg + " - Passed");

            } catch (Exception e) {
                verificationErrors.append(methodID + "(): " + e.toString());
                System.out.println(resultsMsg + " - Failed");
            }

            contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);

            //Step: check the Notes Box 'see list' link click navigation
            expPgTitle = "Notes";
            resultsMsg = "VP: Clicking Notes Box 'see list' link navigated to the expected page";
            try {
                //click the Notes Box 'see list' link
                contactsListView.contactsListViewNotesBoxSeeListLink.click();
                Thread.sleep(5000);
                commNav.isPageDisplayed(expPgTitle);
                AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id='history_related']")).isDisplayed());
                headerButton.goBack();
                Thread.sleep(2000);
                System.out.println(resultsMsg + " - Passed");

            } catch (Exception e) {
                verificationErrors.append(methodID + "(): " + e.toString());
                System.out.println(resultsMsg + " - Failed");
            }
        } else {
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
    public void test99_Mobile_LogOut() throws InterruptedException {
        String methodID = "test99_Mobile_LogOut";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        doVerificationLogout();

        System.out.println(ENDLINE);
    }

}
