package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.WebDriverSingleton;

public class LoginFailSteps {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverSingleton.getDriver();
    }

    @After
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }

    @When("I enter wrong password")
    public void i_enter_wrong_password() {
        CommonUtils.enterPassword(driver, "wrong-password");
    }

    @Then("I get an error message for incorrect password")
    public void i_get_an_error_message_for_incorrect_password_username() {
        boolean errorMessageDisplayed = driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed();
        Assert.assertTrue(errorMessageDisplayed, "Error message is not displayed on login page");
    }
}
