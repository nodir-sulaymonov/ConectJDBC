package com.nodir.csv;


import com.nodir.entity.Bookings;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;

public class BookingsCSV {

    private static String CSV_FILE = "airtrans/bookings.csv";
    private static String CSV_SPLIT_BY = ",";

    public List<Bookings> getBookingsFromCSV() {

        String bookRef;
        Timestamp bookDate;
        String stringDate;
        double totalAmount;


        String format = "yyyy-MM-dd HH:mm:ssZ";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);


        String line = "";

        List<Bookings> bookings = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {

            Bookings booking;
            while ((line = br.readLine()) != null) {

                String[] attr = line.split(CSV_SPLIT_BY);

                bookRef = attr[0];
                stringDate = attr[1] + "00";
                totalAmount = Double.parseDouble(attr[2]);

                LocalDateTime date = LocalDateTime.parse(stringDate, formatter);

                bookDate = Timestamp.valueOf(date);


                booking = new Bookings(bookRef, bookDate, totalAmount);

                bookings.add(booking);
            }

        } catch (IOException e) {
            System.out.println("Не получилось считать файл:" + CSV_FILE + "\n" + e.getLocalizedMessage());
            return new ArrayList<>();
        }

        return bookings;

    }

}
