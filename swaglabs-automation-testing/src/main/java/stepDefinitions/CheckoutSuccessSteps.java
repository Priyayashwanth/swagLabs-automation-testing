package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverSingleton;

public class CheckoutSuccessSteps {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverSingleton.getDriver();
    }

    @After
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }

    @And("I add {int} items to cart")
    public void i_add_items_to_cart(int itemCount) {
        for (int i = 0; i < itemCount; i++) {
            WebElement addToCartButton = driver.findElement(By.xpath("//div[@class='inventory_item']["+ (i + 1) + "]//button"));
            addToCartButton.click();
        }
    }

    @And("I click on cart icon")
    public void i_click_on_cart_icon() {
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();
    }

    @And("I click on checkout")
    public void i_click_on_checkout() {
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
    }

    @And("I enter first name")
    public void i_enter_first_name() {
        WebElement firstNameField = driver.findElement(By.id("first-name"));
        firstNameField.sendKeys("John");
    }

    @And("I enter last name")
    public void i_enter_last_name() {
        WebElement lastNameField = driver.findElement(By.id("last-name"));
        lastNameField.sendKeys("Doe");
    }

    @And("I enter postal code")
    public void i_enter_postal_code() {
        WebElement postalCodeField = driver.findElement(By.id("postal-code"));
        postalCodeField.sendKeys("12345");
    }

    @And("I click on continue")
    public void i_click_on_continue() {
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();
    }

    @And("I click on finish")
    public void i_click_on_finish() {
        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();
    }

    @Then("I should get a successful message")
    public void i_should_get_a_successful_message() {
        WebElement successMessage = driver.findElement(By.className("complete-header"));
        assert successMessage.getText().equals("Thank you for your order!");
    }
}
