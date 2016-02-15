package com.example.david.watchcatalog.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.michaelevans.colorart.library.ColorArt;

/**
 * The class {@code UIUtils} is used to hold app common helper methods
 * <p/>
 * Created by ronan on 2/14/2016.
 */
public class UIUtils {

    /**
     * Get Detail color from an image
     *
     * @param context    context
     * @param resourceId image id to get color from
     * @return integer value of Detail color from an image
     */
    public static int getDetailColorFromImage(Context context, int resourceId) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId);
        ColorArt colorArt = new ColorArt(bitmap);
        return colorArt.getDetailColor();
    }
}
