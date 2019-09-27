package com.introvd.template.sdk.p381b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.preference.PreferenceManager;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.introvd.template.sdk.b.d */
public class C8394d implements SharedPreferences, OnSharedPreferenceChangeListener {
    private static WeakHashMap<Context, C8394d> ecb = new WeakHashMap<>();
    /* access modifiers changed from: private */
    public SharedPreferences ebY;
    /* access modifiers changed from: private */
    public SharedPreferences ebZ;
    private CopyOnWriteArrayList<OnSharedPreferenceChangeListener> eca;

    /* renamed from: com.introvd.template.sdk.b.d$a */
    private class C8395a implements Editor {
        private Editor ecc;
        private Editor ecd;

        C8395a() {
            this.ecc = C8394d.this.ebY.edit();
            this.ecd = C8394d.this.ebZ.edit();
        }

        /* renamed from: I */
        public C8395a putInt(String str, int i) {
            if (C8394d.m24217nu(str)) {
                this.ecc.putInt(str, i);
            } else {
                this.ecd.putInt(str, i);
            }
            return this;
        }

        /* renamed from: aHo */
        public C8395a clear() {
            this.ecc.clear();
            this.ecd.clear();
            return this;
        }

        /* renamed from: aR */
        public C8395a putString(String str, String str2) {
            if (C8394d.m24217nu(str)) {
                this.ecc.putString(str, str2);
            } else {
                this.ecd.putString(str, str2);
            }
            return this;
        }

        public void apply() {
            this.ecc.apply();
            this.ecd.apply();
        }

        /* renamed from: c */
        public C8395a putFloat(String str, float f) {
            if (C8394d.m24217nu(str)) {
                this.ecc.putFloat(str, f);
            } else {
                this.ecd.putFloat(str, f);
            }
            return this;
        }

        public boolean commit() {
            return this.ecc.commit() && this.ecd.commit();
        }

        /* renamed from: j */
        public C8395a putLong(String str, long j) {
            if (C8394d.m24217nu(str)) {
                this.ecc.putLong(str, j);
            } else {
                this.ecd.putLong(str, j);
            }
            return this;
        }

        /* renamed from: nw */
        public C8395a remove(String str) {
            this.ecc.remove(str);
            this.ecd.remove(str);
            return this;
        }

        public Editor putStringSet(String str, Set<String> set) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: w */
        public C8395a putBoolean(String str, boolean z) {
            if (C8394d.m24217nu(str)) {
                this.ecc.putBoolean(str, z);
            } else {
                this.ecd.putBoolean(str, z);
            }
            return this;
        }
    }

    public C8394d(Context context, int i) {
        this.ebY = PreferenceManager.getDefaultSharedPreferences(context);
        this.ebY.registerOnSharedPreferenceChangeListener(this);
        synchronized (ecb) {
            ecb.put(context, this);
        }
        this.eca = new CopyOnWriteArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append("_preferences_");
        sb.append(i);
        this.ebZ = context.getSharedPreferences(sb.toString(), 0);
        this.ebZ.registerOnSharedPreferenceChangeListener(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: nu */
    public static boolean m24217nu(String str) {
        return str.equals("pref_camera_id_key") || str.equals("pref_camera_recordlocation_key") || str.equals("pref_guideline_key") || str.equals("pref_timer_key");
    }

    public SharedPreferences aHm() {
        return this.ebY;
    }

    public SharedPreferences aHn() {
        return this.ebZ;
    }

    public boolean contains(String str) {
        if (this.ebZ.contains(str)) {
            return true;
        }
        return this.ebY.contains(str);
    }

    public Editor edit() {
        return new C8395a();
    }

    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException();
    }

    public boolean getBoolean(String str, boolean z) {
        return (m24217nu(str) || !this.ebZ.contains(str)) ? this.ebY.getBoolean(str, z) : this.ebZ.getBoolean(str, z);
    }

    public float getFloat(String str, float f) {
        return (m24217nu(str) || !this.ebZ.contains(str)) ? this.ebY.getFloat(str, f) : this.ebZ.getFloat(str, f);
    }

    public int getInt(String str, int i) {
        return (m24217nu(str) || !this.ebZ.contains(str)) ? this.ebY.getInt(str, i) : this.ebZ.getInt(str, i);
    }

    public long getLong(String str, long j) {
        return (m24217nu(str) || !this.ebZ.contains(str)) ? this.ebY.getLong(str, j) : this.ebZ.getLong(str, j);
    }

    public String getString(String str, String str2) {
        return (m24217nu(str) || !this.ebZ.contains(str)) ? this.ebY.getString(str, str2) : this.ebZ.getString(str, str2);
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        throw new UnsupportedOperationException();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        Iterator it = this.eca.iterator();
        while (it.hasNext()) {
            ((OnSharedPreferenceChangeListener) it.next()).onSharedPreferenceChanged(this, str);
        }
    }

    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.eca.add(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.eca.remove(onSharedPreferenceChangeListener);
    }
}
