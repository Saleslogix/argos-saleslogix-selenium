package argos.saleslogix.selenium.test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LeadViewsElements extends BrowserSetup {
	
	private WebDriver driver;

	public LeadViewsElements(WebDriver driver) {
		this.driver = driver;		
	}
	
	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

	//List View elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_3']/div/div[1]/input")
	WebElement leadsSearchTxtBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_3']/div/div[2]/button")
	WebElement leadsSearchClearBtn;
	
	@CacheLookup
	@FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_3']/div/div[3]/button")
	WebElement leadsSearchLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul")
	WebElement leadsListView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[1]")
	WebElement topleadsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[1]/button")
	WebElement topleadsListItemIcon;	

	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[1]/div/h3")
	WebElement topleadsListItemName;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[1]/div/h4[1]")
	WebElement topleadsListItemLine2;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[1]/div/h4[2]")
	WebElement topleadsListItemLine3;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[1]/div/h4[3]")
	WebElement topleadsListItemLine4;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[1]/div/h4[4]")
	WebElement topleadsListItemLine5;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[11]")
	WebElement eleventhleadsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[21]")
	WebElement twentyfirstleadsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li[31]")
	WebElement thirtyfirstleadsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/div[3]")
	WebElement recordsRemainingListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_list']/ul/li/h3")
	WebElement noRecordsListItem;
	
	//Detail View elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']")
	WebElement leadDetailView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/h2[1]")
	WebElement leadDetailViewQuickActionsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/ul[1]/li[1]/a")
	WebElement leadDetailViewCallMainNumberLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/ul[1]/li[2]/a")
	WebElement leadDetailViewScheduleActivityLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/ul[1]/li[3]/a")
	WebElement leadDetailViewAddNoteLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/ul[1]/li[4]/a")
	WebElement leadDetailViewViewAddressLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/h2[2]")
	WebElement leadDetailViewDetailsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[1]")
	WebElement leadDetailViewleadFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[2]")
	WebElement leadDetailViewWebFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[3]")
	WebElement leadDetailViewFaxFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[4]")
	WebElement leadDetailViewTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[5]")
	WebElement leadDetailViewSubTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[6]")
	WebElement leadDetailViewStatusFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/h2[3]")
	WebElement leadDetailViewMoreDetailsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[1]")
	WebElement leadDetailViewIndustryFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[2]")
	WebElement leadDetailViewBusDescFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[3]")
	WebElement leadDetailViewAcctMgrFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[4]")
	WebElement leadDetailViewOwnerFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[5]")
	WebElement leadDetailViewLeadSourceFld;

	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/div[2]/h2[4]")
	WebElement leadDetailViewRelatedItemsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/descendant::*[text() = 'Activities']")
	WebElement leadDetailViewActivitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/descendant::*[text() = 'Contacts']")
	WebElement leadDetailViewContactsLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/descendant::*[text() = 'Opportunities']")
	WebElement leadDetailViewOpportunitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/descendant::*[text() = 'Tickets']")
	WebElement leadDetailViewTicketsLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/descendant::*[text() = 'Notes/History']")
	WebElement leadDetailViewNotesHistoryLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/descendant::*[text() = 'Addresses']")
	WebElement leadDetailViewNotesAddressesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='lead_detail']/descendant::*[text() = 'Attachments']")
	WebElement leadDetailViewNotesAttachmentsLnk;
	
	
	//Edit View elements

	
	//Methods
	public boolean NoRecordsFound() {
		boolean result = false;
		
		return result;
	}
}
