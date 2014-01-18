package argos.saleslogix.selenium.test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContactViewsElements extends BrowserSetup {
	
	private WebDriver driver;

	public ContactViewsElements(WebDriver driver) {
		this.driver = driver;		
	}
	
	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

	//List View elements
	//------------------
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_6']/div/div[1]/input")
	WebElement contactsSearchTxtBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_6']/div/div[2]/button")
	WebElement contactsSearchClearBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_6']/div/div[3]/button")
	WebElement contactsSearchLookupBtn;

	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']")
	WebElement contactsListViewPnl;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']")
	WebElement contactsListViewNotesBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]")
	WebElement contactsListViewNotesBox1stItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[1]/div")
	WebElement contactsListViewNotesBox1stItemInitialsBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[2]/h4[1]/strong")
	WebElement contactsListViewNotesBox1stItemRegarding;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[2]/h4[2]")
	WebElement contactsListViewNotesBox1stItemLastActivity;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[3]/div/h4")
	WebElement contactsListViewNotesBox1stItemNotes;
	
	@CacheLookup
	@FindBy(xpath = "//div[2]/div[4]/div[2]")
	WebElement contactsListViewNotesBoxSeeListLink;

	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul")
	WebElement contactsListViewHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MetricWidget_1']/button")
	WebElement contactsListViewMetricsBox1;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul")
	WebElement contactsListView;
	
	@CacheLookup
	@FindBy(xpath = "//div[7]/div[2]/div/button")
	WebElement contactsListView1stKPICard;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list_search-expression']/div")
	WebElement contactsListView1stHashTagFilter;
	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[1]")
	WebElement topContactsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[1]/button")
	WebElement topContactsListItemIcon;	

	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[1]/div[3]/h3")
	WebElement topContactsListItemName;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[1]/div[3]/h4[1]")
	WebElement topContactsListItemLine2;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[1]/div[3]/h4[3]")
	WebElement topContactsListItemLine3;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[1]/div[3]/h4[4]")
	WebElement topContactsListItemLine4;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[1]/div[3]/h4[5]")
	WebElement topContactsListItemLine5;
	
	@CacheLookup
	@FindBy(css = "#contact_list > ul.list-content > li > #bottom_item_indicators > span > img")
	WebElement topContactsListItemTouch;
	
	@CacheLookup
	@FindBy(css = "#contact_list > ul.list-content > li > #list-item-footer > div > button.footer-item-selector.button")
	WebElement topContactsListItemQuickActionsBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[2]/button[8]")
	WebElement topContactsListItemQuickActionsAddAttachmentBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[2]/button[7]")
	WebElement topContactsListItemQuickActionsAddActivityBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[2]/button[6]")
	WebElement topContactsListItemQuickActionsAddNoteBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[2]/button[5]")
	WebElement topContactsListItemQuickActionsEmailBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[2]/button[4]")
	WebElement topContactsListItemQuickActionsAccountBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[2]/button[3]")
	WebElement topContactsListItemQuickActionsCallMobileBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[2]/button[2]")
	WebElement topContactsListItemQuickActionsCallWorkBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li[2]/button[1]")
	WebElement topContactsListItemQuickActionsEditBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul[2]/li[11]")
	WebElement eleventhContactsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul[2]/li[21]")
	WebElement twentyfirstContactsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul[2]/li[31]")
	WebElement thirtyfirstContactsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/div[2]/div/span")
	WebElement recordsRemainingListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_list']/ul/li/h3")
	WebElement noRecordsListItem;
	
	//Context Menu elements
	//---------------------
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2[1]")
	WebElement contactsHashTagsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul[1]")
	WebElement contactsHashTagsPnl;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2[2]")
	WebElement contactsKPIHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul[2]")
	WebElement contactsKPIPnl;
	
	//Detail View elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']")
	WebElement contactsDetailView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/h2[1]")
	WebElement contactsDetailViewQuickActionsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Call main number']")
	WebElement contactsDetailViewCallMainNumberLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Call mobile']")
	WebElement contactsDetailViewCallMobileLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Send email']")
	WebElement contactsDetailViewSendEmailLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Schedule activity']")
	WebElement contactsDetailViewScheduleActivityLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Add note']")
	WebElement contactsDetailViewAddNoteLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'View address']")
	WebElement contactsDetailViewViewAddressLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/h2[2]")
	WebElement contactsDetailViewDetailsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[1]/div[1]")
	WebElement contactsDetailViewContactFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[1]/div[2]")
	WebElement contactsDetailViewAccountFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[1]/div[3]")
	WebElement contactsDetailViewWebFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[1]/div[4]")
	WebElement contactsDetailViewTitleFld;
		
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/h2[3]")
	WebElement contactsDetailViewMoreDetailsHdr;
		
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]")
	WebElement contactsDetailViewMoreDetailsFields;	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[1]")
	WebElement contactsDetailViewHomePhoneFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[2]")
	WebElement contactsDetailViewFaxFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[3]")
	WebElement contactsDetailViewAcctMgrFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[4]")
	WebElement contactsDetailViewOwnerFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[5]")
	WebElement contactsDetailViewCuisineFld;

	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/div[2]/h2[4]")
	WebElement contactsDetailViewRelatedItemsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Activities']")
	WebElement contactsDetailViewActivitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Opportunities']")
	WebElement contactsDetailViewOpportunitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Tickets']")
	WebElement contactsDetailViewTicketsLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Notes/History']")
	WebElement contactsDetailViewNotesHistoryLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Addresses']")
	WebElement contactsDetailViewAddressesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Attachments']")
	WebElement contactsDetailViewAttachmentsLnk;
		
	//Edit View elements
	//------------------
	//TODO: the Contact Edit fields need to be updated when needed
	@CacheLookup
	@FindBy(xpath = "//*[@id='contact_edit']")
	WebElement contactsEditView;
	
	@CacheLookup
	@FindBy(css= "#Mobile_SalesLogix_Fields_PicklistField_1 > input[type='text']")
	WebElement contactsEditViewCuisineFld;
	
	@CacheLookup
	@FindBy(css = "#Mobile_SalesLogix_Fields_PicklistField_1 > button.button.simpleSubHeaderButton")
	WebElement contactsEditViewCuisineFldBtn;
	
	@CacheLookup
	@FindBy(css = "input[name='WebAddress']")
	WebElement contactsEditViewWebFld;
	
	@CacheLookup
	@FindBy(css = "input[name='WorkPhone']")
	WebElement contactsEditViewPhoneFld;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_AddressField_0']/div")
	WebElement contactsEditViewAddressFld;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_AddressField_0']/button")
	WebElement contactsEditViewAddressFldBtn;
	
	@CacheLookup
	@FindBy(css = "input[name='Email']")
	WebElement contactsEditViewEmailFld;
	
	@CacheLookup
	@FindBy(css = "input[name='Fax']")
	WebElement contactsEditViewFaxFld;
	
	@CacheLookup
	@FindBy(xpath = "(//input[@type='text'])[11]")
	WebElement contactsEditViewTitleFld;
	
	@CacheLookup
	@FindBy(css = "#Mobile_SalesLogix_Fields_PicklistField_0 > button.button.simpleSubHeaderButton")
	WebElement contactsEditViewTitleFldBtn;
	
	@CacheLookup
	@FindBy(css = "input[name='HomePhone']")
	WebElement contactsEditViewHomePhoneFld;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Sage_Platform_Mobile_Fields_LookupField_0']/input")
	WebElement contactsEditViewAccountFld;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Sage_Platform_Mobile_Fields_LookupField_0']/button")
	WebElement contactsEditViewAccountFldBtn;
	
	@CacheLookup
	@FindBy(css = "#Sage_Platform_Mobile_Fields_LookupField_1 > input[type='text']")
	WebElement contactsEditViewAcctMgrFld;
	
	@CacheLookup
	@FindBy(css = "#Sage_Platform_Mobile_Fields_LookupField_1 > button.button.simpleSubHeaderButton")
	WebElement contactsEditViewAcctMgrFldBtn;
	
	@CacheLookup
	@FindBy(css = "input[name='Mobile']")
	WebElement contactsEditViewMobileFld;
	
	@CacheLookup
	@FindBy(css = "input[type='text']")
	WebElement contactsEditViewNameFld;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_NameField_0']/button")
	WebElement contactsEditViewNameFldBtn;
	
	@CacheLookup
	@FindBy(css = "#Sage_Platform_Mobile_Fields_LookupField_2 > input[type='text']")
	WebElement contactsEditViewOwnerFld;
	
	@CacheLookup
	@FindBy(css = "#Sage_Platform_Mobile_Fields_LookupField_2 > button.button.simpleSubHeaderButton")
	WebElement contactsEditViewOwnerFldBtn;
	
	//Methods
	//-------
	public String getContactsListViewTxt() {
		String methodID = "getContactsListViewTxt";
		String listViewTxt = "";
		
		try {
			WebElement contactsLisViewInfo = driver.findElement(By.xpath("//*[@id='contact_list']/ul"));
			listViewTxt = contactsLisViewInfo.getText();
		}
		catch (Exception excptn) {
			System.out.println(excptn.toString());
		}
		
		return listViewTxt;		
	}
	
	
	public boolean NoRecordsFound() {
		boolean result = false;
		
		return result;
	}


	//Methods
		//=======
		/**
		 * This method will add an auto-generated test Contact record by filling-in the Contact Edit input fields.
		 * The Contact will have a unique string appended to the Last Name in order to ensure uniqueness.
		 * @author	mike.llena@swiftpage.com
		 * @version	1.0
		 * @param	strContactLastName	contact last name to set
		 * @param	strContactFirstName	contact first name to set
		 * @param	strContactAccount	account record to associate this contact with
		 * @throws Exception 
		 */
		public void doAddRandTestContact(String strContactLastName, String strContactFirstName, String strContactAccount) throws Exception {
			String methodID = "doAddRandTestContact";
			
			CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
			HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
			CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
			
			System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
			
		    //Step: navigate to Contacts list view
			commNav.clickGlobalMenuItem("Contacts");
			
			//Step: click the Add header button to enter Contact edit view
			headerButton.clickHeaderButton("Add");
			
			//Step: setup new Contact field values
			//setup name fields		
			contactsEditViewNameFldBtn.click();
				//TEMP: disable Name Prefix selection in favor of direct input field value setting
				commView.namePrefixInputFld.sendKeys("Mr.");
				commView.nameFirstInputFld.sendKeys(strContactFirstName);
				commView.nameMiddleInputFld.sendKeys("Neo");
				commView.nameLastInputFld.sendKeys(strContactLastName);
				commView.nameSuffixInputFld.sendKeys("Sr.");
				headerButton.clickHeaderButton("check");
				
			//setup account field
			contactsEditViewAccountFldBtn.click();
				commNav.highlightNClick(commNav.entityListViewSelect("Accounts", strContactAccount));
			
			//conditionaly setup web field	
			if (commNav.isFieldValueEmpty("Web", contactsEditViewWebFld)) {
				contactsEditViewWebFld.sendKeys("www.saleslogix.com");
			}
			
			//conditionally setup phone field
			if (commNav.isFieldValueEmpty("Phone", contactsEditViewPhoneFld)) {
				contactsEditViewPhoneFld.sendKeys("888-867-5309");
			}
			
			//setup email field
			contactsEditViewEmailFld.sendKeys("theone@boguscompany.com");
			
			//setup title field
			contactsEditViewTitleFld.sendKeys("Principal");
			
			//conditionally setup address fields
			if (contactsEditViewAddressFld.getText().equals("")) {
				contactsEditViewAddressFldBtn.click();
				//TEMP disable selection views (doesn't work on Jenkins server)				
				commView.addressPrimaryTgl.click();
				commView.addressShippingTgl.click();
				commView.addressLine1.sendKeys("8800 Mobile St.");
				commView.addressLine2.sendKeys("Corporate Campus");
				commView.addressLine3.sendKeys("Suite 100");
				commView.addressCityInputFld.sendKeys("Phoenix");				
				commView.addressStateInputFld.sendKeys("AZ");				
				commView.addressPostalInputFld.sendKeys("85048");
				commView.addressCountryInputFld.sendKeys("USA");				
				commView.addressAttentionInputFld.sendKeys("Mr. Rogers");
				headerButton.clickHeaderButton("check");
			}				
			
			//setup home phone field
			contactsEditViewHomePhoneFld.sendKeys("(480)-867-5309");
			
			//setup mobile field
			contactsEditViewMobileFld.sendKeys("(602)-867-5309");

			//setup fax field
			contactsEditViewFaxFld.sendKeys("(866)-867-5309");
			
			//conditionally setup acct mgr field
			if (commNav.isFieldValueEmpty("Acct Mgr", contactsEditViewAcctMgrFld)) {
				contactsEditViewAcctMgrFldBtn.click();
				commNav.highlightNClick(commNav.entityListViewSearch("Users", "Hogan"));				
			}
			
			//conditionally setup owner field
			if (commNav.isFieldValueEmpty("Owner", contactsEditViewOwnerFld)) {
				//TEMP disable - doesn't work for Trinity DB
				contactsEditViewOwnerFld.sendKeys("Midwest");
			}
			
			//setup cuisine field
			contactsEditViewCuisineFldBtn.click();
				commView.selectFieldValListItem("Cuisine", "Chinese");
				headerButton.clickHeaderButton("check");
			
			//Step: save the new Contact field values
			commNav.waitForPage("Contact");
			headerButton.clickHeaderButton("save");
			commNav.waitForNotPage("Contact");
			
			System.out.println(methodID + ": Auto-test Contact - " +  strContactLastName + ", " + strContactLastName + " record was created under the '" + strContactAccount + "' Account.");
		}


		//TODO: finish doSearchAccount() method
		public boolean doSearchContact(String strContactName) throws InterruptedException, Exception {
			String methodID = "doSearchContact";
			
			CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
			HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
			CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
				
		    //Step: search for then click to open Contact record detail view
			commNav.highlightNClick(commNav.entityListViewSearch("Contacts", strContactName));
			
			//Step: confirm Account record detail view is displayed
			if (commNav.waitForNotPage("Contacts")) {
				return true;
			}
			else {		
				return false;
			}
		}
}
