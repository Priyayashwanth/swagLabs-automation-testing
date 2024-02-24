package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {
    private static WebDriver driver;

    // Private constructor to prevent instantiation
    private WebDriverSingleton() {
    }

    // Method to get the instance of WebDriver
    public static WebDriver getDriver() {
        if (driver == null) {
            // Initialize WebDriver if not already initialized
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\priya\\Desktop\\swaglabs-automation-testing\\swaglabs-testing\\src\\main\\java\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    // Method to quit WebDriver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Reset driver instance after quitting
        }
    }
}
