package argos.saleslogix.selenium.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public abstract class BaseTest {
	public WebDriver driver;
	public String baseUrl;
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	public List<WebDriver> drivers;

	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"drivers/chromedriver.exe"); // TODO: Check environment here
		// System.setProperty("webdriver.ie.driver",
		// "drivers/IEDriverServer.exe"); // TODO: Check environment here
		loadSettings();
	}

	private void loadSettings() throws Exception {
		Properties p = new Properties();
		FileReader reader = new FileReader("app.properties");
		p.load(reader);
		reader.close();
		baseUrl = p.getProperty("base_url");
	}

	public void runTests() throws Exception {
		drivers = new ArrayList<WebDriver>();
		drivers.add(new FirefoxDriver());
		drivers.add(new ChromeDriver());
		//drivers.add(new InternetExplorerDriver());
		
		for (WebDriver d : drivers) {
			driver = d;
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			testBody();
		}
	}

	@Test
	public abstract void testBody() throws Exception;

	@AfterMethod
	public void tearDown() throws Exception {
		for (WebDriver d : drivers) {
			d.quit();
		}

		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alert.getText();
		} finally {
			acceptNextAlert = true;
		}
	}

	// TODO: Come up with a pattern to move these into a utility class
	public void doLogin(String userName) throws Exception {
		driver.get(baseUrl + "mobile/products/argos-saleslogix/index-dev.html");
		driver.findElement(By.cssSelector("input[name=\"username\"]")).clear();
		driver.findElement(By.cssSelector("input[name=\"username\"]"))
				.sendKeys(userName);
		driver.findElement(By.cssSelector("button.button.actionButton"))
				.click();
		for (int second = 0;; second++) {
			if (second >= 60)
				Assert.fail("timeout");
			try {
				if (isElementPresent(By.id("pageTitle")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}
}
