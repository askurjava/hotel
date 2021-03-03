package com.epam.hotel;

import com.epam.hotel.model.entity.HotelEntity;
import com.epam.hotel.model.entity.RoomEntity;
import com.epam.hotel.model.resources.HotelResourceDTO;
import com.epam.hotel.model.resources.RoomResourceDTO;

import java.util.Collections;

public class TestData {

    public static HotelEntity hotelEntity(){
        return HotelEntity.builder()
                .hotelId(1L)
                .hotelName("Test Hotel")
                .rating(5)
                .city("New Delhi")
                .phoneNumber(123456)
                .email("test@test.com")
                .availableRoom(100L)
                .roomEntity(Collections.singletonList(roomEntity()))
                .build();
    }

    private static RoomEntity roomEntity(){
        return RoomEntity.builder()
                .price(100L)
                .roomType("TEST")
                .availableRoom(100L)
                .hotelId(1L)
                .build();
    }

    public static HotelResourceDTO hotelResourceDTO(){
        return HotelResourceDTO.builder()
                .hotelId(1L)
                .hotelName("Test Hotel")
                .rating(5)
                .city("New Delhi")
                .phoneNumber(123456)
                .email("test@test.com")
                .room(Collections.singletonList(roomResourceDTO()))
                .build();
    }

    private static RoomResourceDTO roomResourceDTO(){
        return RoomResourceDTO.builder()
                .price(100L)
                .roomType("TEST")
                .availableRoom(100L)
                .build();
    }


}
