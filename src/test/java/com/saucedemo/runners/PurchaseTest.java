package com.saucedemo.runners;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin   = {"pretty"},
        features = "src/test/resources/features/purchase.feature",
        glue     = "com.saucedemo.steps"
)
public class PurchaseTest {}
