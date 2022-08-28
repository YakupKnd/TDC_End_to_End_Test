package com.trimdownclub.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
		plugin = {"html:target/cucumber-report.html",
				"json:target/cucumber.json",
				"rerun:target/rerun.txt"
		},
		features = "src/test/resources/features",
		glue = "com/trimdownclub/step_definitions",
//		dryRun = false,
		dryRun = true,
		tags = "@wip"
)

public class TestRunner {

}

