package com.opencart.managers;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitManager {
    private static final Logger logger = LogManager.getLogger(ExplicitWaitManager.class);
    private static int explicitWaitTimeout = Integer.parseInt(ConfigReaderManager.getProperty("explicitWaitTimeout"));
    private static WebDriverWait waitObject = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(explicitWaitTimeout));

    public static void waitTillElementIsVisivle(WebElement element){
        logger.log(Level.DEBUG,"Waiting for element visible..." + element.getAccessibleName());
        waitObject.until(ExpectedConditions.visibilityOf(element));
        logger.log(Level.DEBUG, "Element visible." + element.getAccessibleName());
    }


    public static void waitTillElementIsClickable(WebElement element){
        logger.log(Level.DEBUG,"Waiting for element clickable..." + element.getAccessibleName());
        waitObject.until(ExpectedConditions.elementToBeClickable(element));
        logger.log(Level.DEBUG, "Element clickable." + element.getAccessibleName());
    }
}
