package com.junit;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {
    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    @Test
    public void ReturnTotalFare() {
        double distance = 5;
        double time = 20;
        int expected = 70;
        int actual = (int) invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(expected, actual);

        distance = 0.5;
        time = 0.2;
        expected = 5;
        actual = (int) invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(expected, actual);
    }
}
