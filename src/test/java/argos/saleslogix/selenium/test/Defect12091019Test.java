package argos.saleslogix.selenium.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

public class Defect12091019Test extends BaseTest {

	//@Test // TODO: This test is not asserting the right view. It should be ticket activities not ticket detail.
	public void doTest() throws Exception {
		runTests();
	}

	public void testBody() throws Exception {
		// SE Test: SETest-Defect_12091019
		// Desc: validates that 'elapsed hours' used in Ticket Activity - More
		// Details edit view
		// Required Entity: Ticket 000-00-000011
		// ====================================
		// 'Step: navigate to Home screen...
		doLogin("lee");
		// Step: navigate to Tickets list view...
		driver.findElement(
				By.xpath("//div[@id='home']/div[3]/ul[2]/li[8]/div[2]/h3"))
				.click();
		// Step: perform ticket search...
		driver.findElement(
				By.cssSelector("#Sage_Platform_Mobile_SearchWidget_18 > div.table-layout > div > input[name=\"query\"]"))
				.clear();
		driver.findElement(
				By.cssSelector("#Sage_Platform_Mobile_SearchWidget_18 > div.table-layout > div > input[name=\"query\"]"))
				.sendKeys("000-00-000011");
		driver.findElement(
				By.cssSelector("#Sage_Platform_Mobile_SearchWidget_18 > div.table-layout > div.hasButton > button.subHeaderButton.searchButton"))
				.click();
		// Step: navigate to target Ticket record...
		driver.findElement(
				By.cssSelector("#ticket_list > ul.list-content > li > div.list-item-content > h3"))
				.click();
		// Step: expand Ticket Details - More Details section...
		driver.findElement(
				By.xpath("//div[@id='ticket_detail']/div[2]/ul[2]/li[2]/a/span"))
				.click();
		driver.findElement(By.cssSelector("h3")).click();
		// VP: check that "elapsed hours" field is available...
		try {
			assertEquals(
					"elapsed hours",
					driver.findElement(
							By.xpath(".//*[@id='ticketactivity_detail']/div[2]/div[2]/div[2]/label"))
							.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		// 'End: navigate back to Home...
		driver.findElement(
				By.xpath(".//*[@id='Mobile_SalesLogix_Views_MainToolbar_0']/button[3]"))
				.click();
	}
}
