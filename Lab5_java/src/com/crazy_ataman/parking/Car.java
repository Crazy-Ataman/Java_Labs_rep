package com.crazy_ataman.parking;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    private final Semaphore sem;
    private final Parking parking;
    private final int id;

    public Car(Parking parking, Semaphore sem, int id) {
        this.parking = parking;
        this.sem = sem;
        this.id = id;
    }

    private void parking() {
        System.out.println("Car №" + id + " parked on stand №" + parking.getId() + ".");
    }

    private void leaving() {
        System.out.println("Car №" + id + " is leaving stand №" + parking.getId() + ".");
    }

    @Override
    public void run() {
        try {
            sem.acquire();
            parking();
            Thread.sleep(new Random().nextInt(250) + 250);
            sem.release();
            leaving();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}