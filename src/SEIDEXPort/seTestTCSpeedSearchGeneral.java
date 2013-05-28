package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeTestTCSpeedSearchGeneral {
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
  public void testSeTestTCSpeedSearchGeneral() throws Exception {
    // SE Test: SETest-TC-SpeedSearch-General
    // Version: 2.2
    // Desc: performs general searches to validate Global Search functionality
    // Required Entity: TYPE - NAME
    // ====================================
    // Step: click Top-Left button to reveal Global Menu...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[1]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("div.group-content > ul.list-content. > li"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: UI element check
    assertTrue(isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]")));
    assertTrue(isElementPresent(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")));
    // -- Section: Execute some global searches in the mobile client
    // Step: perform 1st global search...
    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]")).clear();
    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div > input[name=\"query\"]")).sendKeys("blackberry");
    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_0 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
    assertEquals("Search Results", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath(".//*[@id='speedsearch_list']/ul/li[1]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: check search results...
    // Warning: verifyTextNotPresent may require manual changes
    try {
      assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Training[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Ticket[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Reu[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: click to open the top Search Results link...
    driver.findElement(By.xpath(".//*[@id='speedsearch_list']/ul/li[1]/h3")).click();
    // Warning: verifyTextNotPresent may require manual changes
    try {
      assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*SearchResults[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("History", driver.findElement(By.id("pageTitle")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Training", driver.findElement(By.xpath("//div[@id='history_detail']/div[2]/div/div[3]/span")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: navigate back...
    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Search Results".equals(driver.findElement(By.id("pageTitle")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: reset the Search then nav back to Home...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_1']/div/div[2]/button")).click();
    // Step: perform 2nd global search...
    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).clear();
    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).sendKeys("blackberri");
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[3]/button")).click();
    assertEquals("Search Results", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("#speedsearch_list > ul.list-content > li"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: check search results...
    // Warning: verifyTextNotPresent may require manual changes
    try {
      assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Training[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Ticket[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Reu[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: reset the Search the nav back to Home...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_1']/div/div[2]/button")).click();
    // Step: perform 3rd global search...
    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).clear();
    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).sendKeys("blackbarry");
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_0']/div/div[3]/button")).click();
    assertEquals("Search Results", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("#speedsearch_list > ul.list-content > li"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: check search results...
    // Warning: verifyTextNotPresent may require manual changes
    try {
      assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Training[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Ticket[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Reu[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: reset the Search the nav back to Home...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_1']/div/div[2]/button")).click();
    // Step: perform 4th global search...
    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).clear();
    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).sendKeys("black berry");
    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
    assertEquals("Search Results", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("#speedsearch_list > ul.list-content > li"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: check search results...
    // Warning: verifyTextNotPresent may require manual changes
    try {
      assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Al Bahar[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Jennifer Blake[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Bass Beer and Wine Co[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: reset the Search the nav back to Home...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_1']/div/div[2]/button")).click();
    // Step: perform 5th global search...
    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).clear();
    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).sendKeys("advisinh");
    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
    assertEquals("Search Results", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("#speedsearch_list > ul.list-content > li"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: check search results...
    // Warning: verifyTextNotPresent may require manual changes
    try {
      assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Advising Group[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Jurgenson Advisory[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Advising Group Test Opp[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: reset the Search the nav back to Home...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_1']/div/div[2]/button")).click();
    // Step: perform 6th global search...
    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).clear();
    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).sendKeys("world");
    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
    assertEquals("Search Results", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("#speedsearch_list > ul.list-content > li"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: check search results...
    // Warning: verifyTextNotPresent may require manual changes
    try {
      assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*World Electrical[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*World Beers[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Abbott WorldWide-Phase[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: reset the Search the nav back to Home...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_1']/div/div[2]/button")).click();
    // Step: perform 7th global search...
    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).clear();
    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).sendKeys("sophia");
    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
    assertEquals("Search Results", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("#speedsearch_list > ul.list-content > li"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: check search results...
    // Warning: verifyTextNotPresent may require manual changes
    try {
      assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Drakes Cycle Shop -Phase-1[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Neil Shiff[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Drakes Cycle Shop[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: reset the Search the nav back to Home...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_1']/div/div[2]/button")).click();
    // Step: perform 8th global search...
    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).clear();
    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div > input[name=\"query\"]")).sendKeys("sophia perez");
    driver.findElement(By.cssSelector("#Mobile_SalesLogix_SpeedSearchWidget_1 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton")).click();
    assertEquals("Search Results", driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText());
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("#speedsearch_list > ul.list-content > li"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Step: check search results...
    // Warning: verifyTextNotPresent may require manual changes
    try {
      assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*no records[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Database Change[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*status[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Sophia Perez[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // Step: reset the Search the nav back to Home...
    driver.findElement(By.xpath(".//*[@id='Mobile_SalesLogix_SpeedSearchWidget_1']/div/div[2]/button")).click();
    // -- End Section
    // Step: navigate back to Home...
    driver.findElement(By.xpath("//div[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[2]")).click();
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
