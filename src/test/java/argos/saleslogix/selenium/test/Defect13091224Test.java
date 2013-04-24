package argos.saleslogix.selenium.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.openqa.selenium.By;

public class Defect13091224Test extends BaseTest {
	@Test
	public void doTest() throws Exception {
		runTests();
	}

	public void testBody() throws Exception {
		// Open Mobile build
		driver.get(baseUrl + "mobile/products/argos-saleslogix/index-dev.html");
		// Login as Lee
		driver.findElement(By.cssSelector("input[name=\"username\"]")).clear();
		driver.findElement(By.cssSelector("input[name=\"username\"]"))
				.sendKeys("lee");
		driver.findElement(By.cssSelector("button.button.actionButton"))
				.click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By
						.cssSelector("div.list-item-content > h3")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		// Click Add Account/ Contact button
		driver.findElement(By.cssSelector("div.list-item-content > h3"))
				.click();
		// Validate title of 'Add Account / Contact'
		try {
			assertTrue(isElementPresent(By.xpath(".//*[@id='pageTitle']")));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		// Wait for element present - Account Type
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By
						.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_1 > input[type=\"text\"]")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		// Verify Account Type preset to Prospect
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if ("Prospect"
						.equals(driver
								.findElement(
										By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_1 > input[type=\"text\"]"))
								.getAttribute("value")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		// Wait for element present - Account Status
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By
						.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_3 > input[type=\"text\"]")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		// Verify Account Status preset to Active
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if ("Active"
						.equals(driver
								.findElement(
										By.cssSelector("#Mobile_SalesLogix_Fields_PicklistField_3 > input[type=\"text\"]"))
								.getAttribute("value")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		// Warning: verifyTextPresent may require manual changes
		try {
			assertTrue(driver.findElement(By.cssSelector("BODY")).getText()
					.matches("^[\\s\\S]*Log Out[\\s\\S]*$"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}
}
