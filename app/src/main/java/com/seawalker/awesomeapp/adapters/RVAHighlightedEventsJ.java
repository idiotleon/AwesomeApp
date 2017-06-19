package com.seawalker.awesomeapp.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.seawalker.awesomeapp.Model.ModelItemHighlightEvent;

import java.util.ArrayList;

/**
 * Created by LeonthePro7 on 6/18/2017.
 */

public class RVAHighlightedEventsJ extends BaseAdapter {
    private Context context;
    private ArrayList<ModelItemHighlightEvent> highlightEvents;

    public RVAHighlightedEventsJ(Context context, ArrayList<ModelItemHighlightEvent> highlightEvents) {
        this.context = context;
        this.highlightEvents = highlightEvents;
    }

    @Override
    public int getCount() {
        return highlightEvents.size();
    }

    @Override
    public Object getItem(int position) {
        return highlightEvents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return highlightEvents.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
