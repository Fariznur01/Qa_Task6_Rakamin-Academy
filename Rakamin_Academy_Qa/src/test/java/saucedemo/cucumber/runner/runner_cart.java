package saucedemo.cucumber.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/saucedemo/cucumber/resources/features/cart.feature",
        glue = "saucedemo.cucumber.stepDef.cart",
        plugin = {"html:target/cart/cucumber-reports"}
)
public class runner_cart {
}
