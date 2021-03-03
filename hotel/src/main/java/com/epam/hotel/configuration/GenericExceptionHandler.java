package com.epam.hotel.configuration;

import com.epam.hotel.exception.HotelNotFoundException;
import com.epam.hotel.model.error.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * The type Generic exception handler.
 */
@Slf4j
@ControllerAdvice(basePackages = "com.epam.hotel.api")
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Guest not found response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<ErrorMessage> guestNotFound(final HotelNotFoundException exception) {
        ErrorMessage errorResponse = ErrorMessage.builder()
                .errorCode(404)
                .errorMessage(exception.getMessage())
                .build();
        log.error("Error Response = {}", errorResponse);
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
