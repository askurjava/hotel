package com.epam.hotel.exception;

/**
 * The type Hotel not found exception.
 */
public class HotelNotFoundException extends RuntimeException {
    /**
     * Instantiates a new Hotel not found exception.
     *
     * @param message the message
     */
    public HotelNotFoundException(String message) {
        super(message);
    }
}
