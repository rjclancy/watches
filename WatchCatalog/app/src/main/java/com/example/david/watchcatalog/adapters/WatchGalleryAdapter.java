package com.example.david.watchcatalog.adapters;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.david.watchcatalog.activities.WatchActivity;
import com.example.david.watchcatalog.constants.WatchConstants;
import com.example.david.watchcatalog.models.WatchModel;

import java.util.List;

/**
 *
 * Created by David on 04/02/2016.
 */
public class WatchGalleryAdapter extends BaseAdapter {

    private Context ctx;

    private List<WatchModel> watches;

    GridView grid;

    public WatchGalleryAdapter(Context ctx, List<WatchModel> watches) {
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
            //just creating the view if not already present
        } else {
            imageView = (ImageView) convertView;
            //re-using if already here
        }

        imageView.setImageResource(watches.get(position).getImageId());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(setColumnParams(parent), setColumnParams(parent)));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, WatchActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("watchId", watches.get(position).getId());// TODO create constant
                bundle.putString(WatchConstants.BUNDLE_NAME, watches.get(position).getName());
                bundle.putString("price", watches.get(position).getPrice());// TODO create constant
                bundle.putString("description", watches.get(position).getDescription());// TODO create constant
                intent.putExtras(bundle);
                ctx.startActivity(intent);
            }
        });

        return imageView;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private int setColumnParams(ViewGroup parent) {
        grid = (GridView) parent;
        return grid.getColumnWidth();
    }
}
