package com.seawalker.awesomeapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.seawalker.awesomeapp.Model.ModelItemHighlightedEventJ;
import com.seawalker.awesomeapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Leon on 6/24/2017.
 */

public class RVAdapterHighlightedEventsJ extends RecyclerView.Adapter<RVAdapterHighlightedEventsJ.ViewHolder> {

    private static final String LOG_TAG = RVAdapterHighlightedEventsJ.class.getSimpleName();

    private ArrayList<ModelItemHighlightedEventJ> highlightedEvents;
    private Context context;

    public RVAdapterHighlightedEventsJ(Context context, ArrayList<ModelItemHighlightedEventJ> highlightedEvents) {
        this.highlightedEvents = highlightedEvents;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_highlighted_event, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ModelItemHighlightedEventJ currentHighlightedEvent = highlightedEvents.get(position);
        String title = currentHighlightedEvent.getTitle();
        Log.v(LOG_TAG, "title: " + title);
        holder.titleTV.setText(title);
        String abstractContent = currentHighlightedEvent.getAbstractContent();
        holder.abstractTV.setText(abstractContent);
        String orgName = currentHighlightedEvent.getOrgName();
        holder.orgNameTV.setText(orgName);
        String countDown = currentHighlightedEvent.getCountDown();
        Log.v(LOG_TAG, "countDown: " + countDown);
        holder.countDownTV.setText(countDown);

        String iconImageUrl = currentHighlightedEvent.getIconImageURL();
        Log.v(LOG_TAG, "iconImageUrl: " + iconImageUrl);
        if (iconImageUrl != null && iconImageUrl != "") {
            Picasso.with(context).cancelRequest(holder.iconIV);
            Picasso.with(context).load(currentHighlightedEvent.getIconImageURL()).into(holder.iconIV);
        }

        String backgroundImageUrl = currentHighlightedEvent.getBackgroundImageURL();
        Log.v(LOG_TAG, "backgroundImageUrl: " + backgroundImageUrl);
        if (backgroundImageUrl != null && backgroundImageUrl != "") {
            Picasso.with(context).load(currentHighlightedEvent.getBackgroundImageURL()).into(holder.backgroundIV);
        }

        holder.optionsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(context, holder.optionsBTN);
                popup.inflate(R.menu.menu_hel_diplay_fragment);

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_refresh_display_hles:
                                Toast.makeText(context, "Refresh triggered", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });

                popup.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        int count = highlightedEvents.size();
        Log.v(LOG_TAG, "getItemCount: " + count);
        return count;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconIV;
        TextView titleTV;
        TextView abstractTV;
        TextView orgNameTV;
        TextView countDownTV;
        ImageView backgroundIV;
        Button optionsBTN;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTV = (TextView) itemView.findViewById(R.id.tv_hle_title);
            iconIV = (ImageView) itemView.findViewById(R.id.iv_hle_icon);
            abstractTV = (TextView) itemView.findViewById(R.id.tv_hle_abstract);
            orgNameTV = (TextView) itemView.findViewById(R.id.tv_hle_org_name);
            countDownTV = (TextView) itemView.findViewById(R.id.tv_hle_count_down);
            backgroundIV = (ImageView) itemView.findViewById(R.id.iv_hle_background);
            optionsBTN = (Button) itemView.findViewById(R.id.btn_options_hles);
        }
    }
}
