package com.nodir.migration;

import com.nodir.csv.BookingsCSV;
import com.nodir.entity.Aircrafts;
import com.nodir.entity.Bookings;
import com.nodir.repository.BookingsRepository;

import java.util.List;

public class BookingsCSVToDB {

        BookingsRepository bookingsRepository = new BookingsRepository();
        BookingsCSV bookingsCSV = new BookingsCSV();

        public  boolean migrate(){
            boolean result = true;
            List<Bookings> bookings = bookingsCSV.getBookingsFromCSV();

            for (Bookings booking : bookings) {
                result = result && bookingsRepository.insert(booking);
            }

            return result;
        }
}
