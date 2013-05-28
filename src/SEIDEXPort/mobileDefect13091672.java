package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MobileDefect13091672 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://107.21.243.158/mobile-builds/stable/latest/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMobileDefect13091672() throws Exception {
    // SE Test: SETest-Defect_13091672
    // Version: 2.2
    // Desc: validates that a Validation Summary error is displayed if a Product record is attempted to be saved w/o a Product Program set
    // Required Entity: Opportunity - Abbott WorldWide-Phase I
    // ====================================
    // Step: click Top-Left button to reveal Global Menu...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("div.group-content > ul.list-content. > li"))) break; } catch (Exception e) {}
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
    assertEquals("Opportunities", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).clear();
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).sendKeys("Abbott WorldWide-Phase I");
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[3]/button")).click();
    // Warning: waitForTextPresent may require manual changes
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Abbott WorldWide-Phase I \\(Abbott WorldWide\\)[\\s\\S]*$")) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Warning: assertTextPresent may require manual changes
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Abbott WorldWide-Phase I \\(Abbott WorldWide\\)[\\s\\S]*$"));
    // Step: click the Opportunity list item for editing...
    driver.findElement(By.xpath(".//*[@id='opportunity_list']/ul/li/div/h3")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Abbott WorldWide-Phase I".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: click the Products link...
    driver.findElement(By.xpath(".//*[@id='opportunity_detail']/div[2]/ul[2]/li[1]/a/span")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (!"".equals(driver.findElement(By.xpath(".//*[@id='opportunityproduct_related']/ul/li[1]/div/h3")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    assertEquals("Products", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
    // Step: click the '+' button to add a new Product...
    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Abbott WorldWide-Phase I".equals(driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_13']/input")).getAttribute("value"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    try {
      assertEquals("Opportunity Product", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: click Product lookup button to select a product...
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_14']/button")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (!"".equals(driver.findElement(By.xpath(".//*[@id='product_related']/ul/li[1]/div/h3")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    try {
      assertEquals("Products", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: select a product from the list...
    driver.findElement(By.xpath(".//*[@id='product_related']/ul/li[2]/div/h3")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Abbott WorldWide-Phase I".equals(driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_13']/input")).getAttribute("value"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    try {
      assertEquals("Opportunity Product", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: click the Top Save button...
    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
    // Validate: check that the Validation Summary error is displayed...
    // Warning: assertTextPresent may require manual changes
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Validation Summary[\\s\\S]*$"));
    // Warning: assertTextPresent may require manual changes
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*The field 'price level' must have a value\\.[\\s\\S]*$"));
    // Step: click the Price Level lookup to select a value...
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_15']/button")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Product Programs".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: select a Product Programs item...
    driver.findElement(By.xpath(".//*[@id='productprogram_related']/ul/li[1]/div/h3")).click();
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Retail[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: click the Top Save button...
    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
    // VP: check that the save is successful and that Validation Summary error is not displayed...
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Warning: verifyTextNotPresent may require manual changes
    try {
      assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*The field 'price level' must have a value\\.[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // 'End: navigate back to Home...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Abbott WorldWide-Phase I".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Opportunities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // -- End
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
