package kz.djunglestones.jobtask;

class QRTickets {
    private String username,ticketName;
    private int image;

    public QRTickets(String username, String ticketName, int image) {
        this.username = username;
        this.ticketName = ticketName;
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
