package com.example.david.watchcatalog.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;

import com.example.david.watchcatalog.R;
import com.example.david.watchcatalog.adapters.WatchGalleryAdapter;
import com.example.david.watchcatalog.db.SQLiteHelper;
import com.example.david.watchcatalog.models.WatchModel;

import java.util.List;

public class WatchGalleryActivity extends AppCompatActivity {

    SQLiteHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_gallery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = new SQLiteHelper(this);
        List<WatchModel> watches = db.getAllWatches();

        GridView gridview = (GridView) findViewById(R.id.watchesGrid);
        gridview.setAdapter(new WatchGalleryAdapter(this, watches));
    }
}



