package com.crazy_ataman.parking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {
    private static final int NUMBER_OF_CARS = 30;
    private static final int FIRST_PARKING = 2;
    private static final int SECOND_PARKING = 4;

    public static void main(String[] args) {
        Parking first_parking = new Parking(1, FIRST_PARKING);
        Parking second_parking = new Parking(2, SECOND_PARKING);
        Semaphore first_sem = new Semaphore(first_parking.getCapacity(), true);
        Semaphore second_sem = new Semaphore(second_parking.getCapacity(), true);
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 1; i <= NUMBER_OF_CARS; ) {
            service.execute(new Car(first_parking, first_sem, i++));
            service.execute(new Car(second_parking, second_sem, i++));
        }

        service.shutdown();
    }
}
