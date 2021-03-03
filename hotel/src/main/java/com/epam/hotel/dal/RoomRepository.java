package com.epam.hotel.dal;

import com.epam.hotel.model.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<RoomEntity, Long> {
}
