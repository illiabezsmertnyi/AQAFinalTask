package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//input[@name= 'proceedToRetailCheckout']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//span[@id= 'sc-subtotal-label-activecart']")
    private WebElement subtotalText;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void isProceedToCheckoutButtonVisible() {
        proceedToCheckoutButton.isDisplayed();
    }

    public String getSubtotalText() {return subtotalText.getText();}

}
