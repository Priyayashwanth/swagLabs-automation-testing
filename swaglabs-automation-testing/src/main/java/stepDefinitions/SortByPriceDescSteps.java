package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverSingleton;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class SortByPriceDescSteps {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverSingleton.getDriver();
    }

    @After
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }

    @And("I click on sort")
    public void i_click_on_sort() {
        WebElement sortButton = driver.findElement(By.className("product_sort_container"));
        sortButton.click();
    }

    @And("I select high to low")
    public void i_select_high_to_low() {
        WebElement highToLowOption = driver.findElement(By.cssSelector("option[value='hilo']"));
        highToLowOption.click();
    }

    @Then("Price of items should be in descending order")
    public void price_of_items_should_be_in_descending_order() {
        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
        for (int i = 0; i < priceElements.size() - 1; i++) {
            String price1 = priceElements.get(i).getText().replace("$", "");
            String price2 = priceElements.get(i + 1).getText().replace("$", "");
            double itemPrice1 = Double.parseDouble(price1);
            double itemPrice2 = Double.parseDouble(price2);
            assertTrue("Prices are not in descending order", itemPrice1 >= itemPrice2);
        }
    }
}
