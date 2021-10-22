package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CareersPage extends BasePage{

    @FindBy(xpath = "//div[@class = 'container']//input[@id=\"search_typeahead\"]")
    private WebElement searchField;

    @FindBy(xpath = "//div[@class = 'row']/div[contains(@class, 'col-12 d')]")
    private List<WebElement> amountOfOpportunities;

    @FindBy(xpath = "//div[@class = 'button-wrapper']/a")
    private WebElement learnAboutButton;

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public String getAmountOfOpportunities() {
        return String.valueOf(amountOfOpportunities.size());
    }

    public void isLearnAboutButtonVisible() {
        learnAboutButton.isDisplayed();
    }

}
