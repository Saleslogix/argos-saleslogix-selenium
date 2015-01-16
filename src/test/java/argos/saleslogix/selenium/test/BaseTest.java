package argos.saleslogix.selenium.test;

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
    public String browserVersion = "";
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
     * To configure a different browser, you can change your app.properties browser line or pass in a
     * system property to maven: "maven -Dbrowser=firefox test". Note: all of the app.properties can be override this way.
     *
     * The browsers property can be any of the following:
     *  firefox
     *  chrome
     *  internetExplorer
     *  android
     *  phantomjs
     *
     * @throws InterruptedException
     */
    @BeforeClass
    public void launchBrowser() throws InterruptedException, MalformedURLException {
        // Run in grid
        loadProperties();
        System.out.println(browsername);
        System.out.println(webDriverUrl);

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        if (browsername.equalsIgnoreCase("firefox")) {
            capabilities = DesiredCapabilities.firefox();
        } else if (browsername.equalsIgnoreCase("chrome")) {
            capabilities = DesiredCapabilities.chrome();
        } else if (browsername.equalsIgnoreCase("internetExplorer")) {
            capabilities = DesiredCapabilities.internetExplorer();
        } else if (browsername.equalsIgnoreCase("android")) {
            capabilities = DesiredCapabilities.android();
        } else if (browsername.equalsIgnoreCase("ipad")) {
            capabilities = DesiredCapabilities.ipad();
            capabilities.setCapability("simulatorVersion", "7.1");
            capabilities.setCapability("sdkVersion", "7.1");
        } else if (browsername.equalsIgnoreCase("iphone")) {
            capabilities = DesiredCapabilities.iphone();
        } else if (browsername.equalsIgnoreCase("phantomjs")) {
            capabilities = DesiredCapabilities.phantomjs();
        }

        if (!browserVersion.isEmpty()) {
            capabilities.setVersion(browserVersion);
        }

        driver = new RemoteWebDriver(new URL(webDriverUrl), capabilities);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
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

            browsername = System.getProperty("browser");
            browserVersion = System.getProperty("browser_version");
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
        Thread.sleep(2000);
        closeAlert();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(2000);
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
        Thread.sleep(1000);
        try {
            AssertJUnit.assertEquals(shortProdName, driver.getTitle());
            System.out.println("VP: Login Screen Title check - Passed");
        }
        catch (Error e) {
            System.out.println("Error: Login Screen Title check - Failed");
            verificationErrors.append(methodID).append("(): ").append(e.toString());
        }

        //VP: Login Page Name
        Thread.sleep(1000);
        try {
            AssertJUnit.assertTrue(commNav.isPageDisplayed(fullProdName));
            System.out.println("VP: Login Page Name check - Passed");
        }
        catch (Error e) {
            System.out.println("Error: Login Page Name check - Failed");
            verificationErrors.append(methodID + "(): " + e.toString());
        }

        //VP: product logo
        try {
            AssertJUnit.assertTrue(commNav.isElementDisplayed(By.xpath(".//*[@id='login']/p/img")));
            System.out.println("VP: 'infor' logo check  - Passed");
        }
        catch (Error e) {
            System.out.println("Error: product logo check - Failed");
            verificationErrors.append(methodID + "(): " + e.toString());
        }

        //VP: Copyright Info

        try {
            AssertJUnit.assertEquals(copyrightLabel, driver.findElement(By.xpath(".//*[@id='login']/span[1]")).getText());
            System.out.println("VP: Copyright check - Passed");
        }
        catch (Error e) {
            System.out.println("Error: Copyright check - Failed");
            verificationErrors.append(methodID + "(): " + e.toString());
        }
        try {
            AssertJUnit.assertEquals(versionLabel, driver.findElement(By.xpath(".//*[@id='login']/span[2]")).getText());
            System.out.println("VP: Version Label check - Passed");
        }
        catch (Error e) {
            System.out.println("Error: Version Label check - Failed");
            verificationErrors.append(methodID + "(): " + e.toString());
        }

        // Step: Enter username and password then click the logon button
        slxMobileLogin.doLogin(userName, userPwd, true);

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
            System.out.println(methodID + "(): " + e.toString());
        }
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
        Thread.sleep(2000);
        closeAlert();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(2000);


        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("pageTitle"), fullProdName));

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