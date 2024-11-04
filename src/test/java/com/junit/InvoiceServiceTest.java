package com.junit;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class InvoiceServiceTest {
    @Test
    public void testGetInvoice() {
        RideRepository rideRepository = new RideRepository();
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        InvoiceService invoiceService = new InvoiceService(rideRepository, invoiceGenerator);

        List<Ride> rides = List.of(new Ride(5.0, 20.0,"NORMAL"), new Ride(3.0, 10.0,"PREMIUM"));
        rideRepository.addRides("user1", rides);

        InvoiceSummary invoiceSummary = invoiceService.getInvoice("user1");

        Assert.assertEquals(2, invoiceSummary.getTotalRides());
        double expectedTotalFare=150;
        Assert.assertEquals(expectedTotalFare, invoiceSummary.getTotalFare(), 0.0);
        Assert.assertEquals(expectedTotalFare / 2, invoiceSummary.getAverageFare(), 0.0);
    }
}
