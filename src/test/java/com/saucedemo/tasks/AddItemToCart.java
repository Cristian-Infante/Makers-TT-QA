package com.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;

public class AddItemToCart implements Task {

    private static final String ADD_TO_CART_TEMPLATE = "[data-test='add-to-cart-%s']";
    private final String productName;

    public AddItemToCart(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // "Sauce Labs Backpack" → "sauce-labs-backpack"
        String slug = productName.toLowerCase()
                .replaceAll("[^a-z0-9]+", "-")
                .replaceAll("^-|-$", "");

        Target addToCartButton = Target.the(
                        String.format("add-to-cart button for %s", productName))
                .locatedBy(String.format(ADD_TO_CART_TEMPLATE, slug));

        actor.attemptsTo(
                Click.on(addToCartButton)
        );
    }

    public static AddItemToCart called(String productName) {
        return Tasks.instrumented(AddItemToCart.class, productName);
    }
}
