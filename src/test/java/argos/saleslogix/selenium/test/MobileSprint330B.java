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
 * Test class that defines test methods for the SLX Mobile Defect (v3.3.0) fixes.
 * 
 * @author kathleen.lockyer-bratton@infor.com
 * @version	1.0
 */
public class MobileSprint330B extends BaseTest {

    public String TEST_OPPORTUNITY_RECORD = "Vegas Vision-Phase1";
    public String TEST_CONTACT_RECORD = "Abbott, John";
    public String TEST_ACCOUNT_RECORD = "Abbott Ltd.";

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
    // MBL-10613 ... My Activities : phone - on adding a second activity, phone displays value for the first activity's account, while account is blank

    public void test09_MBL10613() throws Exception {
        String methodID = "test09_MBL10613";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        AccountViewsElements accountListView = PageFactory.initElements(driver, AccountViewsElements.class);


        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        try {


            //Step: logout & log back in (to clear cookies)
            LogOutThenLogBackIn(userName, userPwd);


            //Step: go to "My Activities" view, if not already there ... wait for page My Activities
            if (!commNav.isPageDisplayed("My Activities"))   {
                commNav.clickGlobalMenuItem("My Activities");
                commNav.waitForPage("My Activities");
            }


            //Step: click the Add header button to open Activity schedule view
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

            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);


            //Step: set the account to one that has a phone number
            activityEditView.activityEditViewAccountBtn.click();
            commNav.waitForPage("Accounts");


            commView.lookupTxtBox.sendKeys(TEST_ACCOUNT_RECORD);
            Thread.sleep(500);
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
            Thread.sleep(500);
            accountListView = PageFactory.initElements(driver, AccountViewsElements.class);
            accountListView.relatedAccountsListViewTopItem.click();
            //Thread.sleep(500);
            commNav.waitForPage("Meeting");

            //Step: retrieve the value for phone for the account record chosen
            String firstActivityPhoneNo = activityEditView.activityEditViewPhoneFld.getAttribute("value");
            System.out.println("VP: phone number for first activity ... from account chosen, is ... " + firstActivityPhoneNo);


            //Step: save activity
            headerButton.clickHeaderButton("Save");

            //Step: wait for page My Activities
            commNav.waitForPage("My Activities");
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);

            //Step: create a second activity with no account
            headerButton.clickHeaderButton("Add");

            //Step: wait for page Schedule... to open
            commNav.waitForPage("Schedule...");

            //Step: select Meeting for activity type
            activityEditView.activityScheduleMeetingBtn.click();

            //Step: wait for page Meeting to open
            commNav.waitForPage("Meeting");

            //Step: with no account chosen for activity, verify that phone number is not set to the first activity's phone number - should be blank
            String secondActivityPhoneNo = activityEditView.activityEditViewPhoneFld.getAttribute("value");
            System.out.println("VP: phone number for second activity ... with no account chosen, is ... " + secondActivityPhoneNo);

            AssertJUnit.assertEquals("VP: second activity phone number is not displaying as blank - FAILED", "", secondActivityPhoneNo);
            System.out.println("VP: second activity phone number is displaying as blank - PASSED");

        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: second activity phone number is displaying as blank " + " - FAILED");
            AssertJUnit.fail("test failed");
        }

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
