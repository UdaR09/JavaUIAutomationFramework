package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class GenericSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();

    @Then("the URL contains the following keyword {string}")
    public void theURLContainsTheFollowingKeyword(String keyword) throws InterruptedException {
        Thread.sleep(1000);
        boolean containsKeyword = driver.getCurrentUrl().contains(keyword);
        Assertions.assertTrue(containsKeyword, "The keyword " + keyword + " was not found in the URL");
    }

    @Given("The {string} is accessed")
    public void theIsAccessed(String link) {
        driver.get(link);
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
    public void theFollowingListOfErrorMessagesIsDisplayed(List<String> listOfErrorMessages) throws InterruptedException {
        Thread.sleep(500);
        listOfErrorMessages.forEach(errorMessage -> {
            boolean messagesDisplayed = driver.findElement(By.xpath(".//*[contains(text(),'" + errorMessage + "')]")).isDisplayed();
            Assertions.assertTrue(messagesDisplayed, "The following list of error messages is displayed");
        });
    }
}
