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

        TextView magnitudeText = (TextView) quakeItem.findViewById(R.id.magnitude_item);
        magnitudeText.setText(currentEarthquake.getMagnitude());

        TextView locationText = (TextView) quakeItem.findViewById(R.id.location_item);
        locationText.setText(currentEarthquake.getLocation());

        TextView dateText = (TextView) quakeItem.findViewById(R.id.date_item);
        dateText.setText(currentEarthquake.getDate());

        return listItemView;
    }
}
