package com.junit;

public class CalculateFair {
    double costPerKiloMeter = 10.0;
    int minute = 1;
    int minFare = 5;

    public double calculateAmount(double distance, double time) {
        double totalFare = (distance * costPerKiloMeter) + (time * minute);
        if (totalFare < minFare) {
            return 5;
        } else {
            return totalFare;
        }
    }
}
