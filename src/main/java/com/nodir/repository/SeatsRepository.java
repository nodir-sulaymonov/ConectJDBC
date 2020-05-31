package com.nodir.repository;

import com.nodir.dao.SeatsDAO;
import com.nodir.entity.Seats;

public class SeatsRepository {
    private SeatsDAO seatsDAO = new SeatsDAO();

    public boolean insert(Seats seats){
        return seatsDAO.insert(seats);
    }


}
