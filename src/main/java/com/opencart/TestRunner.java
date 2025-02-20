package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.FakeDataManager;
import com.opencart.pageobjects.AccountPage;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online/");

        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(driver);

        String email = FakeDataManager.getRandomEmail();
        String password = FakeDataManager.getRandomPassword();

        registerPage.completeTheRegisterForm(FakeDataManager.getRandomName(), FakeDataManager.getRandomSurname(), email, password);
        registerPage.enablePrivacyPolicy();
        registerPage.clickOnContinueButton();

        Thread.sleep(2000);

        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickLogoutButton();

        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.completeLoginForm(email, password);
        loginPage.clickLoginButton();

        Thread.sleep(2000);
        driver.quit();
        System.out.println("Test completed, driver closed");
    }
}