package com.nodir.entity;

public class TicketFlights {

    private String ticketNo;
    private int flightId;
    private String fareConditions;
    private Double amount;

    public TicketFlights(String ticketNo, int flightId, String fareConditions, Double amount) {
        this.ticketNo = ticketNo;
        this.flightId = flightId;
        this.fareConditions = fareConditions;
        this.amount = amount;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFareConditions() {
        return fareConditions;
    }

    public void setFareConditions(String fareConditions) {
        this.fareConditions = fareConditions;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
