package com.introvd.template.datacenter.social;

import android.database.sqlite.SQLiteDatabase;

public abstract class AbsTable {
    protected static final String CONST_CREATE_TABEL_SQL_PRE = "CREATE TABLE IF NOT EXISTS ";

    protected static boolean ExecSQL(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
