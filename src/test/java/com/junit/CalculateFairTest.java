package com.junit;

import org.junit.Assert;
import org.junit.Test;

public class CalculateFairTest {
    CalculateFair calculateFair = new CalculateFair();

    @Test
    public void findFare() {
        double distance = 5;
        double time = 20;
        int expected = 70;
        int actual = (int) calculateFair.calculateAmount(distance, time);
        Assert.assertEquals(expected, actual);

        distance = 0.5;
        time = 0.2;
        expected = 5;
        actual = (int) calculateFair.calculateAmount(distance, time);
        Assert.assertEquals(expected, actual);
    }
}
