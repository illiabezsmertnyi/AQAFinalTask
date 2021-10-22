package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class = 'a-section a-spacing-medium']")
    private List<WebElement> amountOfProducts;

    @FindBy(xpath = "//span[text() = 'Headphones']")
    private WebElement headphonesCategory;

    @FindBy(xpath = "//a[@class = 'a-link-normal a-text-normal']")
    private WebElement productPageButton;

    @FindBy(xpath = "//span[text() = 'Camcorders']")
    private WebElement camcordersButton;

    @FindBy(xpath = "//span[text() = 'Under $25']")
    private WebElement under25Button;

    @FindBy(xpath = "//span[text() = 'No results for ']")
    private WebElement noResultMessage;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getAmountOfProducts() {
        return String.valueOf(amountOfProducts.size());
    }

    public String getHeadphonesCategoryText() { return headphonesCategory.getText(); }

    public void clickProductPageButton() {productPageButton.click();}

    public void clickCamcordersButton() {camcordersButton.click();}

    public void clickUnder25Button() {under25Button.click();}

    public String getNoResultMessage() { return noResultMessage.getText(); }

}
