package com.nodir.migration;

import com.nodir.csv.FlightsCSV;
import com.nodir.entity.Flights;
import com.nodir.repository.FlightsRepository;

import java.util.List;

public class FlightsCSVToDB {

    FlightsRepository flightsRepository = new FlightsRepository();
    FlightsCSV flightsCSV = new FlightsCSV();

    public boolean migrate(){
        boolean result = true;
        List<Flights> flights = flightsCSV.getFlightsFromCSV();

        for (Flights flight : flights) {
            result = result && flightsRepository.insert(flight);
        }

        return result;
    }
}
