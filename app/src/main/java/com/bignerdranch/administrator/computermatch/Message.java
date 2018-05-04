package com.bignerdranch.administrator.computermatch;

/**
 * Created by Administrator on 2018/5/3 0003.
 */

public class Message {

    private String place;
    private String time;
    private int ImageId;

    public Message(String place, String time, int imageId) {
        this.place = place;
        this.time = time;
        ImageId = imageId;
    }

    public String getPlace() {
        return place;
    }

    public String getTime() {
        return time;
    }

    public int getImageId() {
        return ImageId;
    }
}
