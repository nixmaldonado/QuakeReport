package com.example.android.quakereport;


import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

import static com.example.android.quakereport.EarthquakeActivity.LOG_TAG;

public class EarthQuakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private String queryUrl;

    public EarthQuakeLoader(Context context, String url) {
        super(context);
        queryUrl = url;
    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG,"onStartLoading");
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        Log.i(LOG_TAG,"loadInBackground");

        if (queryUrl == null){return null;}

        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(queryUrl);
        return earthquakes;
    }
}
