package com.example.android.quakereport;

import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;

public class Earthquake {
    private String location;
    private double magnitude;
    private long date;
    private String url;

    public Earthquake(double thisMagnitude,
                      String thisLocation, long thisDate, String thisUrl){
        location  = thisLocation;
        magnitude = thisMagnitude;
        date      = thisDate;
        url       = thisUrl;
    }

    public String getLocation(){return location;}

    public double getMagnitude(){
        return magnitude;
    }

    public String getDate(){
        return formatDate();
    }

    public String getHour(){return formatHour();}

    public String getUrl(){return url;}
    @NonNull
    private String formatDate() {
        return new SimpleDateFormat("DD MMM, yyyy").format(date);
    }

    private String formatHour() {
        return new SimpleDateFormat("h:mm a").format(date);
    }

}
