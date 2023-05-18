package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    // Webelements

    @FindBy (xpath = "//input[@data-qa-input-qualifier = 'email']")
    WebElement inputEmailField;

    @FindBy (xpath = "//input[@data-qa-input-qualifier= 'password']")
    WebElement inputPasswordField;

    @FindBy (xpath = "//input[@data-qa-input-qualifier= 'passwordConfirm']")
    WebElement inputPasswordRepeatField;

    @FindBy (xpath = "//input[@data-qa-input-qualifier= 'firstName']")
    WebElement inputNameField;

    @FindBy (xpath = "//input[@data-qa-input-qualifier= 'lastName']")
    WebElement inputSurnameField;

    @FindBy (xpath = "//div [@data-name = 'newsletterCheck']//div//div/label")
    WebElement receiveZaraMailCheckbox;

    @FindBy (xpath = "//div[@data-name = 'privacyCheck']/div/div/label/div")
    WebElement privacyAndCookiesPolicyCheckbox;

    @FindBy (xpath = "//div[@class = 'zds-button__lines-wrapper']")
    WebElement createAccountButton;








    // Constructor

    public RegisterPage(){}
    public RegisterPage (ChromeDriver driver){
        super(driver);
        print("RegisterPage");
    }

    // Methods

    // elements methods

    public void enterEmail(String text){
        print("enterEmail");
        waitForElement(inputEmailField);
        inputEmailField.click();
        inputEmailField.sendKeys(text);
    }

    public void enterPassword(String text){
        print("enterPassword");
        waitForElement(inputPasswordField);
        inputPasswordField.click();
        inputPasswordField.sendKeys(text);
    }

    public void enterPasswordRepeat(String text){
        print("enterPasswordRepeat");
        waitForElement(inputPasswordRepeatField);
        inputPasswordRepeatField.click();
        inputPasswordRepeatField.sendKeys(text);
    }

    public void enterName(String text){
        print("enterName");
        waitForElement(inputNameField);
        inputNameField.click();
        inputNameField.sendKeys(text);
    }

    public void enterSurname(String text){
        print("enterSurname");
        waitForElement(inputSurnameField);
        inputSurnameField.click();
        inputSurnameField.sendKeys(text);
    }

    public void clickReceiveZaraMailCheckbox (){
        print("clickReceiveZaraMailCheckbox");
        waitForElement(receiveZaraMailCheckbox);
        receiveZaraMailCheckbox.click();

    }

    public void clickPrivacyAndCookiesPolicyCheckbox(){
        print("clickPrivacyAndCookiesPolicyCheckbox");
        waitForElement(privacyAndCookiesPolicyCheckbox);
        privacyAndCookiesPolicyCheckbox.click();
    }
    public void clickCreateAccountButton (){
        print("clickCreateAccountButton");
        waitForElement(createAccountButton);
        createAccountButton.click();
    }


    // helper methods
}
