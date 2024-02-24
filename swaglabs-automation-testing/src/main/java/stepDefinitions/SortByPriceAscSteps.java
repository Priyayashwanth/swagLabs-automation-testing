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

public class SortByPriceAscSteps {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverSingleton.getDriver();
    }

    @After
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }

    @And("I select low to high")
    public void i_select_low_to_high() {
        WebElement lowToHighOption = driver.findElement(By.cssSelector("option[value='lohi']"));
        lowToHighOption.click();
    }

    @Then("Price of items should be in ascending order")
    public void price_of_items_should_be_in_ascending_order() {
        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
        for (int i = 0; i < priceElements.size() - 1; i++) {
            String price1 = priceElements.get(i).getText().replace("$", "");
            String price2 = priceElements.get(i + 1).getText().replace("$", "");
            double itemPrice1 = Double.parseDouble(price1);
            double itemPrice2 = Double.parseDouble(price2);
            assertTrue("Prices are not in ascending order", itemPrice1 <= itemPrice2);
        }
    }
}
