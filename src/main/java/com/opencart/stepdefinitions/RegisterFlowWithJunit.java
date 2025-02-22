package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.managers.FakeDataManager;
import com.opencart.pageobjects.AccountPage;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class RegisterFlowWithJunit {
    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before All");
    }

    @BeforeEach
    public void beforeEach() {
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online/");

        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();

        registerPage = new RegisterPage(driver);
    }

    @Test
    @DisplayName("User is redirected to Account page when registering is valid")
    public void registerFlowWithValidDataRedirectsTheUserToAccountPage() throws InterruptedException {
        String email = FakeDataManager.getRandomEmail();
        String password = FakeDataManager.getRandomPassword();

        registerPage.completeTheRegisterForm(FakeDataManager.getRandomName(), FakeDataManager.getRandomSurname(), email, password);
        registerPage.enablePrivacyPolicy();
        registerPage.clickOnContinueButton();

        Thread.sleep(2000);

        boolean urlContainSuccessKeyword = driver.getCurrentUrl().contains("success");
        Assertions.assertTrue(urlContainSuccessKeyword, "The URL of the page contains Success Keyword");

        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickLogoutButton();

        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.completeLoginForm(email, password);
        loginPage.clickLoginButton();

        Thread.sleep(2000);
    }

    @Test
    @DisplayName("The user remains on the register pagen when registeriag fault accepting terms and conditions")
    public void registerFlowWithValidDataRedirectsTheUserToRegisterPage() throws InterruptedException {
        String email = FakeDataManager.getRandomEmail();
        String password = FakeDataManager.getRandomPassword();

        registerPage.completeTheRegisterForm(FakeDataManager.getRandomName(), FakeDataManager.getRandomSurname(), email, password);
        registerPage.clickOnContinueButton();

        Thread.sleep(2000);

        boolean urlContainSuccessKeyword = driver.getCurrentUrl().contains("success");
        Assertions.assertFalse(urlContainSuccessKeyword, "The URL of the page contains success Keyword");
    }

    @Test
    @DisplayName("Navigate To Login page from register")
    public void registerFlowWithValidDataRedirectsTheUserToLoginPage() throws InterruptedException {
        registerPage.navigateToLoginPage();
        Assertions.assertTrue(driver.getCurrentUrl().contains("login"), "The URL of the page doesn't contains login");
    }
    @AfterEach
    public void afterEach() {
        DriverManager.getInstance().quitTheDriver();
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("This method is executed after all");
    }
}
