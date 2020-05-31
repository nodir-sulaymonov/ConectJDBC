package com.nodir.dao;

import com.nodir.connection.DataSource;
import com.nodir.entity.Tickets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TicketsDAO {
    DataSource dataSource;

        public boolean insert(Tickets ticket){
            String sql = "INSERT INTO tickets(ticket_no, book_ref, passenger_id, passanger_name, contact_data) VALUES(?, ?, ?, ?, ?::JSON);";


            try (Connection connection = dataSource.getConnection();
                 PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setString(1, ticket.getTicketNo());
                ps.setString(2, ticket.getBookRef());
                ps.setString(3, ticket.getPassengerId());
                ps.setString(4, ticket.getPassengerName());
                ps.setString(5, ticket.getContactData());

                ps.executeUpdate();
            }
            catch (SQLException e){
                System.out.println("Не получилось добавить " + ticket + "в бд. Причина: \n" + e);
                return false;
            }
            return true;
        }
}
