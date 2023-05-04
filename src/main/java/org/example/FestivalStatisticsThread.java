package org.example;

import java.util.Queue;

public class FestivalStatisticsThread extends Thread {
    private Queue<String> ticketQueue;

    public FestivalStatisticsThread(Queue<String> ticketQueue) {
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

            /**Generate the attendance statistics
             * Print the attendance statistics
             */
            int totalAttendees = ticketQueue.size();
            int fullTickets = 0;
            int fullVipTickets = 0;
            int freePasses = 0;
            int oneDayTickets = 0;
            int oneDayVipTickets = 0;

            for (String ticket : ticketQueue) {
                switch (ticket) {
                    case "full":
                        fullTickets++;
                        break;
                    case "full-vip":
                        fullVipTickets++;
                        break;
                    case "free-pass":
                        freePasses++;
                        break;
                    case "one-day":
                        oneDayTickets++;
                        break;
                    case "one-day-vip":
                        oneDayVipTickets++;
                        break;
                }
            }


            System.out.println("Festival Attendance Statistics:");
            System.out.println("Total attendees: " + totalAttendees);
            System.out.println("Full tickets: " + fullTickets);
            System.out.println("Full VIP tickets: " + fullVipTickets);
            System.out.println("Free passes: " + freePasses);
            System.out.println("One-day tickets: " + oneDayTickets);
            System.out.println("One-day VIP tickets: " + oneDayVipTickets);
            System.out.println();
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
