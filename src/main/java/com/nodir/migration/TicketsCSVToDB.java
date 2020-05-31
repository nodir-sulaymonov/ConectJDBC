package com.nodir.migration;

import com.nodir.csv.TicketsCSV;
import com.nodir.entity.Tickets;
import com.nodir.repository.TicketsRepository;

import java.util.List;

public class TicketsCSVToDB {
    TicketsRepository ticketsRepository = new TicketsRepository();
    TicketsCSV ticketsCSV = new TicketsCSV();

    public boolean migrate(){
        boolean result = true;
        List<Tickets> tickets = ticketsCSV.getTicketsFromCSV();

        for (Tickets ticket: tickets){
            result = result && ticketsRepository.insert(ticket);
        }

        return result;
    }



}
