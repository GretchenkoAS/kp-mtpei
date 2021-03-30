package com.nyha.webfinal.model.dao;

public class ColumnName {

    //Constants for users table
    public static final String USER_ID = "user_id";
    public static final String USER_EMAIL = "email";
    public static final String USER_ROLE = "role";
    public static final String USER_USERNAME = "username";

    //Constants for passengers table
    public static final String PASSENGER_ID = "passenger_id";
    public static final String PASSENGER_ADDRESS = "address";
    public static final String PASSENGER_FIRST_NAME = "first_name";
    public static final String PASSENGER_LAST_NAME = "last_name";
    public static final String PASSENGER_PASSPORT_NUMBER = "passport_number";

    //Constants for stations table
    public static final String STATION_ID = "station_id";
    public static final String STATION_NAME = "station_name";
    public static final String STATION_CITY = "city";
    public static final String STATION_COUNTRY = "country";
    public static final String STATION_STATE = "state";

    //Constants for tickets table
    public static final String TICKET_ID = "ticket_id";
    public static final String TICKET_SEAT = "seat";
    public static final String TICKET_PRICE = "ticket_PRICE";

    //Constants for trains table
    public static final String TRAIN_ID = "train_id";
    public static final String TRAIN_MANUFACTURER = "manufacturer";
    public static final String TRAIN_MODEL = "model";
    public static final String TRAIN_NUMBER_OF_SEATS = "number_of_seats";
    public static final String TRAIN_TYPE= "train_type";

    //Constants for trips table
    public static final String TRIP_ID = "trip_id";
    public static final String TRIP_DEPARTURE_DATETIME = "departure_datetime";
    public static final String TRIP_ARRIVAL_DATETIME = "arrival_datetime";


    private ColumnName() {
    }
}
