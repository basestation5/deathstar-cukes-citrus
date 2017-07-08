package com.thedeathstar.steps;

import com.consol.citrus.config.CitrusSpringConfig;
import com.consol.citrus.dsl.design.TestDesigner;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import com.consol.citrus.annotations.CitrusResource;
import org.springframework.test.context.ContextConfiguration;
import com.consol.citrus.http.client.HttpClient;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import org.springframework.http.HttpStatus;

/**
 * In the when statement, we will confirm the test setup is in the expected configuration.
 */


@SuppressWarnings("SpringJavaAutowiringInspection")
@ContextConfiguration(classes = CitrusSpringConfig.class)
public class GivenCukeSteps {

    @CitrusResource
    private TestDesigner designer;

   @Autowired
   private HttpClient deathStarClient;

    @Given("^There are two deathstars in the Galaxy$")
    public void ConfirmTwoDeathStarsExist() throws Throwable {

        designer.http()
                .client(deathStarClient)
                .send()
                .get("/deathstars");

        designer.http()
                .client(deathStarClient)
                .receive()
                .response(HttpStatus.OK);
        //.payload(String.valueOf(2));
    }

}
