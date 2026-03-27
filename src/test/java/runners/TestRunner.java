package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources/features/addEmployeeScenario.feature",
                "src/test/resources/features/addEmployee.feature"},
        glue={"stepdefinitions","hooks"},
        plugin = {"pretty","html:target/cucumber-report.html",
                "json:target/cucumber.json","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" },
//        monochrome = true,
        tags = "  @login or @regression"
)
public class TestRunner {
}
//"html:target/cucumber-report.html",
//"json:target/cucumber.json"
//"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
