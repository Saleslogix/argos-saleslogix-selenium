package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MobileDefect13091789 {
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
  public void testMobileDefect13091789() throws Exception {
    // SE Test: SETest-Defect_13091789
    // Version: 2.2
    // Desc: validates that it's setting a Product's discount to 100% will set the Extended Price to 0.00
    // Pre-Run Steps: Logoff, then Log back in as 'Lee'...
    // Required Entity: Opportunity - Abbott Ltd.-Phase-9
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

    // Step: perform a search of a target Opportunity...
    assertEquals("Opportunities", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).clear();
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")).sendKeys("Abbott Ltd.-Phase-9");
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[3]/button")).click();
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Abbott Ltd\\.-Phase-9[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: click the Opportunity list item for editing...
    driver.findElement(By.xpath(".//*[@id='opportunity_list']/ul/li/div/h3")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Abbott Ltd.-Phase-9".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: click the Products link...
    driver.findElement(By.xpath(".//*[@id='opportunity_detail']/div[2]/ul[2]/li[1]/a/span")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: click the Product link...
    driver.findElement(By.xpath(".//*[@id='opportunityproduct_related']/ul/li[1]/div/h3")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Dell Optiplex".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: click Top Edit button to edit Product fields...
    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Opportunity Product".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: set the discount % field to 0.00
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_0']/input")).clear();
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_0']/input")).sendKeys("100.00");
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DecimalField_1']/input")).click();
    // Verify: check the values of the product and price fields...
    try {
      assertEquals("0.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_2']/input")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("0.00", driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_4']/input")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: click the Top Save button...
    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Dell Optiplex".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Verify: check the saved Price field values...
    try {
      assertEquals("100.00%", driver.findElement(By.xpath(".//*[@id='opportunityproduct_detail']/div[2]/div[1]/div[6]/span")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("0.00 USD", driver.findElement(By.xpath(".//*[@id='opportunityproduct_detail']/div[2]/div[2]/div[1]/span")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("0.00 USD", driver.findElement(By.xpath(".//*[@id='opportunityproduct_detail']/div[2]/div[2]/div[2]/span")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("0.00 USD", driver.findElement(By.xpath(".//*[@id='opportunityproduct_detail']/div[2]/div[3]/div/span")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: navigate back...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[4]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Products".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Abbott Ltd.-Phase-9".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Opportunities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
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
