package com.nodir.entity;

import java.sql.Timestamp;

public class Bookings {
    private String bookRef;
    private Timestamp bookDate;
    private double totalAmount;

    public Bookings(String bookRef, Timestamp bookDate, double totalAmount) {
        this.bookRef = bookRef;
        this.bookDate = bookDate;
        this.totalAmount = totalAmount;
    }

    public String getBookRef() {
        return bookRef;
    }

    public void setBookRef(String bookRef) {
        this.bookRef = bookRef;
    }

    public Timestamp getBookDate() {
        return bookDate;
    }

    public void setBookDate(Timestamp bookDate) {
        this.bookDate = bookDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
