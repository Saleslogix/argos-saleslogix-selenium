package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeTestTCGlobalMenuEditActivityScreens {
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
  public void testSeTestTCGlobalMenuEditActivityScreens() throws Exception {
    // SETest-GlobalMenu_EditActivity_Screens
    // Version: 2.2
    // Desc: Confirms that the toggle button (left and right) for Global Menu access is visible on screens accessible under the Edit Activity screens...
    // Note: This test script can be used as a template for completing/editing an Activity.
    // Condition(s): Test user is logged in.    
    // ==================================================================
    // Step: click top Activity link from the My Activities screen...
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("My Activities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("span.p-description")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    assertEquals("Complete Activity", driver.findElement(By.cssSelector("a > label")).getText());
    // Step: click the Top cEdit Activity button...
    driver.findElement(By.xpath(".//*[@id='activity_detail']/div[2]/ul[1]/li/a")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // VP: confirm that Global Menu button is available...
    try {
      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: click the Regarding edit button...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_31']/button")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Activity Regarding".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // VP: confirm that Global Menu button is available...
    try {
      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: navigate back to Activity screen...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: click Start Date edit button...
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DateField_10']/button")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Calendar".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // VP: confirm that Global Menu button is available...
    try {
      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: navigate back to Activity screen...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: click Duration edit button...
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_DurationField_2']/button")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("List".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // VP: confirm that Global Menu button is available...
    try {
      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: navigate back to the Activity screen...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: click the Result edit button...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_32']/button")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Result".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // VP: confirm that Global Menu button is available...
    try {
      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: navigate back to the Activity screen...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: click the Follow-up edit button...
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_SelectField_2']/button")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Follow-up type".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // VP: confirm that Global Menu button is available...
    try {
      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: navigate back to the Activity screen...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: click the Notes edit button...
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_NoteField_7']/button")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Notes".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // VP: confirm that Global Menu button is available...
    try {
      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: navigate back to the Activity screen...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: click the Priority edit button...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_33']/button")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Priority".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // VP: confirm that Global Menu button is available...
    try {
      assertTrue(isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: navigate back to the Activity screen...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: click the Category edit button...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Fields_PicklistField_34']/button")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Activity Category".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // VP: confirm that Global Menu button is available...
    try {
      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: navigate back to the Activity screen...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: click the Leader edit button...
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_33']/button")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Users".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // VP: confirm that Global Menu button is available...
    try {
      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: navigate back to the Activity screen...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: click the Account edit button...
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_34']/button")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Accounts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // VP: confirm that Global Menu button is available...
    try {
      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: navigate back to the Activity screen...
    driver.findElement(By.xpath(".//*[@id='account_related']/ul/li[1]/div/h3")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: click the Contact edit button...
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_35']/button")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Contacts".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // VP: confirm that Global Menu button is available...
    try {
      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: navigate back to the Activity screen...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: click the Opportunity edit button...
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_36']/button")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Opportunities".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // VP: confirm that Global Menu button is available...
    try {
      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: navigate back to the Activity screen...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: click the Tickets edit button...
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_37']/button")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Tickets".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // VP: confirm that Global Menu button is available...
    try {
      assertTrue(isElementPresent(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: navigate back to the Activity screen...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Complete Activity".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: navigate back to the Activity screen...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
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
