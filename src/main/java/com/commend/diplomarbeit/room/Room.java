package com.commend.diplomarbeit.room;

import com.commend.diplomarbeit.patient.Patient;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor // Konstruktor wird ohne Inhalte erstellt
@AllArgsConstructor // Erstellt einen Konstruktor für alle Integer
@Entity// This tells Hibernate to make a table out of this class
public class Room {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonBackReference
    @OneToMany(mappedBy = "room")
    private List<Patient> patient;

    //  private int patientid;
    private long number;
    private long maxBelegung;

  /*  public long getNumber() {
        return number;
    }
    public void setNumber(long number) {
        this.number = number;
    }

    public long getMaxBelegung() {
        return maxBelegung;
    }
    public void setMaxBelegung(long maxBelegung) {
        this.maxBelegung = maxBelegung;
    }

   */





}
