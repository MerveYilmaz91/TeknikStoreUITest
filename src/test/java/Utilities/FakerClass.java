package Utilities;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerClass {

    private static final Faker faker = new Faker(new Locale("tr"));

    public static String firstName() {
        return faker.name().firstName() + " Test";
    }

    public static String lastName() {
        return faker.name().lastName() + " Test";
    }

    public static String fullName() {
        return faker.name().fullName() + " Test";
    }


    public static String randomEmail() {
        return "test" + faker.number().numberBetween(10000, 99999) + "@gmail.com";
    }

    public static String randomNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("min değeri max değerinden küçük olmalı.");
        }

        return String.valueOf(faker.number().numberBetween(min, max));
    }



    public static String phoneNumber() {
        return "0" + faker.number().numberBetween(212, 555) +
                faker.number().numberBetween(1000000, 9999999);
    }


    public static String fullAddress() {
        return faker.address().streetAddress() + " No:" +
                faker.number().numberBetween(1, 100) + " Daire:" +
                faker.number().numberBetween(1, 30);
    }
}