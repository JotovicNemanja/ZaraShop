package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    // Attribute ChromeDriver
    ChromeDriver driver;


    // Webelements

    @FindBy (xpath = "//a[@title= 'ZARA Serbia, Go to the Zara homepage']")
    WebElement mainZaraLogo;



    // Constructor

    public BasePage(){}
    public BasePage (ChromeDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    // Methods

    // element methods

    /**
     * Method navigates to the HomePage
     */
    public void goToHomePage() {
        print("goToHomePage");
        waitForElement(mainZaraLogo);
        scrollIntoView(mainZaraLogo);
        mainZaraLogo.click();
    }


    // helper methods

    /**
     * Method prints text on the console
     * @param s
     */
    public static void print (String s) {System.out.println(s);}


    /**
     * Method verefies is URL correct
     * @param expectedUrl
     * @return
     */
    public boolean verifyURL (String expectedUrl) {
        print("verifyURL ( " + expectedUrl + " )");
        String curentURL = driver.getCurrentUrl();
        return curentURL.equals(expectedUrl);

    }


    /**
     * Method stops program for required time
     * @param seconds
     */
    public void sleep (int seconds) {
        try{
            Thread.sleep(seconds*1000);
        }catch (Exception e){
            print(e.getMessage());
        }

    }


    /**
     * Method verifies is element present on the page
     * @param element
     * @return
     */
    public static boolean isElementPresent (WebElement element) {
        try{
            print("isElementPresent");
            element.isDisplayed();
            return true;
        }catch (NoSuchElementException | StaleElementReferenceException e){
            return false;
        }


    }

    public boolean isDisplayed(WebElement elements){
        if (elements.isDisplayed()){
            return true;
        }else{
            return false;
        }
    }


    /**
     * Method scroll to requierd visible element
     * @param element
     */
    public void scrollIntoView (WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    /**
     * Method wait to element be visible on the page
     * @param element
     */
    public void waitForElement (WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
