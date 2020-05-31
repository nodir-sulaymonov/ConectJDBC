package com.nodir.migration;


import com.nodir.csv.AirportsCSV;

import com.nodir.entity.Airports;

import com.nodir.repository.AirportsRepository;

import java.util.List;

public class AirportsCSVToDB {
    AirportsRepository airportsRepository = new AirportsRepository();
    AirportsCSV airportsCSV = new AirportsCSV();

    public boolean migrate() {

        boolean result = true;
        List<Airports> airports = airportsCSV.getAirportsFromCSV();

        for (Airports airport : airports) {
            result = result && airportsRepository.insert(airport);
        }

        return result;
    }

}
