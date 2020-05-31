package com.nodir.repository;

import com.nodir.dao.TicketFlightsDAO;
import com.nodir.entity.TicketFlights;

public class TicketFlightsRepository {

    private TicketFlightsDAO ticketFlightsDAO = new TicketFlightsDAO();

    public boolean insert(TicketFlights ticketFlights){
        return ticketFlightsDAO.insert(ticketFlights);
    }
}
