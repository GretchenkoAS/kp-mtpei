package com.nyha.webfinal.model.entity;

import java.time.LocalDate;

public class Ticket extends Entity {
    private Trip trip;
    private Passenger passenger;
    private int seat;
    private LocalDate date;
    private double price;

    public Ticket() {
    }

    public Ticket(Trip trip, Passenger passenger, int seat, LocalDate date, double price) {
        this.trip = trip;
        this.passenger = passenger;
        this.seat = seat;
        this.date = date;
        this.price = price;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ticket ticket = (Ticket) o;
        if (trip == null) {
            if (ticket.trip != null) {
                return false;
            }
        } else if (!trip.equals(ticket.trip)) {
            return false;
        }
        if (passenger == null) {
            if (ticket.passenger != null) {
                return false;
            }
        } else if (!passenger.equals(ticket.passenger)) {
            return false;
        }
        if (seat != ticket.seat) {
            return false;
        }
        if (date == null) {
            if (ticket.date != null) {
                return false;
            }
        } else if (!date.equals(ticket.date)) {
            return false;
        }
        if (price != ticket.price) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((trip == null) ? 0 : trip.hashCode());
        result = prime * result + ((passenger == null) ? 0 : passenger.hashCode());
        result = prime * result + seat;
        result = prime * result + (int)price;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        return result;
    }

    //    private Trip trip;
//    private Passenger passenger;
//    private int seat;
//    private LocalDate date;
//    private double price;
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ticket{");
        sb.append(trip);
        sb.append(", ").append(passenger);
        sb.append(", seat='").append(seat).append('\'');
        sb.append(", date='").append(date).append('\'');
        sb.append(", price='").append(price);
        sb.append('}');
        return sb.toString();
    }
}
