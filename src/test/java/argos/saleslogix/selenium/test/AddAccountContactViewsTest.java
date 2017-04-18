package argos.saleslogix.selenium.test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * @author mllena
 * Class: AccountEntityViewsTest
 * Desc.: Test class for the Account entity views
 */
public class AddAccountContactViewsTest extends BaseTest {
	@Test
	public void test01_SeTestTCAddAccountContact() throws Exception {
		String methodID = "test01_SeTestTCAddAccountContact";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: login & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
				
		AddAccountContactEditViewElements addAcctCntctView = PageFactory.initElements(driver, AddAccountContactEditViewElements.class);
		
		//Step: add a random test Account & Contact records
		String newAcctName = "SeAutoTestAddAcctCntct-" + new SimpleDateFormat("yyMMddHHmm").format(new GregorianCalendar().getTime());
		String newConLastName = "Smith-" + new SimpleDateFormat("yyMMddHHmm").format(new GregorianCalendar().getTime());
		addAcctCntctView.doAddRandAccountContact(newConLastName, newAcctName);
		
		//Step: find the newly-added test Account record
		AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
		String strResultsMsg = "VP: recently added test Account '" + newAcctName + "' was found.";
		if (accountsListView.doSearchAccount(newAcctName)) {
			System.out.println(strResultsMsg + " - PASSED");
		}
		else {
			System.out.println(strResultsMsg + " - FAILED");
		}
		
		//Step: find the newly-added test Contact record
		ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
		strResultsMsg = "VP: recently added test Contact '" + newConLastName + "' was found.";
        String fullName = newConLastName + ", A.";
        WebElement entityListItem = commNav.entityListViewSearch("Contact", fullName);
        if (entityListItem.isDisplayed())  {
            System.out.println(strResultsMsg + " - PASSED");
        }
        else {
            System.out.println(strResultsMsg + " - FAILED");
        }
		
		//Step: go back to My Activities view
		//commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);
	}


	@Test(enabled = false)
	public void test02_SeTestTCAddAccountOnly() throws Exception {
		String methodID = "test02_SeTestTCAddAccountOnly";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: login & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
				
		AddAccountContactEditViewElements addAcctCntctView = PageFactory.initElements(driver, AddAccountContactEditViewElements.class);
		
		//Step: add a random test Account & Contact records
		String newAcctName = "SeAutoTestAddAcctOnly-" + new SimpleDateFormat("yyMMddHHmm").format(new GregorianCalendar().getTime());
		String newConLastName = "Smith-" + new SimpleDateFormat("yyMMddHHmm").format(new GregorianCalendar().getTime());
		addAcctCntctView.doAddRandContactOnly(newConLastName, newAcctName);
		
		//Step: find the newly-added test Account record
		AccountViewsElements accountsListView = PageFactory.initElements(driver, AccountViewsElements.class);
		String strResultsMsg = "VP: recently added test Account '" + newAcctName + "' was found.";
		if (accountsListView.doSearchAccount(newAcctName)) {
			System.out.println(strResultsMsg + " - Passed");
		}
		else {
			System.out.println(strResultsMsg + " - FAILED");
		}
		
		//Step: go back to My Activities view
		//commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);
	}


	@Test(enabled = false)
	public void test03_SeTestTCAddContactOnly() throws Exception {
		String methodID = "test03_SeTestTCAddContactOnly";
		
		CommonNavigation commNav = PageFactory.initElements(driver, CommonNavigation.class);
		
		System.out.println(STARTLINE + " " + methodID + " " + STARTLINE);
		
		//Step: login & log back in (to clear cookies)
		LogOutThenLogBackIn(userName, userPwd);
				
		AddAccountContactEditViewElements addAcctCntctView = PageFactory.initElements(driver, AddAccountContactEditViewElements.class);
		
		//Step: add a random test Account & Contact records
		String newAcctName = "SeAutoTestCntctOnly-" + new SimpleDateFormat("yyMMddHHmm").format(new GregorianCalendar().getTime());
		String newConLastName = "Smith-" + new SimpleDateFormat("yyMMddHHmm").format(new GregorianCalendar().getTime());
		addAcctCntctView.doAddRandContactOnly(newConLastName, newAcctName);
		
		//Step: find the newly-added test Contact record
		ContactViewsElements contactsListView = PageFactory.initElements(driver, ContactViewsElements.class);
		String strResultsMsg = "VP: recently added test Contact '" + newConLastName + "' was found.";
		if (contactsListView.doSearchContact(newConLastName)) {
			System.out.println(strResultsMsg + " - Passed");
		}
		else {
			System.out.println(strResultsMsg + " - FAILED");
		}
		
		//Step: go back to My Activities view
		//commNav.clickGlobalMenuItem("My Activities");
		
		System.out.println(ENDLINE);
	}
}
