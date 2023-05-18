package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    // Webelements

    @FindBy(xpath = "//a[@class = 'layout-header-search-link__link']")
    WebElement searchButton;

    @FindBy(xpath = "//a[@class = 'layout-header-link layout-header-links__desktop-link layout-header-links__logon-link link']")
    WebElement loginButton;

    @FindBy(xpath = "//a[@class = 'layout-header-link layout-header-links__desktop-link layout-header-links__help-link link']")
    WebElement helpButton;

    @FindBy(xpath = "//a[@class = 'layout-header-link layout-header-shop-cart-link layout-header-links__shop-cart-link link']")
    WebElement ShoppingCartButton;

    @FindBy(xpath = "//img[@src = 'https://static.zara.net/photos///contents/mkt/spots/ss22-newsletter/subhome-xmedia-03//w/1640/IMAGE-portrait-fill-cabff040-f3d1-40fa-8d04-11261d54bf49-default_0.jpg?ts=1643121593731']")
    WebElement newsletterButton;



    // Constructor

    public HomePage(){}
    public HomePage (ChromeDriver driver){
        super(driver);
        driver.get(Strings.HOME_PAGE_URL);
        print("HomePage");
    }



    // Mehods

    // element methods

    public void clickLoginButton() {
        print("clickLoginButton");
        waitForElement(loginButton);
        loginButton.click();

    }

    public void clickSearchButton() {
        print("clickSearchButton");
        waitForElement(searchButton);
        searchButton.click();

    }

    public void clicHelpButton (){
        print("clicHelpButton");
        waitForElement(helpButton);
        helpButton.click();
    }

    public void clickNewsletterButton(){
        print("clickNewsletterButton");
        sleep(3);
        waitForElement(newsletterButton);
        scrollIntoView(newsletterButton);
        sleep(3);
        newsletterButton.click();

    }







}
