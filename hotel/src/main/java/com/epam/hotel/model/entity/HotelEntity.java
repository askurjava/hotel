package com.epam.hotel.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "HOTEL_TABLE")
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelId;

    @Column(name = "HOTEL_NAME")
    private String hotelName;

    @Column(name = "RATING")
    private Integer rating;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "phoneNumber")
    private Integer phoneNumber;

    @Column(name = "CITY")
    private String city;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotelId", referencedColumnName = "hotelId")
    private List<RoomEntity> roomEntity;

}
