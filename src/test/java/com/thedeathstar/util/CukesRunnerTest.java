package com.thedeathstar.util;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

/**
 * Created by Jeremy on 6/27/17.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, glue = "com.thedeathstar", features = "src/test/resources")
public class CukesRunnerTest {



}
