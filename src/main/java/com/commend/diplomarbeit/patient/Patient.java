package com.commend.diplomarbeit.patient;

import com.commend.diplomarbeit.room.Room;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data   //Getter und setter werden automatisch gebildet, können aber im Controller nicht aufgerufen werden
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue
    private Integer id;

    @JsonManagedReference
    @ManyToOne
    private Room room;

    private String fn;
    private String ln;
    private String content;
    private String medikamente;
    private String therapiezeit;
    private String hauptBetreuer;

   /* public String getFn(){
        return fn;
    }
    public void setFn(String fn){
        this.fn = fn;
    }

    public String getLn(){
        return ln;
    }
    public void setLn(String ln){
        this.ln = ln;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMedikamente(){
        return medikamente;
    }
    public void setMedikamente(String medikamente) {
        this.medikamente = medikamente;
    }

    public String getTherapiezeit() {
        return therapiezeit;
    }
    public void setTherapiezeit(String therapiezeit) {
        this.therapiezeit = therapiezeit;
    }

    public String getHauptBetreuer() {
        return hauptBetreuer;
    }
    public void setHauptBetreuer(String hauptBetreuer) {
        this.hauptBetreuer = hauptBetreuer;
    }

    */
}
