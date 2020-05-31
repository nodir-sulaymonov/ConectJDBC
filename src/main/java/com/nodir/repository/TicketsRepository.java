package com.nodir.repository;

import com.nodir.dao.TicketsDAO;
import com.nodir.entity.Aircrafts;
import com.nodir.entity.Tickets;

public class TicketsRepository {
    private TicketsDAO ticketsDAO = new TicketsDAO();

    public boolean insert(Tickets tickets)
    {
        return ticketsDAO.insert(tickets);
    }
}
