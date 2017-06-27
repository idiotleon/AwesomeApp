package com.seawalker.awesomeapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seawalker.awesomeapp.R;
import com.seawalker.awesomeapp.utilies.TimeUtils;

/**
 * Created by Leon on 6/20/2017.
 */

public class DisplayFragmentJ extends Fragment {
    private static final String LOG_TAG = DisplayFragmentJ.class.getSimpleName();

    private TextView dayOfWeekTV;
    private TextView dateTV;
    private TextView temperatureTV;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTheme(R.style.Theme_AppCompat_NoActionBar);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_display_layout, container, false);
        // todo: apply JSON parsing fetching HLEs here
        DisplayHighlightedEventsFragmentJ displayHighlightedEventsFragmentJ =
                new DisplayHighlightedEventsFragmentJ();

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_display_highlighted_events, displayHighlightedEventsFragmentJ)
                .addToBackStack(null)
                .commit();

        // todo: apply JSON parsing fetching posts here
        DisplayPostsFragmentJ displayPostsFragmentJ = new DisplayPostsFragmentJ();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_display_posts, displayPostsFragmentJ)
                .addToBackStack(null)
                .commit();

        dayOfWeekTV = (TextView) view.findViewById(R.id.tv_day_of_week);
        dateTV = (TextView) view.findViewById(R.id.tv_date);
        temperatureTV = (TextView) view.findViewById(R.id.tv_temperature);

        dayOfWeekTV.setText(TimeUtils.getCurrentDayOfWeek());
        dateTV.setText(TimeUtils.getCurrentDate());
        temperatureTV.setText("GeoLocatio->Weather");

        return view;
    }
}
