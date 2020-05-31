package com.nodir.csv;

import com.nodir.entity.Flights;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FlightsCSV {

    private static String CSV_FILE = "airtrans/flights.csv";
    private static String CSV_SPLIT_BY = ",";

    public List<Flights> getFlightsFromCSV(){

         int flightId;
         String flightNo;
         Timestamp scheduledDeparture;
         String stringDate1;
         Timestamp scheduledArrival;
         String stringDate2;
         String departureAirport;
         String arrivalAirport;
         String status;
         String aircraftCode;
         Timestamp actualDeparture;
         String stringDate3;
         Timestamp actualArrival;
         String stringDate4;

        String format = "yyyy-MM-dd HH:mm:ssZ";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

         String line = "";

         List<Flights> flights = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {

            Flights flight;
            while ((line = br.readLine()) != null) {

                String[] attr = line.split(CSV_SPLIT_BY);

                flightId = Integer.parseInt(attr[0]);
                flightNo = attr[1];

                stringDate1 = attr[2] + "00";
                LocalDateTime date = LocalDateTime.parse(stringDate1, formatter);
                scheduledDeparture = Timestamp.valueOf(date);

                stringDate2 = attr[3] + "00";
                LocalDateTime date1 = LocalDateTime.parse(stringDate2, formatter);
                scheduledArrival = Timestamp.valueOf(date1);

                departureAirport = attr[4];
                arrivalAirport = attr[5];
                status = attr[6];
                aircraftCode = attr[7];

                if((attr.length - 2) == 8){
                    stringDate3 = attr[8] + "00";
                    LocalDateTime date3 = LocalDateTime.parse(stringDate3, formatter);
                    actualDeparture = Timestamp.valueOf(date3);
                }
                else {
                    actualDeparture= null;
                }

                if((attr.length - 1) == 9){
                    stringDate4 = attr[9] + "00";
                    LocalDateTime date4 = LocalDateTime.parse(stringDate4, formatter);
                    actualArrival = Timestamp.valueOf(date4);
                }
                else {
                    actualArrival=null;
                }



                flight = new Flights(flightId, flightNo, scheduledDeparture,scheduledArrival,departureAirport, arrivalAirport, status, aircraftCode, actualDeparture, actualArrival);


                flights.add(flight);
            }

        } catch (IOException e) {
            System.out.println("Не получилось считать файл:" + CSV_FILE + "\n" + e.getLocalizedMessage());
            return new ArrayList<>();
        }

        return flights;

    }
}
