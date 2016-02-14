package com.example.david.watchcatalog.activities;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.david.watchcatalog.R;
import com.example.david.watchcatalog.adapters.WatchAdapter;
import com.example.david.watchcatalog.constants.WatchConstants;
import com.example.david.watchcatalog.db.SQLiteHelper;
import com.example.david.watchcatalog.models.WatchModel;
import com.example.david.watchcatalog.utils.Utils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * The class {@code WatchActivity} is used for WatchUI purposes
 *
 * @author david
 */
public class WatchActivity extends AppCompatActivity {

    @Bind(R.id.watchesName)
    TextView name;
    @Bind(R.id.watchesPrice)
    TextView price;
    @Bind(R.id.watchesDescription)
    TextView description;
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    private SQLiteHelper db;
    private int bundle_id;
    private List<String> imageResourceIds;
    private WatchModel watch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);
        ButterKnife.bind(this);

        // Initiate bundle data
        initBundleVariable(getIntent().getExtras());

        // Link sql instance
        db = new SQLiteHelper(this);
        watch = db.getWatch(bundle_id);
        imageResourceIds = db.getWatchImageResourceIds(bundle_id);

        // Initialize Toolbar attrs
        initToolbar(watch.getName());

        // Initialize view data
        name.setText(watch.getName());
        price.setText("$ " + watch.getPrice());
        description.setText(watch.getDescription());

        initPagerAdapter();
        initAnimations();
    }

    private void initPagerAdapter() {
        WatchAdapter adapter = new WatchAdapter(this, imageResourceIds);
        viewPager.setAdapter(adapter);
    }

    private void initBundleVariable(Bundle bundle) {
        bundle_id = bundle.getInt(WatchConstants.BUNDLE_WATCH_ID);
    }

    private void initAnimations() {
        Animation slide_up = AnimationUtils.loadAnimation(this,
                R.anim.slide_up);
        Animation slide_up_1 = AnimationUtils.loadAnimation(this,
                R.anim.slide_up);
        Animation slide_up_2 = AnimationUtils.loadAnimation(this,
                R.anim.slide_up);

        slide_up.setDuration(900);
        slide_up_1.setDuration(1150);
        slide_up_2.setDuration(1350);

        name.setAnimation(slide_up);
        price.setAnimation(slide_up_1);
        description.setAnimation(slide_up_2);
    }

    private void initToolbar(String title) {
        // Setup toolbar attrs
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Utils.getDetailToolbarColorFromImage(this, Integer.valueOf(imageResourceIds.get(0)))));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
