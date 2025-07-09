package com.saucedemo.steps;

import com.saucedemo.questions.CartBadge;
import com.saucedemo.questions.ConfirmationMessage;
import com.saucedemo.tasks.*;
import io.cucumber.java.en.*;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class PurchaseStepDefinitions {

    @When("the user adds {string} and {string} to the cart")
    public void add_two_items(String first, String second) {
        theActorInTheSpotlight()
            .attemptsTo(
                AddItemToCart.called(first),
                AddItemToCart.called(second)
            );
    }

    @Then("the cart badge should show {string}")
    public void cart_badge_should_show(String qty) {
        theActorInTheSpotlight()
            .should(seeThat(CartBadge.value(), containsString(qty)));
    }

    @Given("the cart contains {string}")
    public void ensure_cart_contains(String item) {
        theActorInTheSpotlight()
            .attemptsTo(
                AddItemToCart.called(item),
                OpenCart.view()
            );
    }

    @When("the user checks out providing first name {string}, last name {string} and zip {string}")
    public void user_checks_out(String first, String last, String zip) {
        theActorInTheSpotlight()
            .attemptsTo(Checkout.withData(first, last, zip));
    }

    @Then("the confirmation page should display {string}")
    public void confirmation_page_should_display(String expected) {
        theActorInTheSpotlight()
            .should(seeThat(
                ConfirmationMessage.displayed(),
                containsString(expected)
            ));
    }
}
