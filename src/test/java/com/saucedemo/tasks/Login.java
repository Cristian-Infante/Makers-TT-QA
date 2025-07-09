package com.saucedemo.tasks;

import com.saucedemo.interactions.EnterCredentials;
import com.saucedemo.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class Login implements Task {
    private final User user;
    public Login(User user) { this.user = user; }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            EnterCredentials.forUser(user),
            Click.on("#login-button")
        );
    }

    public static Login with(User user) { return Tasks.instrumented(Login.class, user); }
}
