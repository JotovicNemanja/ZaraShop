package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{


    // Webelements

    @FindBy (xpath = "//input[@id = 'search-products-form-combo-input']")
    WebElement inputSearchField;

    @FindBy (xpath = "//div[@class = 'search-products-view__results-count']/span")
    WebElement numberOfResults;


    @FindBy (xpath = "//*[@id='main']/article/div/div/section/div[1]/div[1]/div/form/div[1]/div/div/svg/path")
    WebElement closeSearchButton;

    @FindBy (xpath = "//li[@class = 'products-category-grid-media-carousel-item']")
    WebElement firstItem;


    @FindBy (xpath = "//button[@class = 'search-products-recent__clear']")
    WebElement clearRecentButton;

    @FindBy (xpath = "//button[@class = 'search-products-tile__main-btn']")
    WebElement itemsSearchRecent;

    @FindBy (xpath = "//h2 [@class = 'search-products-recent__title']")
    WebElement itemsSearchRecentText;

    @FindBy (xpath = "//button[@class = 'search-products-sections-bar__section-button search-products-sections-bar__section-button--selected']/parent::li/following-sibling::li/button[text()  = 'Man']")
    WebElement menCategoryButton;

    @FindBy(xpath = "//section[@class = 'product-grid']/ul/li/a/div/div/div/div/div/ul/li/div/div/img[@src =  'https://static.zara.net/photos///2023/V/1/2/p/2252/020/800/2/w/408/2252020800_6_1_1.jpg?ts=1670585414020']")
    WebElement chunkyTrainersBlackMenItem;

    @FindBy (xpath = "//span[@class = 'filters__button-title']/span")
    WebElement filtersButton;
    @FindBy (xpath = "//img[@alt = 'Image 0 of CORDUROY PUFFER JACKET from Zara']/parent::div")
    WebElement itemJacketButton;



    // Constructor

    public SearchPage(){}
    public SearchPage (ChromeDriver driver){
        super(driver);
        print("SearchPage");
    }

    // Methods

    // element methods

    public void enterItemName (String text){
        print("enterItemName");
        waitForElement(inputSearchField);
        sleep(2);
        inputSearchField.click();
        inputSearchField.sendKeys(text);
    }

    public String getTextFromNumberOfResults () {
        waitForElement(numberOfResults);
        String numberResults = numberOfResults.getText();
        return numberResults;
    }

    public void clickFirstItem(){
        print("clickFirstItem");
        waitForElement(firstItem);
        firstItem.click();
    }

    public void clickClearRecentButton(){
        print("clickClearRecentButton");
        sleep(5);
        clearRecentButton.click();
    }
    public void clickMenCategoryButton(){
        print("clickMenCategoryButton");
        sleep(2);
        waitForElement(menCategoryButton);
        menCategoryButton.click();
    }

    public void clickChunkyTrainersBlackMenItem (){
        print("clickChunkyTrainersBlackMenItem");
        sleep(2);
        waitForElement(chunkyTrainersBlackMenItem);
        chunkyTrainersBlackMenItem.click();
    }

    public void clickFiltersButton(){
        print("clickFiltersButton");
        sleep(2);
        waitForElement(filtersButton);
        scrollIntoView(filtersButton);
        filtersButton.click();
        sleep(3);
    }

    public void clickModalButtonCharacteristicsMenu(){
        print("clickModalButtonCharacteristicsMenu");
        WebElement modalContainer = driver.findElement(By.xpath("//div[@id = 'theme-modal-container']"));
        WebElement modalCharacteristicsMenu = modalContainer.findElement(By.xpath("//span[text() = 'CHARACTERISTICS']"));
        Actions action = new Actions(driver);
        action.moveToElement(modalCharacteristicsMenu).click().perform();
        sleep(2);
    }


    public void clickModalButtonPufferType(){
        print("clickModalButtonPufferType");
        WebElement modalContainer = driver.findElement(By.xpath("//div[@id = 'theme-modal-container']"));
        WebElement modalPufferJacketType = modalContainer.findElement(By.xpath("//span[text() = 'PUFFER']"));
        Actions action = new Actions(driver);
        action.moveToElement(modalPufferJacketType).click().perform();
        sleep(2);
    }

    public void clickModalButtonColourMenu(){
        print("ClickModalButtonColourMenu");
        WebElement modalContainer = driver.findElement(By.xpath("//div[@id = 'theme-modal-container']"));
        WebElement modalColourMenu = modalContainer.findElement(By.xpath("//span[text() = 'Colour']"));
        Actions action = new Actions(driver);
        action.moveToElement(modalColourMenu).click().perform();
        sleep(2);
    }


    public void clickModalButtonOrangeType() {
        print("clickModalButtonPufferType");
        WebElement modalContainer = driver.findElement(By.xpath("//div[@id = 'theme-modal-container']"));
        WebElement modalOrangeColourType = modalContainer.findElement(By.xpath("//span[text() = 'Light orange']"));
        Actions action = new Actions(driver);
        action.moveToElement(modalOrangeColourType).click().perform();
        sleep(2);
    }

    public void clickItemJacketButton(){
        print("clickItemJacketButton");
        sleep(2);
        waitForElement(itemJacketButton);
        itemJacketButton.click();
    }
}
