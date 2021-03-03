package com.epam.hotel.model.resources;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class HotelResourceDTO {
    @ApiModelProperty(notes = "Hotel Id")
    private Long hotelId;
    @ApiModelProperty(notes = "Name of the Hotel", required = true)
    private String hotelName;
    @ApiModelProperty(notes = "Rating of the Hotel")
    private Integer rating;
    @ApiModelProperty(notes = "Hotel's email", required = true)
    private String email;
    @ApiModelProperty(notes = "Hotel's phone number", required = true)
    private Integer phoneNumber;
    @ApiModelProperty(notes = "City")
    private String city;
    @ApiModelProperty(notes = "Details for rooms")
    private List<RoomResourceDTO> room;
}
