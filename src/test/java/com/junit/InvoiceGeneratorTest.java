package com.junit;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {
    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    @Test
    public void checkTotalFareForNormalRide() {
        Ride normalRide = new Ride(5.0, 20.0, "NORMAL");
        double expected = 70;
        double actual = invoiceGenerator.calculateFare(normalRide);
        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void checkTotalFareForPremiumRide() {
        Ride premiumRide = new Ride(5.0, 20.0, "PREMIUM");
        double expected = 140;
        double actual = invoiceGenerator.calculateFare(premiumRide);
        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void CheckTotalFareForMultipleRides() {
        Ride[] rides = {
                new Ride(5.0, 20.0, "NORMAL"),
                new Ride(3.0, 10.0, "PREMIUM"),
                new Ride(0.5, 0.2, "NORMAL")
        };
        int expected = 155;
        int actual = (int) invoiceGenerator.calculateFareForMultipleRides(rides);
        Assert.assertEquals(expected, actual,0.0);
    }

    @Test
    public void CheckEnhancedInvoice() {
        Ride[] rides = {
                new Ride(5.0, 20.0, "NORMAL"),
                new Ride(3.0, 10.0, "PREMIUM"),
                new Ride(0.5, 0.2, "PREMIUM")
        };

        InvoiceSummary expected = new InvoiceSummary(3, 70 + 80 + 20);
        InvoiceSummary actual = invoiceGenerator.calculateEnhancedInvoice(rides);
        Assert.assertEquals(expected.getTotalRides(), actual.getTotalRides());
        Assert.assertEquals(expected.getTotalFare(), actual.getTotalFare(), 0.0);
        Assert.assertEquals(expected.getAverageFare(), actual.getAverageFare(), 0.0);
    }
}
