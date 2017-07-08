package com.thedeathstar.steps;

import com.consol.citrus.annotations.CitrusResource;
import com.consol.citrus.config.CitrusSpringConfig;
import com.consol.citrus.dsl.design.TestDesigner;
import com.consol.citrus.http.client.HttpClient;
import com.consol.citrus.message.MessageType;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;

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
    public void ConfirmDeathStarServiceIsUp() throws Throwable {

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
    public void AddDeathStar() throws Throwable {

        designer.http()
                .client(deathStarClient)
                .send()
                .post("/todolist")
                .messageType(MessageType.JSON)
                .contentType("application/json")
                .payload("{ \"id\": \"DS-3\", \"name\": \"Death Star Three\"}");

        designer.http()
                .client(deathStarClient)
                .receive()
                .response(HttpStatus.NOT_FOUND);
    }
}
