package com.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.questions.Text;

public class LoginErrorMessage implements Question<String> {

    private static final Target ERROR_CONTAINER =
            Target.the("login error container")
                    .locatedBy(".error-message-container.error");

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ERROR_CONTAINER).answeredBy(actor);
    }

    public static LoginErrorMessage displayed() { return new LoginErrorMessage(); }
}
