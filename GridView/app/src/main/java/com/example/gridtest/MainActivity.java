package com.example.gridtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    GridView grid;
    String[] items = {"Item-001", "Item-002", "Item-003",
            "Item-004", "Item-005", "Item-006"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        grid = findViewById(R.id.gridView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>( this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                items);

        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> container, View v, int position, long id) {
                textView.setText(items[position]);
            }
        });

    }
}