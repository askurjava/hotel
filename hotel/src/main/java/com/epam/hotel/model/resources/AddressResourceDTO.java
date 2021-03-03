package com.epam.hotel.model.resources;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * The Address resource dto.
 */
@Builder(toBuilder = true)
@Data
public class AddressResourceDTO {
    @ApiModelProperty(notes = "building Name", required = false)
    private String buildingName;

    @ApiModelProperty(notes = "city", required = true)
    private String city;

    @ApiModelProperty(notes = "state", required = false)
    private String state;

    @ApiModelProperty(notes = "country", required = false)
    private String country;

    @ApiModelProperty(notes = "postalCode", required = true)
    private int postalCode;
}
