package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HelpPage extends BasePage{

    // Webelements

    @FindBy (xpath = "//input[@class = 'ais-SearchBox-input help-search-box__search-box-input']")
    WebElement searchHelpButton;

    @FindBy (xpath = "//ol[@class = 'ais-Hits-list']/li/div/a")
    WebElement firstQuestionOption;

    @FindBy (xpath = "//button[@id= 'accordion-RefundEmailNonReceived']/div/span")
    WebElement selectedQuestionTitle;

    @FindBy (xpath = "//h3[@id = 'help-EXCHANGES, RETURNS AND REFUNDS']")
    WebElement footerQuestionOptios;

    @FindBy (xpath = "//a[text() = 'HOW TO EXCHANGE']")
    WebElement howToExchangQuestionOption;

    @FindBy (xpath = "//a[text() = 'Newsletter']")
    WebElement newsletterButton;

    // Constructor

    public HelpPage(){}
    public HelpPage (ChromeDriver driver){
        super(driver);
        print("HelpPage");
    }

    // Methods

    // element methods

    public void enterQuestionInQueryField(String text){
        print("enterQuestionInQueryField");
        waitForElement(searchHelpButton);
        searchHelpButton.click();
        searchHelpButton.sendKeys(text);
        sleep(6);
    }

    public void hoverAndClickFirst(){
        print("hooverAndClickFirst");
        Actions action = new Actions(driver);
        action.moveToElement(firstQuestionOption).click().perform();
        sleep(2);
    }

    public String getTextOfQuestionTitle(){
        sleep(3);
        String text = selectedQuestionTitle.getText();
        return text;
    }

    public void scrollToExchangesReturnsAndRefunds (){
        print("scrollToExchangesReturnsAndRefunds");
        scrollIntoView(footerQuestionOptios);
        sleep(3);
    }

    public void clickHowToExchangQuestionOption(){
        print("clickHowToExchangQuestionOption");
        waitForElement(howToExchangQuestionOption);
        howToExchangQuestionOption.click();
    }

    public void clickNewsletterButton(){
        print("clickNewsletterButton");
        waitForElement(newsletterButton);
        scrollIntoView(newsletterButton);
        newsletterButton.click();
    }


}
