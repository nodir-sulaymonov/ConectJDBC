package com.nodir.csv;

import com.nodir.entity.BoardingPasses;
import com.nodir.entity.TicketFlights;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BoardingPassesCSV {

    private static String CSV_FILE = "airtrans/boarding_passes.csv";
    private static String CSV_SPLIT_BY = ",";

    public List<BoardingPasses> getBoardingPassesFromCSV() {

        String ticketNo;
        int flightId;
        int boardingNo;
        String seatNo;


        String line = "";

        List<BoardingPasses> boardingPasses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {

            BoardingPasses boardingPasse;
            while ((line = br.readLine()) != null) {

                String[] attr = line.split(CSV_SPLIT_BY);

                ticketNo = attr[0];
                flightId = Integer.parseInt(attr[1]);
                boardingNo = Integer.parseInt(attr[2]);
                seatNo = attr[3];

                boardingPasse = new BoardingPasses(ticketNo, flightId, boardingNo, seatNo);

                boardingPasses.add(boardingPasse);
            }

        } catch (IOException e) {
            System.out.println("Не получилось считать файл:" + CSV_FILE + "\n" + e.getLocalizedMessage());
            return new ArrayList<>();
        }

        return boardingPasses;
    }

}
