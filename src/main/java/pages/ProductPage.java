package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends BasePage {

    @FindBy(xpath = "//span[@class]/a[contains(text(), 'Headphones')]")
    private WebElement categoryCheck;

    @FindBy(xpath = "//input[@id = 'add-to-cart-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[contains(@class, 'attach-primary-atc-confirm-box')]")
    private WebElement addToCartPage;

    @FindBy(xpath = "//input[@class = 'a-button-input']")
    private WebElement cartButton;


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getCategoryCheckText() {return categoryCheck.getText();}

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public boolean isAddToCartPageVisible() { return addToCartPage.isDisplayed(); }

    public void clickCartButton() {
        cartButton.click();
    }

    public WebElement isCartButtonVisible() { return cartButton; }


}
