package com.junit;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {
    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    @Test
    public void CheckTotalFare() {
        double distance = 5;
        double time = 20;
        int expected = 70;
        int actual = (int) invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(expected, actual);

        distance = 0.2;
        time = 0.1;
        expected = 5;
        actual = (int) invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void CheckTotalFareForMultipleRides() {
        Ride[] rides = {
                new Ride(5.0, 20.0),
                new Ride(3.0, 10.0),
                new Ride(0.5, 0.2)
        };
        int expected = 5 * 10 + 20 * 1 + 3 * 10 + 10 * 1 + 5;
        int actual = (int) invoiceGenerator.calculateFareForMultipleRides(rides);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void CheckEnhancedInvoice() {
        Ride[] rides = {
                new Ride(5.0, 20.0),
                new Ride(3.0, 10.0),
                new Ride(0.5, 0.2)
        };
        double expectedTotalFare = invoiceGenerator.calculateFare(5, 20) +
                invoiceGenerator.calculateFare(3, 10) +
                invoiceGenerator.calculateFare(0.5, 0.2);

        InvoiceSummary expected = new InvoiceSummary(3, expectedTotalFare);
        InvoiceSummary actual = invoiceGenerator.calculateEnhancedInvoice(rides);
        Assert.assertEquals(expected, actual);
    }
}
