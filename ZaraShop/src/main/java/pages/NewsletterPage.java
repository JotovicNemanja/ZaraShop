package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class NewsletterPage extends BasePage{

    // Webelements

    @FindBy(xpath = "//label[@class = 'form-input-label__label']/parent::div")
    WebElement newsletterEmail;

    @FindBy(xpath = "//input[@data-qa-input-qualifier='privacyCheck']")
    WebElement cookiesCheckboxField;

    @FindBy(xpath = "//span[text()= 'Man']")
    WebElement menSectionsCheckboxField;

    @FindBy(xpath = "//span[text()='Save']")
    WebElement saveButton;

    @FindBy(xpath = "//button[@class = 'zds-button newsletter-category-buttons__unsubscribe zds-button--secondary']")
    WebElement unsubscribeButton;


    // Constructor

    public NewsletterPage(){}
    public NewsletterPage (ChromeDriver driver){
        super(driver);
        print("NewsletterPage");
    }

    // Methods

    // element methods

    public void enterEmailForNewsletter (String text){
        print("enterEmailForNewsletter");
        sleep(2);
        waitForElement(newsletterEmail);
        sleep(2);
        Actions action = new Actions(driver);
        action.moveToElement(newsletterEmail).click().sendKeys(text).perform();
    }

    public void clickCookiesCheckboxField(){
        print("clickCookiesCheckboxField");
        waitForElement(cookiesCheckboxField);
        scrollIntoView(cookiesCheckboxField);
        sleep(2);
        Actions action = new Actions(driver);
        action.moveToElement(cookiesCheckboxField).click().perform();
        sleep(2);
    }

    public void clickMenSectionsCheckboxField() {
        print("clickMenSectionsCheckboxField");
        waitForElement(menSectionsCheckboxField);
        scrollIntoView(menSectionsCheckboxField);
        menSectionsCheckboxField.click();
        sleep(2);
    }

    public void clickSaveButton(){
        print("clickSaveButton");
        sleep(1);
        waitForElement(saveButton);
        scrollIntoView(saveButton);
        saveButton.click();
    }

    public String getTextModalTitle(){
        sleep(5);
        WebElement modalContainer = driver.findElement(By.xpath("//div[@class = 'zds-dialog__focus-trap zds-alert-dialog__focus-trap']"));
        WebElement title = modalContainer.findElement(By.xpath(".//h1[text() = 'Newsletter']"));
        String text = title.getText();
        return text;
    }
    public void clickUnsubscribeButton (){
        sleep(1);
        waitForElement(unsubscribeButton);
        scrollIntoView(unsubscribeButton);
        unsubscribeButton.click();
    }







}
