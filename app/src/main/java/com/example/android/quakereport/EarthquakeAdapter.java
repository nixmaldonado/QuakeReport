package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Nicolas Maldonado on 25/03/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter {

    public EarthquakeAdapter(@NonNull Context context, @LayoutRes int resource,
                             ArrayList<Earthquake> earthquakes) {
        super(context, resource, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView== null){
            listItemView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item, parent, false);
        }

        Earthquake currentEarthquake = (Earthquake) getItem(position);
        LinearLayout quakeItem = (LinearLayout) listItemView.findViewById(R.id.list_item);

        populateItem(currentEarthquake, quakeItem);

        return listItemView;
    }

    private void populateItem(Earthquake currentEarthquake, LinearLayout quakeItem) {
        setMagnitudeText(currentEarthquake, quakeItem);
        setLocationText(currentEarthquake, quakeItem);
        setDateText(currentEarthquake, quakeItem);
    }

    private void setDateText(Earthquake currentEarthquake, LinearLayout quakeItem) {
        TextView dateText = (TextView) quakeItem.findViewById(R.id.date_item);
        dateText.setText(currentEarthquake.getDate());

        TextView hourText = (TextView) quakeItem.findViewById(R.id.hour_item);
        hourText.setText((currentEarthquake.getHour()));
    }

    private void setMagnitudeText(Earthquake currentEarthquake, LinearLayout quakeItem) {
        TextView magnitudeText = (TextView) quakeItem.findViewById(R.id.magnitude_item);
        magnitudeText.setText(formatMagnitude(currentEarthquake.getMagnitude()));
    }

    private void setLocationText(Earthquake currentEarthquake, LinearLayout quakeItem) {
        TextView locationText = (TextView) quakeItem.findViewById(R.id.location_item);
        TextView offsetText = (TextView) quakeItem.findViewById(R.id.offset_item);
        String[] locations = splitLocation(currentEarthquake.getLocation());
        locationText.setText(locations[0]);
        offsetText.setText(locations[1]);
    }

    private String[] splitLocation(String location){
        String[] locations = new String[2];
        if (hasOffset(location)){
            locations = location.split("(?<= of )");
            return locations;}
        else {
            locations[0] = String.valueOf(R.string.near_the);
            locations[1] = location;
            return locations;
        }
    }

    private boolean hasOffset(String location){
        return location.contains(" of ");
    }

    private String formatMagnitude(Double magnitude){
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
}
