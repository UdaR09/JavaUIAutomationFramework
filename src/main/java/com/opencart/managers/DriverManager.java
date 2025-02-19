package com.opencart.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
    private static DriverManager instance;
    private WebDriver driver;
    private static final String WEB_DRIVER_TYPE = "Chrome";

    private DriverManager(){
        switch(WEB_DRIVER_TYPE.toUpperCase()) {
            case "CHROME":
                driver = new ChromeDriver();
                System.out.println("Chrome driver loaded");
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                System.out.println("Firefox driver loaded");
                break;
            case "EDGE":
                driver = new EdgeDriver();
                System.out.println("Edge driver loaded");
                break;
            case "SAFARI":
                driver = new SafariDriver();
                System.out.println("Safari driver loaded");
                break;
            default:
                System.out.println("Invalid Driver Type");
        }
    }
    public static DriverManager getInstance(){
        if(instance == null){
            instance = new DriverManager();
        }
            return instance;
    }

    public WebDriver getDriver(){
        return driver;
    }
}
