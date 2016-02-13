package com.example.david.watchcatalog.adapters;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.david.watchcatalog.models.WatchGalleryModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Adapter for main watch gallery
 *
 * Created by David on 04/02/2016.
 */
public class WatchGalleryAdapter extends BaseAdapter {

    private Context ctx;
    private List<WatchGalleryModel> watches;

    public WatchGalleryAdapter(Context ctx, List<WatchGalleryModel> watches) {
        this.ctx = ctx;
        this.watches = watches;
    }

    @Override
    public int getCount() {
        return watches.size();
    }

    @Override
    public Object getItem(int position) {
        return watches.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(ctx);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setLayoutParams(new GridView.LayoutParams(setColumnParams(parent), setColumnParams(parent)));
            imageView.setTag(watches.get(position).getId());
        } else {
            imageView = (ImageView) convertView;
        }

        // TODO (David) add loading spinner to Picasso {@see http://stackoverflow.com/questions/24826459/animated-loading-image-in-picasso}
        Picasso.with(ctx).load(Integer.parseInt(watches.get(position).getResourceId())).into(imageView);
        return imageView;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private int setColumnParams(ViewGroup parent) {
        GridView grid = (GridView) parent;
        return grid.getColumnWidth();
    }
}
