package com.example.earthquake;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * An {@link EarthquakeAdapter} knows how to create a list item layout for each earthquake
 * in the data source (a list of {@link EarthquakeModel} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class EarthquakeAdapter extends ArrayAdapter<EarthquakeModel> {

    /**
     * Constructs a new {@link EarthquakeAdapter}.
     *
     * @param context of the app
     * @param earthquakes is the list of earthquakes, which is the data source of the adapter
     */
    public EarthquakeAdapter(Context context, List<EarthquakeModel> earthquakes) {
        super(context, 0, earthquakes);
    }

    /**
     * Returns a list item view that displays information about the earthquake at the given position
     * in the list of earthquakes.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        // Find the earthquake at the given position in the list of earthquakes
        EarthquakeModel currentEarthquake = getItem(position);

        // Find the TextView with view ID magnitude
        TextView magnitudeView = listItemView.findViewById(R.id.magnitude);
        // Display the magnitude of the current earthquake in that TextView
        magnitudeView.setText(currentEarthquake.getMagnitude());

        // Find the TextView with view ID location
        TextView primaryLocationView =  listItemView.findViewById(R.id.location);
        // Display the location of the current earthquake in that TextView
        primaryLocationView.setText(currentEarthquake.getLocation());

        // Find the TextView with view ID date
        TextView dateView = listItemView.findViewById(R.id.date);
        // Display the date of the current earthquake in that TextView
        dateView.setText(currentEarthquake.getDate());

        // Find the TextView with view ID coordinates
        TextView coordinatesView = listItemView.findViewById(R.id.coordinates);
        // Display the date of the current earthquake in that TextView
        coordinatesView.setText(currentEarthquake.getCoordinates());

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

}