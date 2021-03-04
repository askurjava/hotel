package com.epam.hotel.api;

import com.epam.hotel.TestData;
import com.epam.hotel.model.resources.HotelResourceDTO;
import com.epam.hotel.service.HotelService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;

public class HotelApiTest {

    @InjectMocks
    private HotelApiImpl hotelApi;

    @Mock
    private HotelService hotelService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddHotel() {
        Mockito.when(hotelService.addHotel(any(HotelResourceDTO.class))).thenReturn(TestData.hotelResourceDTO());
        ResponseEntity<HotelResourceDTO> dtoResponseEntity = hotelApi.addHotel(TestData.hotelResourceDTO());
        Assert.assertEquals(200, dtoResponseEntity.getStatusCodeValue());
        Mockito.verify(hotelService).addHotel(any(HotelResourceDTO.class));
    }

    @Test
    public void testGetHotelDetailsByHotelId() {
        Mockito.when(hotelService.getHotelByHotelId(anyLong())).thenReturn(TestData.hotelResourceDTO());
        ResponseEntity<HotelResourceDTO> dtoResponseEntity = hotelApi.getHotelDetailsByHotelId(1L);
        Assert.assertEquals(200, dtoResponseEntity.getStatusCodeValue());
        Mockito.verify(hotelService).getHotelByHotelId(anyLong());
    }

    @Test
    public void testGetAllHotelInformationByCity() {
        Mockito.when(hotelService.getHotelsByCity(anyString())).thenReturn(Collections.singletonList(TestData.hotelResourceDTO()));
        ResponseEntity<List<HotelResourceDTO>> responseEntity = hotelApi.getAllHotelInformationByCity("Noida");
        Assert.assertEquals(200, responseEntity.getStatusCodeValue());
        Mockito.verify(hotelService).getHotelsByCity(anyString());
    }
}
