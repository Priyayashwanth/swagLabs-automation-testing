package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.WebDriverSingleton;

public class ProductDetailsVisibleOnClickSteps {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverSingleton.getDriver();
    }

    @After
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }

    @And("I click on a product")
    public void i_click_on_a_product() {
        WebElement productLink = driver.findElement(By.id("item_4_title_link"));
        productLink.click();
    }

    @Then("I should get the details about that product")
    public void i_should_get_the_details_about_that_product() {
        boolean detailsIsDisplayed = driver.findElement(By.className("inventory_details_container")).isDisplayed();
        Assert.assertTrue(detailsIsDisplayed, "Product Details are not displayed");
    }
}
