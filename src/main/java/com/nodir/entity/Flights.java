package com.nodir.entity;

import java.sql.Timestamp;

public class Flights {
        private int flightId;
        private String flightNo;
        private Timestamp scheduledDeparture;
        private Timestamp scheduledArrival;
        private String departureAirport;
        private String arrivalAirport;
        private String status;
        private String aircraftCode;
        private Timestamp actualDeparture;
        private Timestamp actualArrival;

        public Flights(int flightId, String flightNo, Timestamp scheduledDeparture, Timestamp scheduledArrival, String departureAirport, String arrivalAirport, String status, String aircraftCode, Timestamp actualDeparture, Timestamp actualArrival) {
                this.flightId = flightId;
                this.flightNo = flightNo;
                this.scheduledDeparture = scheduledDeparture;
                this.scheduledArrival = scheduledArrival;
                this.departureAirport = departureAirport;
                this.arrivalAirport = arrivalAirport;
                this.status = status;
                this.aircraftCode = aircraftCode;
                this.actualDeparture = actualDeparture;
                this.actualArrival = actualArrival;
        }

        public int getFlightId() {
                return flightId;
        }

        public void setFlightId(int flightId) {
                this.flightId = flightId;
        }

        public String getFlightNo() {
                return flightNo;
        }

        public void setFlightNo(String flightNo) {
                this.flightNo = flightNo;
        }

        public Timestamp getScheduledDeparture() {
                return scheduledDeparture;
        }

        public void setScheduledDeparture(Timestamp scheduledDeparture) {
                this.scheduledDeparture = scheduledDeparture;
        }

        public Timestamp getScheduledArrival() {
                return scheduledArrival;
        }

        public void setScheduledArrival(Timestamp scheduledArrival) {
                this.scheduledArrival = scheduledArrival;
        }

        public String getDepartureAirport() {
                return departureAirport;
        }

        public void setDepartureAirport(String departureAirport) {
                this.departureAirport = departureAirport;
        }

        public String getArrivalAirport() {
                return arrivalAirport;
        }

        public void setArrivalAirport(String arrivalAirport) {
                this.arrivalAirport = arrivalAirport;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }

        public String getAircraftCode() {
                return aircraftCode;
        }

        public void setAircraftCode(String aircraftCode) {
                this.aircraftCode = aircraftCode;
        }

        public Timestamp getActualDeparture() {
                return actualDeparture;
        }

        public void setActualDeparture(Timestamp actualDeparture) {
                this.actualDeparture = actualDeparture;
        }

        public Timestamp getActualArrival() {
                return actualArrival;
        }

        public void setActualArrival(Timestamp actualArrival) {
                this.actualArrival = actualArrival;
        }
}
