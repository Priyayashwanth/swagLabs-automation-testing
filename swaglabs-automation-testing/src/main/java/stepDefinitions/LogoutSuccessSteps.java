package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverSingleton;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class LogoutSuccessSteps {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverSingleton.getDriver();
    }

    @After
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }

    @And("I click on hamburger menu")
    public void i_click_on_hamburger_menu() {
        WebElement hamburgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
        hamburgerMenu.click();
    }

    @And("I click on logout")
    public void i_click_on_logout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        logoutLink.click();
    }
    @Then("I should be back to the login page")
    public void i_should_be_back_to_the_login_page() {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        assertTrue("Login page elements are not displayed",
                usernameField.isDisplayed() && passwordField.isDisplayed() && loginButton.isDisplayed());
    }
}
