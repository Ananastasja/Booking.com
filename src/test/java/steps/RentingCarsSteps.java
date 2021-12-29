package steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class RentingCarsSteps {
    String city;
    public static final String RENT_CAR_BTN = "//*[@class='bui-tab__link']//*[contains(text(), 'Аре')]";
    public static final String SEARCH_FIELD_ID = "ss_origin";
    public static final String MAP_ID = "map_location";

    @Given("User is looking for cars in {string} city")
    public void userIsLookingForCarsInMinskCity(String city) {
        this.city = city;
    }

    @When("User does car search")
    public void userDoesCarSearch() {
        open("https://www.booking.com");
        $(By.xpath(RENT_CAR_BTN)).click();
        $(By.id(SEARCH_FIELD_ID)).sendKeys(city);
        $(".sb-searchbox__button").click();
    }

    @Then("The map with locations is displayed")
    public void theMapWithLocationsIsDisplayed() {
        $(By.id(MAP_ID)).shouldBe(Condition.visible, Duration.ofSeconds(20));
    }
}
