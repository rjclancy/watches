package com.example.david.watchcatalog.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.david.watchcatalog.R;

import java.util.List;

import butterknife.ButterKnife;

/**
 * WatchActivity ViewPager adapter
 * <p/>
 * Created by David on 04/02/2016.
 */
public class WatchActivityPagerAdapter extends PagerAdapter {

    private List<String> watchIds;
    private LayoutInflater layoutInflater;

    public WatchActivityPagerAdapter(Context context, List<String> watchIds) {
        this.watchIds = watchIds;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return watchIds.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View item_view = layoutInflater.inflate(R.layout.watch_pager_item, container, false);
        ImageView imageView = ButterKnife.findById(item_view, R.id.watchPagerImage);
        imageView.setImageResource(Integer.parseInt(watchIds.get(position)));
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
