package com.example.adnroidtestex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {
    private String CHANNEL_ID = "my_custom_channel";
    private int notificationId = 1465;

    private String KEY_TEXT_REPLY = "user_reply_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        TextView textView = (TextView) findViewById(R.id.userInput);
        textView.setText(getMessageText(getIntent()));

        receiveNotification();
    }

    private CharSequence getMessageText(Intent intent) {
        Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);
        if (remoteInput != null) {
            return remoteInput.getCharSequence(KEY_TEXT_REPLY);
        }
        return null;
    }

    private void receiveNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentText("saved");

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        //update notification
        notificationManager.notify(notificationId, builder.build());
    }
}