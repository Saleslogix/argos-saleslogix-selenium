package argos.saleslogix.selenium.test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * BrowserSetup class defines the most basic properties and methods that are necessary for all Mobile Client
 * test classes.  All test classes are required to extend this class.
 *
 * @author mike.llena@swiftpage.com
 * @version 1.0
 */
public class BrowserSetup {

    public WebDriver driver;
    public String browsername = "";
    public String baseUrl;
    public String mobileUrl;
    public String startPage;
    public String homePage;
    public String userName;
    public String userPwd;
    public String fullProdName;
    public String shortProdName;
    public String copyrightLabel;
    public String versionLabel;
    public String scriptuser;
    public String STARTLINE = "==========";
    public String ENDLINE = "---------- end of test ----------";
    protected StringBuffer verificationErrors = new StringBuffer();
    private boolean acceptNextAlert = true;

    public BrowserSetup() {
    }

    public BrowserSetup(String browser) {
    }
    /**
     * @param browser identifier of browser app to launch; specify: 'cr' for Chrome, 'ff' for Firefox, 'ie' for Internet Explorer, 'sf' for Safari
     */
    @BeforeTest
    @Parameters({"browser"})
    public void setupBrowsers(@Optional("ff")String browser) {
        // Run Locally
        System.out.println(browser);

        if (browser.equalsIgnoreCase("FF")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("CR")) {
            File file = new File("drivers/chromedriver.exe");
            System.out.println(file.getAbsolutePath());
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("IE")) {
            File file = new File("drivers/IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("SF")) {
            driver = new SafariDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        browsername = browser;

        try {
            Properties p = new Properties();
            FileReader reader = new FileReader("app.properties");
            p.load(reader);
            reader.close();
            baseUrl = p.getProperty("base_url");
            mobileUrl = p.getProperty("mobile_url");
            startPage = p.getProperty("start_page");
            homePage = p.getProperty("home_page");
            userName = p.getProperty("user_name");
            userPwd = p.getProperty("user_pwd");
            fullProdName = p.getProperty("full_prod_name");
            shortProdName = p.getProperty("short_prod_name");
            copyrightLabel = p.getProperty("copyright_lbl");
            versionLabel = p.getProperty("version_lbl");
            scriptuser = p.getProperty("script_user");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will launch the test browser (default - FireFox) before any Mobile Client tests are run.
     * Test properties specified in the app.properties file are read and used to setup global test variables.
     *
     * @throws InterruptedException
     */
    @BeforeClass
    public void launchBrowser() throws InterruptedException {
        System.out.println("Running SLXMobile3x WebDriver Tests on SLX 8.1 Mobile Client");
        System.out.println("************************************************************");
        System.out.println("launching " + browsername + " WebDriver browser...");

        driver.get(baseUrl + mobileUrl + startPage);

        System.out.println("Testing Build Version: " + versionLabel);
        System.out.println("Testing Site URL: " + baseUrl + mobileUrl);
        System.out.println("");
    }


    /**
     * This method will generate test result reports and screen shots under the \test-output project folder.
     *
     * @version 1.0
     * @param    result        test results object
     */
    @AfterMethod
    public void checkVP(ITestResult result) throws IOException {
        if (!result.isSuccess()) {
            File imageFile = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);
            String failureImageFileName = browsername + "_" + result.getMethod().getMethodName() + new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime())
                    + ".png";
            failureImageFileName = ".\\test-output\\" + failureImageFileName;
            File failureImageFile = new File(failureImageFileName);
            FileUtils.moveFile(imageFile, failureImageFile);
        }
        //driver.close();
        //driver.quit();
        System.out.println("");
    }


    /**
     * This method will return a boolean value that indicates if a specific WebElement is present.
     *
     * @version 1.0
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
     * This method will return a boolean value that indicates if an Alert is present.
     *
     * @version 1.0
     */
    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }


    /**
     * This method will capture an expected Alert and return the Alert text in a string.
     *
     * @version 1.0
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
     * @version 1.0
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
     * @version 1.0
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
     * @author mllena
     * @version 1.0
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
     * @author mllena
     * @version 1.0
     */
    @AfterClass
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }


    /**
     * This method will copy the test report to a specific folder.
     *
     * @author mllena
     * @version 1.0
     */
    @AfterSuite
    public void copyReport() {
        /*
		File sourceFile = new File("C:\\Users\\" + scriptuser + "\\Documents\\SEWebDriver\\SLX8Mobile2x\\test-output\\emailable-report.html");
		File targetFile = new File("\\\\ML02W7U\\TestReports\\Mobile2x SmokeTest Report - " + new SimpleDateFormat("MM-dd-yyyy hh-mm-ss aaa").format(new GregorianCalendar().getTime()) + ".html");
		try {
			Files.copy(sourceFile, targetFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
    }


    /**
     * This method perform a verification check on the SLX Mobile Client Login page.  The verification values
     * are defined in the app.properties file. After the verification check, this method will perform an login using the username an password members
     * defined in the BrowserSetup class.
     *
     * @version 1.0
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
            AssertJUnit.assertTrue(commNav.isElementDisplayed(By.xpath(".//*[@id='login']/p/img")));
            System.out.println("VP: 'saleslog!x' logo check  - Passed");
        } catch (Error e) {
            System.out.println("Error: product logo check - FAILED");
            verificationErrors.append(methodID + "(): " + e.toString());
        }

        //VP: Copyright Info
        try {
            String text = driver.findElement(By.xpath(".//*[@id='login']/span[1]")).getText();
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
            AssertJUnit.assertEquals(versionLabel, driver.findElement(By.xpath(".//*[@id='login']/span[2]")).getText());
            System.out.println("VP: Version Label check - Passed");
        } catch (Error e) {
            System.out.println("Error: Version Label check - FAILED");
            verificationErrors.append(methodID + "(): " + e.toString());
        }

        // Step: Enter username and password then click the logon button
        slxMobileLogin.doLogin(userName, userPwd, true);
    }


    /**
     * This method perform a Logoff from the Mobile Client.  After logoff, a verification check on the
     * SLX Mobile Client Logoff page is performed.  The verification values are defined in the app.properties
     * file.
     *
     * @version 1.0
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
