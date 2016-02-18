package com.example.david.watchcatalog.activities;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
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
import com.example.david.watchcatalog.utils.AnimationUtils;
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
    @Bind(R.id.tab_layout) TabLayout tabLayout;
    @Bind(R.id.watchInfoPager) ViewPager tabViewPager;
    @Bind(R.id.collapsing_toolbar) CollapsingToolbarLayout collapsingToolbarLayout;

    private int bundle_id;
    private List<String> imageResourceIds;
    private int imageDetailColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);
        ButterKnife.bind(this);

        // Initiate bundle data
        initBundleVariables(getIntent().getExtras());

        // Link sql instance
        SQLiteHelper db = new SQLiteHelper(this);
        WatchModel watch = db.getWatch(bundle_id);
        imageResourceIds = db.getWatchImageResourceIds(bundle_id);
        imageDetailColor = UIUtils.getDetailColorFromImage(this, Integer.valueOf(imageResourceIds.get(0)));

        // Initialize Toolbar attrs
        initToolbar(watch.getName());
        setCollapsingToolbarTheme();

        initWatchFragmentTabs();
        initPagerAdapter();
    }

    private void initPagerAdapter() {
        WatchActivityPagerAdapter adapter = new WatchActivityPagerAdapter(this, imageResourceIds);
        viewPager.setAdapter(adapter);
        viewPager.setAnimation(AnimationUtils.get_slide_down(this, 500, 500));
    }

    private void initBundleVariables(Bundle bundle) {
        bundle_id = bundle.getInt(WatchConstants.BUNDLE_WATCH_ID);
    }

    private void initToolbar(String title) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(imageDetailColor));
        }
    }

    private void initWatchFragmentTabs() {
        tabLayout.addTab(tabLayout.newTab().setText(WatchConstants.WATCH_TAB_INFO));
        tabLayout.addTab(tabLayout.newTab().setText(WatchConstants.WATCH_TAB_COMMENTS));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final WatchActivityFragmentAdapter adapter = new WatchActivityFragmentAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        tabViewPager.setAdapter(adapter);
        tabViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setSelectedTabIndicatorColor(imageDetailColor);
        tabLayout.setOnTabSelectedListener(new TabLayoutListener(tabViewPager));
    }

    private void setCollapsingToolbarTheme(){
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);
        collapsingToolbarLayout.setContentScrimColor(imageDetailColor);
        collapsingToolbarLayout.setBackgroundColor(imageDetailColor);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
