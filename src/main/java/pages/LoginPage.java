package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@type = 'email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type = 'password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id= 'continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@id= 'signInSubmit']")
    private WebElement signInButton;

    @FindBy(xpath = "//h4")
    private WebElement errorMessage;

    @FindBy(xpath = "//a[@id = 'ap_change_login_claim']")
    private WebElement forgotPasswordButton;

    @FindBy(xpath = "//span[@class= 'a-size-base']")
    private WebElement helpButton;

    @FindBy(xpath = "//div[@aria-expanded= 'true']")
    private WebElement helpMessage;


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void enterTextToEmailField(final String searchText) {
        emailField.clear();
        emailField.sendKeys(searchText);
    }

    public void enterTextToPasswordField(final String searchText) {
        passwordField.clear();
        passwordField.sendKeys(searchText);
    }

    public void clickContinueButton() {continueButton.click();}

    public void clickSignInButton() {signInButton.click();}

    public WebElement getEmailField() {
        return emailField;
    }

    public String getErrorMessage() {return errorMessage.getText();}

    public void clickForgotPasswordButton() {forgotPasswordButton.click();}

    public void clickHelpButton() {helpButton.click();}

    public String getHelpMessage() {return helpMessage.getText();}

}
