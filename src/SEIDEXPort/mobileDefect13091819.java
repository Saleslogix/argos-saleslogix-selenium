package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MobileDefect13091819 {
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
  public void testMobileDefect13091819() throws Exception {
    // SE Test: SETest-Defect_13091819
    // Version: 2.2
    // Desc: validates that when opening an activity occurrence detail view from My Activities, completing occurrence completes the entire series, whereas same does not happen when opening the activity occurrence detail view from the contact activity list
    // Pre-Run Steps: Logoff, then Log back in as 'Lee'...
    // Required Entity: Contact - Douglas Adi
    // ====================================
    // Step: click Top-Left button to reveal Global Menu...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: navigate to My Activities list view...
    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"My Activities\"]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Schedule...".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("#activity_types_list > ul.list-content > li > div.list-item-content > h3")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_28 > button.button.simpleSubHeaderButton")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Activity Description".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='pick_list_0']/ul/li[5]/div/h3")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("input[name=\"Location\"]")).clear();
    driver.findElement(By.cssSelector("input[name=\"Location\"]")).sendKeys("Arriba");
    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_30 > button.button.simpleSubHeaderButton")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Activity Category".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='pick_list_0']/ul/li[5]/div/h3")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_DateField_8 > button.button.whiteButton")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Calendar".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("td > button.button")).click();
    driver.findElement(By.cssSelector("td > button.button")).click();
    driver.findElement(By.cssSelector("td > button.button")).click();
    new Select(driver.findElement(By.id("day-field"))).selectByVisibleText("30");
    new Select(driver.findElement(By.id("hour-field"))).selectByVisibleText("11");
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_SelectField_1 > button.button.simpleSubHeaderButton")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Recurring".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='select_list']/ul/li[3]/div/h3")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("#Mobile_SalesLogix_Fields_RecurrencesField_0 > button.button.simpleSubHeaderButton")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Recurrence".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("input[name=\"RecurIterations\"]")).clear();
    driver.findElement(By.cssSelector("input[name=\"RecurIterations\"]")).sendKeys("5");
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_Fields_DurationField_0 > button.button.simpleSubHeaderButton")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Duration".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='select_list']/descendant::*[text() = '30 minutes']")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_NoteField_6']/button")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Notes".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("textarea[name=\"Notes\"]")).clear();
    driver.findElement(By.cssSelector("textarea[name=\"Notes\"]")).sendKeys("Recurring test activity for Defect# 13091819");
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_Fields_LookupField_29']/button")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Contacts".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_7 > div.table-layout > div > input[name=\"query\"]")).clear();
    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_7 > div.table-layout > div > input[name=\"query\"]")).sendKeys("Adi");
    driver.findElement(By.cssSelector("#Sage_Platform_Mobile_SearchWidget_7 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
    driver.findElement(By.xpath(".//*[@id='contact_related']/ul/li/div/h3")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Meeting".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: navigate to Contacts detail page to view the Activity list...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"Contacts\"]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Contacts".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_6']/div/div[1]/input")).clear();
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_6']/div/div[1]/input")).sendKeys("Adi");
    driver.findElement(By.xpath(".//*[@id='Sage_Platform_Mobile_SearchWidget_6']/div/div[3]/button")).click();
    driver.findElement(By.xpath(".//*[@id='contact_list']/ul/li/div/h3")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Adi, Douglas".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//div[@id='contact_detail']/div[2]/ul[2]/li/a/span")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    try {
      assertTrue(driver.findElement(By.xpath(".//*[@id='activity_related']/ul/li[1]/div[2]/h3/span[3]")).getText().matches("^[\\s\\S]*Lunch meeting$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(driver.findElement(By.xpath(".//*[@id='activity_related']/ul/li[2]/div[2]/h3/span[3]")).getText().matches("^[\\s\\S]*Lunch meeting$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(driver.findElement(By.xpath(".//*[@id='activity_related']/ul/li[3]/div[2]/h3/span[3]")).getText().matches("^[\\s\\S]*Lunch meeting$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(driver.findElement(By.xpath(".//*[@id='activity_related']/ul/li[4]/div[2]/h3/span[3]")).getText().matches("^[\\s\\S]*Lunch meeting$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(driver.findElement(By.xpath(".//*[@id='activity_related']/ul/li[5]/div[2]/h3/span[3]")).getText().matches("^[\\s\\S]*Lunch meeting$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: navigate back to the Home Screen then navigate to the My Activities list view...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[1]/input"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='left_drawer']/descendant::*[text() = \"My Activities\"]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // *** LEFT-OFF HERE ***
    // Step: re-open one of the Activity occurrences to complete it...
    driver.findElement(By.xpath(".//*[@id='myactivity_list']/ul/li[1]/div[2]/h3/span[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Activity".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: Complete this occurrency of the Activity...
    try {
      assertEquals("Complete Occurrence", driver.findElement(By.xpath(".//*[@id='activity_detail']/div[2]/ul/li[1]/a/label")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Complete Series", driver.findElement(By.xpath(".//*[@id='activity_detail']/div[2]/ul/li[2]/a/label")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath(".//*[@id='activity_detail']/div[2]/ul[1]/li[2]/a/label")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Complete Series".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("My Activities".equals(driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Verify: remaining Recurring Activities are still listed in the Activities list view...
    try {
      assertFalse(driver.findElement(By.xpath(".//*[@id='myactivity_list']/ul/li[1]/div[2]/h3/span[3]")).getText().matches("^[\\s\\S]*Lunch meeting$"));
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
