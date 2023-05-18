package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    // Webelements

    @FindBy(xpath = "//button[@class = 'zds-button zds-button--secondary']")
    WebElement registerButton;

    @FindBy(xpath = "//input[@data-qa-input-qualifier = 'logonId']")
    WebElement inputLoginEmailField;

    @FindBy(xpath = "//input[@data-qa-input-qualifier = 'password']")
    WebElement inputLoginPasswordField;

    @FindBy(xpath = "//button[@class = 'zds-button zds-button--primary']")
    WebElement logInButton;




    // Constructor

    public LoginPage(){}
    public LoginPage (ChromeDriver driver){
        super(driver);
        print("LoginPage");
    }



    // Mehods

    // element methods

    public void clickRegisterButton() {
        print("clickRegisterButton");
        waitForElement(registerButton);
        registerButton.click();

    }

    public void enterLoginEmail(String text) {
        print("enterLoginEmail");
        sleep(3);
        waitForElement(inputLoginEmailField);
        inputLoginEmailField.click();
        inputLoginEmailField.sendKeys(text);

    }

    public void enterLoginPassword(String text) {
        print("enterLoginPassword");
        sleep(3);
        waitForElement(inputLoginPasswordField);
        inputLoginPasswordField.click();
        inputLoginPasswordField.sendKeys(text);

    }

    public void clickLogInButton(){
        print("clickLogInButton");
        sleep(3);
        waitForElement(logInButton);
        logInButton.click();
    }










}
