package com.saucedemo.steps;

import com.saucedemo.models.User;
import com.saucedemo.questions.LoginErrorMessage;
import com.saucedemo.tasks.Login;
import com.saucedemo.utils.Constants;
import com.saucedemo.utils.Credentials;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;
import net.serenitybdd.screenplay.playwright.interactions.Open;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.containsString;

public class LoginStepDefinitions {

    @Given("the user opens the application")
    public void openApp() {
        theActorInTheSpotlight().wasAbleTo(Open.url(Constants.BASE_URL));
    }

    @When("the user logs in with valid credentials")
    public void loginValid() {
        theActorInTheSpotlight()
                .attemptsTo(Login.with(new User(Credentials.username(), Credentials.password())));
    }

    @When("the user attempts to log in with invalid credentials")
    public void loginInvalid() {
        theActorInTheSpotlight()
                .attemptsTo(Login.with(new User("invalid_user", "invalid_pass")));
    }

    @Then("the inventory should be visible")
    public void inventoryVisible() {
        theActorInTheSpotlight().should(seeThat(
                actor -> BrowseTheWebWithPlaywright.as(actor)
                        .getCurrentPage()
                        .url(),
                containsString("/inventory.html")
        ));
    }

    @Then("the error message {string} should be displayed")
    public void errorShown(String msg) {
        theActorInTheSpotlight()
                .should(seeThat(LoginErrorMessage.displayed(), containsString(msg)));
    }
}
