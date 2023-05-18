package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class SearchTests extends BaseTest{

    /**
     * Search Pullover item
     *
     * Steps:
     * 1. Click searchButton
     * 2. Enter item name in search field
     *
     *
     * Expected:
     * 1. Verify that user is navigated on LoginPage
     * 2. Verifay that number of results is greater than 0
     */

    @Test
    public void testSearchItem (){
        print("testSearchItem");

        ChromeDriver driver = openChromeDriver();

        try{
            print("1. Click searchButton");
            HomePage homePage = new HomePage(driver);
            homePage.clickSearchButton();

            print("1. Verify that user is navigated on SearchPage");
            SearchPage searchPage = new SearchPage(driver);
            String actualUrl = driver.getCurrentUrl();
            assert searchPage.verifyURL(Strings.SEARCH_PAGE_URL) : "Wrong page. Expected: " + Strings.SEARCH_PAGE_URL + "Actual: " + actualUrl;


            print("2. Enter item name in search field");
            searchPage.enterItemName(Strings.ITEM_NAME_PULLOVER);

            print("2. Verify that number of results is greater than 0");
            String pulloverItemsSearch = searchPage.getTextFromNumberOfResults();
            assert !Strings.NUMBER_OF_ITEMS_0.equals(searchPage.getTextFromNumberOfResults()) : "Wrong number. Expected: 326. Actual: " + pulloverItemsSearch;

        }finally {
            driver.quit();
        }
    }

    /**
     * Test checks functionality of clear recent search button
     *
     * Steps:
     * 1. Click searchButton
     * 2. Enter item name in search field
     * 3. Click firstItem
     * 4. Click SearchButtonFromItemPage
     * 5. Click clearRecentButton
     *
     * Expected:
     * 1. Verify that user is navigated on LoginPage
     * 5. Verify that element present
     */
    @Test
    public void testClearRecentSearch (){
        print("clearRecentSearch");

//        ChromeDriver driver = openChromeDriver();

        ChromeDriver driver = new ChromeDriver();
        try {
            print("1. Click searchButton");
            HomePage homePage = new HomePage(driver);
            homePage.clickSearchButton();

            print("1. Verify that user is navigated on SearchPage");
            SearchPage searchPage = new SearchPage(driver);
            String actualUrl = driver.getCurrentUrl();
            assert searchPage.verifyURL(Strings.SEARCH_PAGE_URL) : "Wrong page. Expected: " + Strings.SEARCH_PAGE_URL + "Actual: " + actualUrl;

            print("2. Enter item name in search field");
            searchPage.enterItemName(Strings.ITEM_NAME_TSHIRT);


            print("3. Click firstItem");
            searchPage.clickFirstItem();


            print("4. Click SearchButtonFromItemPage");
            ItemPage itemPage = new ItemPage(driver);
            itemPage.clickSearchButtonFromItemPage();

            print("5. Click clearRecentButton");
            searchPage.clickClearRecentButton();

//            print("5. Verify that element present");
//            assert isElementPresent(itemsSearchRecentText);

        }finally {
            driver.quit();
        }
    }


    /**
     * Test checks that some item is availability in some store
     *
     * Steps:
     * 1. Click searchButton
     * 2. Enter item name in search field
     * 3. Enter item name in search field
     * 4. Click chunkyTrainersBlackMenItem
     * 5. Click checkInStoreAvailability
     * 6. Click sizeNumberModalButton
     * 7. Click modalCheckAvailability
     * 8. Enter store address
     * 9. Click modalSearchStoreButton
     *
     * Expected:
     * 1. Verify that user is navigated on SearchPage
     * 4. Verify that user navigated on ItemPage
     * 9. Verify that text corresponds to the expected text
     */
    @Test
    public void testCheckInStoreAvailability() {
        print("testCheckInStoreAvailability");

        ChromeDriver driver = openChromeDriver();

        try{
            print("1. Click searchButton");
            HomePage homePage = new HomePage(driver);
            homePage.clickSearchButton();

            print("1. Verify that user is navigated on SearchPage");
            SearchPage searchPage = new SearchPage(driver);
            String actualUrl = driver.getCurrentUrl();
            assert searchPage.verifyURL(Strings.SEARCH_PAGE_URL) : "Wrong page. Expected: " + Strings.SEARCH_PAGE_URL + "Actual: " + actualUrl;

            print("2. Click men category");
            searchPage.clickMenCategoryButton();

            print("3. Enter item name in search field");
            searchPage.enterItemName(Strings.ITEM_NAME_CHUNKY_TRAINERS);

            print("4. Click chunkyTrainersBlackMenItem");
            searchPage.clickChunkyTrainersBlackMenItem();

            print("4. Verify that user navigated on ItemPage");
            String actualUrl1 = driver.getCurrentUrl();
            assert actualUrl1.equals(Strings.ITEM_CHUNKY_TRAINERS_PAGE_URL) : "Wrong page. Expected: " + Strings.ITEM_CHUNKY_TRAINERS_PAGE_URL + "Actual: " + actualUrl1;


            print("5. Click checkInStoreAvailability");
            ItemPage itemPage = new ItemPage(driver);
            itemPage.clickCheckInStoreAvailability();

            print("6. Click sizeNumberModalButton");
            itemPage.clickSizeNumberModalButton();

            print("7. Click modalCheckAvailability");
            itemPage.clickCheckAvailabilityButton();

            print("8. Enter store address");
            itemPage.enterAdressOfStore(Strings.STORE_ADDRESS_BEOGRAD);

            print("9. Click modalSearchStoreButton");
            itemPage.clickSearchStoreButton();

            print("9. Verify that text corresponds to the expected text");
            String expectedValue = "KNEZ MIHAILOVA, 11-15";
            assert expectedValue.equals(itemPage.getTextNearStore()) : "Element is NOT present.";


    }finally {
//            driver.quit();
        }
        }





}




































