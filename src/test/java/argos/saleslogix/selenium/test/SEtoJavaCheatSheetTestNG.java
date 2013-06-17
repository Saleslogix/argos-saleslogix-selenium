package argos.saleslogix.selenium.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SEtoJavaCheatSheetTestNG {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeMethod
public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://107.21.243.158/mobile-builds/2.2/stable/latest/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSEtoJavaCheatSheet() throws Exception {
    // Selenese to Java Conversion Cheat Sheet
    // ====================================
    // Commonly Used
    // ------------------
    // open:
    driver.get("http://107.21.243.158/mobile-builds/2.2/stable/latest/#_login");

// click: (using locator only)
driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();

// click: (using location text identifier)
driver.findElement(By.xpath("//*[@id='left_drawer']/descendant::*[text() = 'SpeedSearch']")).click();

// type:
driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")).clear();
driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")).sendKeys("test");

// typeKeys:
// ERROR: Caught exception [ERROR: Unsupported command [typeKeys | xpath=.//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input | test]]

// assertElementPresent:
AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='myactivity_list']/ul/li[1]/div[2]/h3/span[3]")));

// verifyElementPresent:
try {
  AssertJUnit.assertTrue(isElementPresent(By.xpath("//*[@id='myactivity_list']/ul/li[1]/div[2]/h3/span[3]")));
} catch (Error e) {
  verificationErrors.append(e.toString());
}


// assertTitle:
AssertJUnit.assertEquals("SalesLogix", driver.getTitle());

// verifyTitle:
try {
  AssertJUnit.assertTrue(driver.getTitle().matches("^Sales[\\s\\S]*$"));
} catch (Error e) {
  verificationErrors.append(e.toString());
}

// assertText:
AssertJUnit.assertEquals("My Activities", driver.findElement(By.xpath("//*[@id='pageTitle']")).getText());

// verifyText:
try {
  AssertJUnit.assertEquals("My Activities", driver.findElement(By.xpath("//*[@id='pageTitle']")).getText());
} catch (Error e) {
  verificationErrors.append(e.toString());
}

// assertTextPresent:
// Warning: assertTextPresent may require manual changes
AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*My Activities[\\s\\S]*$"));

// verifyTextPresent:
// Warning: verifyTextPresent may require manual changes
try {
  AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Send[\\s\\S]*$"));
} catch (Error e) {
  verificationErrors.append(e.toString());
}

// assertNotText:
//assertThat("bogus", is(not(driver.findElement(By.xpath("//*[@id='pageTitle']")).getText())));
AssertJUnit.assertSame("bogus", is(not(driver.findElement(By.xpath("//*[@id='pageTitle']")).getText())));
AssertJUnit.assertNotSame("bogus", driver.findElement(By.xpath("//*[@id='pageTitle']")).getText());

// verifyNotText:
try {
	AssertJUnit.assertSame("bogus", is(not(driver.findElement(By.xpath("//*[@id='pageTitle']")).getText())));
} catch (Error e) {
  verificationErrors.append(e.toString());
}

// waitForText:
for (int second = 0;; second++) {
	if (second >= 60) Assert.fail("timeout");
	try { if ("My Activities".equals(driver.findElement(By.xpath("//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	Thread.sleep(1000);
}


// waitForTextPresent:
// Warning: waitForTextPresent may require manual changes
for (int second = 0;; second++) {
	if (second >= 60) Assert.fail("timeout");
	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*My Activities[\\s\\S]*$")) break; } catch (Exception e) {}
	Thread.sleep(1000);
}

  }

  @AfterMethod
public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      Assert.fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
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
