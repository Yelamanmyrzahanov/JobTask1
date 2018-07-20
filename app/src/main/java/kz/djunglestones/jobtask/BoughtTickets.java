package kz.djunglestones.jobtask;


public class BoughtTickets {
    private String date;
    private String eventName;
    private String location;
    private int numOfTickets;
    private int image;

    public BoughtTickets(String date, String eventName, String location, int numOfTickets, int image) {
        this.date = date;
        this.eventName = eventName;
        this.location = location;
        this.numOfTickets = numOfTickets;
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumOfTickets() {
        return numOfTickets;
    }

    public void setNumOfTickets(int numOfTickets) {
        this.numOfTickets = numOfTickets;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

