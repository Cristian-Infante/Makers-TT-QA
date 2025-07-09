package com.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class AddItemToCart implements Task {

    private final String productName;

    public AddItemToCart(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target addButton = Target.the("add to cart button")
            .locatedBy("//div[text()='{0}']/ancestor::div[@class='inventory_item']//button")
            .of(productName);

        actor.attemptsTo(
            WaitUntil.the(addButton, isClickable()).forNoMoreThan(5).seconds(),
            Click.on(addButton)
        );
    }

    public static AddItemToCart called(String productName) {
        return Tasks.instrumented(AddItemToCart.class, productName);
    }
}
