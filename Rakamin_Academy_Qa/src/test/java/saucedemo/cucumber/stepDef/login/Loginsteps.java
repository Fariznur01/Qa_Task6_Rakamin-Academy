package saucedemo.cucumber.stepDef.login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class Loginsteps {
    private WebDriver driver;

    @Given("I am on the Sauce Demo login page")
    public void openLoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter a valid username {string} and password {string}")
    public void enterValidUsernameAndPassword(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @When("I click the login button")
    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("I should be logged in successfully")
    public void verifySuccessfulLogin() {
        WebElement productsTitle = driver.findElement(By.cssSelector(".title"));
        Assert.assertTrue(productsTitle.isDisplayed());
        driver.quit();
    }

    @When("I enter an invalid username {string} and password {string}")
    public void enterInvalidUsernameAndPassword(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @Then("I should see an error message")
    public void verifyErrorMessage() {
        WebElement errorMessage = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3 > button"));
        Assert.assertTrue(errorMessage.isDisplayed());
        driver.quit();
    }

    @When("I leave the username and password fields empty")
    public void leaveFieldsEmpty() {
        // Do nothing, leave fields empty
    }

    @When("I enter the username {string} and password {string}")
    public void enterLockedOutUser(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @And("I am logged in")
    public void verifyLoggedIn() {
        WebElement productsTitle = driver.findElement(By.cssSelector(".title"));
        Assert.assertTrue(productsTitle.isDisplayed());
    }

    @When("I click the logout button")
    public void clickLogoutButton() {
        WebElement logoutButton = driver.findElement(By.id("logout-button"));
        logoutButton.click();
    }

    @Then("I should be logged out")
    public void verifyLoggedOut() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        Assert.assertTrue(loginButton.isDisplayed());
        driver.quit();
    }

    @And("I click the product link")
    public void clickProductLink() {
        WebElement productLink = driver.findElement(By.linkText("Products"));
        productLink.click();
    }

    @Then("I should be on the product page")
    public void verifyProductPage() {
        WebElement productList = driver.findElement(By.cssSelector(".product_list"));
        Assert.assertTrue(productList.isDisplayed());
        driver.quit();
    }
}
