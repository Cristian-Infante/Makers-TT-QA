package com.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ConfirmationMessage implements Question<String> {
    @Override public String answeredBy(Actor actor) {
        return Text.of(".complete-header").answeredBy(actor);
    }
    public static ConfirmationMessage displayed(){ return new ConfirmationMessage(); }
}
