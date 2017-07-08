package com.thedeathstar.steps;

import com.consol.citrus.annotations.CitrusResource;
import com.consol.citrus.config.CitrusSpringConfig;
import com.consol.citrus.dsl.design.TestDesigner;
import com.consol.citrus.http.client.HttpClient;
import com.consol.citrus.message.MessageType;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

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
    public void ConfirmTwoDeathStars() throws Throwable {

        designer.http()
                .client(deathStarClient)
                .send()
                .get("/deathstars");

        designer.http()
                .client(deathStarClient)
                .receive()
                .response(HttpStatus.OK)
                .messageType(MessageType.JSON)
                .validate("$.*", hasSize(2));


    }

    @Then("^I should get three deathstars$")
    public void ConfirmThreeDeathStars() throws Throwable {

        designer.http()
                .client(deathStarClient)
                .send()
                .get("/deathstars");

        //designer.http()
        //        .client(deathStarClient)
        //        .receive()
        //        .response(HttpStatus.OK)
        //        .messageType(MessageType.JSON)
        //        .validate("$.*", hasSize(3));
    }

}
