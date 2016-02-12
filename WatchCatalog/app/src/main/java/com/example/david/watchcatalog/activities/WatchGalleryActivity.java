package com.example.david.watchcatalog.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.david.watchcatalog.R;
import com.example.david.watchcatalog.adapters.WatchGalleryAdapter;
import com.example.david.watchcatalog.constants.WatchConstants;
import com.example.david.watchcatalog.db.SQLiteHelper;
import com.example.david.watchcatalog.models.WatchGalleryModel;

import java.util.List;

public class WatchGalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_gallery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final SQLiteHelper db = new SQLiteHelper(this);
        List<WatchGalleryModel> watches = db.getAllWatches();

        GridView gridview = (GridView) findViewById(R.id.watchesGrid);
        gridview.setAdapter(new WatchGalleryAdapter(this, watches));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), WatchActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(WatchConstants.BUNDLE_WATCH_ID, Integer.parseInt(view.getTag().toString()));
                intent.putExtras(bundle);
                WatchGalleryActivity.this.startActivity(intent);
            }
        });
    }
}



