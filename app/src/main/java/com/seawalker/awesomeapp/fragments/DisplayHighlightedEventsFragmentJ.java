package com.seawalker.awesomeapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

import com.seawalker.awesomeapp.Model.ModelItemHighlightedEventJ;
import com.seawalker.awesomeapp.R;
import com.seawalker.awesomeapp.adapters.RVAdapterHighlightedEventsJ;

import java.util.ArrayList;

import static com.seawalker.awesomeapp.Model.ModelItemHighlightedEventJ.dummyHLEsCreator;

/**
 * Created by leon on 6/19/17.
 */

public class DisplayHighlightedEventsFragmentJ extends Fragment {
    private static final String LOG_TAG = DisplayHighlightedEventsFragmentJ.class.getSimpleName();

    public static final String IDENTIFIER_HIGHLIGHTED_EVENT = "identifier_highlighted_event";

    private TextView titleTV;
    // todo: change all RecyclerViews into ListViews
    private RecyclerView displayHLEsRV;

    private Context context;
    private ArrayList<ModelItemHighlightedEventJ> highlightedEvents;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        highlightedEvents = new ArrayList<>();
        this.context = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            if (savedInstanceState.getParcelableArrayList(IDENTIFIER_HIGHLIGHTED_EVENT) != null) {
                highlightedEvents = savedInstanceState.getParcelableArrayList(IDENTIFIER_HIGHLIGHTED_EVENT);
            }
        } else if (getArguments() != null) {
            if (getArguments().getParcelableArrayList(IDENTIFIER_HIGHLIGHTED_EVENT) != null) {
                highlightedEvents = getArguments().getParcelableArrayList(IDENTIFIER_HIGHLIGHTED_EVENT);
            }
        } else {
            highlightedEvents = dummyHLEsCreator();
        }

        RVAdapterHighlightedEventsJ adapter = new RVAdapterHighlightedEventsJ(context, highlightedEvents);

        View view = inflater.inflate(R.layout.hles_display_layout, container, false);
        titleTV = (TextView) view.findViewById(R.id.title_display_hles);
        displayHLEsRV = (RecyclerView) view.findViewById(R.id.rv_display_hles);
        displayHLEsRV.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true));
        displayHLEsRV.setAdapter(adapter);

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(IDENTIFIER_HIGHLIGHTED_EVENT, highlightedEvents);
    }

}