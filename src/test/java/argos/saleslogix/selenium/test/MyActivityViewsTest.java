package argos.saleslogix.selenium.test;

import argos.saleslogix.selenium.pages.CommonNavigation;
import argos.saleslogix.selenium.pages.HeaderButton;
import argos.saleslogix.selenium.pages.MiscEntityItemViewsElements;
import argos.saleslogix.selenium.pages.MyActivityViewsElements;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;


/**
 * @author mllena
 *         Class: ActivityViewsTest
 *         Desc.: Test class for My Activities
 */
public class MyActivityViewsTest extends BaseTest {

    public String TEST_ACTIVITY_RECORD = "Presentation";

    //Test Methods Set

    @Test(enabled = true)
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


    //================
    @Test(enabled = true)
    public void test01_SeTestTCMyActivitiesListView() throws Exception {
        //Reference: MBL-10071
        String methodID = "test01_SeTestTCMyActivitiesListView";

        // Test Params:
        String entityType = "My Activities";
        String expEntityPgTitle = "My Activities";
        String regardingRecord = TEST_ACTIVITY_RECORD;

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: navigate to My Activities list view...
        commNav.entityListViewSearch(entityType, regardingRecord);

        //Step: test the My Activities, List View page elements
        // SubStep: check the Page Title
        if (commNav.isPageDisplayed(entityType)) {

            MyActivityViewsElements myActivitiesListView = PageFactory.initElements(driver, MyActivityViewsElements.class);

            //Step: check the My Activities List view, Card Layout
            commNav.checkIfWebElementPresent("My Activites List View, Card Layout", myActivitiesListView.myActivitiesListView);

            //Step: check an Opportunity list view item record
            commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record", myActivitiesListView.topMyActivitiesListItem);
            commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Activity Type", myActivitiesListView.topMyActivitiesListItemIcon);
            commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Regarding", myActivitiesListView.topMyActivitiesListItemRegarding);
            commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Start Time", myActivitiesListView.topMyActivitiesListItemStartTime);
            commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Contact & Account", myActivitiesListView.topMyActivitiesListItemContactAccount);
            commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Phone", myActivitiesListView.topMyActivitiesListItemPhone);
            commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Alarm Icon", myActivitiesListView.topMyActivitiesListItemAlarm);
            commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Touched Icon", myActivitiesListView.topMyActivitiesListItemTouch);
            commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Priority Icon", myActivitiesListView.topMyActivitiesListItemBang);
            commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Recurring Icon", myActivitiesListView.topMyActivitiesListItemRecurring);
            commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Overdue Icon", myActivitiesListView.topMyActivitiesListItemOverdueIndicator);

            //Step: check the Quick Action button and items
            try {
                //click list item icon to reveal Quick Action item
                myActivitiesListView.topMyActivitiesListItemIcon.click();

                //click the Quick Action button, then check each of the Quick Action items
                commNav.checkIfWebElementPresent("My Activites List View Card Layout, Quick Action Add Attachment button", myActivitiesListView.topMyActivitiesListItemQuickActionsAddAttachmentBtn);
                commNav.checkIfWebElementPresent("My Activites List View Card Layout, Quick Action Call button", myActivitiesListView.topMyActivitiesListItemQuickActionsCallBtn);
                commNav.checkIfWebElementPresent("My Activites List View Card Layout, Quick Action Decline button", myActivitiesListView.topMyActivitiesListItemQuickActionsDeclineBtn);
                commNav.checkIfWebElementPresent("My Activites List View Card Layout, Quick Action Accept button", myActivitiesListView.topMyActivitiesListItemQuickActionsAcceptBtn);
                commNav.checkIfWebElementPresent("My Activites List View Card Layout, Quick Action Complete button", myActivitiesListView.topMyActivitiesListItemQuickActionsCompleteBtn);
                commNav.checkIfWebElementPresent("My Activites List View Card Layout, Quick Action Contact button", myActivitiesListView.topMyActivitiesListItemQuickActionsContactBtn);
                commNav.checkIfWebElementPresent("My Activites List View Card Layout, Quick Action Opportunity button", myActivitiesListView.topMyActivitiesListItemQuickActionsOpportunityBtn);
                commNav.checkIfWebElementPresent("My Activites List View Card Layout, Quick Action Account button", myActivitiesListView.topMyActivitiesListItemQuickActionsAccountBtn);

                //click list item icon to hide the Quick Action items
                myActivitiesListView.topMyActivitiesListItemIcon.click();
            } catch (Exception e) {
                System.out.println(methodID + "(): " + e.toString());
            }

            //Step: check the "X records remaining" item box at the bottom of the list view
            //commNav.checkIfWebElementPresent("My Activites List View, Card Layout, 'x remaining records' item", accountListView.recordsRemainingListItem);
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
