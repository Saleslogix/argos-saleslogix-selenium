package argos.saleslogix.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


/**
 * Test class that defines test methods for the SLX Mobile Defect (v3.3.0) fixes.
 * 
 * @author kathleen.lockyer-bratton@infor.com
 * @version	1.0
 */
public class MobileSprint330 extends BaseTest {

    public String TEST_OPPORTUNITY_RECORD = "Vegas Vision-Phase1";
    public String TEST_CONTACT_RECORD = "Abbott, John";

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
    // MBL-10793 ... Opportunity - an edit to the 'est close' is setting the date to a day ahead of what was chosen

    public void test01_MBL10793() throws Exception {
        String methodID = "test01_MBL10793";

        // Test Params:
        String entityType = "Opportunities";
        String entityRecord = TEST_OPPORTUNITY_RECORD;

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        OpportunityViewsElements oppsListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
        CalendarViewsElements calendarEditView = PageFactory.initElements(driver, CalendarViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: login & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: search for Opportunity entity, open Detail view, and edit est close value
        try {
            //Step: search for Opportunity entity, then open it's Detail view
            commNav.entityRecordOpenDetailView(entityType, entityRecord);

            //Step: edit the opportunity, save the original 'est close' value
            headerButton.editButton.click();
            commNav.waitForPage("Opportunity");
            Thread.sleep(3000);
            String estCloseDateOriginal = oppsListView.opportunityEditViewEstCloseInputFld.getAttribute("value");
            String[] dateValues = estCloseDateOriginal.split("/");
            System.out.println("Original opportunity 'est close' date has a month of : " + dateValues[0] + ", a day of : " + dateValues[1] + ", and year of : " + dateValues[2]);

            //Step: open calendar for 'est close', and choose 1 month earlier
            oppsListView.opportunityEditViewEstCloseFldBtn.click();
            commNav.waitForPage("Calendar");
            calendarEditView.calendarDecrementMonthBtn.click();
            headerButton.checkButton.click();
            commNav.waitForPage("Opportunity");

            //Step: retrieve the revised 'est close' date
            oppsListView = PageFactory.initElements(driver, OpportunityViewsElements.class);
            String estCloseDateModified = oppsListView.opportunityEditViewEstCloseInputFld.getAttribute("value");
            String[] dateValuesNew = estCloseDateModified.split("/");
            System.out.println("Modified opportunity 'est close' date has a month of : " + dateValuesNew[0] + ", a day of : " + dateValuesNew[1] + ", and year of : " + dateValuesNew[2]);


            //Step: verify that revised 'est close' date, is one month earlier, but has the same value for day
            String expectedDay = dateValues[1];
            String expectedMonth;
            String expectedYear;
            //  remove any leading zeroes from the revised 'month' ... for comparison with expectedMonth, which has no leading zeroes
            dateValuesNew[0] = dateValuesNew[0].replaceFirst("^0+(?!$)", "");

            //  if original month is 01, then expected month should be 12, and the expected year should be 1 less than the original year
            if (Integer.valueOf(dateValues[0]) == 1) {
                expectedMonth =  "12";
                expectedYear = Integer.toString(Integer.valueOf(dateValues[2]) - 1);
            }
            else {
                expectedMonth = Integer.toString(Integer.valueOf(dateValues[0]) - 1);
                expectedYear = dateValues[2];
            }

            System.out.println("Expected Day : " + expectedDay + " Expected Month : " + expectedMonth + " Expected Year : " + expectedYear);
            AssertJUnit.assertEquals("VP: revised date does not have the expected month of ... " + expectedMonth + " - FAILED", expectedMonth, dateValuesNew[0]);
            System.out.println("VP: revised date does have the expected month of ... " + expectedMonth + " - PASSED");
            AssertJUnit.assertEquals("VP: revised date does not have the expected day of ... " + expectedDay + " - FAILED", expectedDay, dateValuesNew[1]);
            System.out.println("VP: revised date does have the expected day of ... " + expectedDay + " - PASSED");
            AssertJUnit.assertEquals("VP: revised date does not have the expected year of ... " + expectedYear + " - FAILED", expectedYear, dateValuesNew[2]);
            System.out.println("VP: revised date does have the expected year of ... " + expectedYear + " - PASSED");



        }
        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }



    @Test(enabled = true)
    // MBL-10838 ... 8.1 Update 05 Activity Endpoint Changes : changing timeless activity start date should not save activitiy as not timeless

    public void test02_MBL10838() throws Exception {
        String methodID = "test02_MBL10838";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
        CalendarViewsElements calendarView = PageFactory.initElements(driver, CalendarViewsElements.class);
        MyActivityViewsElements activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);


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

            //Step: set activity to be timeless
            activityEditView.activityEditViewTimelessTgl.click();
            String newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);

            //Step: save activity
            headerButton.clickHeaderButton("Save");

            //Step: wait for page My Activities
            commNav.waitForPage("My Activities");

            //Step: search for activity created ... and re-open
            activityEditView.performMyActivitiesSearch(newActivityRegarding);
            WebElement activityItemLnk = driver.findElement(By.xpath("//*[@id='myactivity_list']//ul/li[1]/descendant::*[text() = '" + newActivityRegarding + "']"));
            commNav.highlightNClick(activityItemLnk);
            commNav.waitForPage("Activity");


            //Step: open the activity created in edit mode
            headerButton = PageFactory.initElements(driver, HeaderButton.class);
            headerButton.clickHeaderButton("Edit");

            //Step: wait for page Activity
            commNav.waitForPage("Activity");

            //Step: edit the start date and re-save activity
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            activityEditView.activityEditViewStartTimeFldBtn.click();
            commNav.waitForPage("Calendar");
            calendarView.calendarDecrementMonthBtn.click();
            headerButton.checkButton.click();
            commNav.waitForPage("Activity");

            String editedActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date changed to : " + editedActivityStartDate);
            headerButton.clickHeaderButton("Save");


            //Step: re-edit activity, retrieve edited start date
            headerButton = PageFactory.initElements(driver, HeaderButton.class);
            activityEditView = PageFactory.initElements(driver, MyActivityViewsElements.class);
            headerButton.clickHeaderButton("Edit");
            commNav.waitForPage("Activity");
            String edited2ActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date after re-save is : " + edited2ActivityStartDate);

            AssertJUnit.assertEquals("VP: after editing start date and re-saving timeless activity, activity is no longer timeless - FAILED", editedActivityStartDate, edited2ActivityStartDate);
            System.out.println("VP: after editing start date and re-saving timeless activity, activity remains timeless - PASSED");

        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: changing timeless activity start date and saving should keep activity as timeless " + " - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


    @Test(enabled = true)
    // MBL-10659 ... for Firefox, the Contact detail 'View address' quick action does nothing

    public void test03_MBL10659() throws Exception {
        String methodID = "test03_MBL10659";

        // Test Params:
        String entityType = "Contact";
        String entityRecord = TEST_CONTACT_RECORD;
        String viewName = "Contact Edit view";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        try {
            //Step: search for Contact entity, then open it's Detail view
            AssertJUnit.assertTrue(commNav.entityRecordOpenDetailView(entityType, entityRecord));

            ContactViewsElements contactDetailView = PageFactory.initElements(driver, ContactViewsElements.class);

            commNav.isWebElementPresent(viewName + ", 'View address'", contactDetailView.contactsDetailViewViewAddressLnk);

            //Store the current window handle for the mobile window
            String winHandleBefore = driver.getWindowHandle();

            //Step: click on the contact detail view 'View Address' link ... should open map with address
            contactDetailView.contactsDetailViewViewAddressLnk.click();
            Thread.sleep(7000);

            //Switch to new window opened for the contact address
            for(String winHandle : driver.getWindowHandles()){
                driver.switchTo().window(winHandle);
            }

            AssertJUnit.assertTrue("VP: View Address action for contact has opened a map with address - FAILED", driver.getPageSource().contains("Google Maps"));
            System.out.println("VP: View Address action for contact has opened a map with address - PASSED");

            //Close the new window (address map)
            driver.close();

            //Switch back to original browser (first window - mobile)
            driver.switchTo().window(winHandleBefore);

        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: View Address action for contact has opened a map with address - FAILED");
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
