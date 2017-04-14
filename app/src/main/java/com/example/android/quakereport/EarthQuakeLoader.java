package com.example.android.quakereport;


import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class EarthQuakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private String queryUrl;

    public EarthQuakeLoader(Context context, String url) {
        super(context);
        queryUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        if (queryUrl == null){return null;}

        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(queryUrl);
        return earthquakes;
    }
}
