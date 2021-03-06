package com.commend.diplomarbeit.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("room") // This means URL's start with /room (after Application path)
public class RoomController {

    // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    @Autowired
    private RoomRepository roomRepository;

    /**
     * Map ONLY POST Requests
     *
     * @param room Es wird ein Raum Objekt erzeugt
     * @return Der neu erstellte Raum wird zurückgegeben
     */
    @PostMapping
    public Room create(@RequestBody Room room) {
        return roomRepository.save(room);
    }

    /**
     * Zeigt alle Räume an
     *
     * @return Alle in der Datenbank gespeicherten Räume werden zurückgegeben und angezeigt
     */
    @GetMapping
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    /**
     * @param id Über die eingegebene id wird ein Raum herausgefiltert
     * @return Der Raum mit der angegebenen id wird zurückgegeben und angezeigt
     * @throws InvalidConfigurationPropertyValueException This is a configuration property
     */
    @GetMapping("{id}")
    public Room findById(@PathVariable int id) throws InvalidConfigurationPropertyValueException {
        return roomRepository.findById(id).orElseThrow(() -> new InvalidConfigurationPropertyValueException("id", id, "Not found"));
    }

    /**
     * Mit diesem PutMapping können Änderungen an den Raumdaten vorgenommen werden
     *
     * @param id Über die id wird ein Raum ausgewählt der upgedatet werden soll
     * @param room Die neuen daten werden über ein JSON Objekt angegeben
     * @return Der veränderte Raum wird zurückgegeben
     * @throws InvalidConfigurationPropertyValueException This is a configuration property
     */
    @PutMapping("{id}")
    public Room update(@PathVariable int id, @RequestBody Room room) throws InvalidConfigurationPropertyValueException {

        Room r = roomRepository.findById(id).orElseThrow(() -> new InvalidConfigurationPropertyValueException("id", id, "Not found"));

        r.setNumber(room.getNumber());
        r.setMaxOccupancy(room.getMaxOccupancy());
        r.setPatients(room.getPatients());

        return roomRepository.save(r);
    }

    /**
     * Hier werden die Daten des Raumes mittels Zugriff per Raum ID gelöscht
     *
     * @param id Über die id wird ein Raum ausgewählt der gelöscht werden soll
     * @return Es wird eine Http Statusmeldung ausgegeben
     */
    @DeleteMapping("{id}")
    public Object delete(@PathVariable int id) {
        roomRepository.deleteById(id);
        return ResponseEntity.noContent();
    }
}