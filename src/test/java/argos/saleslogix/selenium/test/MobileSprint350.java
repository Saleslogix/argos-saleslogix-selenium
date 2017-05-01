package argos.saleslogix.selenium.test;

import argos.saleslogix.selenium.pages.CommonNavigation;
import argos.saleslogix.selenium.pages.CommonViewsElements;
import argos.saleslogix.selenium.pages.ContactViewsElements;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;


/**
 * @author Kathy Lockyer-Bratton
 *         Class: MobileSprint350
 *         Desc.: Test class for some defects or features in Mobile 3.5.0
 */
public class MobileSprint350 extends BaseTest {

    public String TEST_ACCOUNT_LOOKUP = "Account Graphics";

    @Test
    // INFORCRM-11513 ... in Mobile 3.5 now able to lookup contacts by account, in addition to existing searches
    public void test01_INFORCRM11513() throws Exception {
        String methodID = "test01_INFORCRM11513";

        // Test Params:
        String entityType = "Contacts";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: logout & log back in (to clear cookies)
        LogOutThenLogBackIn(userName, userPwd);

        //Step: go to Contacts view
        commNav.clickGlobalMenuItem(entityType);
        commNav.waitForPage("All Contacts");

        ContactViewsElements contactListView = PageFactory.initElements(driver, ContactViewsElements.class);

        commView.lookupTxtBox.click();
        commNav.waitForAnimation();
        commView.lookupTxtBox.sendKeys(TEST_ACCOUNT_LOOKUP);
        commView.lookupTxtBox.sendKeys(Keys.RETURN);
        commNav.waitForPage("Contacts");

        commNav.highlightNClick(contactListView.topContactsListItemName);
        String contactName = contactListView.topContactsListItemName.getText();
        AssertJUnit.assertEquals("VP: under contact listview, able to lookup contacts by account name " + TEST_ACCOUNT_LOOKUP + " - FAILED", "Mindzak, Lisa", contactName);
        System.out.println("VP: under contact listview, able to lookup contacts by account name " + TEST_ACCOUNT_LOOKUP + ", found contact : " + contactName + " - PASSED");

        System.out.println(ENDLINE);
    }
}
