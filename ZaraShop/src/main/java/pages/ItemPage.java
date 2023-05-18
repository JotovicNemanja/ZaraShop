package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
public class ItemPage extends BasePage{

    // Webelements

    @FindBy(xpath = "//a[@class = 'layout-header-search-link__link']")
    WebElement searchButton;

    @FindBy(xpath = "//button[@class = 'product-detail-actions__action-button']/span[text() = 'Check in-store availability']")
    WebElement checkInStoreAvailability;
    @FindBy(xpath = "//span[text() ='Add to bag']")
    WebElement addToBagButton;

    @FindBy(xpath = "//span[text() ='S-M']")
    WebElement sizeButton;

    @FindBy (xpath = "//span[ @class= 'layout-header-shop-cart-link__count']")
    WebElement cartBadge;


//    @FindBy(xpath = "//input[@data-qa-input-qualifier = 'size_43']/parent::div")
//    WebElement sizeNumberModalButton;


    // Constructor

    public ItemPage(){}
    public ItemPage (ChromeDriver driver){
        super(driver);
        print("ItemPage");
    }


    // Methods

    // element methods

    public void clickSearchButtonFromItemPage(){
        waitForElement(searchButton);
        searchButton.click();

    }

    public void clickCheckInStoreAvailability (){
        sleep(2);
        waitForElement(checkInStoreAvailability);
        checkInStoreAvailability.click();

    }

    public void clickSizeNumberModalButton(){
        sleep(2);
        WebElement modalContainer = driver.findElement(By.xpath("//div[@class = 'zds-dialog__focus-trap zds-drawer__content']"));
        WebElement modalSizeButton = modalContainer.findElement(By.xpath(".//div[@class = 'multi-size-selector multi-size-selector--6-columns']/div/following-sibling::div/following-sibling::div/div/div/label/div/following-sibling::span[text() = '41']"));
        modalSizeButton.click();
    }

    public void clickCheckAvailabilityButton(){
        sleep(2);
        WebElement modalContainer = driver.findElement(By.xpath("//div[@class = 'zds-dialog__focus-trap zds-drawer__content']"));
        WebElement modalCheckAvailability = modalContainer.findElement(By.xpath("//button[@class = 'zds-button product-stock-availability-size-selector-form__button zds-button--secondary']/div/span"));
        waitForElement(modalCheckAvailability);
        sleep(2);
        scrollIntoView(modalCheckAvailability);
        Actions action = new Actions(driver);
        action.moveToElement(modalCheckAvailability).click().perform();
        sleep(2);
    }

    public void enterAdressOfStore(String address){
        sleep(2);
        WebElement modalContainer = driver.findElement(By.xpath("//div[@class = 'zds-dialog__focus-trap zds-drawer__content']"));
        WebElement modalInputAdressField = modalContainer.findElement(By.xpath("//div[@class = 'form-input form-input--has-help location-search-form__search']/div/div/label"));
        waitForElement(modalInputAdressField);
        sleep(2);
        Actions action = new Actions(driver);
        action.moveToElement(modalInputAdressField).click().sendKeys(address).perform();
        sleep(2);
    }

    public void clickSearchStoreButton(){
        sleep(2);
        WebElement modalContainer = driver.findElement(By.xpath("//div[@class = 'zds-dialog__focus-trap zds-drawer__content']"));
        WebElement modalSearchStoreButton = modalContainer.findElement(By.xpath(".//button[@class = 'zds-button location-search-form__submit zds-button--secondary']"));
        waitForElement(modalSearchStoreButton);
        sleep(2);
        Actions action = new Actions(driver);
        action.moveToElement(modalSearchStoreButton).click().perform();
        sleep(12);
    }

    public String getTextNearStore(){
        WebElement modalContainer = driver.findElement(By.xpath("//div[@class = 'zds-dialog__focus-trap zds-drawer__content']"));
        WebElement storesNear = modalContainer.findElement(By.xpath(".//div[@class = 'location-search-location__title']"));
        String text = storesNear.getText();
        return text;

    }
    public void clickAddToBagButton() {
        print("clickAddToBagButton");
        waitForElement(addToBagButton);
        sleep(1);
        addToBagButton.click();
    }

    public void clickSizeButton(){
        print("clickSizeButton");
        waitForElement(sizeButton);
        sleep(2);
        sizeButton.click();
    }

    public String getNumberCartBadge(){
        print("getNumberCartBadge");
        String numberInCart = cartBadge.getText();
        return numberInCart;
    }


}
