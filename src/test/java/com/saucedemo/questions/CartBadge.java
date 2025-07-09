package com.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.questions.Text;

public class CartBadge implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(".shopping_cart_badge").answeredBy(actor);
    }

    public static CartBadge value() { return new CartBadge(); }
}
