package com.nodir.migration;

import com.nodir.csv.AircraftsCSV;
import com.nodir.entity.Aircrafts;
import com.nodir.repository.AircraftsRepository;

import java.util.List;

public class AircraftsCSVToDB {
    AircraftsRepository aircraftsRepository = new AircraftsRepository();
    AircraftsCSV aircraftsCSV = new AircraftsCSV();

    public boolean migrate() {

        boolean result = true;
        List<Aircrafts> aircrafts = aircraftsCSV.getAircraftsFromCSV();

        for (Aircrafts aircraft : aircrafts) {
            result = result && aircraftsRepository.insert(aircraft);
        }

        return result;
    }

}
