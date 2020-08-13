package com.commend.diplomarbeit.patient;

import com.commend.diplomarbeit.room.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Room room;

    private String fn;
    private String ln;
    private String content;
    private String medikamente;
    private String therapiezeit;
    private String hauptBetreuer;
}
