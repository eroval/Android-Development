package com.example.adnroidtestex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnStart;
    private Button btnStop;
    private Button btnGo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStop = (Button) findViewById(R.id.start);
        btnStart = (Button) findViewById(R.id.stop);
        btnGo = (Button) findViewById(R.id.go);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToActivity2();
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotification();
            }
        });
    }

    private void goToActivity2(){
        Intent intent = new Intent(this, SecondaryActivity.class);
        startActivity(intent);
    }


    private void sendNotification(){
        Intent intent = new Intent(this, SecondaryActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
        .setSmallIcon(android.R.drawable.ic_dialog_alert)
        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
        .setContentTitle("Notifications Title")
        .setContentText("Your notification content here.")
        .setSubText("Tap to view the website.")
        .setStyle(new NotificationCompat.BigTextStyle()
                .bigText("Your notification content here. ...Much longer text that cannot fit one line..."))
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        // Set the intent that will fire when the user taps the notification
        .setContentIntent(pendingIntent)
        .setAutoCancel(true);

    }


}