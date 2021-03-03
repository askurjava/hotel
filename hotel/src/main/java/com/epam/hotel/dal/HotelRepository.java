package com.epam.hotel.dal;

import com.epam.hotel.model.entity.HotelEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The interface Hotel repository.
 */
public interface HotelRepository extends CrudRepository<HotelEntity, Long> {

    /**
     * Find by city list.
     *
     * @param city the city
     * @return the list
     */
    List<HotelEntity> findByCity(String city);
}
