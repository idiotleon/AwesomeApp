package com.seawalker.awesomeapp.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.seawalker.awesomeapp.R;
import com.seawalker.awesomeapp.fragments.DisplayHighlightedEventsFragmentJ;
import com.seawalker.awesomeapp.fragments.DisplayPostsFragmentJ;
import com.seawalker.awesomeapp.utilies.TimeUtils;

/**
 * Created by Leon on 6/20/2017.
 */

public class DisplayActivityJ extends AppCompatActivity {

    private TextView dayOfWeekTV;
    private TextView dateTV;
    private TextView temperatureTV;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_AppCompat_NoActionBar);
        setContentView(R.layout.main_display_layout);

        // todo: apply JSON parsing fetching HLEs here
        DisplayHighlightedEventsFragmentJ displayHighlightedEventsFragmentJ =
                new DisplayHighlightedEventsFragmentJ();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_display_highlighted_events, displayHighlightedEventsFragmentJ)
                .addToBackStack(null)
                .commit();

        // todo: apply JSON parsing fetching posts here
        DisplayPostsFragmentJ displayPostsFragmentJ = new DisplayPostsFragmentJ();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_display_posts, displayPostsFragmentJ)
                .addToBackStack(null)
                .commit();

        dayOfWeekTV = (TextView) findViewById(R.id.tv_day_of_week);
        dateTV = (TextView) findViewById(R.id.tv_date);
        temperatureTV = (TextView) findViewById(R.id.tv_temperature);

        dayOfWeekTV.setText(TimeUtils.getCurrentDayOfWeek());
        dateTV.setText(TimeUtils.getCurrentDate());
        temperatureTV.setText("GeoLocatio->Weather");

    }
}
