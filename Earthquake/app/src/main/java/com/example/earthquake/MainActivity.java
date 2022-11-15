package com.example.earthquake;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ArrayList<String> earthquakes = new ArrayList<>();
//        earthquakes.add("San Francisco");
//        earthquakes.add("London");
//        earthquakes.add("Tokyo");
//        earthquakes.add("Mexico City");
//        earthquakes.add("Moscow");
//        earthquakes.add("Rio de Janeiro");
//        earthquakes.add("Paris");
//        earthquakes.add("Venice");
//        earthquakes.add("Los Angeles");
//
//        ListView listView = findViewById(R.id.list);
//        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, earthquakes);
//        listView.setAdapter(itemsAdapter);

        ArrayList<EarthquakeModel> earthquakes = new ArrayList<>();
        earthquakes.add(new EarthquakeModel("7.2","San Franciso", "Mar 3, 2016", "23515"));
        earthquakes.add(new EarthquakeModel("3.2","London", "Mar 3, 2016", "13425"));
        earthquakes.add(new EarthquakeModel("4.2","Tokyo", "Mar 3, 2016", "63515"));
        earthquakes.add(new EarthquakeModel("4.3","Mexico City", "Mar 3, 2016", "36515"));
        earthquakes.add(new EarthquakeModel("4.5","Moscow", "Mar 3, 2016", "53515"));
        earthquakes.add(new EarthquakeModel("2.3","Rio de Janeiro", "Mar 3, 2016", "43515"));
        earthquakes.add(new EarthquakeModel("1.3","Paris", "Mar 3, 2016", "83515"));
        earthquakes.add(new EarthquakeModel("1.1","Venice", "Mar 3, 2016", "26515"));
        earthquakes.add(new EarthquakeModel("6.5","Los Angeles", "Mar 3, 2016", "83515"));

        ListView earthquakeListView = findViewById(R.id.list);
        EarthquakeAdapter earthquakeAdapter = new EarthquakeAdapter(this, earthquakes);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EarthquakeModel currentEarthquake = earthquakeAdapter.getItem(position);
                String itemLocation = String.valueOf(currentEarthquake.getLocation());
                Toast.makeText(MainActivity.this, itemLocation, Toast.LENGTH_SHORT).show();
            }
        });
        earthquakeListView.setAdapter(earthquakeAdapter);
    }
}