package com.introvd.template.datacenter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

abstract class SqliteOpenHelperWithDaemon extends SQLiteOpenHelper implements CursorDaemon {
    protected final String CONST_CREATE_TABEL_SQL_PRE = "CREATE TABLE IF NOT EXISTS ";
    protected Context mContext;
    List<WeakReference<SocialCursor>> mDaemonCursor = new ArrayList();

    public SqliteOpenHelperWithDaemon(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.mContext = context.getApplicationContext();
    }

    /* access modifiers changed from: protected */
    public boolean ExecSQL(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public synchronized void add(WeakReference<SocialCursor> weakReference) {
        if (weakReference != null) {
            this.mDaemonCursor.add(weakReference);
        }
    }

    public void close() {
        try {
            if (!this.mDaemonCursor.isEmpty()) {
                ArrayList<WeakReference> arrayList = new ArrayList<>(this.mDaemonCursor);
                arrayList.size();
                for (WeakReference weakReference : arrayList) {
                    if (weakReference != null) {
                        try {
                            remove(weakReference);
                            SocialCursor socialCursor = (SocialCursor) weakReference.get();
                            if (socialCursor != null) {
                                socialCursor.forceClose(true);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
                this.mDaemonCursor.clear();
                super.close();
            }
        } finally {
            super.close();
        }
    }

    public synchronized void remove(WeakReference<SocialCursor> weakReference) {
        if (weakReference != null) {
            this.mDaemonCursor.remove(weakReference);
        }
    }
}
