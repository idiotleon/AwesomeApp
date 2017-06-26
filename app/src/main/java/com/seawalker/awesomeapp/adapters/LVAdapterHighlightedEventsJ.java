package com.seawalker.awesomeapp.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.seawalker.awesomeapp.Model.ModelItemHighlightedEventJ;
import com.seawalker.awesomeapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by LeonthePro7 on 6/18/2017.
 */

public class LVAdapterHighlightedEventsJ extends BaseAdapter {
    private final static String LOG_TAG = LVAdapterHighlightedEventsJ.class.getSimpleName();

    private Context context;
    private ArrayList<ModelItemHighlightedEventJ> highlightEvents;

    public LVAdapterHighlightedEventsJ(Context context, ArrayList<ModelItemHighlightedEventJ> highlightEvents) {
        this.context = context;
        this.highlightEvents = highlightEvents;
    }

    @Override
    public int getCount() {
        return highlightEvents.size();
    }

    @Override
    public ModelItemHighlightedEventJ getItem(int position) {
        return highlightEvents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return highlightEvents.get(position).getId();
    }

    public String getItemUUID(int position) {
        return getItem(position).getUUID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            Log.i(LOG_TAG, "convertView is null");
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.item_highlighted_event, null);
            viewHolder = new ViewHolder();
            viewHolder.titleTV = (TextView) convertView.findViewById(R.id.tv_hle_title);
            viewHolder.iconIV = (ImageView) convertView.findViewById(R.id.iv_hle_icon);
            viewHolder.abstractTV = (TextView) convertView.findViewById(R.id.tv_hle_abstract);
            viewHolder.orgNameTV = (TextView) convertView.findViewById(R.id.tv_hle_org_name);
            viewHolder.countDownTV = (TextView) convertView.findViewById(R.id.tv_hle_count_down);
            viewHolder.backgroundIV = (ImageView) convertView.findViewById(R.id.iv_hle_background);
            convertView.setTag(viewHolder);
        } else {
            Log.i(LOG_TAG, "convertView is NOT null");
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ModelItemHighlightedEventJ currentHighlightedEvent = getItem(position);
        String title = currentHighlightedEvent.getTitle();
        Log.v(LOG_TAG, "title: " + title);
        viewHolder.titleTV.setText(title);
        String abstractContent = currentHighlightedEvent.getAbstractContent();
        viewHolder.abstractTV.setText(abstractContent);
        String orgName = currentHighlightedEvent.getOrgName();
        viewHolder.orgNameTV.setText(orgName);
        String countDown = currentHighlightedEvent.getCountDown();
        Log.v(LOG_TAG, "countDown: " + countDown);
        viewHolder.countDownTV.setText(countDown);

        String iconImageUrl = currentHighlightedEvent.getIconImageURL();
        Log.v(LOG_TAG, "iconImageUrl: " + iconImageUrl);
        if (iconImageUrl != null && iconImageUrl != "") {
            Picasso.with(context).cancelRequest(viewHolder.iconIV);
            Picasso.with(context).load(currentHighlightedEvent.getIconImageURL()).into(viewHolder.iconIV);
        }

        String backgroundImageUrl = currentHighlightedEvent.getBackgroundImageURL();
        Log.v(LOG_TAG, "backgroundImageUrl: " + backgroundImageUrl);
        if (backgroundImageUrl != null && backgroundImageUrl != "") {
            Picasso.with(context).cancelRequest(viewHolder.backgroundIV);
            Picasso.with(context).load(currentHighlightedEvent.getBackgroundImageURL()).into(viewHolder.backgroundIV);
        }

        return convertView;
    }

    private static class ViewHolder {
        ImageView iconIV;
        TextView titleTV;
        TextView abstractTV;
        TextView orgNameTV;
        TextView countDownTV;
        ImageView backgroundIV;
    }
}
