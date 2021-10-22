package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DealsPage extends BasePage{


    @FindBy(xpath = "//b[text() = 'Deals and Promotions']")
    private WebElement bannerText;

    @FindBy(xpath = "//div[contains(@id, 'dealView')]")
    private List<WebElement> amountOfProducts;

    @FindBy(xpath = "//a[text() = 'Deal of the Day']")
    private WebElement dealOfTheDayButton;

    @FindBy(xpath = "//span[text() = 'DEAL OF THE DAY']")
    private WebElement dealOfTheDayText;

    public DealsPage(WebDriver driver) {
        super(driver);
    }

    public String getBannerText() { return bannerText.getText(); }

    public String getAmountOfDeals() {
        return String.valueOf(amountOfProducts.size());
    }

    public void clickDealOfTheDayButton() {
        dealOfTheDayButton.click();
    }

    public WebElement getDealOfTheDay() {
        return dealOfTheDayText;
    }

    public String getDealOfTheDayText() { return dealOfTheDayText.getText(); }

}
