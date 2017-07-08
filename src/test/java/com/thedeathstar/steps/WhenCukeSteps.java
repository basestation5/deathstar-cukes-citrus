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

/**
 * Created by Jeremy on 7/7/17.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@ContextConfiguration(classes = CitrusSpringConfig.class)
public class WhenCukeSteps {

    @CitrusResource
    private TestDesigner designer;

    @Autowired
    private HttpClient deathStarClient;

    @When("^I call the Deathstar Service$")
    public void i_call_the_Deathstar_Service() throws Throwable {

        designer.http()
                .client(deathStarClient)
                .send()
                .get("/deathstars");

        designer.http()
                .client(deathStarClient)
                .receive()
                .response(HttpStatus.OK);

    }

    @When("^I add a Deathstar to the DeathStar Service$")
    public void i_add_a_Deathstar_to_the_DeathStar_Service() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }
}
