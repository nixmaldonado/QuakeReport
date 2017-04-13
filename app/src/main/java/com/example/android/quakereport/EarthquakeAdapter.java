package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter {

    public EarthquakeAdapter(@NonNull Context context, @LayoutRes int resource,
                             List<Earthquake> earthquakes) {
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
        setMagnitudeView(currentEarthquake, quakeItem);
        setLocationText(currentEarthquake, quakeItem);
        setDateText(currentEarthquake, quakeItem);
    }

    private void setDateText(Earthquake currentEarthquake, LinearLayout quakeItem) {
        TextView dateText = (TextView) quakeItem.findViewById(R.id.date_item);
        dateText.setText(currentEarthquake.getDate());

        TextView hourText = (TextView) quakeItem.findViewById(R.id.hour_item);
        hourText.setText((currentEarthquake.getHour()));
    }

    private void setMagnitudeView(Earthquake currentEarthquake, LinearLayout quakeItem) {
        TextView magnitudeText = (TextView) quakeItem.findViewById(R.id.magnitude_item);
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeText.getBackground();
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);
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
            locations[0] = getContext().getString(R.string.near_the);
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

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
