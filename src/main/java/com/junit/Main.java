package com.junit;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RideRepository rideRepository = new RideRepository();
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        InvoiceService invoiceService = new InvoiceService(rideRepository, invoiceGenerator);

        rideRepository.addRides("user1", List.of(new Ride(5.0, 20.0), new Ride(3.0, 10.0)));
        InvoiceSummary invoiceSummary = invoiceService.getInvoice("user1");

        System.out.println("Total Rides: " + invoiceSummary.getTotalRides());
        System.out.println("Total Fare: " + invoiceSummary.getTotalFare());
        System.out.println("Average Fare: " + invoiceSummary.getAverageFare());
    }
}
