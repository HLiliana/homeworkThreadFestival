package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import static java.time.chrono.JapaneseEra.values;

/**
 * Every festival has a gate, where people have to show their tickets // festival, gate, showTickets, tickets
 * write an application where every person is represented by
 * a Thread that is instantiated with random ticket data // thread, randomTicketData
 * possible ticket types: full, full-vip, free-pass, one-day, one-day-vip // ticketType:
 * every attendee validates the ticket, and the ticket-data is kept is a queue // attendee, validateTicket, keepTicketData
 * meanwhile,
 * every 5 seconds a FestivalStatisticsThread wakes up and reads the new data  // wakeUpAndReadNewData
 * from the gate and generates statistics // gate, generateStatistics
 * <p>
 * 100 people entered // peopleEntered
 * 57 people have full tickets // fullTickets
 * 30 have free passes // freePasses
 * 3 have full VIP passes // fullVipPasses
 * 10 have one-day passes // oneDayPasses
 * 0 have one-day VIP passes // oneDayVIPPasses
 * <p>
 * NOTES
 * <p>
 * there can be only one statisticsThread // statisticsThread
 * statistics thread reads from the gate-data only if it's not empty // NotEmpty gate Data
 * there can be unlimited attendee threads // attendeeThread
 * attendee threads can add data to the gate regardless of the gate data being empty or full // addDataToTHeGate
 * the application must randomly generate multiple attendee threads - at least 100
 * use Thread.sleep() in both thread types
 * <p>
 * Nouns:  festival, gate, tickets, thread, ticketType: fullTickets, freePasses, fullVipPasses, oneDayPasses, oneDayVIPPasses,
 * attendee, statisticsThread, attendeeThread
 * Verbs:  showTickets, randomTicketData, validateTicket, keepTicketData, wakeUpAndReadNewData, generateStatistics,
 * peopleEntered, addDataToTHeGate, sleep();
 */
public class App {
    public static void main(String[] args) {

        FestivalGate gate = new FestivalGate();

        Queue<String> ticketQueue = new LinkedList<>();
        FestivalStatistics festivalStatistics = new FestivalStatistics();
        FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(ticketQueue, festivalStatistics );
        statisticsThread.start();
        statisticsThread.sleep(1000);

        for (int i = 0; i < 100; i++) {
            TicketType ticketType = TicketType.getRandomTicketType();

            AttendeeThread attendeeThread = new AttendeeThread(ticketType, ticketQueue);
            attendeeThread.start();
        }
    }
}







