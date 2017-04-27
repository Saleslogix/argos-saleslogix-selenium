package argos.saleslogix.selenium.pages;

import argos.saleslogix.selenium.pages.CommonNavigation;
import argos.saleslogix.selenium.pages.CommonViewsElements;
import argos.saleslogix.selenium.pages.HeaderButton;
import argos.saleslogix.selenium.test.BaseTest;
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
    public WebElement leadsSearchTxtBox;
    @CacheLookup
    @FindBy(xpath = "//*[@selected='true']//button[@class='clear-button']")
    public WebElement leadsSearchClearBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@selected='true']//button[@class='subHeaderButton searchButton']")
    public WebElement leadsSearchLookupBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']")
    public WebElement leadsListViewPnl;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']")
    public WebElement leadsListViewNotesBox;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]")
    public WebElement leadsListViewNotesBox1stItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[1]/div")
    public WebElement leadsListViewNotesBox1stItemInitialsBox;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[2]/h4[1]/strong")
    public WebElement leadsListViewNotesBox1stItemRegarding;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[2]/h4[2]")
    public WebElement leadsListViewNotesBox1stItemLastActivity;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[3]/div/h4")
    public WebElement leadsListViewNotesBox1stItemNotes;
    @CacheLookup
    @FindBy(xpath = "//div[2]/div[4]/div[2]")
    public WebElement leadsListViewNotesBoxSeeListLink;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul")
    public WebElement leadsListViewHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list' and @selected='selected']")
    public WebElement leadsListView;
    @CacheLookup
    @FindBy(xpath = "//div[6]/div[2]/div/div/div/button")
    public WebElement leadsListView1stKPICard;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list_search-expression']/div")
    public WebElement leadsListView1stHashTagFilter;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//div[@data-action='activateEntry'][1]")
    public WebElement topLeadsListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul/li[1]/div[1]")
    public WebElement topLeadsListItemTab;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//button[@data-action='selectEntry'][1]")
    public WebElement topLeadsListItemIcon;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//h2[@class='widget-title'][1]")
    public WebElement topLeadsListItemName;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul/li[1]/div/h4[1]")
    public WebElement topLeadsListItemLine2;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul/li[1]/div/h4[2]")
    public WebElement topLeadsListItemLine3;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul/li[1]/div/h4[3]")
    public WebElement topLeadsListItemLine4;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul/li[1]/div/h4[4]")
    public WebElement topLeadsListItemLine5;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul/li[1]/div/h4[5]")
    public WebElement topLeadsListItemLine6;
    @CacheLookup
    @FindBy(xpath = "//*[@id='bottom_item_indicators']/span/img")
    public WebElement topLeadsListItemBtmIndicator;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//span[@data-action='sendEmail'][1]")
    public WebElement topLeadsListItemEmailLink;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//li[1]//span[@data-action='callWork']")
    public WebElement topLeadsListItemCallWorkLink;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//li[1]//span[@data-action='callMobile']")
    public WebElement topLeadsListItemCallMobileLink;
    @CacheLookup
    //@FindBy(css = "#lead_list > ul.list-content > li > #bottom_item_indicators > span > img")
    @FindBy(xpath = "//*[@id='bottom_item_indicators']/span")
    public WebElement topLeadsListItemTouch;
    @CacheLookup
    //@FindBy(css = "#lead_list > ul.list-content > li > #list-item-footer > div > button.footer-item-selector.button")
    @FindBy(xpath = "//*[@id='list-item-footer']/div/button")
    public WebElement topLeadsListItemQuickActionsBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//button[@aria-label='addAttachment'][1]")
    public WebElement topLeadsListItemQuickActionsAddAttachmentBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//button[@aria-label='addActivity'][1]")
    public WebElement topLeadsListItemQuickActionsAddActivityBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//button[@aria-label='addNote'][1]")
    public WebElement topLeadsListItemQuickActionsAddNoteBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//button[@aria-label='sendEmail'][1]")
    public WebElement topLeadsListItemQuickActionsEmailBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//button[@aria-label='callMobile'][1]")
    public WebElement topLeadsListItemQuickActionsCallMobileBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//button[@aria-label='callWork'][1]")
    public WebElement topLeadsListItemQuickActionsCallWorkBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//button[@aria-label='edit'][1]")
    public WebElement topLeadsListItemQuickActionsEditBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul[2]/li[11]")
    public WebElement eleventhLeadsListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul[2]/li[21]")
    public WebElement twentyfirstLeadsListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul[2]/li[31]")
    public WebElement thirtyfirstLeadsListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']/div[2]/div/span")
    public WebElement recordsRemainingListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//ul[2]/li/h3")
    public WebElement noRecordsListItem;
    //Context Menu elements
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']/div[3]/h2[2]")
    public WebElement leadsHashTagsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']//ul[@data-group='view']")
    public WebElement leadsHashTagsPnl;
    @CacheLookup
    @FindBy(xpath = "//div[@id='right_drawer']//h2[contains(., 'KPI')]")
    public WebElement leadsKPIHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']//ul[@data-group='kpi']")
    public WebElement leadsKPIPnl;

    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']//div[@data-group='kpi']/preceding-sibling::div[1]")
    public WebElement leadsKPIHeader;
    //Detail View elements
    //TODO: the Lead Edit fields need to be updated when needed
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']")
    public WebElement leadsDetailView;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']/div[2]/h2[1]")
    public WebElement leadsDetailViewQuickActionsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']//a[@data-action='callWorkPhone']")
    public WebElement leadsDetailViewCallMainNumberLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']//a[@data-action='sendEmail']")
    public WebElement leadsDetailViewSendEmailLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']//a[@data-action='scheduleActivity']")
    public WebElement leadsDetailViewScheduleActivityLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']//a[@data-action='addNote']")
    public WebElement leadsDetailViewAddNoteLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']//a[@data-action='viewAddress']")
    public WebElement leadsDetailViewViewAddressLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']/div[2]/h2[2]")
    public WebElement leadsDetailViewDetailsHdr;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[1]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='LeadNameLastFirst']/span")
    public WebElement leadsDetailViewNameFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[2]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='Company']/span")
    public WebElement leadsDetailViewCompanyFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[5]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='WebAddress']/span")
    public WebElement leadsDetailViewWebFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[5]/span/a")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='WebAddress']/span/a")
    public WebElement leadsDetailViewWebFldLnk;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[1]/div[3]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='Title']/span")
    public WebElement leadsDetailViewTitleFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[1]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='WorkPhone']/span")
    public WebElement leadsDetailViewWorkPhoneFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[2]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='Mobile']/span")
    public WebElement leadsDetailViewMobilePhoneFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[3]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='TollFree']/span")
    public WebElement leadsDetailViewTollFreeFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[4]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='LeadSource.Description']/span")
    public WebElement leadsDetailViewLeadSourceFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']/div[2]/h2[3]")
    public WebElement leadsDetailViewMoreDetailsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]")
    public WebElement leadsDetailViewMoreDetailsFields;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[6]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='Interests']/span")
    public WebElement leadsDetailViewInterestsFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[7]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='Industry']/span")
    public WebElement leadsDetailViewIndustryFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[8]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='SICCode']/span")
    public WebElement leadsDetailViewSicCodeFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[9]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='BusinessDescription']/span")
    public WebElement leadsDetailViewBusDescFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[10]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='Notes']/span")
    public WebElement leadsDetailViewCommentsFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='lead_detail']/div[2]/div[2]/div[11]")
    @FindBy(xpath = "//*[@id='lead_detail']//div[@data-property='Owner.OwnerDescription']/span")
    public WebElement leadsDetailViewOwnerFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']/div[2]/h2[4]")
    public WebElement leadsDetailViewRelatedItemsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']/descendant::*[text() = 'Activities']")
    public WebElement leadsDetailViewActivitiesLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']/descendant::*[text() = 'Notes/History']")
    public WebElement leadsDetailViewNotesHistoryLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_detail']/descendant::*[text() = 'Attachments']")
    public WebElement leadsDetailViewAttachmentsLnk;
    //Edit View elements
    //TODO: the Lead Edit fields need to be updated when needed
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_edit']")
    public WebElement leadsEditView;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_edit']/div[2]/h2")
    public WebElement leadsEditViewDetailsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='crm_Fields_NameField_0']/input")
    public WebElement leadsEditViewNameInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='LeadNameLastFirst']//button")
    public WebElement leadsEditViewNameFldBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='Company']//input")
    public WebElement leadsEditViewCompanyInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='WebAddress']//input")
    public WebElement leadsEditViewWebInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='WorkPhone']//input")
    public WebElement leadsEditViewWorkPhoneInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='Mobile']//input")
    public WebElement leadsEditViewMobilePhoneInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='TollFree']//input")
    public WebElement leadsEditViewTollFreeInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='Email']//input")
    public WebElement leadsEditViewEmailInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='Title']//input")
    public WebElement leadsEditViewTitleInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='Title']//button")
    public WebElement leadsEditViewTitleFldBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='Address']/div/div/label")
    public WebElement leadsEditViewAddressInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='Address']//button")
    public WebElement leadsEditViewAddressFldBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='LeadSource']//input")
    public WebElement leadsEditViewLeadSourceInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='LeadSource']//button")
    public WebElement leadsEditViewLeadSourceFldBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='Interests']//input")
    public WebElement leadsEditViewInterestsInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='Industry']//input")
    public WebElement leadsEditViewIndustryInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='Industry']//button")
    public WebElement leadsEditViewIndustryFldBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='SICCode']//input")
    public WebElement leadsEditViewSicCodeInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='BusinessDescription']//textarea")
    public WebElement leadsEditViewBusDescInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='Notes']//textarea")
    public WebElement leadsEditViewCommentsInputFld;
    @CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@data-field='Owner']//button")
    public WebElement leadsEditViewOwnerFldBtn;
    @CacheLookup
    // this data-key is specific to user loup for 'All Leads' group
    @FindBy(xpath = "//*[@id='groups_configure']//li[@data-descriptor='All Leads']")
    public WebElement groupsConfigureAllLeads;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']//li[@data-title='All Leads']")
    public WebElement rmenu_groupAllLeads;
    @CacheLookup
    @FindBy(xpath = "//*[@id='lead_list']//span[2][@data-propertyname='WorkPhone']")
    public WebElement leadGroupViewWorkPhoneFld;
    @CacheLookup
    // Group View Email link for lead John Beck
    @FindBy(xpath = "//*[@id='lead_list']//span[@data-key='QDEMOA00013R']")
    public WebElement johnBeckGroupViewEmailLink;
    @CacheLookup
    // Group view card for lead John Beck ... press to open lead
    @FindBy(xpath = "//*[@id='lead_list']//div[@data-key='QDEMOA00013R']//div[@class='group-item']")
    public WebElement johnBeckGroupViewCard;
    @CacheLookup
    // Group view button to open quick actions for lead John Beck
    @FindBy(xpath = "//*[@id='lead_list']//button[@data-key='QDEMOA00013R']")
    public WebElement johnBeckGroupViewQuickActionBtn;
    @CacheLookup
    // Group view button to open email quick action
    @FindBy(xpath = "//*[@id='lead_list']//button[@aria-label='sendEmail']")
    public WebElement leadGroupViewQuickActionEmailBtn;
    @CacheLookup
    // Group view button to open call work quick action
    @FindBy(xpath = "//*[@id='lead_list']//button[@aria-label='callWork']")
    public WebElement leadGroupViewQuickActionCallWorkBtn;
    @CacheLookup
    // Group view button to open call mobile quick action
    @FindBy(xpath = "//*[@id='lead_list']//button[@aria-label='callMobile']")
    public WebElement leadGroupViewQuickActionCallMobileBtn;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='lead_detail']//ul[@class='tab-list']/li[1]")
    public WebElement leadsDetailViewDetailsTab;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='lead_detail']//ul[@class='tab-list']/li[2]")
    public WebElement leadsDetailViewMoreDetailsTab;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='lead_detail']//ul[@class='tab-list']/li[3]")
    public WebElement leadsDetailViewRelatedItemsTab;
    private WebDriver driver;
    CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

    public LeadViewsElements(WebDriver driver) {
        this.driver = driver;
    }


    //Methods
    //=======

    public void clickGroupConfigureAllLeads() {
        groupsConfigureAllLeads.click();
    }

    /**
     * This method will return a String that represents the contents of the Leads list view.
     *
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
