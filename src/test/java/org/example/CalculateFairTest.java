package org.example;

import org.junit.Assert;
import org.junit.Test;

public class CalculateFairTest {
    CalculateFair calculateFair = new CalculateFair();

    @Test
    public void findFare() {
        System.out.println("Checking");
        double distance=5;
        double time=20;
        int expected = 70;
        int actual = (int) calculateFair.calculateAmount(distance,time);
        Assert.assertEquals(expected, actual);
    }
}
