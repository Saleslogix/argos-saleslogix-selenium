package argos.saleslogix.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

/**
 * Class that defines WebElements and methods for the Account entity views on the Mobile Client.
 */
public class AccountViewsElements {

    //List View elements
    //==================
    
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_3']/div/div[1]/input")
    public WebElement accountsSearchTxtBox;
    
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_3']/div/div[2]/button")
    public WebElement accountsSearchClearBtn;
    
    @FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_3']/div/div[3]/button")
    public WebElement accountsSearchLookupBtn;
    
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_4']/div/div[1]/input")
    public WebElement relatedAccountsSearchTxtBox;
    
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_4']/div/div[2]/button")
    public WebElement relatedAccountsSearchClearBtn;
    
    @FindBy(xpath = ".//*[@id='Sage_Platform_Mobile_SearchWidget_4']/div/div[3]/button")
    public WebElement relatedAccountsSearchLookupBtn;
    
    @FindBy(xpath = "//*[@id='account_list']/ul")
    public WebElement accountsListView;
    
    @FindBy(xpath = "//*[@id='account_related']/ul")
    public WebElement relatedAccountsListView;
    
    @FindBy(xpath = "//div[8]/div[2]/div/button")
    public WebElement accountsListView1stKPICard;
    
    @FindBy(xpath = "//div[9]/div[2]/div/button")
    public WebElement accountsListView2ndKPICard;
    
    @FindBy(xpath = "//div[10]/div[2]/div/button")
    public WebElement accountsListView3rdKPICard;
    
    @FindBy(xpath = "//*[@id='account_list_search-expression']/div")
    public WebElement accountsListView1stHashTagFilter;
    
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MetricWidget_1']/button")
    public WebElement accountsListViewKPIBox1;
    
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MetricWidget_2']/button")
    public WebElement accountsListViewKPIBox2;
    
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MetricWidget_3']/button")
    public WebElement accountsListViewKPIBox3;
    
    @FindBy(xpath = "//*[@id='itemsNode']")
    public WebElement accountsListViewNotesBox;
    
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]")
    public WebElement accountsListViewNotesBox1stItem;
    
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[1]/div")
    public WebElement accountsListViewNotesBox1stItemInitialsBox;
    
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[2]/h4[1]/strong")
    public WebElement accountsListViewNotesBox1stItemRegarding;
    
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[2]/h4[2]")
    public WebElement accountsListViewNotesBox1stItemLastActivity;
    
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[3]/div/h4")
    public WebElement accountsListViewNotesBox1stItemNotes;
    
    @FindBy(xpath = "//div[2]/div[4]/div[2]")
    public WebElement accountsListViewNotesBoxSeeListLink;
    
    @FindBy(xpath = "//*[@id='account_list']/ul/li[1]")
    public WebElement topAccountsListItem;
    
    @FindBy(xpath = "//*[@id='account_list']/ul/li[1]/button")
    public WebElement topAccountsListItemIcon;
    
    @FindBy(xpath = "//*[@id='account_list']/ul/li[1]/div/h3")
    public WebElement topAccountsListItemName;
    
    @FindBy(xpath = "//*[@id='account_list']/ul/li[1]/div/h4[1]")
    public WebElement topAccountsListItemLine2;
    
    @FindBy(xpath = "//*[@id='account_list']/ul/li[1]/div/h4[2]")
    public WebElement topAccountsListItemLine3;
    
    @FindBy(xpath = "//*[@id='account_list']/ul/li[1]/div/h4[3]")
    public WebElement topAccountsListItemLine4;
    
    @FindBy(xpath = "//*[@id='account_list']/ul/li[1]/div/h4[4]")
    public WebElement topAccountsListItemLine5;
    
    @FindBy(xpath = "//*[@id='account_list']/ul/li[1]/div/h4[5]")
    public WebElement topAccountsListItemLine6;
    
    @FindBy(xpath = "//*[@id='account_list']/ul/li[1]/div/h4[6]")
    public WebElement topAccountsListItemLine7;
    
    @FindBy(css = "#account_list > ul.list-content > li > #bottom_item_indicators > span > img")
    public WebElement topAccountsListItemTouch;
    
    @FindBy(css = "#account_list > ul.list-content > li > #list-item-footer > div > button.footer-item-selector.button")
    public WebElement topAccountsListItemQuickActionsBtn;
    
    @FindBy(xpath = "//*[@id='account_list']/ul/li[2]/button[6]")
    public WebElement topAccountsListItemQuickActionsAddAttachmentBtn;
    
    @FindBy(xpath = "//*[@id='account_list']/ul/li[2]/button[5]")
    public WebElement topAccountsListItemQuickActionsAddActivityBtn;
    
    @FindBy(xpath = "//*[@id='account_list']/ul/li[2]/button[4]")
    public WebElement topAccountsListItemQuickActionsAddNoteBtn;
    
    @FindBy(xpath = "//*[@id='account_list']/ul/li[2]/button[3]")
    public WebElement topAccountsListItemQuickActionsContactsBtn;
    
    @FindBy(xpath = "//*[@id='account_list']/ul/li[2]/button[2]")
    public WebElement topAccountsListItemQuickActionsCallMainBtn;
    
    @FindBy(xpath = "//*[@id='account_list']/ul/li[2]/button[1]")
    public WebElement topAccountsListItemQuickActionsEditBtn;
    
    @FindBy(xpath = "//*[@id='account_list']/ul/li[11]")
    public WebElement eleventhAccountsListItem;
    
    @FindBy(xpath = "//*[@id='account_list']/ul/li[21]")
    public WebElement twentyfirstAccountsListItem;

    @FindBy(xpath = "//*[@id='account_list']/ul/li[31]")
    public WebElement thirtyfirstAccountsListItem;

    @FindBy(xpath = "//*[@id='account_list']/div[2]")
    public WebElement recordsRemainingListItem;

    @FindBy(xpath = "//*[@id='account_list']/ul/li/h3")
    public WebElement noRecordsListItem;
    //Context Menu elements

    @FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2[1]")
    public WebElement accountHashTagsHdr;

    @FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul[1]")
    public WebElement accountHashTagsPnl;

    @FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2[2]")
    public WebElement accountKPIHdr;

    @FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul[2]")
    public WebElement accountKPIPnl;
    //Detail View elements

    @FindBy(xpath = "//*[@id='account_detail']")
    public WebElement accountDetailView;

    @FindBy(xpath = "//*[@id='account_detail']/div[2]/h2[1]")
    public WebElement accountDetailViewQuickActionsHdr;

    @FindBy(xpath = "//*[@id='account_detail']/div[2]/ul[1]/li[1]/a")
    public WebElement accountDetailViewCallMainNumberLnk;

    @FindBy(xpath = "//*[@id='account_detail']/div[2]/ul[1]/li[2]/a")
    public WebElement accountDetailViewScheduleActivityLnk;

    @FindBy(xpath = "//*[@id='account_detail']/div[2]/ul[1]/li[3]/a")
    public WebElement accountDetailViewAddNoteLnk;

    @FindBy(xpath = "//*[@id='account_detail']/div[2]/ul[1]/li[4]/a")
    public WebElement accountDetailViewViewAddressLnk;

    @FindBy(xpath = "//*[@id='account_detail']/div[2]/h2[2]")
    public WebElement accountDetailViewDetailsHdr;

    @FindBy(xpath = "//*[@id='account_detail']/div[2]/div[1]/div[1]/span")
    public WebElement accountDetailViewAccountFld;

    @FindBy(xpath = "//*[@id='account_detail']/div[2]/div[1]/div[2]/span")
    public WebElement accountDetailViewWebFld;

    @FindBy(xpath = "//*[@id='account_detail']/div[2]/div[1]/div[3]")
    public WebElement accountDetailViewFaxFld;

    @FindBy(xpath = "//*[@id='account_detail']/div[2]/div[1]/div[4]")
    public WebElement accountDetailViewTypeFld;

    @FindBy(xpath = "//*[@id='account_detail']/div[2]/div[1]/div[5]")
    public WebElement accountDetailViewSubTypeFld;

    @FindBy(xpath = "//*[@id='account_detail']/div[2]/div[1]/div[6]")
    public WebElement accountDetailViewStatusFld;

    @FindBy(xpath = "//*[@id='account_detail']/div[2]/h2[3]")
    public WebElement accountDetailViewMoreDetailsHdr;

    @FindBy(xpath = "//*[@id='account_detail']/div[2]/div[2]")
    public WebElement accountDetailViewMoreDetailsFields;

    @FindBy(xpath = "//*[@id='account_detail']/div[2]/div[2]/div[1]")
    public WebElement accountDetailViewIndustryFld;

    @FindBy(xpath = "//*[@id='account_detail']/div[2]/div[2]/div[2]")
    public WebElement accountDetailViewBusDescFld;

    @FindBy(xpath = "//*[@id='account_detail']/div[2]/div[2]/div[3]")
    public WebElement accountDetailViewAcctMgrFld;

    @FindBy(xpath = "//*[@id='account_detail']/div[2]/div[2]/div[4]")
    public WebElement accountDetailViewOwnerFld;

    @FindBy(xpath = "//*[@id='account_detail']/div[2]/div[2]/div[5]")
    public WebElement accountDetailViewLeadSourceFld;

    @FindBy(xpath = "//*[@id='account_detail']/div[2]/h2[4]")
    public WebElement accountDetailViewRelatedItemsHdr;

    @FindBy(xpath = "//*[@id='account_detail']//a[@data-view= 'activity_related']")
    public WebElement accountDetailViewActivitiesLnk;

    @FindBy(xpath = "//*[@id='account_detail']//a[@data-view= 'contact_related']")
    public WebElement accountDetailViewContactsLnk;

    @FindBy(xpath = "//*[@id='account_detail']//a[@data-view= 'opportunity_related']")
    public WebElement accountDetailViewOpportunitiesLnk;

    @FindBy(xpath = "//*[@id='account_detail']//a[@data-view= 'ticket_related']")
    public WebElement accountDetailViewTicketsLnk;

    @FindBy(xpath = "//*[@id='account_detail']//a[@data-view= 'history_related']")
    public WebElement accountDetailViewNotesHistoryLnk;

    @FindBy(xpath = "//*[@id='account_detail']//a[@data-view= 'address_related']")
    public WebElement accountDetailViewAddressesLnk;

    @FindBy(xpath = "//*[@id='account_detail']//a[@data-view= 'account_attachment_related']")
    public WebElement accountDetailViewAttachmentsLnk;
    //Edit View elements

    @FindBy(xpath = "//*[@id='account_edit']")
    public WebElement accountEditView;

    @FindBy(xpath = "//*[@id='account_edit']/div[2]/h2")
    public WebElement accountEditViewDetailsHdr;

    @FindBy(css = "input[name='AccountName']")
    public WebElement accountEditViewAccountInputFld;

    @FindBy(css = "input[name='WebAddress']")
    public WebElement accountEditViewWebInputFld;

    @FindBy(css = "input[name='MainPhone']")
    public WebElement accountEditViewPhoneInputFld;

    @FindBy(css = "//*[@id='Mobile_SalesLogix_Fields_AddressField_0']/div")
    public WebElement accountEditViewAddressFld;

    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_AddressField_0']/button")
    public WebElement accountEditViewAddressFldBtn;
    
    @FindBy(css = "input[name='Fax']")
    public WebElement accountEditViewFaxInputFld;
    
    @FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_0']/input")
    public WebElement accountEditViewTypeFld;
    
    @FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_0']/button")
    public WebElement accountEditViewTypeFldBtn;
    
    @FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_1']/input")
    public WebElement accountEditViewSubTypeFld;
    
    @FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_1']/button")
    public WebElement accountEditViewSubTypeFldBtn;
    
    @FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_2']/input")
    public WebElement accountEditViewStatusFld;
    
    @FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_2']/button")
    public WebElement accountEditViewStatusFldBtn;
    
    @FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_3']/input")
    public WebElement accountEditViewIndustryFld;
    
    @FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_PicklistField_3']/button")
    public WebElement accountEditViewIndustryFldBtn;
    
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_Fields_NoteField_0']/textarea")
    public WebElement accountEditViewBusDescFld;
    
    @FindBy(xpath = "//div[@id='Sage_Platform_Mobile_Fields_NoteField_0']/button")
    public WebElement accountEditViewBusDescFldBtn;
    
    @FindBy(xpath = "//div[@id='Sage_Platform_Mobile_Fields_LookupField_0']/input")
    public WebElement accountEditViewAcctMgrFld;
    
    @FindBy(xpath = "//div[@id='Sage_Platform_Mobile_Fields_LookupField_0']/button")
    public WebElement accountEditViewAcctMgrFldBtn;
    
    @FindBy(xpath = "//div[@id='Sage_Platform_Mobile_Fields_LookupField_1']/input")
    public WebElement accountEditViewOwnerFld;
    
    @FindBy(xpath = "//div[@id='Sage_Platform_Mobile_Fields_LookupField_1']/button")
    public WebElement accountEditViewOwnerFldBtn;
    
    @FindBy(xpath = "//div[@id='Sage_Platform_Mobile_Fields_LookupField_2']/input")
    public WebElement accountEditViewLeadSourceFld;
    
    @FindBy(xpath = "//div[@id='Sage_Platform_Mobile_Fields_LookupField_2']/button")
    public WebElement accountEditViewLeadSourceFldBtn;
    private WebDriver driver;
    CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

    public AccountViewsElements(WebDriver driver) {
        this.driver = driver;
    }


    //Methods
    //=======


    /**
     * This method will add an auto-generated test Account record by filling-in the Account Edit input fields
     * then saving the field values.
     *
     * @throws InterruptedException
     * @param    strAccountName    account name to set
     */
    public void doAddRandTestAccount(String strAccountName) throws InterruptedException, IOException {
        String methodID = "doAddRandTestAccount";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);

        //Step: navigate to Accounts list view
        commNav.clickGlobalMenuItemAccounts();

        //Step: click the Add header button to enter Account edit view
        headerbutton.clickAdd();
        commNav.waitForPage("Account");

        // TODO: Ensure all insert/edit views wait for this loading indicator to go away.
        // Otherwise if you enter text it will clear out the values potentially.
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("panel-loading-indicator")));

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
            headerbutton.clickCheck();
        } catch (Exception e0) {
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
        commNav.waitForPage("Account");
        headerbutton.clickSave();
        commNav.waitForPage("Accounts");

        System.out.println(methodID + ": Auto-test Account - " + strAccountName + " record was created.");
    }


    /**
     * This method will search for then click a target Account record from the Accounts List view in order
     * to open the Account record's Detail view.
     *
     * @param    strAcctName        name of a target Account record to find and open
     * @return void
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
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(methodID + "(): " + e.toString());
            return false;
        }
    }


    /**
     * This method captures the contents of the Accounts List view and return the same contents in a string.
     *
     * @return void
     */
    public String getAccountsListViewTxt() {
        String methodID = "getAccountsListViewTxt";

        WebElement accountsLisViewInfo = driver.findElement(By.xpath("//*[@id='account_list']/ul"));

        return accountsLisViewInfo.getText();
    }


    /**
     * This method returns a boolean value to determine if the 'no record' result is displayed on the Accounts
     * List view.
     *
     * @return void
     */
    public boolean noRecordsFoundCheck() throws InterruptedException {
        String methodID = "noRecordsFoundCheck";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

        boolean result = false;
        String noRecsTxt = "no records";

        if (commNav.isTextPresentOnPage(noRecsTxt)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }


    /**
     * This method will perform a "filter-less" search (no hash-tag & no search string) on the Accounts
     * List view.  The resulting Activities search is displayed in the List view.
     *
     * @throws InterruptedException
     */
    public void performNoFilterSearch() throws InterruptedException {
        String methodID = "performNoFilterSearch";

        AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);

        //Step: execute a filter-free search
        headerButton.showRightContextMenu();
        accountsListView.accountsSearchTxtBox.click();
        Thread.sleep(100);
        accountsListView.accountsSearchClearBtn.click();
        Thread.sleep(100);
        accountsListView.accountsSearchLookupBtn.click();
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
        Thread.sleep(100);
        activitiesListView.relatedActivitiesSearchClearBtn.click();
        Thread.sleep(100);
        activitiesListView.relatedActivitiesSearchTxtBox.sendKeys(regarding);
        Thread.sleep(100);
        activitiesListView.relatedActivitiesSearchLookupBtn.click();
    }
}
