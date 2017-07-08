package com.thedeathstar.util;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

/**
 * Created by Jeremy on 6/27/17.
 */
@RunWith(Cucumber.class)
@CucumberOptions( plugin = { "com.consol.citrus.cucumber.CitrusReporter" } , glue = "com.thedeathstar.steps", features = "src/test/resources/features")
public class CukesRunnerTest {



}
