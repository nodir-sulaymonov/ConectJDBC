package com.nodir.repository;


import com.nodir.dao.AirportsDAO;

import com.nodir.entity.Airports;

public class AirportsRepository {
    private AirportsDAO airportsDAO = new AirportsDAO();

    public boolean insert(Airports airports)
    {
        return airportsDAO.insert(airports);
    }

}
