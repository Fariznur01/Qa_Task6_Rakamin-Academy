package saucedemo.cucumber.stepDef.logout;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class Logotsteps {
    private WebDriver driver;

    @Given("I am on the Sauce Demo login page")
    public void iAmOnSauceDemoLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @And("I am logged in with valid credentials")
    public void loginWithValidCredentials() {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();
    }

    @When("I click tab menu")
    public void clickTabMenu() {
        WebElement tabMenu = driver.findElement(By.cssSelector("#menu_button_container > div > div:nth-child(1) > div"));
        tabMenu.click();
    }

    @And("I click the logout button")
    public void clickLogoutButton() {
        By logoutLinkID = By.id("logout_sidebar_link");

// Temukan elemen menggunakan WebDriver
        WebElement logoutLink = driver.findElement(logoutLinkID);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Maksimum waktu tunggu 10 detik
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
// Lakukan tindakan klik pada elemen
        logoutLink.click();
    }

    @Then("I should be logged out")
    public void verifyLoggedOut() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        Assert.assertTrue(loginButton.isDisplayed());
    }
}
