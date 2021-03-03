package com.epam.hotel.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Address resource dto.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Embeddable
public class AddressEntity {

    @Column(name = "BUILDING_NAME")
    private String buildingName;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "POSTAL_CODE")
    private Integer postalCode;

}
