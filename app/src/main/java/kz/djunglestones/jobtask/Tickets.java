package kz.djunglestones.jobtask;

public class Tickets {
    String ticketName;
    int ticketPrice;
    int amountOfTickets;

    public Tickets(String ticketName, int ticketPrice, int amountOfTickets) {
        this.ticketName = ticketName;
        this.ticketPrice = ticketPrice;
        this.amountOfTickets = amountOfTickets;
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
}
