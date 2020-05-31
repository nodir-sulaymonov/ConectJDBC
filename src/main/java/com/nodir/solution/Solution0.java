package com.nodir.solution;

import com.nodir.connection.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;


/**
 * Инициируем базу данных Postgres
 */

public class Solution0 {
    private DataSource dataSource = new DataSource();

    public void aircrafts(){

        String sql = "CREATE TABLE aircrafts(\n" +
                "    aircraft_code varchar(3) PRIMARY KEY NOT NULL,\n" +
                "    model jsonb NOT NULL,\n" +
                "    range integer NOT NULL\n" +
                ");";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql))
              {
                  ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Запрос не выполнился. Причина: " + ex.getMessage());

        }

    }
    public void airports(){
        String sql = "CREATE TABLE airports(\n" +
                "    airport_code varchar(3) PRIMARY KEY NOT NULL,\n" +
                "    airport_name jsonb NOT NULL,\n" +
                "    city jsonb NOT NULL,\n" +
                "    coordinates point NOT NULL,\n" +
                "    timezone text NOT NULL\n" +
                ");";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Запрос не выполнился. Причина: " + ex.getMessage());

        }
    }

    public void seats(){
        String sql = "CREATE TABLE seats(\n" +
                "    aircraft_code varchar(3) NOT NULL,\n" +
                "    seat_no varchar(3) \tNOT NULL,\n" +
                "    PRIMARY KEY (seat_no, aircraft_code),\n" +
                "    fare_conditions  varchar(10) NOT NULL,\n" +
                "    CONSTRAINT seats_aircrafts1_fkey FOREIGN KEY (aircraft_code)\n" +
                "    REFERENCES aircrafts(aircraft_code) MATCH SIMPLE\n" +
                "    ON UPDATE NO ACTION ON DELETE NO ACTION\n" +
                ");";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Запрос не выполнился. Причина: " + ex.getMessage());

        }
    }
    public void bookings(){
        String sql = "CREATE TABLE bookings(\n" +
                "    book_ref varchar(6) PRIMARY KEY NOT NULL,\n" +
                "    book_date timestamptz NOT NULL,\n" +
                "    total_amount numeric(10,2) NOT NULL\n" +
                ");";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Запрос не выполнился. Причина: " + ex.getMessage());

        }
    }
    public void tickets(){
        String sql = "CREATE TABLE tickets(\n" +
                "    ticket_no varchar(13)PRIMARY KEY  NOT NULL,\n" +
                "    book_ref varchar(6) NOT NULL,\n" +
                "    passenger_id varchar(20)\tNOT NULL,\n" +
                "    passanger_name text NOT NULL,\n" +
                "    contact_data jsonb,\n" +
                "    CONSTRAINT tickets_bookings_id_fkey FOREIGN KEY (book_ref)\n" +
                "    REFERENCES bookings (book_ref) MATCH SIMPLE\n" +
                "    ON UPDATE NO ACTION ON DELETE NO ACTION\n" +
                ");";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Запрос не выполнился. Причина: " + ex.getMessage());

        }
    }

    public void flights(){
        String sql = "CREATE TABLE flights(\n" +
                "    flight_id serial PRIMARY KEY NOT NULL,\n" +
                "    flight_no varchar(6) NOT NULL,\n" +
                "    scheduled_departure timestamptz NOT NULL,\n" +
                "    scheduled_arrival timestamptz NOT NULL,\n" +
                "    departure_airport varchar(3)  NOT NULL, \n" +
                "    arrival_airport varchar(3) NOT NULL,\n" +
                "    status varchar(20) NOT NULL,\n" +
                "    aircraft_code varchar(6) NOT NULL,\n" +
                "    actual_departure timestamptz,\n" +
                "    actual_arrival timestamptz,\n" +
                "    CONSTRAINT flights_aircrafts_id_fkey FOREIGN KEY (aircraft_code)\n" +
                "      REFERENCES aircrafts (aircraft_code) MATCH SIMPLE\n" +
                "      ON UPDATE NO ACTION ON DELETE NO ACTION,\n" +
                "    CONSTRAINT flights_airports1_id_fkey FOREIGN KEY (arrival_airport)\n" +
                "      REFERENCES airports (airport_code)MATCH SIMPLE\n" +
                "      ON UPDATE NO ACTION ON DELETE NO ACTION,\n" +
                "    CONSTRAINT flights_airports2_id_fkey FOREIGN KEY (departure_airport)\n" +
                "      REFERENCES airports (airport_code) MATCH SIMPLE\n" +
                "      ON UPDATE NO ACTION ON DELETE NO ACTION\n" +
                ");";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Запрос не выполнился. Причина: " + ex.getMessage());

        }
    }
    public void ticket_flights(){
        String sql = "CREATE TABLE ticket_flights(\n" +
                "    ticket_no  varchar(13)  NOT NULL, \n" +
                "    flight_id  integer NOT NULL,\n" +
                "    fare_conditions varchar(10) NOT NULL,\n" +
                "    amount numeric(10,2) NOT NULL,\n" +
                "    PRIMARY KEY (ticket_no, flight_id),\n" +
                "    CONSTRAINT ticket_flights_flight_id_fkey FOREIGN KEY (flight_id)\n" +
                "      REFERENCES flights (flight_id) MATCH SIMPLE\n" +
                "      ON UPDATE NO ACTION ON DELETE NO ACTION,\n" +
                "    CONSTRAINT ticket_flights_ticket_no_fkey FOREIGN KEY (ticket_no)\n" +
                "      REFERENCES tickets (ticket_no) MATCH SIMPLE\n" +
                "      ON UPDATE NO ACTION ON DELETE NO ACTION   \n" +
                ")";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Запрос не выполнился. Причина: " + ex.getMessage());

        }
    }

    public void boarding_passes(){
        String sql = "CREATE TABLE boarding_passes(\n" +
                "    ticket_no  varchar(13) NOT NULL, \n" +
                "    flight_id  integer NOT NULL,\n" +
                "    boarding_no integer NOT NULL,\n" +
                "    seat_no  varchar(4) NOT NULL,\n" +
                "    PRIMARY KEY (ticket_no, flight_id),\n" +
                "    CONSTRAINT boarding_passes_ticket_no_fkey FOREIGN KEY (ticket_no)\n" +
                "      REFERENCES tickets (ticket_no) MATCH SIMPLE\n" +
                "      ON UPDATE NO ACTION ON DELETE NO ACTION,\n" +
                "    CONSTRAINT boarding_passes_flight_id_fkey FOREIGN KEY (flight_id)\n" +
                "      REFERENCES flights (flight_id) MATCH SIMPLE\n" +
                "      ON UPDATE NO ACTION ON DELETE NO ACTION\n" +
                ")\n";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Запрос не выполнился. Причина: " + ex.getMessage());

        }
    }

    public void allTables(){
        aircrafts();
        seats();
        airports();
        bookings();
        tickets();
        flights();
        ticket_flights();
        boarding_passes();
    }
}
