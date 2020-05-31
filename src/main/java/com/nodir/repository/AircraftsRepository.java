package com.nodir.repository;

import com.nodir.dao.AircraftsDAO;
import com.nodir.entity.Aircrafts;

public class AircraftsRepository {
    private AircraftsDAO aircraftsDAO = new AircraftsDAO();

    public boolean insert(Aircrafts aircrafts)
    {
        return aircraftsDAO.insert(aircrafts);
    }

}
