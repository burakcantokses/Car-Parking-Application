package com.teamdelta.ticket;

import com.teamdelta.vehicle.Vehicle;

import java.util.Date;

public class Ticket {
    // Properties of the Ticket class
    public Vehicle vehicle;        // The vehicle associated with the ticket
    public Date entryDate;         // The entry date and time of the vehicle
    public Date exitDate;          // The exit date and time of the vehicle
    public double totalPrice;      // The total price for the parking duration
    public int numberOfTickets;     // Number of tickets (not used in the provided code)

    public double hourlyPrice;     // The hourly price for parking

    // Constructor for creating a Ticket with vehicle and entry date
    public Ticket(Vehicle vehicle, Date entryDate) {
        this.vehicle = vehicle;
        this.entryDate = entryDate;
    }

    // Method to calculate the total price based on hourly price and exit date
    public double calculatePrice(double hourlyPrice, Date exitDate) {
        this.exitDate = exitDate;
        this.hourlyPrice = hourlyPrice;

        // Calculate the number of hours the vehicle was parked
        int numberOfHours = (int) ((exitDate.getTime() - entryDate.getTime()) / (1000 * 60 * 60));

        // Calculate the total price for parking
        this.totalPrice = this.vehicle.size * hourlyPrice * numberOfHours;
        return totalPrice;
    }

    // Getter method for retrieving the associated vehicle
    public Vehicle getVehicle() {
        return vehicle;
    }

    // Getter method for retrieving the hourly price
    public double getHourlyPrice() {
        return hourlyPrice;
    }

    // Method to get ticket information as a formatted string
    public String getTicketInfo() {
        if (exitDate == null) {
            // Display information for a ticket with no exit date
            return "Ticket Info" +
                    "\n Plate Number: " + vehicle.plateNumber +
                    "\n Entry: " + entryDate;
        } else {
            // Display information for a ticket with exit date, including hours and fee
            int numberOfHours = (int) ((exitDate.getTime() - entryDate.getTime()) / (1000 * 60 * 60));
            return "Ticket Info" +
                    "\n Plate Number: " + vehicle.plateNumber +
                    "\n Entry: " + entryDate +
                    "\n Exit: " + exitDate +
                    "\n Hour: " + numberOfHours +
                    "\n Fee: " + calculatePrice(hourlyPrice, exitDate);
        }
    }
}
