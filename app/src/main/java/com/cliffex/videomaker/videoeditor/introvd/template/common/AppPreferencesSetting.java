package com.introvd.template.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;

@Deprecated
public class AppPreferencesSetting {
    private static AppPreferencesSetting ccc;
    private SharedPreferences aKC;
    private Editor aNI;
    private boolean ccd = false;

    private AppPreferencesSetting() {
    }

    /* renamed from: dZ */
    private void m14216dZ(Context context) {
        if (this.aKC == null) {
            this.aKC = PreferenceManager.getDefaultSharedPreferences(context);
            if (this.aKC != null) {
                this.aNI = this.aKC.edit();
                this.ccd = true;
            }
        }
    }

    public static synchronized AppPreferencesSetting getInstance() {
        AppPreferencesSetting appPreferencesSetting;
        synchronized (AppPreferencesSetting.class) {
            if (ccc == null) {
                ccc = new AppPreferencesSetting();
            }
            appPreferencesSetting = ccc;
        }
        return appPreferencesSetting;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean getAppSettingBoolean(java.lang.String r2, boolean r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            android.content.SharedPreferences r0 = r1.aKC     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0010
            if (r2 != 0) goto L_0x0008
            goto L_0x0010
        L_0x0008:
            android.content.SharedPreferences r0 = r1.aKC     // Catch:{ all -> 0x0012 }
            boolean r2 = r0.getBoolean(r2, r3)     // Catch:{ all -> 0x0012 }
            monitor-exit(r1)
            return r2
        L_0x0010:
            monitor-exit(r1)
            return r3
        L_0x0012:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.AppPreferencesSetting.getAppSettingBoolean(java.lang.String, boolean):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int getAppSettingInt(java.lang.String r2, int r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            android.content.SharedPreferences r0 = r1.aKC     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0010
            if (r2 != 0) goto L_0x0008
            goto L_0x0010
        L_0x0008:
            android.content.SharedPreferences r0 = r1.aKC     // Catch:{ all -> 0x0012 }
            int r2 = r0.getInt(r2, r3)     // Catch:{ all -> 0x0012 }
            monitor-exit(r1)
            return r2
        L_0x0010:
            monitor-exit(r1)
            return r3
        L_0x0012:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.AppPreferencesSetting.getAppSettingInt(java.lang.String, int):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized long getAppSettingLong(java.lang.String r2, long r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            android.content.SharedPreferences r0 = r1.aKC     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0010
            if (r2 != 0) goto L_0x0008
            goto L_0x0010
        L_0x0008:
            android.content.SharedPreferences r0 = r1.aKC     // Catch:{ all -> 0x0012 }
            long r2 = r0.getLong(r2, r3)     // Catch:{ all -> 0x0012 }
            monitor-exit(r1)
            return r2
        L_0x0010:
            monitor-exit(r1)
            return r3
        L_0x0012:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.AppPreferencesSetting.getAppSettingLong(java.lang.String, long):long");
    }

    public synchronized String getAppSettingStr(String str, String str2) {
        if (this.aKC == null) {
            return str2;
        }
        return this.aKC.getString(str, str2);
    }

    public synchronized boolean init(Context context) {
        m14216dZ(context);
        return true;
    }

    public synchronized Boolean isContainsKey(String str) {
        if (this.aKC != null) {
            if (!TextUtils.isEmpty(str)) {
                return Boolean.valueOf(this.aKC.contains(str));
            }
        }
        return Boolean.valueOf(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void removeAppKey(java.lang.String r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            android.content.SharedPreferences r0 = r1.aKC     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0016
            android.content.SharedPreferences$Editor r0 = r1.aNI     // Catch:{ all -> 0x0018 }
            if (r0 != 0) goto L_0x000a
            goto L_0x0016
        L_0x000a:
            android.content.SharedPreferences$Editor r0 = r1.aNI     // Catch:{ all -> 0x0018 }
            r0.remove(r2)     // Catch:{ all -> 0x0018 }
            android.content.SharedPreferences$Editor r2 = r1.aNI     // Catch:{ all -> 0x0018 }
            r2.commit()     // Catch:{ all -> 0x0018 }
            monitor-exit(r1)
            return
        L_0x0016:
            monitor-exit(r1)
            return
        L_0x0018:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.AppPreferencesSetting.removeAppKey(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setAppSettingBoolean(java.lang.String r3, boolean r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            android.content.SharedPreferences r0 = r2.aKC     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x0030
            if (r3 != 0) goto L_0x0008
            goto L_0x0030
        L_0x0008:
            android.content.SharedPreferences$Editor r0 = r2.aNI     // Catch:{ all -> 0x0032 }
            r0.putBoolean(r3, r4)     // Catch:{ all -> 0x0032 }
            android.content.SharedPreferences$Editor r0 = r2.aNI     // Catch:{ all -> 0x0032 }
            r0.commit()     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0032 }
            r0.<init>()     // Catch:{ all -> 0x0032 }
            java.lang.String r1 = "setAppSettingBoolean key="
            r0.append(r1)     // Catch:{ all -> 0x0032 }
            r0.append(r3)     // Catch:{ all -> 0x0032 }
            java.lang.String r3 = " value="
            r0.append(r3)     // Catch:{ all -> 0x0032 }
            r0.append(r4)     // Catch:{ all -> 0x0032 }
            java.lang.String r3 = r0.toString()     // Catch:{ all -> 0x0032 }
            com.introvd.template.common.LogUtilsV2.m14227d(r3)     // Catch:{ all -> 0x0032 }
            monitor-exit(r2)
            return
        L_0x0030:
            monitor-exit(r2)
            return
        L_0x0032:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.AppPreferencesSetting.setAppSettingBoolean(java.lang.String, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setAppSettingInt(java.lang.String r2, int r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            android.content.SharedPreferences r0 = r1.aKC     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0016
            if (r2 != 0) goto L_0x0008
            goto L_0x0016
        L_0x0008:
            android.content.SharedPreferences r0 = r1.aKC     // Catch:{ all -> 0x0018 }
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ all -> 0x0018 }
            r0.putInt(r2, r3)     // Catch:{ all -> 0x0018 }
            r0.commit()     // Catch:{ all -> 0x0018 }
            monitor-exit(r1)
            return
        L_0x0016:
            monitor-exit(r1)
            return
        L_0x0018:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.AppPreferencesSetting.setAppSettingInt(java.lang.String, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setAppSettingLong(java.lang.String r3, long r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            android.content.SharedPreferences r0 = r2.aKC     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x0030
            if (r3 != 0) goto L_0x0008
            goto L_0x0030
        L_0x0008:
            android.content.SharedPreferences$Editor r0 = r2.aNI     // Catch:{ all -> 0x0032 }
            r0.putLong(r3, r4)     // Catch:{ all -> 0x0032 }
            android.content.SharedPreferences$Editor r0 = r2.aNI     // Catch:{ all -> 0x0032 }
            r0.commit()     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0032 }
            r0.<init>()     // Catch:{ all -> 0x0032 }
            java.lang.String r1 = "setAppSettingBoolean key="
            r0.append(r1)     // Catch:{ all -> 0x0032 }
            r0.append(r3)     // Catch:{ all -> 0x0032 }
            java.lang.String r3 = " value="
            r0.append(r3)     // Catch:{ all -> 0x0032 }
            r0.append(r4)     // Catch:{ all -> 0x0032 }
            java.lang.String r3 = r0.toString()     // Catch:{ all -> 0x0032 }
            com.introvd.template.common.LogUtilsV2.m14227d(r3)     // Catch:{ all -> 0x0032 }
            monitor-exit(r2)
            return
        L_0x0030:
            monitor-exit(r2)
            return
        L_0x0032:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.AppPreferencesSetting.setAppSettingLong(java.lang.String, long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setAppSettingStr(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            android.content.SharedPreferences r0 = r1.aKC     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x001d
            if (r2 != 0) goto L_0x0008
            goto L_0x001d
        L_0x0008:
            if (r3 != 0) goto L_0x000f
            r1.removeAppKey(r2)     // Catch:{ all -> 0x001f }
            monitor-exit(r1)
            return
        L_0x000f:
            android.content.SharedPreferences r0 = r1.aKC     // Catch:{ all -> 0x001f }
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ all -> 0x001f }
            r0.putString(r2, r3)     // Catch:{ all -> 0x001f }
            r0.commit()     // Catch:{ all -> 0x001f }
            monitor-exit(r1)
            return
        L_0x001d:
            monitor-exit(r1)
            return
        L_0x001f:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.AppPreferencesSetting.setAppSettingStr(java.lang.String, java.lang.String):void");
    }
}
