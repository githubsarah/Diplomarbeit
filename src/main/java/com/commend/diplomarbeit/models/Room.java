package com.commend.diplomarbeit.models;

public class Room {
    private final long number;
    private final long id;
    private final Patient patient;



    public Room(long number, long id, Patient patient){
        this.number = number;
        this.id = id;
        this.patient = patient;
    }


    public long getNumber(){
        return number;
    }

    public long getId(){
        return id;
    }

    public Patient getPatient(){
        return patient;
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
