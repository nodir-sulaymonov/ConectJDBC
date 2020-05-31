package com.nodir.repository;

import com.nodir.dao.BookingsDAO;
import com.nodir.entity.Bookings;

public class BookingsRepository {

    private BookingsDAO bookingsDAO = new BookingsDAO();

    public boolean insert(Bookings bookings){
         return bookingsDAO.insert(bookings);
    }

}
