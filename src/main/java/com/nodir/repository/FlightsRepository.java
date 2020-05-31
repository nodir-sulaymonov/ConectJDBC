package com.nodir.repository;

import com.nodir.dao.FlightsDAO;
import com.nodir.entity.Flights;

public class FlightsRepository {
        private FlightsDAO flightsDAO = new FlightsDAO();

        public boolean insert(Flights flight){
            return flightsDAO.inserts(flight);
        }
}
