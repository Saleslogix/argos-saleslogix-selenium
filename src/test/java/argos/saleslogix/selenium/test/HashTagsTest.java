package argos.saleslogix.selenium.test;

import argos.saleslogix.selenium.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;


public class HashTagsTest extends BaseTest {

    CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

    public void accountHashTagSelectNSearchCheck(String hashTagName, String searchVal) throws Exception {
        String methodID = "accountHashTagSelectNSearchCheck";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);


        //Step: navigate to Opportunity list view...
        commNav.clickGlobalMenuItem("Accounts");

        AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);

        //Step: reveal Right Context Menu panel
        headerButton.showRightContextMenu();
        prepHashTagsSubPanel();


        //SECTION 1:
        //Step: test the Hash Tag item
        String hashTagVal = hashTagName.toLowerCase();
        String hashTagSearchVal = "#" + hashTagVal;

        //capture the initial Accounts List view text
        String beforeAccountListViewTxt = accountsListView.getAccountsListViewTxt();

        //click the Hash Tag
        commNav.rightClickContextMenuItem(hashTagVal);
        String afterAccountListViewTxt = accountsListView.getAccountsListViewTxt();

        //compare the Account List
        String resultsMsg = "VP: '" + hashTagVal + "' Hash Tag successful load check";
        try {
            AssertJUnit.assertNotSame(beforeAccountListViewTxt, afterAccountListViewTxt);
            System.out.println(resultsMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resultsMsg + " - FAILED");
        }

        //SECTION 2:
        //Step: check the filled-in search input field value
        String resulstMsg = "VP: right-context menu search field value set to " + hashTagSearchVal;

        String accountSearchVal = accountsListView.accountsSearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertEquals(hashTagSearchVal, accountSearchVal);
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + accountSearchVal + "'");
        }


        //SECTION 3:
        //Step: perform a account record search on the name fields
        String regardingFldSearchVal = searchVal;
        String resultMsg = "VP: account record search for account field with '" + regardingFldSearchVal;
        String hashTagRecSrch = hashTagSearchVal + " " + regardingFldSearchVal;

        commNav.searchListView("account", hashTagRecSrch);
        try {
            AssertJUnit.assertTrue(commNav.isTextPresentOnPage(regardingFldSearchVal));
            System.out.println(resultMsg + "' - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resultMsg + "' - FAILED");
        }
    }


    public void contactHashTagSelectNSearchCheck(String hashTagName, String searchVal) throws Exception {
        String methodID = "contactHashTagSelectNSearchCheck";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);


        //Step: navigate to Contacts list view...
        commNav.clickGlobalMenuItem("Contacts");

        ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);

        //Step: reveal Right Context Menu panel
        headerButton.showRightContextMenu();
        prepHashTagsSubPanel();


        //SECTION 1:
        //Step: test the Hash Tag item
        String hashTagVal = hashTagName.toLowerCase();
        String hashTagSearchVal = "#" + hashTagVal;

        //capture the initial Contacts List view text
        String beforeContactListViewTxt = contactsListView.getContactsListViewTxt();

        //click the Hash Tag
        commNav.rightClickContextMenuItem(hashTagVal);
        Thread.sleep(3000);
        String afterContactListViewTxt = contactsListView.getContactsListViewTxt();

        //compare the Contact List
        String resultsMsg = "VP: '" + hashTagVal + "' Hash Tag successful load check";
        try {
            AssertJUnit.assertNotSame(beforeContactListViewTxt, afterContactListViewTxt);
            System.out.println(resultsMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resultsMsg + " - FAILED");
        }

        //SECTION 2:
        //Step: check the filled-in search input field value
        String resulstMsg = "VP: right-context menu search field value set to " + hashTagSearchVal;

        String contactSearchVal = contactsListView.contactsSearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertEquals(hashTagSearchVal, contactSearchVal);
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + contactSearchVal + "'");
        }


        //SECTION 3:
        //Step: perform a contact record search on a possible matching field value
        String fldSearchVal = searchVal;
        String resultMsg = "VP: contact record search for contact field with '" + fldSearchVal;
        String hashTagRecSrch = hashTagSearchVal + " " + fldSearchVal;

        commNav.searchListView("contact", hashTagRecSrch);
        try {
            AssertJUnit.assertTrue(commNav.isTextPresentOnPage(fldSearchVal));
            System.out.println(resultMsg + "' - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resultMsg + "' - FAILED");
        }
    }


    public void leadHashTagSelectNSearchCheck(String hashTagName, String searchVal) throws Exception {
        String methodID = "leadHashTagSelectNSearchCheck";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);


        //Step: navigate to Lead list view...
        commNav.clickGlobalMenuItem("Leads");

        LeadViewsElements leadsListView = PageFactory.initElements(driver, LeadViewsElements.class);

        //Step: reveal Right Context Menu panel
        headerButton.showRightContextMenu();
        prepHashTagsSubPanel();


        //SECTION 1:
        //Step: test the Hash Tag item
        String hashTagVal = hashTagName.toLowerCase();
        String hashTagSearchVal = "#" + hashTagVal;

        //capture the initial Lead List view text
        String beforeLeadListViewTxt = leadsListView.getLeadsListViewTxt();

        //click the Hash Tag
        commNav.rightClickContextMenuItem(hashTagVal);
        Thread.sleep(3000);
        String afterLeadListViewTxt = leadsListView.getLeadsListViewTxt();

        //compare the Contact List
        String resultsMsg = "VP: '" + hashTagVal + "' Hash Tag successful load check";
        try {
            AssertJUnit.assertNotSame(beforeLeadListViewTxt, afterLeadListViewTxt);
            System.out.println(resultsMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resultsMsg + " - FAILED");
        }

        //SECTION 2:
        //Step: check the filled-in search input field value
        String resulstMsg = "VP: right-context menu search field value set to " + hashTagSearchVal;

        String leadSearchVal = leadsListView.leadsSearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertEquals(hashTagSearchVal, leadSearchVal);
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + leadSearchVal + "'");
        }


        //SECTION 3:
        //Step: perform a lead record search on a possible matching field value
        String fldSearchVal = searchVal;
        String resultMsg = "VP: contact record search for lead field with '" + fldSearchVal;
        String hashTagRecSrch = hashTagSearchVal + " " + fldSearchVal;

        commNav.searchListView("lead", hashTagRecSrch);
        try {
            AssertJUnit.assertTrue(commNav.isTextPresentOnPage(fldSearchVal));
            System.out.println(resultMsg + "' - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resultMsg + "' - FAILED");
        }
    }


    public void notesHistoryHashTagSelectNSearchCheck(String hashTagName, String searchVal) throws Exception {
        String methodID = "notesHistoryHashTagSelectNSearchCheck";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);


        //Step: navigate to Notes/History list view...
        commNav.clickGlobalMenuItem("Notes/History");

        NotesHistoryViewsElements notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);

        //Step: reveal Right Context Menu panel
        headerButton.showRightContextMenu();
        prepHashTagsSubPanel();


        //SECTION 1:
        //Step: test the Hash Tag item
        String hashTagVal = hashTagName.toLowerCase();
        String hashTagSearchVal = "#" + hashTagVal;

        //capture the initial Notes/History List view text
        String beforeNotesHistoryListViewTxt = notesHistoryListView.getNotesHistoryListViewTxt();

        //click the Hash Tag
        commNav.rightClickContextMenuItem(hashTagVal);
        String afterNotesHistoryListViewTxt = notesHistoryListView.getNotesHistoryListViewTxt();

        //compare the Notes History List
        String resultsMsg = "VP: '" + hashTagVal + "' Hash Tag successful load check";
        try {
            AssertJUnit.assertNotSame(beforeNotesHistoryListViewTxt, afterNotesHistoryListViewTxt);
            System.out.println(resultsMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resultsMsg + " - FAILED");
        }

        //SECTION 2:
        //Step: check the filled-in search input field value
        String resulstMsg = "VP: right-context menu search field value set to " + hashTagSearchVal;

        String notesHistorySearchVal = notesHistoryListView.notesHistorysSearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertEquals(hashTagSearchVal, notesHistorySearchVal);
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + notesHistorySearchVal + "'");
        }


        //SECTION 3:
        //Step: perform a notes/history record search on the Regarding field
        String regardingFldSearchVal = searchVal;
        String resultMsg = "VP: notes/history note search for Regarding field with '" + regardingFldSearchVal;
        String hashTagRecSrch = hashTagSearchVal + " " + regardingFldSearchVal;

        commNav.searchListView("notes/history", hashTagRecSrch);
        try {
            AssertJUnit.assertTrue(commNav.isTextPresentOnPage(regardingFldSearchVal));
            System.out.println(resultMsg + "' - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resultMsg + "' - FAILED");
        }
    }


    public void opportunityHashTagSelectNSearchCheck(String hashTagName, String searchVal) throws Exception {
        String methodID = "opportunityHashTagSelectNSearchCheck";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);


        //Step: navigate to Opportunity list view...
        commNav.clickGlobalMenuItem("Opportunity");

        OpportunityViewsElements opportunityListView = PageFactory.initElements(driver, OpportunityViewsElements.class);

        //Step: reveal Right Context Menu panel
        headerButton.showRightContextMenu();
        prepHashTagsSubPanel();


        //SECTION 1:
        //Step: test the Hash Tag item
        String hashTagVal = hashTagName.toLowerCase();
        String hashTagSearchVal = "#" + hashTagVal;

        //capture the initial Notes/History List view text
        String beforeOpportunityListViewTxt = opportunityListView.getOpportunityListViewTxt();

        //click the Hash Tag
        commNav.rightClickContextMenuItem(hashTagVal);
        String afterOpportunityListViewTxt = opportunityListView.getOpportunityListViewTxt();

        //compare the Opportunity List
        String resultsMsg = "VP: '" + hashTagVal + "' Hash Tag successful load check";
        try {
            AssertJUnit.assertNotSame(beforeOpportunityListViewTxt, afterOpportunityListViewTxt);
            System.out.println(resultsMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resultsMsg + " - FAILED");
        }

        //SECTION 2:
        //Step: check the filled-in search input field value
        String resulstMsg = "VP: right-context menu search field value set to " + hashTagSearchVal;

        String opportunitySearchVal = opportunityListView.opportunitySearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertEquals(hashTagSearchVal, opportunitySearchVal);
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + opportunitySearchVal + "'");
        }


        //SECTION 3:
        //Step: perform a opportunity record search on the Regarding field
        String regardingFldSearchVal = searchVal;
        String resultMsg = "VP: opportunity record search for Regarding field with '" + regardingFldSearchVal;
        String hashTagRecSrch = hashTagSearchVal + " " + regardingFldSearchVal;

        commNav.searchListView("opportunity", hashTagRecSrch);
        try {
            AssertJUnit.assertTrue(commNav.isTextPresentOnPage(regardingFldSearchVal));
            System.out.println(resultMsg + "' - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resultMsg + "' - FAILED");
        }
    }


    public void prepHashTagsSubPanel() {
        String methodID = "prepHashTagsSubPanel";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

        //expand the Hash Tags sub-panel if it's currently collapsed
        if (!commNav.rmenu_HashTagsSubPnl.isDisplayed()) {
            System.out.println(methodID + ": Hash Tags panel was initially collapsed; expanding panel for test...");
            commNav.rmenu_HashTagsHdr.click();

            //confirm the the sub-panel was indeed expanded
            try {
                AssertJUnit.assertTrue(commNav.rmenu_HashTagsSubPnl.isDisplayed());
            } catch (Error e) {
                System.out.println(methodID + "(): " + e.toString());
                System.out.println(methodID + ": Hash Tags panel failed to expand on panel header click; test aborted.");
                return;
            }
        }
    }


    //Test Methods
    //============
    @Test(enabled = false)
    public void test01_SeTestTCHashTagsNotesHistoryGeneral() throws Exception {
        String methodID = "test01_SeTestTCHashTagsNotesHistoryGeneral";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        // Test Params:
        String entityType = "Notes/History";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: navigate to Notes/History list view...
        commNav.clickGlobalMenuItem(entityType);

        NotesHistoryViewsElements notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);

        //Step: reveal Right Context Menu panel
        headerButton.showRightContextMenu();
        prepHashTagsSubPanel();


        //SECTION 1:
        //Step: test the Hash Tags header
        //collapse the Hash Tags sub-panel
        String resultsMsg = "VP: Hash Tags sub-panel collapse check";

        notesHistoryListView.notesHistoryHashTagsHdr.click();
        try {
            AssertJUnit.assertFalse(notesHistoryListView.notesHistoryHashTagsPnl.isDisplayed());
            System.out.println(resultsMsg + " - Passed");

            //re-expand the Hash Tags sub-panel
            resultsMsg = "VP: Hash Tags sub-panel expand check";

            notesHistoryListView.notesHistoryHashTagsHdr.click();
            try {
                AssertJUnit.assertTrue(notesHistoryListView.notesHistoryHashTagsPnl.isDisplayed());
                System.out.println(resultsMsg + " - Passed");
            } catch (Error e) {
                System.out.println(methodID + "(): " + e.toString());
                System.out.println(resultsMsg + " - FAILED");
            }
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resultsMsg + " - FAILED");
        }


        //SECTION 2:
        //Step: close Right-Context Menu
        headerButton.clickHeaderButton("right");

        //check to see that the Right-Context Menu is indeed closed
        // Verify the 'Right-Context Menu' left-screen displays...
        resultsMsg = "VP: Right-Context Menu panel expand check";

        try {
            AssertJUnit.assertFalse(driver.findElement(By.xpath(".//*[@id='right_drawer']/div")).isDisplayed());
            System.out.println(resultsMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resultsMsg + " - FAILED");
        }

        //Step: re-open Right-Context Menu (confirmation is handled in the method)
        headerButton.showRightContextMenu();

        //SECTION 3:
        //Step: test each of the pre-set Hash Tag items
        commNav.rightClickContextMenuItem("note");
        commNav.rightClickContextMenuItem("phonecall");
        commNav.rightClickContextMenuItem("meeting");
        commNav.rightClickContextMenuItem("personal");
        commNav.rightClickContextMenuItem("email");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test02_SeTestTCHashTagsNotesHistoryNotesHT() throws Exception {
        String methodID = "test02_SeTestTCHashTagsNotesHistoryNotesHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'note' hash tag
        notesHistoryHashTagSelectNSearchCheck("note", "Proposal");

        System.out.println(ENDLINE);
    }


    @Test(enabled = false)
    public void test03_SeTestTCHashTagsNotesHistoryPhonecallHT() throws Exception {
        String methodID = "test03_SeTestTCHashTagsNotesHistoryPhonecallHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'phonecall' hash tag
        notesHistoryHashTagSelectNSearchCheck("phonecall", "Lead Generation");

        System.out.println(ENDLINE);
    }


    @Test(enabled = false)
    public void test04_SeTestTCHashTagsNotesHistoryMeetinglHT() throws Exception {
        String methodID = "test04_SeTestTCHashTagsNotesHistoryMeetinglHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'meeting' hash tag
        notesHistoryHashTagSelectNSearchCheck("meeting", "Discuss opportunities");

        System.out.println(ENDLINE);
    }


    @Test(enabled = false)
    public void test05_SeTestTCHashTagsNotesHistoryMeetingHT() throws Exception {
        String methodID = "test05_SeTestTCHashTagsNotesHistoryMeetingHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'meeting' hash tag
        notesHistoryHashTagSelectNSearchCheck("meeting", "Discuss opportunities");

        System.out.println(ENDLINE);
    }


    @Test(enabled = false)
    public void test06_SeTestTCHashTagsNotesHistoryPersonalHT() throws Exception {
        String methodID = "test06_SeTestTCHashTagsNotesHistoryPersonalHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'personal' hash tag
        notesHistoryHashTagSelectNSearchCheck("personal", "Staff meeting");

        System.out.println(ENDLINE);
    }


    @Test(enabled = false)
    public void test07_SeTestTCHashTagsNotesHistoryEmailHT() throws Exception {
        String methodID = "test07_SeTestTCHashTagsNotesHistoryEmailHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'personal' hash tag
        notesHistoryHashTagSelectNSearchCheck("email", "Introductory Letter");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test08_SeTestTCHashTagsNotesHistoryStateRetention() throws Exception {
        String methodID = "test08_SeTestTCHashTagsNotesHistoryStateRetention";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        // Test Params:
        String entityType = "Notes/History";
        String hashTag = "email";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: navigate to Notes/History list view...
        commNav.clickGlobalMenuItem(entityType);

        NotesHistoryViewsElements notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);

        //Step: select the 'email' hash tag
        commNav.rightClickContextMenuItem(hashTag);

        //Step: check the filled-in search input field value
        String resulstMsg = "VP: right-context menu search field value set to " + hashTag;
        String notesHistorySearchVal = notesHistoryListView.notesHistorysSearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertEquals("#" + hashTag, notesHistorySearchVal);
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + notesHistorySearchVal + "'");
        }

        //Step: navigate back to the My Activities List view
        headerButton.goBack();

        //Step: navigate to Contacts List view...
        commNav.clickGlobalMenuItem("Contacts");

        //Step: navigate back to Notes/History list view...
        //commNav.clickGlobalMenuItem(entityType);
        headerButton.showGlobalMenu();
        WebElement notesHistoryItem = driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = 'Notes/History']"));
        //notesHistoryItem.click();
        commNav.highlightNClick(notesHistoryItem);

        //Step: re-open the Right-Context Menu
        headerButton.showRightContextMenu();

        notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);

        //Step: check the filled-in search input field value
        resulstMsg = "VP: right-context menu search field persistent value set to " + hashTag;
        notesHistorySearchVal = notesHistoryListView.notesHistorysSearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertEquals("#" + hashTag, notesHistorySearchVal);
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + notesHistorySearchVal + "'");
        }

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test09_SeTestTCHashTagsNotesHistoryMutalExclusivity() throws Exception {
        String methodID = "test09_SeTestTCHashTagsNotesHistoryMutalExclusivity";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);


        // Test Params:
        String entityType = "Notes/History";
        String hashTag = "note";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: navigate to Notes/History list view...
        commNav.clickGlobalMenuItem(entityType);

        NotesHistoryViewsElements notesHistoryListView = PageFactory.initElements(driver, NotesHistoryViewsElements.class);

        //Step: select the hash tag
        commNav.rightClickContextMenuItem(hashTag);

        //Step: check the filled-in search input field value
        String resulstMsg = "VP: right-context menu search field value set to " + hashTag;
        String notesHistorySearchVal = notesHistoryListView.notesHistorysSearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertEquals("#" + hashTag, notesHistorySearchVal);
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + notesHistorySearchVal + "'");
        }

        //Step: perform invalid Hash Tag combo search A: "#note#meeting"
        String hTagComboTxt = "#note #meeting";
        String resultsMsg = "VP: invalid combo Hash Tag search '" + hTagComboTxt + "'returned 'no records'";
        commNav.searchListView(entityType, hTagComboTxt);
        try {
            AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
            System.out.println(resultsMsg + " - Passed");
        } catch (Error e) {
            System.out.println(resultsMsg + " - FAILED");
        }

        //Step: perform invalid Hash Tag combo search B: "#phonecall#personal"
        hTagComboTxt = "#phonecall #personal";
        commNav.searchListView(entityType, hTagComboTxt);
        try {
            AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
            System.out.println(resultsMsg + " - Passed");
        } catch (Error e) {
            System.out.println(resultsMsg + " - FAILED");
        }

        //Step: perform invalid Hash Tag combo search C: "#meeting#email"
        hTagComboTxt = "#meeting #email";
        commNav.searchListView(entityType, hTagComboTxt);
        try {
            AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
            System.out.println(resultsMsg + " - Passed");
        } catch (Error e) {
            System.out.println(resultsMsg + " - FAILED");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = false)
    public void test10_SeTestTCHashTagsOpportunityGeneral() throws Exception {
        String methodID = "test10_SeTestTCHashTagsOpportunityGeneral";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        // Test Params:
        String entityType = "Opportunities";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: navigate to Opportunities list view...
        commNav.clickGlobalMenuItem(entityType);

        OpportunityViewsElements opportunityListView = PageFactory.initElements(driver, OpportunityViewsElements.class);

        //Step: reveal Right Context Menu panel
        headerButton.showRightContextMenu();
        prepHashTagsSubPanel();


        //SECTION 1:
        //Step: test the Hash Tags header
        //collapse the Hash Tags sub-panel
        String resultsMsg = "VP: Hash Tags sub-panel collapse check";
        opportunityListView.opportunityHashTagsHdr.click();
        try {
            AssertJUnit.assertFalse(opportunityListView.opportunityHashTagsPnl.isDisplayed());
            System.out.println(resultsMsg + " - Passed");

            //re-expand the Hash Tags sub-panel
            resultsMsg = "VP: Hash Tags sub-panel expand check";

            opportunityListView.opportunityHashTagsHdr.click();
            try {
                AssertJUnit.assertTrue(opportunityListView.opportunityHashTagsPnl.isDisplayed());
                System.out.println(resultsMsg + " - Passed");
            } catch (Error e) {
                System.out.println(methodID + "(): " + e.toString());
                System.out.println(resultsMsg + " - FAILED");
            }
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resultsMsg + " - FAILED");
        }


        //SECTION 2:
        //Step: close Right-Context Menu
        headerButton.clickHeaderButton("right");

        //check to see that the Right-Context Menu is indeed closed
        // Verify the 'Right-Context Menu' left-screen displays...
        resultsMsg = "VP: Right-Context Menu panel expand check";
        try {
            AssertJUnit.assertFalse(driver.findElement(By.xpath(".//*[@id='right_drawer']/div")).isDisplayed());
            System.out.println(resultsMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resultsMsg + " - FAILED");
        }

        //Step: re-open Right-Context Menu (confirmation is handled in the method)
        headerButton.showRightContextMenu();

        //SECTION 3:
        //Step: test each of the pre-set Hash Tag items
        commNav.rightClickContextMenuItem("open");
        commNav.rightClickContextMenuItem("won");
        commNav.rightClickContextMenuItem("lost");
        commNav.rightClickContextMenuItem("inactive");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test11_SeTestTCHashTagsOpportunityOpenHT() throws Exception {
        String methodID = "test11_SeTestTCHashTagsOpportunityOpenHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'open' hash tag for specific Opportunity
        opportunityHashTagSelectNSearchCheck("open", "Vegas Vision-Phase1");

        //Step: select and search on 'open' hash tag for specific Account
        opportunityHashTagSelectNSearchCheck("open", "Abbott Ltd.");

        System.out.println(ENDLINE);
    }


    @Test(enabled = false)
    public void test12_SeTestTCHashTagsOpportunityWonHT() throws Exception {
        String methodID = "test12_SeTestTCHashTagsOpportunityWonHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'won' hash tag for specific Opportunity
        opportunityHashTagSelectNSearchCheck("won", "Abbott Ltd.-Phase2");

        //Step: select and search on 'won' hash tag for specific Account
        opportunityHashTagSelectNSearchCheck("won", "Big Systems");

        System.out.println(ENDLINE);
    }


    @Test(enabled = false)
    public void test13_SeTestTCHashTagsOpportunityLostHT() throws Exception {
        String methodID = "test13_SeTestTCHashTagsOpportunityLostHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'lost' hash tag for specific Opportunity
        opportunityHashTagSelectNSearchCheck("lost", "AD Foods-Phase1");

        //Step: select and search on 'lost' hash tag for specific Account
        opportunityHashTagSelectNSearchCheck("lost", "Douglas Healthcare");

        System.out.println(ENDLINE);
    }


    @Test(enabled = false)
    public void test14_SeTestTCHashTagsOpportunityInactiveHT() throws Exception {
        String methodID = "test14_SeTestTCHashTagsOpportunityInactiveHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'open' hash tag for specific Opportunity
        opportunityHashTagSelectNSearchCheck("inactive", "Best Software-Phase1");

        //Step: select and search on 'open' hash tag for specific Account
        opportunityHashTagSelectNSearchCheck("inactive", "Equity Residential");

        System.out.println(ENDLINE);
    }


    @Test(enabled = false)
    public void test21_SeTestTCHashTagsOpportunityStateRetention() throws Exception {
        String methodID = "test21_SeTestTCHashTagsOpportunityStateRetention";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        // Test Params:
        String entityType = "Opportunity";
        String hashTag = "open";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: navigate to Opportunity list view...
        commNav.clickGlobalMenuItem(entityType);

        OpportunityViewsElements opportunityListView = PageFactory.initElements(driver, OpportunityViewsElements.class);

        //Step: select the 'open' hash tag
        commNav.rightClickContextMenuItem(hashTag);

        //Step: check the filled-in search input field value
        String resulstMsg = "VP: right-context menu search field value set to " + hashTag;
        String opportunitySearchVal = opportunityListView.opportunitySearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertEquals("#" + hashTag, opportunitySearchVal);
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + opportunitySearchVal + "'");
        }

        //Step: navigate back to the My Activities List view
        headerButton.goBack();

        //Step: navigate to Contacts List view...
        commNav.clickGlobalMenuItem("Contacts");

        //Step: navigate back to Opportunity list view...
        headerButton.showGlobalMenu();
        WebElement opportunityItem = driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = 'Opportunities']"));
        commNav.highlightNClick(opportunityItem);

        //Step: re-open the Right-Context Menu
        headerButton.showRightContextMenu();

        opportunityListView = PageFactory.initElements(driver, OpportunityViewsElements.class);

        //Step: check the filled-in search input field value
        resulstMsg = "VP: right-context menu search field persistent value set to " + hashTag;
        opportunitySearchVal = opportunityListView.opportunitySearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertEquals("#" + hashTag, opportunitySearchVal);
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + opportunitySearchVal + "'");
        }

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test22_SeTestTCHashTagsOpportunityMutalExclusivity() throws Exception {
        String methodID = "test22_SeTestTCHashTagsOpportunityMutalExclusivity";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

        // Test Params:
        String entityType = "Opportunity";
        String hashTag = "open";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: navigate to Opportunity list view...
        commNav.clickGlobalMenuItem(entityType);

        OpportunityViewsElements opportunityListView = PageFactory.initElements(driver, OpportunityViewsElements.class);

        //Step: select the hash tag
        commNav.rightClickContextMenuItem(hashTag);

        //Step: check the filled-in search input field value
        String resulstMsg = "VP: right-context menu search field value set to " + hashTag;
        String opportunitySearchVal = opportunityListView.opportunitySearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertEquals("#" + hashTag, opportunitySearchVal);
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + opportunitySearchVal + "'");
        }

        //Step: perform invalid Hash Tag combo search A: "#won#open"
        String hTagComboTxt = "#won #open";
        String resultsMsg = "VP: invalid combo Hash Tag search '" + hTagComboTxt + "'returned 'no records'";
        commNav.searchListView(entityType, hTagComboTxt);
        try {
            AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
            System.out.println(resultsMsg + " - Passed");
        } catch (Error e) {
            System.out.println(resultsMsg + " - FAILED");
        }

        //Step: perform invalid Hash Tag combo search B: "#open#lost"
        hTagComboTxt = "#open #lost";
        commNav.searchListView(entityType, hTagComboTxt);
        try {
            AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
            System.out.println(resultsMsg + " - Passed");
        } catch (Error e) {
            System.out.println(resultsMsg + " - FAILED");
        }

        //Step: perform invalid Hash Tag combo search C: "#open#inactive"
        hTagComboTxt = "#open #inactive";
        commNav.searchListView(entityType, hTagComboTxt);
        try {
            AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
            System.out.println(resultsMsg + " - Passed");
        } catch (Error e) {
            System.out.println(resultsMsg + " - FAILED");
        }

        //Step: perform invalid Hash Tag combo search C: "#won#lost"
        hTagComboTxt = "#won #lost";
        commNav.searchListView(entityType, hTagComboTxt);
        try {
            AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
            System.out.println(resultsMsg + " - Passed");
        } catch (Error e) {
            System.out.println(resultsMsg + " - FAILED");
        }

        //Step: perform invalid Hash Tag combo search C: "#won#inactive"
        hTagComboTxt = "#won #inactive";
        commNav.searchListView(entityType, hTagComboTxt);
        try {
            AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
            System.out.println(resultsMsg + " - Passed");
        } catch (Error e) {
            System.out.println(resultsMsg + " - FAILED");
        }

        //Step: perform invalid Hash Tag combo search C: "#lost#inactive"
        hTagComboTxt = "#lost #inactive";
        commNav.searchListView(entityType, hTagComboTxt);
        try {
            AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
            System.out.println(resultsMsg + " - Passed");
        } catch (Error e) {
            System.out.println(resultsMsg + " - FAILED");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = false)
    public void test27_SeTestTCHashTagsAccountGeneral() throws Exception {
        String methodID = "test27_SeTestTCHashTagsAccountGeneral";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        // Test Params:
        String entityType = "Accounts";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: navigate to Opportunities list view...
        commNav.clickGlobalMenuItem(entityType);

        AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);

        //Step: reveal Right Context Menu panel
        headerButton.showRightContextMenu();
        prepHashTagsSubPanel();


        //SECTION 1:
        //Step: test the Hash Tags header
        //collapse the Hash Tags sub-panel
        String resultsMsg = "VP: Hash Tags sub-panel collapse check";

        accountListView.accountHashTagsHdr.click();
        try {
            AssertJUnit.assertFalse(accountListView.accountHashTagsPnl.isDisplayed());
            System.out.println(resultsMsg + " - Passed");

            //re-expand the Hash Tags sub-panel
            resultsMsg = "VP: Hash Tags sub-panel expand check";

            accountListView.accountHashTagsHdr.click();
            try {
                AssertJUnit.assertTrue(accountListView.accountHashTagsPnl.isDisplayed());
                System.out.println(resultsMsg + " - Passed");
            } catch (Error e) {
                System.out.println(methodID + "(): " + e.toString());
                System.out.println(resultsMsg + " - FAILED");
            }
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resultsMsg + " - FAILED");
        }


        //SECTION 2:
        //Step: close Right-Context Menu
        headerButton.clickHeaderButton("right");

        //check to see that the Right-Context Menu is indeed closed
        // Verify the 'Right-Context Menu' left-screen displays...
        resultsMsg = "VP: Right-Context Menu panel expand check";

        try {
            AssertJUnit.assertFalse(driver.findElement(By.xpath(".//*[@id='right_drawer']/div")).isDisplayed());
            System.out.println(resultsMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resultsMsg + " - FAILED");
        }

        //Step: re-open Right-Context Menu (confirmation is handled in the method)
        headerButton.showRightContextMenu();

        //SECTION 3:
        //Step: test each of the pre-set Hash Tag items
        commNav.rightClickContextMenuItem("active");
        commNav.rightClickContextMenuItem("inactive");
        commNav.rightClickContextMenuItem("suspect");
        commNav.rightClickContextMenuItem("lead");
        commNav.rightClickContextMenuItem("prospect");
        commNav.rightClickContextMenuItem("customer");
        commNav.rightClickContextMenuItem("partner");
        commNav.rightClickContextMenuItem("vendor");
        commNav.rightClickContextMenuItem("influencer");
        commNav.rightClickContextMenuItem("competitor");

        System.out.println(ENDLINE);
    }


    @Test(enabled = false)
    public void test28_SeTestTCHashTagsAccountActiveHT() throws Exception {
        String methodID = "test28_SeTestTCHashTagsAccountActiveHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'active' hash tag for specific Account
        accountHashTagSelectNSearchCheck("active", "");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test29_SeTestTCHashTagsAccountInactiveHT() throws Exception {
        String methodID = "test29_SeTestTCHashTagsAccountInactiveHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'inactive' hash tag for specific Account
        accountHashTagSelectNSearchCheck("inactive", "");

        //Step: select and search on 'inactive' hash tag for specific Account
        accountHashTagSelectNSearchCheck("inactive", "American Tours");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test30_SeTestTCHashTagsAccountSuspectHT() throws Exception {
        String methodID = "test30_SeTestTCHashTagsAccountSuspectHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'suspect' hash tag for specific Account
        accountHashTagSelectNSearchCheck("suspect", "");

        //Step: select and search on 'suspect' hash tag for specific Account
        accountHashTagSelectNSearchCheck("suspect", "Call Color");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test31_SeTestTCHashTagsAccountLeadHT() throws Exception {
        String methodID = "test31_SeTestTCHashTagsAccountLeadHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'lead' hash tag for specific Account
        accountHashTagSelectNSearchCheck("lead", "");

        //Step: select and search on 'lead' hash tag for specific Account
        accountHashTagSelectNSearchCheck("lead", "Alexander Leathers");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test32_SeTestTCHashTagsAccountProspectHT() throws Exception {
        String methodID = "test32_SeTestTCHashTagsAccountProspectHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'prospect' hash tag for specific Account
        accountHashTagSelectNSearchCheck("prospect", "");

        //Step: select and search on 'prospect' hash tag for specific Account
        accountHashTagSelectNSearchCheck("prospect", "Artistic");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test33_SeTestTCHashTagsAccountCustomerHT() throws Exception {
        String methodID = "test33_SeTestTCHashTagsAccountCustomerHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'customer' hash tag for specific Account
        accountHashTagSelectNSearchCheck("customer", "");

        //Step: select and search on 'customer' hash tag for specific Account
        accountHashTagSelectNSearchCheck("customer", "AD Foods");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test34_SeTestTCHashTagsAccountPartnerHT() throws Exception {
        String methodID = "test34_SeTestTCHashTagsAccountPartnerHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'partner' hash tag for specific Account
        accountHashTagSelectNSearchCheck("partner", "");

        //Step: select and search on 'partner' hash tag for specific Account
        accountHashTagSelectNSearchCheck("partner", "Big Systems");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test35_SeTestTCHashTagsAccountVendorHT() throws Exception {
        String methodID = "test35_SeTestTCHashTagsAccountVendorHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'vendor' hash tag for specific Account
        accountHashTagSelectNSearchCheck("vendor", "");

        //Step: select and search on 'vendor' hash tag for specific Account
        accountHashTagSelectNSearchCheck("vendor", "Iomega");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test36_SeTestTCHashTagsAccountInfluencerHT() throws Exception {
        String methodID = "test36_SeTestTCHashTagsAccountInfluencerHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'influencer' hash tag for specific Account
        accountHashTagSelectNSearchCheck("influencer", "");

        //Step: select and search on 'influencer' hash tag for specific Account
        accountHashTagSelectNSearchCheck("influencer", "EMC");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test37_SeTestTCHashTagsAccountCompetitorHT() throws Exception {
        String methodID = "test37_SeTestTCHashTagsAccountCompetitorHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'competitor' hash tag for specific Account
        accountHashTagSelectNSearchCheck("competitor", "");

        //Step: select and search on 'competitor' hash tag for specific Account
        accountHashTagSelectNSearchCheck("competitor", "Mega Computers");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test38_SeTestTCHashTagsAccountStateRetention() throws Exception {
        String methodID = "test38_SeTestTCHashTagsAccountStateRetention";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        // Test Params:
        String entityType = "Accounts";
        String hashTag = "competitor";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: navigate to Accounts list view...
        commNav.clickGlobalMenuItem(entityType);

        AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);

        //Step: select the 'negotiation' hash tag
        commNav.rightClickContextMenuItem(hashTag);

        //Step: check the filled-in search input field value
        String resulstMsg = "VP: right-context menu search field value set to " + hashTag;
        String accountSearchVal = accountListView.accountsSearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertEquals("#" + hashTag, accountSearchVal);
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + accountSearchVal + "'");
        }

        //Step: navigate back to the My Activities List view
        headerButton.goBack();

        //Step: navigate to Contacts List view...
        commNav.clickGlobalMenuItem("Contacts");

        //Step: navigate back to Accounts list view...
        headerButton.showGlobalMenu();
        WebElement opportunityItem = driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = 'Accounts']"));
        commNav.highlightNClick(opportunityItem);

        //Step: re-open the Right-Context Menu
        headerButton.showRightContextMenu();

        accountListView = PageFactory.initElements(driver, AccountViewsElements.class);

        //Step: check the filled-in search input field value
        resulstMsg = "VP: right-context menu search field persistent value set to " + hashTag;
        accountSearchVal = accountListView.accountsSearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertEquals("#" + hashTag, accountSearchVal);
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + accountSearchVal + "'");
        }

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test39_SeTestTCHashTagsAccountMutalExclusivity() throws Exception {
        String methodID = "test39_SeTestTCHashTagsAccountMutalExclusivity";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

        // Test Params:
        String entityType = "Accounts";
        String hashTag = "active";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: navigate to Accounts list view...
        commNav.clickGlobalMenuItem(entityType);

        AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);

        //Step: select the hash tag
        commNav.rightClickContextMenuItem(hashTag);

        //Step: check the filled-in search input field value
        String resulstMsg = "VP: right-context menu search field value set to " + hashTag;
        String accountSearchVal = accountListView.accountsSearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertEquals("#" + hashTag, accountSearchVal);
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + accountSearchVal + "'");
        }

        //Step: perform invalid Hash Tag combo search A: "#inactive#active"
        String hTagComboTxt = "#inactive #active";
        String resultsMsg = "VP: invalid combo Hash Tag search '" + hTagComboTxt + "'returned 'no records'";
        commNav.searchListView(entityType, hTagComboTxt);
        try {
            AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
            System.out.println(resultsMsg + " - Passed");
        } catch (Error e) {
            System.out.println(resultsMsg + " - FAILED");
        }

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test40_SeTestTCHashTagsAccountTypeUnique() throws Exception {
        String methodID = "test40_SeTestTCHashTagsAccountTypeUnique";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

        // Test Params:
        String entityType = "Accounts";
        String hashTag = "suspect";
        String[] hTagTypeList = {"#suspect", "#lead", "#prospect", "#customer", "#partner", "#vendor", "#influencer", "#competitor"};
        String hTagComboTxt = hTagTypeList[0];
        String resultsMsg = "VP: Account Types combo Hash Tag search returned 'no records'";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: navigate to Accounts list view...
        commNav.clickGlobalMenuItem(entityType);

        AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);

        //Step: select the hash tag
        commNav.rightClickContextMenuItem(hashTag);

        //Step: check the filled-in search input field value
        String resulstMsg = "VP: right-context menu search field value set to " + hashTag;
        String accountSearchVal = accountListView.accountsSearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertEquals("#" + hashTag, accountSearchVal);
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + accountSearchVal + "'");
        }
        System.out.println(" ");

        //Step: perform Hash Tag combo search using #suspect and other types
        System.out.println(methodID + ": perform Hash Tag combo search using #suspect and other types...");
        hTagComboTxt = hTagTypeList[0];
        for (int iCount = 1; iCount < hTagTypeList.length; iCount++) {
            hTagComboTxt = hTagTypeList[0];
            hTagComboTxt = hTagComboTxt + " " + hTagTypeList[iCount];
            commNav.searchListView(entityType, hTagComboTxt);
            try {
                AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
                System.out.println(resultsMsg + " - Passed");
            } catch (Error e) {
                System.out.println(resultsMsg + " - FAILED");
            }
        }
        System.out.println(" ");

        //Step: perform Hash Tag combo search using #lead and other types
        System.out.println(methodID + ": perform Hash Tag combo search using #lead and other types...");
        for (int iCount = 2; iCount < hTagTypeList.length; iCount++) {
            hTagComboTxt = hTagTypeList[1];
            hTagComboTxt = hTagComboTxt + " " + hTagTypeList[iCount];
            commNav.searchListView(entityType, hTagComboTxt);
            try {
                AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
                System.out.println(resultsMsg + " - Passed");
            } catch (Error e) {
                System.out.println(resultsMsg + " - FAILED");
            }
        }
        System.out.println(" ");

        //Step: perform Hash Tag combo search using #prospect and other types
        System.out.println(methodID + ": perform Hash Tag combo search using #prospect and other types...");
        for (int iCount = 3; iCount < hTagTypeList.length; iCount++) {
            hTagComboTxt = hTagTypeList[2];
            hTagComboTxt = hTagComboTxt + " " + hTagTypeList[iCount];
            commNav.searchListView(entityType, hTagComboTxt);
            try {
                AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
                System.out.println(resultsMsg + " - Passed");
            } catch (Error e) {
                System.out.println(resultsMsg + " - FAILED");
            }
        }
        System.out.println(" ");

        //Step: perform Hash Tag combo search using #customer and other types
        System.out.println(methodID + ": perform Hash Tag combo search using #customer and other types...");
        for (int iCount = 4; iCount < hTagTypeList.length; iCount++) {
            hTagComboTxt = hTagTypeList[3];
            hTagComboTxt = hTagComboTxt + " " + hTagTypeList[iCount];
            commNav.searchListView(entityType, hTagComboTxt);
            try {
                AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
                System.out.println(resultsMsg + " - Passed");
            } catch (Error e) {
                System.out.println(resultsMsg + " - FAILED");
            }
        }
        System.out.println(" ");

        //Step: perform Hash Tag combo search using #partner and other types
        System.out.println(methodID + ": perform Hash Tag combo search using #partner and other types...");
        for (int iCount = 5; iCount < hTagTypeList.length; iCount++) {
            hTagComboTxt = hTagTypeList[4];
            hTagComboTxt = hTagComboTxt + " " + hTagTypeList[iCount];
            commNav.searchListView(entityType, hTagComboTxt);
            try {
                AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
                System.out.println(resultsMsg + " - Passed");
            } catch (Error e) {
                System.out.println(resultsMsg + " - FAILED");
            }
        }
        System.out.println(" ");

        //Step: perform Hash Tag combo search using #vendor and other types
        System.out.println(methodID + ": perform Hash Tag combo search using #vendor and other types...");
        for (int iCount = 6; iCount < hTagTypeList.length; iCount++) {
            hTagComboTxt = hTagTypeList[5];
            hTagComboTxt = hTagComboTxt + " " + hTagTypeList[iCount];
            commNav.searchListView(entityType, hTagComboTxt);
            try {
                AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
                System.out.println(resultsMsg + " - Passed");
            } catch (Error e) {
                System.out.println(resultsMsg + " - FAILED");
            }
        }
        System.out.println(" ");

        //Step: perform Hash Tag combo search using #influencer and other types
        System.out.println(methodID + ": perform Hash Tag combo search using #influencer and other types...");
        for (int iCount = 7; iCount < hTagTypeList.length; iCount++) {
            hTagComboTxt = hTagTypeList[6];
            hTagComboTxt = hTagComboTxt + " " + hTagTypeList[iCount];
            commNav.searchListView(entityType, hTagComboTxt);
            try {
                AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
                System.out.println(resultsMsg + " - Passed");
            } catch (Error e) {
                System.out.println(resultsMsg + " - FAILED");
            }
        }
        System.out.println(" ");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test41_SeTestTCHashTagsAccountActiveStatusType() throws Exception {
        String methodID = "test41_SeTestTCHashTagsAccountActiveStatusType";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

        // Test Params:
        String entityType = "Accounts";
        String hashTag = "active";
        String[] hTagTypeList = {"#suspect", "#lead", "#prospect", "#customer", "#partner", "#vendor", "#influencer", "#competitor"};
        String hTagComboTxt = "#" + hashTag;
        String resultsMsg = "VP: Account #active Status + Type combo Hash Tag search returned records";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: navigate to Accounts list view...
        commNav.clickGlobalMenuItem(entityType);

        AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);

        //Step: select the hash tag
        commNav.rightClickContextMenuItem(hashTag);

        //Step: check the filled-in search input field value
        String resulstMsg = "VP: right-context menu search field value set to " + hashTag;
        String accountSearchVal = accountListView.accountsSearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertEquals("#" + hashTag, accountSearchVal);
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + accountSearchVal + "'");
        }
        System.out.println(" ");

        //Step: perform Hash Tag combo search using #active and other types
        System.out.println(methodID + ": perform Hash Tag combo search using #active and other types...");
        for (int iCount = 0; iCount < hTagTypeList.length; iCount++) {
            hTagComboTxt = "#" + hashTag;
            hTagComboTxt = hTagComboTxt + " " + hTagTypeList[iCount];
            String accountListViewTxt = accountListView.getAccountsListViewTxt();
            commNav.searchListView(entityType, hTagComboTxt);
            Thread.sleep(2000);
            String searchResultsTxt = accountListView.getAccountsListViewTxt();
            try {
                AssertJUnit.assertTrue(!searchResultsTxt.equals(accountListViewTxt));
                System.out.println(resultsMsg + " - Passed");
            } catch (Error e) {
                System.out.println(methodID + "(): " + e.toString());
                System.out.println(resultsMsg + " - FAILED");
            }
        }
        System.out.println(" ");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test42_SeTestTCHashTagsAccountInactiveStatusType() throws Exception {
        String methodID = "test42_SeTestTCHashTagsAccountInactiveStatusType";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

        // Test Params:
        String entityType = "Accounts";
        String hashTag = "inactive";
        String[] hTagTypeList = {"#suspect", "#lead", "#prospect", "#customer", "#partner", "#vendor", "#influencer", "#competitor"};
        String hTagComboTxt = "#" + hashTag;
        String resultsMsg = "VP: Account #inactive Status + Type combo Hash Tag search returned records";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: navigate to Accounts list view...
        commNav.clickGlobalMenuItem(entityType);

        AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);

        //Step: select the hash tag
        commNav.rightClickContextMenuItem(hashTag);

        //Step: check the filled-in search input field value
        String resulstMsg = "VP: right-context menu search field value set to " + hashTag;
        String accountSearchVal = accountListView.accountsSearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertEquals("#" + hashTag, accountSearchVal);
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + accountSearchVal + "'");
        }
        System.out.println(" ");

        //Step: perform Hash Tag combo search using #active and other types
        System.out.println(methodID + ": perform Hash Tag combo search using #active and other types...");
        for (int iCount = 0; iCount < hTagTypeList.length; iCount++) {
            hTagComboTxt = "#" + hashTag;
            hTagComboTxt = hTagComboTxt + " " + hTagTypeList[iCount];
            String accountListViewTxt = accountListView.getAccountsListViewTxt();
            commNav.searchListView(entityType, hTagComboTxt);
            Thread.sleep(2000);
            String searchResultsTxt = accountListView.getAccountsListViewTxt();
            try {
                AssertJUnit.assertTrue(!searchResultsTxt.equals(accountListViewTxt));
                System.out.println(resultsMsg + " - Passed");
            } catch (Error e) {
                System.out.println(methodID + "(): " + e.toString());
                System.out.println(resultsMsg + " - FAILED");
            }
        }
        System.out.println(" ");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test43_SeTestTCHashTagsContactGeneral() throws Exception {
        String methodID = "test43_SeTestTCHashTagsContactGeneral";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        // Test Params:
        String entityType = "Contacts";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: navigate to Contacts list view...
        commNav.clickGlobalMenuItem(entityType);

        ContactViewsElements contactListView = PageFactory.initElements(driver, ContactViewsElements.class);

        //Step: reveal Right Context Menu panel
        headerButton.showRightContextMenu();
        prepHashTagsSubPanel();


        //SECTION 1:
        //Step: test the Hash Tags header
        //collapse the Hash Tags sub-panel
        String resultsMsg = "VP: Hash Tags sub-panel collapse check";
        contactListView.contactsHashTagsHdr.click();
        try {
            AssertJUnit.assertFalse(contactListView.contactsHashTagsPnl.isDisplayed());
            System.out.println(resultsMsg + " - Passed");

            //re-expand the Hash Tags sub-panel
            resultsMsg = "VP: Hash Tags sub-panel expand check";

            contactListView.contactsHashTagsHdr.click();
            try {
                AssertJUnit.assertTrue(contactListView.contactsHashTagsPnl.isDisplayed());
                System.out.println(resultsMsg + " - Passed");
            } catch (Error e) {
                System.out.println(methodID + "(): " + e.toString());
                System.out.println(resultsMsg + " - FAILED");
            }
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resultsMsg + " - FAILED");
        }


        //SECTION 2:
        //Step: close Right-Context Menu
        headerButton.clickHeaderButton("right");

        //check to see that the Right-Context Menu is indeed closed
        // Verify the 'Right-Context Menu' left-screen displays...
        resultsMsg = "VP: Right-Context Menu panel expand check";
        try {
            AssertJUnit.assertFalse(driver.findElement(By.xpath(".//*[@id='right_drawer']/div")).isDisplayed());
            System.out.println(resultsMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resultsMsg + " - FAILED");
        }

        //Step: re-open Right-Context Menu (confirmation is handled in the method)
        headerButton.showRightContextMenu();

        //SECTION 3:
        //Step: test each of the pre-set Hash Tag items
        commNav.rightClickContextMenuItem("primary");
        commNav.rightClickContextMenuItem("not-primary");
        commNav.rightClickContextMenuItem("can-email");
        commNav.rightClickContextMenuItem("can-phone");
        commNav.rightClickContextMenuItem("can-fax");
        commNav.rightClickContextMenuItem("can-mail");
        commNav.rightClickContextMenuItem("can-solicit");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test44_SeTestTCHashTagsContactPrimaryHT() throws Exception {
        String methodID = "test44_SeTestTCHashTagsContactPrimaryHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'primary' hash tag
        contactHashTagSelectNSearchCheck("primary", "");

        //Step: select and search on 'primary' hash tag for specific Contact Name
        contactHashTagSelectNSearchCheck("primary", "Douglas");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test45_SeTestTCHashTagsContactNotPrimaryHT() throws Exception {
        String methodID = "test45_SeTestTCHashTagsContactNotPrimaryHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'not-primary' hash tag
        contactHashTagSelectNSearchCheck("not-primary", "");

        //Step: select and search on 'not-primary' hash tag for specific Contact Name
        contactHashTagSelectNSearchCheck("not-primary", "Allenson");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test46_SeTestTCHashTagsContactCanEmailHT() throws Exception {
        String methodID = "test46_SeTestTCHashTagsContactCanEmailHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'can-email' hash tag
        contactHashTagSelectNSearchCheck("can-email", "");

        //Step: select and search on 'can-email' hash tag for specific Contact Name
        contactHashTagSelectNSearchCheck("can-email", "Alvarez");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test47_SeTestTCHashTagsContactCanPhoneHT() throws Exception {
        String methodID = "test47_SeTestTCHashTagsContactCanPhoneHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'can-phone' hash tag
        contactHashTagSelectNSearchCheck("can-phone", "");

        //Step: select and search on 'can-phone' hash tag for specific Contact Name
        contactHashTagSelectNSearchCheck("can-phone", "Aberle");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test48_SeTestTCHashTagsContactCanFaxHT() throws Exception {
        String methodID = "test48_SeTestTCHashTagsContactCanFaxHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'can-fax' hash tag
        contactHashTagSelectNSearchCheck("can-fax", "");

        //Step: select and search on 'can-fax' hash tag for specific Contact Name
        contactHashTagSelectNSearchCheck("can-fax", "Chuck");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test49_SeTestTCHashTagsContactCanMailHT() throws Exception {
        String methodID = "test49_SeTestTCHashTagsContactCanMailHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'can-mail' hash tag
        contactHashTagSelectNSearchCheck("can-mail", "");

        //Step: select and search on 'can-mail' hash tag for specific Contact Name
        contactHashTagSelectNSearchCheck("can-mail", "Linda");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test50_SeTestTCHashTagsContactCanSolicitHT() throws Exception {
        String methodID = "test50_SeTestTCHashTagsContactCanSolicitHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'can-solicit' hash tag
        contactHashTagSelectNSearchCheck("can-solicit", "");

        //Step: select and search on 'can-solicit' hash tag for specific Contact Name
        contactHashTagSelectNSearchCheck("can-solicit", "Lars");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test51_SeTestTCHashTagsContactStateRetention() throws Exception {
        String methodID = "test51_SeTestTCHashTagsContactStateRetention";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        // Test Params:
        String entityType = "Contacts";
        String hashTag = "can-solicit";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: navigate to Contacts list view...
        commNav.clickGlobalMenuItem(entityType);

        ContactViewsElements contactListView = PageFactory.initElements(driver, ContactViewsElements.class);

        //Step: select the 'negotiation' hash tag
        commNav.rightClickContextMenuItem(hashTag);

        //Step: check the filled-in search input field value
        String resulstMsg = "VP: right-context menu search field value set to " + hashTag;
        String contactSearchVal = contactListView.contactsSearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertEquals("#" + hashTag, contactSearchVal);
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + contactSearchVal + "'");
        }

        //Step: navigate back to the My Activities List view
        headerButton.goBack();

        //Step: navigate to Accounts List view...
        commNav.clickGlobalMenuItem("Accounts");

        //Step: navigate back to Contacts list view...
        headerButton.showGlobalMenu();
        WebElement opportunityItem = driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = 'Contacts']"));
        commNav.highlightNClick(opportunityItem);

        //Step: re-open the Right-Context Menu
        headerButton.showRightContextMenu();

        contactListView = PageFactory.initElements(driver, ContactViewsElements.class);

        //Step: check the filled-in search input field value
        resulstMsg = "VP: right-context menu search field persistent value set to " + hashTag;
        contactSearchVal = contactListView.contactsSearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertEquals("#" + hashTag, contactSearchVal);
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + contactSearchVal + "'");
        }

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test52_SeTestTCHashTagsContactMutalExclusivity() throws Exception {
        String methodID = "test52_SeTestTCHashTagsContactMutalExclusivity";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

        // Test Params:
        String entityType = "Contacts";
        String hashTag = "primary";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: navigate to Contacts list view...
        commNav.clickGlobalMenuItem(entityType);

        ContactViewsElements contactListView = PageFactory.initElements(driver, ContactViewsElements.class);

        //Step: select the hash tag
        commNav.rightClickContextMenuItem(hashTag);

        //Step: check the filled-in search input field value
        String resulstMsg = "VP: right-context menu search field value set to " + hashTag;
        String contactSearchVal = contactListView.contactsSearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertEquals("#" + hashTag, contactSearchVal);
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + contactSearchVal + "'");
        }

        //Step: perform invalid Hash Tag combo search A: "#not-primary #primary"
        String hTagComboTxt = "#not-primary #primary";
        String resultsMsg = "VP: invalid combo Hash Tag search '" + hTagComboTxt + "'returned 'no records'";
        commNav.searchListView(entityType, hTagComboTxt);
        try {
            AssertJUnit.assertTrue(commNav.isTextPresentOnPage("no records"));
            System.out.println(resultsMsg + " - Passed");
        } catch (Error e) {
            System.out.println(resultsMsg + " - FAILED");
        }

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test53_SeTestTCHashTagsContactPrimaryHTCombos() throws Exception {
        String methodID = "test53_SeTestTCHashTagsContactPrimaryHTCombos";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

        // Test Params:
        String entityType = "Contacts";
        String hashTag = "primary";
        String[] hTagTypeList = {"#can-email", "#can-phone", "#can-fax", "#can-mail", "#can-solicit"};
        String hTagComboTxt = "#" + hashTag;
        String resultsMsg = "VP: Contact #primary indicator + donot combo Hash Tag search returned records";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: navigate to Contacts list view...
        commNav.clickGlobalMenuItem(entityType);

        ContactViewsElements contactListView = PageFactory.initElements(driver, ContactViewsElements.class);

        //Step: select the hash tag
        commNav.rightClickContextMenuItem(hashTag);

        //Step: check the filled-in search input field value
        String resulstMsg = "VP: right-context menu search field value set to " + hashTag;
        String contactSearchVal = contactListView.contactsSearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertEquals("#" + hashTag, contactSearchVal);
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + contactSearchVal + "'");
        }
        System.out.println(" ");

        //Step: perform Hash Tag combo search using #active and other types
        System.out.println(methodID + ": perform Hash Tag combo search using #primary and donot flags...");
        for (int iCount = 0; iCount < hTagTypeList.length; iCount++) {
            hTagComboTxt = "#" + hashTag;
            hTagComboTxt = hTagComboTxt + " " + hTagTypeList[iCount];
            String contactListViewTxt = contactListView.getContactsListViewTxt();
            commNav.searchListView(entityType, hTagComboTxt);
            Thread.sleep(2000);
            String searchResultsTxt = contactListView.getContactsListViewTxt();
            try {
                AssertJUnit.assertTrue(!searchResultsTxt.equals(contactListViewTxt));
                System.out.println(resultsMsg + " - Passed");
            } catch (Error e) {
                System.out.println(methodID + "(): " + e.toString());
                System.out.println(resultsMsg + " - FAILED");
            }
        }
        System.out.println(" ");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test54_SeTestTCHashTagsContactNotPrimaryHTCombos() throws Exception {
        String methodID = "test54_SeTestTCHashTagsContactNotPrimaryHTCombos";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

        // Test Params:
        String entityType = "Contacts";
        String hashTag = "not-primary";
        String[] hTagTypeList = {"#can-email", "#can-phone", "#can-fax", "#can-mail", "#can-solicit"};
        String hTagComboTxt = "#" + hashTag;
        String resultsMsg = "VP: Contact #primary indicator + donot combo Hash Tag search returned records";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: navigate to Contacts list view...
        commNav.clickGlobalMenuItem(entityType);

        ContactViewsElements contactListView = PageFactory.initElements(driver, ContactViewsElements.class);

        //Step: select the hash tag
        commNav.rightClickContextMenuItem(hashTag);

        //Step: check the filled-in search input field value
        String resulstMsg = "VP: right-context menu search field value set to " + hashTag;
        String contactSearchVal = contactListView.contactsSearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertEquals("#" + hashTag, contactSearchVal);
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + contactSearchVal + "'");
        }
        System.out.println(" ");

        //Step: perform Hash Tag combo search using #active and other types
        System.out.println(methodID + ": perform Hash Tag combo search using #not-primary and donot flags...");
        for (int iCount = 0; iCount < hTagTypeList.length; iCount++) {
            hTagComboTxt = "#" + hashTag;
            hTagComboTxt = hTagComboTxt + " " + hTagTypeList[iCount];
            String contactListViewTxt = contactListView.getContactsListViewTxt();
            commNav.searchListView(entityType, hTagComboTxt);
            Thread.sleep(2000);
            String searchResultsTxt = contactListView.getContactsListViewTxt();
            try {
                AssertJUnit.assertTrue(!searchResultsTxt.equals(contactListViewTxt));
                System.out.println(resultsMsg + " - Passed");
            } catch (Error e) {
                System.out.println(methodID + "(): " + e.toString());
                System.out.println(resultsMsg + " - FAILED");
            }
        }
        System.out.println(" ");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test55_SeTestTCHashTagsLeadGeneral() throws Exception {
        String methodID = "test55_SeTestTCHashTagsLeadGeneral";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        // Test Params:
        String entityType = "Leads";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: navigate to Contacts list view...
        commNav.clickGlobalMenuItem(entityType);

        LeadViewsElements leadListView = PageFactory.initElements(driver, LeadViewsElements.class);

        //Step: reveal Right Context Menu panel
        headerButton.showRightContextMenu();
        prepHashTagsSubPanel();


        //SECTION 1:
        //Step: test the Hash Tags header
        //collapse the Hash Tags sub-panel
        String resultsMsg = "VP: Hash Tags sub-panel collapse check";
        leadListView.leadsHashTagsHdr.click();
        try {
            AssertJUnit.assertFalse(leadListView.leadsHashTagsPnl.isDisplayed());
            System.out.println(resultsMsg + " - Passed");

            //re-expand the Hash Tags sub-panel
            resultsMsg = "VP: Hash Tags sub-panel expand check";

            leadListView.leadsHashTagsHdr.click();
            try {
                AssertJUnit.assertTrue(leadListView.leadsHashTagsPnl.isDisplayed());
                System.out.println(resultsMsg + " - Passed");
            } catch (Error e) {
                System.out.println(methodID + "(): " + e.toString());
                System.out.println(resultsMsg + " - FAILED");
            }
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resultsMsg + " - FAILED");
        }


        //SECTION 2:
        //Step: close Right-Context Menu
        headerButton.clickHeaderButton("right");

        //check to see that the Right-Context Menu is indeed closed
        // Verify the 'Right-Context Menu' left-screen displays...
        resultsMsg = "VP: Right-Context Menu panel expand check";
        try {
            AssertJUnit.assertFalse(driver.findElement(By.xpath(".//*[@id='right_drawer']/div")).isDisplayed());
            System.out.println(resultsMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resultsMsg + " - FAILED");
        }

        //Step: re-open Right-Context Menu (confirmation is handled in the method)
        headerButton.showRightContextMenu();

        //SECTION 3:
        //Step: test each of the pre-set Hash Tag items
        commNav.rightClickContextMenuItem("can-email");
        commNav.rightClickContextMenuItem("can-phone");
        commNav.rightClickContextMenuItem("can-fax");
        commNav.rightClickContextMenuItem("can-mail");
        commNav.rightClickContextMenuItem("can-solicit");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test56_SeTestTCHashTagsLeadCanEmailHT() throws Exception {
        String methodID = "test56_SeTestTCHashTagsLeadCanEmailHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'can-email' hash tag
        leadHashTagSelectNSearchCheck("can-email", "");

        //Step: select and search on 'can-email' hash tag for specific Lead Name
        leadHashTagSelectNSearchCheck("can-email", "Achew");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test57_SeTestTCHashTagsLeadCanPhoneHT() throws Exception {
        String methodID = "test57_SeTestTCHashTagsLeadCanPhoneHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'can-phone' hash tag
        leadHashTagSelectNSearchCheck("can-phone", "");

        //Step: select and search on 'can-phone' hash tag for specific Lead Name
        leadHashTagSelectNSearchCheck("can-phone", "Banks");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test58_SeTestTCHashTagsLeadCanFaxHT() throws Exception {
        String methodID = "test58_SeTestTCHashTagsLeadCanFaxHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'can-fax' hash tag
        leadHashTagSelectNSearchCheck("can-fax", "");

        //Step: select and search on 'can-fax' hash tag for specific Lead Name
        leadHashTagSelectNSearchCheck("can-fax", "Aaron");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test59_SeTestTCHashTagsLeadCanMailHT() throws Exception {
        String methodID = "test59_SeTestTCHashTagsLeadCanMailHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'can-mail' hash tag
        leadHashTagSelectNSearchCheck("can-mail", "");

        //Step: select and search on 'can-mail' hash tag for specific Lead Name
        leadHashTagSelectNSearchCheck("can-mail", "Barkley");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test60_SeTestTCHashTagsLeadCanSolicitHT() throws Exception {
        String methodID = "test60_SeTestTCHashTagsLeadCanSolicitHT";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: select and search on 'can-solicit' hash tag
        leadHashTagSelectNSearchCheck("can-solicit", "");

        //Step: select and search on 'can-solicit' hash tag for specific Lead Name
        leadHashTagSelectNSearchCheck("can-solicit", "John");

        System.out.println(ENDLINE);
    }

    @Test(enabled = false)
    public void test61_SeTestTCHashTagsLeadStateRetention() throws Exception {
        String methodID = "test61_SeTestTCHashTagsLeadStateRetention";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        // Test Params:
        String entityType = "Leads";
        String hashTag = "can-solicit";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: navigate to Lead list view...
        commNav.clickGlobalMenuItem(entityType);

        LeadViewsElements leadsListView = PageFactory.initElements(driver, LeadViewsElements.class);

        //Step: select the hash tag
        commNav.rightClickContextMenuItem(hashTag);

        //Step: check the filled-in search input field value
        String resulstMsg = "VP: right-context menu search field value set to " + hashTag;
        String leadSearchVal = leadsListView.leadsSearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertTrue(leadSearchVal.contains(hashTag));
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + leadSearchVal + "'");
        }

        //Step: navigate back to the My Activities List view
        headerButton.goBack();

        //Step: navigate to Leads List view...
        commNav = PageFactory.initElements(driver, CommonNavigation.class);
        commNav.clickGlobalMenuItem("Leads");

        //Step: re-open the Right-Context Menu
        //headerButton = PageFactory.initElements(driver, HeaderButton.class);
        headerButton.showRightContextMenu();

        leadsListView = PageFactory.initElements(driver, LeadViewsElements.class);

        //Step: check the filled-in search input field value
        resulstMsg = "VP: right-context menu search field persistent value set to " + hashTag;
        leadSearchVal = leadsListView.leadsSearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertEquals("#" + hashTag, leadSearchVal);
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + leadSearchVal + "'");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = false)
    public void test62_SeTestTCHashTagsLeadCombos() throws Exception {
        String methodID = "test62_SeTestTCHashTagsLeadCombos";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

        // Test Params:
        String entityType = "Leads";
        String hashTag = "can-email";
        String resultsMsg = "VP: Lead Types combo Hash Tag search returned results";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: navigate to Leads list view...
        commNav.clickGlobalMenuItem(entityType);

        LeadViewsElements leadListView = PageFactory.initElements(driver, LeadViewsElements.class);

        //Step: select the hash tag
        commNav.rightClickContextMenuItem(hashTag);

        //Step: check the filled-in search input field value
        String resulstMsg = "VP: right-context menu search field value set to " + hashTag;
        String leadSearchVal = leadListView.leadsSearchTxtBox.getAttribute("value");
        try {
            AssertJUnit.assertEquals("#" + hashTag, leadSearchVal);
            System.out.println(resulstMsg + " - Passed");
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(resulstMsg + " - FAILED; the actual value is '" + leadSearchVal + "'");
        }
        System.out.println(" ");

        //Step: perform Hash Tag combo search using #can-email and other types
        String[] hTagTypeList1 = {"#can-email", "#can-phone", "#can-fax", "#can-mail", "#can-solicit"};
        String hTagComboTxt1 = hTagTypeList1[0];
        System.out.println(methodID + ": perform Hash Tag combo search using #can-email and other types...");
        for (int iCount = 1; iCount < hTagTypeList1.length; iCount++) {
            hTagComboTxt1 = hTagTypeList1[0];
            hTagComboTxt1 = hTagComboTxt1 + " " + hTagTypeList1[iCount];
            commNav.searchListView(entityType, hTagComboTxt1);
            try {
                AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
                System.out.println(resultsMsg + " - Passed");
            } catch (Error e) {
                System.out.println(resultsMsg + " - FAILED");
            }
        }
        System.out.println(" ");

        //Step: perform Hash Tag combo search using #can-phone and other types
        String[] hTagTypeList2 = {"#can-phone", "#can-email", "#can-fax", "#can-mail", "#can-solicit"};
        String hTagComboTxt2 = hTagTypeList2[0];
        System.out.println(methodID + ": perform Hash Tag combo search using #can-phone and other types...");
        for (int iCount = 1; iCount < hTagTypeList2.length; iCount++) {
            hTagComboTxt2 = hTagTypeList2[0];
            hTagComboTxt2 = hTagComboTxt2 + " " + hTagTypeList2[iCount];
            commNav.searchListView(entityType, hTagComboTxt2);
            try {
                AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
                System.out.println(resultsMsg + " - Passed");
            } catch (Error e) {
                System.out.println(resultsMsg + " - FAILED");
            }
        }
        System.out.println(" ");

        //Step: perform Hash Tag combo search using #can-fax and other types
        String[] hTagTypeList3 = {"#can-fax", "#can-phone", "#can-email", "#can-mail", "#can-solicit"};
        String hTagComboTxt3 = hTagTypeList3[0];
        System.out.println(methodID + ": perform Hash Tag combo search using #can-phone and other types...");
        for (int iCount = 1; iCount < hTagTypeList3.length; iCount++) {
            hTagComboTxt3 = hTagTypeList3[0];
            hTagComboTxt3 = hTagComboTxt3 + " " + hTagTypeList3[iCount];
            commNav.searchListView(entityType, hTagComboTxt3);
            try {
                AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
                System.out.println(resultsMsg + " - Passed");
            } catch (Error e) {
                System.out.println(resultsMsg + " - FAILED");
            }
        }
        System.out.println(" ");

        //Step: perform Hash Tag combo search using #can-mail and other types
        String[] hTagTypeList4 = {"#can-mail", "#can-fax", "#can-phone", "#can-email", "#can-solicit"};
        String hTagComboTxt4 = hTagTypeList4[0];
        System.out.println(methodID + ": perform Hash Tag combo search using #can-mail and other types...");
        for (int iCount = 1; iCount < hTagTypeList4.length; iCount++) {
            hTagComboTxt4 = hTagTypeList4[0];
            hTagComboTxt4 = hTagComboTxt4 + " " + hTagTypeList4[iCount];
            commNav.searchListView(entityType, hTagComboTxt4);
            try {
                AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
                System.out.println(resultsMsg + " - Passed");
            } catch (Error e) {
                System.out.println(resultsMsg + " - FAILED");
            }
        }
        System.out.println(" ");

        //Step: perform Hash Tag combo search using #can-solicit and other types
        String[] hTagTypeList5 = {"#can-solicit", "#can-mail", "#can-fax", "#can-phone", "#can-email"};
        String hTagComboTxt5 = hTagTypeList5[0];
        System.out.println(methodID + ": perform Hash Tag combo search using #can-solicit and other types...");
        for (int iCount = 1; iCount < hTagTypeList5.length; iCount++) {
            hTagComboTxt5 = hTagTypeList5[0];
            hTagComboTxt5 = hTagComboTxt5 + " " + hTagTypeList5[iCount];
            commNav.searchListView(entityType, hTagComboTxt5);
            try {
                AssertJUnit.assertFalse(commNav.isTextPresentOnPage("no records"));
                System.out.println(resultsMsg + " - Passed");
            } catch (Error e) {
                System.out.println(resultsMsg + " - FAILED");
            }
        }
        System.out.println(" ");

        System.out.println(ENDLINE);
    }


    //Login & Logout
    //==============
    @Test(enabled = false)
    public void test00_MobileClient_Login() throws InterruptedException {
        String methodID = "test00_MobileClient_Login";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        doVerificationLogin();

        System.out.println(ENDLINE);
    }


    @Test(enabled = false)
    public void test99_Mobile_LogOut() throws InterruptedException {
        String methodID = "test99_Mobile_LogOut";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        doVerificationLogout();

        System.out.println(ENDLINE);
    }

}
