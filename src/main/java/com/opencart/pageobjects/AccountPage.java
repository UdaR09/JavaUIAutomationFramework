package com.opencart.pageobjects;

import com.opencart.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Page{
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    public WebElement logoutButton;

    public void clickLogoutButton() {
        ScrollManager.ScrollToElement(logoutButton);
        logoutButton.click();
        System.out.println("Logout button clicked");
    }
}
