package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

    @FindBy(xpath = "//form[@id= 'searchForm']//input[@type = 'submit']")
    private WebElement searchOrdersButton;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchOrdersButtonVisible() {
        return searchOrdersButton.isDisplayed();
    }

}
