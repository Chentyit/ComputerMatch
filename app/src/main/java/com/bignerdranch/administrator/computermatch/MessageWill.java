package com.bignerdranch.administrator.computermatch;

/**
 * Created by Administrator on 2018/5/4 0004.
 */

public class MessageWill {

    private String place;
    private String time;
    private int ImageId;
    private int Hour;
    private int minute;
    private int seconds;

    public MessageWill(String place, String time, int imageId, int hour, int minute, int seconds) {
        this.place = place;
        this.time = time;
        ImageId = imageId;
        Hour = hour;
        this.minute = minute;
        this.seconds = seconds;
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

    public int getHour() {
        return Hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSeconds() {
        return seconds;
    }
}
