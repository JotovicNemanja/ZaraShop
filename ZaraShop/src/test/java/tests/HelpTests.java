package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HelpPage;
import pages.HomePage;
import pages.Strings;

public class HelpTests extends BaseTest {

    /**
     * Test checks that search help functionality
     *
     * Steps:
     * 1. Click helpButton
     * 2. Enter question in question search field
     * 3. Hover and Click question option"
     *
     * Expected:
     * 1. Verify that user is navigated on HelpPage
     * 3. Verify that question title text corresponds to the expected title
     */
    @Test
    public void testSearchHelp(){
        print("testSearchHelp");

        ChromeDriver driver = openChromeDriver();

        try {
            print("1. Click helpButton");
            HomePage homePage = new HomePage(driver);
            homePage.clicHelpButton();

            print("1. Verify that user is navigated on HelpPage");
            String actualUrl = driver.getCurrentUrl();
            assert actualUrl.equals(Strings.HELP_PAGE_URL) : "Wrong page. Expected: " + Strings.HELP_PAGE_URL + " Actual: " + actualUrl;

            print("2. Enter question in question search field");
            HelpPage helpPage = new HelpPage(driver);
            helpPage.enterQuestionInQueryField(Strings.HELP_QUESTION_WHY);

            print("3. Hover and Click question option");
            helpPage.hoverAndClickFirst();

            print("3. Verify that question title text corresponds to the expected title ");
            assert helpPage.getTextOfQuestionTitle().equals(Strings.GET_TEXT_QUESTION_TITLE) : "Wrong title. Expected: " + Strings.GET_TEXT_QUESTION_TITLE;

        }finally {
            driver.quit();
        }
    }

    /**
     * Test checks other way to choose help question options
     *
     * Steps:
     * 1. Click helpButton
     * 2. Scroll to EXCHANGES, RETURNS AND REFUNDS
     * 3. Click howToExchangQuestionOption
     *
     * Expected:
     * 1. Verify that user is navigated on HelpPage
     * 3. Verify that user navigated to expected page
     */
    @Test
    public void testChooseHelpQuestionOptions (){
        print("testChooseHelpQuestionOptions");

        ChromeDriver driver = openChromeDriver();
        try {
            print("1. Click helpButton");
            HomePage homePage = new HomePage(driver);
            homePage.clicHelpButton();

            print("1. Verify that user is navigated on HelpPage");
            String actualUrl = driver.getCurrentUrl();
            assert actualUrl.equals(Strings.HELP_PAGE_URL) : "Wrong page. Expected: " + Strings.HELP_PAGE_URL + " Actual: " + actualUrl;


            print("2. Scroll to EXCHANGES, RETURNS AND REFUNDS");
            HelpPage helpPage = new HelpPage(driver);
            helpPage.scrollToExchangesReturnsAndRefunds();

            print("3. Click howToExchangQuestionOption");
            helpPage.clickHowToExchangQuestionOption();

            print("3. Verify that user navigated to expected page");
            String actualUrl1 = driver.getCurrentUrl();
            assert actualUrl1.equals(Strings.HOW_TO_EXCHANGE_PAGE_URL) : "Wrong page. Expected: " + Strings.HOW_TO_EXCHANGE_PAGE_URL + " Actual: "+ actualUrl1;

        }finally {
            driver.quit();
        }
    }


}
