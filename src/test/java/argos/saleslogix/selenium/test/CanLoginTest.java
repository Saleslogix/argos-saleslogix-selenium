package argos.saleslogix.selenium.test;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;





public class CanLoginTest extends BaseTest {

	@Test
	public void doTest() throws Exception {
		runTests();
	}

	@Test
	public void testBody() throws Exception {
		driver.get(baseUrl + "mobile/products/argos-saleslogix/index-dev.html");
		driver.findElement(By.cssSelector("input[name=\"username\"]")).clear();
		driver.findElement(By.cssSelector("input[name=\"username\"]"))
				.sendKeys("admin");
		driver.findElement(By.cssSelector("button.button.actionButton"))
				.click();
		for (int second = 0;; second++) {
			if (second >= 60)
				Assert.fail("timeout");
			try {
				if (isElementPresent(By.id("pageTitle")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}
}
