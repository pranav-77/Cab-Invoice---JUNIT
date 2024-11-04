package com.junit;

public class InvoiceGenerator {
    static final double costPerKiloMeter = 10.0;
    static final int costPerMinute = 1;
    static final int minFare = 5;

    static final double premiumCostPerKiloMeter = 20.0;
    static final int premiumCostPerMinute = 2;
    static final int premiumMinFare = 20;

    public double calculateFare(Ride ride) {
        double totalFare;
        if ("PREMIUM".equalsIgnoreCase(ride.rideType)) {
            totalFare = (ride.distance * premiumCostPerKiloMeter) + (ride.time * premiumCostPerMinute);
            return Math.max(totalFare, premiumMinFare);
        } else {
            totalFare = (ride.distance * costPerKiloMeter) + (ride.time * costPerMinute);
            return Math.max(totalFare, minFare);
        }
    }

    public double calculateFareForMultipleRides(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride);
        }
        return totalFare;
    }

    public InvoiceSummary calculateEnhancedInvoice(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }
}
