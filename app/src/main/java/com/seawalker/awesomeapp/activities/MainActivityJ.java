package com.seawalker.awesomeapp.activities;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.seawalker.awesomeapp.R;
import com.seawalker.awesomeapp.fragments.DisplayFragmentJ;
import com.seawalker.awesomeapp.fragments.GroupFragment;
import com.seawalker.awesomeapp.fragments.MeFragment;
import com.seawalker.awesomeapp.fragments.StatsFragment;

import java.util.List;

public class MainActivityJ extends AppCompatActivity {
    private static final String LOG_TAG = MainActivityJ.class.getSimpleName();

    private final int VIEW_PAGER_NUM = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // todo: setup ViewPager
        setupViewPager();
    }

    private void setupViewPager() {
        final ViewPager viewPager = (ViewPager) findViewById(R.id.vp_main_activity);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        final BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bnv_main_activity);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bnv_home:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.bnv_group:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.bnv_stats:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.bnv_me:
                        viewPager.setCurrentItem(3);
                        break;
                }
                return false;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            MenuItem prevMenuItem;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }

                Log.v(LOG_TAG, "onPageSelected: " + position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new DisplayFragmentJ();
                case 1:
                    return new GroupFragment();
                case 2:
                    return new StatsFragment();
                case 3:
                    return new MeFragment();
            }

            return null;
        }

        @Override
        public int getCount() {
            return VIEW_PAGER_NUM;
        }
    }
}
