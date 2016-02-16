package com.example.david.watchcatalog.listeners;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

/**
 * WatchActivity TabLayout listener
 * <p/>
 * Created by ronan on 2/16/2016.
 */
public class TabLayoutListener implements TabLayout.OnTabSelectedListener {

    private ViewPager viewPager;

    public TabLayoutListener(ViewPager viewPager) {
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
