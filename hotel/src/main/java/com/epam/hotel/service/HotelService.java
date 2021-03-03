package com.epam.hotel.service;

import com.epam.hotel.model.resources.HotelResourceDTO;

import java.util.List;

/**
 * The interface Hotel service.
 */
public interface HotelService {

    /**
     * Add hotel hotel resource dto.
     *
     * @param hotelResourceDTO the hotel resource dto
     * @return the hotel resource dto
     */
    HotelResourceDTO addHotel(HotelResourceDTO hotelResourceDTO);

    /**
     * Gets hotel by hotel id.
     *
     * @param hotelId the hotel id
     * @return the hotel by hotel id
     */
    HotelResourceDTO getHotelByHotelId(Long hotelId);

    /**
     * Gets hotels by city.
     *
     * @param city the city
     * @return the hotels by city
     */
    List<HotelResourceDTO> getHotelsByCity(String city);

}
