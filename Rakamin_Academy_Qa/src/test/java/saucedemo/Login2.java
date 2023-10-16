package saucedemo;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class Login2 {
    WebDriver driver;

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        try {
            String csvFile = "C:\\Users\\Administrator\\Downloads\\Dts Proa Rakamin IT Qa\\Minggu6\\Tugas\\test_data.csv";
            CSVReader reader = new CSVReader(new FileReader(csvFile));
            String[] nextLine;
            int totalRows = 0;

            while ((nextLine = reader.readNext()) != null) {
                totalRows++;
            }
            reader.close();

            Object[][] data = new Object[totalRows][3];

            reader = new CSVReader(new FileReader(csvFile));
            int i = 0;

            while ((nextLine = reader.readNext()) != null) {
                data[i][0] = nextLine[0]; // username
                data[i][1] = nextLine[1]; // password
                data[i][2] = nextLine[2]; // expected result
                i++;
            }

            return data;
        } catch (CsvValidationException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, String expected) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

        // Navigate to the Sauce Demo website
        driver.get("https://www.saucedemo.com/");

        // Find the username and password fields and login button
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        // Enter the username and password
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        // Click the login button
        loginButton.click();

        // Verify the login result
        WebElement inventoryContainer = driver.findElement(By.className("inventory_container"));

        if (expected.equals("Successful Login") && inventoryContainer.isDisplayed()) {
            System.out.println("Login is successful. Success!");
        } else if (expected.equals("Unsuccessful Login")) {
            WebElement errorMessage = driver.findElement(By.cssSelector(".error-message"));
            if (errorMessage.isDisplayed()) {
                System.out.println("Login is unsuccessful. Error message: " + errorMessage.getText());
            } else {
                System.out.println("Login is successful.");
            }
        }


        // Close the browser
        driver.quit();
    }
}
