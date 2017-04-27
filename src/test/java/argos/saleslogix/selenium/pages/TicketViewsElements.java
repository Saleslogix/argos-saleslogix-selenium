package argos.saleslogix.selenium.pages;

import argos.saleslogix.selenium.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TicketViewsElements extends BaseTest {

    //List View elements
    @CacheLookup
    @FindBy(xpath = "//*[@selected='true']//input[@name='query']")
    public WebElement ticketsSearchTxtBox;
    @CacheLookup
    @FindBy(xpath = "//*[@selected='true']//button[@class='clear-button']")
    public WebElement ticketsSearchClearBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@selected='true']//button[@class='subHeaderButton searchButton']")
    public WebElement ticketsSearchLookupBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_list']")
    public WebElement ticketsListViewPnl;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_list']//ul")
    public WebElement ticketsListViewHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_list']//ul")
    public WebElement ticketsListView;
    @CacheLookup
    @FindBy(xpath = "//div[4]/div[2]/div/div/div/button")
    public WebElement ticketsListView1stKPICard;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_list_search-expression']/div")
    public WebElement ticketsListView1stHashTagFilter;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']")
    public WebElement ticketsListViewNotesBox;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]")
    public WebElement ticketsListViewNotesBox1stItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[1]/div")
    public WebElement ticketsListViewNotesBox1stItemInitialsBox;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[2]/h4[1]/strong")
    public WebElement ticketsListViewNotesBox1stItemRegarding;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[2]/h4[2]")
    public WebElement ticketsListViewNotesBox1stItemLastActivity;
    @CacheLookup
    @FindBy(xpath = "//*[@id='itemsNode']/div[2]/div/div[3]/div/h4")
    public WebElement ticketsListViewNotesBox1stItemNotes;
    @CacheLookup
    @FindBy(xpath = "//div[2]/div[4]/div[2]")
    public WebElement ticketsListViewNotesBoxSeeListLink;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_list']//ul/li[1]")
    public WebElement topTicketsListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_list']//ul/li[1]/div[1]")
    public WebElement topTicketsListItemTab;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_list']//ul/li[1]/button")
    public WebElement topTicketsListItemIcon;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_list']//ul/li[1]/div[2]/h3")
    public WebElement topTicketsListItemNumber;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_list']//ul/li[1]/div[2]/h4[2]")
    public WebElement topTicketsListItemLine2;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_list']//ul/li[1]/div[2]/h4[3]")
    public WebElement topTicketsListItemLine3;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_list']//ul/li[1]/div[2]/h4[4]")
    public WebElement topTicketsListItemLine4;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_list']//ul/li[1]/div[2]/h4[5]")
    public WebElement topTicketsListItemLine5;
    @CacheLookup
    @FindBy(xpath = "//*[@id='bottom_item_indicators']/span/img")
    public WebElement topTicketsListItemBtmIndicator;
    @CacheLookup
    //@FindBy(css = "#ticket_list > ul.list-content > li > #bottom_item_indicators > span > img")
    @FindBy(xpath = "//*[@id='bottom_item_indicators']/span")
    public WebElement topTicketsListItemTouch;
    @CacheLookup
    //@FindBy(css = "#ticket_list > ul.list-content > li > #list-item-footer > div > button.footer-item-selector.button")
    @FindBy(xpath = "//*[@id='list-item-footer']/div/button")
    public WebElement topTicketsListItemQuickActionsBtn;
    @CacheLookup
    @FindBy(xpath = "//li[2]//button[@aria-label='addAttachment']")
    public WebElement topTicketsListItemQuickActionsAddAttachmentBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_list']//ul/li[2]//button[@aria-label='addActivity']")
    public WebElement topTicketsListItemQuickActionsAddActivityBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_list']//ul/li[2]//button[@aria-label='addNote']")
    public WebElement topTicketsListItemQuickActionsAddNoteBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_list']//ul/li[2]//button[@aria-label='viewContact']")
    public WebElement topTicketsListItemQuickActionsContactBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_list']//ul/li[2]//button[@aria-label='viewAccount']")
    public WebElement topTicketsListItemQuickActionsAccountBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_list']//ul/li[2]//button[@aria-label='edit']")
    public WebElement topTicketsListItemQuickActionsEditBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_list']//ul[2]/li[11]")
    public WebElement eleventhLeadsListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_list']//ul[2]/li[21]")
    public WebElement twentyfirstLeadsListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_list']//ul[2]/li[31]")
    public WebElement thirtyfirstLeadsListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_list']/div[2]/div/span")
    public WebElement recordsRemainingListItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_list']//ul[2]/li/h3")
    public WebElement noRecordsListItem;
    //Context Menu elements
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']/div[3]/h2[2]")
    public WebElement ticketsHashTagsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']//ul[@data-group='view']")
    public WebElement ticketsHashTagsPnl;
    @CacheLookup
    @FindBy(xpath = "//div[@id='right_drawer']//h2[contains(., 'KPI')]")
    public WebElement ticketsKPIHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']//ul[@data-group='kpi']")
    public WebElement ticketsKPIPnl;
    //Detail View elements
    //TODO: the Ticket Edit fields need to be updated when needed
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']")
    public WebElement ticketsDetailView;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/div[2]/h2[1]")
    public WebElement ticketsDetailViewQuickActionsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/div[2]/ul[1]/li[1]/a")
    public WebElement ticketsDetailViewCallMainNumberLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/div[2]/ul[1]/li/a")
    public WebElement ticketsDetailViewScheduleActivityLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/div[2]/ul[1]/li[3]/a")
    public WebElement ticketsDetailViewAddNoteLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/div[2]/ul[1]/li[4]/a")
    public WebElement ticketsDetailViewViewAddressLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/div[2]/h2[2]")
    public WebElement ticketsDetailViewDetailsHdr;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[1]/div[2]")
    @FindBy(xpath = "//*[@id='ticket_detail']/div[3]/div[4]/div[2]/span")
    public WebElement ticketsDetailViewContactFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[2]/div[1]")
    @FindBy(xpath = "//*[@id='ticket_detail']//div[@data-property='Area']/span")
    public WebElement ticketsDetailViewAreaFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[2]/div[2]")
    @FindBy(xpath = "//*[@id='ticket_detail']//div[@data-property='Category']/span")
    public WebElement ticketsDetailViewCategoryFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[2]/div[3]")
    @FindBy(xpath = "//*[@id='ticket_detail']//div[@data-property='Issue']/span")
    public WebElement ticketsDetailViewIssueFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[2]/div[4]")
    @FindBy(xpath = "//*[@id='ticket_detail']//div[@data-property='Subject']/span")
    public WebElement ticketsDetailViewSubjectFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[2]/div[5]")
    @FindBy(xpath = "//*[@id='ticket_detail']//div[@data-property='TicketProblem.Notes']/span")
    public WebElement ticketsDetailViewDescriptionFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[1]/div[2]")
    public WebElement ticketsDetailViewWebFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[1]/div[3]")
    public WebElement ticketsDetailViewFaxFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[1]/div[4]")
    public WebElement ticketsDetailViewTypeFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[1]/div[5]")
    public WebElement ticketsDetailViewSubTypeFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[2]/div[6]")
    @FindBy(xpath = "//*[@id='ticket_detail']//div[@data-property='StatusCode']/span")
    public WebElement ticketsDetailViewStatusFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[1]/div[4]")
    @FindBy(xpath = "//*[@id='ticket_detail']//div[@data-property='Urgency.Description']/span")
    public WebElement ticketsDetailViewUrgencyFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[1]/div[5]")
    @FindBy(xpath = "//*[@id='ticket_detail']//div[@data-property='NeededByDate']/span")
    public WebElement ticketsDetailViewNeededDateFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[1]/div[3]")
    @FindBy(xpath = "//*[@id='ticket_detail']//div[@data-property='AssignedTo.OwnerDescription']/span")
    public WebElement ticketsDetailViewAssignedToFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[2]/div[7]")
    @FindBy(xpath = "//*[@id='ticket_detail']//div[@data-property='CompletedBy.OwnerDescription']/span")
    public WebElement ticketsDetailViewCompletedByFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[2]/div[8]")
    @FindBy(xpath = "//*[@id='ticket_detail']//div[@data-property='Contract.ReferenceNumber']/span")
    public WebElement ticketsDetailViewContractFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[2]/div[9]")
    @FindBy(xpath = "//*[@id='ticket_detail']//div[@data-property='ViaCode']/span")
    public WebElement ticketsDetailViewSourceFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[2]/div[10]")
    @FindBy(xpath = "//*[@id='ticket_detail']//div[@data-property='AssignedDate']/span")
    public WebElement ticketsDetailViewAssignedDateFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[2]/div[11]")
    @FindBy(xpath = "//*[@id='ticket_detail']//div[@data-property='TicketSolution.Notes']/span")
    public WebElement ticketsDetailViewResolutionFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[2]/div[12]")
    @FindBy(xpath = "//*[@id='ticket_detail']//div[@data-property='Notes']/span")
    public WebElement ticketsDetailViewCommentsFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/div[2]/h2[3]")
    public WebElement ticketsDetailViewMoreDetailsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[2]")
    public WebElement ticketsDetailViewMoreDetailsFields;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[2]/div[1]")
    public WebElement ticketsDetailViewIndustryFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[2]/div[2]")
    public WebElement ticketsDetailViewBusDescFld;
    @CacheLookup
    //@FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[1]/div[1]")
    @FindBy(xpath = "//*[@id='ticket_detail']/div[3]/div[4]/div[1]/span")
    public WebElement ticketsDetailViewAccountFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[2]/div[3]")
    public WebElement ticketsDetailViewAcctMgrFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[2]/div[4]")
    public WebElement ticketsDetailViewOwnerFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/div[2]/div[2]/div[5]")
    public WebElement ticketsDetailViewLeadSourceFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/div[2]/h2[4]")
    public WebElement ticketsDetailViewRelatedItemsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/descendant::*[text() = 'Activities']")
    public WebElement ticketsDetailViewActivitiesLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/descendant::*[text() = 'Ticket Activities']")
    public WebElement ticketsDetailViewTicketsActivitiesLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/descendant::*[text() = 'Contacts']")
    public WebElement ticketsDetailViewContactsLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/descendant::*[text() = 'Opportunities']")
    public WebElement ticketsDetailViewOpportunitiesLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/descendant::*[text() = 'Tickets']")
    public WebElement ticketsDetailViewTicketsLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/descendant::*[text() = 'Notes/History']")
    public WebElement ticketsDetailViewNotesHistoryLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/descendant::*[text() = 'Addresses']")
    public WebElement ticketsDetailViewAddressesLnk;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']/descendant::*[text() = 'Attachments']")
    public WebElement ticketsDetailViewAttachmentsLnk;
    //Edit View elements
    //TODO: the Lead Edit fields need to be updated when needed
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_edit']")
    public WebElement ticketsEditView;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_edit']/div[2]/h2")
    public WebElement ticketsEditViewDetailsHdr;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_LookupField_0']/input")
    public WebElement ticketsEditViewAccountFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_LookupField_0']/button")
    public WebElement ticketsEditViewAccountFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_LookupField_1']/input")
    public WebElement ticketsEditViewContactFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_LookupField_1']/button")
    public WebElement ticketsEditViewContactFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_LookupField_2']/input")
    public WebElement ticketsEditViewContractFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_LookupField_2']/button")
    public WebElement ticketsEditViewContractFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_LookupField_3']/input")
    public WebElement ticketsEditViewAreaFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_LookupField_3']/button")
    public WebElement ticketsEditViewAreaFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_LookupField_4']/input")
    public WebElement ticketsEditViewCategoryFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_LookupField_4']/button")
    public WebElement ticketsEditViewCategoryFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_LookupField_5']/input")
    public WebElement ticketsEditViewIssueFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_LookupField_5']/button")
    public WebElement ticketsEditViewIssueFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='crm_Fields_PicklistField_0']/input")
    public WebElement ticketsEditViewSourceFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='crm_Fields_PicklistField_0']/button")
    public WebElement ticketsEditViewSourceFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_LookupField_6']/input")
    public WebElement ticketsEditViewUrgencyFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_LookupField_6']/button")
    public WebElement ticketsEditViewUrgencyFldBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@data-field='NeededByDate']//input")
    public WebElement ticketsEditViewNeededDateFld;
    @CacheLookup
    @FindBy(xpath = "//div[@data-field='NeededByDate']//button")
    public WebElement ticketsEditViewNeededDateFldBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@data-field='AssignedDate']//input")
    public WebElement ticketsEditViewAssignedDateFld;
    @CacheLookup
    @FindBy(xpath = "//div[@data-field='AssignedDate']//button")
    public WebElement ticketsEditViewAssignedDateFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_LookupField_7']/input")
    public WebElement ticketsEditViewAssignedToFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_LookupField_7']/button")
    public WebElement ticketsEditViewAssignedToFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_TextField_2']/input")
    public WebElement ticketsEditViewSubjectInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_NoteField_0']/textarea")
    public WebElement ticketsEditViewDescInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_NoteField_1']/textarea")
    public WebElement ticketsEditViewResolutionInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_NoteField_2']/textarea")
    public WebElement ticketsEditViewCommentsInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_TextField_15']/input")
    public WebElement ticketsEditViewWebInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_PhoneField_5']/input")
    public WebElement ticketsEditViewPhoneInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='crm_Fields_AddressField_2']/div")
    public WebElement ticketsEditViewAddressFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='crm_Fields_AddressField_2']/button")
    public WebElement ticketsEditViewAddressFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_PhoneField_6']/input")
    public WebElement ticketsEditViewFaxInputFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='crm_Fields_PicklistField_11']/input")
    public WebElement ticketsEditViewTypeFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='crm_Fields_PicklistField_11']/button")
    public WebElement ticketsEditViewTypeFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='crm_Fields_PicklistField_12']/input")
    public WebElement ticketsEditViewSubTypeFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='crm_Fields_PicklistField_12']/button")
    public WebElement ticketsEditViewSubTypeFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='crm_Fields_PicklistField_1']/input")
    public WebElement ticketsEditViewStatusFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='crm_Fields_PicklistField_1']/button")
    public WebElement ticketsEditViewStatusFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='crm_Fields_PicklistField_14']/input")
    public WebElement ticketsEditViewIndustryFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='crm_Fields_PicklistField_14']/button")
    public WebElement ticketsEditViewIndustryFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_NoteField_0']/div")
    public WebElement ticketsEditViewBusDescFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_NoteField_0']/button")
    public WebElement ticketsEditViewBusDescFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_LookupField_0']/input")
    public WebElement ticketsEditViewAcctMgrFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_LookupField_0']/button")
    public WebElement ticketsEditViewAcctMgrFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_LookupField_1']/input")
    public WebElement ticketsEditViewOwnerFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_LookupField_1']/button")
    public WebElement ticketsEditViewOwnerFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_LookupField_2']/input")
    public WebElement ticketsEditViewLeadSourceFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='argos_Fields_LookupField_2']/button")
    public WebElement ticketsEditViewLeadSourceFldBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticketactivity_edit']//div[@data-field='AssignedDate']//button")
    public WebElement ticketActivityStartDateBtn;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticketactivity_edit']//div[@data-field='CompletedDate']//button")
    public WebElement ticketActivityEndDateBtn;
    @CacheLookup
    // this data-key is specific to user loup for 'Follow-Up' group
    @FindBy(xpath = "//*[@id='groups_configure']//li[@data-key='p6UJ9A0004QM']")
    public WebElement groupsConfigureFollowUp;
    @CacheLookup
    @FindBy(xpath = "//*[@id='right_drawer']//a[@data-title='Follow-Up']")
    public WebElement rmenu_groupFollowUp;
    @FindBy(xpath = "//div[@id='ticket_list']/div/div/div[1]/div/div[2]/div[2]/div[1]/div[last()]/div/span[2]")
    public WebElement followUpTicketsGroupTopComplDate;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_list']//span[2][@data-name='callPhone']")
    public WebElement ticketGroupViewWorkPhoneFld;
    @CacheLookup
    @FindBy(xpath = "//*[@id='urgency_list']//li[1]//h3")
    public WebElement ticketUrgency1stItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='urgency_list']//li[2]//h3")
    public WebElement ticketUrgency2ndItem;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']//ul[@class='tab-list']/li[1]")
    public WebElement ticketDetailViewDetailsTab;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']//ul[@class='tab-list']/li[2]")
    public WebElement ticketDetailViewMoreDetailsTab;
    @CacheLookup
    @FindBy(xpath = "//*[@id='ticket_detail']//ul[@class='tab-list']/li[3]")
    public WebElement ticketDetailViewRelatedItemsTab;
    private WebDriver driver;
    CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);

    public TicketViewsElements(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public String getTicketsListViewTxt() {
        String methodID = "getTicketsListViewTxt";
        String listViewTxt = "";

        try {
            WebElement ticketsListViewInfo = driver.findElement(By.xpath("//*[@id='ticket_list']//ul"));
            listViewTxt = ticketsListViewInfo.getText();
        } catch (Exception excptn) {
            System.out.println(excptn.toString());
        }

        return listViewTxt;
    }


    public boolean NoRecordsFound() {
        boolean result = false;

        return result;
    }
}
