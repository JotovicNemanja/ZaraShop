package tests;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    ChromeDriver driver;

    /**
     * Method opens customized browser
     * @return
     */
    public ChromeDriver openChromeDriver() {

        print("Opening Chrome Driver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--start-maximized"});
        options.addArguments(new String[]{"--ignore-certificate-errors"});
        options.addArguments(new String[]{"--disable-popup-blocking"});
        options.addArguments(new String[]{"--incognito"});
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--disable-third-party-cookies");
        ChromeDriver driver = new ChromeDriver(options);
        // ovo dole sluzi za setovanje dimenzija
//        driver.manage().window().setSize(new Dimension(600,768));
        return driver;
    }

    /**
     * Method print text on the console
     *
     * @param s
     */
    public static void print(String s) {
        System.out.println(s);
    }

    /**
     * Method stops program for required time
     *
     * @param seconds
     */
    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            print(e.getMessage());
        }


    }

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


    public void waitForElement (WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }




}
