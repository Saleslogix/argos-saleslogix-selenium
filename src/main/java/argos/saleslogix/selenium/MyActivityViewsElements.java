package argos.saleslogix.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyActivityViewsElements {

    //List View elements
    @CacheLookup
    @FindBy(xpath = "//*[@id='myactivity_list_search-expression']")
    public WebElement myActivitiesListViewHeader;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myactivity_list']")
    public WebElement myActivitiesListView;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_related_search-expression']")
    public WebElement relatedActivitiesListViewHeader;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_related']")
    public WebElement relatedActivitiesListView;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myactivity_list']/ul/li[1]")
    public WebElement topMyActivitiesListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myactivity_list']/ul/li[1]/div[1]")
    public WebElement topMyActivitiesListItemTab;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myactivity_list']/ul/li[1]/button")
    public WebElement topMyActivitiesListItemIcon;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='myactivity_list']/ul/li[1]/div[3]/h3/span")
    public WebElement topMyActivitiesListItemRegarding;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myactivity_list']/ul/li[1]/div[3]/h4[1]/strong")
    public WebElement topMyActivitiesListItemStartTime;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myactivity_list']/ul[1]/li[1]/div[3]/h4[2]")
    public WebElement topMyActivitiesListItemContactAccount;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myactivity_list']/ul[1]/li[1]/div[3]/h4[3]")
    public WebElement topMyActivitiesListItemPhone;
    @CacheLookup
    @FindBy(xpath = "//div[@id='bottom_item_indicators']/span[1]/img")
    public WebElement topMyActivitiesListItemAlarm;
    @CacheLookup
    @FindBy(xpath = "//div[@id='bottom_item_indicators']/span[2]/img")
    public WebElement topMyActivitiesListItemTouch;
    @CacheLookup
    @FindBy(xpath = "//div[@id='bottom_item_indicators']/span[3]/img")
    public WebElement topMyActivitiesListItemBang;
    @CacheLookup
    @FindBy(xpath = "//div[@id='bottom_item_indicators']/span[4]/img")
    public WebElement topMyActivitiesListItemRecurring;
    @CacheLookup
    @FindBy(xpath = "//div[@id='bottom_item_indicators']/span[5]/img")
    public WebElement topMyActivitiesListItemType;
    @CacheLookup
    @FindBy(css = "button.footer-item-selector.button")
    public WebElement topMyActivitiesListItemQuickActionsBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myactivity_list']/ul/li[2]/button[8]")
    public WebElement topMyActivitiesListItemQuickActionsAddAttachmentBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myactivity_list']/ul/li[2]/button[7]")
    public WebElement topMyActivitiesListItemQuickActionsCallBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myactivity_list']/ul/li[2]/button[6]")
    public WebElement topMyActivitiesListItemQuickActionsDeclineBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myactivity_list']/ul/li[2]/button[5]")
    public WebElement topMyActivitiesListItemQuickActionsAcceptBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myactivity_list']/ul/li[2]/button[4]")
    public WebElement topMyActivitiesListItemQuickActionsCompleteBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myactivity_list']/ul/li[2]/button[3]")
    public WebElement topMyActivitiesListItemQuickActionsContactBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myactivity_list']/ul/li[2]/button[2]")
    public WebElement topMyActivitiesListItemQuickActionsOpportunityBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myactivity_list']/ul/li[2]/button[1]")
    public WebElement topMyActivitiesListItemQuickActionsAccountBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myactivity_list']/ul/li[11]")
    public WebElement eleventhMyActivitiesListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myactivity_list']/ul/li[21]")
    public WebElement twentyfirstMyActivitiesListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myactivity_list']/ul/li[31]")
    public WebElement thirtyfirstMyActivitiesListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myactivity_list']/div[2]")
    public WebElement recordsRemainingListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='myactivity_list']/div[3]/li/h3")
    public WebElement noRecordsListItem;
    //Context Menu elements
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[1]/input")
    public WebElement myActivitiesSearchTxtBox;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[2]/button")
    public WebElement myActivitiesSearchClearBtn;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_26']/div/div[3]/button")
    public WebElement myActivitiesSearchLookupBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_25']/div/div[1]/input")
    public WebElement relatedActivitiesSearchTxtBox;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_25']/div/div[2]/button")
    public WebElement relatedActivitiesSearchClearBtn;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_25']/div/div[3]/button")
    public WebElement relatedActivitiesSearchLookupBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2[1]")
    public WebElement myActivitiesHashTagsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul[1]")
    public WebElement myActivitiesTagsPnl;
    //Detail View elements
    //TODO: update the Detail View elements
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']")
    public WebElement activityDetailView;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/div[2]/h2[1]")
    public WebElement activityDetailViewQuickActionsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Complete Occurrence']")
    public WebElement activityDetailViewCompleteOccurrenceLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/div[2]/ul[1]/li[1]/a/span")
    public WebElement activityDetailViewCompleteOccurrenceFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Complete Series']")
    public WebElement activityDetailViewCompleteSeriesLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/div[2]/ul[1]/li[2]/a/span")
    public WebElement activityDetailViewCompleteSeriesFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/div[2]/ul[1]/li[3]/a")
    public WebElement activityDetailViewAddNoteLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/div[2]/ul[1]/li[4]/a")
    public WebElement activityDetailViewViewAddressLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/div[2]/h2[2]")
    public WebElement activityDetailViewDetailsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[1]/div[1]")
    public WebElement activityDetailViewAccountFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[1]/div[2]")
    public WebElement activityDetailViewWebFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[1]/div[3]")
    public WebElement activityDetailViewFaxFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[1]/div[4]")
    public WebElement activityDetailViewTypeFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[1]/div[5]")
    public WebElement activityDetailViewSubTypeFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[1]/div[6]")
    public WebElement activityDetailViewStatusFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/div[2]/h2[3]")
    public WebElement activityDetailViewMoreDetailsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[2]")
    public WebElement activityDetailViewMoreDetailsFields;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[2]/div[1]")
    public WebElement activityDetailViewIndustryFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[2]/div[2]")
    public WebElement activityDetailViewBusDescFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[2]/div[3]")
    public WebElement activityDetailViewAcctMgrFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[2]/div[4]")
    public WebElement activityDetailViewOwnerFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/div[2]/div[2]/div[5]")
    public WebElement activityDetailViewLeadSourceFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/div[2]/h2[4]")
    public WebElement activityDetailViewRelatedItemsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Activities']")
    public WebElement activityDetailViewActivitiesLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Contacts']")
    public WebElement activityDetailViewContactsLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Opportunities']")
    public WebElement activityDetailViewOpportunitiesLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Tickets']")
    public WebElement activityDetailViewTicketsLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Notes/History']")
    public WebElement activityDetailViewNotesHistoryLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Addresses']")
    public WebElement activityDetailViewAddressesLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_detail']/descendant::*[text() = 'Attachments']")
    public WebElement activityDetailViewAttachmentsLnk;
    //Edit View elements
    //TODO: update the Edit View elements
    @CacheLookup
    @FindBy(xpath = ".//*[@id='activity_edit']")
    public WebElement activityEditView;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_edit']//descendant::*[@data-dojo-attach-point='inputNode'][2]")
    public WebElement activityEditViewRegardingFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_0']/button")
    public WebElement activityEditViewRegardingFldBtn;
    @CacheLookup
    @FindBy(css = "input[name='Location']")
    public WebElement activityEditViewLocationFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_edit']//descendant::*[@data-dojo-attach-point='inputNode'][4]")
    public WebElement activityEditViewPriorityFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_1']/button")
    public WebElement activityEditViewPriorityFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_edit']//descendant::*[@data-dojo-attach-point='inputNode'][5]")
    public WebElement activityEditViewCategoryFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_2']/button")
    public WebElement activityEditViewCategoryFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='activity_edit']//descendant::*[@data-dojo-attach-point='inputNode'][6]")
    public WebElement activityEditViewStartTimeFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_DateField_0']/button")
    public WebElement activityEditViewStartTimeFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_SelectField_0']/input")
    public WebElement activityEditViewRepeatsFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_SelectField_0']/button")
    public WebElement activityEditViewRepeatsFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_RecurrencesField_0']/div")
    public WebElement activityEditViewRecurringFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_RecurrencesField_0']/button")
    public WebElement activityEditViewRecurringFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_BooleanField_1']/div/span[1]")
    public WebElement activityEditViewTimelessTgl;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_DurationField_0']/input")
    public WebElement activityEditViewDurationFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_DurationField_0']/button")
    public WebElement activityEditViewDurationBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_BooleanField_2']/div/span[1]")
    public WebElement activityEditViewAlarmTgl;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_DurationField_1']/input")
    public WebElement activityEditViewAlarmFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_DurationField_1']/button")
    public WebElement activityEditViewAlarmFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_BooleanField_3']/div/span[1]")
    public WebElement activityEditViewAutoRolloverFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/input")
    public WebElement activityEditViewLeaderFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/button")
    public WebElement activityEditViewLeaderFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_NoteField_0']/textarea")
    public WebElement activityEditViewNotesFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_BooleanField_4']/div/span[1]")
    public WebElement activityEditViewForLeadTgl;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_5']/input")
    public WebElement activityEditViewLeadFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_5']/button")
    public WebElement activityEditViewLeadBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_3']/input")
    public WebElement activityEditViewCompanyFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/input")
    public WebElement activityEditViewAccountFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/button")
    public WebElement activityEditViewAccountBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/input")
    public WebElement activityEditViewContactFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/button")
    public WebElement activityEditViewContactBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_3']/input")
    public WebElement activityEditViewOpportunityFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_3']/button")
    public WebElement activityEditViewOpportunityBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_4']/input")
    public WebElement activityEditViewTicketFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_4']/button")
    public WebElement activityEditViewTicketBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_PhoneField_0']/input")
    public WebElement activityEditViewPhoneFld;
    private WebDriver driver;
    CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

    public MyActivityViewsElements(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    //-------
    public String getMyActivitiesListViewTxt() {
        String methodID = "getMyActivitiesListViewTxt";

        WebElement myActivitiesLisViewInfo = driver.findElement(By.xpath("//*[@id='myactivity_list']/ul"));

        return myActivitiesLisViewInfo.getText();
    }


    /**
     * This method will return a string that consists of all the activity items displayed on the first
     * page of the Activities (related) List view.
     *
     */
    public String getRelatedActivitiesListViewTxt() {
        String methodID = "getRelatedActivitiesListViewTxt";

        WebElement relActivitiesLisViewInfo = driver.findElement(By.xpath("//*[@id='activity_related']/ul"));

        return relActivitiesLisViewInfo.getText();
    }

    /**
     * This method will perform a search for an activity record (using the regarding field value) from the
     * My Activities List view.  The resulting activity search is displayed.
     * @param	regarding	the target Activity's regarding field value
     * @exception InterruptedException
     */
    public void performMyActivitiesSearch(String regarding) throws InterruptedException {
        MyActivityViewsElements activitiesListView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        //Step: execute a filter-free search
        headerButton.showRightContextMenu();
        activitiesListView.myActivitiesSearchTxtBox.click();
        Thread.sleep(500);
        activitiesListView.myActivitiesSearchClearBtn.click();
        Thread.sleep(1000);
        activitiesListView.myActivitiesSearchTxtBox.sendKeys(regarding);
        Thread.sleep(500);
        activitiesListView.myActivitiesSearchLookupBtn.click();
    }


    /**
     * This method will perform a "filter-less" search (no hash-tag & no search string) on the My Activities
     * List view.  The resulting activity search is displayed.
     *
     * @throws InterruptedException
     */
    public void performNoFilterSearch() throws InterruptedException {
        String methodID = "performNoFilterSearch";

        MyActivityViewsElements activitiesListView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        //Step: execute a filter-free search
        headerButton.showRightContextMenu();
        activitiesListView.myActivitiesSearchTxtBox.click();
        Thread.sleep(500);
        activitiesListView.myActivitiesSearchClearBtn.click();
        Thread.sleep(1000);
        activitiesListView.myActivitiesSearchLookupBtn.click();
        Thread.sleep(3000);
    }


    /**
     * This method will perform a search for an activity record (using the regarding field value) from the
     * Activities (related) List view.  The resulting activity search is displayed.
     *
     * @throws InterruptedException
     * @param    regarding    the target Activity's regarding field value
     */
    public void performRelActivitiesSearch(String regarding) throws InterruptedException {
        String methodID = "performRelActivitiesSearch";

        MyActivityViewsElements activitiesListView = PageFactory.initElements(driver, MyActivityViewsElements.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        //Step: execute a Related Activities search
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


    /**
     * This method will search for an activity record (using the regarding field value) from the
     * current Activities (related) List view.  The selected activity record item is open such that
     * the Activity Detail view is opened.
     *
     * @throws InterruptedException
     * @param    regarding    the target Activity's regarding field value
     */
    public void selectNOpenMyActivitiesListItem(String regarding) {
        String methodID = "selectNOpenMyActivitiesListItem";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

        try {
            WebElement activityItemLnk = driver.findElement(By.xpath("//*[@id='myactivity_list']/ul/li[1]/descendant::*[text() = '" + regarding + "']"));
            System.out.println(methodID + ": successfully found, selected and clicked the '" + regarding + "' My Activities List item");
            commNav.highlightNClick(activityItemLnk);
            commNav.waitForNotPage("Activities");
        } catch (Exception e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(methodID + ": unable to find the '" + regarding + "' My Activities List item");
        }

    }


    /**
     * This method will search for an activity record (using the regarding field value) from the
     * current My Activities List view.  The selected activity record item is open such that
     * the Activity Detail view is opened.
     *
     * @throws InterruptedException
     * @param    regarding    the target Activity's regarding field value
     */
    public void selectNOpenRelatedActivityListItem(String regarding) {
        String methodID = "selectRelatedActivityListItem";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

        try {
            WebElement activityItemLnk = driver.findElement(By.xpath("//*[@id='activity_related']/ul/li[1]/descendant::*[text() = '" + regarding + "']"));
            System.out.println(methodID + ": successfully found, selected and clicked the '" + regarding + "' related Activity List item");
            commNav.highlightNClick(activityItemLnk);
            commNav.waitForNotPage("Activities");
        } catch (Exception e) {
            System.out.println(methodID + "(): " + e.toString());
            System.out.println(methodID + ": unable to find the '" + regarding + "' related Activity List item");
        }

    }


    public boolean NoRecordsFound() {
        boolean result = false;

        return result;
    }
}
