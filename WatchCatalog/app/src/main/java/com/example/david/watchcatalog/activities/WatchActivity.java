package com.example.david.watchcatalog.activities;

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

/**
 * The class {@code WatchActivity} is used for WatchUI purposes
 *
 * @author david
 */
public class WatchActivity extends AppCompatActivity {

    private TextView name;
    private TextView price;
    private TextView description;
    private int bundle_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);

        // Initiate bundle data
        initBundleVariable(getIntent().getExtras());

        // Link sql instance
        final SQLiteHelper db = new SQLiteHelper(this);
        WatchModel watch = db.getWatch(bundle_id);

        // Setup toolbar attrs
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(watch.getName());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Set view data
        name = (TextView) findViewById(R.id.watchesName);
        price = (TextView) findViewById(R.id.watchesPrice);
        description = (TextView) findViewById(R.id.watchesDescription);
        name.setText(watch.getName());
        price.setText("$ " + watch.getPrice());
        description.setText(watch.getDescription());

        // Set up page image adapter
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        WatchAdapter adapter = new WatchAdapter(this, db.getWatchImageResourceIds(bundle_id));
        viewPager.setAdapter(adapter);

        // Setup animations
        setAnimations();
    }

    /**
     * Get data from bundle and setup variables
     *
     * @param bundle intent bundle
     */
    private void initBundleVariable(Bundle bundle) {
        bundle_id = bundle.getInt(WatchConstants.BUNDLE_WATCH_ID);
    }

    /**
     * Setup activity animations
     */
    private void setAnimations() {
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
