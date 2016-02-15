package com.example.david.watchcatalog.adapters;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.david.watchcatalog.R;
import com.example.david.watchcatalog.models.WatchGalleryModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Adapter for main watch gallery
 * <p/>
 * Created by David on 04/02/2016.
 */
public class WatchGalleryActivityGridAdapter extends BaseAdapter {

    private Context context;
    private List<WatchGalleryModel> watches;

    public WatchGalleryActivityGridAdapter(Context context, List<WatchGalleryModel> watches) {
        this.context = context;
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
        return Long.parseLong(watches.get(position).getId());
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.watch_gallery_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.watchGalleryItem = (ImageView) convertView.findViewById(R.id.watchGalleryImage);
            convertView.setLayoutParams(new GridView.LayoutParams(setColumnParams(parent), setColumnParams(parent)));
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        convertView.setId(Integer.valueOf(watches.get(position).getId()));
        // TODO (David) add loading spinner to Picasso {@see http://stackoverflow.com/questions/24826459/animated-loading-image-in-picasso}
        Picasso.with(context).load(Integer.parseInt(watches.get(position).getResourceId())).into(viewHolder.watchGalleryItem);
        return convertView;
    }

    private static class ViewHolder {
        ImageView watchGalleryItem;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private int setColumnParams(ViewGroup parent) {
        GridView grid = (GridView) parent;
        return grid.getColumnWidth();
    }
}
