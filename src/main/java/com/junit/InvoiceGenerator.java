package com.junit;

public class InvoiceGenerator {
    double costPerKiloMeter = 10.0;
    int minute = 1;
    int minFare = 5;

    public double calculateFare(double distance, double time) {
        double totalFare = (distance * costPerKiloMeter) + (time * minute);
        if (totalFare < minFare) {
            return 5;
        } else {
            return totalFare;
        }
    }

    public double calculateFareForMultipleRides(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }
}
