package kz.djunglestones.jobtask;

import android.widget.ImageView;

public class Link2Data {
    private String info2, link4, info3, tag1,tag2;
    private int image;
    public Link2Data(){

    }

    public Link2Data(String info2, String link4, String info3, int image) {
        this.info2 = info2;
        this.link4 = link4;
        this.info3 = info3;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.image = image;
    }

    public String getInfo2() {
        return info2;
    }

    public void setInfo2(String info2) {
        this.info2 = info2;
    }

    public String getLink4() {
        return link4;
    }

    public void setLink4(String link4) {
        this.link4 = link4;
    }

    public String getInfo3() {
        return info3;
    }

    public void setInfo3(String info3) {
        this.info3 = info3;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
