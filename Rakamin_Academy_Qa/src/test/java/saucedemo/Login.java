package saucedemo;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    @Test
    public static void main(String[] args) {
        // Atur path ke chromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");


        // Inisialisasi instance WebDriver
        WebDriver driver = new ChromeDriver();

        // Buka www.saucedemo.com
        driver.get("https://www.saucedemo.com");

        // Temukan elemen input username dan password
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        // Isi username dan password
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");

        // Temukan dan klik tombol login
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Tunggu beberapa saat untuk melihat hasilnya
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Tutup browser
        driver.quit();
    }
}
