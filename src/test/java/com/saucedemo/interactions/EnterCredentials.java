package com.saucedemo.interactions;

import com.saucedemo.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.playwright.interactions.Enter;

public class EnterCredentials implements Interaction {

    private final User user;

    public EnterCredentials(User user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user.username()).into("#user-name"),
                Enter.theValue(user.password()).into("#password")
        );
    }

    public static EnterCredentials forUser(User user) {
        return Tasks.instrumented(EnterCredentials.class, user);
    }
}
