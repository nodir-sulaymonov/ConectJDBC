package com.nodir.dao;

import com.nodir.connection.DataSource;
import com.nodir.entity.Flights;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FlightsDAO {

    DataSource dataSource;

    public boolean inserts(Flights flight){
        String sql = "INSERT INTO flights(flight_id, flight_no, scheduled_departure, scheduled_arrival, departure_airport, arrival_airport, status, aircraft_code, actual_departure, actual_arrival) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, flight.getFlightId());
            ps.setString(2, flight.getFlightNo());
            ps.setTimestamp(3, flight.getScheduledDeparture());
            ps.setTimestamp(4, flight.getScheduledArrival());
            ps.setString(5, flight.getDepartureAirport());
            ps.setString(6, flight.getArrivalAirport());
            ps.setString(7, flight.getStatus());
            ps.setString(8, flight.getAircraftCode());
            ps.setTimestamp(9, flight.getActualDeparture());
            ps.setTimestamp(10, flight.getActualArrival());

            ps.executeUpdate();
        }
        catch (SQLException e){
            System.out.println("Не получилось добавить " + flight + "в бд. Причина: \n" + e);
            return false;
        }
        return true;
    }
}
