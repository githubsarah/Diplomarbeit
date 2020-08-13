package com.commend.diplomarbeit.room;

import com.commend.diplomarbeit.patient.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity// This tells Hibernate to make a table out of this class
public class Room {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany
    private List<Patient> patient;

  //  private int patientid;
    private long number;
    private long maxBelegung;
}
