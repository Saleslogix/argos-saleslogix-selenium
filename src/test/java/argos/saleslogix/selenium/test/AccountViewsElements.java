package argos.saleslogix.selenium.test;

import java.io.IOException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Test class that defines WebElements and methods for Account entity based tests against the SLX Mobile Client.
 * 
 * @author	mike.llena@swiftpage.com
 * @version	1.0
 */
public class AccountViewsElements extends BaseTest {
	
	private WebDriver driver;

	public AccountViewsElements(WebDriver driver) {
		this.driver = driver;		
	}
	
	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

	//List View elements
	//==================
	@CacheLookup
	@FindBy(xpath = "//*[@selected='true']//input[@name='query']")
	WebElement accountsSearchTxtBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@selected='true']//button[@class='clear-button']")
	WebElement accountsSearchClearBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@selected='true']//button[@class='subHeaderButton searchButton']")
	WebElement accountsSearchLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@selected='true']//input[@name='query']")
	WebElement relatedAccountsSearchTxtBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@selected='true']//button[@class='clear-button']")
	WebElement relatedAccountsSearchClearBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@selected='true']//button[@class='subHeaderButton searchButton']")
	WebElement relatedAccountsSearchLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']/div/ul")
	WebElement accountsListView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_related']//ul")
	WebElement relatedAccountsListView;

    @CacheLookup
    @FindBy(xpath = "//*[@id='account_related']//ul/li[1]")
    WebElement relatedAccountsListViewTopItem;

	@CacheLookup
	@FindBy(xpath = "//div[8]/div[2]/div[2]/div/button")
	WebElement accountsListView1stKPICard;
	
	@CacheLookup
	@FindBy(xpath = "//div[9]/div[2]/div/button")
	WebElement accountsListView2ndKPICard;
	
	@CacheLookup
	@FindBy(xpath = "//div[10]/div[2]/div/button")
	WebElement accountsListView3rdKPICard;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list_search-expression']/div")
	WebElement accountsListView1stHashTagFilter;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MetricWidget_1']/button")
	WebElement accountsListViewKPIBox1;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MetricWidget_2']/button")
	WebElement accountsListViewKPIBox2;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MetricWidget_3']/button")
	WebElement accountsListViewKPIBox3;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']")
	WebElement accountsListViewNotesBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]")
	WebElement accountsListViewNotesBox1stItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[1]/div")
	WebElement accountsListViewNotesBox1stItemInitialsBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[2]/h4[1]/strong")
	WebElement accountsListViewNotesBox1stItemRegarding;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[2]/h4[2]")
	WebElement accountsListViewNotesBox1stItemLastActivity;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[3]/div/h4")
	WebElement accountsListViewNotesBox1stItemNotes;
	
	@CacheLookup
	@FindBy(xpath = "//div[2]/div[4]/div[2]")
	WebElement accountsListViewNotesBoxSeeListLink;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']//ul/li[1]")
	WebElement topAccountsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']//ul/li[1]/button")
	WebElement topAccountsListItemIcon;

    @CacheLookup
    @FindBy(xpath = "//*[@id='account_list']//ul/li[1]/div/h3[1]")
    WebElement topAccountsListItemName;

    @CacheLookup
    @FindBy(xpath = "//*[@id='account_list']//ul/li[1]/div/h4[1]")
    WebElement topAccountsListItemLine2;

    @CacheLookup
    @FindBy(xpath = "//*[@id='account_list']//ul/li[1]/div/h4[2]")
    WebElement topAccountsListItemLine3;

    @CacheLookup
    @FindBy(xpath = "//*[@id='account_list']//ul/li[1]/div/h4[3]")
    WebElement topAccountsListItemLine4;

    @CacheLookup
    @FindBy(xpath = "//*[@id='account_list']//ul/li[1]/div/h4[4]")
    WebElement topAccountsListItemLine5;

    @CacheLookup
    @FindBy(xpath = "//*[@id='account_list']//ul/li[1]/div/h4[5]")
    WebElement topAccountsListItemLine6;

    @CacheLookup
    @FindBy(xpath = "//*[@id='account_list']//ul/li[1]/div/h4[6]")
    WebElement topAccountsListItemLine7;
	
	@CacheLookup
	//@FindBy(css = "#account_list > ul.list-content > li > #bottom_item_indicators > span > img")
    @FindBy(xpath = "//*[@id='bottom_item_indicators']/span/img")
    WebElement topAccountsListItemTouch;
	
	@CacheLookup
	//@FindBy(css = "#account_list > ul.list-content > li > #list-item-footer > div > button.footer-item-selector.button")
    @FindBy(xpath = "//*[@id='list-item-footer']/div/button")
	WebElement topAccountsListItemQuickActionsBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']//ul/li[2]/button[6]")
	WebElement topAccountsListItemQuickActionsAddAttachmentBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']//ul/li[2]/button[5]")
	WebElement topAccountsListItemQuickActionsAddActivityBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']//ul/li[2]/button[4]")
	WebElement topAccountsListItemQuickActionsAddNoteBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']//ul/li[2]/button[3]")
	WebElement topAccountsListItemQuickActionsContactsBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']//ul/li[2]/button[2]")
	WebElement topAccountsListItemQuickActionsCallMainBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']//ul/li[2]/button[1]")
	WebElement topAccountsListItemQuickActionsEditBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']//ul/li[11]")
	WebElement eleventhAccountsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']//ul/li[21]")
	WebElement twentyfirstAccountsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']//ul/li[31]")
	WebElement thirtyfirstAccountsListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']/div[2]")
	WebElement recordsRemainingListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_list']//ul/li/h3")
	WebElement noRecordsListItem;
	
	//Context Menu elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[3]/h2[2]")
	WebElement accountHashTagsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']//ul[@data-group='view']")
	WebElement accountHashTagsPnl;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[3]/h2[2]")
	WebElement accountKPIHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']//ul[@data-group='kpi']")
	WebElement accountKPIPnl;
	
	//Detail View elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']")
	WebElement accountDetailView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/h2[2]")
	WebElement accountDetailViewQuickActionsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div/div[3]/span/a")
	WebElement accountDetailViewCallMainNumberLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/ul[1]/li[1]/a")
	WebElement accountDetailViewScheduleActivityLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/ul[1]/li[2]/a")
	WebElement accountDetailViewAddNoteLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div/div[4]/span/a")
	WebElement accountDetailViewViewAddressLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/h2[1]")
	WebElement accountDetailViewDetailsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div[1]/div[1]/span")
	WebElement accountDetailViewAccountFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div[1]/div[2]/span")
	WebElement accountDetailViewWebFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div/div[5]/span/a")
	WebElement accountDetailViewFaxFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div/div[6]/span")
	WebElement accountDetailViewTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div/div[7]/span")
	WebElement accountDetailViewSubTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div/div[8]/span")
	WebElement accountDetailViewStatusFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/h2[3]")
	WebElement accountDetailViewMoreDetailsHdr;
		
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div[2]")
	WebElement accountDetailViewMoreDetailsFields;	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div/div[9]/span")
	WebElement accountDetailViewIndustryFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div/div[10]/span")
	WebElement accountDetailViewBusDescFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div/div[11]/span")
	WebElement accountDetailViewAcctMgrFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div/div[12]/span")
	WebElement accountDetailViewOwnerFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/div/div[13]/span")
	WebElement accountDetailViewLeadSourceFld;

	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/div[2]/h2[3]")
	WebElement accountDetailViewRelatedItemsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/descendant::*[text() = 'Activities']")
	WebElement accountDetailViewActivitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/descendant::*[text() = 'Contacts']")
	WebElement accountDetailViewContactsLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/descendant::*[text() = 'Opportunities']")
	WebElement accountDetailViewOpportunitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/descendant::*[text() = 'Tickets']")
	WebElement accountDetailViewTicketsLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/descendant::*[text() = 'Notes/History']")
	WebElement accountDetailViewNotesHistoryLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/descendant::*[text() = 'Addresses']")
	WebElement accountDetailViewAddressesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_detail']/descendant::*[text() = 'Attachments']")
	WebElement accountDetailViewAttachmentsLnk;
		
	//Edit View elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_edit']")
	WebElement accountEditView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='account_edit']/div[2]/h2")
	WebElement accountEditViewDetailsHdr;
	
	@CacheLookup
	@FindBy(css = "input[name='AccountName']")
	WebElement accountEditViewAccountInputFld;
	
	@CacheLookup
	@FindBy(css = "input[name='WebAddress']")
	WebElement accountEditViewWebInputFld;
	
	@CacheLookup
	@FindBy(css = "input[name='MainPhone']")
	WebElement accountEditViewPhoneInputFld;
	
	@CacheLookup
	@FindBy(css = "//*[@id='Mobile_SalesLogix_Fields_AddressField_0']/div")
	WebElement accountEditViewAddressFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_0']/button")
	WebElement accountEditViewAddressFldBtn;
	
	@CacheLookup
	@FindBy(css = "input[name='Fax']")
	WebElement accountEditViewFaxInputFld;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_0']/input")
	WebElement accountEditViewTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_0']/button")
	WebElement accountEditViewTypeFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_1']/input")
	WebElement accountEditViewSubTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_1']/button")
	WebElement accountEditViewSubTypeFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_2']/input")
	WebElement accountEditViewStatusFld;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_2']/button")
	WebElement accountEditViewStatusFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_3']/input")
	WebElement accountEditViewIndustryFld;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_3']/button")
	WebElement accountEditViewIndustryFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_NoteField_0']/textarea")
	WebElement accountEditViewBusDescFld;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Sage_Platform_Mobile_Fields_NoteField_0']/button")
	WebElement accountEditViewBusDescFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Sage_Platform_Mobile_Fields_LookupField_0']/input")
	WebElement accountEditViewAcctMgrFld;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Sage_Platform_Mobile_Fields_LookupField_0']/button")
	WebElement accountEditViewAcctMgrFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Sage_Platform_Mobile_Fields_LookupField_1']/input")
	WebElement accountEditViewOwnerFld;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Sage_Platform_Mobile_Fields_LookupField_1']/button")
	WebElement accountEditViewOwnerFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Sage_Platform_Mobile_Fields_LookupField_2']/input")
	WebElement accountEditViewLeadSourceFld;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='Sage_Platform_Mobile_Fields_LookupField_2']/button")
	WebElement accountEditViewLeadSourceFldBtn;
	
	
	//Methods
	//=======
	/**
	 * This method will select and apply a hash-tag on the Accounts List view.  The assumption is that the
	 * hash-tag must exist and be applicable to the Accounts List view.
	 * 
	 * @param	hashTag		Account hash-tag to select; do not pre-pend a "#" symbol in the parameter string
	 * @throws InterruptedException
	 */
	public void applyHashTagFilter(String hashTag) throws InterruptedException {
		String methodID = "applyHashTagFilter";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

		//Step: select the Account hash-tag from the context-menu
		try {
			commNav.rightClickContextMenuItem(hashTag);
			Thread.sleep(3000);
		}
		catch (Exception e) {
			System.out.println(methodID + ": " + e.toString());
		}
	}
	
	
	/**
	 * This method will select and apply a KPI metric on the Accounts List view.  The assumption is that the
	 * KPI metric must exist and be applicable to the Accounts List view.
	 * 
	 * @param	kpiMetric	Account KPI metric to select
	 * @throws InterruptedException
	 */
	public void applyKPIMetric(String kpiMetric) throws InterruptedException {
		String methodID = "applyKPIMetric";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
		
		try {
			//Step: select the Account hash-tag from the context-menu
			commNav.rightClickContextMenuItem(kpiMetric);
			Thread.sleep(500);
			headerButton.closeRightContextMenu();
			Thread.sleep(3000);
		}
		catch (Exception e) {
			System.out.println(methodID + ": " + e.toString());
		}
	}
	
	
	/**
	 * This method will add an auto-generated test Account record by filling-in the Account Edit input fields
	 * then saving the field values.
	 * 
	 * @param	strAccountName	account name to set
	 * @throws InterruptedException, IOException
	 */
	public void doAddRandTestAccount(String strAccountName) throws InterruptedException, IOException {
		String methodID = "doAddRandTestAccount";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
		CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
	    //Step: navigate to Accounts list view
		commNav.clickGlobalMenuItem("Accounts");
		
		//Step: click the Add header button to enter Account edit view
		headerbutton.clickHeaderButton("Add");
		
		//Step: setup new Account field values
		//setup account field		
		accountEditViewAccountInputFld.sendKeys(strAccountName);
		commNav.verifyWebElementValue("Account field", accountEditViewAccountInputFld, strAccountName);
		
		//setup web field
		String sWebVal = "www.SeAutoTestAcct.com";
		accountEditViewWebInputFld.sendKeys(sWebVal);
		
		//setup phone field
		String sPhoneVal = "888-987-6543";
		accountEditViewPhoneInputFld.sendKeys(sPhoneVal);
		
		//setup address fields
		accountEditViewAddressFldBtn.click();
		try {
			//TEMP disable (doesn't work on Jenkins server)
			commView.addressDescriptionInputFld.sendKeys("Mailing");			
			commView.addressPrimaryTgl.click();
			commView.addressShippingTgl.click();
			commView.addressLine1.sendKeys("8800 Mobile St.");
			commView.addressLine2.sendKeys("Corporate Campus");
			commView.addressLine3.sendKeys("Suite 100");
			
			//TEMP: disable City, State & Country selections in favor of direct input field value setting
			//commView.addressCityInputFldBtn.click();
			//commView.selectFieldValListItem("City", "Phoenix");
			commView.addressCityInputFld.sendKeys("Phoenix");
			
			//commView.addressStateInputFldBtn.click();
			//commView.selectFieldValListItem("State", "AZ");
			commView.addressStateInputFld.sendKeys("AZ");
			
			commView.addressPostalInputFld.sendKeys("85048");

			//commView.addressCountryInputFldBtn.click();
			//commView.selectFieldValListItem("Country", "USA");
			commView.addressCountryInputFld.sendKeys("USA");
			
			commView.addressAttentionInputFld.sendKeys("Mr. Rogers");
			headerbutton.clickHeaderButton("check");
		}
		catch (Exception e0) {
			System.out.println(methodID + "(): " + e0.toString());			
			headerbutton.goBack();
		}
		
		//setup fax field
		accountEditViewFaxInputFld.sendKeys("480-987-6543");
		
		//setup type field
		if (commNav.isFieldValueEmpty("Type", accountEditViewTypeFld)) {
			accountEditViewTypeFld.sendKeys("Partner");
		}
		
		//setup subtype field
		accountEditViewSubTypeFld.sendKeys("Reseller");
		
		//setup status field
		if (commNav.isFieldValueEmpty("Status", accountEditViewStatusFld)) {
			accountEditViewStatusFld.sendKeys("Active");
		}
		
		//setup industry field
		accountEditViewIndustryFld.sendKeys("Computers/Electronics/High Tech");
		
		//setup bus desc field
		accountEditViewBusDescFld.sendKeys("Business Description - Random Automated Test Account");
		Thread.sleep(3000);
		//commView.setBusDescription("Business Description - Random Automated Test Account");
		
		//setup acct mgr field
		if (commNav.isFieldValueEmpty("Acct Mgr", accountEditViewAcctMgrFld)) {
			accountEditViewAcctMgrFldBtn.click();
			commView.selectFieldValListItem("Acct Mgr", "Hogan");			
		}
		
		//setup owner field
		if (commNav.isFieldValueEmpty("Acct Mgr", accountEditViewOwnerFld)) {
			accountEditViewOwnerFldBtn.click();
			commView.selectFieldValListItem("User", "Everyone");
		}
		
		//setup lead source field
		//TODO: re-enable after server error is resolved from the Lead Sources list view		
//		accountEditViewLeadSourceFldBtn.click();
//		commView.selectLeadSource("None");		
		
		//Step: save the new Account field values
		headerbutton.clickHeaderButton("save");
		commNav.waitForNotPage("Account");
		
		System.out.println(methodID + ": Auto-test Account - " +  strAccountName + " record was created.");
	}
	
	
	/**
	 * This method will search for then click a target Account record from the Accounts List view in order
	 * to open the Account record's Detail view. 
	 * 
	 * @param strAcctName	name of a target Account record to find and open
	 * @return boolean	whether or not a specific Account record is displayed in the list view
	 * @throws	InterruptedException, Exception
	 */	
	public boolean doSearchAccount(String strAcctName) throws InterruptedException, Exception {
		String methodID = "doSearchAccount";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
			
	    //Step: search for then click to open the target Account record detail view
		try {
			commNav.highlightNClick(commNav.entityListViewSearch("Accounts", strAcctName));
			
			//Step: confirm Account record detail view is displayed
			if (commNav.waitForPage(strAcctName)) {
				return true;
			}
			else {		
				return false;
			}
		}
		catch (Exception e) {
			System.out.println(methodID + "(): " + e.toString());
			return false;
		}
	}
	
	
	/**
	 * This method captures the contents of the Accounts List view and return the same contents in a string. 
	 * 
	 * @param N/A
	 * @return String Accounts list view info
	 */	
	public String getAccountsListViewTxt() {
		String methodID = "getAccountsListViewTxt";
		
		try {
			WebElement accountsLisViewInfo = driver.findElement(By.xpath("//*[@id='account_list']//ul"));
			
			return accountsLisViewInfo.getText();
		}
		catch (Exception e) {
			System.out.println(methodID + ": "  + e.toString());
			return null;
		}
	}
	
	
	/**
	 * This method returns a boolean value to determine if the 'no record' result is displayed on the Accounts
	 * List view. 
	 * 
	 * @param strAcctName		name of a target Account record to find and open
	 * @return boolean		whether or not the 'no record' result it displayed in the Accounts list view
	 * @throws InterruptedException 
	 */	
	public boolean noRecordsFoundCheck() throws InterruptedException {
		String methodID = "noRecordsFoundCheck";

		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		boolean result = false;
		String noRecsTxt = "no records";
		
		try {
			if (commNav.isTextPresentOnPage(noRecsTxt)) { 
				result = true;
			}
			else {
				result = false;
			}
			return result;
		}
		catch (Exception e) {
			System.out.println(methodID + ": " + e.toString());
			return false;
		}
	}


	/**
	 * This method will perform a "filter-less" search (no hash-tag & no search string) on the Accounts 
	 * List view.  The resulting Activities search is displayed in the List view.
	 * 
	 * @param N/A
	 * @throws InterruptedException
	 */
	public void performNoFilterSearch() throws InterruptedException {
		String methodID = "performNoFilterSearch";
		
		AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class); 
				
		//Step: execute a filter-free search
		try {
		headerButton.showRightContextMenu();
		accountsListView.accountsSearchTxtBox.click();
		Thread.sleep(500);
		accountsListView.accountsSearchClearBtn.click();
		Thread.sleep(1000);
		accountsListView.accountsSearchLookupBtn.click();
		Thread.sleep(3000);
		}
		catch (Exception e) {
			System.out.println(methodID + ": " + e.toString());
		} 
	}


	/**
	 * This method will perform a search for an activity record (using the regarding field value) from the 
	 * Activities (related) List view.  The resulting activity search is displayed.
	 * 
	 * @param	regarding	the target Activity's regarding field value
	 * @throws InterruptedException
	 */
	public void performRelActivitiesSearch(String regarding) throws InterruptedException {
		String methodID = "performRelActivitiesSearch";
		
		MyActivityViewsElements activitiesListView = PageFactory.initElements(driver, MyActivityViewsElements.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class); 
				
		//Step: execute a Related Activities search
		try {
			headerButton.showRightContextMenu();
			activitiesListView.relatedActivitiesSearchTxtBox.click();
			Thread.sleep(500);
			activitiesListView.relatedActivitiesSearchClearBtn.click();
			Thread.sleep(1000);
			activitiesListView.relatedActivitiesSearchTxtBox.sendKeys(regarding);
			Thread.sleep(500);
			activitiesListView.relatedActivitiesSearchLookupBtn.click();
			Thread.sleep(3000);
		}
		catch (Exception e) {
			System.out.println(methodID + ": " + e.toString());
		}
	}
}
