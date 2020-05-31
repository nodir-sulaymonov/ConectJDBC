package com.nodir.entity;


import lombok.AllArgsConstructor;
import lombok.Data;



public class Seats {
    private String aircraftCode;
    private String seatNo;
    private String fareConditions;


    public Seats(String aircraftCode, String seatNo, String fareConditions) {
        this.aircraftCode = aircraftCode;
        this.seatNo = seatNo;
        this.fareConditions = fareConditions;
    }

    public String getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(String aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getFareConditions() {
        return fareConditions;
    }

    public void setFareConditions(String fareConditions) {
        this.fareConditions = fareConditions;
    }
}
