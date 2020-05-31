package com.nodir.csv;


import com.nodir.entity.Bookings;
import com.nodir.entity.TicketFlights;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;

public class TicketFlightsCSV {

    private static String CSV_FILE = "airtrans/ticket_flights.csv";
    private static String CSV_SPLIT_BY = ",";

    public List<TicketFlights> getTicketFlightsFromCSV() {

        String ticketNo;
        int flightId;
        String fareConditions;
        Double amount;


        String line = "";

        List<TicketFlights> ticketFlights = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {

            TicketFlights ticketFlight;
            while ((line = br.readLine()) != null) {

                String[] attr = line.split(CSV_SPLIT_BY);

                ticketNo = attr[0];
                flightId = Integer.parseInt(attr[1]);
                fareConditions = attr[2];
                amount = Double.parseDouble(attr[3]);

                ticketFlight = new TicketFlights(ticketNo, flightId, fareConditions, amount);

                ticketFlights.add(ticketFlight);
            }

        } catch (IOException e) {
            System.out.println("Не получилось считать файл:" + CSV_FILE + "\n" + e.getLocalizedMessage());
            return new ArrayList<>();
        }

        return ticketFlights;

    }

}
