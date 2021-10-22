package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public CareersPage getCareersPage() {
        return new CareersPage(driver);
    }

    public DealsPage getDealsPage() {
        return new DealsPage(driver);
    }

    public AccountPage getAccountPage() {
        return new AccountPage(driver);
    }

    public LoginPage getLoginPage() {return new LoginPage(driver);}

    public SearchResultsPage getSearchResultsPage() {return new SearchResultsPage(driver);}

    public ProductPage getProductPage() {return new ProductPage(driver);}

    public CartPage getCartPage() {return new CartPage(driver);}

}
