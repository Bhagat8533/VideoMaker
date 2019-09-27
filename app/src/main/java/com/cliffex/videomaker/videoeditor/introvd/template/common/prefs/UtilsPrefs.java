package com.introvd.template.common.prefs;

import android.content.Context;
import android.content.SharedPreferences;

public class UtilsPrefs {
    private static UtilsPrefs cfh;
    private static SharedPreferences sharedPreferences;

    private UtilsPrefs(Context context, String str) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(str, 0);
    }

    public static UtilsPrefs with(Context context, String str, boolean z) {
        if (z) {
            cfh = new UtilsPrefs(context, str);
        }
        return cfh;
    }

    public String read(String str) {
        return sharedPreferences.getString(str, "");
    }

    public String read(String str, String str2) {
        return sharedPreferences.getString(str, str2);
    }

    public boolean readBoolean(String str, boolean z) {
        return sharedPreferences.getBoolean(str, z);
    }

    public int readInt(String str, int i) {
        return sharedPreferences.getInt(str, i);
    }

    public long readLong(String str, long j) {
        return sharedPreferences.getLong(str, j);
    }

    public void write(String str, String str2) {
        sharedPreferences.edit().putString(str, str2).apply();
    }

    public void writeBoolean(String str, boolean z) {
        sharedPreferences.edit().putBoolean(str, z).apply();
    }

    public void writeInt(String str, int i) {
        sharedPreferences.edit().putInt(str, i).apply();
    }

    public void writeLong(String str, long j) {
        sharedPreferences.edit().putLong(str, j).apply();
    }
}
