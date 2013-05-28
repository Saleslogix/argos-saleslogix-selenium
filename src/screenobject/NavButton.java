package screenobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class NavButton {

	private WebDriver driver;
	
	public NavButton(WebDriver driver) {
		this.driver = driver;		
	}
		
	@CacheLookup
	@FindBy(css = "#navEntitiesAccount > a > span")
	WebElement accounts;
	
	@CacheLookup
	@FindBy(css = "#navEntitiesContactSales > a > span")
	WebElement contacts;
	
	@CacheLookup
	@FindBy(css = "#navEntitiesLeadsSales > a > span")
	WebElement leads;
	
	@CacheLookup
	@FindBy(xpath = "//li[@id='navEntitiesOpportunity']/a/div")
	WebElement opportunities;
	
	@CacheLookup
	@FindBy(css = "#navEntitiesSalesOrders > a > span")
	WebElement salesorders;
	
	@CacheLookup
	@FindBy(css = "#navActivityManagerSales > a > span")
	WebElement activities;
	
	@CacheLookup
	@FindBy(css = "#navCalendarSales > a > span")
	WebElement calendar;
	
	@CacheLookup
	@FindBy(css = "#navEntitiesCampaign > a > span")
	WebElement campaigns;
	
	@CacheLookup
	@FindBy(css = "#navEntitiesTicketSupport > a > span")
	WebElement tickets;
	
	@CacheLookup
	@FindBy(css = "#navEntitiesDefect > a > span")
	WebElement defects;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='MainNav']/descendant::*[text()='Marketing']")
	WebElement clickMarketingHeader;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='MainNav']/descendant::*[text()='Support']")
	WebElement clickSupportHeader;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='MainNav']/descendant::*[text()='Sales']")
	WebElement clickSalesHeader;
	
	//xpathText = ".//*[@id='MainNav']/descendant::*[text()='" + navBarItem + "']";
	//@CacheLookup
	//@FindBy(xpath = xpathText)
	//WebElement clickNavButton;
	
	public WebElement getSafeElement(By locator) throws InterruptedException {
		int i = 0;
		WebElement element = null;
		while (i < 5) {
			try {
				element = driver.findElement(locator);
				element.click();
				break;
			} catch (Exception e) {
				Thread.sleep(1000);
				element = driver.findElement(locator);
				element.click();
			}
		}
		return element;
		}
	
	public NavButton accounts() throws InterruptedException {
		accounts.click();
		Thread.sleep(8000);
		return this;
	}
	
	public NavButton contacts() throws InterruptedException {
		contacts.click();
		Thread.sleep(8000);
		return this;
	}
	
	public NavButton leads() throws InterruptedException {
		leads.click();
		Thread.sleep(8000);
		return this;
	}
	
	public NavButton opportunities() throws InterruptedException {
		opportunities.click();
		Thread.sleep(8000);
		return this;
	}
	
	public NavButton salesorders() throws InterruptedException {
		salesorders.click();
		Thread.sleep(8000);
		return this;
	}
	
	public NavButton activities() throws InterruptedException {
		activities.click();
		Thread.sleep(8000);
		return this;
	}
	
	public NavButton calendar() throws InterruptedException {
		calendar.click();
		Thread.sleep(8000);
		return this;
	}	
	
	public NavButton campaigns() throws InterruptedException {
		campaigns.click();
		Thread.sleep(8000);
		return this;
	}	
	
	public NavButton tickets() throws InterruptedException {
		tickets.click();
		Thread.sleep(8000);
		return this;
	}
	
	public NavButton defects() throws InterruptedException {
		defects.click();
		Thread.sleep(8000);
		return this;
	}
	
	public NavButton clickMarketingHeader() throws InterruptedException {
		clickMarketingHeader.click();
		Thread.sleep(8000);
		return this;
	}
	
	public NavButton clickSupportHeader() throws InterruptedException {
		clickSupportHeader.click();
		Thread.sleep(8000);
		return this;
	}
	
	public NavButton clickSalesHeader() throws InterruptedException {
		clickSalesHeader.click();
		Thread.sleep(8000);
		return this;
	}
}
