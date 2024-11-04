package com.junit;

import java.util.List;

public class InvoiceService {
    private final RideRepository rideRepository;
    private final InvoiceGenerator invoiceGenerator;

    public InvoiceService(RideRepository rideRepository, InvoiceGenerator invoiceGenerator) {
        this.rideRepository = rideRepository;
        this.invoiceGenerator = invoiceGenerator;
    }

    public InvoiceSummary getInvoice(String userId) {
        List<Ride> rides = rideRepository.getRides(userId);
        return invoiceGenerator.calculateEnhancedInvoice(rides.toArray(new Ride[0]));
    }
}
