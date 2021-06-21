package com.nyha.webfinal.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validates ticket info
 *
 * @author Andrey Gretchenko
 */
public class TicketValidator {
    private static final Pattern SEAT_REGEX = Pattern
            .compile("\\d{1,5}");

    private TicketValidator() {
    }

    /**
     * Checks if seat is valid
     *
     * @param seat {@link String}
     * @return boolean true if seat is valid, else false
     */
    public static boolean isValidSeat(String seat) {
        if (seat == null || seat.isBlank()) {
            return false;
        }
        Matcher matcher = SEAT_REGEX.matcher(seat);
        return matcher.matches();
    }
}
