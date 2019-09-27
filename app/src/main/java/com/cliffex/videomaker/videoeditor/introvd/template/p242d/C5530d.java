package com.introvd.template.p242d;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.util.List;

/* renamed from: com.introvd.template.d.d */
public class C5530d {
    public int cnU = 0;
    public int cnV = 0;
    public int cnW = 201;
    public int cnX = 0;
    public int cnY = 1;
    public int cnZ = 0;
    public int coa = 0;
    public int cob = 0;
    public Object coc = null;
    public List<Uri> cod;
    public Uri coe = null;
    public boolean cof = false;
    private int cog = 32767;
    private int coh = 32767;
    private boolean coi = true;
    private int coj = 0;
    private boolean cok = false;

    /* renamed from: aj */
    public static int m14976aj(Activity activity) {
        int i;
        Intent intent = activity.getIntent();
        int i2 = 0;
        if (intent == null) {
            return 0;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            i2 = extras.getInt("entry");
        }
        if (i2 == 0) {
            try {
                i = activity.getPackageManager().getActivityInfo(activity.getComponentName(), 128).metaData.getInt("entry");
            } catch (Exception unused) {
            }
            return i;
        }
        i = i2;
        return i;
    }

    /* renamed from: kn */
    public static boolean m14977kn(int i) {
        return i == 0 || i == 1;
    }

    public boolean aaO() {
        return this.cok;
    }

    /* renamed from: dI */
    public void mo27243dI(boolean z) {
        this.cok = z;
    }
}
