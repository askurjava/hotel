package com.epam.hotel.model.error;

import lombok.Builder;
import lombok.Data;

/**
 * The type Error message.
 */
@Data
@Builder
public class ErrorMessage {
    private final Integer errorCode;
    private final String errorMessage;
}
