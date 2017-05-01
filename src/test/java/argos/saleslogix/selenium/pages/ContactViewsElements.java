package argos.saleslogix.selenium.pages;


import argos.saleslogix.selenium.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Test class that defines WebElements and methods for Account entity based tests against the SLX Mobile Client.
 *
 * @author mike.llena@swiftpage.com
 * @version 1.0
 */
public class ContactViewsElements extends BaseTest {

    //List View elements
    //==================
    @CacheLookup
    @FindBy(xpath = "//*[@selected='true']//input[@name='query']")
    public WebElement contactsSearchTxtBox;
    @CacheLookup
    @FindBy(xpath = "//*[@selected='true']//button[@class='clear-button']")
    public WebElement contactsSearchClearBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@selected='true']//button[@class='subHeaderButton searchButton']")
    public WebElement contactsSearchLookupBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@selected='true']//input[@name='query']")
    public WebElement relatedContactsSearchTxtBox;
    @CacheLookup
    @FindBy(xpath = "//*[@selected='true']//button[@class='clear-button']")
    public WebElement relatedContactsSearchClearBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@selected='true']//button[@class='subHeaderButton searchButton']")
    public WebElement relatedContactsSearchLookupBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_related']//ul")
    public WebElement relatedContactsListView;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_related']//ul/li[1]")
    public WebElement relatedContactsListViewTopItem;
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
    @FindBy(xpath = "//*[@id='contact_list']//ul")
    public WebElement contactsListViewHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='crm_Views_MetricWidget_1']/button")
    public WebElement contactsListViewMetricsBox1;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']//ul")
    public WebElement contactsListView;
    @CacheLookup
    @FindBy(xpath = "//div[7]/div[2]/div/div/div/button")
    public WebElement contactsListView1stKPICard;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list_search-expression']/div")
    public WebElement contactsListView1stHashTagFilter;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']//ul/li[1]")
    public WebElement topContactsListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']//ul/li[1]/button")
    public WebElement topContactsListItemIcon;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']//div[@class='widget']/div/h2")
    public WebElement topContactsListItemName;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']//ul/li[1]/div/h4[1]")
    public WebElement topContactsListItemLine2;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']//ul/li[1]/div/h4[3]")
    public WebElement topContactsListItemLine3;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']//span[@data-action='callWork']")
    public WebElement topContactsListItemWorkPhone;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']//ul/li[1]/div/h4[4]")
    public WebElement topContactsListItemLine4;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']//ul/li[1]/div/h4[5]")
    public WebElement topContactsListItemLine5;
    @CacheLookup
    //@FindBy(css = "#contact_list > ul.list-content > li > #bottom_item_indicators > span > img")
    @FindBy(xpath = "//*[@id='bottom_item_indicators']/span")
    public WebElement topContactsListItemTouch;
    @CacheLookup
    //@FindBy(css = "#contact_list > ul.list-content > li > #list-item-footer > div > button.footer-item-selector.button")
    @FindBy(xpath = "//*[@id='list-item-footer']/div/button")
    public WebElement topContactsListItemQuickActionsBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']//ul/li[2]//button[@aria-label='addAttachment']")
    public WebElement topContactsListItemQuickActionsAddAttachmentBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']//ul/li[2]//button[@aria-label='addActivity']")
    public WebElement topContactsListItemQuickActionsAddActivityBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']//ul/li[2]//button[@aria-label='addNote']")
    public WebElement topContactsListItemQuickActionsAddNoteBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']//ul/li[2]//button[@aria-label='sendEmail']")
    public WebElement topContactsListItemQuickActionsEmailBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']//ul/li[2]//button[@aria-label='viewAccount']")
    public WebElement topContactsListItemQuickActionsAccountBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']//ul/li[2]//button[@aria-label='callMobile']")
    public WebElement topContactsListItemQuickActionsCallMobileBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']//ul/li[2]//button[@aria-label='callWork']")
    public WebElement topContactsListItemQuickActionsCallWorkBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']//ul/li[2]//button[@aria-label='edit']")
    public WebElement topContactsListItemQuickActionsEditBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']//ul[2]/li[11]")
    public WebElement eleventhContactsListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']//ul[2]/li[21]")
    public WebElement twentyfirstContactsListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']//ul[2]/li[31]")
    public WebElement thirtyfirstContactsListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']/div[2]/div/span")
    public WebElement recordsRemainingListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']//ul/li/h3")
    public WebElement noRecordsListItem;
    //Context Menu elements
    //---------------------
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']/div[3]/h2[2]")
    public WebElement contactsHashTagsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']//ul[@data-group='view']")
    public WebElement contactsHashTagsPnl;
    @CacheLookup
    @FindBy(xpath = "//div[@id='right_drawer']//h2[contains(., 'KPI')]")
    public WebElement contactsKPIHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']//ul[@data-group='kpi']")
    public WebElement contactsKPIPnl;
    //Detail View elements
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']")
    public WebElement contactsDetailView;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/div[2]/h2[1]")
    public WebElement contactsDetailViewQuickActionsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/descendant::*[text() = 'Call work']")
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
    //@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[1]/div[1]")
    @FindBy(xpath = "//*[@id='contact_detail']//div[@data-property='NameLF']/span")
    public WebElement contactsDetailViewContactFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[1]/div[2]")
    @FindBy(xpath = "//*[@id='contact_detail']/div[3]/div[4]/div[2]/span")
    public WebElement contactsDetailViewAccountFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[2]")
    @FindBy(xpath = "//*[@id='contact_detail']//div[@data-property='WebAddress']/span")
    public WebElement contactsDetailViewWebFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[3]")
    @FindBy(xpath = "//*[@id='contact_detail']//div[@data-property='Title']/span")
    public WebElement contactsDetailViewTitleFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/div[2]/h2[3]")
    public WebElement contactsDetailViewMoreDetailsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]")
    public WebElement contactsDetailViewMoreDetailsFields;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[1]")
    @FindBy(xpath = "//*[@id='contact_detail']//div[@data-property='HomePhone']/span")
    public WebElement contactsDetailViewHomePhoneFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']//div[@data-property='WorkPhone']/span")
    public WebElement contactsDetailViewWorkPhoneFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[4]")
    @FindBy(xpath = "//*[@id='contact_detail']//div[@data-property='Fax']/span")
    public WebElement contactsDetailViewFaxFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[1]/div[4]")
    @FindBy(xpath = "//*[@id='contact_detail']//div[@data-property='AccountManager.UserInfo']/span")
    public WebElement contactsDetailViewAcctMgrFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[5]")
    @FindBy(xpath = "//*[@id='contact_detail']//div[@data-property='Owner.OwnerDescription']/span")
    public WebElement contactsDetailViewOwnerFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='contact_detail']/div[2]/div[2]/div[6]/span")
    @FindBy(xpath = "//*[@id='contact_detail']//div[@data-property='CuisinePreference']/span")
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
    @FindBy(xpath = "//*[@id='crm_Fields_NameField_0']/input")
    public WebElement contactsEditViewNameInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='crm_Fields_NameField_0']/button")
    public WebElement contactsEditViewNameInputFldBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@id='argos_Fields_LookupField_0']/input")
    public WebElement contactsEditViewAccountInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@id='argos_Fields_LookupField_0']/button")
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
    @FindBy(xpath = "//*[@id='crm_Fields_PicklistField_0']/input")
    public WebElement contactsEditViewTitleInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='crm_Fields_PicklistField_0']/button")
    public WebElement contactsEditViewTitleInputFldBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@id='crm_Fields_AddressField_0']/div")
    public WebElement contactsEditViewAddressInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@id='crm_Fields_AddressField_0']/button")
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
    @FindBy(css = "#argos_Fields_LookupField_1 > input[type='text']")
    public WebElement contactsEditViewAcctMgrInputFld;
    @CacheLookup
    @FindBy(css = "#argos_Fields_LookupField_1 > button.button.simpleSubHeaderButton")
    public WebElement contactsEditViewAcctMgrInputFldBtn;
    @CacheLookup
    @FindBy(css = "#argos_Fields_LookupField_2 > input[type='text']")
    public WebElement contactsEditViewOwnerInputFld;
    @CacheLookup
    @FindBy(css = "#argos_Fields_LookupField_2 > button.button.simpleSubHeaderButton")
    public WebElement contactsEditViewOwnerInputFldBtn;
    @CacheLookup
    @FindBy(css = "#crm_Fields_PicklistField_1 > input[type='text']")
    public WebElement contactsEditViewCuisineInputFld;
    @CacheLookup
    @FindBy(css = "#crm_Fields_PicklistField_1 > button.button.simpleSubHeaderButton")
    public WebElement contactsEditViewCuisineInputFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='pick_list_0']//ul/li[1]//h3")
    public WebElement contactsEditViewTitleValue1;
    @CacheLookup
    @FindBy(xpath = "//*[@id='pick_list_0']//ul/li[2]//h3")
    public WebElement contactsEditViewTitleValue2;
    @CacheLookup
    @FindBy(xpath = "//*[@id='pick_list_0']//ul/li[3]//h3")
    public WebElement contactsEditViewTitleValue3;
    @CacheLookup
    @FindBy(xpath = "//*[@id='pick_list_0']//ul/li[4]//h3")
    public WebElement contactsEditViewTitleValue4;
    @CacheLookup
    @FindBy(xpath = "//*[@id='pick_list_0']//ul/li[5]//h3")
    public WebElement contactsEditViewTitleValue5;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']//li[1]/div[2]/div[1]/div/div[3]/h3[2]/span[2]")
    public WebElement authContactsGroupTopAuthValue;
    @CacheLookup
    // this data-key is specific to user loup for 'Authorized Contacts'
    @FindBy(xpath = "//*[@id='groups_configure']//li[@data-key='p6UJ9A0005C7']")
    public WebElement groupsConfigureAuthContacts;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']//li[@data-title='Authorized Contacts']")
    public WebElement rmenu_groupAuthContacts;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']//span[2][@data-propertyname='WorkPhone']")
    public WebElement contactGroupViewWorkPhoneFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_list']//span[2][@data-propertyname='Mobile']")
    public WebElement contactGroupViewMobileFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']//ul[@class='tab-list']/li[1]")
    public WebElement contactDetailViewDetailsTab;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']//ul[@class='tab-list']/li[2]")
    public WebElement contactDetailViewMoreDetailsTab;
    @CacheLookup
    @FindBy(xpath = "//*[@id='contact_detail']//ul[@class='tab-list']/li[3]")
    public WebElement contactDetailViewRelatedItemsTab;
    private WebDriver driver;
    CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

    public ContactViewsElements(WebDriver driver) {
        this.driver = driver;
    }


    //Methods
    //=======

    /**
     * This method will return a String that represents the contents of the Contacts list view.
     * list view.
     *
     * @throws InterruptedException, Exception
     */
    public String getContactsListViewTxt() {
        String methodID = "getContactsListViewTxt";

        String listViewTxt = "";

        try {
            WebElement contactsLisViewInfo = driver.findElement(By.xpath("//*[@id='contact_list']//ul"));
            listViewTxt = contactsLisViewInfo.getText();
        } catch (Exception e) {
            System.out.println(methodID + "(): " + e.toString());
        }

        return listViewTxt;
    }


    /**
     * This method will add an auto-generated test Contact record by filling-in the Contact Edit input fields.
     * The Contact will have a unique string appended to the Last Name in order to ensure uniqueness.
     *
     * @param strContactLastName  contact last name to set
     * @param strContactFirstName contact first name to set
     * @param strContactAccount   account record to associate this contact with
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
        contactsEditViewNameInputFldBtn.click();
        try {
            //TEMP: disable Name Prefix selection in favor of direct input field value setting
            commView.namePrefixInputFld.sendKeys("Mr.");
            commView.nameFirstInputFld.sendKeys(strContactFirstName);
            commView.nameMiddleInputFld.sendKeys("Neo");
            commView.nameLastInputFld.sendKeys(strContactLastName);
            //commView.nameSuffixInputFld.sendKeys("Sr.");
            headerButton.clickHeaderButton("check");
        } catch (Exception e0) {
            System.out.println(methodID + "(): " + e0.toString());
            headerButton.goBack();
        }

        //setup account field
        contactsEditViewAccountInputFldBtn.click();
        commNav.highlightNClick(commNav.entityListViewSelect("Accounts", strContactAccount));

        //conditionaly setup web field
        Thread.sleep(2000);
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
                headerButton.clickHeaderButton("check");
            } catch (Exception e1) {
                System.out.println(methodID + "(): " + e1.toString());
                headerButton.goBack();
            }
        }

        //setup home phone field
        contactsEditViewHomePhoneInputFld.sendKeys("(480)-867-5309");

        //setup mobile field
        contactsEditViewMobileInputFld.sendKeys("(602)-867-5309");

        //conditionally setup fax field
        if (commNav.isFieldValueEmpty("Fax", contactsEditViewFaxInputFld)) {
            contactsEditViewFaxInputFld.sendKeys("866-867-5309");
        }

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
        headerButton.clickHeaderButton("check");

        //Step: save the new Contact field values
        commNav.waitForPage("Contact");
        headerButton.clickHeaderButton("save");
        commNav.waitForNotPage("Contact");

        System.out.println(methodID + ": Auto-test Contact - " + strContactLastName + ", " + strContactLastName + " record was created under the '" + strContactAccount + "' Account.");
    }


    /**
     * This method will return a boolean value if a search for a specific Contact record from the Contacts
     * list view.
     *
     * @param strContactName contact name to search for
     * @throws InterruptedException, Exception
     */
    public boolean doSearchContact(String strContactName) throws InterruptedException, Exception {
        String methodID = "doSearchContact";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

        //Step: search for then click to open Contact record detail view
        try {
            commNav.highlightNClick(commNav.entityListViewSearch("Contacts", strContactName));

            //Step: confirm Contact record detail view is displayed
            if (commNav.waitForNotPage("Contacts")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(methodID + ": " + e.toString());
            return false;
        }
    }
}
