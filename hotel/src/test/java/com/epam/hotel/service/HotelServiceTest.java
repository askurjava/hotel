package com.epam.hotel.service;

import com.epam.hotel.TestData;
import com.epam.hotel.dal.HotelRepository;
import com.epam.hotel.exception.HotelNotFoundException;
import com.epam.hotel.model.entity.HotelEntity;
import com.epam.hotel.model.resources.HotelResourceDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

public class HotelServiceTest {

    @InjectMocks
    private HotelServiceImpl hotelService;
    @Mock
    private HotelRepository repository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddHotel(){
        Mockito.when(repository.save(any(HotelEntity.class))).thenReturn(TestData.hotelEntity());
        HotelResourceDTO resourceDTO = hotelService.addHotel(TestData.hotelResourceDTO());
        Assert.assertNotNull(resourceDTO);
        Mockito.verify(repository).save(any(HotelEntity.class));
    }

    @Test
    public void testGetHotelById(){
        Mockito.when(repository.findById(any())).thenReturn(java.util.Optional.ofNullable(TestData.hotelEntity()));
        HotelResourceDTO resourceDTO = hotelService.getHotelByHotelId(1L);
        Assert.assertNotNull(resourceDTO);
    }


    @Test(expected = HotelNotFoundException.class)
    public void testGetHotelByNullId(){
        hotelService.getHotelByHotelId(null);
    }

    @Test
    public void testGetHotelByCity(){
        Mockito.when(repository.findByCity(anyString()))
                .thenReturn(Collections.singletonList(TestData.hotelEntity()));
        List<HotelResourceDTO> hotels = hotelService.getHotelsByCity("Noida");
        Assert.assertFalse(hotels.isEmpty());
    }

    @Test(expected = HotelNotFoundException.class)
    public void testGetHotelByNullCity(){
        hotelService.getHotelsByCity(null);
    }

}
