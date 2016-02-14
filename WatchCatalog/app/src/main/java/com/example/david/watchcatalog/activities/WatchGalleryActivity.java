package com.example.david.watchcatalog.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.david.watchcatalog.R;
import com.example.david.watchcatalog.adapters.WatchGalleryAdapter;
import com.example.david.watchcatalog.constants.WatchConstants;
import com.example.david.watchcatalog.db.SQLiteHelper;
import com.example.david.watchcatalog.models.WatchGalleryModel;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WatchGalleryActivity extends AppCompatActivity {

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.watchesGrid) GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_gallery);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        final SQLiteHelper db = new SQLiteHelper(this);
        List<WatchGalleryModel> watches = db.getAllWatches();

        gridview.setAdapter(new WatchGalleryAdapter(this, watches));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), WatchActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(WatchConstants.BUNDLE_WATCH_ID, view.getId());
                Log.i("id","" + view.getId());
                intent.putExtras(bundle);
                WatchGalleryActivity.this.startActivity(intent);
            }
        });
    }
}



