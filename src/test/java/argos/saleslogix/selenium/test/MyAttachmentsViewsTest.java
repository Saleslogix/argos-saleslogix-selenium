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
 * Class: MyAttachmentsViewsTest
 * Desc.: Test class for the My Attachments views
 */
public class MyAttachmentsViewsTest extends BaseTest {

    public String TEST_JPG_RECORD = "TestJpg";
	
	//Test Methods Set
	//================
	@Test(enabled = true)
	public void test01_SeTestTCMyAttachmentsListView() throws Exception {
		//Reference: MBL-10052
		String methodID = "test01_SeTestTCMyAttachmentsListView";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		
		// Test Params:
		String entityType = "My Attachments";
		String expEntityPgTitle = "My Attachments";
		String attachmentRecord = TEST_JPG_RECORD;
	
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: click Top-Left button to reveal Global Menu...
		headerbutton.showGlobalMenu();
	
	    //Step: navigate to My Attachments list view...
		commNav.entityListViewSearchContains(entityType, attachmentRecord);
		
		//Step: test the My Attachments, List View Card Layout page elements
		// SubStep: check the Page Title
		if (commNav.isPageDisplayed(entityType)) {
			
			MyAttachmentsViewsElements myAttachmentsListView = PageFactory.initElements(driver, MyAttachmentsViewsElements.class);			
			
			//Step: check the My Attachments List view, Card Layout
			commNav.checkIfWebElementPresent("My Attachments List View, Card Layout", myAttachmentsListView.myAttachmentsListView);
						
			//Step: check an My Attachments List view item record
			commNav.checkIfWebElementPresent("My Attachments List View Card Layout, item record", myAttachmentsListView.topMyAttachmentsListItem);
			commNav.checkIfWebElementPresent("My Attachments List View Card Layout, item record Icon", myAttachmentsListView.topMyAttachmentsListItemIcon);
			commNav.checkIfWebElementPresent("My Attachments List View Card Layout, item record Name", myAttachmentsListView.topMyAttachmentsListItemName);
			commNav.checkIfWebElementPresent("My Attachments List View Card Layout, item record Date & Size", myAttachmentsListView.topMyAttachmentsListItemDateAndSize);
			commNav.checkIfWebElementPresent("My Attachments List View Card Layout, item record File Extension", myAttachmentsListView.topMyAttachmentsListItemFileExtension);
			commNav.checkIfWebElementPresent("My Attachments List View Card Layout, item record Item Owner", myAttachmentsListView.topMyAttachmentsListItemOwner);
			commNav.checkIfWebElementPresent("My Attachments List View Card Layout, item record Touch Icon", myAttachmentsListView.topMyAttachmentsListItemTouch);
			
			//Step: check the "X records remaining" item box at the bottom of the list view
			//commNav.checkIfWebElementPresent("My Attachments List View, Card Layout, 'x remaining records' item", accountListView.recordsRemainingListItem);
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
