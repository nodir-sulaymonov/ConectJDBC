package com.nodir.entity;

public class Airports {
    private String airportCode;
    private String airportName;
    private String city;
    private double pointX;
    private double pointY;
    private String timezone;


    public Airports(String airportCode, String airportName, String city, double pointX, double pointY, String timezone) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.city = city;
        this.pointX = pointX;
        this.pointY = pointY;
        this.timezone = timezone;
    }


    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return "Airports{" +
                "airportCode='" + airportCode + '\'' +
                ", airportName='" + airportName + '\'' +
                ", city='" + city + '\'' +
                ", pointX=" + pointX +
                ", pointY=" + pointY +
                ", timezone='" + timezone + '\'' +
                '}';
    }
}
