package com.nodir.entity;


public class Aircrafts {
    private String aircraftCode;
    private String model;
    private int range;

    public Aircrafts(String aircraftCode, String model, int range) {
        this.aircraftCode = aircraftCode;
        this.model = model;
        this.range = range;
    }

    public String getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(String aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }


    @Override
    public String toString() {
        return "Aircrafts{" +
                "aircraftCode='" + aircraftCode + '\'' +
                ", model='" + model + '\'' +
                ", range=" + range +
                '}';
    }
}
