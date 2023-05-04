package org.example;

import java.util.Queue;
import java.util.Random;

public class AttendeeThread extends Thread {

    public TicketType ticketType;
    public Queue<String> ticketQueue;

    public AttendeeThread(TicketType ticketType, Queue<String> ticketQueue) {
        this.ticketType = ticketType;
        this.ticketQueue = ticketQueue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        enterGate();
    }

    public void enterGate() {
        String data = this.ticketType.toString();
        ticketQueue.add(data);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


