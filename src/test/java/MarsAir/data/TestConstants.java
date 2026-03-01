package MarsAir.data;

import MarsAir.utils.ConfigReader;

public class TestConstants {

    // --- Timeouts ---
    public static final int TIMEOUT_SHORT = Integer.parseInt(ConfigReader.getProperty("timeout.short"));
    public static final int TIMEOUT_MEDIUM = Integer.parseInt(ConfigReader.getProperty("timeout.medium"));

    // --- Messages ---
    public static final String MSG_SEATS_AVAILABLE = "Seats available!";
    public static final String MSG_NO_SEATS = "Sorry, there are no more seats available.";
    public static final String MSG_INVALID_SCHEDULE = "Unfortunately, this schedule is not possible. Please try again.";
    public static final String MSG_BOOKING_PHONE = "Call now on 0800 MARSAIR to book!";

    // --- Promo Codes & Results ---
    public static final String PROMO_VALID = "AF3-FJK-418";
    public static final String PROMO_INVALID = "ABC-FJK-418";
    public static final String MSG_DISCOUNT_SUCCESS = "Promotional code AF3-FJK-418 used: 30% discount!";
    public static final String MSG_DISCOUNT_INVALID = "Sorry, code ABC-FJK-418 is not valid";
}
