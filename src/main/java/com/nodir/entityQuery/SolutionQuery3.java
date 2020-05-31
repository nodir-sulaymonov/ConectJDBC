package com.nodir.entityQuery;

public class SolutionQuery3 {
    private String city;
    private String arrivalPoint;
    private int duration;

    public SolutionQuery3(String city, String arrivalPoint, int duration) {
        this.city = city;
        this.arrivalPoint = arrivalPoint;
        this.duration = duration;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArrivalPoint() {
        return arrivalPoint;
    }

    public void setArrivalPoint(String arrivalPoint) {
        this.arrivalPoint = arrivalPoint;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
