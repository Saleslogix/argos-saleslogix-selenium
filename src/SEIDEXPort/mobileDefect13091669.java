package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MobileDefect13091669 {
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
  public void testMobileDefect13091669() throws Exception {
    // SE Test: SETest-Defect_13091669
    // Version: 2.2
    // Desc: validates that where multi currency is enabled, on adding product to opportunity, 2 of the 3 'extended price' fields do not change value when the 1st one does
    // Pre-Run Steps: Logoff, then Log back in as 'Lee'...
    // Required Entity: Opportunity - Abbott WorldWide-Phase I
    // ====================================
    // Step: click Top-Left button to reveal Global Menu...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: navigate to Opportunities list view...
    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Opportunities\"]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath(".//*[@id='opportunity_list']/ul/li[1]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: perform a search of a target Opportunity...
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).click();
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).clear();
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).sendKeys("Advising Group Test Opp 100");
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[3]/button")).click();
    // Warning: waitForTextPresent may require manual changes
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Advising Group Test Opp 100 \\(Advising Group\\)[\\s\\S]*$")) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: click the Opportunity list item for editing...
    driver.findElement(By.xpath(".//*[@id='opportunity_list']/ul/li[2]/div/h3")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText().matches("^Advising Group Test Opp[\\s\\S]*$")) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: click the Products link...
    driver.findElement(By.xpath(".//*[@id='opportunity_detail']/div[2]/ul[2]/li[1]/a/span")).click();
    try {
      assertEquals("Products", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: click the '+' button to add a new Product...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: click Product lookup button to select a product...
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_14']/button")).click();
    try {
      assertEquals("Products", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: search and select a Product...
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_31']/div/div[1]/input")).clear();
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_31']/div/div[1]/input")).sendKeys("Blackberry");
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_31']/div/div[3]/button")).click();
    // Warning: waitForTextPresent may require manual changes
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*BlackBerry[\\s\\S]*$")) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='product_related']/ul/li/div/h3")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: set the Price Level...
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_15']/button")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Product Programs".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='productprogram_related']/ul/li[1]/div/h3")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Verify: check the values of the product and price fields...
    try {
      assertEquals("BlackBerry", driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_14']/input")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("399.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_1']/input")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Verify: check the value of the 1st extended price
    try {
      assertEquals("399.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_4']/input")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: enter a discount field value...
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_0']/input")).clear();
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_0']/input")).sendKeys("15.00");
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_1']/label")).click();
    // Verify: updated adjusprice fields...
    try {
      assertEquals("339.15", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_2']/input")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Verify: updated extended price fields...
    try {
      assertEquals("339.15", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_4']/input")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: click the Top Cancel button...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // 'End: navigate back to Home...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText().matches("^Advising Group Test Opp[\\s\\S]*$")) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
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
