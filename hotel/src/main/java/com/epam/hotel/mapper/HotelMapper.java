package com.epam.hotel.mapper;

import com.epam.hotel.model.entity.AddressEntity;
import com.epam.hotel.model.entity.HotelEntity;
import com.epam.hotel.model.entity.RoomEntity;
import com.epam.hotel.model.resources.AddressResourceDTO;
import com.epam.hotel.model.resources.HotelResourceDTO;
import com.epam.hotel.model.resources.RoomResourceDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type Hotel mapper.
 */
public class HotelMapper {

    /**
     * To hotel entity hotel entity.
     *
     * @param hotelResourceDTO the hotel resource dto
     * @return the hotel entity
     */
    public static HotelEntity toHotelEntity(HotelResourceDTO hotelResourceDTO) {
        return HotelEntity.builder()
                .hotelId(Optional.ofNullable(hotelResourceDTO.getHotelId()).orElse(null))
                .hotelName(hotelResourceDTO.getHotelName())
                .email(hotelResourceDTO.getEmail())
                .phoneNumber(hotelResourceDTO.getPhoneNumber())
                .rating(hotelResourceDTO.getRating())
                .city(hotelResourceDTO.getCity())
//                .address(toAddress(hotelResourceDTO.getHotelAddress()))
                .roomEntity(toListRoomEntity(hotelResourceDTO.getRoom()))
                .build();
    }

    /**
     * To address address entity.
     *
     * @param addressResourceDTO the address resource dto
     * @return the address entity
     */
    public static AddressEntity toAddress(final AddressResourceDTO addressResourceDTO) {
        return AddressEntity.builder()
                .buildingName(addressResourceDTO.getBuildingName())
                .city(addressResourceDTO.getCity())
                .state(addressResourceDTO.getState())
                .country(addressResourceDTO.getCountry())
                .postalCode(addressResourceDTO.getPostalCode())
                .build();
    }

    /**
     * To room entity room entity.
     *
     * @param roomResourceDTO the room resource dto
     * @return the room entity
     */
    public static RoomEntity toRoomEntity(RoomResourceDTO roomResourceDTO) {
        return RoomEntity.builder()
                .availableRoom(roomResourceDTO.getAvailableRoom())
                .roomType(roomResourceDTO.getRoomType())
                .price(roomResourceDTO.getPrice())
                .build();
    }

    /**
     * To room dto room resource dto.
     *
     * @param roomEntity the room entity
     * @return the room resource dto
     */
    public static RoomResourceDTO toRoomDTO(RoomEntity roomEntity) {
        return RoomResourceDTO.builder()
                .availableRoom(roomEntity.getAvailableRoom())
                .roomType(roomEntity.getRoomType())
                .price(roomEntity.getPrice())
                .build();
    }

    /**
     * To hotel dto hotel resource dto.
     *
     * @param hotelEntity the hotel entity
     * @return the hotel resource dto
     */
    public static HotelResourceDTO toHotelDTO(HotelEntity hotelEntity) {
        return HotelResourceDTO.builder()
                .hotelId(Optional.ofNullable(hotelEntity.getHotelId()).orElse(null))
                .hotelName(hotelEntity.getHotelName())
                .email(hotelEntity.getEmail())
                .phoneNumber(hotelEntity.getPhoneNumber())
                .rating(hotelEntity.getRating())
                .city(hotelEntity.getCity())
//                .hotelAddress(toAddressDTO(hotelEntity.getAddress()))
                .room(toListRoomDTO(hotelEntity.getRoomEntity()))
                .build();
    }

    /**
     * To address dto address resource dto.
     *
     * @param addressEntity the address entity
     * @return the address resource dto
     */
    public static AddressResourceDTO toAddressDTO(final AddressEntity addressEntity) {
        return AddressResourceDTO.builder()
                .buildingName(addressEntity.getBuildingName())
                .city(addressEntity.getCity())
                .state(addressEntity.getState())
                .country(addressEntity.getCountry())
                .postalCode(addressEntity.getPostalCode())
                .build();
    }

    private static List<RoomEntity> toListRoomEntity(List<RoomResourceDTO> roomResourceDTOS) {
        return roomResourceDTOS.stream()
                .map(HotelMapper::toRoomEntity)
                .collect(Collectors.toList());
    }

    private static List<RoomResourceDTO> toListRoomDTO(List<RoomEntity> roomEntities) {
        return roomEntities.stream()
                .map(HotelMapper::toRoomDTO)
                .collect(Collectors.toList());
    }

    /**
     * To list hotel dto list.
     *
     * @param hotelEntities the hotel entities
     * @return the list
     */
    public static List<HotelResourceDTO> toListHotelDTO(List<HotelEntity> hotelEntities){
        return hotelEntities.stream()
                .map(HotelMapper::toHotelDTO)
                .collect(Collectors.toList());
    }

    public static List<HotelEntity> toListHotelEntity(List<HotelResourceDTO> hotelEntities){
        return hotelEntities.stream()
                .map(HotelMapper::toHotelEntity)
                .collect(Collectors.toList());
    }
}
