package com.junit;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class RideRepositoryTest {
    @Test
    public void testAddAndGetRides() {
        RideRepository rideRepository = new RideRepository();
        Ride ride1 = new Ride(5.0, 20.0);
        Ride ride2 = new Ride(3.0, 10.0);

        rideRepository.addRides("user1", List.of(ride1, ride2));

        List<Ride> rides = rideRepository.getRides("user1");
        Assert.assertEquals(2, rides.size());
        Assert.assertEquals(ride1.distance, rides.get(0).distance, 0.0);
        Assert.assertEquals(ride2.distance, rides.get(1).distance, 0.0);
    }

    @Test
    public void testGetRidesForUnknownUser() {
        RideRepository rideRepository = new RideRepository();

        List<Ride> rides = rideRepository.getRides("unknownUser");
        Assert.assertTrue(rides.isEmpty());
    }
}
