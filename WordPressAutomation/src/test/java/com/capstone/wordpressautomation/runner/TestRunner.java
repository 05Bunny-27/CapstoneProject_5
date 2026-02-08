package com.capstone.wordpressautomation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.capstone.wordpressautomation.steps",
    plugin = {"pretty"}
)
@Test
public class TestRunner extends AbstractTestNGCucumberTests {
}
 