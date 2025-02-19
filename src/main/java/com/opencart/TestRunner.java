package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.FakeDataManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.google.com/");
        System.out.println("Current url is: " + driver.getCurrentUrl());
        System.out.println("Current page title is: " + driver.getTitle());

        String firstWindowName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://tekwillacademy-opencart.online/");
        System.out.println("Current url is: " + driver.getCurrentUrl());
        System.out.println("Current page title is: " + driver.getTitle());

        WebElement myAccountDropDown = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        myAccountDropDown.click();

        WebElement myAccountRegister = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        myAccountRegister.click();

        System.out.println("Current url is: " + driver.getCurrentUrl());
        System.out.println("Current page title is: " + driver.getTitle());

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys(FakeDataManager.getRandomName());

        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys(FakeDataManager.getRandomSurname());

        WebElement emailInput = driver.findElement(By.id("input-email"));
        String email = FakeDataManager.getRandomEmail();
        System.out.println("Current email is: " + email);
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.id("input-password"));
        String password = FakeDataManager.getRandomPassword();
        System.out.println("Current password is: " + password);
        passwordInput.sendKeys(password);

        WebElement acceptPrivacyPolicy = driver.findElement(By.cssSelector("input[value='1'][name='agree']"));
        acceptPrivacyPolicy.click();

        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();

        System.out.println("Current url is: " + driver.getCurrentUrl());
        System.out.println("Current page title is: " + driver.getTitle());

        Thread.sleep(3000);

        driver.close();
        driver.switchTo().window(firstWindowName);

        System.out.println("Current url is: " + driver.getCurrentUrl());
        System.out.println("Current page title is: " + driver.getTitle());

//        driver.get("https://tekwillacademy-opencart.online/");
//        System.out.println("Current url is: " + driver.getCurrentUrl());
//        System.out.println("Current page title is: " + driver.getTitle());
//
//       myAccountDropDown.click();
//
//        WebElement myAccountLogIn = driver.findElement(By.xpath("//a[normalize-space()='Login']"));
//        myAccountLogIn.click();
//
//        emailInput.sendKeys(email);
//        passwordInput.sendKeys(password);
//        continueButton.click();
//
//        System.out.println("Current url is: " + driver.getCurrentUrl());
//        System.out.println("Current page title is: " + driver.getTitle());
//
//        Thread.sleep(3000);

        driver.quit();
    }
}