package com.teamdelta.test;

import com.teamdelta.park.CarPark;
import com.teamdelta.vehicle.Vehicle;

import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void test() {
        // Create a CarPark instance with a capacity of 10 and 5 available spaces.
        CarPark carPark = new CarPark(10, 5);

        // Set the capacity to 4 to trigger an error after the 5th vehicle is parked.
        carPark.setCapacity(4);

        // Create Vehicle instances with registration numbers and passenger capacities.
        Vehicle vehicle1 = new Vehicle("34 AA 123", 4);
        Vehicle vehicle2 = new Vehicle("34 BB 123", 2);
        Vehicle vehicle3 = new Vehicle("34 CC 123", 1);
        Vehicle vehicle4 = new Vehicle("34 DD 123", 2);
        Vehicle vehicle5 = new Vehicle("34 EE 123", 4);

        // Create Date instances for vehicle parking times.
        Date date1 = new Date();
        Date date2 = addHour(date1, 1);
        Date date3 = addHour(date1, 2);
        Date date4 = addHour(date1, 3);
        Date date5 = addHour(date1, 4);

        // Park vehicles in the car park with associated parking times.
        carPark.parkVehicle(vehicle1, date1);
        carPark.parkVehicle(vehicle2, date2);
        carPark.parkVehicle(vehicle3, date3);
        carPark.parkVehicle(vehicle4, date4);
        carPark.parkVehicle(vehicle5, date5);

        // Print the list of vehicles parked in the car park.
        carPark.printVehicleList();

        // Exit vehicles from the car park with exit times.
        carPark.exitVehicle(vehicle1, date2);
        carPark.exitVehicle(vehicle2, date3);
        carPark.exitVehicle(vehicle3, date4);
        carPark.exitVehicle(vehicle4, date5);

        // Print the tickets of the exited vehicles.
        carPark.printTickets();
    }

    // Helper method to add a specified number of hours to a given date.
    public static Date addHour(Date date, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hour);
        return calendar.getTime();
    }
}
