package argos.saleslogix.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NotesHistoryViewsElements {

    //List View elements
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_27']/div/div[1]/input")
    public WebElement notesHistorysSearchTxtBox;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_27']/div/div[2]/button")
    public WebElement notesHistorysSearchClearBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_27']/div/div[3]/button")
    public WebElement notesHistorysSearchLookupBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_list']/ul")
    public WebElement notesHistorysListView;
    @CacheLookup
    @FindBy(xpath = "//div[9]/div[2]/div/button")
    public WebElement notesHistorysListView1stKPICard;
    @CacheLookup
    @FindBy(xpath = "//div[10]/div[2]/div/button")
    public WebElement notesHistorysListView2ndKPICard;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_list_search-expression']/div")
    public WebElement notesHistorysListView1stHashTagFilter;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_list']/ul/li[1]")
    public WebElement topNotesHistoryListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_list']/ul/li[1]/div[1]")
    public WebElement topNotesHistoryListItemTab;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_list']/ul/li[1]/button")
    public WebElement topNotesHistoryListItemIcon;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_list']/ul/li[1]/div/h3")
    public WebElement topNotesHistoryListItemScheduledTime;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_list']/ul/li[1]/div[3]/h4[1]")
    public WebElement topNotesHistoryListItemContactAccount;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_list']/ul/li[1]/div[3]/h4[2]")
    public WebElement topNotesHistoryListItemRegarding;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_list']/ul/li[1]/div[3]/div/div")
    public WebElement topNotesHistoryListItemNotes;
    @CacheLookup
    @FindBy(css = "#history_list > ul.list-content > li > #bottom_item_indicators > span > img")
    public WebElement topNotesHistoryListItemTouch;
    @CacheLookup
    @FindBy(css = "#history_list > ul.list-content > li > #list-item-footer > div > button.footer-item-selector.button")
    public WebElement topNotesHistoryListItemQuickActionsBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_list']/ul/li[2]/button[4]")
    public WebElement topNotesHistoryListItemQuickActionsAddAttachmentBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_list']/ul/li[2]/button[3]")
    public WebElement topNotesHistoryListItemQuickActionsContactsBtn;

    //TODO: figure out the css identifier for the ToDo icon that is right of the touch icon
    /*
    @CacheLookup
	@FindBy(css = "#history_list > ul.list-content > li > #bottom_item_indicators > span > img")
	public WebElement topNotesHistoryListItemTouch;
	*/
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_list']/ul/li[2]/button[2]")
    public WebElement topNotesHistoryListItemQuickActionsOpportunityBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_list']/ul/li[2]/button[1]")
    public WebElement topNotesHistoryListItemQuickActionsAccountBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_list']/ul/li[11]")
    public WebElement eleventhNotesHistoryListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_list']/ul/li[21]")
    public WebElement twentyfirstNotesHistoryListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_list']/ul/li[31]")
    public WebElement thirtyfirstNotesHistoryListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_list']/div[2]")
    public WebElement recordsRemainingListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_list']/ul/li/h3")
    public WebElement noRecordsListItem;
    //Context Menu elements
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2[1]")
    public WebElement notesHistoryHashTagsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul[1]")
    public WebElement notesHistoryHashTagsPnl;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2[2]")
    public WebElement notesHistoryKPIHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul[2]")
    public WebElement notesHistoryKPIPnl;
    //Detail View elements
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_detail']")
    public WebElement notesHistoryDetailView;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_detail']/div[2]/h2[1]")
    public WebElement notesHistoryDetailViewDetailsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_detail']/div[2]/div[1]/div[1]")
    public WebElement notesHistoryDetailViewScheduledFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_detail']/div[2]/div[1]/div[2]")
    public WebElement notesHistoryDetailViewCompletedFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_detail']/div[2]/div[1]/div[3]")
    public WebElement notesHistoryDetailViewRegardingFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_detail']/div[2]/div[1]/div[4]")
    public WebElement notesHistoryDetailViewCompletedByFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_detail']/div[2]/h2[2]")
    public WebElement notesHistoryDetailViewNotesHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_detail']/div[2]/div[2]")
    public WebElement notesHistoryDetailViewNotesFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_detail']/div[2]/h2[3]")
    public WebElement notesHistoryDetailRelatedItems1Hdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_detail']/div[2]/div[3]/div[1]")
    public WebElement notesHistoryDetailViewAccountFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_detail']/div[2]/div[3]/div[2]")
    public WebElement notesHistoryDetailViewContactFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_detail']/div[2]/div[3]/div[3]")
    public WebElement notesHistoryDetailViewOpportunityFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_detail']/div[2]/div[3]/div[4]")
    public WebElement notesHistoryDetailViewTicketFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_detail']/div[2]/h2[4]")
    public WebElement notesHistoryDetailRelatedItems2Hdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='history_detail']/div[2]/ul/li/a")
    public WebElement notesHistoryDetailViewAttachmentsLnk;
    //Edit View elements
    @CacheLookup
    @FindBy(xpath = ".//*[@id='history_edit']")
    public WebElement notesHistoryEditView;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_DateField_0']/input")
    public WebElement notesHistoryEditViewTimeInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_DateField_0']/button")
    public WebElement notesHistoryEditViewTimeFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_0']/input")
    public WebElement notesHistoryEditViewRegardingInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_0']/button")
    public WebElement notesHistoryEditViewRegardingFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextAreaField_0']/textarea")
    public WebElement notesHistoryEditViewNotesInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_BooleanField_1']/div/span[1]")
    public WebElement notesHistoryEditViewForLeadToggleBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/input")
    public WebElement notesHistoryEditViewAccountInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/button")
    public WebElement notesHistoryEditViewAccountFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/input")
    public WebElement notesHistoryEditViewContactInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/button")
    public WebElement notesHistoryEditViewContactFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/input")
    public WebElement notesHistoryEditViewOpportunityInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/button")
    public WebElement notesHistoryEditViewOpportunityFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_3']/input")
    public WebElement notesHistoryEditViewTicketInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_3']/button")
    public WebElement notesHistoryEditViewTicketFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_4']/input")
    public WebElement notesHistoryEditViewLeadInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_4']/button")
    public WebElement notesHistoryEditViewLeadFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_2']/input")
    public WebElement notesHistoryEditViewCompanyInputFld;
    private WebDriver driver;
    CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

    public NotesHistoryViewsElements(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    //-------
    public String getNotesHistoryListViewTxt() {
        String methodID = "getNotesHistoryListViewTxt";

        WebElement notesHistoryLisViewInfo = driver.findElement(By.xpath("//*[@id='history_list']/ul"));

        return notesHistoryLisViewInfo.getText();
    }


    public boolean NoRecordsFound() {
        boolean result = false;

        return result;
    }


    /**
     * This method will add an auto-generated test Note record by filling-in the Note Edit input fields.
     * The Note will have a unique string appended to the Note Regarding field in order to ensure uniqueness.
     *
     * @param strRegarding     regarding value
     * @param strNotes         notes to identify the record
     * @param blnForLead       if true then for lead, false otherwise
     * @param strLeadOrAccount lead or account record
     * @throws Exception
     */
    public void doAddRandTestNote(String strRegarding, String strNotes, boolean blnForLead, String strLeadOrAccount) throws Exception {
        String methodID = "doAddRandTestNote";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);

        //Step: navigate to Notes/History list view
        commNav.clickGlobalMenuItemNotes();

        //Step: click the Add header button to enter Notes/History edit view
        headerButton.clickAdd();

        //Step: setup new Note field values
        //setup Time field (leave as-is)

        //setup Regarding fields
        notesHistoryEditViewRegardingInputFld.sendKeys(strRegarding);

        //setup Notes field
        notesHistoryEditViewNotesInputFld.sendKeys(strNotes);

        //set For Lead toggle
        if (blnForLead) {
            //set Lead field
            notesHistoryEditViewLeadFldBtn.click();
            commNav.highlightNClick(commNav.entityListViewSelect("Leads", strLeadOrAccount));
        } else {
            //set Account field
            notesHistoryEditViewAccountFldBtn.click();
            commNav.highlightNClick(commNav.entityListViewSelect("Accounts", strLeadOrAccount));
        }
        //TO-DO: complete selection of remaining non-required fields

        //Step: save the new Note field values
        headerButton.clickSave();
        commNav.waitForNotPage("Note");

        System.out.println(methodID + ": Auto-test Note/History - " + strNotes + " record was created.");
    }


    public boolean doSearchNote(String strNoteInfo) throws InterruptedException, Exception {
        String methodID = "doSearchNote";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);

        //Step: search for then click to open Opportunity record detail view
        commNav.highlightNClick(commNav.entityListViewSearch("Notes/History", strNoteInfo));

        //Step: confirm Note record detail view is displayed
        if (commNav.waitForNotPage("Notes/History")) {
            return true;
        } else {
            return false;
        }
    }
}
