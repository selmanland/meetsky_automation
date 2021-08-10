package com.vytrack.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",     // report van maven
                "html:target/default-html-reports", //html report
                "rerun:target/rerun.txt"},     //create rerun report and keeps failed tset scenarios
        features = "src/test/resources/features",
        glue = "com/vytrack/step_definitions",
        dryRun = false,
        tags = "@wip"
)
public class CukesRunner {
}