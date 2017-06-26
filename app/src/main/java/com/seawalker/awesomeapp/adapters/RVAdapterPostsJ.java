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

import com.seawalker.awesomeapp.Model.ModelItemPostJ;
import com.seawalker.awesomeapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Leon on 6/24/2017.
 */

public class RVAdapterPostsJ extends RecyclerView.Adapter<RVAdapterPostsJ.ViewHolder> {

    private static final String LOG_TAG = RVAdapterPostsJ.class.getSimpleName();

    private Context context;
    private ArrayList<ModelItemPostJ> posts;

    public RVAdapterPostsJ(Context context, ArrayList<ModelItemPostJ> posts) {
        Log.v(LOG_TAG, "RVAdapterPostsJ has been constructed!");
        this.context = context;
        this.posts = posts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        ModelItemPostJ currentPost = posts.get(position);
        String title = currentPost.getTitle();
        Log.v(LOG_TAG, "title, post item: " + title);
        holder.titleTV.setText(title);
        holder.abstractTV.setText(currentPost.getAbstractContent());
        holder.orgNameTV.setText(currentPost.getOrgName());
        holder.countDownTV.setText(currentPost.getCountDown());

        String iconImageUrl = currentPost.getIconImageURL();
        Log.v(LOG_TAG, "iconImageUrl: " + iconImageUrl);
        if (iconImageUrl != null && iconImageUrl != "") {
            Picasso.with(context).cancelRequest(holder.iconIV);
            Picasso.with(context).load(currentPost.getIconImageURL()).into(holder.iconIV);
        }

        String backgroundImageUrl = currentPost.getBackgroundImageURL();
        Log.v(LOG_TAG, "backgroundImageUrl: " + backgroundImageUrl);
        if (backgroundImageUrl != null && backgroundImageUrl != "") {
            Picasso.with(context).cancelRequest(holder.backgroundIV);
            Picasso.with(context).load(currentPost.getBackgroundImageURL()).into(holder.backgroundIV);
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
        return posts.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconIV;
        TextView titleTV;
        TextView abstractTV;
        TextView orgNameTV;
        TextView countDownTV;
        ImageView backgroundIV;
        Button optionsBTN;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTV = (TextView) itemView.findViewById(R.id.tv_post_title);
            iconIV = (ImageView) itemView.findViewById(R.id.iv_post_icon);
            abstractTV = (TextView) itemView.findViewById(R.id.tv_post_abstract);
            orgNameTV = (TextView) itemView.findViewById(R.id.tv_post_org_name);
            countDownTV = (TextView) itemView.findViewById(R.id.tv_post_count_down);
            backgroundIV = (ImageView) itemView.findViewById(R.id.iv_post_background);
            optionsBTN = (Button) itemView.findViewById(R.id.btn_options_post);
        }
    }
}
