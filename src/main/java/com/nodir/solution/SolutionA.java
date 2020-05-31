package com.nodir.solution;

import com.nodir.migration.*;

/**
 * Считываем данные с csv и записываем в Postgres
 */

public class SolutionA {

    public void solute() {
        AircraftsCSVToDB aircraftsCSVToDB = new AircraftsCSVToDB();
        SeatsCSVToDB seatsCSVToDB = new SeatsCSVToDB();
        AirportsCSVToDB airportsCSVToDB = new AirportsCSVToDB();
        BookingsCSVToDB bookingsCSVToDB = new BookingsCSVToDB();
        TicketsCSVToDB ticketsCSVToDB = new TicketsCSVToDB();
        FlightsCSVToDB flightsCSVToDB = new FlightsCSVToDB();
        TicketFlightsCSVToDB ticketFlightsCSVToDB = new TicketFlightsCSVToDB();
        BoardingPassesCSVToDB boardingPassesCSVToDB = new BoardingPassesCSVToDB();


        aircraftsCSVToDB.migrate();
        seatsCSVToDB.migrate();
        airportsCSVToDB.migrate();
        bookingsCSVToDB.migrate();
        ticketsCSVToDB.migrate();
        flightsCSVToDB.migrate();
        ticketFlightsCSVToDB.migrate();
        boardingPassesCSVToDB.migrate();
    }

}
