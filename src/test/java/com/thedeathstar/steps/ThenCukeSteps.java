package com.thedeathstar.steps;

import com.consol.citrus.annotations.CitrusResource;
import com.consol.citrus.config.CitrusSpringConfig;
import com.consol.citrus.dsl.design.TestDesigner;
import com.consol.citrus.http.client.HttpClient;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import org.springframework.http.HttpStatus;

/**
 * Created by Jeremy on 7/7/17.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@ContextConfiguration(classes = CitrusSpringConfig.class)
public class ThenCukeSteps {

    @CitrusResource
    private TestDesigner designer;

    @Autowired
    private HttpClient deathStarClient;

    @Then("^I should get two deathstars$")
    public void i_should_get_two_deathstars() throws Throwable {

        designer.http()
                .client(deathStarClient)
                .send()
                .get("/deathstars");

        designer.http()
                .client(deathStarClient)
                .receive()
                .response(HttpStatus.OK);
               // .payload(String.valueOf(2));

    }


    @Then("^I should get three deathstars$")
    public void i_should_get_three_deathstars() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

}
