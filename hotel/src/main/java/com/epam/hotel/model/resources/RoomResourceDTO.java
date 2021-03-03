package com.epam.hotel.model.resources;


import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomResourceDTO {

    @ApiModelProperty(notes = "Type of room", required = false)
     private String roomType;
    @ApiModelProperty(notes = "Room Price", required = false)
     private Long price;
    @ApiModelProperty(notes = "Available rooms in hotels", required = false)
     private Long availableRoom;

}
