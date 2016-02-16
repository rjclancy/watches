package com.example.david.watchcatalog.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.example.david.watchcatalog.R;
import com.example.david.watchcatalog.constants.WatchConstants;
import com.example.david.watchcatalog.utils.AnimationUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * This Activity will show for 1 second when app is launched
 * <p/>
 * Created by David on 05/02/2016.
 */

public class SplashScreenActivity extends Activity {

    @Bind(R.id.splashScreenImage) ImageView splashImage;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.splash_screen);
        ButterKnife.bind(this);

        setAnimations();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashScreenActivity.this, WatchGalleryActivity.class);
                SplashScreenActivity.this.startActivity(mainIntent);
                SplashScreenActivity.this.finish();
            }
        }, WatchConstants.SPLASH_DISPLAY_LENGTH);
    }

    private void setAnimations() {
        splashImage.setAnimation(AnimationUtils.get_fade_in(this, 1000, 0));
    }
}

