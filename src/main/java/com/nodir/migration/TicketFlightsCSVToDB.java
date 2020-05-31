package com.nodir.migration;

import com.nodir.csv.TicketFlightsCSV;
import com.nodir.entity.TicketFlights;
import com.nodir.repository.TicketFlightsRepository;


import java.util.List;

public class TicketFlightsCSVToDB {

    TicketFlightsRepository ticketFlightsRepository = new TicketFlightsRepository();
    TicketFlightsCSV ticketFlightsCSV = new TicketFlightsCSV();

    public  boolean migrate(){
        boolean result = true;
        List<TicketFlights> ticketFlights = ticketFlightsCSV.getTicketFlightsFromCSV();

        for (TicketFlights ticketFlight : ticketFlights) {
            result = result && ticketFlightsRepository.insert(ticketFlight);
        }

        return result;
    }
}
