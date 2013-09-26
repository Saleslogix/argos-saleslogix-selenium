package argos.saleslogix.selenium.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

/**
 * BrowserSetup class defines the most basic properties and methods that are necessary for all Mobile Client 
 * test classes.  All test classes are required to be extensions of this class.
 * @author	mike.llena@swiftpage.com
 * @version	1.0
 */
public class BrowserSetup {

public static WebDriver driver;
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
public String ENDLINE   = "---------- end of test ----------";
private boolean acceptNextAlert = true;
protected StringBuffer verificationErrors = new StringBuffer();
	
@BeforeClass
	@Parameters("browser")
	public void launchBrowser(@Optional("ff") String browser) throws IOException {

	// Run Locally
	if(browser.equalsIgnoreCase("FF")){
		driver = new FirefoxDriver();
	} else if(browser.equalsIgnoreCase("chrome")){				
		File file = new File("C:\\Selenium\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
	}else {
		File file = new File("C:\\Selenium\\IEDriverServer.exe");
        System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		driver = new InternetExplorerDriver();		
	}
	browsername = browser;
		
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
	
	driver.get(baseUrl + mobileUrl + startPage);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	//driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void checkVP(ITestResult result) throws IOException {
		if (!result.isSuccess()) {
			File imageFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			String failureImageFileName = result.getMethod().getMethodName()+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime())
					+ ".png";
			failureImageFileName = ".\\test-output\\" + failureImageFileName;
			File failureImageFile = new File(failureImageFileName);
			FileUtils.moveFile(imageFile, failureImageFile);
		}
		//driver.close();
		//driver.quit();
		System.out.println("");
	}
		
	protected boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	    	return false;
	    }
	}

	private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	 }

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
	
	public void closeModal() {
		Set<String> windowids = driver.getWindowHandles();
		Iterator<String> iter= windowids.iterator();
		//String mainWindowId=iter.next();
		String popupWindowId=iter.next();
		driver.switchTo().window(popupWindowId);
	}
	
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
	
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
	
}
