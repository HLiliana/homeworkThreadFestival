package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class FestivalGate {

    public Queue<TicketType> ticketData;

    public FestivalGate() {
        this.ticketData = new LinkedList<>();
    }

    public synchronized void addTicketData(TicketType ticketType) {
        this.ticketData.add(ticketType);
    }

    public Queue<TicketType> getTicketData() {
        return ticketData;
    }

    public int getSize() {
        return ticketData.size();
    }

    public void clearTicketData() {
        this.ticketData.clear();
    }

}

