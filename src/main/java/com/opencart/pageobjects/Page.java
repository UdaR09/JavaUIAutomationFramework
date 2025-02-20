package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@class='fa-solid fa-user']")
    protected WebElement userDropDownIcon;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    protected WebElement registerButton;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    protected WebElement loginButton;

    public void navigateToRegisterPage() {
        userDropDownIcon.click();
        registerButton.click();
        System.out.println("Navigated to Register option from Header");
    }

    public void navigateToLoginPage() {
        userDropDownIcon.click();
        loginButton.click();
        System.out.println("Navigated to Login option from Header");
    }
}
