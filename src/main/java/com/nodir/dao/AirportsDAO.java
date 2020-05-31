package com.nodir.dao;

import com.nodir.connection.DataSource;
import com.nodir.entity.Aircrafts;
import com.nodir.entity.Airports;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AirportsDAO {
    DataSource dataSource;

    public boolean insert(Airports airport) {

        String sql = "INSERT INTO airports(airport_code, airport_name, city, coordinates, timezone) VALUES(?, ?::JSON, ?::JSON, POINT(?, ?), ?);";


        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, airport.getAirportCode());
            ps.setString(2, airport.getAirportName());
            ps.setString(3, airport.getCity());
            ps.setDouble(4, airport.getPointX());
            ps.setDouble(5, airport.getPointY());
            ps.setString(6, airport.getTimezone());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Не получилось добавить " + airport + " в бд. Причина: \n" + e);
            return false;
        }
        return true;
    }
}
