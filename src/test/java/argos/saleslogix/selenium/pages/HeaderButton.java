package argos.saleslogix.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.AssertJUnit;

import java.util.concurrent.TimeUnit;

public class HeaderButton {

    //@CacheLookup
    @FindBy(xpath = "//div[@class='buttonset']/button[@data-tool='toggleLeftDrawer']")
    public WebElement globalMenuButton;
    //@CacheLookup
    @FindBy(xpath = "//div[@selected='selected']//div[@class='buttonset']/button[@data-action='openSettings']")
    public WebElement rightCntxtMnuButton; // TODO: This is no longer a header item, move it to common nav.
    //@CacheLookup
    @FindBy(xpath = "//div[@class='buttonset']/button[@data-tool='new']")
    public WebElement addButton;
    //@CacheLookup
    @FindBy(xpath = "//div[@class='buttonset']/button[@data-tool='briefCase']")
    public WebElement briefcaseButton;
    //@CacheLookup
    @FindBy(xpath = "//div[@class='buttonset']/button[@data-tool='edit']")
    public WebElement editButton;
    //@CacheLookup
    @FindBy(xpath = "//div[@class='buttonset']/button[@data-tool='save']")
    public WebElement saveButton;
    //@CacheLookup
    @FindBy(xpath = "//div[@class='buttonset']/button[@data-tool='refresh']")
    public WebElement refreshButton;
    //@CacheLookup
    @FindBy(xpath = "//div[@class='buttonset']/button[@data-tool='complete']")
    public WebElement checkButton;
    //@CacheLookup
    @FindBy(xpath = "//div[@class='buttonset']/button[@data-tool='delete']")
    public WebElement deleteButton;
    //@CacheLookup
    @FindBy(xpath = "//div[@class='buttonset']/button[@data-tool='cancel']")
    public WebElement cancelButton;
    //@CacheLookup
    @FindBy(xpath = "//div[@class='buttonset']/button[@data-tool='back']")
    public WebElement backButton;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@class, 'toolbar')]/div[@class='more']/button[@aria-controls='app-toolbar-more']")
    public WebElement moreButton;
    @CacheLookup
    @FindBy(id = "app-toolbar-more")
    public WebElement moreMenu;

    private WebDriver driver;

    public HeaderButton(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSafeElement(By locator) throws InterruptedException {
        int i = 0;
        WebElement element = null;
        while (i < 5) {
            try {
                element = driver.findElement(locator);
                element.click();
                break;
            } catch (Exception e) {
                Thread.sleep(1000);
                element = driver.findElement(locator);
                element.click();
            }
        }
        return element;
    }


    /**
     * This method will click the header Global Menu button to display the Global Menu items.
     *
     * @throws InterruptedException
     * @author mike.llena@swiftpage.com
     * @version 1.0
     */
    public HeaderButton showGlobalMenu() throws InterruptedException {
        CommonNavigation commonNavigation = PageFactory.initElements(driver, CommonNavigation.class);
        commonNavigation.openNav();
        return this;
    }

    public boolean showRightContextMenu() throws InterruptedException {
        CommonNavigation commonNavigation = PageFactory.initElements(driver, CommonNavigation.class);
        commonNavigation.openSettings();
        return true;
    }

    public HeaderButton goBack() throws InterruptedException {
        String methodID = "goBack";

        WebElement pgTitleBar = driver.findElement(By.xpath(".//*[@id='pageTitle']"));
        String oldPgTitle = driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText();

        //conditionally close the Right Context Menu panel (if blocking the Global Menu button)
        closeRightContextMenu();

        try {
            //click the Header Back button
            backButton.click();
            Thread.sleep(1500);
        } catch (Exception e) {
            //revert to Backspace key-press if Back button click fails
            pgTitleBar.click();
            pgTitleBar.sendKeys(Keys.BACK_SPACE);
            Thread.sleep(1500);
        }

        String newPgTitle = driver.findElement(By.xpath(".//*[@id='pageTitle']")).getText();

        // Verify that previous page is displayed (new title not equal to old)
        try {
            AssertJUnit.assertFalse(oldPgTitle == newPgTitle);
        } catch (Error e) {
            System.out.println(methodID + "(): " + e.toString());
        }
        return this;
    }

    public HeaderButton clickHeaderButton(String buttonName) throws InterruptedException {
        CommonNavigation commonNavigation = PageFactory.initElements(driver, CommonNavigation.class);
        WebElement menuToClick = null;
        switch (buttonName.toLowerCase()) {
            case "global menu":
            case "global":
                menuToClick = globalMenuButton;
                break;
            case "right context menu":
            case "right menu":
            case "right":
                menuToClick = rightCntxtMnuButton;
                break;
            case "back":
            case "go back":
                menuToClick = backButton;
                break;
            case "cancel":
                menuToClick = cancelButton;
                break;
            case "add":
            case "add new":
                menuToClick = addButton;
                break;
            case "edit":
                menuToClick = editButton;
                break;
            case "briefcase":
                menuToClick = briefcaseButton;
                break;
            case "check":
            case "accept":
                menuToClick = checkButton;
                break;
            case "delete":
                menuToClick = deleteButton;
                break;
            case "save":
                menuToClick = saveButton;
                break;
        }

        if (menuToClick == null) {
            return this;
        }

        if (menuToClick.isDisplayed()) {
            menuToClick.click();
        } else {
            String title = menuToClick.getAttribute("title");
            moreButton.click();
            WebElement popupMenuItem = driver.findElement(By.xpath("//ul[@id='app-toolbar-more']/li/a/span[contains(text(), '" + title + "')]/.."));
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .pollingEvery(50, TimeUnit.MILLISECONDS)
                    .withTimeout(5, TimeUnit.SECONDS);
            wait.until((d) -> popupMenuItem.isEnabled());
            commonNavigation.highlightNClick(popupMenuItem);
        }
        return this;
    }

    public boolean closeRightContextMenu() throws InterruptedException {
        CommonNavigation commonNavigation = PageFactory.initElements(driver, CommonNavigation.class);
        commonNavigation.openNav();
        return true;
    }
}
