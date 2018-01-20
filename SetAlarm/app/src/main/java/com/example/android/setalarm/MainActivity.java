package com.example.android.setalarm;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import static android.os.Build.VERSION_CODES.M;


public class MainActivity extends AppCompatActivity {
    // Set how long the user wants to sleep
    int hoursToSleep = 7;
    int minutesToSleep = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


        // Get the current time
        Calendar currentTime = Calendar.getInstance();
        int hour = currentTime.get(Calendar.HOUR_OF_DAY);
        int minutes = currentTime.get(Calendar.MINUTE);

        // Calculate the wake up time
        if((minutes + minutesToSleep)>= 60){
            minutes = minutes + minutesToSleep -60;
            hoursToSleep = hoursToSleep +1;
        }
        else{
            minutes = minutes+ minutesToSleep;
        }
        if((hour+hoursToSleep)>=24){
            hour = hour + hoursToSleep-24;
        }
        else{
            hour = hour + hoursToSleep;
        }

        // Use an intent to set the alarm
        Intent alarmClock = new Intent(AlarmClock.ACTION_SET_ALARM);
        alarmClock.putExtra(AlarmClock.EXTRA_MESSAGE, "New Alarm");
        alarmClock.putExtra(AlarmClock.EXTRA_HOUR, hour);
        alarmClock.putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        alarmClock.putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        startActivity(alarmClock);
        finish();

    }
}
