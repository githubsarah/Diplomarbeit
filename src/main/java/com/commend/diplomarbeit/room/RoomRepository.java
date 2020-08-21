package com.commend.diplomarbeit.room;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Integer> {
    @Override
    List<Room> findAll();
}