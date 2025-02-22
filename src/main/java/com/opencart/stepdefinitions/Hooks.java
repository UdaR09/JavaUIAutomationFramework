package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import io.cucumber.java.*;

public class Hooks {
    @BeforeAll
    public static void beforeAll() {
        System.out.println("Executing of tests suite starting...");
    }

    @Before
    public void before() {
        System.out.println("Test started");
    }

    @After
    public void after() {
        System.out.println("Test finished");
        DriverManager.getInstance().quitTheDriver();
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Tests suite finished");
    }
}
