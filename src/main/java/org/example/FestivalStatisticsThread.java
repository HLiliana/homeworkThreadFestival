package org.example;

import java.util.Queue;

public class FestivalStatisticsThread extends Thread {
    private Queue<String> ticketQueue;
    private FestivalStatistics festivalStatistics;

    public FestivalStatisticsThread(Queue<String> ticketQueue, FestivalStatistics festivalStatistics) {
        this.festivalStatistics = festivalStatistics;
        this.ticketQueue = ticketQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (String ticket : ticketQueue) {
                festivalStatistics.updateStatistics(ticket);
            }
            festivalStatistics.printStatistics();
        }
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
