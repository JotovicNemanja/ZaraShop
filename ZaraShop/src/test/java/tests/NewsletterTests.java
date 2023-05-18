package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HelpPage;
import pages.HomePage;
import pages.NewsletterPage;
import pages.Strings;

public class NewsletterTests extends BaseTest{

    /**
     * Join newsletter
     *
     * Steps:
     * 1. Click helpButton
     * 2. Scroll and click newsletterButton
     * 3. Enter email in newsletter email field
     * 4. Accept cookies
     * 5. Click menSectionsCheckboxField
     * 6 Click saveButton
     *
     *
     * Expected:
     * 1. Verify that user is navigated on HelpPage
     * 2. Verify that user is navigated on NewsletterPage
     * 6. Verify that modal shown and has accept button
     */
    @Test
    public void joinNewsletter(){
        print("joinNewsletter");

        ChromeDriver driver = openChromeDriver();

        try {
            print("1. Click helpButton");
            HomePage homePage = new HomePage(driver);
            homePage.clicHelpButton();

            print("1. Verify that user is navigated on HelpPage");
            String actualUrl = driver.getCurrentUrl();
            assert actualUrl.equals(Strings.HELP_PAGE_URL) : "Wrong page. Expected: " + Strings.HELP_PAGE_URL + " Actual: " + actualUrl;

            print("2. Scroll and click newsletterButton");
            HelpPage helpPage = new HelpPage(driver);
            helpPage.clickNewsletterButton();

            print("2. Verify that user is navigated on NewsletterPage");
            String actualUrl1 = driver.getCurrentUrl();
            assert actualUrl1.equals(Strings.NEWSLETTER_PAGE_URL) : "Wrong page. Expected: " + Strings.NEWSLETTER_PAGE_URL + " Actual: " + actualUrl1;

            print("3. Enter email in newsletter email field");
            NewsletterPage newsletterPage = new NewsletterPage(driver);
            newsletterPage.enterEmailForNewsletter(Strings.NEWSLETTER_EMAIL);

            print("4. Accept cookies");
            newsletterPage.clickCookiesCheckboxField();

            print("5. Click menSectionsCheckboxField");
            newsletterPage.clickMenSectionsCheckboxField();

            print("6 Click saveButton");
            newsletterPage.clickSaveButton();

            print("6. Verify that modal shown and has accept button");
//            assert newsletterPage.getTextModalTitle().equals(Strings.GET_TEXT_MODAL_NEWSLETTER_TEXT) : "Wrong text. Expected: " + Strings.GET_TEXT_MODAL_NEWSLETTER_TEXT;


        }finally {
//            driver.quit();
        }

    }

    /**
     * Test unsubscribes user from newsletter
     *
     * 1. Click helpButton
     * 2. Scroll and click newsletterButton
     * 3. Enter email in newsletter email field
     * 4. Click unsubscribeButton
     *
     *
     * Expected:
     * 1. Verify that user is navigated on HelpPage
     * 2. Verify that user is navigated on NewsletterPage
     * 4. Verify that modal shown and has accept button
     */
    @Test
    public void testUnsubscibeNewsletter(){
        print("testUnsubscibeNewsletter");

        ChromeDriver driver = openChromeDriver();

        try {
            print("1. Click helpButton");
            HomePage homePage = new HomePage(driver);
            homePage.clicHelpButton();

            print("1. Verify that user is navigated on HelpPage");
            String actualUrl = driver.getCurrentUrl();
            assert actualUrl.equals(Strings.HELP_PAGE_URL) : "Wrong page. Expected: " + Strings.HELP_PAGE_URL + " Actual: " + actualUrl;

            print("2. Scroll and click newsletterButton");
            HelpPage helpPage = new HelpPage(driver);
            helpPage.clickNewsletterButton();

            print("2. Verify that user is navigated on NewsletterPage");
            String actualUrl1 = driver.getCurrentUrl();
            assert actualUrl1.equals(Strings.NEWSLETTER_PAGE_URL) : "Wrong page. Expected: " + Strings.NEWSLETTER_PAGE_URL + " Actual: " + actualUrl1;

            print("3. Enter email in newsletter email field");
            NewsletterPage newsletterPage = new NewsletterPage(driver);
            newsletterPage.enterEmailForNewsletter(Strings.NEWSLETTER_EMAIL);

            print("4. Click unsubscribeButton");
            newsletterPage.clickUnsubscribeButton();


        }finally {
//            driver.quit();
        }
        }


}
