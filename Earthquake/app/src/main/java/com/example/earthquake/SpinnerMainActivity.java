package com.example.earthquake;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerMainActivity extends AppCompatActivity {
    Spinner spinner;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_main);

        textView = findViewById(R.id.zodiac_text);
        spinner = findViewById(R.id.zodiac_spinner);

        // Interface as listener
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        // ArrayAdapter with (string-array) and spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        R.array.zodiac_array, android.R.layout.simple_spinner_item);

        // Point the view to be used
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // After an element is chosen, it can be taken with
        // parent.getItemAtPosition (pos)

        String item = spinner.getItemAtPosition(pos).toString();
        textView.setText(item);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Reaction to the answer
        Toast.makeText(this,"Please, choose from the list",Toast.LENGTH_SHORT).show();
    }

}