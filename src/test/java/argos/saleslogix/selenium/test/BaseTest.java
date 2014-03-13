package argos.saleslogix.selenium.test;

import argos.saleslogix.selenium.CommonNavigation;
import argos.saleslogix.selenium.SLXMobileLogin;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.*;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * BaseTest class defines the most basic properties and methods that are necessary for all Mobile Client
 * test classes.  All test classes are required to extend this class.
 */
public class BaseTest {

    public WebDriver driver;
    public String browsername = "";
    public String baseUrl;
    public String mobileUrl;
    public String webDriverUrl;
    public String startPage;
    public String homePage;
    public String userName;
    public String userPwd;
    public String fullProdName;
    public String shortProdName;
    public String copyrightLabel;
    public String versionLabel;
    public String STARTLINE = "==========";
    public String ENDLINE = "---------- end of test ----------";
    protected StringBuffer verificationErrors = new StringBuffer();
    private boolean acceptNextAlert = true;

    public BaseTest() {
    }

    /**
     * This method will launch the test browser (default - Chrome) before any Mobile Client tests are run.
     * Test properties specified in the app.properties file are read and used to setup global test variables.
     *
     * @param browser identifier of browser app to launch; specify: 'chrome' for Chrome, 'firefox' for Firefox
     *
     * @throws InterruptedException
     */
    @BeforeClass
    @Parameters({"browser"})
    public void launchBrowser(@Optional("chrome")String browser) throws InterruptedException, MalformedURLException {
        // Run in grid
        System.out.println(browser);
        loadProperties();
        browsername = browser;

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        if (browser.equalsIgnoreCase("firefox")) {
            capabilities = DesiredCapabilities.firefox();
        } else if (browser.equalsIgnoreCase("chrome")) {
            capabilities = DesiredCapabilities.chrome();
        } else if (browser.equalsIgnoreCase("internetExplorer")) {
            capabilities = DesiredCapabilities.internetExplorer();
        } else if (browser.equalsIgnoreCase("android")) {
            capabilities = DesiredCapabilities.android();
        } else if (browser.equalsIgnoreCase("phantomjs")) {
            capabilities = DesiredCapabilities.phantomjs();
        }

        driver = new RemoteWebDriver(new URL(webDriverUrl), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("Running SLXMobile3x WebDriver Tests on SLX 8.1 Mobile Client");
        System.out.println("************************************************************");
        System.out.println("launching " + browsername + " WebDriver browser...");

        driver.get(baseUrl + mobileUrl + startPage);

        System.out.println("Testing Build Version: " + versionLabel);
        System.out.println("Testing Site URL: " + baseUrl + mobileUrl);
        System.out.println("");
    }

    private void loadProperties() {
        try {
            Properties p = new Properties();
            FileReader reader = new FileReader("app.properties");
            p.load(reader);
            reader.close();

            Enumeration<?> enumeration = p.propertyNames();
            while(enumeration.hasMoreElements())
            {
                String key = (String) enumeration.nextElement();
                if (System.getProperty(key) == null) {
                    System.setProperty(key, p.getProperty(key));
                }
            }

            baseUrl = System.getProperty("base_url");
            mobileUrl = System.getProperty("mobile_url");
            webDriverUrl = System.getProperty("webdriver_url");
            startPage = System.getProperty("start_page");
            homePage = System.getProperty("home_page");
            userName = System.getProperty("user_name");
            userPwd = System.getProperty("user_pwd");
            fullProdName = System.getProperty("full_prod_name");
            shortProdName = System.getProperty("short_prod_name");
            copyrightLabel = System.getProperty("copyright_lbl");
            versionLabel = System.getProperty("version_lbl");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * This method will return a boolean value that indicates if a specific WebElement is present.
     *
     * @param    by        element locator
     */
    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    /**
     * This method will capture an expected Alert and return the Alert text in a string.
     *
     */
    public String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }


    /**
     * This method will capture and close an expected Alert.
     *
     */
    public String closeAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertTxt = alert.getText();
            alert.accept();
            System.out.println(alertTxt);
            return alertTxt;
        } finally {
        }
    }


    /**
     * This method will close an on-screen modal dialog/window.
     *
     */
    public void closeModal() {
        Set<String> windowids = driver.getWindowHandles();
        Iterator<String> iter = windowids.iterator();
        //String mainWindowId=iter.next();
        String popupWindowId = iter.next();
        driver.switchTo().window(popupWindowId);
    }


    /**
     * This method will perform a logoff, clear session cookies, then log back in using the username & password
     * specified in the input parameters.  This method can be used if a scenario requires a different user
     * login session.
     *
     * @param userName SLX username
     * @param passWord password of SLX username
     */
    public void LogOutThenLogBackIn(String userName, String passWord) throws InterruptedException {
        String methodID = "LogOutThenLogBackIn";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        SLXMobileLogin slxmobilelogin = PageFactory.initElements(driver, SLXMobileLogin.class);

        //Step: Log out of Mobile Client
        commNav.clickGlobalMenuItem("log out");
        closeAlert();
        System.out.println("invoking " + methodID + " method...");

        //Step: Clear cookies
        driver.manage().deleteAllCookies();

        //Step: Redo login using valid credentials
        slxmobilelogin.doLogin(userName, passWord, true);
    }


    /**
     * This method will close and quit the WebDriver.
     *
     */
    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

    /**
     * This method perform a verification check on the SLX Mobile Client Login page.  The verification values
     * are defined in the app.properties file. After the verification check, this method will perform an login using the username an password members
     * defined in the BaseTest class.
     */
    public void doVerificationLogin() throws InterruptedException {
        String methodID = "doVerificationLogin";

        SLXMobileLogin slxMobileLogin = PageFactory.initElements(driver, SLXMobileLogin.class);

        //VP: the Mobile Login screen is loaded from base URL
        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        commNav.waitForPage(fullProdName);

        //VP: Page Title (header text - not pagetitle property)
        Thread.sleep(500);
        try {
            AssertJUnit.assertEquals(shortProdName, driver.getTitle());
            System.out.println("VP: Login Screen Title check - Passed");
        } catch (Error e) {
            System.out.println("Error: Login Screen Title check - FAILED");
            verificationErrors.append(methodID + "(): " + e.toString());
        }

        //VP: Login Page Name
        Thread.sleep(1000);
        try {
            AssertJUnit.assertTrue(commNav.isPageDisplayed(fullProdName));
            System.out.println("VP: Login Page Name check - Passed");
        } catch (Error e) {
            System.out.println("Error: Login Page Name check - FAILED");
            verificationErrors.append(methodID + "(): " + e.toString());
        }

        //VP: product logo
        try {
            AssertJUnit.assertTrue(slxMobileLogin.isLogoDisplayed());
            System.out.println("VP: 'saleslog!x' logo check  - Passed");
        } catch (Error e) {
            System.out.println("Error: product logo check - FAILED");
            verificationErrors.append(methodID + "(): " + e.toString());
        }

        //VP: Copyright Info
        try {
            String text = slxMobileLogin.getCopyright();
            text = new String(text.getBytes("ISO-8859-1"), "UTF-8");
            String label = new String(copyrightLabel.getBytes(), "UTF-8");
            AssertJUnit.assertEquals(label, text);
            System.out.println("VP: Copyright check - Passed");
        } catch (Error e) {
            System.out.println("Error: Copyright check - FAILED");
            verificationErrors.append(methodID + "(): " + e.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            AssertJUnit.assertEquals(versionLabel, slxMobileLogin.getAppVersion());
            System.out.println("VP: Version Label check - Passed");
        } catch (Error e) {
            System.out.println("Error: Version Label check - FAILED");
            verificationErrors.append(methodID + "(): " + e.toString());
        }

        // Step: Enter username and password then click the logon button
        AssertJUnit.assertTrue(slxMobileLogin.doLogin(userName, userPwd, true));
    }


    /**
     * This method perform a Logoff from the Mobile Client.  After logoff, a verification check on the
     * SLX Mobile Client Logoff page is performed.  The verification values are defined in the app.properties
     * file.
     *
     */
    public void doVerificationLogout() throws InterruptedException {
        String methodID = "doVerificationLogout";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

        // Click the Log Off button
        commNav.clickGlobalMenuItem("log out");
        closeAlert();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("pageTitle"), fullProdName));

        // Verify the Mobile Login screen displays
        try {
            AssertJUnit.assertEquals(fullProdName, driver.findElement(By.id("pageTitle")).getText());
            System.out.println("VP: Mobile Client Logout Check - Passed");
        } catch (Error e) {
            System.out.println("Error: Mobile Client Logout Check - FAILED");
            System.out.println(methodID + "(): " + e.toString());
        }
    }
}
