package com.epam.hotel.service;

import com.epam.hotel.dal.HotelRepository;
import com.epam.hotel.exception.HotelNotFoundException;
import com.epam.hotel.mapper.HotelMapper;
import com.epam.hotel.model.entity.HotelEntity;
import com.epam.hotel.model.resources.HotelResourceDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Hotel service.
 */
@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    /**
     * Instantiates a new Hotel service.
     *
     * @param hotelRepository the hotel repository
     */
    public HotelServiceImpl(final HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public HotelResourceDTO addHotel(HotelResourceDTO hotelResourceDTO) {
        HotelEntity entity = hotelRepository.save(HotelMapper.toHotelEntity(hotelResourceDTO));
        return HotelMapper.toHotelDTO(entity);
    }

    @Override
    public HotelResourceDTO getHotelByHotelId(Long hotelId) {
        return Optional.ofNullable(hotelId)
                .flatMap(hotelRepository::findById)
                .map(HotelMapper::toHotelDTO)
                .orElseThrow(() -> new HotelNotFoundException("Hotel not found for hotel Id:" + hotelId));
    }

    @Override
    public List<HotelResourceDTO> getHotelsByCity(String city) {
        return Optional.ofNullable(city)
                .map(hotelRepository::findByCity)
                .map(HotelMapper::toListHotelDTO)
                .orElseThrow(() -> new HotelNotFoundException("Hotels for City: " + city + "are not found."));
    }

}
