package com.commend.diplomarbeit.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

   /* @ManyToOne
    @JoinColumn(name="room_patientid")
    private Room room;

    */

    private String fn;
    private String ln;
    private String content;



    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getFn(){
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

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String toString(){
        return id + " " + fn + " " + ln + " " + content;
    }

}
