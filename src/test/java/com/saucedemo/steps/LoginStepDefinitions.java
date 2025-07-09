package com.saucedemo.steps;

import com.saucedemo.models.User;
import com.saucedemo.tasks.Login;
import com.saucedemo.questions.LoginErrorMessage;
import com.saucedemo.utils.Constants;
import com.saucedemo.utils.Credentials;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class LoginStepDefinitions {
    @Given("the user opens the application")
    public void the_user_opens_the_application() {
        theActorInTheSpotlight()
            .wasAbleTo(Open.url(Constants.BASE_URL));
    }

    @When("the user logs in with valid credentials")
    public void the_user_logs_in_with_valid_credentials() {
        theActorInTheSpotlight()
            .attemptsTo(Login.with(new User(Credentials.username(), Credentials.password())));
    }

    @When("the user attempts to log in with invalid credentials")
    public void the_user_attempts_to_log_in_with_invalid_credentials() {
        theActorInTheSpotlight()
            .attemptsTo(Login.with(new User("invalid_user","invalid_pass")));
    }

    @Then("the inventory should be visible")
    public void the_inventory_should_be_visible() {
        theActorInTheSpotlight()
            .should(seeThat(
                actor -> BrowseTheWeb.as(actor)
                    .getDriver()
                    .getCurrentUrl(),
                containsString("/inventory.html")
            ));
    }

    @Then("the error message {string} should be displayed")
    public void the_error_message_should_be_displayed(String message) {
        theActorInTheSpotlight()
            .should(seeThat(
                LoginErrorMessage.displayed(),
                containsString(message)
            ));
    }
}
