package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MobileDefect13091842 {
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
  public void testMobileDefect13091842() throws Exception {
    // SE Test: SETest-Defect_13091842
    // Version: 2.2
    // Desc: checks that there is no error when a new Opportunity record is saved...
    // Pre-Run Steps: Logoff, then Log back in as 'Lee'...
    // Required Entity: TBD
    // ====================================
    // Step: click Top-Left button to reveal Global Menu...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: navigate to Opportunity list view...
    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Opportunities\"]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath(".//*[@id='opportunity_list']/ul/li[1]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: click the Top "+" (Add) button...
    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Opportunity".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: setup the required fields of the new Opportunity...
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextField_19']/input")).clear();
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_TextField_19']/input")).sendKeys("Test Opp for Defect Fix Test-13091842");
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_6']/button")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Accounts".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='account_related']/descendant::*[text()=\"Abbott WorldWide\"]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Opportunity".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Verify: save the Opportunity and confirm that there is no error message...
    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Warning: assertTextPresent may require manual changes
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Test Opp for Defect Fix Test-13091842[\\s\\S]*$"));
    // 'End: navigate back to Home...
    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
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
