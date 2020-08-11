package com.commend.diplomarbeit.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Room {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private long number;
    private Patient patient;



    /*public Room(long number, long id, Patient patient){
        this.number = number;
        this.id = id;
        this.patient = patient;
    }*/

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public long getNumber(){
        return number;
    }

    public void setNumber(long number){
        this.number = number;
    }

    public Patient getPatient(){
        return patient;
    }

    public void setPatient(Patient patient){
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", id=" + id +
                patient.toString() +
                '}';
    }
}
