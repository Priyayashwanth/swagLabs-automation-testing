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

public class AddAnItemToCartSteps {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverSingleton.getDriver();
    }

    @After
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }

    @And("I add an item to cart")
    public void i_add_an_item_to_cart() {
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
    }

    @Then("The items that I added should appear in the shopping cart")
    public void the_items_that_i_added_should_appear_in_the_shopping_cart() {
        boolean removeButtonIsDisplayed = driver.findElement(By.id("remove-sauce-labs-backpack")).isDisplayed();
        Assert.assertTrue(removeButtonIsDisplayed, "Remove button is not displayed for the item");
    }
}
