package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.Strings;

public class LoginAndRegistrationTests extends BaseTest{


    /**
     * Complete user registration
     * Steps:
     *  1. Click loginButton on HomePage
     *  2. Click registerButton on LoginPage
     *  3. Enter Email
     *  4. Enter password
     *  5. Enter password repeat
     *  6. Enter name
     *  7. Enter surname
     *  8. Click privacyAndCookiesPolicyCheckbox
     *  9. Click createAccountButton
     *
     * Expected:
     *  1. Verify that user is navigated on LoginPage
     *  2. Verify that user is navigated on RegisterPage
     *  9. Verify that user is navigated on HomePage
     */
    @Test
    public void testRegistrationUser() {
        print("testRegistration");

        ChromeDriver driver = openChromeDriver();

        try {
            print("1. Click loginButton on HomePage");
            HomePage homePage = new HomePage(driver);
            homePage.clickLoginButton();

            print("1. Verify that user is navigated on LoginPage");
            LoginPage loginPage = new LoginPage(driver);
            assert loginPage.verifyURL(Strings.LOGIN_PAGE_URL) : "Wrong page";


            print("2. Click registerButton on LoginPage");
            loginPage.clickRegisterButton();

            print("1. Verify that user is navigated on RegisterPage");
            RegisterPage registerPage = new RegisterPage(driver);
            assert registerPage.verifyURL(Strings.REGISTER_PAGE_URL) : "Wrong page";

            print("3. Enter Email");
            registerPage.enterEmail(Strings.USER_EMAIL);

            print("4. Enter password");
            registerPage.enterPassword(Strings.USER_PASSWORD);

            print("5. Enter password repeat");
            registerPage.enterPasswordRepeat(Strings.USER_PASSWORD_REPEAT);

            print("6. Enter name");
            registerPage.enterName(Strings.USER_NAME);

            print("7. Enter surname");
            registerPage.enterSurname(Strings.USER_SURNAME);


            print("9. Click privacyAndCookiesPolicyCheckbox");
            registerPage.clickPrivacyAndCookiesPolicyCheckbox();

            print("10. Click createAccountButton");
            registerPage.clickCreateAccountButton();

//            print("10. Verify that user is navigated on HomePage");
//            String actualUrl = driver.getCurrentUrl();
//            assert loginPage.verifyURL(Strings.LOGIN_PAGE_URL) : "Wrong page. Expected:" + Strings.LOGIN_PAGE_URL + "Actual: " + actualUrl;




        } finally {
            driver.quit();

        }
    }

    /**
     * Login with valid credentials
     *
     * Steps:
     * 1. Click loginButton on HomePage
     * 2. Enter valid Email
     * 3. Enter valid password
     * 4. Click logInButton
     *
     * Expected:
     * 1. Verify that user is navigated on LoginPage
     * 4. Verify that user is navigated on HomePage
     *
     */

    @Test
    public void testLogginWithValidCreds() {
        print("testLoginUser");

        ChromeDriver driver = openChromeDriver();

        try{
            print("1. Click loginButton on HomePage");
            HomePage homePage = new HomePage(driver);
            homePage.clickLoginButton();

            print("1. Verify that user is navigated on LoginPage");
            LoginPage loginPage = new LoginPage(driver);
            String actualUrl = driver.getCurrentUrl();
            assert loginPage.verifyURL(Strings.LOGIN_PAGE_URL) : "Wrong page. Expected: " + Strings.LOGIN_PAGE_URL + " Actual: " + actualUrl;


            print("2. Enter valid Email");
            loginPage.enterLoginEmail(Strings.USER_VALID_EMAIL_LOGIN);

            print("3. Enter valid password");
            loginPage.enterLoginPassword(Strings.USER_VALID_PASSWORD_LOGIN);

            print("4. click logInButton");
            loginPage.clickLogInButton();


//            print("4. Verify that user is navigated on HomePage");
//            String actualUrl1 = driver.getCurrentUrl();
//            assert homePage.verifyURL(Strings.HOME_PAGE_URL) : "Wrong page. Expected: " + Strings.HOME_PAGE_URL + " Actual: " + actualUrl1;


        }finally {
            driver.quit();
        }


    }

}
