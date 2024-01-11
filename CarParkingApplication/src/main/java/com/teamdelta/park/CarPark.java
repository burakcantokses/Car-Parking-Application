package com.teamdelta.park;

import com.teamdelta.ticket.Ticket;
import com.teamdelta.vehicle.Vehicle;

import java.util.Date;

public class CarPark {
    // Properties of the CarPark class
    public int capacity;                // Total capacity of the car park
    public ParkPlace[] parkPlaceArray;  // Array to store parked vehicles
    public Ticket[] ticketArray;        // Array to store associated tickets
    public double hourlyPrice;          // Hourly price for parking

    // Constructor for creating a CarPark with specified capacity and hourly price
    public CarPark(int capacity, double hourlyPrice) {
        this.capacity = capacity;
        this.hourlyPrice = hourlyPrice;
    }

    // Method to set the capacity of the car park
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Method to check if there is available capacity in the car park
    public boolean checkCapacity() {
        if (capacity == 0) {
            System.out.println("Car park is full!");
            return false;
        }
        return true;
    }

    // Method to park a vehicle in the car park and generate a ticket
    public Ticket parkVehicle(Vehicle vehicle, Date entryDate) {
        if (checkCapacity()) {
            if (parkPlaceArray == null) {
                parkPlaceArray = new ParkPlace[capacity];
                ticketArray = new Ticket[capacity];
            }
            for (int i = 0; i < parkPlaceArray.length; i++) {
                if (parkPlaceArray[i] == null) {
                    parkPlaceArray[i] = new ParkPlace(vehicle);
                    ticketArray[i] = new Ticket(vehicle, entryDate);
                    capacity--;
                    System.out.println("The vehicle with " + vehicle.plateNumber + " plate number is parked.");
                    return ticketArray[i];
                }
            }
        }
        return null;
    }

    // Method to exit a vehicle from the car park, calculate the price, and display it
    public Ticket exitVehicle(Vehicle vehicle, Date exitDate) {
        for (int i = 0; i < parkPlaceArray.length; i++) {
            if (parkPlaceArray[i] == null) {
                continue;
            }
            if (parkPlaceArray[i].vehicle.plateNumber.equals(vehicle.plateNumber)) {
                ticketArray[i].calculatePrice(hourlyPrice, exitDate);
                System.out.println("The price for vehicle with " + vehicle.plateNumber + " plate number is: " + ticketArray[i].totalPrice + " TLs");
                parkPlaceArray[i] = null;
                capacity++;
                return ticketArray[i];
            }
        }
        return null;
    }

    // Method to calculate and return the total income from all tickets
    public double getTotalIncome() {
        double totalIncome = 0;
        for (Ticket ticket : ticketArray) {
            totalIncome += ticket.totalPrice;
        }
        return totalIncome;
    }

    // Method to print the list of vehicles parked in the car park
    public void printVehicleList() {
        System.out.println("\nVEHICLE LIST\n------------");
        for (int i = 0; i < parkPlaceArray.length; i++) {
            System.out.println(parkPlaceArray[i].vehicle.getVehicleInfo());
        }
        System.out.println("------------");
    }

    // Method to print information about all issued tickets
    public void printTickets() {
        System.out.println("\nTICKETS\n--------");
        for (Ticket ticket : ticketArray) {
            System.out.println(ticket.getTicketInfo());
        }
        System.out.println("------------");
    }
}
