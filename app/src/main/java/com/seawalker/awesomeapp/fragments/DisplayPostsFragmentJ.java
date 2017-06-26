package com.seawalker.awesomeapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seawalker.awesomeapp.Model.ModelItemPostJ;
import com.seawalker.awesomeapp.R;
import com.seawalker.awesomeapp.adapters.RVAdapterPostsJ;

import java.util.ArrayList;

import static com.seawalker.awesomeapp.Model.ModelItemPostJ.dummyPostsCreator;

/**
 * Created by leon on 6/19/17.
 */

public class DisplayPostsFragmentJ extends Fragment {

    private static final String LOG_TAG = DisplayPostsFragmentJ.class.getSimpleName();

    public static final String IDENTIFIER_POST = "identifier_post";

    private TextView titleTV;
    // todo: change all RecyclerViews into ListViews
    private RecyclerView displayPostsRV;

    private Context context;
    private ArrayList<ModelItemPostJ> posts;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        posts = new ArrayList<>();
        this.context = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            if (savedInstanceState.getParcelableArrayList(IDENTIFIER_POST) != null) {
                posts = savedInstanceState.getParcelableArrayList(IDENTIFIER_POST);
            }
        } else if (getArguments() != null) {
            if (getArguments().getParcelableArrayList(IDENTIFIER_POST) != null) {
                posts = getArguments().getParcelableArrayList(IDENTIFIER_POST);
            }
        } else {
            posts = dummyPostsCreator();
        }

        RVAdapterPostsJ adapter = new RVAdapterPostsJ(context, posts);

        View view = inflater.inflate(R.layout.posts_display_layout, container, false);
        titleTV = (TextView) view.findViewById(R.id.title_display_posts);
        displayPostsRV = (RecyclerView) view.findViewById(R.id.rv_display_posts);
        displayPostsRV.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        displayPostsRV.setHasFixedSize(true);
        displayPostsRV.setAdapter(adapter);

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(IDENTIFIER_POST, posts);
    }
}
