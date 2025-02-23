package com.opencart.stepdefinitions;

import com.opencart.CucumberTestRunner;
import com.opencart.managers.DriverManager;
import io.cucumber.java.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {
    private static final Logger logger = LogManager.getLogger(Hooks.class);
    private static int counter = 0;
    @BeforeAll
    public static void beforeAll() {
        logger.log(Level.INFO, "Executing of tests suite started");
    }

    @Before
    public void before() {
        String logMessage = "Test " + ++counter + " started";
        logger.log(Level.INFO, logMessage);
    }

    @After
    public void after() {
        String logMessage = "Test " + counter + " finished";
        logger.log(Level.INFO, logMessage);
        DriverManager.getInstance().quitTheDriver();
    }

    @AfterAll
    public static void afterAll() {
        logger.log(Level.INFO, "Executing of tests suite finished");
    }
}
