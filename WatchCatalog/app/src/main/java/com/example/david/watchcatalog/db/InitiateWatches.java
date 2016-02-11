package com.example.david.watchcatalog.db;

import android.database.sqlite.SQLiteDatabase;

import com.example.david.watchcatalog.R;

/**
 *
 * Created by David on 08/02/2016.
 */
public class InitiateWatches {

    private static final String DATABASE_TABLE_WATCHES = "watches";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PRICE = "price";
    private static final String KEY_DESCRIPTION = "description";

    private static final String DATABASE_TABLE_WATCH = "watch";
    private static final String WATCH_ID = "watchId";
    private static final String KEY_IMAGE_ID = "imageId";

    public static void init(SQLiteDatabase db){
        db.execSQL("insert into " + DATABASE_TABLE_WATCHES + "(" + KEY_ID + ","
                + KEY_NAME + ", "
                + KEY_PRICE + ","
                + KEY_DESCRIPTION + ", "
                + KEY_IMAGE_ID + ") "
                + "values(1,'Sturhling Original Black', '34', 'Please note personalized items are considered final sale. No returns or exchanges. We need a little more time to create your amazing, personalized piece. Please allow an additional 5-7 business days processing time for engraving and embossing orders. After processing is complete, your order will be shipped according to the selected shipping method.', " + R.drawable.watch1_base +  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCHES + "(" + KEY_ID + ","
                + KEY_NAME + ", "
                + KEY_PRICE + ","
                + KEY_DESCRIPTION + ", "
                + KEY_IMAGE_ID + ") "
                + "values(2,'Sturhling Original Black', '34', 'Please note personalized items are considered final sale. No returns or exchanges. We need a little more time to create your amazing, personalized piece. Please allow an additional 5-7 business days processing time for engraving and embossing orders. After processing is complete, your order will be shipped according to the selected shipping method.', " + R.drawable.watch2_base +  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCHES + "(" + KEY_ID + ","
                + KEY_NAME + ", "
                + KEY_PRICE + ","
                + KEY_DESCRIPTION + ", "
                + KEY_IMAGE_ID + ") "
                + "values(3,'Sturhling Original Black', '34', 'Please note personalized items are considered final sale. No returns or exchanges. We need a little more time to create your amazing, personalized piece. Please allow an additional 5-7 business days processing time for engraving and embossing orders. After processing is complete, your order will be shipped according to the selected shipping method.', " + R.drawable.watch3_base +  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCHES + "(" + KEY_ID + ","
                + KEY_NAME + ", "
                + KEY_PRICE + ","
                + KEY_DESCRIPTION + ", "
                + KEY_IMAGE_ID + ") "
                + "values(4,'Sturhling Original Silver', '34', 'Please note personalized items are considered final sale. No returns or exchanges. We need a little more time to create your amazing, personalized piece. Please allow an additional 5-7 business days processing time for engraving and embossing orders. After processing is complete, your order will be shipped according to the selected shipping method.', " + R.drawable.watch4_base +  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCHES + "(" + KEY_ID + ","
                + KEY_NAME + ", "
                + KEY_PRICE + ","
                + KEY_DESCRIPTION + ", "
                + KEY_IMAGE_ID + ") "
                + "values(5,'Sturhling Original Silver', '34', 'the watch', " + R.drawable.watch5_base +  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCHES + "(" + KEY_ID + ","
                + KEY_NAME + ", "
                + KEY_PRICE + ","
                + KEY_DESCRIPTION + ", "
                + KEY_IMAGE_ID + ") "
                + "values(6,'Sturhling Original Silver', '34', 'the watch', " + R.drawable.watch6_base +  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCHES + "(" + KEY_ID + ","
                + KEY_NAME + ", "
                + KEY_PRICE + ","
                + KEY_DESCRIPTION + ", "
                + KEY_IMAGE_ID + ") "
                + "values(7,'Sturhling Original Silver', '34', 'the watch', " + R.drawable.watch7_base +  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCHES + "(" + KEY_ID + ","
                + KEY_NAME + ", "
                + KEY_PRICE + ","
                + KEY_DESCRIPTION + ", "
                + KEY_IMAGE_ID + ") "
                + "values(8,'Sturhling Original Silver', '34', 'the watch', " + R.drawable.watch8_base +  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCHES + "(" + KEY_ID + ","
                + KEY_NAME + ", "
                + KEY_PRICE + ","
                + KEY_DESCRIPTION + ", "
                + KEY_IMAGE_ID + ") "
                + "values(9,'Sturhling Original Silver', '34', 'the watch', " + R.drawable.watch9_base +  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCHES + "(" + KEY_ID + ","
                + KEY_NAME + ", "
                + KEY_PRICE + ","
                + KEY_DESCRIPTION + ", "
                + KEY_IMAGE_ID + ") "
                + "values(10,'Sturhling Original Silver', '34', 'the watch', " + R.drawable.watch10_base +  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCHES + "(" + KEY_ID + ","
                + KEY_NAME + ", "
                + KEY_PRICE + ","
                + KEY_DESCRIPTION + ", "
                + KEY_IMAGE_ID + ") "
                + "values(11,'Sturhling Original Silver', '34', 'the watch', " + R.drawable.watch11_base +  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCHES + "(" + KEY_ID + ","
                + KEY_NAME + ", "
                + KEY_PRICE + ","
                + KEY_DESCRIPTION + ", "
                + KEY_IMAGE_ID + ") "
                + "values(12,'Sturhling Original Silver', '34', 'the watch', " + R.drawable.watch12_base +  ")");
    }

    public static void initWatchImages(SQLiteDatabase db) {
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(1,'1', " + R.drawable.watch1_base+  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(2,'1', " + R.drawable.watch1_large1+  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(3,'1', " + R.drawable.watch1_large2 +  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(4,'2', " + R.drawable.watch2_base+  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(5,'2', " + R.drawable.watch2_large1+  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(6,'2', " + R.drawable.watch2_large2 +  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(7,'3', " + R.drawable.watch3_base+  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(8,'3', " + R.drawable.watch3_large1+  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(9,'3', " + R.drawable.watch3_large2 +  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(10,'4', " + R.drawable.watch4_base+  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(11,'4', " + R.drawable.watch4_large1+  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(12,'4', " + R.drawable.watch4_large2 +  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(13,'5', " + R.drawable.watch5_base+  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(14,'5', " + R.drawable.watch5_large1+  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(15,'5', " + R.drawable.watch5_large2 +  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(16,'6', " + R.drawable.watch6_base+  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(17,'6', " + R.drawable.watch6_large1+  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(18,'6', " + R.drawable.watch6_large2 +  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(19,'7', " + R.drawable.watch7_base+  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(20,'7', " + R.drawable.watch7_large1+  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(21,'7', " + R.drawable.watch7_large2 +  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(22,'8', " + R.drawable.watch8_base+  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(23,'8', " + R.drawable.watch8_large1+  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(24,'8', " + R.drawable.watch8_large2 +  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(25,'9', " + R.drawable.watch9_base+  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(26,'9', " + R.drawable.watch9_large1+  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(27,'9', " + R.drawable.watch9_large2 +  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(28,'10', " + R.drawable.watch10_base+  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(29,'10', " + R.drawable.watch10_large1+  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(30,'10', " + R.drawable.watch10_large2 +  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(31,'11', " + R.drawable.watch11_base+  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(32,'11', " + R.drawable.watch11_large1+  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(33,'11', " + R.drawable.watch11_large2 +  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(34,'12', " + R.drawable.watch12_base+  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(35,'12', " + R.drawable.watch12_large1+  ")");
        db.execSQL("insert into " + DATABASE_TABLE_WATCH + "(" + KEY_ID + ","
                + WATCH_ID + ","
                + KEY_IMAGE_ID + ") "
                + "values(36,'12', " + R.drawable.watch12_large2 +  ")");
    }
}
