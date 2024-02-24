package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.WebDriverSingleton;

public class LoginSuccessSteps {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverSingleton.getDriver();
    }

    @After
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }

    @Given("I access the swag labs login page")
    public void i_access_the_swag_labs_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter username")
    public void i_enter_username() {
        CommonUtils.enterUsername(driver, "standard_user");
    }

    @And("I enter password")
    public void i_enter_password() {
        CommonUtils.enterPassword(driver, "secret_sauce");
    }

    @And("I click on login button")
    public void i_click_on_login_button() {
        CommonUtils.clickOnLogin(driver);
    }

    @Then("I should be presented with products list")
    public void i_should_be_presented_with_products_list() {
        boolean productListDisplayed = driver.findElement(By.className("inventory_list")).isDisplayed();
        Assert.assertTrue(productListDisplayed, "Products list is not displayed after login");
    }
}
