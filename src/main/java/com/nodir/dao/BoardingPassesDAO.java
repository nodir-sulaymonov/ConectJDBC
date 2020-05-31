package com.nodir.dao;

import com.nodir.connection.DataSource;
import com.nodir.entity.BoardingPasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardingPassesDAO {
    DataSource dataSource;

    public boolean insert(BoardingPasses boardingPasse) {

        String sql = "INSERT INTO boarding_passes(ticket_no, flight_id, boarding_no, seat_no) VALUES(?, ?, ?, ?);";


        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, boardingPasse.getTicketNo());
            ps.setInt(2, boardingPasse.getFlightId());
            ps.setInt(3, boardingPasse.getBoardingNo());
            ps.setString(4, boardingPasse.getSeatNo());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Не получилось добавить " + boardingPasse + " в бд. Причина: \n" + e);
            return false;
        }
        return true;
    }
}
