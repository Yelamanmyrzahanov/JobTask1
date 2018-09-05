package kz.djunglestones.jobtask;

public class Tickets {
    String ticketName;
    int ticketPrice;
    int amountOfTickets;

    int ticketCount = 0;

    public Tickets(String ticketName, int ticketPrice, int amountOfTickets) {
        this.ticketName = ticketName;
        this.ticketPrice = ticketPrice;
        this.amountOfTickets = amountOfTickets;
        this.ticketCount = ticketCount;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getAmountOfTickets() {
        return amountOfTickets;
    }

    public void setAmountOfTickets(int amountOfTickets) {
        this.amountOfTickets = amountOfTickets;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }
}
