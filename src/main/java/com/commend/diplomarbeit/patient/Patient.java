package com.commend.diplomarbeit.patient;

import com.commend.diplomarbeit.room.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//Getter und setter werden automatisch gebildet, können aber im Controller nicht aufgerufen werden
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue
    private Integer id;

    //    @JsonManagedReference
    @ManyToOne
    private Room room;

    private String fn;
    private String ln;
    private String content;
    private String drug;
    private String therapyTime;
    private String mainCaregiver;
}
