package com.seawalker.awesomeapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Display

/**
 * Created by LeonthePro7 on 6/18/2017.
 */

public class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, DisplayActivity::class.java)
        startActivity(intent)
    }
}