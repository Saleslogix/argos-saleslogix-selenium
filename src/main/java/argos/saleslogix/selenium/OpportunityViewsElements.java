package argos.saleslogix.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OpportunityViewsElements {

    //List View elements
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[1]/input")
    public WebElement opportunitySearchTxtBox;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[2]/button")
    public WebElement opportunitySearchClearBtn;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_11']/div/div[3]/button")
    public WebElement opportunitySearchLookupBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_list']/ul")
    public WebElement opportunityListViewRecords;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_list']/ul/li[1]")
    public WebElement topOpportunityListItem;
    @CacheLookup
    @FindBy(xpath = "//div[5]/div[2]/div/button")
    public WebElement opportunityListView1stKPICard;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_list_search-expression']/div")
    public WebElement opportunityListView1stHashTagFilter;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_list']/ul/li[1]/div[1]")
    public WebElement topOpportunityListItemTab;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_list']/ul/li[1]/button")
    public WebElement topOpportunityListItemIcon;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_list']/ul/li[1]/div/h3")
    public WebElement topOpportunityListItemName;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_list']/ul/li[1]/div[3]/h4[1]")
    public WebElement topOpportunityListItemAccount;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_list']/ul/li[1]/div[3]/h4[2]")
    public WebElement topOpportunityListItemAcctMgrInfo;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_list']/ul/li[1]/div[3]/h4[3]")
    public WebElement topOpportunityListItemStatusInfo;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_list']/ul/li[1]/div[3]/h4[4]/strong")
    public WebElement topOpportunityListItemSalesPotOppRate;
    @CacheLookup
    @FindBy(css = "#opportunity_list > ul.list-content > li > #bottom_item_indicators > span > img")
    public WebElement topOpportunityListItemTouch;
    @CacheLookup
    @FindBy(css = "#opportunity_list > ul.list-content > li > #list-item-footer > div > button.footer-item-selector.button")
    public WebElement topOpportunityListItemQuickActionsBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_list']/ul/li[2]/button[7]")
    public WebElement topOpportunityListItemQuickActionsAddAttachmentBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_list']/ul/li[2]/button[6]")
    public WebElement topOpportunityListItemQuickActionsAddActivityBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_list']/ul/li[2]/button[5]")
    public WebElement topOpportunityListItemQuickActionsAddNoteBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_list']/ul/li[2]/button[4]")
    public WebElement topOpportunityListItemQuickActionsProductsBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_list']/ul/li[2]/button[3]")
    public WebElement topOpportunityListItemQuickActionsContactsBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_list']/ul/li[2]/button[2]")
    public WebElement topOpportunityListItemQuickActionsAccountBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_list']/ul/li[2]/button[1]")
    public WebElement topOpportunityListItemQuickActionsEditBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_list']/ul/li[11]")
    public WebElement eleventhOpportunityListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_list']/ul/li[21]")
    public WebElement twentyfirstOpportunityListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_list']/ul/li[31]")
    public WebElement thirtyfirstOpportunityListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_list']/div[2]")
    public WebElement recordsRemainingListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_list']/ul/li/h3")
    public WebElement noRecordsListItem;
    //Context Menu elements
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2[1]")
    public WebElement opportunityHashTagsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul[1]")
    public WebElement opportunityHashTagsPnl;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_list']")
    public WebElement opportunityListViewPnl;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']")
    public WebElement opportunityListViewNotesBox;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]")
    public WebElement opportunityListViewNotesBox1stItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[1]/div")
    public WebElement opportunityListViewNotesBox1stItemInitialsBox;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[2]/h4[1]/strong")
    public WebElement opportunityListViewNotesBox1stItemRegarding;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[2]/h4[2]")
    public WebElement opportunityListViewNotesBox1stItemLastActivity;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[3]/div/h4")
    public WebElement opportunityListViewNotesBox1stItemNotes;
    @CacheLookup
    @FindBy(xpath = "//div[2]/div[4]/div[2]")
    public WebElement opportunityListViewNotesBoxSeeListLink;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2[2]")
    public WebElement opportunityKPIHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul[2]")
    public WebElement opportunityKPIPnl;
    //Detail View elements
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']")
    public WebElement opportunityDetailView;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/h2[1]")
    public WebElement opportunityDetailViewQuickActionsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/ul[1]/li[1]/a")
    public WebElement opportunityDetailViewScheduleActivityLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/ul[1]/li[2]/a")
    public WebElement opportunityDetailViewAddNoteLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/h2[2]")
    public WebElement opportunityDetailViewDetailsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[1]")
    public WebElement opportunityDetailViewOpportunityFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[2]")
    public WebElement opportunityDetailViewAcctFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[3]")
    public WebElement opportunityDetailViewResellerFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[4]")
    public WebElement opportunityDetailViewEstCloseFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[5]")
    public WebElement opportunityDetailViewStatusFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[6]")
    public WebElement opportunityDetailViewTypeFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[7]")
    public WebElement opportunityDetailViewCloseProbFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[8]")
    public WebElement opportunityDetailViewSalesPotentialBaseRateFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[9]")
    public WebElement opportunityDetailViewSalesPotentialMyRateFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[1]/div[10]")
    public WebElement opportunityDetailViewSalesPotentialOppRateFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/h2[2]")
    public WebElement opportunityDetailViewMultiCurrencyHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[2]")
    public WebElement opportunityDetailViewMultiCurrencyFields;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[2]/div[1]")
    public WebElement opportunityDetailViewExchangeRateFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[2]/div[2]")
    public WebElement opportunityDetailViewCodeFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[2]/div[3]")
    public WebElement opportunityDetailViewRateDateFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[2]/div[4]")
    public WebElement opportunityDetailViewRateLockedFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/h2[3]")
    public WebElement opportunityDetailViewMoreDetailsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[2]")
    public WebElement opportunityDetailViewMoreDetailsFields;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[2]/div[1]")
    public WebElement opportunityDetailViewAcctMgrFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/div[2]/div[2]")
    public WebElement opportunityDetailViewLeadSourceFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/div[2]/h2[4]")
    public WebElement opportunityDetailViewRelatedItemsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/descendant::*[text() = 'Products']")
    public WebElement opportunityDetailViewProductsLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/descendant::*[text() = 'Activities']")
    public WebElement opportunityDetailViewActivitiesLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/descendant::*[text() = 'Opportunity Contacts']")
    public WebElement opportunityDetailViewOpportunityContactsLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/descendant::*[text() = 'Notes/History']")
    public WebElement opportunityDetailViewNotesHistoryLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_detail']/descendant::*[text() = 'Attachments']")
    public WebElement opportunityDetailViewAttachmentsLnk;
    //Edit View elements
    @CacheLookup
    @FindBy(xpath = ".//*[@id='opportunity_edit']")
    public WebElement opportunityEditView;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_edit']/descendant::*[@name='Description'][2]")
    public WebElement opportunityEditViewOpportunityInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/input")
    public WebElement opportunityEditViewAccountInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/input")
    public WebElement opportunityEditViewAcctInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_0']/button")
    public WebElement opportunityEditViewAcctFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/input")
    public WebElement opportunityEditViewAcctMgrInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_1']/button")
    public WebElement opportunityEditViewAcctMgrFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/input")
    public WebElement opportunityEditViewResellerInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_2']/button")
    public WebElement opportunityEditViewResellerFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_DateField_0']/input")
    public WebElement opportunityEditViewEstCloseInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_DateField_0']/button")
    public WebElement opportunityEditViewEstCloseFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_0']/input")
    public WebElement opportunityEditViewSalesPotentialInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_MultiCurrencyField_0']/span")
    public WebElement opportunityEditViewSalesPotentialCurrencyFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_0']/input")
    public WebElement opportunityEditViewTypeInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_0']/button")
    public WebElement opportunityEditViewTypeFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_1']/input")
    public WebElement opportunityEditViewStatusInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_1']/button")
    public WebElement opportunityEditViewStatusFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_3']/input")
    public WebElement opportunityEditViewLeadSourceInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_3']/button")
    public WebElement opportunityEditViewLeadSourceFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_4']/input")
    public WebElement opportunityEditViewOwnerInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_4']/button")
    public WebElement opportunityEditViewOwnerFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_2']/input")
    public WebElement opportunityEditViewCloseProbInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_2']/button")
    public WebElement opportunityEditViewCloseProbFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_edit']/div[2]/fieldset[2]/div[1]")
    public WebElement opportunityEditViewExchangeRateFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_TextField_2']/input")
    public WebElement opportunityEditViewExchangeRateInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_edit']/div[2]/fieldset[2]/div[2]")
    public WebElement opportunityEditViewCodeFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_5']/input")
    public WebElement opportunityEditViewCodeInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_LookupField_5']/button")
    public WebElement opportunityEditViewCodeFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_edit']/div[2]/fieldset[2]/div[3]")
    public WebElement opportunityEditViewRateLockedFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_BooleanField_1']/div/span[2]")
    public WebElement opportunityEditViewRateLockedToggle;
    @CacheLookup
    @FindBy(xpath = "//*[@id='opportunity_edit']/div[2]/fieldset[2]/div[4]")
    public WebElement opportunityEditViewRateDateFld;
    private WebDriver driver;
    CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

    public OpportunityViewsElements(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    //-------
    public String getOpportunityListViewTxt() {
        String methodID = "getOpportunityListViewTxt";

        WebElement OpportunityLisViewInfo = driver.findElement(By.xpath("//*[@id='opportunity_list']/ul"));

        return OpportunityLisViewInfo.getText();
    }


    public boolean NoRecordsFound() {
        boolean result = false;

        return result;
    }


    /**
     * This method will add an auto-generated test Opportunity record by filling-in the Opportunity Edit input fields.
     * The Opportunity will have a unique string appended to the Opportunity Name in order to ensure uniqueness.
     *
     * @throws Exception
     * @author mike.llena@swiftpage.com
     * @version 1.0
     * @param    strOppName    lead last name to set
     * @param    strOppAccount    lead first name to set
     */
    public void doAddRandTestOpportunity(String strOppName, String strOppAccount) throws Exception {
        String methodID = "doAddRandTestOpportunity";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);

        //Step: navigate to Opportunity list view
        commNav.clickGlobalMenuItem("Opportunities");

        //Step: click the Add header button to enter Opportunity edit view
        headerButton.clickHeaderButton("Add");

        //Step: setup new Opportunity field values
        //setup Opportunity fields
        opportunityEditViewOpportunityInputFld.sendKeys(strOppName);

        //setup acct field
        opportunityEditViewAcctFldBtn.click();
        commNav.highlightNClick(commNav.entityListViewSelect("Accounts", strOppAccount));

        //TO-DO: complete selection of remaining non-required fields

        //Step: save the new Opportunity field values
        headerButton.clickHeaderButton("save");
        commNav.waitForNotPage("Opportunity");

        System.out.println(methodID + ": Auto-test Opportunity - " + strOppName + " record was created.");
    }


    public boolean doSearchOpportunity(String strOppName) throws InterruptedException, Exception {
        String methodID = "doSearchOpportunity";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);

        //Step: search for then click to open Opportunity record detail view
        commNav.highlightNClick(commNav.entityListViewSearch("Opportunities", strOppName));

        //Step: confirm Opportunity record detail view is displayed
        if (commNav.waitForNotPage("Opportunities")) {
            return true;
        } else {
            return false;
        }
    }


    //Methods
    public String getOpportunitiesListViewTxt() {
        String methodID = "getOpportunitiesListViewTxt";
        String listViewTxt = "";

        try {
            WebElement oppsLisViewInfo = driver.findElement(By.xpath("//*[@id='opportunity_list']/ul"));
            listViewTxt = oppsLisViewInfo.getText();
        } catch (Exception e) {
            System.out.println(methodID + "(): " + e.toString());
        }

        return listViewTxt;
    }
}
