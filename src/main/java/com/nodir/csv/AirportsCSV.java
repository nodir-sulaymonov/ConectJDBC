package com.nodir.csv;

import com.nodir.entity.Airports;
import com.nodir.entity.Bookings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirportsCSV {

    private static String CSV_FILE = "airtrans/airports_data.csv";
    private static String CSV_SPLIT_BY = ",";

    public List<Airports> getAirportsFromCSV() {

        String airportCode;
        String airportName;
        String city;
        double pointX;
        String firstPoint;
        String secondPoint;
        double pointY;
        String timezone;


        String line = "";

        List<Airports> airports = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {

            Airports airport;
            while ((line = br.readLine()) != null) {

                String[] attr = line.split(CSV_SPLIT_BY);

                airportCode = attr[0];

                airportName = attr[1] + "," + attr[2];

                if (airportName.length() - 1 > 1) {
                    airportName = airportName.replace("\"\"", "\"");
                    airportName = airportName.substring(1, airportName.length() - 1);
                }

                city = attr[3] + "," + attr[4];
                if(city.length() -1 > 1){
                    city = city.replace("\"\"", "\"");
                    city = city.substring(1, city.length() -1);
                }


                firstPoint = attr[5];
                secondPoint = attr[6];

                firstPoint = firstPoint.substring(2);
                secondPoint = secondPoint.substring(0, secondPoint.length() - 2);


                pointX = Double.parseDouble(firstPoint);
                pointY = Double.parseDouble(secondPoint);

                timezone = attr[7];

                airport = new Airports(airportCode, airportName, city, pointX, pointY, timezone);

                airports.add(airport);

            }

        } catch (IOException e) {
            System.out.println("Не получилось считать файл:" + CSV_FILE + "\n" + e.getLocalizedMessage());
            return new ArrayList<>();
        }

        return airports;

    }
}
