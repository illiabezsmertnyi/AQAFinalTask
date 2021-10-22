package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//header")
    private WebElement header;

    @FindBy(xpath = "//div[@id = 'navFooter']")
    private WebElement footer;

    @FindBy(xpath = "//div[@id= 'gw-layout']")
    private WebElement promoField;

    @FindBy(xpath = "//img[@alt = 'Deals & Promotions']")
    private WebElement dealsAndPromotionsButton;

    @FindBy(xpath = "//a[text() = 'Careers']")
    private WebElement careersButton;

    @FindBy(xpath = "//a[@data-nav-ref= 'nav_custrec_signin']/span[@class = 'nav-action-inner']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class = 'nav-signin-tt nav-flyout']")
    private WebElement signInPopup;

    @FindBy(xpath = "//input[@id= 'twotabsearchtextbox']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@id= 'nav-search-submit-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@id= 'nav-link-accountList']")
    private WebElement accountMenu;

    @FindBy(xpath = "//span[text() = 'Account']")
    private WebElement accountButton;

    @FindBy(xpath = "//div[@data-card-identifier = 'YourOrders']")
    private WebElement yourOrdersButton;

    @FindBy(xpath = "//a[@id = 'nav-hamburger-menu']")
    private WebElement allCatalogButton;

    @FindBy(xpath = "//div[text() = 'Electronics']")
    private WebElement electronicsButton;

    @FindBy(xpath = "//a[text() = 'Headphones']")
    private WebElement headphonesButton;

    @FindBy(xpath = "//a[@id = 'nav-logo-sprites']")
    private WebElement logoButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {driver.get(url);}

    public void isHeaderVisible() {
        header.isDisplayed();
    }

    public void isFooterVisible() {
        footer.isDisplayed();
    }

    public void isPromoFieldVisible() {
        promoField.isDisplayed();
    }

    public void clickCareersButton() {careersButton.click();}

    public void clickSignInButton() {
        signInButton.click();
    }

    public void clickDealsAndPromotionsButton() {
        dealsAndPromotionsButton.click();
    }

    public void isSignInPopupVisible() {
        signInPopup.isDisplayed();
    }

    public void moveToAccountMenu() {
        Actions actions = new Actions(driver);
        actions.moveToElement(accountMenu).perform();
    }
    public void clickAccountButton() {accountButton.click();}

    public void clickYourOrdersButton() {yourOrdersButton.click();}

    public boolean isSearchFieldVisible() {
        return searchField.isDisplayed();
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickAllCatalogButton() {
        allCatalogButton.click();
    }

    public void clickElectronicsButton() {
        electronicsButton.click();
    }

    public void clickHeadphonesButton() {
        headphonesButton.click();
    }

    public void clickLogoButton() {logoButton.click();}

}
