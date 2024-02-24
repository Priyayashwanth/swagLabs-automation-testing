package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.WebDriverSingleton;

public class LockedOutUserLogin {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverSingleton.getDriver();
    }

    @After
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }

    @When("I enter a locked out username")
    public void i_enter_a_locked_out_username() {
        CommonUtils.enterUsername(driver, "locked_out_user");
    }

    @Then("I get an error message for locked out user")
    public void i_get_an_error_message_for_locked_out_user() {
        boolean errorMessageDisplayed = driver.findElement(By.cssSelector("[data-test=\"error\"]")).isDisplayed();
        Assert.assertTrue(errorMessageDisplayed, "Error message is not displayed on login page");
    }
}
