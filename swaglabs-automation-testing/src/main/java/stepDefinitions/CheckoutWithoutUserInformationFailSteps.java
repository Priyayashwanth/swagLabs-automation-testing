package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.WebDriverSingleton;

public class CheckoutWithoutUserInformationFailSteps {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverSingleton.getDriver();
    }

    @After
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }

    @Then("I should get an error message")
    public void i_should_get_an_error_message() {
        boolean errorMessageDisplayed = driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed();
        Assert.assertTrue(errorMessageDisplayed, "Error message is not displayed on login page");
    }
}
