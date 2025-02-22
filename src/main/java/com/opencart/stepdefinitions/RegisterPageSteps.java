package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.managers.FakeDataManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @And("The register form is populated with data")
    public void theRegisterFormIsPopulatedWithData() {
        String email = FakeDataManager.getRandomEmail();
        String password = FakeDataManager.getRandomPassword();
        registerPage.completeTheRegisterForm(FakeDataManager.getRandomName(), FakeDataManager.getRandomSurname(), email, password);

    }

    @And("The privacy policy is enabled")
    public void thePrivacyPolicyIsEnabled() {
        registerPage.enablePrivacyPolicy();
    }

    @When("Continue button is clicked")
    public void continueButtonIsClicked() {
        registerPage.clickOnContinueButton();
    }
}
