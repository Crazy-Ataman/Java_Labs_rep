package com.crazy_ataman.callCenter;

import java.util.Random;

public class Operator {
    private final int id;
    private Client client;

    public Operator(int id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public int getId() {
        return id;
    }

    public void talk() {
        try {
            Thread.sleep(new Random().nextInt(250));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
