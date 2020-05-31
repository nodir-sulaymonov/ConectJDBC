package com.nodir.csv;

import com.nodir.entity.Aircrafts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AircraftsCSV {

    private static String CSV_FILE = "airtrans/aircrafts_data.csv";
    private static String CSV_SPLIT_BY = ",";

    public List<Aircrafts> getAircraftsFromCSV() {

        String aircraftCode;
        String model;
        int range;

        String line = "";

        List<Aircrafts> aircrafts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {

            Aircrafts aircraft;
            while ((line = br.readLine()) != null) {

                String[] attr = line.split(CSV_SPLIT_BY);

                aircraftCode = attr[0];
                model = attr[1] + "," + attr[2];

                if (model.length() - 1 > 1) {
                    model = model.replace("\"\"", "\"");
                    model = model.substring(1, model.length() - 1);
                }

                range = Integer.parseInt(attr[3]);
                aircraft = new Aircrafts(aircraftCode, model, range);


                aircrafts.add(aircraft);
            }

        } catch (IOException e) {
            System.out.println("Не получилось считать файл:" + CSV_FILE + "\n" + e.getLocalizedMessage());
            return new ArrayList<>();
        }

        return aircrafts;

    }

}
