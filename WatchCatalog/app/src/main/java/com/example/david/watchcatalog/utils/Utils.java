package com.example.david.watchcatalog.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.michaelevans.colorart.library.ColorArt;

/**
 * The class {@code Utils} is used to hold app common helper method
 * <p/>
 * Created by ronan on 2/14/2016.
 */
public class Utils {

    /**
     * Get Detail color from watch image
     *
     * @param context    context
     * @param resourceId image to get color from
     * @return integer value of Detail color from watch image
     */
    public static int getDetailToolbarColorFromImage(Context context, int resourceId) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId);
        ColorArt colorArt = new ColorArt(bitmap);
        return colorArt.getDetailColor();
    }
}
