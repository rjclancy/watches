package com.example.david.watchcatalog.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.david.watchcatalog.fragments.WatchActivityCommentFragment;
import com.example.david.watchcatalog.fragments.WatchActivityInfoFragment;

/**
 * WatchActivity fragment adapter
 * <p/>
 * Created by ronan on 2/15/2016.
 */
public class WatchActivityFragmentAdapter extends FragmentStatePagerAdapter {
    int numOfTabs;

    public WatchActivityFragmentAdapter(FragmentManager fragmentManager, int numOfTabs) {
        super(fragmentManager);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new WatchActivityInfoFragment();
            case 1:
                return new WatchActivityCommentFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
