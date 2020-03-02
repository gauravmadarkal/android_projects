package com.gauravm.weather.database;

import android.content.Context;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
public class database extends SQLiteAssetHelper {
    private static final String DATABASE_NAMES = "sqlitedata";
    private static final int DATABASE_VERSION = 3;
    public database(Context context) {
        super(context, DATABASE_NAMES, null, DATABASE_VERSION);
    }
}
