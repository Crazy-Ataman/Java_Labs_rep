package com.crazy_ataman.callCenter;

import java.util.ArrayList;
import java.util.Random;

public class CallCenter {
    private final static int MAX_ATTEMPTS = 2;
    ArrayList<Operator> operators;

    public CallCenter(ArrayList<Operator> operators) {
        this.operators = operators;
    }

    public synchronized Operator call(Client client) {
        int attempts = 0;
        boolean success = false;
        while (!success) {
            for (var operator : operators) {
                if (searchFreeOperator(operator, client)) {
                    return operator;
                }
            }
            if (!success) {
                try {
                    attempts++;
                    if (checkAttempts(attempts, client)) {
                        return null;
                    }
                } catch (InterruptedException ex) {
                    System.out.println("Something is going wrong...");
                    ex.printStackTrace();
                }
            }
        }

        return null;
    }

    public boolean searchFreeOperator(Operator operator, Client client) {
        if (operator.getClient() == null) {
            operator.setClient(client);
            operators.remove(operator);
            return true;
        }
        return false;
    }

    public synchronized boolean checkAttempts(
            int attempts, Client client) throws InterruptedException {
        if (attempts == MAX_ATTEMPTS) {
            System.out.println("The client №" + client.getId() + " put a negative review.");
            wait(100 + new Random().nextLong(400));
            return true;
        } else {
            System.out.println("The client №" + client.getId() + " is waiting.");
            wait(100 + new Random().nextLong(400));
        }
        return false;
    }

    public synchronized void endCall(Operator operator) {
        operator.setClient(null);
        operators.add(operator);
        notify();
    }

}
