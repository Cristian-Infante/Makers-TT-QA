package com.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CartBadge implements Question<String> {

    private static final Target BADGE =
            Target.the("cart badge").locatedBy(".shopping_cart_badge");

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(BADGE, isVisible()).forNoMoreThan(5).seconds()
        );
        return Text.of(BADGE).answeredBy(actor);
    }

    public static CartBadge value(){ return new CartBadge(); }
}

