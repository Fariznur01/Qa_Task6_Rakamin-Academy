package saucedemo.cucumber.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/saucedemo/cucumber/resources/features/product.feature",
        glue = "saucedemo.cucumber.stepDef.product",
        plugin = {"html:target/product/cucumber-reports"}
)
public class runner_product {
}
