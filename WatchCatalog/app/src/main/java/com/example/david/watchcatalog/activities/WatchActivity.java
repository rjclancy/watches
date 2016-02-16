package com.example.david.watchcatalog.activities;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.david.watchcatalog.R;
import com.example.david.watchcatalog.adapters.WatchActivityFragmentAdapter;
import com.example.david.watchcatalog.adapters.WatchActivityPagerAdapter;
import com.example.david.watchcatalog.constants.WatchConstants;
import com.example.david.watchcatalog.db.SQLiteHelper;
import com.example.david.watchcatalog.listeners.TabLayoutListener;
import com.example.david.watchcatalog.models.WatchModel;
import com.example.david.watchcatalog.utils.UIUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * The class {@code WatchActivity} is used for WatchUI purposes
 *
 * @author david
 */
public class WatchActivity extends AppCompatActivity {

    @Bind(R.id.viewPager) ViewPager viewPager;
    @Bind(R.id.tab_layout)  TabLayout tabLayout;
    @Bind(R.id.watchInfoPager) ViewPager tabViewPager;

    private int bundle_id;
    private List<String> imageResourceIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);
        ButterKnife.bind(this);

        // Initiate bundle data
        initBundleVariable(getIntent().getExtras());

        // Link sql instance
        SQLiteHelper db = new SQLiteHelper(this);
        WatchModel watch = db.getWatch(bundle_id);
        imageResourceIds = db.getWatchImageResourceIds(bundle_id);

        // Initialize Toolbar attrs
        initToolbar(watch.getName());

        setupTabs();
        initPagerAdapter();
    }

    private void initPagerAdapter() {
        WatchActivityPagerAdapter adapter = new WatchActivityPagerAdapter(this, imageResourceIds);
        viewPager.setAdapter(adapter);
    }

    private void initBundleVariable(Bundle bundle) {
        bundle_id = bundle.getInt(WatchConstants.BUNDLE_WATCH_ID);
    }

    private void initToolbar(String title) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(UIUtils.getDetailColorFromImage(this, Integer.valueOf(imageResourceIds.get(0)))));
        }
    }

    private void setupTabs() {
        tabLayout.addTab(tabLayout.newTab().setText("Info"));
        tabLayout.addTab(tabLayout.newTab().setText("Comments"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final WatchActivityFragmentAdapter adapter = new WatchActivityFragmentAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        tabViewPager.setAdapter(adapter);
        tabViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setSelectedTabIndicatorColor(UIUtils.getDetailColorFromImage(this, Integer.valueOf(imageResourceIds.get(0))));
        tabLayout.setOnTabSelectedListener(new TabLayoutListener(tabViewPager));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
