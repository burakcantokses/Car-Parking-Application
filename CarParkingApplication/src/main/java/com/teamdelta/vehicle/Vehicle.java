package com.teamdelta.vehicle;

public class Vehicle {
    // Properties of the Vehicle class
    public String plateNumber;  // License plate number of the vehicle
    public int size;            // Size of the vehicle (1: motorcycle, 2: car, 4: truck)

    // Constructor for creating a Vehicle with specified plate number and size
    public Vehicle(String plateNumber, int size) {
        this.plateNumber = plateNumber;
        this.size = size;
    }

    // Getter method for retrieving the license plate number
    public String getPlateNumber() {
        return plateNumber;
    }

    // Getter method for retrieving the size of the vehicle
    public int getSize() {
        return size;
    }

    // Method to get information about the vehicle as a formatted string
    public String getVehicleInfo() {
        return "Plate number: " + plateNumber + "\n Size: " + size;
    }
}
