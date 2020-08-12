package com.commend.diplomarbeit.models;

import javax.persistence.*;
import java.util.List;

@Entity// This tells Hibernate to make a table out of this class
public class Room {

     @Id
     @GeneratedValue(strategy= GenerationType.AUTO)
     private Integer id;
     private Integer patientid;

    /*@OneToMany(mappedBy = "patient")
    private List<Patient> patients;

     */


    private long number;





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

    public Integer getPatientid(){
        return patientid;
    }

    public void setPatientid(Integer patientid){
        this.patientid = patientid;
    }

    public long getNumber(){
        return number;
    }

    public void setNumber(long number){
        this.number = number;
    }

   /* public Patient getPatient(){
        return patient;
    }

    public void setPatient(Patient patient){
        this.patient = patient;
    }

    */

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", id=" + patientid;
    }
}
