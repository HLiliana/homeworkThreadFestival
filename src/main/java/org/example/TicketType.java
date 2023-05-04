package org.example;

import java.util.Random;

public enum TicketType {
    FULL, FULL_VIP, FREE_PASS, ONE_DAY, ONE_DAY_VIP;

    private static final Random RANDOM = new Random();

    public static TicketType getRandomTicketType() {
        return values()[RANDOM.nextInt(values().length)];
    }
}
