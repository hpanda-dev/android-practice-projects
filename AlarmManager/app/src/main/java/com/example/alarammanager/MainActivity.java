package com.example.alarammanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton toggleButton;
    AlarmManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        toggleButton = findViewById(R.id.toogle);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Intent intent = new Intent(getApplicationContext(), MyService.class);
                    PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    long trigger = SystemClock.elapsedRealtime() + (60 * 1000);
                    long interval = 60 * 1000;
                    manager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, trigger, interval, pi);
                    Toast.makeText(MainActivity.this, "Alarm is ON", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), MyService.class);
                    PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    long trigger = SystemClock.elapsedRealtime() + (60 * 1000);
                    long interval = 60 * 1000;
                    manager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, trigger, interval, pi);
                    Toast.makeText(MainActivity.this, "Alarm is OFF", Toast.LENGTH_SHORT).show();
                    manager.cancel(pi);
                }
            }
        });
    }
}