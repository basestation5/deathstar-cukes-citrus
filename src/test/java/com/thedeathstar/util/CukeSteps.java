package com.thedeathstar.util;

import com.consol.citrus.config.CitrusSpringConfig;
import com.consol.citrus.dsl.design.TestDesigner;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import com.consol.citrus.annotations.CitrusResource;
import org.springframework.test.context.ContextConfiguration;
import com.consol.citrus.http.client.HttpClient;

/**
 * Created by Jeremy on 6/27/17.
 */


//@SuppressWarnings("SpringJavaAutowiringInspection")
@ContextConfiguration(classes = CitrusSpringConfig.class)
public class CukeSteps {

    @CitrusResource
    private TestDesigner designer;

   @Autowired
   private HttpClient deathStarClient;

    @Given("There are two deathstars in the Galaxy")
    public void ExecuteGiven() {

    }
    @When("I call the Deathstar Service")
    public void ExecuteWhen() {

         designer.http()
               .client(deathStarClient)
               .send()
               .get("/deathstars");

    }
    @Then("I should get two deathstars")
    public void ExecuteThen() {

    }


}
