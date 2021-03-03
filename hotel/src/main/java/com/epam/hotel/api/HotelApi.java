package com.epam.hotel.api;

import com.epam.hotel.model.error.ErrorMessage;
import com.epam.hotel.model.resources.HotelResourceDTO;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The interface Hotel api.
 */
@Api(value = "hotel")
@RequestMapping("hotel")
public interface HotelApi {

    /**
     * Gets all hotel information by city.
     *
     * @param city the city
     * @return the all hotel information by city
     */
    @ApiOperation(
            value = "Get All Hotel Details by city name",
            response = HotelResourceDTO.class,
            produces = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "hotel information has been fetched successfully", response = HotelResourceDTO.class),
            @ApiResponse(code = 400, message = "Business validation fail", response = ErrorMessage.class),
            @ApiResponse(code = 401, message = "Authentication failed."),
            @ApiResponse(code = 403, message = "You are not authorized to do this operation."),
            @ApiResponse(code = 404, message = "Resource not found.")
    })
    @GetMapping(value = "/getHotels/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<HotelResourceDTO>> getAllHotelInformationByCity(
            @ApiParam(value = "filter by city") @PathVariable("city") final String city
    );

    /**
     * Gets hotel details by hotel id.
     *
     * @param hotelId the hotel id
     * @return the hotel details by hotel id
     */
    @ApiOperation(
            value = "Get Hotel Details by hotel id",
            response = HotelResourceDTO.class,
            produces = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "hotel information has been fetched successfully", response = HotelResourceDTO.class),
            @ApiResponse(code = 400, message = "Business validation fail", response = ErrorMessage.class),
            @ApiResponse(code = 401, message = "Authentication failed."),
            @ApiResponse(code = 403, message = "You are not authorized to do this operation."),
            @ApiResponse(code = 404, message = "Resource not found.")
    })
    @GetMapping(value = "/getHotel/{hotelId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<HotelResourceDTO> getHotelDetailsByHotelId(
            @ApiParam(value = "get hotel details by hotelId") @PathVariable("hotelId") final Long hotelId
    );

    /**
     * Add hotel details response entity.
     *
     * @param hotelRequest the hotel details request
     * @return the response entity
     */
    @ApiOperation(
            value = "Request for add new hotel information",
            response = HotelResourceDTO.class,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "POST"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Hotel information has been added successfully.", response = HotelResourceDTO.class),
            @ApiResponse(code = 400, message = "Business validation fail", response = ErrorMessage.class),
            @ApiResponse(code = 401, message = "Authentication failed."),
            @ApiResponse(code = 403, message = "You are not authorized to do this operation."),
            @ApiResponse(code = 404, message = "Resource not found.")
    })
    @PostMapping(value = "/addHotel", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<HotelResourceDTO> addHotel(
            @ApiParam(value = "request for add hotel information") @RequestBody final HotelResourceDTO hotelRequest);
}
