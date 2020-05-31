package com.nodir.csv;


import com.nodir.entity.Seats;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeatsCSV {

    private static String CSV_FILE = "airtrans/seats.csv";
    private static String CSV_SPLIT_BY = ",";

    public List<Seats> getSeatsFromCSV() {

        String aircraftCode;
        String seatNo;
        String fareConditions;

        String line = "";

        List<Seats> seats = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {

            Seats seat;
            while ((line = br.readLine()) != null) {

                String[] attr = line.split(CSV_SPLIT_BY);

                aircraftCode = attr[0];
                seatNo = attr[1];
                fareConditions = attr[2];
                seat = new Seats(aircraftCode, seatNo, fareConditions);

                seats.add(seat);
            }

        } catch (IOException e) {
            System.out.println("Не получилось считать файл:" + CSV_FILE + "\n" + e.getLocalizedMessage());
            return new ArrayList<>();
        }

        return seats;

    }

}
