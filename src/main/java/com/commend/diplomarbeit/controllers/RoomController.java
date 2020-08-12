package com.commend.diplomarbeit.controllers;

import com.commend.diplomarbeit.models.Room;
import com.commend.diplomarbeit.models.RoomRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/room") // This means URL's start with /room (after Application path)
public class RoomController {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private RoomRepository roomRepository;


    @GetMapping("") // Zeigt alle Räume an
    public Iterable<Room> getAllRooms(int patientid) {

        return roomRepository.findAll();
    }

    @PostMapping("") // Map ONLY POST Requests
    public String createRoom(@RequestParam long number, @RequestParam int patientid){
        Room r = new Room();
        r.setNumber(number);
        r.setPatientid(patientid);
        roomRepository.save(r);
        return "Saved";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable("id") int id, @RequestBody Room room) throws InvalidConfigurationPropertyValueException {

        Room r = roomRepository.findById(id).orElseThrow(() -> new InvalidConfigurationPropertyValueException("id", id, "Not found"));

        r.setNumber(room.getNumber());
        r.setPatientid(room.getPatientid());

        final Room updateRoom = roomRepository.save(r);
        return ResponseEntity.ok(updateRoom);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable("id") int id) throws InvalidConfigurationPropertyValueException {
        Room r = roomRepository.findById(id).orElseThrow(() -> new InvalidConfigurationPropertyValueException("id", id, "Not found"));

        return ResponseEntity.ok().body(r);
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}"
    )
    public String deleteRoom(@PathVariable("id") int id ){
        roomRepository.deleteById(id);
        return "Deleted";
    }

}
