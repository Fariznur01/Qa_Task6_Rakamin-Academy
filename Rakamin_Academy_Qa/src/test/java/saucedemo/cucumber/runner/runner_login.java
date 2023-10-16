package saucedemo.cucumber.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/saucedemo/cucumber/resources/features/login.feature", // Direktori atau path ke file fitur
        glue = "saucedemo.cucumber.stepDef.login", // Paket yang berisi definisi langkah-langkah
        plugin = {"html:target/login/cucumber-reports"} // Opsional: Untuk laporan HTML
)

public class runner_login {

}
