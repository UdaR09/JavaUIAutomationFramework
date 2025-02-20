package com.opencart.pageobjects;

import com.opencart.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    private WebElement firstName;

    @FindBy(id = "input-lastname")
    private WebElement lastName;

    @FindBy(id = "input-email")
    private WebElement email;

    @FindBy(id = "input-password")
    private WebElement password;

    @FindBy(css = "input[value='1'][name='agree']")
    private WebElement privacyPolicy;

    @FindBy(css = "button[type='submit']")
    private WebElement continueButton;

    public void completeTheRegisterForm(String firstName, String lastName, String email, String password) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        System.out.println("Completed the register form with:\n" + email + "\n" + password);
    }

    public void enablePrivacyPolicy() {
        ScrollManager.ScrollToElement(privacyPolicy);
        privacyPolicy.click();
        System.out.println("Enabled Privacy Policy");
    }

    public void clickOnContinueButton() {
        ScrollManager.ScrollToElement(continueButton);
        continueButton.click();
        System.out.println("The continue button is clicked");
    }
}
