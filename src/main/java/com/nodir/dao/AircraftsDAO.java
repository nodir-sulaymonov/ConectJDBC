package com.nodir.dao;

import com.nodir.connection.DataSource;
import com.nodir.entity.Aircrafts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AircraftsDAO {
    DataSource dataSource;

    public boolean insert(Aircrafts aircraft) {

        String sql = "INSERT INTO aircrafts(aircraft_code, model, range) VALUES(?, ?::JSON, ?);";


        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, aircraft.getAircraftCode());
            ps.setString(2, aircraft.getModel());
            ps.setInt(3, aircraft.getRange());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Не получилось добавить " + aircraft + " в бд. Причина: \n" + e);
            return false;
        }
        return true;
    }
}
