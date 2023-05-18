package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ItemPage;
import pages.SearchPage;
import pages.Strings;

public class FilterAndBuyTests extends BaseTest {

    /**
     * Search Jacket item using filters
     *
     * Steps:
     * 1. Click searchButton
     * 2. Enter item name in search field
     * 3. Click men category
     * 4. Click filtersButton
     * 5. Click modal characteristics menu
     * 6. Click modal button puffer type
     * 7. Click filtersButton
     * 8. Click modal colour menu
     * 9. Click modal orange type
     * 10. Click CORDUROY PUFFER JACKET item and user is navigated to item page
     * 11. Click sizeButton and choose size
     * 12. click addToBagButton and add item in shopping bag
     *
     * Expected:
     * 1. Verify that user is navigated on LoginPage
     * 10. Verify that user is navigated on ItemPage
     */
    @Test
    public void testFilterAndAddToCartItem(){
        print("testFilterAndBuyItem");

        ChromeDriver driver = openChromeDriver();

        try {
            print("1. Click searchButton");
            HomePage homePage = new HomePage(driver);
            homePage.clickSearchButton();

            print("1. Verify that user is navigated on SearchPage");
            SearchPage searchPage = new SearchPage(driver);
            String actualUrl = driver.getCurrentUrl();
            assert searchPage.verifyURL(Strings.SEARCH_PAGE_URL) : "Wrong page. Expected: " + Strings.SEARCH_PAGE_URL + "Actual: " + actualUrl;


            print("2. Enter item name in search field");
            searchPage.enterItemName(Strings.ITEM_NAME_JACKET);


            print("3. Click men category");
            searchPage.clickMenCategoryButton();

            print("4. Click filtersButton");
            searchPage.clickFiltersButton();

            print("5. Click modal characteristics menu");
            searchPage.clickModalButtonCharacteristicsMenu();

            print("6. Click modal button puffer type");
            searchPage.clickModalButtonPufferType();

            print("7. Click filtersButton");
            searchPage.clickFiltersButton();

            print("8. Click modal colour menu");
            searchPage.clickModalButtonColourMenu();

            print("9. Click modal orange type");
            searchPage.clickModalButtonOrangeType();

            print("10. Click CORDUROY PUFFER JACKET item and user is navigated to item page");
            searchPage.clickItemJacketButton();

            print("10. Verify that user is navigated on ItemPage");
            String actualUrl1 = driver.getCurrentUrl();
            assert actualUrl1.equals(Strings.ITEM_ORANGE_JACKET_PAGE_URL) : "Wrong page. Expected: " + Strings.ITEM_ORANGE_JACKET_PAGE_URL + " Actual: " + actualUrl1;

            print("11. Click sizeButton and choose size");
            ItemPage itemPage = new ItemPage(driver);
            itemPage.clickSizeButton();


            print("12. click addToBagButton and add item in shopping bag");
            itemPage.clickAddToBagButton();

//            print("9. Verify that cart badge number change to 1");
//            assert itemPage.getNumberCartBadge().equals(Strings.CART_BADGE_NUMBER_1) : "Wrong number of items in shopping cart. Expected: " + Strings.CART_BADGE_NUMBER_1;

        }finally {
            driver.quit();
        }
    }
}
