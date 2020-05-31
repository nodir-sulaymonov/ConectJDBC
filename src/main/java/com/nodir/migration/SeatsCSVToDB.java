package com.nodir.migration;

import com.nodir.csv.SeatsCSV;
import com.nodir.entity.Seats;
import com.nodir.repository.SeatsRepository;

import java.util.List;

public class SeatsCSVToDB {
    SeatsRepository seatsRepository = new SeatsRepository();
    SeatsCSV seatsCSV = new SeatsCSV();

    public boolean migrate() {

        boolean result = true;
        List<Seats> seats = seatsCSV.getSeatsFromCSV();

        for (Seats seat : seats) {
            result = result && seatsRepository.insert(seat);
        }

        return result;
    }

}
