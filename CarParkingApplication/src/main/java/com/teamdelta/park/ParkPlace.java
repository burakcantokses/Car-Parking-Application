package com.teamdelta.park;

import com.teamdelta.vehicle.Vehicle;

public class ParkPlace {
    // Properties of the ParkPlace class
    public int size;        // Size of the park place (not currently used)
    public Vehicle vehicle; // The vehicle parked in the park place

    // Constructor for creating a ParkPlace with a specified vehicle
    public ParkPlace(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    // Getter method for retrieving the associated vehicle
    public Vehicle getVehicle() {
        return vehicle;
    }

    // Getter method for retrieving the size of the park place (not currently used)
    public int getSize() {
        return size;
    }
}
