package com.example.my_intent_test;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.app.TaskStackBuilder;

public class MainActivity extends AppCompatActivity {

    Button btnSend;
    TextView tvQuantity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSend = findViewById(R.id.btnSend);
        tvQuantity = findViewById(R.id.tvQuantity);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_activity_test_1();
            }
        });

    }

    private void open_activity_test_1(){
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

        Intent secondaryIntent = new Intent(this, NewActivity.class);
        secondaryIntent.putExtra("data", tvQuantity.getText().toString());

        stackBuilder.addNextIntentWithParentStack(secondaryIntent);

        stackBuilder.startActivities();
    }

}