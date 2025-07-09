package com.saucedemo.utils;

public class Credentials {
    public static String username() {
        return System.getenv().getOrDefault("SAUCE_USERNAME","standard_user");
    }
    public static String password() {
        return System.getenv().getOrDefault("SAUCE_PASSWORD","secret_sauce");
    }
}
