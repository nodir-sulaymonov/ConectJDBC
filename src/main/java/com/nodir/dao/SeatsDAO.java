package com.nodir.dao;

import com.nodir.connection.DataSource;
import com.nodir.entity.Seats;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SeatsDAO {
    DataSource dataSource;


    public boolean insert(Seats seat) {

        String sql = "INSERT INTO seats(aircraft_code, seat_no, fare_conditions) VALUES(?, ?, ?);";


        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, seat.getAircraftCode());
            ps.setString(2, seat.getSeatNo());
            ps.setString(3, seat.getFareConditions());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Не получилось добавить " + seat + "в бд. Причина: \n" + e);
            return false;
        }
        return true;
    }
}


