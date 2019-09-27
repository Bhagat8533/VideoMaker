package com.introvd.template.datacenter;

import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteCursor;
import android.text.TextUtils;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;

class SocialCursor extends CursorWrapper implements CrossProcessCursor {
    public static boolean ENALBE_TRACE_LOG;
    WeakReference<CursorDaemon> mCursorDaemonRef = null;
    WeakReference<SQLiteCursor> mRawCursorRef = null;
    WeakReference<SocialCursor> mRefThis = null;
    SocialSecurity mSecurity = null;
    String mStrCallStack = null;
    String mStrTableName = null;

    private SocialCursor(Cursor cursor) {
        super(cursor);
        this.mRawCursorRef = new WeakReference<>((SQLiteCursor) cursor);
    }

    public SocialCursor(Cursor cursor, String str, SocialSecurity socialSecurity, CursorDaemon cursorDaemon) {
        super(cursor);
        if (ENALBE_TRACE_LOG) {
            this.mStrCallStack = getCurrentStackTrace();
        }
        this.mRawCursorRef = new WeakReference<>((SQLiteCursor) cursor);
        this.mStrTableName = str;
        this.mSecurity = socialSecurity;
        this.mCursorDaemonRef = new WeakReference<>(cursorDaemon);
        this.mRefThis = new WeakReference<>(this);
        if (cursorDaemon != null) {
            cursorDaemon.add(this.mRefThis);
        }
    }

    private String getCurrentStackTrace() {
        try {
            int i = 100 / 0;
        } catch (Throwable th) {
            String stackTrace = getStackTrace(th);
            if (!TextUtils.isEmpty(stackTrace)) {
                int indexOf = stackTrace.indexOf("\n");
                if (indexOf > 0) {
                    stackTrace = stackTrace.substring(indexOf + 1);
                }
                int indexOf2 = stackTrace.indexOf("\n");
                if (indexOf2 > 0) {
                    stackTrace = stackTrace.substring(indexOf2 + 1);
                }
                return stackTrace;
            }
        }
        return null;
    }

    private String getStackTrace(Throwable th) {
        if (th == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
            printWriter.append("\n");
        }
        String obj = stringWriter.toString();
        printWriter.close();
        return obj;
    }

    public void close() {
        if (this.mCursorDaemonRef != null) {
            CursorDaemon cursorDaemon = (CursorDaemon) this.mCursorDaemonRef.get();
            if (cursorDaemon != null) {
                cursorDaemon.remove(this.mRefThis);
            }
        }
        forceClose(false);
    }

    public void fillWindow(int i, CursorWindow cursorWindow) {
        if (i >= 0) {
            try {
                if (i <= getCount()) {
                    SQLiteCursor sQLiteCursor = (SQLiteCursor) this.mRawCursorRef.get();
                    if (sQLiteCursor != null) {
                        sQLiteCursor.fillWindow(i, cursorWindow);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void forceClose(boolean z) {
        if (!isClosed()) {
            if (z && this.mStrCallStack != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("memory leak:");
                sb.append(this.mStrCallStack);
                Log.e("SocialCursor", sb.toString());
            }
            super.close();
            this.mCursorDaemonRef = null;
            this.mRefThis = null;
        }
    }

    public int getCount() {
        try {
            return super.getCount();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public String getString(int i) {
        String string = super.getString(i);
        if (string == null) {
            return null;
        }
        if (this.mSecurity != null) {
            string = this.mSecurity.onDecrypt(this.mStrTableName, getColumnName(i), string);
        }
        return string;
    }

    public CursorWindow getWindow() {
        SQLiteCursor sQLiteCursor = (SQLiteCursor) this.mRawCursorRef.get();
        if (sQLiteCursor == null) {
            return null;
        }
        return sQLiteCursor.getWindow();
    }

    public boolean onMove(int i, int i2) {
        boolean z;
        SQLiteCursor sQLiteCursor = (SQLiteCursor) this.mRawCursorRef.get();
        if (sQLiteCursor == null) {
            return false;
        }
        try {
            z = sQLiteCursor.onMove(i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
            z = false;
        }
        return z;
    }
}
