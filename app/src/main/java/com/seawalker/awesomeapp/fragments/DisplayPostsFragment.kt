package com.seawalker.awesomeapp.fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seawalker.awesomeapp.R

/**
 * Created by LeonthePro7 on 6/18/2017.
 */

class DisplayPostsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater!!.inflate(R.layout.posts_display_layout, container)
        return view
    }
}
