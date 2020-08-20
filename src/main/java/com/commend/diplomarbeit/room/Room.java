package com.commend.diplomarbeit.room;

import com.commend.diplomarbeit.patient.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor // Konstruktor wird ohne Inhalte erstellt
@AllArgsConstructor // Erstellt einen Konstruktor für alle Integer
@Entity// This tells Hibernate to make a table out of this class
public class Room {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany
    private List<Patient> patients;

    private long number;
    private long maxOccupancy;
}
