package com.example.my_intent_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    private TextView dataTV;
    private String tvQuantity="No data received.";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        dataTV = findViewById(R.id.tvData);
        dataTV.setText("cool");

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("data")) {
                tvQuantity = getIntent().getStringExtra("data");
            }
        }
        dataTV.setText(tvQuantity);
    }
}