package com.example.david.watchcatalog.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.david.watchcatalog.models.WatchModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 08/02/2016.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Watches";
    private static final String DATABASE_TABLE_WATCHES = "watches";
    private static final int DATA_BASE_VERSION = 1;

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATA_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createWatchesTable = "CREATE TABLE watches (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, price TEXT, description TEXT, imageId INTEGER)";
        db.execSQL(createWatchesTable);
        InitiateWatches.init(db);

        String createWatchTable = "CREATE TABLE watch (id INTEGER PRIMARY KEY AUTOINCREMENT, watchId INTEGER, imageId INTEGER)";
        db.execSQL(createWatchTable);
        InitiateWatches.initWatchImages(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * @return List<{@code WatchModel}>
     */
    public List<WatchModel> getAllWatches() {

        List<WatchModel> watches = new ArrayList<>();

        String query = "SELECT * FROM " + DATABASE_TABLE_WATCHES + "";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        WatchModel watch;

        if (cursor.moveToFirst()) {
            do {
                watch = new WatchModel(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), Integer.parseInt(cursor.getString(4)));
                watches.add(watch);
            } while (cursor.moveToNext());
        }
        cursor.close();

        Log.i("[sql]Watches size: " + watches.size(), ".....");
        return watches;
    }

    /**
     * Get a list of watch image resource ids for a specific watch
     *
     * @param id watch id
     * @return List<String> image resource ids
     */
    public List<String> getWatchImageResourceIds(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        List<String> watches = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT imageId from watch WHERE watchId = " + id, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    watches.add(cursor.getString(0));
                } while (cursor.moveToNext());
            }
        }
        return watches;
    }
}