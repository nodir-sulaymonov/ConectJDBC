package com.nodir.dao;

import com.nodir.connection.DataSource;
import com.nodir.entity.Bookings;
import com.nodir.entity.Seats;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookingsDAO {

    DataSource dataSource;

    public boolean insert(Bookings booking) {

        String sql = "INSERT INTO bookings(book_ref, book_date, total_amount) VALUES(?, ?, ?);";


        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, booking.getBookRef());
            ps.setTimestamp(2, booking.getBookDate());
            ps.setDouble(3, booking.getTotalAmount());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Не получилось добавить " + booking + " в бд. Причина: \n" + e);
            return false;
        }
        return true;
    }
}
