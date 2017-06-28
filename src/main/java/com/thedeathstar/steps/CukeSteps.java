package com.thedeathstar.steps;

import com.thedeathstar.api.RestClient;
import com.thedeathstar.model.DeathStars;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * Created by Jeremy on 6/27/17.
 */


//Feature: Get a Deathstar
//   Scenario: Get a single Deathstar
//           Given There are two deathstars in the Galaxy
//           When I call the Deathstar Service
//           Then I should get two deathstars

public class CukeSteps {

    @Given("There are two deathstars in the Galaxy")
    public void ExecuteGiven() {

    }
    @When("I call the Deathstar Service")
    public void ExecuteWhen() {

        RestClient client = new RestClient();

        String deathstars = client.GetDeathStars();

    }
    @Then("I should get two deathstars")
    public void ExecuteThen() {

    }


}
