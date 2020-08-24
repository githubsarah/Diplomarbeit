package com.commend.diplomarbeit.patient;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PatientRepository extends CrudRepository<Patient, Integer> {

    /**
     *
     * @param room_id
     * @return
     */
    Patient findByRoomId(int room_id);

    @Override
    List<Patient> findAll();
}
