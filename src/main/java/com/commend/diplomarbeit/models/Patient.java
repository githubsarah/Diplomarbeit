package com.commend.diplomarbeit.models;

public class Patient {
    private final long patientid;
    private final String vn;
    private final String ln;
    private final String content;

    public Patient(long patientid, String vn, String ln, String content){
        this.patientid = patientid;
        this.vn = vn;
        this.ln = ln;
        this.content = content;
    }

    public long getPatientid(){
        return patientid;
    }

    public String getVn(){
        return vn;
    }

    public String getLn(){
        return ln;
    }

    public String getContent(){
        return content;
    }

    public String toString(){
        return patientid + " " + vn + " " + ln + " " + content;
    }

}
