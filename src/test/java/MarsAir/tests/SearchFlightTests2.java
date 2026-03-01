package MarsAir.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static MarsAir.data.TestConstants.*;

public class SearchFlightTests2 extends BaseTest {

    @DataProvider(name = "promoTestData")
    public Object[][] promoCodeData() {
        return new Object[][]{
                // { PromoCode, ExpectedDiscountMessage, ExpectedSeatMessage, WaitTimeout }
                {"AF3-FJK-418", "Promotional code AF3-FJK-418 used: 30% discount!", MSG_SEATS_AVAILABLE, TIMEOUT_MEDIUM},
                {"ABC-FJK-418", "Sorry, code ABC-FJK-418 is not valid", MSG_SEATS_AVAILABLE, TIMEOUT_MEDIUM},
                {"", "", MSG_SEATS_AVAILABLE, TIMEOUT_SHORT}
        };
    }

    @Test(dataProvider = "promoTestData", description = "Verify various promotional code scenarios")
    void shouldVerifyPromoCodeResults(String promo, String expectedDiscount, String expectedSeat, int timeout) {
        searchPage.searchFlight("July", "December (two years from now)", promo);

        Assert.assertEquals(searchPage.getConfirmSeatMessage(), expectedSeat);
        Assert.assertEquals(searchPage.getDiscountResult(timeout), expectedDiscount);
        Assert.assertEquals(searchPage.getBookingPhoneNumber(), MSG_BOOKING_PHONE);
    }

    @Test(description = "Verify error message when the flight is fully booked")
    void shouldSeeNoSeatsMessageWhenFlightIsFull() {
        searchPage.searchFlight("July", "July (two years from now)", "AF3-FJK-418");
        Assert.assertEquals(searchPage.getConfirmSeatMessage(), MSG_NO_SEATS);
    }

    @Test(description = "Verify error message when selecting an invalid date range")
    void shouldSeeErrorMessageWhenSearchInvalidDateRange() {
        searchPage.searchFlight("July", "December", "");
        Assert.assertEquals(searchPage.getConfirmSeatMessage(), MSG_INVALID_SCHEDULE);
    }

}


