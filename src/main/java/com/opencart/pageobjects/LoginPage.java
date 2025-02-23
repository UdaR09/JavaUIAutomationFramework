package com.opencart.pageobjects;

import com.opencart.managers.ExplicitWaitManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-email")
    public WebElement email;

    @FindBy(id = "input-password")
    public WebElement password;

    @FindBy(xpath = "//*[@id=\"form-login\"]/div[3]/button")
    public WebElement loginButton;

    public void completeLoginForm(String email, String password) {
        ExplicitWaitManager.waitTillElementIsVisivle(this.email);
        this.email.sendKeys(email);
        ExplicitWaitManager.waitTillElementIsVisivle(this.password);
        this.password.sendKeys(password);
        System.out.println("Completed login form");
    }
}
