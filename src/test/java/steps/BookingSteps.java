package steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;

public class BookingSteps {
    String city;
    public static final String RATING_XPATH = "//*[text()='%s']//ancestor::*[@data-testid='property-card']//*[contains(@aria-label, 'Оценка')]";

    @Given("User is looking for hotels in {string} city")
    public void userIsLookingForHotelsInCity(String city) {
        this.city = city;
    }

    @When("User does search")
    public void userDoesSearch() {
        open("https://www.booking.com");
        $(By.id("ss")).sendKeys(city);
        $(".sb-searchbox__button").click();
    }

    @Then("Hotel {string} should be on the first page")
    public void hotelHamptonByHiltonMinskCityCentreShouldBeOnTheFirstPage(String hotel) {
        ArrayList<String> hotelNames = new ArrayList<>();
        for (SelenideElement element : $$(By.xpath("//*[@data-testid='title']"))) {
            hotelNames.add(element.getText());
        }
        Assert.assertTrue(hotelNames.contains(hotel));
    }

    @And("the hotel {string} should have the rating {string}")
    public void theHotelHotelShouldHaveTheRatingRating(String hotel, String rating) {
        ArrayList<String> hotelRate = new ArrayList<>();
        for (SelenideElement element : $$(By.xpath(String.format(RATING_XPATH, hotel)))) {
            hotelRate.add(element.getText());
        }
        Assert.assertTrue(hotelRate.contains(rating));
    }
}
