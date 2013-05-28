package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeTestLoginNonAdminNoPW {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://107.21.243.158/mobile-builds/2.2/stable/latest/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSeTestLoginNonAdminNoPW() throws Exception {
    // SE Test: SETest-Login_NonAdmin_NoPW                               
    // Version: 2.2
    // Desc: Performs a login (as user 'Lee') on the Mobile 2.2 SLX site.
    // Condition(s): No open login session.  Test user is logged out.    
    // ==================================================================
    // Load: SLX Mobile Client URL into FF..
    driver.get(baseUrl + "about:blank");

driver.get(baseUrl + "#_login");
for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if ("Sage SalesLogix".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
	Thread.sleep(1000);
}

// VP: Page Title
assertEquals("SalesLogix", driver.getTitle());
// VP: Login Page Name
for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if ("Sage SalesLogix".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	Thread.sleep(1000);
}

try {
  assertEquals("Sage SalesLogix", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
} catch (Error e) {
  verificationErrors.append(e.toString());
}
// VP: Copyright Info...
try {
  assertEquals("© 2013 Sage Software, Inc. All rights reserved.", driver.findElement(By.xpath(".//*[@id='login']/span[1]")).getText());
} catch (Error e) {
  verificationErrors.append(e.toString());
}
try {
  assertEquals("Mobile V2.2.0 / SalesLogix V8.0.0", driver.findElement(By.xpath(".//*[@id='login']/span[2]")).getText());
} catch (Error e) {
  verificationErrors.append(e.toString());
}
// Step: Login as 'Lee' (no Password)...
driver.findElement(By.cssSelector("input[name=\"username\"]")).clear();
driver.findElement(By.cssSelector("input[name=\"username\"]")).sendKeys("Lee");
// Step: click password field... (but don't set any value)
driver.findElement(By.cssSelector("input[name=\"password\"]")).click();
// Step: Set remember option to ON...
driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_BooleanField_0']/div/span[1]")).click();
// Step: Click Log On button to login...
driver.findElement(By.cssSelector("button.button.actionButton")).click();
// VP: My Activities page is loaded...
for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
	Thread.sleep(1000);
}

try {
  assertEquals("My Activities", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
} catch (Error e) {
  verificationErrors.append(e.toString());
}
// -- END
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
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
