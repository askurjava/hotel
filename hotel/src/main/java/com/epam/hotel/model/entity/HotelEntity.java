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

    @Column(name = "AVAILABLE_ROOM")
    private Long availableRoom;

    @Column(name = "CITY")
    private String city;

    //    @OneToMany(mappedBy = "hotelEntity", fetch = FetchType.EAGER)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotelId", referencedColumnName = "hotelId")
    private List<RoomEntity> roomEntity;

//   ` @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "buildingName", column = @Column(name = "BUILDING_NAME")),
//            @AttributeOverride(name = "city", column = @Column(name = "CITY")),
//            @AttributeOverride(name = "state", column = @Column(name = "STATE")),
//            @AttributeOverride(name = "country", column = @Column(name = "COUNTRY")),
//            @AttributeOverride(name = "postalCode", column = @Column(name = "POSTAL_CODE"))
//    })
//    private AddressEntity address;`
}
