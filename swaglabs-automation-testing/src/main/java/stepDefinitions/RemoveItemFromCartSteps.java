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
import java.util.List;

public class RemoveItemFromCartSteps {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverSingleton.getDriver();
    }

    @After
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }

    @And("I add items to the cart")
    public void i_add_items_to_the_cart() {
        WebElement addToCartButton1 = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
        WebElement addToCartButton2 = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton1.click();
        addToCartButton2.click();
    }

    @And("I click the remove button for a specific item")
    public void i_click_the_remove_button_for_a_specific_item() {
        WebElement removeButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
        removeButton.click();
    }

    @Then("the item should be immediately removed from the cart")
    public void the_item_should_be_immediately_removed_from_the_cart() {
        List<WebElement> cartItems = driver.findElements(By.id("sauce-labs-backpack"));
        Assert.assertTrue(cartItems.isEmpty(), "Item is still present in the cart");
    }

    @And("cart count should update accordingly")
    public void cart_count_should_update_accordingly() {
        WebElement cartItemCountElement = driver.findElement(By.className("shopping_cart_badge"));
        String cartItemCountText = cartItemCountElement.getText();
        int cartCount = Integer.parseInt(cartItemCountText);
        Assert.assertEquals(cartCount, 1, "Cart count is not updated after item removal");
    }
}
