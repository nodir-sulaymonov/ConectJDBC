package com.nodir.csv;

import com.nodir.entity.Aircrafts;
import com.nodir.entity.Tickets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TicketsCSV {
    private static String CSV_FILE = "airtrans/tickets.csv";
    private static String CSV_SPLIT_BY = ",";

    public List<Tickets> getTicketsFromCSV() {

         String ticketNo;
         String bookRef;
         String passengerId;
         String passengerName;
         String contactData;

        String line = "";

        List<Tickets> tickets = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {

            Tickets ticket;
            while ((line = br.readLine()) != null) {

                String[] attr = line.split(CSV_SPLIT_BY);

                ticketNo = attr[0];
                bookRef = attr[1];
                passengerId = attr[2];
                passengerName = attr[3];
                contactData = "";
                for (int i = 4; i < attr.length; i++){
                    if(i == attr.length - 1){
                        contactData += attr[i];
                    }
                    else {
                        contactData += attr[i] + ",";

                    }
                }

                if (contactData.length() - 1 > 1) {
                    contactData = contactData.replace("\"\"", "\"");
                    contactData = contactData.substring(1, contactData.length() - 1);
                }

                ticket = new Tickets(ticketNo, bookRef, passengerId,passengerName,contactData);


                tickets.add(ticket);
            }

        } catch (IOException e) {
            System.out.println("Не получилось считать файл:" + CSV_FILE + "\n" + e.getLocalizedMessage());
            return new ArrayList<>();
        }

        return tickets;

    }
}
