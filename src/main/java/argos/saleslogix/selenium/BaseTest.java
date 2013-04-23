package argos.saleslogix.selenium;
import static org.junit.Assert.fail;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
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

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"drivers/chromedriver.exe"); // TODO: Check environment here
		//System.setProperty("webdriver.ie.driver",
			//	"drivers/IEDriverServer.exe"); // TODO: Check environment here
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

	public void testBody() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		for (WebDriver d : drivers) {
			d.quit();
		}
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
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
}
