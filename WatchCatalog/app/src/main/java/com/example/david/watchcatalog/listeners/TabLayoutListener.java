package com.example.david.watchcatalog.listeners;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

/**
 * TabLayout WatchActivity listener
 *
 * Created by ronan on 2/16/2016.
 */
public class TabLayoutListener implements TabLayout.OnTabSelectedListener {

    ViewPager viewPager;

    public TabLayoutListener(ViewPager viewPager){
        this.viewPager = viewPager;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
