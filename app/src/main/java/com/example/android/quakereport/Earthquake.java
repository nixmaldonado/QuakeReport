package com.example.android.quakereport;

import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;

public class Earthquake {
    private String location;
    private double magnitude;
    private long date;

    public Earthquake(double thisMagnitude,
                      String thisLocation, long thisDate){
        location  = thisLocation;
        magnitude = thisMagnitude;
        date      = thisDate;
    }

    public String getLocation(){return location;}

    public double getMagnitude(){
        return magnitude;
    }

    public String getDate(){
        return formatDate();
    }

    public String getHour(){return formatHour();}

    @NonNull
    private String formatDate() {
        return new SimpleDateFormat("DD MMM, yyyy").format(date);
    }

    private String formatHour() {
        return new SimpleDateFormat("h:mm a").format(date);
    }

}
