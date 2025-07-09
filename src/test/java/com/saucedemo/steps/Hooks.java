package com.saucedemo.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;

public class Hooks {

    private BrowseTheWebWithPlaywright ability;

    @Before
    public void setTheStage() {
        ability = BrowseTheWebWithPlaywright.usingTheDefaultConfiguration();
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("User").can(ability);
    }

    @After
    public void tearDown() {
        if (ability != null && ability.getBrowser() != null) {
            ability.getBrowser().close();
        }
    }
}
