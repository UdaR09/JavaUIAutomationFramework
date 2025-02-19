package com.opencart.managers;

import com.github.javafaker.Faker;

public class FakeDataManager {
    private static Faker faker = new Faker();

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomName() {
        return faker.name().firstName();
    }

    public static String getRandomSurname() {
        return faker.name().lastName();
    }

    public static String getRandomPassword() {
        return faker.internet().password();
    }
}
