package com.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;

public class AddItemToCart implements Task {

    private static final String ADD_TO_CART_TEMPLATE = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button";

    private final String productName;

    public AddItemToCart(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Target addToCartButton = Target.the(
                        String.format("add-to-cart button for product %s", productName))
                .locatedBy(String.format(ADD_TO_CART_TEMPLATE, productName));

        actor.attemptsTo(
                Click.on(addToCartButton)
        );
    }

    public static AddItemToCart called(String productName) {
        return Tasks.instrumented(AddItemToCart.class, productName);
    }
}
