package kz.djunglestones.jobtask;

public class PopularCardview {
    String card_date, card_event_name,card_location;
    int image;

    public PopularCardview(String card_date, String card_event_name, String card_location, int image) {
        this.card_date = card_date;
        this.card_event_name = card_event_name;
        this.card_location = card_location;
        this.image = image;
    }

    public String getCard_date() {
        return card_date;
    }

    public void setCard_date(String card_date) {
        this.card_date = card_date;
    }

    public String getCard_event_name() {
        return card_event_name;
    }

    public void setCard_event_name(String card_event_name) {
        this.card_event_name = card_event_name;
    }

    public String getCard_location() {
        return card_location;
    }

    public void setCard_location(String card_location) {
        this.card_location = card_location;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
