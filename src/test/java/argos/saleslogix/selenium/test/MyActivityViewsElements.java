package argos.saleslogix.selenium.test;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Test class that defines WebElements and methods for the Activity based tests against the SLX Mobile Client.
 * 
 * @author	mike.llena@swiftpage.com
 * @version	1.0
 */
public class MyActivityViewsElements extends BaseTest {
	
	private WebDriver driver;

	public MyActivityViewsElements(WebDriver driver) {
		this.driver = driver;		
	}
	
	CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

	//List View elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list_search-expression']")
	WebElement myActivitiesListViewHeader;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']")
	WebElement myActivitiesListView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_related_search-expression']")
	WebElement relatedActivitiesListViewHeader;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_related']")
	WebElement relatedActivitiesListView;	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']//ul/li[1]")
	WebElement topMyActivitiesListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']//ul/li[1]/div[1]")
	WebElement topMyActivitiesListItemTab;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']//ul/li[1]/button")
	WebElement topMyActivitiesListItemIcon;

	@CacheLookup
	@FindBy(xpath = ".//*[@id='myactivity_list']//ul/li[1]/div[2]/h3/span")
	WebElement topMyActivitiesListItemRegarding;
		
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']//ul/li[1]/div[2]/h4[1]/strong")
	WebElement topMyActivitiesListItemStartTime;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']//ul[1]/li[1]/div[2]/h4[2]")
	WebElement topMyActivitiesListItemContactAccount;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']//ul[1]/li[1]/div[2]/h4[3]")
	WebElement topMyActivitiesListItemPhone;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='bottom_item_indicators']/span[1]")
	WebElement topMyActivitiesListItemAlarm;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='bottom_item_indicators']/span[2]")
	WebElement topMyActivitiesListItemTouch;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='bottom_item_indicators']/span[3]")
	WebElement topMyActivitiesListItemBang;
	
	@CacheLookup
	@FindBy(xpath = "//div[@id='bottom_item_indicators']/span[4]")
	WebElement topMyActivitiesListItemRecurring;

	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']//ul/li[1]/button")
	WebElement topMyActivitiesListItemType;
	
	@CacheLookup
	@FindBy(css = "button.footer-item-selector.button")
	WebElement topMyActivitiesListItemQuickActionsBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']//ul/li[2]/button[8]")
	WebElement topMyActivitiesListItemQuickActionsAddAttachmentBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']//ul/li[2]/button[7]")
	WebElement topMyActivitiesListItemQuickActionsCallBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']//ul/li[2]/button[6]")
	WebElement topMyActivitiesListItemQuickActionsDeclineBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']//ul/li[2]/button[5]")
	WebElement topMyActivitiesListItemQuickActionsAcceptBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']//ul/li[2]/button[4]")
	WebElement topMyActivitiesListItemQuickActionsCompleteBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']//ul/li[2]/button[3]")
	WebElement topMyActivitiesListItemQuickActionsContactBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']//ul/li[2]/button[2]")
	WebElement topMyActivitiesListItemQuickActionsOpportunityBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']//ul/li[2]/button[1]")
	WebElement topMyActivitiesListItemQuickActionsAccountBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']//ul/li[11]")
	WebElement eleventhMyActivitiesListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']//ul/li[21]")
	WebElement twentyfirstMyActivitiesListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']//ul/li[31]")
	WebElement thirtyfirstMyActivitiesListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']/div[2]")
	WebElement recordsRemainingListItem;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='myactivity_list']/div[3]/li/h3")
	WebElement noRecordsListItem;
	
	//Context Menu elements
	@CacheLookup
	@FindBy(xpath = "//*[@selected='true']//input[@name='query']")
	WebElement myActivitiesSearchTxtBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@selected='true']//button[@class='clear-button']")
	WebElement myActivitiesSearchClearBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@selected='true']//button[@class='subHeaderButton searchButton']")
	WebElement myActivitiesSearchLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@selected='true']//input[@name='query']")
	WebElement relatedActivitiesSearchTxtBox;
	
	@CacheLookup
	@FindBy(xpath = "//*[@selected='true']//button[@class='clear-button']")
	WebElement relatedActivitiesSearchClearBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@selected='true']//button[@class='subHeaderButton searchButton']")
	WebElement relatedActivitiesSearchLookupBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']/div[3]/h2[1]")
	WebElement myActivitiesHashTagsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='right_drawer']//ul[@data-group='view']")
	WebElement myActivitiesTagsPnl;
	
	//Detail View elements
	//TODO: update the Detail View elements
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']")
	WebElement activityDetailView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/h2[1]")
	WebElement activityDetailViewQuickActionsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Complete Occurrence']")
	WebElement activityDetailViewCompleteOccurrenceLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/ul[1]/li[1]/a/span")
	WebElement activityDetailViewCompleteOccurrenceFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Complete Series']")
	WebElement activityDetailViewCompleteSeriesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/ul[1]/li[2]/a/span")
	WebElement activityDetailViewCompleteSeriesFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/ul[1]/li[3]/a")
	WebElement activityDetailViewAddNoteLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/ul[1]/li[4]/a")
	WebElement activityDetailViewViewAddressLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/h2[2]")
	WebElement activityDetailViewDetailsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[1]/div[1]")
	WebElement activityDetailViewAccountFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[1]/div[2]")
	WebElement activityDetailViewWebFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[1]/div[3]")
	WebElement activityDetailViewFaxFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[1]/div[4]")
	WebElement activityDetailViewTypeFld;

    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[2]/div[1]/span")
    WebElement activityDetailViewStartTimeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[1]/div[5]")
	WebElement activityDetailViewSubTypeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[1]/div[6]")
	WebElement activityDetailViewStatusFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/h2[3]")
	WebElement activityDetailViewMoreDetailsHdr;
		
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[2]")
	WebElement activityDetailViewMoreDetailsFields;	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[2]/div[1]")
	WebElement activityDetailViewIndustryFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[2]/div[2]")
	WebElement activityDetailViewBusDescFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[2]/div[3]")
	WebElement activityDetailViewAcctMgrFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[2]/div[4]")
	WebElement activityDetailViewOwnerFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[2]/div[5]")
	WebElement activityDetailViewLeadSourceFld;

	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/div[2]/h2[4]")
	WebElement activityDetailViewRelatedItemsHdr;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Activities']")
	WebElement activityDetailViewActivitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Contacts']")
	WebElement activityDetailViewContactsLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Opportunities']")
	WebElement activityDetailViewOpportunitiesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Tickets']")
	WebElement activityDetailViewTicketsLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Notes/History']")
	WebElement activityDetailViewNotesHistoryLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Addresses']")
	WebElement activityDetailViewAddressesLnk;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Attachments']")
	WebElement activityDetailViewAttachmentsLnk;
		
	//Edit View elements
	//TODO: update the Edit View elements
	@CacheLookup
	@FindBy(xpath = ".//*[@id='activity_edit']")
	WebElement activityEditView;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_edit']//descendant::*[@data-dojo-attach-point='inputNode'][2]")
	WebElement activityEditViewRegardingFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_0']/button")
	WebElement activityEditViewRegardingFldBtn;
		
	@CacheLookup
	@FindBy(css = "input[name='Location']")
	WebElement activityEditViewLocationFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_edit']//descendant::*[@data-dojo-attach-point='inputNode'][4]")
	WebElement activityEditViewPriorityFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_1']/button")
	WebElement activityEditViewPriorityFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_edit']//descendant::*[@data-dojo-attach-point='inputNode'][5]")
	WebElement activityEditViewCategoryFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_2']/button")
	WebElement activityEditViewCategoryFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_edit']//descendant::*[@data-dojo-attach-point='inputNode'][6]")
	WebElement activityEditViewStartTimeFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_DateField_0']/button")
	WebElement activityEditViewStartTimeFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_SelectField_0']/input")
	WebElement activityEditViewRepeatsFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_SelectField_0']/button")
	WebElement activityEditViewRepeatsFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_RecurrencesField_0']/div")
	WebElement activityEditViewRecurringFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_RecurrencesField_0']/button")
	WebElement activityEditViewRecurringFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_BooleanField_1']/div/span[1]")
	WebElement activityEditViewTimelessTgl;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_DurationField_0']/input")
	WebElement activityEditViewDurationFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_DurationField_0']/button")
	WebElement activityEditViewDurationBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_BooleanField_2']/div/span[1]")
	WebElement activityEditViewAlarmTgl;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_DurationField_1']/input")
	WebElement activityEditViewAlarmFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_DurationField_1']/button")
	WebElement activityEditViewAlarmFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_BooleanField_3']/div/span[1]")
	WebElement activityEditViewAutoRolloverFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/input")
	WebElement activityEditViewLeaderFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/button")
	WebElement activityEditViewLeaderFldBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_NoteField_0']/textarea")
	WebElement activityEditViewNotesFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_BooleanField_4']/div/span[1]")
	WebElement activityEditViewForLeadTgl;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_5']/input")
	WebElement activityEditViewLeadFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_5']/button")
	WebElement activityEditViewLeadBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_3']/input")
	WebElement activityEditViewCompanyFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/input")
	WebElement activityEditViewAccountFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/button")
	WebElement activityEditViewAccountBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/input")
	WebElement activityEditViewContactFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/button")
	WebElement activityEditViewContactBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_3']/input")
	WebElement activityEditViewOpportunityFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_3']/button")
	WebElement activityEditViewOpportunityBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_4']/input")
	WebElement activityEditViewTicketFld;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_4']/button")
	WebElement activityEditViewTicketBtn;
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_0']/input")
	WebElement activityEditViewPhoneFld;
	
	
	@CacheLookup
	@FindBy(xpath = "//*[@id='activity_types_list']//ul/li[1]/div[2]")
	WebElement activityScheduleMeetingBtn;

    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_types_list']//ul/li[3]/div[2]")
    WebElement activitySchedulePhoneCallBtn;

    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_types_list']//ul/li[4]/div[2]")
    WebElement activityScheduleToDoBtn;

    @CacheLookup
    @FindBy(xpath = "//*[@id='select_list']//li[@data-descriptor='Daily']")
    WebElement activityRecurringDailyFld;


    @CacheLookup
    @FindBy(xpath = "//*[@id='select_list']//li[@data-descriptor='Weekly on Sunday']")
    WebElement activityRecurringWeeklyFld;


    @CacheLookup
    @FindBy(xpath = "//div/input[@name='RecurIterations']")
    WebElement activityRecurrenceOccurencesFld;


    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar_access_list']//ul/li[1]//h3")
    WebElement activityLeaderViewUser1;


    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar_access_list']//ul/li[2]//h3")
    WebElement activityLeaderViewUser2;


    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar_access_list']//ul/li[3]//h3")
    WebElement activityLeaderViewUser3;


    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar_access_list']//ul/li[4]//h3")
    WebElement activityLeaderViewUser4;


    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar_access_list']//ul/li[5]//h3")
    WebElement activityLeaderViewUser5;


    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar_access_list']//ul/li[6]//h3")
    WebElement activityLeaderViewUser6;


    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar_access_list']//ul/li[7]//h3")
    WebElement activityLeaderViewUser7;


    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar_access_list']//ul/li[8]//h3")
    WebElement activityLeaderViewUser8;


    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar_access_list']//ul/li[9]//h3")
    WebElement activityLeaderViewUser9;


    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar_access_list']//ul/li[10]//h3")
    WebElement activityLeaderViewUser10;


    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar_access_list']//ul/li[11]//h3")
    WebElement activityLeaderViewUser11;


    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar_access_list']//ul/li[12]//h3")
    WebElement activityLeaderViewUser12;


    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar_access_list']//ul/li[13]//h3")
    WebElement activityLeaderViewUser13;


    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar_access_list']//ul/li[14]//h3")
    WebElement activityLeaderViewUser14;


    @CacheLookup
    @FindBy(xpath = "//*[@id='calendar_access_list']//ul/li[15]//h3")
    WebElement activityLeaderViewUser15;

    //Methods
	//=======
	/**
	 * This method will return a String that represents the contents of the My Activities list view. 
	 * 
	 * @param N/A
	 */
	public String getMyActivitiesListViewTxt() {
		String methodID = "getMyActivitiesListViewTxt";
		
		try {
			WebElement myActivitiesLisViewInfo = driver.findElement(By.xpath("//*[@id='myactivity_list']//ul"));
			
			return myActivitiesLisViewInfo.getText();
		}
		catch (Exception e) {
			System.out.println(methodID + ": " + e.toString());
			return "";
		}
	}
	
	
	/**
	 * This method will return a string that consists of all the activity items displayed on the first
	 * page of the Activities (related) List view.
	 * 
	 * @parameter N/A
	 */
	public String getRelatedActivitiesListViewTxt() {
		String methodID = "getRelatedActivitiesListViewTxt";
		
		try {
			WebElement relActivitiesLisViewInfo = driver.findElement(By.xpath("//*[@id='activity_related']/ul"));
			
			return relActivitiesLisViewInfo.getText();
		}
		catch (Exception e) {
			System.out.println(methodID + ": " + e.toString());
			return "";
		}
	}
	
	
	/**
	 * This method will perform a search for an activity record (using the regarding field value) from the 
	 * My Activities List view.  The resulting activity search is displayed.
	 * 
	 * @param regarding		the target Activity's regarding field value
	 * @throws InterruptedException
	 */
	public void performMyActivitiesSearch(String regarding) throws InterruptedException {
		String methodID = "performMyActivitiesSearch";
		
		MyActivityViewsElements activitiesListView = PageFactory.initElements(driver, MyActivityViewsElements.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class); 
				
		//Step: execute a filter-free search
		try {
			headerButton.showRightContextMenu();
			activitiesListView.myActivitiesSearchTxtBox.click();
			Thread.sleep(500);
			activitiesListView.myActivitiesSearchClearBtn.click();
			Thread.sleep(1000);
			activitiesListView.myActivitiesSearchTxtBox.sendKeys(regarding);
			Thread.sleep(500);
			activitiesListView.myActivitiesSearchLookupBtn.click();
			Thread.sleep(3000);
		}
		catch (Exception e) {
			System.out.println(methodID + ": " + e.toString());
		}
	}
	
	
	/**
	 * This method will perform a "filter-less" search (no hash-tag & no search string) on the My Activities 
	 * List view.  The resulting activity search is displayed.
	 * 
	 * @parameter N/A
	 * @throws InterruptedException
	 */
	public void performNoFilterSearch() throws InterruptedException {
		String methodID = "performNoFilterSearch";
		
		MyActivityViewsElements activitiesListView = PageFactory.initElements(driver, MyActivityViewsElements.class);
		HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class); 
				
		//Step: execute a filter-free search
		try {
			headerButton.showRightContextMenu();
			activitiesListView.myActivitiesSearchTxtBox.click();
			Thread.sleep(500);
			activitiesListView.myActivitiesSearchClearBtn.click();
			Thread.sleep(1000);
			activitiesListView.myActivitiesSearchLookupBtn.click();
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
		
	
	/**
	 * This method will search for an activity record (using the regarding field value) from the 
	 * current Activities (related) List view.  The selected activity record item is open such that
	 * the Activity Detail view is opened.
	 *
	 * @param	regarding	the target Activity's regarding field value
	 */
	public void selectNOpenMyActivitiesListItem(String regarding) {
		String methodID = "selectNOpenMyActivitiesListItem";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

		try {
			WebElement activityItemLnk = driver.findElement(By.xpath("//*[@id='myactivity_list']//ul/li[1]/descendant::*[text() = '" + regarding + "']"));
			System.out.println(methodID + ": successfully found, selected and clicked the '" + regarding + "' My Activities List item");
			commNav.highlightNClick(activityItemLnk);
			commNav.waitForNotPage("Activities");
		}
		catch (Exception e) {
			System.out.println(methodID + "(): " + e.toString());
			System.out.println(methodID + ": unable to find the '" + regarding + "' My Activities List item");
		}
			
	}
	
	
	/**
	 * This method will search for an activity record (using the regarding field value) from the 
	 * current My Activities List view.  The selected activity record item is open such that
	 * the Activity Detail view is opened.
	 *
	 * @param	regarding	the target Activity's regarding field value
	 */
	public void selectNOpenRelatedActivityListItem(String regarding) {
		String methodID = "selectRelatedActivityListItem";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

		try {
			WebElement activityItemLnk = driver.findElement(By.xpath("//*[@id='activity_related']/ul/li[1]/descendant::*[text() = '" + regarding + "']"));
			System.out.println(methodID + ": successfully found, selected and clicked the '" + regarding + "' related Activity List item");
			commNav.highlightNClick(activityItemLnk);
			commNav.waitForNotPage("Activities");
		}
		catch (Exception e) {
			System.out.println(methodID + "(): " + e.toString());
			System.out.println(methodID + ": unable to find the '" + regarding + "' related Activity List item");
		}
			
	}
}
