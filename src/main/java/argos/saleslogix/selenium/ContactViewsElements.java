package argos.saleslogix.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContactViewsElements {

    //List View elements
    //------------------
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_6']/div/div[1]/input")
    public WebElement contactsSearchTxtBox;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_6']/div/div[2]/button")
    public WebElement contactsSearchClearBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Sage_Platform_Mobile_SearchWidget_6']/div/div[3]/button")
    public WebElement contactsSearchLookupBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']")
    public WebElement contactsListViewPnl;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']")
    public WebElement contactsListViewNotesBox;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]")
    public WebElement contactsListViewNotesBox1stItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[1]/div")
    public WebElement contactsListViewNotesBox1stItemInitialsBox;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[2]/h4[1]/strong")
    public WebElement contactsListViewNotesBox1stItemRegarding;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[2]/h4[2]")
    public WebElement contactsListViewNotesBox1stItemLastActivity;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[3]/div/h4")
    public WebElement contactsListViewNotesBox1stItemNotes;
    @CacheLookup
    @FindBy(xpath = "//div[2]/div[4]/div[2]")
    public WebElement contactsListViewNotesBoxSeeListLink;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']/ul")
    public WebElement contactsListViewHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Views_MetricWidget_1']/button")
    public WebElement contactsListViewMetricsBox1;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']/ul")
    public WebElement contactsListView;
    @CacheLookup
    @FindBy(xpath = "//div[7]/div[2]/div/button")
    public WebElement contactsListView1stKPICard;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list_search-expression']/div")
    public WebElement contactsListView1stHashTagFilter;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']/ul/li[1]")
    public WebElement topContactsListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']/ul/li[1]/button")
    public WebElement topContactsListItemIcon;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']/ul/li[1]/div[3]/h3")
    public WebElement topContactsListItemName;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']/ul/li[1]/div[3]/h4[1]")
    public WebElement topContactsListItemLine2;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']/ul/li[1]/div[3]/h4[3]")
    public WebElement topContactsListItemLine3;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']/ul/li[1]/div[3]/h4[4]")
    public WebElement topContactsListItemLine4;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']/ul/li[1]/div[3]/h4[5]")
    public WebElement topContactsListItemLine5;
    @CacheLookup
    @FindBy(css = "#contact_list > ul.list-content > li > #bottom_item_indicators > span > img")
    public WebElement topContactsListItemTouch;
    @CacheLookup
    @FindBy(css = "#contact_list > ul.list-content > li > #list-item-footer > div > button.footer-item-selector.button")
    public WebElement topContactsListItemQuickActionsBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']/ul/li[2]/button[8]")
    public WebElement topContactsListItemQuickActionsAddAttachmentBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']/ul/li[2]/button[7]")
    public WebElement topContactsListItemQuickActionsAddActivityBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']/ul/li[2]/button[6]")
    public WebElement topContactsListItemQuickActionsAddNoteBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']/ul/li[2]/button[5]")
    public WebElement topContactsListItemQuickActionsEmailBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']/ul/li[2]/button[4]")
    public WebElement topContactsListItemQuickActionsAccountBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']/ul/li[2]/button[3]")
    public WebElement topContactsListItemQuickActionsCallMobileBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']/ul/li[2]/button[2]")
    public WebElement topContactsListItemQuickActionsCallWorkBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']/ul/li[2]/button[1]")
    public WebElement topContactsListItemQuickActionsEditBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']/ul[2]/li[11]")
    public WebElement eleventhContactsListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']/ul[2]/li[21]")
    public WebElement twentyfirstContactsListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']/ul[2]/li[31]")
    public WebElement thirtyfirstContactsListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']/div[2]/div/span")
    public WebElement recordsRemainingListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']/ul/li/h3")
    public WebElement noRecordsListItem;
    //Context Menu elements
    //---------------------
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2[1]")
    public WebElement contactsHashTagsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul[1]")
    public WebElement contactsHashTagsPnl;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']/div[4]/h2[2]")
    public WebElement contactsKPIHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']/div[4]/ul[2]")
    public WebElement contactsKPIPnl;
    //Detail View elements
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']")
    public WebElement contactsDetailView;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/div[2]/h2[1]")
    public WebElement contactsDetailViewQuickActionsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Call main number']")
    public WebElement contactsDetailViewCallMainNumberLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Call mobile']")
    public WebElement contactsDetailViewCallMobileLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Send email']")
    public WebElement contactsDetailViewSendEmailLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Schedule activity']")
    public WebElement contactsDetailViewScheduleActivityLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Add note']")
    public WebElement contactsDetailViewAddNoteLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'View address']")
    public WebElement contactsDetailViewViewAddressLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/div[2]/h2[2]")
    public WebElement contactsDetailViewDetailsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[1]/div[1]")
    public WebElement contactsDetailViewContactFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[1]/div[2]")
    public WebElement contactsDetailViewAccountFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[1]/div[3]")
    public WebElement contactsDetailViewWebFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[1]/div[4]")
    public WebElement contactsDetailViewTitleFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/div[2]/h2[3]")
    public WebElement contactsDetailViewMoreDetailsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]")
    public WebElement contactsDetailViewMoreDetailsFields;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[1]")
    public WebElement contactsDetailViewHomePhoneFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[2]")
    public WebElement contactsDetailViewFaxFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[3]")
    public WebElement contactsDetailViewAcctMgrFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[4]")
    public WebElement contactsDetailViewOwnerFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[5]")
    public WebElement contactsDetailViewCuisineFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/div[2]/h2[4]")
    public WebElement contactsDetailViewRelatedItemsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Activities']")
    public WebElement contactsDetailViewActivitiesLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Opportunities']")
    public WebElement contactsDetailViewOpportunitiesLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Tickets']")
    public WebElement contactsDetailViewTicketsLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Notes/History']")
    public WebElement contactsDetailViewNotesHistoryLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Addresses']")
    public WebElement contactsDetailViewAddressesLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Attachments']")
    public WebElement contactsDetailViewAttachmentsLnk;
    //Edit View elements
    //------------------
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_edit']")
    public WebElement contactsEditView;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_edit']/div[2]/h2")
    public WebElement contactsEditViewDetailsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_NameField_0']/input")
    public WebElement contactsEditViewNameInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_NameField_0']/button")
    public WebElement contactsEditViewNameInputFldBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@id='Sage_Platform_Mobile_Fields_LookupField_0']/input")
    public WebElement contactsEditViewAccountInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@id='Sage_Platform_Mobile_Fields_LookupField_0']/button")
    public WebElement contactsEditViewAccountInputFldBtn;
    @CacheLookup
    @FindBy(css = "input[name='WebAddress']")
    public WebElement contactsEditViewWebInputFld;
    @CacheLookup
    @FindBy(css = "input[name='WorkPhone']")
    public WebElement contactsEditViewPhoneInputFld;
    @CacheLookup
    @FindBy(css = "input[name='Email']")
    public WebElement contactsEditViewEmailInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_0']/input")
    public WebElement contactsEditViewTitleInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='Mobile_SalesLogix_Fields_PicklistField_0']/button")
    public WebElement contactsEditViewTitleInputFldBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_AddressField_0']/div")
    public WebElement contactsEditViewAddressInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@id='Mobile_SalesLogix_Fields_AddressField_0']/button")
    public WebElement contactsEditViewAddressInputFldBtn;
    @CacheLookup
    @FindBy(css = "input[name='HomePhone']")
    public WebElement contactsEditViewHomePhoneInputFld;
    @CacheLookup
    @FindBy(css = "input[name='Mobile']")
    public WebElement contactsEditViewMobileInputFld;
    @CacheLookup
    @FindBy(css = "input[name='Fax']")
    public WebElement contactsEditViewFaxInputFld;
    @CacheLookup
    @FindBy(css = "#Sage_Platform_Mobile_Fields_LookupField_1 > input[type='text']")
    public WebElement contactsEditViewAcctMgrInputFld;
    @CacheLookup
    @FindBy(css = "#Sage_Platform_Mobile_Fields_LookupField_1 > button.button.simpleSubHeaderButton")
    public WebElement contactsEditViewAcctMgrInputFldBtn;
    @CacheLookup
    @FindBy(css = "#Sage_Platform_Mobile_Fields_LookupField_2 > input[type='text']")
    public WebElement contactsEditViewOwnerInputFld;
    @CacheLookup
    @FindBy(css = "#Sage_Platform_Mobile_Fields_LookupField_2 > button.button.simpleSubHeaderButton")
    public WebElement contactsEditViewOwnerInputFldBtn;
    @CacheLookup
    @FindBy(css = "#Mobile_SalesLogix_Fields_PicklistField_1 > input[type='text']")
    public WebElement contactsEditViewCuisineInputFld;
    @CacheLookup
    @FindBy(css = "#Mobile_SalesLogix_Fields_PicklistField_1 > button.button.simpleSubHeaderButton")
    public WebElement contactsEditViewCuisineInputFldBtn;
    private WebDriver driver;
    CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

    public ContactViewsElements(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    //-------
    public String getContactsListViewTxt() {
        String methodID = "getContactsListViewTxt";
        String listViewTxt = "";

        try {
            WebElement contactsLisViewInfo = driver.findElement(By.xpath("//*[@id='contact_list']/ul"));
            listViewTxt = contactsLisViewInfo.getText();
        } catch (Exception e) {
            System.out.println(methodID + "(): " + e.toString());
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
     *
     * @throws Exception
     * @param    strContactLastName    contact last name to set
     * @param    strContactFirstName    contact first name to set
     * @param    strContactAccount    account record to associate this contact with
     */
    public void doAddRandTestContact(String strContactLastName, String strContactFirstName, String strContactAccount) throws Exception {
        String methodID = "doAddRandTestContact";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);


        //Step: navigate to Contacts list view
        commNav.clickGlobalMenuItemContacts();

        //Step: click the Add header button to enter Contact edit view
        headerButton.clickAdd();

        //Step: setup new Contact field values
        //setup name fields
        contactsEditViewNameInputFldBtn.click();
        try {
            //TEMP: disable Name Prefix selection in favor of direct input field value setting
            commView.namePrefixInputFld.sendKeys("Mr.");
            commView.nameFirstInputFld.sendKeys(strContactFirstName);
            commView.nameMiddleInputFld.sendKeys("Neo");
            commView.nameLastInputFld.sendKeys(strContactLastName);
            //commView.nameSuffixInputFld.sendKeys("Sr.");
            headerButton.clickCheck();
        } catch (Exception e0) {
            System.out.println(methodID + "(): " + e0.toString());
            headerButton.goBack();
        }

        //setup account field
        contactsEditViewAccountInputFldBtn.click();
        commNav.highlightNClick(commNav.entityListViewSelect("Accounts", strContactAccount));

        //conditionaly setup web field
        if (commNav.isFieldValueEmpty("Web", contactsEditViewWebInputFld)) {
            contactsEditViewWebInputFld.sendKeys("www.saleslogix.com");
        }

        //conditionally setup phone field
        if (commNav.isFieldValueEmpty("Phone", contactsEditViewPhoneInputFld)) {
            contactsEditViewPhoneInputFld.sendKeys("888-867-5309");
        }

        //setup email field
        contactsEditViewEmailInputFld.sendKeys("theone@boguscompany.com");

        //setup title field
        contactsEditViewTitleInputFld.sendKeys("Principal");

        //conditionally setup address fields
        if (contactsEditViewAddressInputFld.getText().equals("")) {
            contactsEditViewAddressInputFldBtn.click();
            try {
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
                headerButton.clickCheck();
            } catch (Exception e1) {
                System.out.println(methodID + "(): " + e1.toString());
                headerButton.goBack();
            }
        }

        //setup home phone field
        contactsEditViewHomePhoneInputFld.sendKeys("(480)-867-5309");

        //setup mobile field
        contactsEditViewMobileInputFld.sendKeys("(602)-867-5309");

        //setup fax field
        contactsEditViewFaxInputFld.sendKeys("(866)-867-5309");

        //conditionally setup acct mgr field
        if (commNav.isFieldValueEmpty("Acct Mgr", contactsEditViewAcctMgrInputFld)) {
            contactsEditViewAcctMgrInputFldBtn.click();
            commNav.highlightNClick(commNav.entityListViewSearch("Users", "Hogan"));
        }

        //conditionally setup owner field
        if (commNav.isFieldValueEmpty("Owner", contactsEditViewOwnerInputFld)) {
            //TEMP disable - doesn't work for Trinity DB
            contactsEditViewOwnerInputFld.sendKeys("Midwest");
        }

        //setup cuisine field
        contactsEditViewCuisineInputFldBtn.click();
        commView.selectFieldValListItem("Cuisine", "Chinese");
        headerButton.clickCheck();

        //Step: save the new Contact field values
        commNav.waitForPage("Contact");
        headerButton.clickSave();
        commNav.waitForNotPage("Contact");

        System.out.println(methodID + ": Auto-test Contact - " + strContactLastName + ", " + strContactLastName + " record was created under the '" + strContactAccount + "' Account.");
    }


    //TODO: finish doSearchAccount() method
    public boolean doSearchContact(String strContactName) throws InterruptedException, Exception {
        String methodID = "doSearchContact";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerbutton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);

        //Step: search for then click to open Contact record detail view
        WebElement element = commNav.entityListViewSearch("Contacts", strContactName);
        commNav.highlightNClick(element);

        //Step: confirm Account record detail view is displayed
        if (commNav.waitForNotPage("Contacts")) {
            return true;
        } else {
            return false;
        }
    }
}
