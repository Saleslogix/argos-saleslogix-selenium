package argos.saleslogix.selenium.test;

import argos.saleslogix.selenium.pages.CommonNavigation;
import argos.saleslogix.selenium.pages.HeaderButton;
import argos.saleslogix.selenium.pages.SLXMobileLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class UnitTestX extends BaseTest {

    CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

    //Login & Logout
    //==============
    @Test(enabled = true)
    public void test00_MobileClient_Login() throws InterruptedException {
        String methodID = "test00_MobileClient_Login";

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        doVerificationLogin();

        System.out.println(ENDLINE);
    }


    @Test(enabled = false)
    public void test99_Mobile_LogOutOLD() throws InterruptedException {
        String methodID = "test99_Mobile_LogOut";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        // Click the Log Off button
        commNav.clickGlobalMenuItem("log out");
        Thread.sleep(2000);
        closeAlert();
        Thread.sleep(1000);

        // Verify the Mobile Login screen displays
        try {
            AssertJUnit.assertEquals(fullProdName, driver.findElement(By.id("pageTitle")).getText());
            System.out.println("VP: Mobile Client Logout Check - Passed");
        } catch (Error e) {
            System.out.println("Error: Mobile Client Logout Check - FAILED");
            System.out.println(e.toString());
        }
        System.out.println(ENDLINE);
    }


    public String getKPICardValue(String fullKPICardVal) {

        String[] segStrArray = fullKPICardVal.split("\n");
        String cardValue = segStrArray[1];

        return cardValue;
    }


    public void checkGlobalMenuStatus(String resultMsg) {
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        try {
            AssertJUnit.assertTrue(headerButton.globalMenuButton.isDisplayed());
            System.out.println(resultMsg + " - Passed");
        } catch (Error e) {
            verificationErrors.append(e.toString());
            System.out.println(resultMsg + " - Failed");
        }
    }


    @Test(enabled = false)
    public void test11_MobileDefect_MBL10172() throws Exception {
        //MBL-10172: Mobile - Ticket Activities : elapsed hours not displaying as it does in web client (16 dec positions versus 2) [DTS 13091638]
        String methodID = "test11_MobileDefect_MBL10172";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: open the Ticket Detail view
        String entityType = "Tickets";
        String tktItem = "001-00-000017";
        String entityDetailViewLink = "Ticket Activities";
        commNav.entityRecordOpenDetailView(entityType, tktItem);

        //Step: open the Ticket Activities view
        String tktDetVwActivitiesXPath = "//*[@id='ticket_detail']/descendant::*[text() = '" + entityDetailViewLink + "']";
        driver.findElement(By.xpath(tktDetVwActivitiesXPath)).click();
        commNav.waitForPage(entityDetailViewLink);

        //Step: perform a Ticket Activity search
        String searchItem = "Customer follow up to check on new units";
        WebElement searchFld = driver.findElement(By.name("query"));
        WebElement lookupBtn = driver.findElement(By.xpath("//div[3]/button"));
        searchFld.clear();
        searchFld.sendKeys(searchItem);
        lookupBtn.click();
        Thread.sleep(2000);

        //Step: click to open the Ticket Activity record
        WebElement tktListItem = driver.findElement(By.xpath("//*[@id='ticketactivity_related']/ul/li"));
        tktListItem.click();
        commNav.waitForNotPage(entityDetailViewLink);

        //Step: expand the More Details link
        WebElement moreDetailsLnk = driver.findElement(By.xpath("//*[@id='ticketactivity_detail']/descendant::*[text() = 'More Details']"));
        moreDetailsLnk.click();

        //VP: check to see that the Elapsed Hours field is not equal to 0.0333333333333333
        String txt2Chk = "0.0333333333333333";
        String resultsMsg = "VP: The Elapsed Hours field value is not equal to " + txt2Chk;
        try {
            WebElement elapsedHrsFld = driver.findElement(By.xpath("//*[@id='ticketactivity_detail']/div[2]/div[2]/div[2]"));
            String elapsedHrsVal = elapsedHrsFld.getText();
            AssertJUnit.assertFalse(elapsedHrsVal.equals("elapsed hours" + txt2Chk));
            System.out.println(resultsMsg + " - Passed");
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println(resultsMsg + " - Failed");
        }

        //END
        commNav.clickGlobalMenuItem("My Activities");
        System.out.println(ENDLINE);
    }


    //Login & Logout
    //==============
    @Test(enabled = false)
    public void test00_MobileClient_LoginOLD() throws InterruptedException {
        //TODO: need to setup a method for Login() under CommonNavigation
        String methodID = "test00_MobileClient_Login";

        SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //VP: the Mobile Login screen is loaded from base URL
        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        commNav.waitForPage(fullProdName);

        //VP: Page Title (header text - not pagetitle property)
        Thread.sleep(1000);
        try {
            AssertJUnit.assertEquals(shortProdName, driver.getTitle());
            System.out.println("VP: Login Screen Title check - Passed");
        } catch (Error e) {
            System.out.println("Error: Login Screen Title check - FAILED");
            verificationErrors.append(e.toString());
        }

        //VP: Login Page Name
        Thread.sleep(1000);
        try {
            AssertJUnit.assertTrue(commNav.isPageDisplayed(fullProdName));
            System.out.println("VP: Login Page Name check - Passed");
        } catch (Error e) {
            System.out.println("Error: Login Page Name check - FAILED");
            verificationErrors.append(e.toString());
        }

        //VP: product logo
        try {
            AssertJUnit.assertTrue(commNav.isElementDisplayed(By.xpath(".//*[@id='login']/p/img")));
            System.out.println("VP: 'saleslog!x' logo check  - Passed");
        } catch (Error e) {
            System.out.println("Error: product logo check - FAILED");
            verificationErrors.append(e.toString());
        }

        //VP: Copyright Info
        try {
            AssertJUnit.assertEquals(copyrightLabel, driver.findElement(By.xpath(".//*[@id='login']/span[1]")).getText());
            System.out.println("VP: Copyright check - Passed");
        } catch (Error e) {
            System.out.println("Error: Copyright check - FAILED");
            verificationErrors.append(e.toString());
        }
        try {
            AssertJUnit.assertEquals(versionLabel, driver.findElement(By.xpath(".//*[@id='login']/span[2]")).getText());
            System.out.println("VP: Version Label check - Passed");
        } catch (Error e) {
            System.out.println("Error: Version Label check - FAILED");
            verificationErrors.append(e.toString());
        }

        // Step: Enter username and password then click the logon button
        slxmobilelogin.doLogin(userName, userPwd, true);

        // VP: confirm that the 'My Activities' screen displays after login
        Thread.sleep(3000);
        try {
            AssertJUnit.assertTrue(driver.findElement(By.xpath(".//*[@id='myactivity_list']")).isDisplayed());
            System.out.println("VP: Successfully logged in to Mobile Client.");
        } catch (UnhandledAlertException e) {
            //closeAlert();
            closeModal();
            //assertEquals("The user name or password is invalid.", closeAlertAndGetItsText());
            System.out.println("Error: Unable to login to Mobile Client.");
            System.out.println(e.toString());
        }
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
