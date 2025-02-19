package com.opencart;

import com.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.google.com/");

        String firstTabName = driver.getWindowHandle();

        //Open new window and navigate to Diez.md
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.diez.md/");
        Thread.sleep(2000);
        driver.close();
        //Close ccurent Tab

        driver.switchTo().window(firstTabName);
        driver.get("https://www.stiri.md/");
        Thread.sleep(2000);
        driver.quit();
    }
}