package com.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginErrorMessage implements Question<String> {

    private static final Target ERROR_CONTAINER =
            Target.the("login error container")
                    .locatedBy(".error-message-container.error");

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(ERROR_CONTAINER, isVisible())
                        .forNoMoreThan(5).seconds()
        );
        return Text.of(ERROR_CONTAINER).answeredBy(actor);
    }

    public static LoginErrorMessage displayed() {
        return new LoginErrorMessage();
    }
}
