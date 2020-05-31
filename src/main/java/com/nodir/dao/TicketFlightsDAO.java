package com.nodir.dao;

import com.nodir.connection.DataSource;
import com.nodir.entity.Bookings;
import com.nodir.entity.TicketFlights;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TicketFlightsDAO {
    DataSource dataSource;

    public boolean insert(TicketFlights ticketFlight) {

        String sql = "INSERT INTO ticket_flights(ticket_no, flight_id, fare_conditions, amount) VALUES(?, ?, ?, ?);";


        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

          ps.setString(1, ticketFlight.getTicketNo());
          ps.setInt(2, ticketFlight.getFlightId());
          ps.setString(3, ticketFlight.getFareConditions());
          ps.setDouble(4, ticketFlight.getAmount());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Не получилось добавить " + ticketFlight + " в бд. Причина: \n" + e);
            return false;
        }
        return true;
    }
}
