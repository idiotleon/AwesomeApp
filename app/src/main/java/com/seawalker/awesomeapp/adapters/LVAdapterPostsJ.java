package com.seawalker.awesomeapp.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.seawalker.awesomeapp.Model.ModelItemPostJ;
import com.seawalker.awesomeapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Leon on 6/19/2017.
 */

public class LVAdapterPostsJ extends BaseAdapter {
    private final static String LOG_TAG = LVAdapterPostsJ.class.getSimpleName();

    private Context context;
    private ArrayList<ModelItemPostJ> posts;

    public LVAdapterPostsJ(Context context, ArrayList<ModelItemPostJ> posts) {
        this.context = context;
        this.posts = posts;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public ModelItemPostJ getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.item_post, null);
            viewHolder = new ViewHolder();
            viewHolder.titleTV = (TextView) convertView.findViewById(R.id.tv_post_title);
            viewHolder.iconIV = (ImageView) convertView.findViewById(R.id.iv_post_icon);
            viewHolder.abstractTV = (TextView) convertView.findViewById(R.id.tv_post_abstract);
            viewHolder.orgNameTV = (TextView) convertView.findViewById(R.id.tv_post_org_name);
            viewHolder.countDownTV = (TextView) convertView.findViewById(R.id.tv_post_count_down);
            viewHolder.backgroundIV = (ImageView) convertView.findViewById(R.id.iv_post_background);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ModelItemPostJ currentPost = getItem(position);
        String title = currentPost.getTitle();
        Log.v(LOG_TAG, "title, post item: " + title);
        viewHolder.titleTV.setText(title);
        viewHolder.abstractTV.setText(currentPost.getAbstractContent());
        viewHolder.orgNameTV.setText(currentPost.getOrgName());
        viewHolder.countDownTV.setText(currentPost.getCountDown());

        String iconImageUrl = currentPost.getIconImageURL();
        Log.v(LOG_TAG, "iconImageUrl: " + iconImageUrl);
        if (iconImageUrl != null && iconImageUrl != "") {
            Picasso.with(context).cancelRequest(viewHolder.iconIV);
            Picasso.with(context).load(currentPost.getIconImageURL()).into(viewHolder.iconIV);
        }

        String backgroundImageUrl = currentPost.getBackgroundImageURL();
        Log.v(LOG_TAG, "backgroundImageUrl: " + backgroundImageUrl);
        if (backgroundImageUrl != null && backgroundImageUrl != "") {
            Picasso.with(context).cancelRequest(viewHolder.backgroundIV);
            Picasso.with(context).load(currentPost.getBackgroundImageURL()).into(viewHolder.backgroundIV);
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
