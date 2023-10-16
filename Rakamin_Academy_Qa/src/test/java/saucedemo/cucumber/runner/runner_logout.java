package saucedemo.cucumber.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/saucedemo/cucumber/resources/features/logout.feature",
        glue = "saucedemo.cucumber.stepDef.logout",
        plugin = {"html:target/logout/cucumber-reports"}
)
public class runner_logout {

}
