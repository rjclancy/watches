package com.example.david.watchcatalog.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.watchcatalog.R;

import java.util.List;

/**
 * Created by David on 04/02/2016.
 */
public class WatchAdapter extends PagerAdapter {

    private Context ctx;
    private LayoutInflater layoutInflater;
    private List<String> watchIds;
    private Animation slide_down;

    public WatchAdapter(Context ctx, List<String> watchIds) {
        this.ctx = ctx;
        this.watchIds = watchIds;
        slide_down = AnimationUtils.loadAnimation(ctx,
                R.anim.slide_down);
        slide_down.setStartOffset(500);
    }

    @Override
    public int getCount() {
        return watchIds.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return (view == (LinearLayout) o);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.content_activity_watch, container, false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.watchesGrid);
        imageView.setImageResource(Integer.parseInt(watchIds.get(position)));// Problem with this line
        container.addView(item_view);
        imageView.setAnimation(slide_down);

        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
