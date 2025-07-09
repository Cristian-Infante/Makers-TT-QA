package com.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.playwright.interactions.Click;

public class AddItemToCart implements Task {

    private final String productName;

    public AddItemToCart(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String locator = String.format(
                "//div[text()='%s']/ancestor::div[@class='inventory_item']//button",
                productName
        );

        actor.attemptsTo(
                Click.on(locator)
        );
    }

    public static AddItemToCart called(String productName) {
        return Tasks.instrumented(AddItemToCart.class, productName);
    }
}
