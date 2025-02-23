package com.opencart.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
    private static DriverManager instance;
    private WebDriver driver;
    private static final String WEB_DRIVER_TYPE = ConfigReaderManager.getProperty("browserType");

    private DriverManager(){
        switch(WEB_DRIVER_TYPE.toUpperCase()) {
            case "CHROME":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--incognito");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                System.out.println("Chrome driver loaded");
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                System.out.println("Firefox driver loaded");
                break;
            case "EDGE":
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                System.out.println("Edge driver loaded");
                break;
            case "SAFARI":
                driver = new SafariDriver();
                driver.manage().window().maximize();
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

    public void quitTheDriver(){
        driver.quit();
        driver = null;
        instance = null;
        System.out.println("Driver quitted");
    }
}
