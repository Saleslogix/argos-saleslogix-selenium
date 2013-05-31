package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeTestTCGlobalMenuOpenAttachments {
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
  public void testSeTestTCGlobalMenuOpenAttachments() throws Exception {
    // SE Test: SETest-GlobalMenu_OpenAttachments
    // Version: 2.2
    // Desc: Opens various Attachment file types from the My Attachments list view..
    // Setup: Configure browser to automatically save downloaded items instead of using any viewers.
    // Condition(s): Test user is logged in.    
    // ==================================================================
    // Step: click Top-Left button to reveal Global Menu...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath(".//*[@id='myactivity_list']/ul/li[1]/div[2]/h3/span[3]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: navigate to Attachments list view...
    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"My Attachments\"]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath(".//*[@id='myattachment_list']/ul/li[1]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: open a .jpg Attachment...
    driver.findElement(By.linkText("bluepencil")).click();
    // Step: open a .log Attachment...
    driver.findElement(By.linkText("DtcInstall")).click();
    // Step: open an .ini Attachment...
    driver.findElement(By.linkText("win")).click();
    // Step: open an .xlsx Attachment...
    driver.findElement(By.linkText("AttachmentsMatrix2")).click();
    // Step: open an .xml Attachment...
    driver.findElement(By.linkText("Enterprise")).click();
    // Step: open an .rtf Attachment...
    driver.findElement(By.linkText("WeirdChar")).click();
    // Step: open an .pdf Attachment...
    driver.findElement(By.linkText("Sage SalesLogix Client OLE DB Provider Installation")).click();
    // Step: open an .doc Attachment...
    driver.findElement(By.linkText("ComboBoxRows")).click();
    // Step: open an .pptx Attachment...
    driver.findElement(By.linkText("Trinity - Mobile v2_1 - What's New")).click();
    // Step: open an .wav Attachment...
    driver.findElement(By.linkText("lightsaber_01")).click();
    // Step: navigate back...
    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
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
