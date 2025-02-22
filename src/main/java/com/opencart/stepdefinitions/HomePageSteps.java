package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);

    @Given("The home page is displayed")
    public void the_home_page_is_displayed() {
        driver.get("https://tekwillacademy-opencart.online/");
    }

    @And("Register Page is accessed from Home Page buttons")
    public void register_page_is_accessed_from_home_page_buttons() {
        homePage.navigateToRegisterPage();
    }


}
