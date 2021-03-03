package com.epam.hotel.api;

import com.epam.hotel.model.resources.HotelResourceDTO;
import com.epam.hotel.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Hotel api.
 */
@RestController
public class HotelApiImpl implements HotelApi {

    private final HotelService hotelService;

    /**
     * Instantiates a new Hotel api.
     *
     * @param hotelService the hotel service
     */
    public HotelApiImpl(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    /**
     * Gets all hotel information by city.
     *
     * @param city the city
     * @return the all hotel information by city
     */
    @Override
    public ResponseEntity<List<HotelResourceDTO>> getAllHotelInformationByCity(String city) {
        return ResponseEntity.ok().body(hotelService.getHotelsByCity(city));
    }

    /**
     * Gets hotel details by hotel id.
     *
     * @param hotelId the hotel id
     * @return the hotel details by hotel id
     */
    @Override
    public ResponseEntity<HotelResourceDTO> getHotelDetailsByHotelId(Long hotelId) {
        return ResponseEntity.ok().body(hotelService.getHotelByHotelId(hotelId));
    }

    /**
     * Add hotel details response entity.
     *
     * @param hotelRequest the hotel details request
     * @return the response entity
     */
    @Override
    public ResponseEntity<HotelResourceDTO> addHotel(HotelResourceDTO hotelRequest) {
        return ResponseEntity.ok().body(hotelService.addHotel(hotelRequest));
    }

}
