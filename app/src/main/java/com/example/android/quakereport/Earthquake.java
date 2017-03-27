package com.example.android.quakereport;

public class Earthquake {
    private String location;
    private String magnitude;
    private String date;

    public Earthquake(String thisLocation,
                      String thisMagnitude, String thisDate){
        location  = thisLocation;
        magnitude = thisMagnitude;
        date      = thisDate;
    }

    public String getLocation(){return location;}

    public String getMagnitude(){
        return magnitude;
    }

    public String getDate(){
        return date;
    }
}
