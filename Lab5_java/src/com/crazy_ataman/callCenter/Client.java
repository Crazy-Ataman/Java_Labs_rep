package com.crazy_ataman.callCenter;

public class Client implements Runnable {
    private final int id;
    private final CallCenter callCenter;

    public Client(CallCenter callCenter, int id) {
        this.callCenter = callCenter;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public void run() {
        Operator operator = null;
        try {
            while (operator == null) {
                System.out.println("The client №" + id + " calls.");
                operator = callCenter.call(this);
            }
            System.out.println("The client №" + id + " goes to the operator #" + operator.getId()+".");
            operator.talk();
        } catch (Exception ex) {
            ex.getStackTrace();
        } finally {
            if (operator != null) {
                System.out.println("The client №" + id + " ended the call.");
                callCenter.endCall(operator);
            }
        }
    }
}
