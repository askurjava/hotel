package com.epam.hotel.model.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ROOM_TABLE")
public class RoomEntity {

    @Id
    @Column(name = "ROOM_TYPE")
    private String roomType;

    @Column(name = "PRICE")
    private Long price;

    @Column(name="rooms")
    private Long availableRoom;

    private Long hotelId;


}
