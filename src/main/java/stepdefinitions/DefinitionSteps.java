package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    CareersPage careersPage;
    DealsPage dealsPage;
    AccountPage accountPage;
    LoginPage loginPage;
    PageFactoryManager pageFactoryManager;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    CartPage cartPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks promo field visibility")
    public void userChecksPromoFieldVisibility() { homePage.isPromoFieldVisible(); }

    @When("User clicks 'Deals & Promotions' button")
    public void userClicksDealsPromotionsButton() throws InterruptedException {        Thread.sleep(5000);
        homePage.clickDealsAndPromotionsButton();
    }

    @And("User checks that deals page contains {string} in description")
    public void userChecksThatDealsPageContainsBannerTextInDescription(final String expectedText) {
        dealsPage = pageFactoryManager.getDealsPage();
        dealsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(dealsPage.getBannerText(), expectedText);
    }

    @Then("User checks that amount of deals in catalog are {string}")
    public void userChecksThatAmountOfDealsInCatalogAreAmountOfProducts(final String expectedAmount) {
        dealsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(dealsPage.getAmountOfDeals(), expectedAmount);
    }


    @And("User clicks 'Deal of the Day' button")
    public void userClicksDealOfTheDayButton() {
        dealsPage.clickDealOfTheDayButton();
    }

    @And("User checks product list contains {string} in description")
    public void userChecksProductListContainsKeywordInDescription(final String expectedText) {
        dealsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, dealsPage.getDealOfTheDay());
        assertEquals(dealsPage.getDealOfTheDayText(), expectedText);
    }

    @And("User checks footer visibility")
    public void userChecksFooterVisibility() { homePage.isFooterVisible(); }

    @When("User clicks 'Careers' button")
    public void userClicksCareersButton() { homePage.clickCareersButton(); }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        careersPage = pageFactoryManager.getCareersPage();
        careersPage.isSearchFieldVisible();
    }

    @Then("User checks that amount of opportunities link  is {string}")
    public void userChecksThatAmountOfOpportunitiesLinkIsAmount(final String expectedAmount) {
        careersPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(careersPage.getAmountOfOpportunities(), expectedAmount);

    }

    @And("User checks 'Learn about' button visibility")
    public void userChecksLearnAboutButtonVisibility() {
        careersPage.isLearnAboutButtonVisible();
    }

    @And("User checks header visibility")
    public void userChecksHeaderVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isHeaderVisible();

    }

    @And("User checks login pop-up visibility")
    public void userChecksLoginPopUpVisibility() {homePage.isSignInPopupVisible();}

    @When("User clicks 'Sign in' button")
    public void userClicksSignInButton() {homePage.clickSignInButton();}

    @And("User writes in valid {string}")
    public void userWritesInValidEMail(final String keyword) {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, loginPage.getEmailField());
        loginPage.enterTextToEmailField(keyword);
    }

    @And("User clicks 'Continue' button")
    public void userClicksContinueButton() {loginPage.clickContinueButton();

    }

    @And("User writes in valid {string} too")
    public void userWritesInValidPassword(final String keyword) {
        loginPage.enterTextToPasswordField(keyword);
    }

    @And("User writes in invalid {string}")
    public void userWritesInInvalidPassword(final String keyword) {
        loginPage.enterTextToPasswordField(keyword);
    }

    @Then("User checks that error message is {string}")
    public void userChecksThatErrorMessageIsErrorMessage(final String expectedText) {
        assertEquals(loginPage.getErrorMessage(), expectedText);
    }

    @And("User clicks 'Sign-In' button")
    public void userClicksAnotherSignInButton() { loginPage.clickSignInButton(); }

    @Then("User hovers the mouse to 'Account & Lists'")
    public void userHoversTheMouseToAccountLists() { homePage.moveToAccountMenu(); }

    @And("User clicks 'Account' button")
    public void userClicksAccountButton() { homePage.clickAccountButton(); }

    @And("User clicks 'Your orders' button")
    public void userClicksYourOrdersButton() {homePage.clickYourOrdersButton();}

    @And("User checks 'Search Orders' button visibility")
    public void userChecksSearchOrdersButtonVisibility() {
        accountPage = pageFactoryManager.getAccountPage();
        assertTrue(accountPage.isSearchOrdersButtonVisible());
    }

    @And("User clicks 'Forgot your password?' button")
    public void userClicksForgotYourPasswordButton() {
        loginPage.clickForgotPasswordButton();
    }

    @Then("User clicks 'I need more help' button")
    public void userClicksINeedMoreHelpButton() {
        loginPage.clickHelpButton();
    }

    @And("User checks that verification message is {string}")
    public void userChecksThatVerificationMessageIsVerificationMessage(final String expectedText) {
        assertThat(expectedText, containsString(loginPage.getHelpMessage()));
    }

    @When("User clicks 'All' button")
    public void userClicksAllButton() { homePage.clickAllCatalogButton(); }

    @And("User clicks 'Electronics' button")
    public void userClicksElectronicsButton() { homePage.clickElectronicsButton(); }

    @And("User clicks 'Headphones' button")
    public void userClicksHeadphonesButton() { homePage.clickHeadphonesButton(); }

    @Then("User checks that amount of products in catalog are {string}")
    public void userChecksThatAmountOfProductsInCatalogAreAmountOfProducts(final String expectedAmount) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        assertEquals(searchResultsPage.getAmountOfProducts(), expectedAmount);
    }

    @And("User checks category is {string}")
    public void userChecksCategoryIsCategory(final String expectedText) {
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(searchResultsPage.getHeadphonesCategoryText(), expectedText);
    }

    @And("User clicks products page button")
    public void userClicksProductsPageButton() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.clickProductPageButton();
    }

    @And("User checks category is {string} again")
    public void userChecksCategoryIsCategoryAgain(final String expectedText) {
        productPage = pageFactoryManager.getProductPage();
        assertEquals(productPage.getCategoryCheckText(), expectedText);
    }

    @And("User checks home search field visibility")
    public void userChecksHomeSearchFieldVisibility() { assertTrue(homePage.isSearchFieldVisible()); }

    @When("User makes search by {string}")
    public void userMakesSearchByKeyword(final String searchText) {
        homePage.enterTextToSearchField(searchText);
    }

    @And("User clicks search button")
    public void userClicksSearchButton() { homePage.clickSearchButton(); }

    @And("User clicks 'Add to Cart' button on product")
    public void userClicksAddToCartButtonOnProduct() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.isCartButtonVisible());
        productPage.clickAddToCartButton();
    }

    @And("User checks that add to cart page is visible")
    public void userChecksThatAddToCartPageIsVisible() { assertTrue(productPage.isAddToCartPageVisible());
    }

    @Then("User clicks cart button")
    public void userClicksCartButton() {
        productPage.clickCartButton();
    }

    @And("User checks 'Proceed to checkout' button visibility")
    public void userChecksProceedToCheckoutButtonVisibility() {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.isProceedToCheckoutButtonVisible();
    }

    @And("User checks Subtotal is {string}")
    public void userChecksSubtotalIsSubtotal(final String expectedText) {
        assertEquals(cartPage.getSubtotalText(), expectedText);
    }

    @Then("User clicks 'Camcorders' button")
    public void userClicksCamcordersButton() {
        searchResultsPage.clickCamcordersButton();
    }

    @And("User clicks 'Under $25' button")
    public void userClicksUnderButton() {
        searchResultsPage.clickUnder25Button();
    }

    @Then("User checks that search error message is {string}")
    public void userChecksThatSearchErrorMessageIsErrorMessage(final String expectedText) {
        assertEquals(searchResultsPage.getNoResultMessage(), expectedText);
    }

    @And("User checks that add to cart page is {string}")
    public void userChecksThatAddToCartPageIsAddToCart(final String expectedText) {
        productPage = pageFactoryManager.getProductPage();
        assertEquals(productPage.isAddToCartPageVisible(), expectedText);
    }

    @And("User clicks home button")
    public void userClicksHomeButton() { homePage.clickLogoButton();}

    @After
    public void tearDown() {
        driver.close();
    }

}
