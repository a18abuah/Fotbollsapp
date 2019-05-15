package com.example.fotbollsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class Fotboll2 extends AppCompatActivity {
    private static final String TAG = "Fotboll2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotboll2);
        TextView incomingData = (TextView) findViewById(R.id.textFromMain);
        TextView  data = (TextView) findViewById(R.id.textFromMain2);
        Log.d(TAG, "onCreate: Started");

        Intent incomingIntent =getIntent();
        String incomingName =incomingIntent.getStringExtra("name");
        String  datastring =incomingIntent.getStringExtra("location");
        Log.d(TAG, "oncreate: Found incoming name: " +incomingName);
        incomingData.setText(incomingName);
        data.setText(datastring);
    }
}
