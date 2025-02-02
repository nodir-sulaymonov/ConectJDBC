package com.nodir.entity;

public class BoardingPasses {
    private String ticketNo;
    private int flightId;
    private int boardingNo;
    private String seatNo;

    public BoardingPasses(String ticketNo, int flightId, int boardingNo, String seatNo) {
        this.ticketNo = ticketNo;
        this.flightId = flightId;
        this.boardingNo = boardingNo;
        this.seatNo = seatNo;
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

    public int getBoardingNo() {
        return boardingNo;
    }

    public void setBoardingNo(int boardingNo) {
        this.boardingNo = boardingNo;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }
}
