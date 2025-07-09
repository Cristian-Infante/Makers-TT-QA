package com.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.playwright.interactions.Click;
import net.serenitybdd.screenplay.playwright.interactions.Enter;

public class Checkout implements Task {

    private final String first;
    private final String last;
    private final String zip;

    public Checkout(String first, String last, String zip) {
        this.first = first;
        this.last = last;
        this.zip = zip;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on("#checkout"),
                Enter.theValue(first).into("#first-name"),
                Enter.theValue(last).into("#last-name"),
                Enter.theValue(zip).into("#postal-code"),
                Click.on("#continue"),
                Click.on("#finish")
        );
    }

    public static Checkout withData(String f, String l, String z) {
        return Tasks.instrumented(Checkout.class, f, l, z);
    }
}
