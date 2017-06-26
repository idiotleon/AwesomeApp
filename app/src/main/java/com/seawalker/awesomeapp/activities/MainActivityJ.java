package com.seawalker.awesomeapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.seawalker.awesomeapp.R;

public class MainActivityJ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent displayIntent = new Intent(this, DisplayActivityJ.class);
        startActivity(displayIntent);

        // todo: setup ViewPager
    }
}
