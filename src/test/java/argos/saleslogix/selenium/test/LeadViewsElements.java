package argos.saleslogix.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Test class that defines WebElements and methods for Lead entity based tests against the SLX Mobile Client.
 *
 * @author mike.llena@swiftpage.com
 * @version 1.0
 */
public class LeadViewsElements extends BaseTest {

    //List View elements
    @CacheLookup
    @FindBy(xpath = "//*[@selected='true']//input[@name='query']")
    WebElement leadsSearchTxtBox;
    @CacheLookup
    @FindBy(xpath = "//*[@selected='true']//button[@class='clear-button']")
    WebElement leadsSearchClearBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@selected='true']//button[@class='subHeaderButton searchButton']")
    WebElement leadsSearchLookupBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']")
    WebElement leadsListViewPnl;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']")
    WebElement leadsListViewNotesBox;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]")
    WebElement leadsListViewNotesBox1stItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[1]/div")
    WebElement leadsListViewNotesBox1stItemInitialsBox;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[2]/h4[1]/strong")
    WebElement leadsListViewNotesBox1stItemRegarding;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[2]/h4[2]")
    WebElement leadsListViewNotesBox1stItemLastActivity;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[3]/div/h4")
    WebElement leadsListViewNotesBox1stItemNotes;
    @CacheLookup
    @FindBy(xpath = "//div[2]/div[4]/div[2]")
    WebElement leadsListViewNotesBoxSeeListLink;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul")
    WebElement leadsListViewHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list' and @selected='selected']")
    WebElement leadsListView;
    @CacheLookup
    @FindBy(xpath = "//div[6]/div[2]/div/div/div/button")
    WebElement leadsListView1stKPICard;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list_search-expression']/div")
    WebElement leadsListView1stHashTagFilter;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//div[@data-action='activateEntry'][1]")
    WebElement topLeadsListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul/li[1]/div[1]")
    WebElement topLeadsListItemTab;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//button[@data-action='selectEntry'][1]")
    WebElement topLeadsListItemIcon;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//h2[@class='widget-title'][1]")
    WebElement topLeadsListItemName;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul/li[1]/div/h4[1]")
    WebElement topLeadsListItemLine2;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul/li[1]/div/h4[2]")
    WebElement topLeadsListItemLine3;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul/li[1]/div/h4[3]")
    WebElement topLeadsListItemLine4;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul/li[1]/div/h4[4]")
    WebElement topLeadsListItemLine5;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul/li[1]/div/h4[5]")
    WebElement topLeadsListItemLine6;
    @CacheLookup
    @FindBy(xpath = "//*[@id='bottom_item_indicators']/span/img")
    WebElement topLeadsListItemBtmIndicator;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//span[@data-action='sendEmail'][1]")
    WebElement topLeadsListItemEmailLink;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//li[1]//span[@data-action='callWork']")
    WebElement topLeadsListItemCallWorkLink;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//li[1]//span[@data-action='callMobile']")
    WebElement topLeadsListItemCallMobileLink;
    @CacheLookup
    //@FindBy(css = "#lead_list > ul.list-content > li > #bottom_item_indicators > span > img")
    @FindBy(xpath = "//*[@id='bottom_item_indicators']/span")
    WebElement topLeadsListItemTouch;
    @CacheLookup
    //@FindBy(css = "#lead_list > ul.list-content > li > #list-item-footer > div > button.footer-item-selector.button")
    @FindBy(xpath = "//*[@id='list-item-footer']/div/button")
    WebElement topLeadsListItemQuickActionsBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//button[@aria-label='addAttachment'][1]")
    WebElement topLeadsListItemQuickActionsAddAttachmentBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//button[@aria-label='addActivity'][1]")
    WebElement topLeadsListItemQuickActionsAddActivityBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//button[@aria-label='addNote'][1]")
    WebElement topLeadsListItemQuickActionsAddNoteBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//button[@aria-label='sendEmail'][1]")
    WebElement topLeadsListItemQuickActionsEmailBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//button[@aria-label='callMobile'][1]")
    WebElement topLeadsListItemQuickActionsCallMobileBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//button[@aria-label='callWork'][1]")
    WebElement topLeadsListItemQuickActionsCallWorkBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//button[@aria-label='edit'][1]")
    WebElement topLeadsListItemQuickActionsEditBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul[2]/li[11]")
    WebElement eleventhLeadsListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul[2]/li[21]")
    WebElement twentyfirstLeadsListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul[2]/li[31]")
    WebElement thirtyfirstLeadsListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']/div[2]/div/span")
    WebElement recordsRemainingListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul[2]/li/h3")
    WebElement noRecordsListItem;
    //Context Menu elements
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']/div[3]/h2[2]")
    WebElement leadsHashTagsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']//ul[@data-group='view']")
    WebElement leadsHashTagsPnl;
    @CacheLookup
    @FindBy(xpath = "//div[@id='right_drawer']//h2[contains(., 'KPI')]")
    WebElement leadsKPIHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']//ul[@data-group='kpi']")
    WebElement leadsKPIPnl;

    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']//div[@data-group='kpi']/preceding-sibling::div[1]")
    WebElement leadsKPIHeader;
    //Detail View elements
    //TODO: the Lead Edit fields need to be updated when needed
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']")
    WebElement leadsDetailView;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']/div[2]/h2[1]")
    WebElement leadsDetailViewQuickActionsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']//a[@data-action='callWorkPhone']")
    WebElement leadsDetailViewCallMainNumberLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']//a[@data-action='sendEmail']")
    WebElement leadsDetailViewSendEmailLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']//a[@data-action='scheduleActivity']")
    WebElement leadsDetailViewScheduleActivityLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']//a[@data-action='addNote']")
    WebElement leadsDetailViewAddNoteLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']//a[@data-action='viewAddress']")
    WebElement leadsDetailViewViewAddressLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']/div[2]/h2[2]")
    WebElement leadsDetailViewDetailsHdr;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[1]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='LeadNameLastFirst']/span")
    WebElement leadsDetailViewNameFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[2]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='Company']/span")
    WebElement leadsDetailViewCompanyFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[5]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='WebAddress']/span")
    WebElement leadsDetailViewWebFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[5]/span/a")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='WebAddress']/span/a")
    WebElement leadsDetailViewWebFldLnk;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[3]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='Title']/span")
    WebElement leadsDetailViewTitleFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[1]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='WorkPhone']/span")
    WebElement leadsDetailViewWorkPhoneFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[2]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='Mobile']/span")
    WebElement leadsDetailViewMobilePhoneFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[3]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='TollFree']/span")
    WebElement leadsDetailViewTollFreeFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[4]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='LeadSource.Description']/span")
    WebElement leadsDetailViewLeadSourceFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']/div[2]/h2[3]")
    WebElement leadsDetailViewMoreDetailsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]")
    WebElement leadsDetailViewMoreDetailsFields;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[6]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='Interests']/span")
    WebElement leadsDetailViewInterestsFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[7]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='Industry']/span")
    WebElement leadsDetailViewIndustryFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[8]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='SICCode']/span")
    WebElement leadsDetailViewSicCodeFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[9]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='BusinessDescription']/span")
    WebElement leadsDetailViewBusDescFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[10]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='Notes']/span")
    WebElement leadsDetailViewCommentsFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[11]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='Owner.OwnerDescription']/span")
    WebElement leadsDetailViewOwnerFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']/div[2]/h2[4]")
    WebElement leadsDetailViewRelatedItemsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']/descendant::*[text() = 'Activities']")
    WebElement leadsDetailViewActivitiesLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']/descendant::*[text() = 'Notes/History']")
    WebElement leadsDetailViewNotesHistoryLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']/descendant::*[text() = 'Attachments']")
    WebElement leadsDetailViewAttachmentsLnk;
    //Edit View elements
    //TODO: the Lead Edit fields need to be updated when needed
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_edit']")
    WebElement leadsEditView;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_edit']/div[2]/h2")
    WebElement leadsEditViewDetailsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='crm_Fields_NameField_0']/input")
    WebElement leadsEditViewNameInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='LeadNameLastFirst']//button")
    WebElement leadsEditViewNameFldBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='Company']//input")
    WebElement leadsEditViewCompanyInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='WebAddress']//input")
    WebElement leadsEditViewWebInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='WorkPhone']//input")
    WebElement leadsEditViewWorkPhoneInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='Mobile']//input")
    WebElement leadsEditViewMobilePhoneInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='TollFree']//input")
    WebElement leadsEditViewTollFreeInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='Email']//input")
    WebElement leadsEditViewEmailInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='Title']//input")
    WebElement leadsEditViewTitleInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='Title']//button")
    WebElement leadsEditViewTitleFldBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='Address']/div/div/label")
    WebElement leadsEditViewAddressInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='Address']//button")
    WebElement leadsEditViewAddressFldBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='LeadSource']//input")
    WebElement leadsEditViewLeadSourceInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='LeadSource']//button")
    WebElement leadsEditViewLeadSourceFldBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='Interests']//input")
    WebElement leadsEditViewInterestsInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='Industry']//input")
    WebElement leadsEditViewIndustryInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='Industry']//button")
    WebElement leadsEditViewIndustryFldBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='SICCode']//input")
    WebElement leadsEditViewSicCodeInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='BusinessDescription']//textarea")
    WebElement leadsEditViewBusDescInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='Notes']//textarea")
    WebElement leadsEditViewCommentsInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='Owner']//button")
    WebElement leadsEditViewOwnerFldBtn;
    @CacheLookup
    // this data-key is specific to user loup for 'All Leads' group
    @FindBy(xpath = "//*[@id='groups_configure']//li[@data-descriptor='All Leads']")
    WebElement groupsConfigureAllLeads;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']//li[@data-title='All Leads']")
    WebElement rmenu_groupAllLeads;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//span[2][@data-propertyname='WorkPhone']")
    WebElement leadGroupViewWorkPhoneFld;
    @CacheLookup
    // Group View Email link for lead John Beck
    @FindBy(xpath = "//*[@id='lead_list']//span[@data-key='QDEMOA00013R']")
    WebElement johnBeckGroupViewEmailLink;
    @CacheLookup
    // Group view card for lead John Beck ... press to open lead
    @FindBy(xpath = "//*[@id='lead_list']//div[@data-key='QDEMOA00013R']//div[@class='group-item']")
    WebElement johnBeckGroupViewCard;
    @CacheLookup
    // Group view button to open quick actions for lead John Beck
    @FindBy(xpath = "//*[@id='lead_list']//button[@data-key='QDEMOA00013R']")
    WebElement johnBeckGroupViewQuickActionBtn;
    @CacheLookup
    // Group view button to open email quick action
    @FindBy(xpath = "//*[@id='lead_list']//button[@aria-label='sendEmail']")
    WebElement leadGroupViewQuickActionEmailBtn;
    @CacheLookup
    // Group view button to open call work quick action
    @FindBy(xpath = "//*[@id='lead_list']//button[@aria-label='callWork']")
    WebElement leadGroupViewQuickActionCallWorkBtn;
    @CacheLookup
    // Group view button to open call mobile quick action
    @FindBy(xpath = "//*[@id='lead_list']//button[@aria-label='callMobile']")
    WebElement leadGroupViewQuickActionCallMobileBtn;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='lead_detail']//ul[@class='tab-list']/li[1]")
    WebElement leadsDetailViewDetailsTab;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='lead_detail']//ul[@class='tab-list']/li[2]")
    WebElement leadsDetailViewMoreDetailsTab;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='lead_detail']//ul[@class='tab-list']/li[3]")
    WebElement leadsDetailViewRelatedItemsTab;
    private WebDriver driver;
    CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

    public LeadViewsElements(WebDriver driver) {
        this.driver = driver;
    }


    //Methods
    //=======

    /**
     * This method will return a String that represents the contents of the Leads list view.
     *
     * @param N/A
     * @throws InterruptedException, Exception
     */
    public String getLeadsListViewTxt() {
        String methodID = "getLeadsListViewTxt";
        String listViewTxt = "";

        try {
            WebElement leadsLisViewInfo = driver.findElement(By.xpath("//*[@id='lead_list']//ul"));
            listViewTxt = leadsLisViewInfo.getText();
        } catch (Exception e) {
            System.out.println(methodID + "(): " + e.toString());
        }

        return listViewTxt;
    }


    /**
     * This method will add an auto-generated test Lead record by filling-in the Lead Edit input fields.
     * The Lead will have a unique string appended to the Last Name in order to ensure uniqueness.
     *
     * @throws Exception
     * @param    strLeadLastName    lead last name to set
     * @param    strLeadFirstName    lead first name to set
     * @param    strLeadCompany    company name for lead
     */
    public void doAddRandTestLead(String strLeadLastName, String strLeadFirstName, String strLeadCompany) throws Exception {
        String methodID = "doAddRandTestLead";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
        HeaderButton headerButton = PageFactory.initElements(driver, HeaderButton.class);
        CommonViewsElements commView = PageFactory.initElements(driver, CommonViewsElements.class);

        System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);

        //Step: navigate to Leads list view
        commNav.clickGlobalMenuItem("Leads");

        //Step: click the Add header button to enter Lead edit view
        headerButton.clickHeaderButton("Add");

        //Step: setup new Lead field values
        //setup name fields
        leadsEditViewNameFldBtn.click();

        //TEMP: disable Name Prefix selection in favor of direct input field value setting
        commView.namePrefixInputFld.sendKeys("Mr.");
        commView.nameFirstInputFld.sendKeys(strLeadFirstName);
        commView.nameMiddleInputFld.sendKeys("Neo");
        commView.nameLastInputFld.sendKeys(strLeadLastName);
        //commView.nameSuffixInputFld.sendKeys("Jr.");
        headerButton.clickHeaderButton("check");

        //setup company field
        leadsEditViewCompanyInputFld.sendKeys(strLeadCompany);

        //setup web field
        leadsEditViewWebInputFld.sendKeys("www.saleslogix.com");

        //setup work phone field
        leadsEditViewWorkPhoneInputFld.sendKeys("888-867-5309");

        //setup mobile phone field
        leadsEditViewMobilePhoneInputFld.sendKeys("408-867-5309");

        //setup toll free field
        leadsEditViewMobilePhoneInputFld.sendKeys("800-867-5309");

        //setup email field
        leadsEditViewEmailInputFld.sendKeys("aturing@fakemail.com");

        //setup title field
        leadsEditViewTitleInputFld.sendKeys("CEO");

        //conditionally setup address fields
        if (leadsEditViewAddressInputFld.getText().equals("")) {
            leadsEditViewAddressFldBtn.click();
            commNav.waitForPage("Address");
            //TEMP disable selection views (doesn't work on Jenkins server)
            commView.addressDescriptionInputFld.sendKeys("Mailing");
            commView.addressPrimaryTgl.click();
            commView.addressShippingTgl.click();
            commView.addressLine1.sendKeys("8800 Mobile St.");
            commView.addressLine2.sendKeys("Corporate Campus");
            commView.addressLine3.sendKeys("Suite 200");
            commView.addressCityInputFld.sendKeys("Phoenix");
            commView.addressStateInputFld.sendKeys("AZ");
            commView.addressPostalInputFld.sendKeys("85048");
            commView.addressCountryInputFld.sendKeys("USA");
            commView.addressAttentionInputFld.sendKeys("Mrs. Rogers");
            headerButton.clickHeaderButton("check");
            commNav.waitForPage("Lead");
        }

        //setup lead source field
        leadsEditViewLeadSourceFldBtn.click();
        commNav.waitForPage("Lead Sources");
        // TODO: Fix lookups
        commView.lookupNSelectListItem("Lead Sources", "Web - General");

        //setup interests field
        leadsEditViewInterestsInputFld.sendKeys("automated test");

        //setup industry field
        leadsEditViewIndustryInputFld.sendKeys("Computers/Electronics/High Tech");
        //leadsEditViewIndustryFldBtn.click();
        //	commView.selectFieldValListItem("Industry", "Computers/Electronics/High Tech");
        //	headerButton.clickHeaderButton("check");

        //setup sic code field
        leadsEditViewSicCodeInputFld.sendKeys("51CC0D3");

        //setup business desc field
        leadsEditViewBusDescInputFld.sendKeys("automated test lead entity record");

        //setup comments field
        leadsEditViewCommentsInputFld.sendKeys("automated test lead entity record");

        //setup owner field
        leadsEditViewOwnerFldBtn.click();
        commView.lookupNSelectListItem("Owners", "Everyone");

        //Step: save the new Lead field values
        commNav.waitForPage("Lead");
        headerButton.clickHeaderButton("save");
        commNav.waitForNotPage("Lead");

        System.out.println(methodID + ": Auto-test Lead - " + strLeadLastName + ", " + strLeadLastName + " record was created.");
    }


    /**
     * This method will return a boolean value if a search for a specific Lead record from the Leads
     * list view.
     *
     * @param strLeadName lead name to search for
     * @throws InterruptedException, Exception
     */
    public boolean doSearchLead(String strLeadName) throws InterruptedException, Exception {
        String methodID = "doSearchLead";

        CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

        //Step: search for then click to open Lead record detail view
        try {
            commNav.highlightNClick(commNav.entityListViewSearch("Leads", strLeadName));

            //Step: confirm Lead record detail view is displayed
            if (commNav.waitForNotPage("Leads")) {
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
