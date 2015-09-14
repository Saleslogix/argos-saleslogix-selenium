package argos.saleslogix.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * @author Kathy Lockyer-Bratton
 * Class: MobileSprint320Test
 * Desc.: Test class for some defects or features in Mobile 3.2
 */
public class MobileSprint320Test extends BaseTest {

    public String TEST_CONTACT_RECORD = "Abbott, John";
	
	//Test Methods Set
	//================


    @Test(enabled = true)
    // MBL-10698 ... Recurring Activity : for Complete Occurrence screen, leader displays as an ID

    public void test01_MBL10698() throws Exception {
        String methodID = "test01_MBL10698";


        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);


        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);


        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: go to "My Activities" view, if not already there ... wait for page My Activities
        if (!commNav.isPageDisplayed("My Activities"))   {
            commNav.clickGlobalMenuItem("My Activities");
            commNav.waitForPage("My Activities");
        }


        //Step: add an activity (recurring Meeting for 2 days)
        headerButton.clickHeaderButton("Add");

        //Step: wait for page Schedule... to open
        commNav.waitForPage("Schedule...");

        //Step: select Meeting for activity type
        activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        activityEditView.activityScheduleMeetingBtn.click();

        //Step: wait for page Meeting to open
        commNav.waitForPage("Meeting");


        //Step: add an Activity record with a random value for 'regarding'
        String newActivityRegarding = "SeAutoTestActivity-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
        System.out.println("2nd Activity regarding field will be - " + newActivityRegarding);

        activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);

        //Step: set meeting to be recurring for 2 days
        activityEditView.activityEditViewRepeatsFldBtn.click();
        commNav.waitForPage("Recurring");
        activityEditView.activityRecurringDailyFld.click();
        commNav.waitForPage("Meeting");


        activityEditView.activityEditViewRecurringFldBtn.click();
        commNav.waitForPage("Recurrence");
        activityEditView.activityRecurrenceOccurencesFld.clear();
        activityEditView.activityRecurrenceOccurencesFld.sendKeys("2");
        headerButton.checkButton.click();
        commNav.waitForPage("Meeting");


        //Step: retrieve the value of the activity's Leader ... and print
        String initialLeaderValue = activityEditView.activityEditViewLeaderFld.getAttribute("value");
        System.out.println("VP: on initial creation of activity, the value for Leader is ... " + initialLeaderValue);

        //Step: save activity
        headerButton.clickHeaderButton("Save");

        //Step: search for recurring activity created above
        commView.lookupTxtBox.click();
        Thread.sleep(500);
        commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
        commView.lookupTxtBox.sendKeys(newActivityRegarding);
        commView.lookupTxtBox.sendKeys(Keys.RETURN);
        Thread.sleep(3000);


        //Step: open the activity, then choose to 'Complete Occurrence'
        activityEditView.topMyActivitiesListItem.click();
        commNav.waitForPage("Activity");
        Thread.sleep(3000);
        activityEditView.activityDetailViewCompleteOccurrenceLnk.click();
        commNav.waitForPage("Complete Occurrence");

        //Step: retrieve the value of the Leader on this dialog, and compare to the initial value of Leader ... should be the same (ie: NOT an ID)
        String completeOccurrenceLeaderValue = activityEditView.activityEditViewLeaderFld.getAttribute("value");
        System.out.println("VP: on 'Complete Occurrence' dialog, the value for Leader is ... " + completeOccurrenceLeaderValue);
        AssertJUnit.assertEquals("VP: the value of Leader on 'Complete Occurrence' dialog is not the same as Leader value on initial activity creation - FAILED",initialLeaderValue,completeOccurrenceLeaderValue);
        System.out.println("VP: the value of Leader on 'Complete Occurrence' dialog is the same as Leader value on initial activity creation - PASSED");


        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // MBL-10411 ... Complete activity with follow-up constantly displays 'loading...', and gives error on save

    public void test02_MBL10411() throws Exception {
        String methodID = "test02_MBL10411";


        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        ContactViewsElements contactDetailView = PageFactory.initElements(driver, ContactViewsElements.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);


        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        String entityType = "Contacts";
        String contactRecord = TEST_CONTACT_RECORD;


        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);


        //Step: search for Contact entity, then open it's Detail view
        commNav.entityRecordOpenDetailView(entityType, contactRecord);

        //Step: Open the Activities for the Contact
        commNav.highlightNClick(contactDetailView.contactDetailViewRelatedItemsTab);
        contactDetailView.contactsDetailViewActivitiesLnk.click();
        commNav.waitForPage("Activities");

        //Step: add a simple activity for the contact
        headerButton.clickHeaderButton("add");
        commNav.waitForPage("Schedule...");
        activityEditView.activityScheduleMeetingBtn.click();
        commNav.waitForPage("Meeting");

        //Step: add an Activity record with a random value for 'regarding'
        String newActivityRegarding = "SeAutoTestActivity-1-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
        System.out.println("Activity regarding field will be - " + newActivityRegarding);
        activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);
        headerButton.clickHeaderButton("Save");
        commNav.waitForPage("Activities");

        //Step: search for activity created above
        commView.lookupTxtBox.click();
        Thread.sleep(500);
        commView.lookupTxtBox.sendKeys(Keys.BACK_SPACE);
        commView.lookupTxtBox.sendKeys(newActivityRegarding);
        commView.lookupTxtBox.sendKeys(Keys.RETURN);
        Thread.sleep(3000);

        //Step: open the activity, then choose to Complete
        activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        activityEditView.topRelatedActivitiesListItem.click();
        commNav.waitForPage("Activity");
        activityEditView.activityDetailViewCompleteActivityLnk.click();
        commNav.waitForPage("Complete Activity");

        //Step: on Complete Activity, choose to 'follow-up' with a phone call activity after completion   ++
        activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        headerButton = PageFactory.initElements(driver, HeaderButton.class);
        activityEditView.activityCompleteViewFollowUpBtn.click();
        commNav.waitForPage("Follow-up type");
        activityEditView.activityFollowUpSchedulePhoneCallBtn.click();
        commNav.waitForPage("Complete Activity");
        headerButton.clickHeaderButton("save");

        //Step: after saving the completed activity, should pop-up the follow-up activity for a phone call
        activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        commNav.waitForPage("Phone Call");
        Thread.sleep(3000);

        //Step: checking whether or not 'loading...' is constantly displaying on the 'Phone Call' screen : it should not
        String loadingMessage = activityEditView.activityEditViewLoadingMessage.getText();
        if(loadingMessage.contentEquals("loading...")) {
            System.out.println("VP: Complete activity with follow-up constantly displaying 'loading...' - FAILED");
            AssertJUnit.fail("VP: test failed");
        }
        else {
            System.out.println("VP: Complete activity with follow-up not constantly displaying 'loading...' - PASSED");
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
