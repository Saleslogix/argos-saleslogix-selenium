package argos.saleslogix.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * Test class that defines test methods for the SLX Mobile Defect (v3.08) fixes.
 * 
 * @author kathleen.lockyer-bratton@swiftpage.com
 * @version	1.0
 */
public class MobileSprint308Test extends BaseTest {


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

    @Test(enabled = true)
    // MBL-10408 ... Calendar - date time picker shows wrong 'day' for timeless activities (eg: Wednesday instead of Thursday)
    public void test01_MBL10408() throws Exception {
        String methodID = "test01_MBL10408";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
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
            driver.findElement(By.xpath("//*[@id='activity_types_list']//ul/li[1]/div[4]")).click();

            //Step: wait for page Meeting to open
            commNav.waitForPage("Meeting");

            //Step: add an Activity record with a random value for 'regarding'
            String newActivityRegarding = "SeAutoTestActivity-" + new SimpleDateFormat("yyMMddHHmmss").format(new GregorianCalendar().getTime());
            System.out.println("Activity regarding field will be - " + newActivityRegarding);

            activityEditView.activityEditViewRegardingFld.sendKeys(newActivityRegarding);


            //Step: press the timeless toggle button to ON, then retrieve the value for MM/dd/yy
            activityEditView.activityEditViewTimelessTgl.click();
            String newActivityStartDate = activityEditView.activityEditViewStartTimeFld.getAttribute("value");
            System.out.println("Date/time value for Start Date is : " + newActivityStartDate);

            //Step: find the day of the week associated with newActivityStartDate
            SimpleDateFormat ft = new SimpleDateFormat("M/d/yyyy");
            Calendar dateTime1 = Calendar.getInstance();
            dateTime1.setTime(ft.parse(newActivityStartDate));
            ft = new SimpleDateFormat("EEEE");
            String dayOfWeek = ft.format(dateTime1.getTime()).toString();
            System.out.println("Timeless activity date and day of the week is  - " + newActivityStartDate + " : " + dayOfWeek);


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
            headerButton.clickHeaderButton("Edit");

            //Step: wait for page Activity
            commNav.waitForPage("Activity");

            //Step: Open Start Time calendar, and wait for page Calendar
            activityEditView.activityEditViewStartTimeFldBtn.click();
            commNav.waitForPage("Calendar");

            //Step: Verify that the correct day of the week is displaying for the activity date
            String calendarDayOfWeek = driver.findElement(By.xpath("//*[@id='datetime-picker-date']/caption")).getText();
            System.out.println("Timeless activity day of the week on the Calendar screen is - " + calendarDayOfWeek);
            System.out.println("Timeless activity date and day of the week is  - " + newActivityStartDate + " : " + dayOfWeek);
            AssertJUnit.assertEquals("VP: Timeless activity day of the week on the Calendar screen is not as expected " + " - FAILED", dayOfWeek, calendarDayOfWeek);
            System.out.println("VP: Timeless activity day of the week on the Calendar screen is as expected " + " - PASSED");

        }

        catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: Timeless activity day of the week on the Calendar screen is not as expected " + " - FAILED");
            AssertJUnit.fail("test failed");
        }

        System.out.println(ENDLINE);
    }


}
