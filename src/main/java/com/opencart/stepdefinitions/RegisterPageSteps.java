package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.managers.FakeDataManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Map;

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

    @When("The register form is populated as following:")
    public void theRegisterFormIsPopulatedAsFollowing(Map<String, String> userData) {
        String firstName = userData.get("firstName");
        if (firstName != null && firstName.equalsIgnoreCase("RANDOM")) {
            firstName = FakeDataManager.getRandomName();
        }
        String lastName = userData.get("lastName");
        if (lastName != null && lastName.equalsIgnoreCase("RANDOM")) {
            lastName = FakeDataManager.getRandomName();
        }
        String email = userData.get("email");
        if (email != null && email.equalsIgnoreCase("RANDOM")) {
            email = FakeDataManager.getRandomEmail();
        }
        String password = userData.get("password");
        if (password != null && password.equalsIgnoreCase("RANDOM")) {
            password = FakeDataManager.getRandomPassword();
        }
        registerPage.completeTheRegisterForm(firstName, lastName, email, password);
    }
}
