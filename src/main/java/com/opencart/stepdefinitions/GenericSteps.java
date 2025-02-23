package com.opencart.stepdefinitions;

import com.opencart.managers.ConfigReaderManager;
import com.opencart.managers.DriverManager;
import com.opencart.managers.ExplicitWaitManager;
import com.opencart.managers.ScrollManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class GenericSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    private static final Logger logger = LogManager.getLogger(GenericSteps.class);

    @Then("the URL contains the following keyword {string}")
    public void theURLContainsTheFollowingKeyword(String keyword) throws InterruptedException {
        //Thread.sleep(1000);
        boolean containsKeyword = driver.getCurrentUrl().contains(keyword);
        Assertions.assertTrue(containsKeyword, "The keyword " + keyword + " was not found in the URL");
    }

    @Given("The {string} is accessed")
    public void theIsAccessed(String endpoint) {
        String fullLink =ConfigReaderManager.getProperty("baseUrl") + endpoint;
        driver.get(fullLink);
        logger.log(Level.WARN, "The URL is " + fullLink);
        System.out.println("The " + fullLink + " is accessed");
    }

    @And("a thread sleep of {int} milliseconds is executed")
    public void aThreadSleepOfMillisecondsIsExecuted(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the following list of error messages is displayed:")
    public void theFollowingListOfErrorMessagesIsDisplayed(List<String> listOfErrorMessages) {
        listOfErrorMessages.forEach(errorMessage -> {
            logger.log(Level.ERROR, errorMessage);
            boolean messagesDisplayed = driver.findElement(By.xpath(".//*[contains(text(),'" + errorMessage + "')]")).isDisplayed();
            Assertions.assertTrue(messagesDisplayed, "The following list of error messages is displayed");
        });
    }

    @When("the {string} from {string} is clicked")
    public void theFromIsClicked(String element, String page) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class classInstance = Class.forName("com.opencart.pageobjects."+page);
        Field webElemetField = classInstance.getDeclaredField(element);
        webElemetField.setAccessible(true);
        WebElement webElement = (WebElement) webElemetField.get(classInstance.getConstructor(WebDriver.class).newInstance(driver));
        ExplicitWaitManager.waitTillElementIsVisivle(webElement);
        ScrollManager.ScrollToElement(webElement);
        ExplicitWaitManager.waitTillElementIsClickable(webElement);
        webElement.click();
        logger.log(Level.INFO, "Clicked " + element + " in " + page);
    }
}
