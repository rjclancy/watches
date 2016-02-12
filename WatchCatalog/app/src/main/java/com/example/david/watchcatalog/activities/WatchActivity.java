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

/**
 * The class {@code WatchActivity} is used for WatchUI perposes
 *
 * @author david
 */
public class WatchActivity extends AppCompatActivity {

    private TextView name;
    private TextView price;
    private TextView description;

    private int bundle_id;
    private String bundle_name;
    private String bundle_price;
    private String bundle_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        SQLiteHelper db = new SQLiteHelper(this);

        Bundle bundle = getIntent().getExtras();
        initBundleVariable(bundle);

        name = (TextView) findViewById(R.id.watchesName);
        price = (TextView) findViewById(R.id.watchesPrice);
        description = (TextView) findViewById(R.id.watchesDescription);
        name.setText(bundle_name);
        price.setText("$ " + bundle_price);
        description.setText(bundle_description);

        setAnimations();

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        WatchAdapter adapter = new WatchAdapter(this, db.getWatchImageResourceIds(bundle_id));
        viewPager.setAdapter(adapter);
    }

    /**
     * Get data from bundle and setup variables
     *
     * @param bundle intent bundle
     */
    private void initBundleVariable(Bundle bundle) {
        bundle_id = bundle.getInt("watchId");
        bundle_name = bundle.getString(WatchConstants.BUNDLE_NAME);
        bundle_price = bundle.getString("price");
        bundle_description = bundle.getString("description");
    }

    /**
     * Setup activity animations
     */
    private void setAnimations(){
        Animation slide_up = AnimationUtils.loadAnimation(this,
                R.anim.slide_up);
        Animation slide_up_1 = AnimationUtils.loadAnimation(this,
                R.anim.slide_up);
        Animation slide_up_2 = AnimationUtils.loadAnimation(this,
                R.anim.slide_up);

        slide_up.setDuration(700);
        slide_up_1.setDuration(800);
        slide_up_2.setDuration(900);

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
