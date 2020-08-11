package com.commend.diplomarbeit.models;

public class Patient {
    private long patientid;
    private String fn;
    private String ln;
    private String content;



    public long getPatientid(){
        return patientid;
    }

    public void setPatientid(long id){
        this.patientid = patientid;
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

    public void setContent(){
        this.content = content;
    }

    public String toString(){
        return patientid + " " + fn + " " + ln + " " + content;
    }

}
