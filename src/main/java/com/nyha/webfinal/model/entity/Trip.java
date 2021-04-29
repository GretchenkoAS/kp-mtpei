package com.nyha.webfinal.model.entity;

import java.time.LocalTime;

public class Trip extends Entity{
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private Train train;
    private Station departureStation;
    private Station arrivalStation;

    public Trip() {
    }

    public Trip(LocalTime departureTime, LocalTime arrivalTime, Train train, Station departureStation, Station arrivalStation) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.train = train;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Station getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(Station departureStation) {
        this.departureStation = departureStation;
    }

    public Station getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(Station arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Trip trip = (Trip) o;
        if (departureTime == null) {
            if (trip.departureTime != null) {
                return false;
            }
        } else if (!departureTime.equals(trip.departureTime)) {
            return false;
        }
        if (arrivalTime == null) {
            if (trip.arrivalTime != null) {
                return false;
            }
        } else if (!arrivalTime.equals(trip.arrivalTime)) {
            return false;
        }
        if (train == null) {
            if (trip.train != null) {
                return false;
            }
        } else if (!train.equals(trip.train)) {
            return false;
        }
        if (departureStation == null) {
            if (trip.departureStation != null) {
                return false;
            }
        } else if (!departureStation.equals(trip.departureStation)) {
            return false;
        }
        if (arrivalStation == null) {
            if (trip.arrivalStation != null) {
                return false;
            }
        } else if (!arrivalStation.equals(trip.arrivalStation)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
        result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
        result = prime * result + ((train == null) ? 0 : train.hashCode());
        result = prime * result + ((departureStation == null) ? 0 : departureStation.hashCode());
        result = prime * result + ((arrivalStation == null) ? 0 : arrivalStation.hashCode());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Trip{");
        sb.append("departureTime='").append(departureTime).append('\'');
        sb.append(", arrivalTime='").append(arrivalTime).append('\'');
        sb.append(", ").append(train);
        sb.append(", ").append(departureStation);
        sb.append(", ").append(arrivalStation);
        sb.append('}');
        return sb.toString();
    }
}
