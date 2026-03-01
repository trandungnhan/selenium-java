package MarsAir.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static MarsAir.data.TestConstants.*;

public class SearchFlightTests3 extends BaseTest {

    @Test
    void shouldSeeDiscountWhenSearchWithValidPromoCode() {
        searchPage.searchFlight("July", "December (two years from now)", PROMO_VALID);
        Assert.assertEquals(searchPage.getConfirmSeatMessage(), MSG_SEATS_AVAILABLE);
        Assert.assertEquals(searchPage.getDiscountResult(TIMEOUT_MEDIUM), MSG_DISCOUNT_SUCCESS);
        Assert.assertEquals(searchPage.getBookingPhoneNumber(), MSG_BOOKING_PHONE);

    }

    @Test
    void shouldSeeSeatsAvailableWhenSearchWithoutPromoCode() {
        searchPage.searchFlight("July", "December (two years from now)", "");
        Assert.assertEquals(searchPage.getConfirmSeatMessage(), MSG_SEATS_AVAILABLE);
        Assert.assertEquals(searchPage.getDiscountResult(TIMEOUT_SHORT), "");
        Assert.assertEquals(searchPage.getBookingPhoneNumber(), MSG_BOOKING_PHONE);
    }

    @Test
    void shouldSeeNoSeatsMessageWhenFlightIsFull() {
        searchPage.searchFlight("July", "July (two years from now)", PROMO_VALID);
        Assert.assertEquals(searchPage.getConfirmSeatMessage(), MSG_NO_SEATS);
    }


    @Test
    void shouldSeeErrorMessageWhenSearchInvalidDateRange(){
        searchPage.searchFlight("July", "December", "");
        Assert.assertEquals(searchPage.getConfirmSeatMessage(), MSG_INVALID_SCHEDULE);
    }

    @Test
    void shouldSeeInvalidCodeMessageWhenUseWrongPromoCode() {
        searchPage.searchFlight("July", "December (two years from now)", PROMO_INVALID);
        Assert.assertEquals(searchPage.getConfirmSeatMessage(), MSG_SEATS_AVAILABLE);
        Assert.assertEquals(searchPage.getDiscountResult(TIMEOUT_MEDIUM), MSG_DISCOUNT_INVALID);
        Assert.assertEquals(searchPage.getBookingPhoneNumber(), MSG_BOOKING_PHONE);


    }
}
