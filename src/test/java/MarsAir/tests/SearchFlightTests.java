package MarsAir.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static MarsAir.data.TestConstants.*;

public class SearchFlightTests extends BaseTest {

    @Test
    void shouldSeeDiscountWhenSearchWithValidPromoCode() {
        searchPage.searchFlight("July", "December (two years from now)", "AF3-FJK-418");
        Assert.assertEquals(searchPage.getConfirmSeatMessage(), "Seats available!");
        Assert.assertEquals(searchPage.getDiscountResult(TIMEOUT_MEDIUM), "Promotional code AF3-FJK-418 used: 30% discount!");
        Assert.assertEquals(searchPage.getBookingPhoneNumber(), "Call now on 0800 MARSAIR to book!");

    }

    @Test
    void shouldSeeSeatsAvailableWhenSearchWithoutPromoCode() {
        searchPage.searchFlight("July", "December (two years from now)", "");
        Assert.assertEquals(searchPage.getConfirmSeatMessage(), "Seats available!");
        Assert.assertEquals(searchPage.getDiscountResult(TIMEOUT_SHORT), "");
        Assert.assertEquals(searchPage.getBookingPhoneNumber(), "Call now on 0800 MARSAIR to book!");
    }

    @Test
    void shouldSeeNoSeatsMessageWhenFlightIsFull() {
        searchPage.searchFlight("July", "July (two years from now)", "AF3-FJK-418");
        Assert.assertEquals(searchPage.getConfirmSeatMessage(), "Sorry, there are no more seats available.");
    }


    @Test
    void shouldSeeErrorMessageWhenSearchInvalidDateRange(){
        searchPage.searchFlight("July", "December", "");
        Assert.assertEquals(searchPage.getConfirmSeatMessage(), "Unfortunately, this schedule is not possible. Please try again.");
    }

    @Test
    void shouldSeeInvalidCodeMessageWhenUseWrongPromoCode() {
        searchPage.searchFlight("July", "December (two years from now)", "ABC-FJK-418");
        Assert.assertEquals(searchPage.getConfirmSeatMessage(), "Seats available!");
        Assert.assertEquals(searchPage.getDiscountResult(TIMEOUT_MEDIUM), "Sorry, code ABC-FJK-418 is not valid");
        Assert.assertEquals(searchPage.getBookingPhoneNumber(), "Call now on 0800 MARSAIR to book!");


    }
}
