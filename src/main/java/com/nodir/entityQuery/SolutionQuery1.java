package com.nodir.entityQuery;

public class SolutionQuery1 {
    private String city;
    private String listAirports;

    public SolutionQuery1(String city, String listAirports) {
        this.city = city;
        this.listAirports = listAirports;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getListAirports() {
        return listAirports;
    }

    public void setListAirports(String listAirports) {
        this.listAirports = listAirports;
    }
}
