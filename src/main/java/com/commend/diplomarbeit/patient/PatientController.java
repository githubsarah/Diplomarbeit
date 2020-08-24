package com.commend.diplomarbeit.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patient") // This means URL's start with /room (after Application path)
public class PatientController {

    // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    @Autowired
    private PatientRepository patientRepository;

    /**
     *
     * @param patient
     * @return
     */
    @PostMapping // Map ONLY POST Requests
    public Patient create(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    /**
     *
     * @return
     */
    @GetMapping // Zeigt alle Räume an
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     * @throws InvalidConfigurationPropertyValueException
     */
    //Gibt den Patienten der jeweiligen ID zurück
    @GetMapping("{id}")
    public Patient findById(@PathVariable int id) throws InvalidConfigurationPropertyValueException {
        return patientRepository.findById(id).orElseThrow(() -> new InvalidConfigurationPropertyValueException("id", id, "Not found"));
    }

    /**
     *
     * @param id
     * @return
     */
    // Mit diesem RequestMapping können die Daten der Räume der jeweiligen Patienten per id abgerufen werden
    @GetMapping("room/{room_id}")
    public Patient getPatientByRoomId(@PathVariable("room_id") int id) {
        return patientRepository.findByRoomId(id);
    }

    /**
     *
     * @param id
     * @param patient
     * @return
     * @throws InvalidConfigurationPropertyValueException
     */
    // Ändern von Patienteninfos
    @PutMapping("{id}")
    public Patient update(@PathVariable int id, @RequestBody Patient patient) throws InvalidConfigurationPropertyValueException {

        Patient p = patientRepository.findById(id).orElseThrow(() -> new InvalidConfigurationPropertyValueException("id", id, "Not found"));

        p.setFn(patient.getFn());
        p.setLn(patient.getLn());
        p.setContent(patient.getContent());
        p.setDrug(patient.getDrug());
        p.setTherapyTime(patient.getTherapyTime());
        p.setMainCaregiver(patient.getMainCaregiver());
        p.setRoom(patient.getRoom());

        return patientRepository.save(p);
    }

    /**
     *
     * @param id
     * @return
     */
    // Mit diesem Befehl kann man die Daten eines Patienten über einen ID-Zugriff ganz einfach löschen
    @DeleteMapping("{id}")
    public Object deletePatient(@PathVariable int id) {
        patientRepository.deleteById(id);
        return ResponseEntity.noContent();
    }
}

