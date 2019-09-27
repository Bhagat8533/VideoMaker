package com.introvd.template.sdk;

import android.content.Context;
import com.introvd.template.sdk.p383c.C8398b;
import com.introvd.template.sdk.utils.C8553i;

/* renamed from: com.introvd.template.sdk.e */
public class C8410e {
    private static volatile C8410e ebI;
    private C8379a ebJ;
    private boolean ebK;
    private boolean ebL = false;
    private int ebM = 0;
    private int ebN = 0;
    private int ebO = 0;
    private C8382b ebP;
    private Context mContext;

    private C8410e() {
    }

    public static C8410e aGX() {
        if (ebI == null) {
            ebI = new C8410e();
        }
        return ebI;
    }

    /* renamed from: gK */
    public static boolean m24270gK(Context context) {
        C8553i.setContext(context.getApplicationContext());
        return C8553i.m25005ut(55);
    }

    /* renamed from: a */
    public C8410e mo34094a(Context context, C8396c cVar, C8379a aVar, C8382b bVar) {
        this.mContext = context;
        this.ebJ = aVar;
        this.ebP = bVar;
        C8401d.ebG = cVar;
        C8398b.ecV = this.mContext.getResources().getDisplayMetrics().density;
        C8398b.mLocale = context.getResources().getConfiguration().locale;
        return this;
    }

    public int aGU() {
        return this.ebM;
    }

    public int aGV() {
        return this.ebN;
    }

    public int aGW() {
        return this.ebO;
    }

    public boolean aGY() {
        return this.ebL;
    }

    public C8379a aGZ() {
        if (this.ebJ != null) {
            return this.ebJ;
        }
        throw new NullPointerException("IEditPrefenceListener is null, Please initialize first");
    }

    public C8382b aHa() {
        return this.ebP;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean isCommunitySupport() {
        return this.ebK;
    }

    /* renamed from: ja */
    public C8410e mo34103ja(boolean z) {
        this.ebK = z;
        return this;
    }

    /* renamed from: jb */
    public C8410e mo34104jb(boolean z) {
        this.ebL = z;
        return this;
    }

    /* renamed from: tw */
    public C8410e mo34105tw(int i) {
        this.ebO = i;
        return this;
    }

    /* renamed from: tx */
    public C8410e mo34106tx(int i) {
        this.ebN = i;
        return this;
    }

    /* renamed from: ty */
    public C8410e mo34107ty(int i) {
        this.ebM = i;
        return this;
    }
}
