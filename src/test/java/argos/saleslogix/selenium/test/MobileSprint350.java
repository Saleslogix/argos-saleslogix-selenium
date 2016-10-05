package argos.saleslogix.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.List;


/**
 * @author Kathy Lockyer-Bratton
 * Class: MobileSprint350
 * Desc.: Test class for some defects or features in Mobile 3.5.0
 */
public class MobileSprint350 extends BaseTest {

    public String TEST_ACCOUNT_LOOKUP = "Account Graphics";
	
	//Test Methods Set
	//================


    @Test(enabled = true)
    // INFORCRM-11513 ... in Mobile 3.5 now able to lookup contacts by account, in addition to existing searches

    public void test01_INFORCRM11513() throws Exception {
        String methodID = "test01_INFORCRM11513";

        // Test Params:
        String entityType = "Contacts";
        String entityRecord = TEST_ACCOUNT_LOOKUP;

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        try {
            //Step: go to Contacts view
            commNav.clickGlobalMenuItem(entityType);
            commNav.waitForPage("All Contacts");

            ContactViewsElements contactListView = PageFactory.initElements(driver, ContactViewsElements.class);

            commView.lookupTxtBox.sendKeys(TEST_ACCOUNT_LOOKUP);
            commView.lookupTxtBox.sendKeys(Keys.RETURN);
            Thread.sleep(500);

            commNav.highlightNClick(contactListView.topContactsListItemName);
            String contactName = contactListView.topContactsListItemName.getText();
            AssertJUnit.assertEquals("VP: under contact listview, able to lookup contacts by account name " + TEST_ACCOUNT_LOOKUP + " - FAILED", "Mindzak, Lisa" ,contactName);
            System.out.println("VP: under contact listview, able to lookup contacts by account name " + TEST_ACCOUNT_LOOKUP + ", found contact : " + contactName + " - PASSED");

        } catch (Exception e) {
            verificationErrors.append(methodID + "(): " + e.toString());
            System.out.println("VP: under contact listview, able to lookup contacts by account name - FAILED");
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
