package com.seawalker.awesomeapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.seawalker.awesomeapp.Model.ModelItemHighlightedEvent;
import com.seawalker.awesomeapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by LeonthePro7 on 6/18/2017.
 */

public class RVAHighlightedEventsJ extends BaseAdapter {
    private Context context;
    private ArrayList<ModelItemHighlightedEvent> highlightEvents;

    public RVAHighlightedEventsJ(Context context, ArrayList<ModelItemHighlightedEvent> highlightEvents) {
        this.context = context;
        this.highlightEvents = highlightEvents;
    }

    @Override
    public int getCount() {
        return highlightEvents.size();
    }

    @Override
    public ModelItemHighlightedEvent getItem(int position) {
        return highlightEvents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return highlightEvents.get(position).getId();
    }

    public String getItemUUID(int position){
        return getItem(position).getUUID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.item_highlighted_event, null);
            viewHolder.titleTV = (TextView) convertView.findViewById(R.id.tv_hle_title);
            viewHolder.iconIV = (ImageView) convertView.findViewById(R.id.iv_hle_icon);
            viewHolder.abstractTV = (TextView)convertView.findViewById(R.id.tv_hle_abstract);
            viewHolder.orgNameTV = (TextView)convertView.findViewById(R.id.tv_hle_org_name);
            viewHolder.countDownTV = (TextView)convertView.findViewById(R.id.tv_hle_count_down);
            viewHolder.backgroundIV = (ImageView) convertView.findViewById(R.id.iv_hle_background);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ModelItemHighlightedEvent currentHighlightedEvent = getItem(position);
        viewHolder.titleTV.setText(currentHighlightedEvent.getTitle());
        viewHolder.abstractTV.setText(currentHighlightedEvent.getAbstractContent());
        viewHolder.orgNameTV.setText(currentHighlightedEvent.getOrgName());
        viewHolder.countDownTV.setText(currentHighlightedEvent.getCountDown());

        if(currentHighlightedEvent.getIconImageURL() != null) {
            Picasso.with(context).load(currentHighlightedEvent.getIconImageURL()).into(viewHolder.iconIV);
        }

        if(currentHighlightedEvent.getBackgroundImageURL() != null) {
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
