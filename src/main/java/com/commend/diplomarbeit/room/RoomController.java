package com.commend.diplomarbeit.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room") // This means URL's start with /room (after Application path)
public class RoomController {

    // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    @Autowired
    private RoomRepository roomRepository;

    @PostMapping // Map ONLY POST Requests
    public Room create(@RequestBody Room room) {
        return roomRepository.save(room);
    }

    @GetMapping // Zeigt alle Räume an
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @GetMapping("{id}")
    public Room findById(@PathVariable int id) throws InvalidConfigurationPropertyValueException {
        return roomRepository.findById(id).orElseThrow(() -> new InvalidConfigurationPropertyValueException("id", id, "Not found"));
    }

    // Mit diesem PutMapping können Änderungen an den Raumdaten vorgenommen werden
    @PutMapping("{id}")
    public Room update(@PathVariable int id, @RequestBody Room room) throws InvalidConfigurationPropertyValueException {

        Room r = roomRepository.findById(id).orElseThrow(() -> new InvalidConfigurationPropertyValueException("id", id, "Not found"));

        r.setNumber(room.getNumber());
        r.setMaxOccupancy(room.getMaxOccupancy());
        r.setPatients(room.getPatients());

        return roomRepository.save(r);
    }

    // Hier werden die Daten des Raumes mittels Zugriff per Raum ID gelöscht
    @DeleteMapping("{id}")
    public Object delete(@PathVariable int id) {
        roomRepository.deleteById(id);
        return ResponseEntity.noContent();
    }

}
