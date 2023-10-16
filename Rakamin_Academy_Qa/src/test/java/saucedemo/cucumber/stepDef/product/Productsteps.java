package saucedemo.cucumber.stepDef.product;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class Productsteps {
    private WebDriver driver;
    public Productsteps() {
        // Inisialisasi driver di sini
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("I am on the Sauce Demo login page")
    public void iAmOnSauceDemoLoginPage() {
        // Buka halaman login Sauce Demo
        driver.get("https://www.saucedemo.com/");
    }

    @And("I am logged in with valid credentials")
    public void iAmLoggedInWithValidCredentials() {
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();
    }

    @When("I click on a product from the list")
    public void iClickOnProductFromList() {
        WebElement productLink = driver.findElement(By.cssSelector("#item_4_img_link > img"));
        productLink.click();
    }

    @Then("I should see the details of the selected product")
    public void iShouldSeeDetailsOfSelectedProduct() {
        WebElement productElement = driver.findElement(By.cssSelector("#inventory_item_container > div > div > div.inventory_details_desc_container > div.inventory_details_name.large_size"));
        assert(productElement.isDisplayed());
    }
}
