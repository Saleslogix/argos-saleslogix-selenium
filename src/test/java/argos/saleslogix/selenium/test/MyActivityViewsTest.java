package argos.saleslogix.selenium.test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * @author mllena
 * Class: ActivityViewsTest
 * Desc.: Test class for My Activities
 */
public class MyActivityViewsTest extends BaseTest {

    public String TEST_ACTIVITY_RECORD = "Presentation";
	
	//Test Methods Set
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
			commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Icon", myActivitiesListView.topMyActivitiesListItemIcon);
			commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Regarding", myActivitiesListView.topMyActivitiesListItemRegarding);
			commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Start Time", myActivitiesListView.topMyActivitiesListItemStartTime);
			commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Contact & Account", myActivitiesListView.topMyActivitiesListItemContactAccount);
			commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Phone", myActivitiesListView.topMyActivitiesListItemPhone);
			commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Alarm Icon", myActivitiesListView.topMyActivitiesListItemAlarm);
			commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Touch Icon", myActivitiesListView.topMyActivitiesListItemTouch);
			commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Touch Bang", myActivitiesListView.topMyActivitiesListItemBang);
			commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Touch Recurring", myActivitiesListView.topMyActivitiesListItemRecurring);
			commNav.checkIfWebElementPresent("My Activites List View Card Layout, item record Touch Type", myActivitiesListView.topMyActivitiesListItemType);
			
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
			}
			catch (Exception e) {
				System.out.println(methodID + "(): " + e.toString());				
			}
			
			//Step: check the "X records remaining" item box at the bottom of the list view
			//commNav.checkIfWebElementPresent("My Activites List View, Card Layout, 'x remaining records' item", accountListView.recordsRemainingListItem);
		}
		else {
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
	public void test99_Mobile_LogOut()  throws InterruptedException {				
		String methodID = "test99_Mobile_LogOut";
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		doVerificationLogout();
		
		System.out.println(ENDLINE);
	}
}
