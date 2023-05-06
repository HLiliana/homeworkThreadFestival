package org.example;

public class FestivalStatistics{
    /**Generate the attendance statistics
     * Print the attendance statistics
     */
    private int totalAttendees = 0;
    private int fullTickets = 0;
    private int fullVipTickets = 0;
    private int freePasses = 0;
    private int oneDayTickets = 0;
    private int oneDayVipTickets = 0;

    public synchronized void updateStatistics(String ticket){
        totalAttendees++;
            switch (ticket) {
            case "FULL" -> fullTickets++;
            case "FULL_VIP" -> fullVipTickets++;
            case "FREE_PASS" -> freePasses++;
            case "ONE_DAY" -> oneDayTickets++;
            case "ONE_DAY_VIP" -> oneDayVipTickets++;
            default -> throw new IllegalArgumentException("Invalid ticket type: " + ticket);
        }
    }

    public synchronized void printStatistics(){
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
