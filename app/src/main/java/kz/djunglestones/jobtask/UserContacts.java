package kz.djunglestones.jobtask;

class UserContacts {

    String userName,eventName;

    int image;

    public UserContacts(String userName, String eventName, int image) {
        this.userName = userName;
        this.eventName = eventName;
        this.image = image;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }





    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
